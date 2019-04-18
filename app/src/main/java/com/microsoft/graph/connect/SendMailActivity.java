/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.connect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
import com.microsoft.graph.models.extensions.Attachment;
import com.microsoft.graph.models.extensions.DriveItem;
import com.microsoft.graph.models.extensions.Message;
import com.microsoft.graph.models.extensions.Permission;

/**
 * This activity handles the send mail operation of the app.
 * The app must be connected to Office 365 before this activity can send an email.
 * It also uses the GraphServiceController to send the message.
 */
public class SendMailActivity extends AppCompatActivity {

    // arguments for this activity
    public static final String ARG_GIVEN_NAME = "givenName";
    public static final String ARG_DISPLAY_ID = "displayableId";
    public static final String ARG_UPN = "upn";

    // views
    private EditText mEmailEditText;
    private Button mSendMailButton;
    private ProgressBar mSendMailProgressBar;
    private String mGivenName;
    private String mPreferredName;
    private TextView mConclusionTextView;
    final private GraphServiceController mGraphServiceController = new GraphServiceController();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mail);

        // find the views
        TextView mTitleTextView = (TextView) findViewById(R.id.titleTextView);
        mEmailEditText = (EditText) findViewById(R.id.emailEditText);
        mSendMailButton = (Button) findViewById(R.id.sendMailButton);
        mSendMailProgressBar = (ProgressBar) findViewById(R.id.sendMailProgressBar);
        mConclusionTextView = (TextView) findViewById(R.id.conclusionTextView);

        // Extract the givenName and displayableId and use it in the UI.
        mGivenName = getIntent().getStringExtra(ARG_GIVEN_NAME);
        mTitleTextView.append(mGivenName + "!");
        mEmailEditText.setText(getIntent().getStringExtra(ARG_DISPLAY_ID));
        mPreferredName = getIntent().getStringExtra(ARG_DISPLAY_ID);
    }

    /**
     * Handler for the onclick event of the send mail button. It uses the GraphServiceController to
     * send an email. When the call is completed, the call will return to either the success()
     * or failure() methods in this class which will then take the next steps on the UI.
     * This method sends the email using the address stored in the mEmailEditText view.
     * The subject and body of the message is stored in the strings.xml file.
     * <p>
     * The following calls are made asynchronously in a chain of callback invocations.
     * 1. Get the user's profile picture from Microsoft Graph
     * 2. Upload the profile picture to the user's OneDrive root folder
     * 3. Get a sharing link to the picture from OneDrive
     * 4. Create and post a draft email
     * 5. Get the draft message
     * 6. Attach the profile picture to the draft mail as a byte array
     * 7. Send the draft email
     *
     * @param v The view.
     */
    public void onSendMailButtonClick(View v) {
        try {
            resetUIForSendMail();

            //1. Get the signed in user's profile picture
            mGraphServiceController.getUserProfilePicture(new ICallback<byte[]>() {
                @Override
                public void success(final byte[] bytes) {

                    //2. Upload the profile picture to OneDrive
                    mGraphServiceController.uploadPictureToOneDrive(bytes, new ICallback<DriveItem>() {
                        @Override
                        public void success(DriveItem driveItem) {

                            //3. Get the sharing link and if success, call step 4 helper
                            Log.i("SendMailActivity", "Getting the sharing link ");
                            getSharingLink(driveItem, bytes);
                        }

                        @Override
                        public void failure(ClientException ex) {
                            Log.i("SendMailActivity", "Exception on upload image to OneDrive " + ex.getLocalizedMessage());
                            showSendMailErrorUI();
                        }
                    });
                }

                @Override
                public void failure(ClientException ex) {
                    showSendMailErrorUI();
                }
            });
        } catch (Exception ex) {
            Log.i("SendMailActivity", "Exception on send mail " + ex.getLocalizedMessage());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.send_mail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.disconnectMenuItem:
                AuthenticationManager.getInstance().disconnect();
                Intent connectIntent = new Intent(this, ConnectActivity.class);
                startActivity(connectIntent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    /**
     * Gets the picture sharing link from OneDrive and calls the step 4 helper
     *
     * @param driveItem
     * @param bytes
     */
    private void getSharingLink(DriveItem driveItem, final byte[] bytes) {
        //3. Get a sharing link to the picture uploaded to OneDrive
        mGraphServiceController.getSharingLink(driveItem.id, new ICallback<Permission>() {
            @Override
            public void success(final Permission permission) {
                Log.i("SendMailActivity", "Creating the draft message ");
                createDraftMail(permission, bytes);
            }
            @Override
            public void failure(ClientException ex) {
                Log.i("SendMailActivity", "Exception on get sharing link " + ex.getLocalizedMessage());
                showSendMailErrorUI();
            }
        });
    }

    /**
     * Creates a draft mail and calls the step 5 helper
     *
     * @param permission
     * @param bytes
     */
    private void createDraftMail(final Permission permission, final byte[] bytes) {
        //Prepare body message and insert name of sender
        String body = getString(R.string.mail_body_text2);

        try {
            //insert sharing link instead of given name
            body = getString(R.string.mail_body_text2);

            //replace() is used instead of format() because the mail body string contains several
            //'%' characters, most of which are not string place holders. When format() is used,
            //format exception is thrown. Place holders do not match replacement parameters.
            body = body.replace("a href=%s", "a href=" + permission.link.webUrl.toString());
            final String mailBody = body;
            //4. Create a draft mail message
            mGraphServiceController.createDraftMail(
                mPreferredName,
                mEmailEditText.getText().toString(),
                getString(R.string.mail_subject_text),
                mailBody,
                new ICallback<Message>() {
                    @Override
                    public void success(final Message aMessage) {
                        Log.i("SendMailActivity", "Getting the draft message ");
                        getDraftMessage(aMessage, permission, bytes);
                    }

                    @Override
                    public void failure(ClientException ex) {
                        Log.i("SendMailActivity", "Create draft mail " + ex.getLocalizedMessage());
                        showSendMailErrorUI();
                    }
                }
            );
        } catch (Exception ex) {
            Log.i("SendMailActivity", "Exception on send mail " + ex.getLocalizedMessage());
            showSendMailErrorUI();

        }
    }


    /**
     * Gets the draft message created in the previous step and calls the step 6 helper
     *
     * @param aMessage
     * @param permission
     * @param bytes
     */
    private void getDraftMessage(final Message aMessage, final Permission permission, final byte[] bytes) {
        //5. Get draft message
        mGraphServiceController.getDraftMessage(aMessage.id, new ICallback<Message>() {
            public void success(final Message aMessage) {
                Log.i("SendMailActivity", "Adding picture to draft message ");
                sendDraftMessage(aMessage);

            }

            public void failure(ClientException ex) {
                Log.i("SendMailActivity", "Exception on get draft message " + ex.getLocalizedMessage());
                showSendMailErrorUI();

            }
        });

    }

    /**
     * Adds the picture bytes as attachment to the draft message and calls the step 7 helper
     *
     * @param aMessage
     * @param permission
     * @param bytes
     */
    private void addPictureToDraftMessage(final Message aMessage, final Permission permission, final byte[] bytes) {
        //6. Add the profile picture to the draft mail
        mGraphServiceController.addPictureToDraftMessage(aMessage.id, bytes, permission.link.webUrl,
            new ICallback<Attachment>() {
                @Override
                public void success(final Attachment anAttachment) {
                    Log.i("SendMailActivity", "Sending draft message ");
                    sendDraftMessage(aMessage);
                }

                @Override
                public void failure(ClientException ex) {
                    Log.i("SendMailActivity", "Exception on add picture to draft message " + ex.getLocalizedMessage());
                    showSendMailErrorUI();
                }
            });
    }


    /**
     * Sends the draft message
     *
     * @param aMessage
     */
    private void sendDraftMessage(final Message aMessage) {
        //7. Send the draft message to the recipient
        mGraphServiceController.sendDraftMessage(aMessage.id, new ICallback<Void>() {
            @Override
            public void success(Void aVoid) {
                showSendMailSuccessUI();
            }

            @Override
            public void failure(ClientException ex) {
                Log.i("SendMailActivity", "Exception on send draft message " + ex.getLocalizedMessage());
                showSendMailErrorUI();

            }
        });

    }

    private void resetUIForSendMail() {
        mSendMailButton.setVisibility(View.GONE);
        mConclusionTextView.setVisibility(View.GONE);
        mSendMailProgressBar.setVisibility(View.VISIBLE);
    }

    private void showSendMailSuccessUI() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mSendMailProgressBar.setVisibility(View.GONE);
                mSendMailButton.setVisibility(View.VISIBLE);
                mConclusionTextView.setText(R.string.conclusion_text);
                mConclusionTextView.setVisibility(View.VISIBLE);
                Toast.makeText(
                        SendMailActivity.this,
                        R.string.send_mail_toast_text,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showSendMailErrorUI() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mSendMailProgressBar.setVisibility(View.GONE);
                mSendMailButton.setVisibility(View.VISIBLE);
                mConclusionTextView.setText(R.string.send_mail_text_error);
                mConclusionTextView.setVisibility(View.VISIBLE);
                Toast.makeText(
                        SendMailActivity.this,
                        R.string.send_mail_toast_text_error,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
