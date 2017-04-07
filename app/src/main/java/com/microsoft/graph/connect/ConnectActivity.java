/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.connect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.api.client.auth.openidconnect.IdToken;
import com.google.api.client.json.gson.GsonFactory;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.util.UUID;

/**
 * Starting Activity of the app. Handles the connection to Office 365.
 * When it first starts it only displays a button to Connect to Office 365.
 * If there are no cached tokens, the user is required to sign in to Office 365.
 * If there are cached tokens, the app tries to reuse them.
 * The activity redirects the user to the SendMailActivity upon successful connection.
 */
public class ConnectActivity extends AppCompatActivity  {

    private static final String TAG = "ConnectActivity";

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

        // add click listener
        mConnectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConnectingInProgressUI();

                //check that client id and redirect have been configured
                if (!hasAzureConfiguration()) {
                    Toast.makeText(
                            ConnectActivity.this,
                            getString(R.string.warning_client_id_redirect_uri_incorrect),
                            Toast.LENGTH_LONG).show();
                    resetUIForConnect();
                    return;
                }

                connect();
            }
        });

    }

    private void connect() {
        // define the post-auth callback
        AuthenticationCallback<String> callback =
                new AuthenticationCallback<String>() {

                    @Override
                    public void onSuccess(String idToken) {
                        String name = "";
                        String preferredUsername = "";

                        try {
                            // get the user info from the id token
                            IdToken claims = IdToken.parse(new GsonFactory(), idToken);
                            name = claims.getPayload().get("name").toString();
                            preferredUsername = claims.getPayload().get("preferred_username").toString();

                        } catch (IOException ioe) {
                            Log.e(TAG, ioe.getMessage());
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
                    public void onError(Exception exc) {
                        showConnectErrorUI();
                    }
                };

        AuthenticationManager mgr = AuthenticationManager.getInstance(this);
        mgr.connect(this, callback);
    }

    private static boolean hasAzureConfiguration() {
        try {
            UUID.fromString(Constants.CLIENT_ID);
            URI.create(Constants.REDIRECT_URI);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
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
}
