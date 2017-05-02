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
    private AuthenticationManager() {
    }

    public static synchronized AuthenticationManager getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new AuthenticationManager();

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
        return  mAuthResult.getAccessToken();
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
     * Disconnects the app from Office 365 by clearing the token cache, setting the client objects
     * to null, and removing the user id from shred preferences.
     */
    public void disconnect() {

        mApplication.remove(mAuthResult.getUser());
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
