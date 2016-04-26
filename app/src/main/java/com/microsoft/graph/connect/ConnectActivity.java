package com.microsoft.graph.connect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.microsoft.aad.adal.AuthenticationCallback;
import com.microsoft.aad.adal.AuthenticationCancelError;
import com.microsoft.aad.adal.AuthenticationResult;
import com.microsoft.aad.adal.UserInfo;

import java.net.URI;
import java.util.UUID;

/**
 * Starting Activity of the app. Handles the connection to Office 365.
 * When it first starts it only displays a button to Connect to Office 365.
 * If there are no cached tokens, the user is required to sign in to Office 365.
 * If there are cached tokens, the app tries to reuse them.
 * The activity redirects the user to the SendMailActivity upon successful connection.
 */
public class ConnectActivity extends AppCompatActivity {

    private static final String TAG = "ConnectActivity";

    private Button mConnectButton;
    private TextView mTitleTextView;
    private TextView mDescriptionTextView;
    private ProgressBar mConnectProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

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
        AuthenticationCallback<AuthenticationResult> callback =
                new AuthenticationCallback<AuthenticationResult>() {

                    @Override
                    public void onSuccess(AuthenticationResult result) {
                        // get the UserInfo from the auth response
                        UserInfo user = result.getUserInfo();

                        // get the user's given name
                        String givenName = user.getGivenName();

                        // get the user's displayable Id
                        String displayableId = user.getDisplayableId();

                        // start the SendMailActivity
                        Intent sendMailActivity =
                                new Intent(ConnectActivity.this, SendMailActivity.class);

                        // take the user's info along
                        sendMailActivity.putExtra(SendMailActivity.ARG_GIVEN_NAME, givenName);
                        sendMailActivity.putExtra(SendMailActivity.ARG_DISPLAY_ID, displayableId);

                        // actually start the Activity
                        startActivity(sendMailActivity);

                        finish();
                    }

                    @Override
                    public void onError(Exception exc) {
                        if (userCancelledConnect(exc)) {
                            resetUIForConnect();
                        } else {
                            showConnectErrorUI();
                        }
                    }
                };

        AuthenticationManager mgr = AuthenticationManager.getInstance();
        mgr.setContextActivity(this);
        mgr.connect(callback);
    }

    /**
     * This activity gets notified about the completion of the ADAL activity through this method.
     *
     * @param requestCode The integer request code originally supplied to startActivityForResult(),
     *                    allowing you to identify who this result came from.
     * @param resultCode  The integer result code returned by the child activity through its
     *                    setResult().
     * @param data        An Intent, which can return result data to the caller (various data
     *                    can be attached to Intent "extras").
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i(TAG, "onActivityResult - AuthenticationActivity has come back with results");
        super.onActivityResult(requestCode, resultCode, data);
        AuthenticationManager
                .getInstance()
                .getAuthenticationContext()
                .onActivityResult(requestCode, resultCode, data);
    }

    private static boolean userCancelledConnect(Exception e) {
        return e instanceof AuthenticationCancelError;
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
