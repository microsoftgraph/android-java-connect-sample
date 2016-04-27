package com.microsoft.graph.connect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

/**
 * This activity handles the send mail operation of the app.
 * The app must be connected to Office 365 before this activity can send an email.
 * It also uses the GraphServiceController to send the message.
 */
public class SendMailActivity extends AppCompatActivity {

    // arguments for this activity
    public static final String ARG_GIVEN_NAME = "givenName";
    public static final String ARG_DISPLAY_ID = "displayableId";

    // views
    private EditText mEmailEditText;
    private Button mSendMailButton;
    private ProgressBar mSendMailProgressBar;
    private String mGivenName;
    private TextView mConclusionTextView;

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
    }

    /**
     * Handler for the onclick event of the send mail button. It uses the GraphServiceController to
     * send an email. When the call is completed, the call will return to either the success()
     * or failure() methods in this class which will then take the next steps on the UI.
     * This method sends the email using the address stored in the mEmailEditText view.
     * The subject and body of the message is stored in the strings.xml file.
     *
     * @param v The view.
     */
    public void onSendMailButtonClick(View v) {
        resetUIForSendMail();

        //Prepare body message and insert name of sender
        String body = getString(R.string.mail_body_text);
        body = body.replace("{0}", mGivenName);

        new GraphServiceController()
                .sendMail(
                        mEmailEditText.getText().toString(),
                        getString(R.string.mail_subject_text),
                        body,
                        new ICallback<Void>() {
                            @Override
                            public void success(Void aVoid) {
                                showSendMailSuccessUI();
                            }

                            @Override
                            public void failure(ClientException ex) {
                                showSendMailErrorUI();
                            }
                        }
                );
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
            case R.id.disconnectMenuitem:
                AuthenticationManager.getInstance().disconnect();
                Intent connectIntent = new Intent(this, ConnectActivity.class);
                startActivity(connectIntent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void resetUIForSendMail() {
        mSendMailButton.setVisibility(View.GONE);
        mConclusionTextView.setVisibility(View.GONE);
        mSendMailProgressBar.setVisibility(View.VISIBLE);
    }

    private void showSendMailSuccessUI() {
        mSendMailProgressBar.setVisibility(View.GONE);
        mSendMailButton.setVisibility(View.VISIBLE);
        mConclusionTextView.setText(R.string.conclusion_text);
        mConclusionTextView.setVisibility(View.VISIBLE);
        Toast.makeText(
                SendMailActivity.this,
                R.string.send_mail_toast_text,
                Toast.LENGTH_SHORT).show();
    }

    private void showSendMailErrorUI() {
        mSendMailProgressBar.setVisibility(View.GONE);
        mSendMailButton.setVisibility(View.VISIBLE);
        mConclusionTextView.setText(R.string.send_mail_text_error);
        mConclusionTextView.setVisibility(View.VISIBLE);
        Toast.makeText(
                SendMailActivity.this,
                R.string.send_mail_toast_text_error,
                Toast.LENGTH_LONG).show();
    }
}
