/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.connect;

import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.Application;
import android.util.Log;

import com.microsoft.graph.authentication.IAuthenticationProvider;
import com.microsoft.graph.authentication.MSALAuthenticationProvider;
import com.microsoft.graph.requests.extensions.GraphServiceClient;
import com.microsoft.graph.models.extensions.IGraphServiceClient;
import com.microsoft.graph.http.IHttpRequest;

import java.io.IOException;

/**
 * Singleton class that manages a GraphServiceClient object.
 * It implements IAuthentication provider to authenticate requests using an access token.
 */
public class GraphServiceClientManager extends Application implements IAuthenticationProvider {
    private IGraphServiceClient mGraphServiceClient;
    private static GraphServiceClientManager INSTANCE;
    private AuthenticationManager mAuthenticationManager;
    private static Activity connectActivity;
    private MSALAuthenticationProvider msalAuthenticationProvider;
    private IGraphServiceClient graphClient;


    public static GraphServiceClientManager getApp() {
        return INSTANCE;
    }
    public static Activity getAppActivity() {return connectActivity;}

    private GraphServiceClientManager() {
        mAuthenticationManager = AuthenticationManager.getInstance();
    }

    /**
     * Appends an access token obtained from the {@link AuthenticationManager} class to the
     * Authorization header of the request.
     * @param request
     */
    @Override
    public void authenticateRequest(IHttpRequest request)  {
        try {
            request.addHeader("Authorization", "Bearer "
                    + AuthenticationManager.getInstance()
                    .getAccessToken());
            // This header has been added to identify this sample in the Microsoft Graph service.
            // If you're using this code for your project please remove the following line.
            request.addHeader("SampleID", "android-java-connect-sample");

            Log.i("Connect","Request: " + request.toString());
        } catch (AuthenticatorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  catch (OperationCanceledException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static synchronized GraphServiceClientManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new GraphServiceClientManager();
        }
        return INSTANCE;
    }

    public synchronized IGraphServiceClient getGraphServiceClient() {
        return getGraphServiceClient(this);
    }

    public synchronized IGraphServiceClient getGraphServiceClient(IAuthenticationProvider authenticationProvider) {
        if (mGraphServiceClient == null) {
            if(msalAuthenticationProvider == null){
                msalAuthenticationProvider = new MSALAuthenticationProvider(
                        getAppActivity(),
                        GraphServiceClientManager.getApp(),
                        mAuthenticationManager.getPublicClient(),
                        Constants.SCOPES);
            }
            if(graphClient == null){
                graphClient =
                        GraphServiceClient
                                .builder()
                                .authenticationProvider(msalAuthenticationProvider)
                                .buildClient();
            }
            return graphClient;
        }
        return mGraphServiceClient;
    }
}
