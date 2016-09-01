/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.connect;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

import com.microsoft.aad.adal.ADALError;
import com.microsoft.aad.adal.AuthenticationCallback;
import com.microsoft.aad.adal.AuthenticationContext;
import com.microsoft.aad.adal.AuthenticationException;
import com.microsoft.aad.adal.AuthenticationResult;
import com.microsoft.aad.adal.AuthenticationResult.AuthenticationStatus;
import com.microsoft.aad.adal.AuthenticationSettings;
import com.microsoft.aad.adal.PromptBehavior;

import net.openid.appauth.AuthorizationRequest;
import net.openid.appauth.AuthorizationService;
import net.openid.appauth.AuthorizationServiceConfiguration;
import net.openid.appauth.RedirectUriReceiverActivity;
import net.openid.appauth.ResponseTypeValues;

import java.io.UnsupportedEncodingException;

/**
 * Handles setup of ADAL Dependency Resolver for use in API clients.
 * Check the {@link AuthenticationManager#connect(AuthenticationCallback)} method to learn how to
 * get Azure AD tokens for your app.
 * You can also check {@link AuthenticationManager#authenticatePrompt(AuthenticationCallback)} to
 * learn how to get tokens by prompting the user for credentials, or
 * {@link AuthenticationManager#authenticateSilent(AuthenticationCallback)} to learn how to get
 * tokens silently.
 * To learn how to dispose the tokens, see {@link AuthenticationManager#disconnect()}.
 */
public class AuthenticationManager {
    AuthorizationServiceConfiguration config;
    AuthorizationRequest authorizationRequest;

    private static final String TAG = "AuthenticationManager";
    private static final String PREFERENCES_FILENAME = "ConnectFile";
    private static final String USER_ID_VAR_NAME = "userId";
    private static AuthenticationManager INSTANCE;

