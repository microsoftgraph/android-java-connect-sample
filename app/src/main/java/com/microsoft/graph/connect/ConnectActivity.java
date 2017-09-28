/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.connect;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.microsoft.identity.client.AuthenticationResult;
import com.microsoft.identity.client.Logger;
import com.microsoft.identity.client.MsalClientException;
import com.microsoft.identity.client.MsalException;
import com.microsoft.identity.client.MsalServiceException;
import com.microsoft.identity.client.MsalUiRequiredException;
import com.microsoft.identity.client.User;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Starting Activity of the app. Handles the connection to Office 365.
 * When it first starts it only displays a button to Connect to Office 365.
 * If there are no cached tokens, the user is required to sign in to Office 365.
 * If there are cached tokens, the app tries to reuse them.
 * The activity redirects the user to the SendMailActivity upon successful connection.
 */
public class ConnectActivity extends AppCompatActivity implements MSALAuthenticationCallback {

    private static final String TAG = "ConnectActivity";

    private boolean mEnablePiiLogging = false;
    private User mUser;
    private Handler mHandler;

    private Button mConnectButton;
    private TextView mTitleTextView;
    private TextView mDescriptionTextView;
    private ProgressBar mConnectProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


            Bundle extras = getIntent().getExtras();
            setContentView(R.layout.activity_connect);
            setTitle(R.string.app_name);

            // set up our views
            mConnectButton = (Button) findViewById(R.id.connectButton);
            mConnectProgressBar = (ProgressBar) findViewById(R.id.connectProgressBar);
            mTitleTextView = (TextView) findViewById(R.id.titleTextView);
            mDescriptionTextView = (TextView) findViewById(R.id.descriptionTextView);

