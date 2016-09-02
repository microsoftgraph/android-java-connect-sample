/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.connect;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.util.Log;

import net.openid.appauth.AuthState;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationRequest;
import net.openid.appauth.AuthorizationResponse;
import net.openid.appauth.AuthorizationService;
import net.openid.appauth.AuthorizationServiceConfiguration;
import net.openid.appauth.ResponseTypeValues;
import net.openid.appauth.TokenRequest;
import net.openid.appauth.TokenResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * Handles setup of OAuth library in API clients.
 */
public class AuthenticationManager {
    AuthorizationServiceConfiguration config;
    AuthorizationRequest authorizationRequest;
    AuthState authState;
    AuthorizationService authorizationService;

    private static final String TAG = "AuthenticationManager";
    private static AuthenticationManager INSTANCE;

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
     * Starts the authorization flow, which continues to net.openid.appauth.RedirectReceiverActivity
     * and then to ConnectActivity
     */
    public void startAuthorizationFlow() {
        authorizationService = new AuthorizationService(mContextActivity);

        Intent intent = new Intent(mContextActivity, ConnectActivity.class);

        PendingIntent redirectIntent = PendingIntent.getActivity(mContextActivity, authorizationRequest.hashCode(), intent, 0);

        authorizationService.performAuthorizationRequest(
                authorizationRequest,
                redirectIntent);
    }

    public void processAuthorizationCode(Intent redirectIntent, final AuthorizationService.TokenResponseCallback callback) {
        AuthorizationResponse authorizationResponse = AuthorizationResponse.fromIntent(redirectIntent);
        AuthorizationException authorizationException = AuthorizationException.fromIntent(redirectIntent);
        authState = new AuthState(authorizationResponse, authorizationException);

        if (authorizationResponse != null) {
            HashMap<String, String> additionalParams = new HashMap<>();
            TokenRequest tokenRequest = authorizationResponse.createTokenExchangeRequest(additionalParams);

            authorizationService.performTokenRequest(
                    tokenRequest,
                    new AuthorizationService.TokenResponseCallback() {
                        @Override
                        public void onTokenRequestCompleted(
                                @Nullable TokenResponse tokenResponse,
                                @Nullable AuthorizationException ex) {
                            authState.update(tokenResponse, ex);
                            if (tokenResponse != null) {
                                mAccessToken = tokenResponse.accessToken;
                            }
                            callback.onTokenRequestCompleted(tokenResponse, ex);
                        }
                    });
        } else {
            Log.i(TAG, "Authorization failed: " + authorizationException);
        }
    }

    public JSONObject getClaims(String idToken) {
        JSONObject retValue = null;
        String payload = idToken.split("[.]")[1];

        try {
            // The token payload is in the 2nd element of the JWT
            String jsonClaims = new String(Base64.decode(payload, Base64.DEFAULT), "UTF-8");
            retValue = new JSONObject(jsonClaims);
        } catch ( JSONException | IOException e) {
            Log.e(TAG, "Couldn't decode id token: " + e.getMessage());
        }
        return retValue;
    }

    /**
     * Disconnects the app from Office 365 by clearing the token cache, setting the client objects
     * to null, and removing the user id from shred preferences.
     */
    public void disconnect() {
        // Reset the AuthenticationManager object
        AuthenticationManager.resetInstance();
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