    static {
        // Devices with API level lower than 18 must setup an encryption key.
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2 &&
                AuthenticationSettings.INSTANCE.getSecretKeyData() == null) {
            AuthenticationSettings.INSTANCE.setSecretKey(generateSecretKey());
        }
    }

    private AuthenticationContext mAuthenticationContext;
    private Activity mContextActivity;
    private String mAccessToken;

    private AuthenticationManager() {
        Uri authorityUrl = Uri.parse(Constants.AUTHORITY_URL);
        Uri authorizationEndpoint = Uri.withAppendedPath(authorityUrl, Constants.AUTHORIZATION_ENDPOINT);
        Uri tokenEndpoint = Uri.withAppendedPath(authorityUrl, Constants.TOKEN_ENDPOINT);
        config = new AuthorizationServiceConfiguration(authorizationEndpoint, tokenEndpoint, null);

        authorizationRequest = new AuthorizationRequest.Builder(
                config,
                Constants.CLIENT_ID,
                ResponseTypeValues.CODE,
                Uri.parse(Constants.REDIRECT_URI))
                .build();
    }

    /**
     * Calls {@link AuthenticationManager#authenticatePrompt(AuthenticationCallback)} if no user id is stored in the shared preferences.
     * Calls {@link AuthenticationManager#authenticateSilent(AuthenticationCallback)} otherwise.
     *
     * @param authenticationCallback The callback to notify when the processing is finished.
     */
    public void connect(final AuthenticationCallback<AuthenticationResult> authenticationCallback) {
        AuthorizationService service = new AuthorizationService(mContextActivity);
        Intent postAuthIntent = new Intent(mContextActivity, RedirectUriReceiverActivity.class);
        service.performAuthorizationRequest(
                authorizationRequest,
                PendingIntent.getActivity(mContextActivity, authorizationRequest.hashCode(), postAuthIntent, 0));
    }

    /**
     * Calls acquireTokenSilentAsync with the user id stored in shared preferences.
     * In case of an error, it falls back to {@link AuthenticationManager#authenticatePrompt(AuthenticationCallback)}.
     *
     * @param authenticationCallback The callback to notify when the processing is finished.
     */
    private void authenticateSilent(final AuthenticationCallback<AuthenticationResult> authenticationCallback) {
        getAuthenticationContext().acquireTokenSilentAsync(
                Constants.MICROSOFT_GRAPH_API_ENDPOINT_RESOURCE_ID,
                Constants.CLIENT_ID,
                getUserId(),
                new AuthenticationCallback<AuthenticationResult>() {
                    @Override
                    public void onSuccess(final AuthenticationResult authenticationResult) {
                        if (authenticationResult != null) {
                            if (authenticationResult.getStatus() == AuthenticationStatus.Succeeded) {
                                mAccessToken = authenticationResult.getAccessToken();
                                authenticationCallback.onSuccess(authenticationResult);
                            } else {
                                authenticationCallback.onError(
                                        new Exception(authenticationResult.getErrorDescription()));

                            }
                        } else {
                            // I could not authenticate the user silently,
                            // falling back to prompt the user for credentials.
                            authenticatePrompt(authenticationCallback);
                        }
                    }

                    @Override
                    public void onError(Exception e) {
                        // I could not authenticate the user silently,
                        // falling back to prompt the user for credentials.
                        authenticatePrompt(authenticationCallback);
                    }
                }
        );
    }

    /**
     * Calls acquireToken to prompt the user for credentials.
     *
     * @param authenticationCallback The callback to notify when the processing is finished.
     */
    private void authenticatePrompt(final AuthenticationCallback<AuthenticationResult> authenticationCallback) {
        getAuthenticationContext().acquireToken(
                mContextActivity,
                Constants.MICROSOFT_GRAPH_API_ENDPOINT_RESOURCE_ID,
                Constants.CLIENT_ID,
                Constants.REDIRECT_URI,
                PromptBehavior.Always,
                new AuthenticationCallback<AuthenticationResult>() {
                    @Override
                    public void onSuccess(final AuthenticationResult authenticationResult) {
                        if (authenticationResult != null) {
                            if (authenticationResult.getStatus() == AuthenticationStatus.Succeeded) {
                                setUserId(authenticationResult.getUserInfo().getUserId());
                                mAccessToken = authenticationResult.getAccessToken();
                                authenticationCallback.onSuccess(authenticationResult);
                            } else {
                                // We need to make sure that there is no data stored with the failed auth
                                AuthenticationManager.getInstance().disconnect();
                                // This condition can happen if user signs in with an MSA account
                                // instead of an Office 365 account
                                authenticationCallback.onError(
                                        new AuthenticationException(
                                                ADALError.AUTH_FAILED,
                                                authenticationResult.getErrorDescription()));
                            }
                        } else {
                            // I could not authenticate the user silently,
                            // falling back to prompt the user for credentials.
                            authenticatePrompt(authenticationCallback);
                        }
                    }

                    @Override
                    public void onError(Exception e) {
                        // We need to make sure that there is no data stored with the failed auth
                        AuthenticationManager.getInstance().disconnect();
                        authenticationCallback.onError(e);
                    }
                }
        );
    }

    /**
     * Gets authentication context for Azure Active Directory.
     *
     * @return an authentication context, if successful.
     */
    public AuthenticationContext getAuthenticationContext() {
        if (mAuthenticationContext == null) {
            try {
                mAuthenticationContext =
                        new AuthenticationContext(
                                mContextActivity,
                                Constants.AUTHORITY_URL,
                                false
                        );
            } catch (Throwable t) {
                Log.e(TAG, t.toString());
            }
        }
        return mAuthenticationContext;
    }

    /**
     * Disconnects the app from Office 365 by clearing the token cache, setting the client objects
     * to null, and removing the user id from shred preferences.
     */
    public void disconnect() {
        // Clear tokens.
        if (getAuthenticationContext().getCache() != null) {
            getAuthenticationContext().getCache().removeAll();
        }

        mAccessToken = null;
        // Reset the AuthenticationManager object
        AuthenticationManager.resetInstance();

        // Forget the user
        removeUserId();
    }

    private boolean verifyAuthenticationContext() {
        if (null == mContextActivity) {
            Log.e(TAG, "Must set context activity");
            return false;
        }
        return true;
    }

    private SharedPreferences getSharedPreferences() {
        return mContextActivity.getSharedPreferences(PREFERENCES_FILENAME, Context.MODE_PRIVATE);
    }

    @VisibleForTesting
    boolean isConnected() {
        return getSharedPreferences().contains(USER_ID_VAR_NAME);
    }

    @VisibleForTesting
    String getUserId() {
        return getSharedPreferences().getString(USER_ID_VAR_NAME, "");
    }

    private void setUserId(String value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(USER_ID_VAR_NAME, value);
        editor.apply();
    }

    private void removeUserId() {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.remove(USER_ID_VAR_NAME);
        editor.apply();
    }

    /**
     * Generates an encryption key for devices with API level lower than 18 using the
     * ANDROID_ID value as a seed.
     * In production scenarios, you should come up with your own implementation of this method.
     * Consider that your algorithm must return the same key so it can encrypt/decrypt values
     * successfully.
     *
     * @return The encryption key in a 32 byte long array.
     */
    private static byte[] generateSecretKey() {
        byte[] key = new byte[32];
        byte[] android_id;

        try {
            android_id = Settings.Secure.ANDROID_ID.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "generateSecretKey - " + e.getMessage());
            throw new RuntimeException(e);
        }

        for (int i = 0; i < key.length; i++) {
            key[i] = android_id[i % android_id.length];
        }

        return key;
    }

    public static synchronized AuthenticationManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AuthenticationManager();
        }
        return INSTANCE;
    }

    private static synchronized void resetInstance() {
        INSTANCE = null;
    }

    /**
     * Set the context activity before connecting to the currently active activity.
     *
     * @param contextActivity Currently active activity which can be utilized for interactive
     *                        prompt.
     */
    public void setContextActivity(final Activity contextActivity) {
        mContextActivity = contextActivity;
    }

    /**
     * Returns the access token obtained in authentication
     *
     * @return mAccessToken
     */
    public String getAccessToken() throws TokenNotFoundException {
        if(mAccessToken == null) {
            throw new TokenNotFoundException();
        }
        return mAccessToken;
    }
}