            Connect.getInstance().setConnectActivity(this);
            // add click listener
            mConnectButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showConnectingInProgressUI();
                    connect();
                }
            });

    }

    private void connect() {

        // The sample app is having the PII enable setting on the MainActivity. Ideally, app should decide to enable Pii or not,
        // if it's enabled, it should be  the setting when the application is onCreate.
        if (mEnablePiiLogging) {
            Logger.getInstance().setEnablePII(true);
        } else {
            Logger.getInstance().setEnablePII(false);
        }

        AuthenticationManager mgr = AuthenticationManager.getInstance();

          /* Attempt to get a user and acquireTokenSilent
   * If this fails we do an interactive request
   */
        List<User> users = null;

        try {
            users = mgr.getPublicClient().getUsers();

            if (users != null && users.size() == 1) {
          /* We have 1 user */
                mUser = users.get(0);
                mgr.callAcquireTokenSilent(
                        mUser,
                        true,
                        this);
            } else {
          /* We have no user */

          /* Let's do an interactive request */
                mgr.callAcquireToken(
                        this,
                        this);
            }
        } catch (MsalClientException e) {
            Log.d(TAG, "MSAL Exception Generated while getting users: " + e.toString());
            showConnectErrorUI(e.getMessage());


        } catch (IndexOutOfBoundsException e) {
            Log.d(TAG, "User at this position does not exist: " + e.toString());
            showConnectErrorUI(e.getMessage());

        }catch (IllegalStateException e) {
                Log.d(TAG, "MSAL Exception Generated: " + e.toString());
                showConnectErrorUI(e.getMessage());

        } catch (Exception e) {
            showConnectErrorUI();
        }
    }

    /**
     * Handles redirect response from https://login.microsoftonline.com/common and
     * notifies the MSAL library that the user has completed the authentication
     * dialog
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (AuthenticationManager
                .getInstance()
                .getPublicClient() != null) {
            AuthenticationManager
                    .getInstance()
                    .getPublicClient()
                    .handleInteractiveRequestRedirect(requestCode, resultCode, data);
        }
    }


    private void resetUIForConnect() {
        mConnectButton.setVisibility(View.VISIBLE);
        mTitleTextView.setVisibility(View.GONE);
        mDescriptionTextView.setVisibility(View.GONE);
        mConnectProgressBar.setVisibility(View.GONE);
    }

    private void showConnectingInProgressUI() {
        mConnectButton.setVisibility(View.GONE);
        mTitleTextView.setVisibility(View.GONE);
        mDescriptionTextView.setVisibility(View.GONE);
        mConnectProgressBar.setVisibility(View.VISIBLE);
    }

    private void showConnectErrorUI() {
        mConnectButton.setVisibility(View.VISIBLE);
        mConnectProgressBar.setVisibility(View.GONE);
        mTitleTextView.setText(R.string.title_text_error);
        mTitleTextView.setVisibility(View.VISIBLE);
        mDescriptionTextView.setText(R.string.connect_text_error);
        mDescriptionTextView.setVisibility(View.VISIBLE);
        Toast.makeText(
                ConnectActivity.this,
                R.string.connect_toast_text_error,
                Toast.LENGTH_LONG).show();
    }
    private void showConnectErrorUI(String errorMessage) {
        mConnectButton.setVisibility(View.VISIBLE);
        mConnectProgressBar.setVisibility(View.GONE);
        mTitleTextView.setText(R.string.title_text_error);
        mTitleTextView.setVisibility(View.VISIBLE);
        mDescriptionTextView.setText(errorMessage);
        mDescriptionTextView.setVisibility(View.VISIBLE);
        Toast.makeText(
                ConnectActivity.this,
                R.string.connect_toast_text_error,
                Toast.LENGTH_LONG).show();
    }

    private void showMessage(final String msg) {
        getHandler().post(new Runnable() {

            @Override
            public void run() {
                Toast.makeText(ConnectActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        });
    }

    private Handler getHandler() {
        if (mHandler == null) {
            return new Handler(ConnectActivity.this.getMainLooper());
        }

        return mHandler;
    }


    @Override
    public void onSuccess(AuthenticationResult authenticationResult) {
        mUser = authenticationResult.getUser();

        String name = "";
        String preferredUsername = "";

        try {
            // get the user info from the id token
            name = authenticationResult.getUser().getName();
            preferredUsername = authenticationResult.getUser().getDisplayableId();

            AuthenticationManager mgr = AuthenticationManager.getInstance();


        } catch (NullPointerException npe) {
            Log.e(TAG, npe.getMessage());

        }

        // Prepare the SendMailActivity intent
        Intent sendMailActivity =
                new Intent(ConnectActivity.this, SendMailActivity.class);

        // take the user's info along
        sendMailActivity.putExtra(SendMailActivity.ARG_GIVEN_NAME, name);
        sendMailActivity.putExtra(SendMailActivity.ARG_DISPLAY_ID, preferredUsername);


        // actually start the activity
        startActivity(sendMailActivity);

        new Thread(new Runnable() {
            @Override
            public void run() {
                resetUIForConnect();
            }
        });


    }

    @Override
    public void onError(MsalException exception) {
        // Check the exception type.
        if (exception instanceof MsalClientException) {
            // This means errors happened in the sdk itself, could be network, Json parse, etc. Check MsalError.java
            // for detailed list of the errors.
            showMessage(exception.getMessage());
            showConnectErrorUI(exception.getMessage());
        } else if (exception instanceof MsalServiceException) {
            // This means something is wrong when the sdk is communication to the service, mostly likely it's the client
            // configuration.
            showMessage(exception.getMessage());
            showConnectErrorUI(exception.getMessage());
        } else if (exception instanceof MsalUiRequiredException) {
            // This explicitly indicates that developer needs to prompt the user, it could be refresh token is expired, revoked
            // or user changes the password; or it could be that no token was found in the token cache.
            AuthenticationManager mgr = AuthenticationManager.getInstance();


            mgr.callAcquireToken(ConnectActivity.this, this);
        }

    }

    @Override
    public void onError(Exception exception) {
        showMessage(exception.getMessage());
        showConnectErrorUI(exception.getMessage());
    }

    @Override
    public void onCancel() {
        showMessage("User cancelled the flow.");
        showConnectErrorUI("User cancelled the flow.");

    }


}
