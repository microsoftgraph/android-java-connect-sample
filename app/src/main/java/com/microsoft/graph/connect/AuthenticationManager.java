/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.connect;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.lnikkila.oidc.OIDCAccountManager;
import com.lnikkila.oidc.OIDCRequestManager;
import com.lnikkila.oidc.security.UserNotAuthenticatedWrapperException;
import com.microsoft.identity.client.*;

import java.io.IOException;

/**
 * Handles setup of OAuth library in API clients.
 */
public class AuthenticationManager {
    private static final String TAG = "AuthenticationManager";
    private static AuthenticationManager INSTANCE;
    private PublicClientApplication mApplication;
    private AuthenticationResult mAuthResult;


    private OIDCAccountManager mOIDCAccountManager;

    private AuthenticationManager() {
    }

    public static synchronized AuthenticationManager getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new AuthenticationManager();
            INSTANCE.mOIDCAccountManager = new OIDCAccountManager(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences("oidc_clientconf", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("oidc_loadfromprefs", true);

            //Was false. When false, exception is thrown in OIDCRequestManager, line 378. id is null
            editor.putBoolean("oidc_oauth2only", false);
            editor.putString("oidc_clientId", Constants.CLIENT_ID);
            editor.putString("oidc_redirectUrl", Constants.REDIRECT_URI);
//            editor.putString("oidc_scopes", Constants.SCOPES);
            editor.putString("oidc_flowType", OIDCRequestManager.Flows.Code.name());

            editor.apply();

        }
        return INSTANCE;
    }

    public static synchronized void resetInstance() {
        INSTANCE = null;
    }


    public void setAuthentcationResult(AuthenticationResult authentcationResult) {
        mAuthResult = authentcationResult;
    }
     /**
     * Returns the access token obtained in authentication
     *
     * @return mAccessToken
     */
    public String getAccessToken() throws AuthenticatorException, IOException, OperationCanceledException, UserNotAuthenticatedWrapperException {
        return  mAuthResult.getAccessToken(); //mOIDCAccountManager.getAccessToken(mOIDCAccountManager.getAccounts()[0], null);
    }

    public void connect(Activity activity, final com.microsoft.identity.client.AuthenticationCallback authenticationCallback){
        if (mApplication == null) {
            mApplication = new PublicClientApplication(activity.getApplicationContext());
        }

        mApplication.acquireToken(
                activity,
                Constants.SCOPES,
                Constants.LOGIN_HINT,
                com.microsoft.identity.client.UiBehavior.CONSENT,
                null,
                null,
                null,
                authenticationCallback);

    }
    /**
     *
     * @param authenticationCallback The callback to notify when the processing is finished.
     */
    public void connect(Activity activity, final AuthenticationCallback<String> authenticationCallback) {
        switch (mOIDCAccountManager.getAccounts().length) {
            // No account has been created, let's create one now
            case 0:
                mOIDCAccountManager.createAccount(activity, new AccountManagerCallback<Bundle>() {
                    @Override
                    public void run(AccountManagerFuture<Bundle> futureManager) {
                        // Unless the account creation was cancelled, try logging in again
                        // after the account has been created.
                        if (!futureManager.isCancelled()) {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    Account account = mOIDCAccountManager.getAccounts()[0];
                                    try {
                                        authenticationCallback.onSuccess(mOIDCAccountManager.getIdToken(account.name, null));
                                    } catch (AuthenticatorException | UserNotAuthenticatedWrapperException | OperationCanceledException | IOException e) {
                                        authenticationCallback.onError(e);
                                    }
                                }
                            }).start();
                        } else {
                            authenticationCallback.onError(new AuthenticatorException("Flow was canceled"));
                        }
                    }
                });
                break;
            case 1:
                // if we have an user endpoint we try to get userinfo with the receive token
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Account account = mOIDCAccountManager.getAccounts()[0];
                        try {
                            authenticationCallback.onSuccess(mOIDCAccountManager.getIdToken(account.name, null));
                        } catch (AuthenticatorException | UserNotAuthenticatedWrapperException | OperationCanceledException | IOException e) {
                            authenticationCallback.onError(e);
                        }
                    }
                }).start();
                break;
        }
    }

    /**
     * Disconnects the app from Office 365 by clearing the token cache, setting the client objects
     * to null, and removing the user id from shred preferences.
     */
    public void disconnect() {
        mOIDCAccountManager.removeAccount(mOIDCAccountManager.getAccounts()[0]);
        // Reset the AuthenticationManager object
        AuthenticationManager.resetInstance();
    }

    public void callAcquireToken(Activity activity, com.microsoft.identity.client.AuthenticationCallback authenticationCallback) {
        // The sample app is having the PII enable setting on the MainActivity. Ideally, app should decide to enable Pii or not,
        // if it's enabled, it should be  the setting when the application is onCreate.
//        if (mEnablePiiLogging) {
//            Logger.getInstance().setEnablePII(true);
//        } else {
//            Logger.getInstance().setEnablePII(false);
//        }

        mApplication.acquireToken(activity,
                Constants.SCOPES,
                Constants.LOGIN_HINT,
                com.microsoft.identity.client.UiBehavior.CONSENT,
                null,
                null,
                null,
                authenticationCallback);
    }
    public void callAcquireTokenSilent(User user, boolean forceRefresh, com.microsoft.identity.client.AuthenticationCallback authenticationCallback) {
        mApplication.acquireTokenSilentAsync(Constants.SCOPES, user, null, forceRefresh, authenticationCallback);
    }

}
