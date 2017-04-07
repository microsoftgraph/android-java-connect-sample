/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.connect;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.CursorJoiner;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
import com.microsoft.graph.extensions.AttachmentCollectionPage;
import com.microsoft.graph.extensions.BodyType;
import com.microsoft.graph.extensions.EmailAddress;
import com.microsoft.graph.extensions.FileAttachment;
import com.microsoft.graph.extensions.IGraphServiceClient;
import com.microsoft.graph.extensions.ItemBody;
import com.microsoft.graph.extensions.Message;
import com.microsoft.graph.extensions.ProfilePhoto;
import com.microsoft.graph.extensions.Recipient;
import com.microsoft.graph.serializer.ISerializer;

import java.io.InputStream;
import java.util.Collections;

/**
 * Handles the creation of the message and using the GraphServiceClient to
 * send the message. The app must have connected to Office 365 before using the
 * {@link #sendMail(String, String, String, String, ICallback)}method.
 */
class GraphServiceController {

    private final IGraphServiceClient mGraphServiceClient;

    public GraphServiceController() {
        mGraphServiceClient = GraphServiceClientManager.getInstance().getGraphServiceClient();
    }

    /**
     * Sends an email message using the Microsoft Graph API on Office 365. The mail is sent
     * from the address of the signed in user.
     *
     * @param senderPreferredName  The mail senders principal user name (email addr)
     * @param emailAddress The recipient email address.
     * @param subject      The subject to use in the mail message.
     * @param body         The body of the message.
     * @param callback     The callback method to invoke on completion of the POST request
     */
    public void sendMail(
            final String senderPreferredName,
            final String emailAddress,
            final String subject,
            final String body,
            ICallback<Void> callback
    ) {

        //Get the user's profile picture and then send the email with it as attachment
        getUserProfilePicture(senderPreferredName, emailAddress, subject, body, callback);
    }

    /**
     * Sends an email message using the Microsoft Graph API on Office 365. The mail is sent
     * from the address of the signed in user.
     *
     * @param senderPreferredName The mail senders principal user name
     * @param emailAddress      The recipient email address
     * @param subject           The subject to use in the mail message.
     * @param body              The body of the message.
     * @param senderPicture     The sender's profile picture
     * @param callback
     */
    private void sendMail(
            final String senderPreferredName,
            final String emailAddress,
            final String subject,
            final String body,
            final InputStream senderPicture,
            ICallback<Void> callback
    )
    {
        try {
            // create the email message
            Message message = createMessage(subject, body, emailAddress);

            if (senderPicture != null){
                FileAttachment fileAttachment = new FileAttachment();
                fileAttachment.oDataType = "#microsoft.graph.fileAttachment";
                fileAttachment.contentBytes = null;
                fileAttachment.contentType = "image/png";
                fileAttachment.name = "me.png";

//                ISerializer serializer = new ISerializer() {
//                    @Override
//                    public <T> T deserializeObject(String inputString, Class<T> clazz) {
//                        return null;
//                    }
//
//                    @Override
//                    public <T> String serializeObject(T serializableObject) {
//                        return new Gson().toJson(serializableObject);
//                    }
//                };
//                message.attachments.setRawObject(serializer, senderPicture);

            }

            mGraphServiceClient.getMe().getSendMail(message, true).buildRequest().post(callback);

        } catch (Exception ex) {
            Log.e("GraphServiceController","exception on send mail " + ex.getLocalizedMessage());
            AlertDialog.Builder alertDialogBuidler = new AlertDialog.Builder(Connect.getContext());
            alertDialogBuidler.setTitle("Send mail failed");
            alertDialogBuidler.setMessage("The send mail method failed");
            alertDialogBuidler.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialogBuidler.show();

        }

    }

    @VisibleForTesting
    Message createMessage(
            String subject,
            String body,
            String address) {

        if(address == null || address.isEmpty()) {
            throw new IllegalArgumentException("The address parameter can't be null or empty.");
        } else {
            // perform a simple validation of the email address
            String addressParts[] = address.split("@");
            if(addressParts.length != 2 || addressParts[0].length() == 0 || addressParts[1].indexOf('.') == -1) {
                throw new IllegalArgumentException(
                    String.format("The address parameter must be a valid email address {0}", address)
                );
            }
        }

        Message message = new Message();

        EmailAddress emailAddress = new EmailAddress();
        emailAddress.address = address;

        Recipient recipient = new Recipient();
        recipient.emailAddress = emailAddress;

        message.toRecipients = Collections.singletonList(recipient);

        ItemBody itemBody = new ItemBody();
        itemBody.content = body;
        itemBody.contentType = BodyType.html;

        message.body = itemBody;

        message.subject = subject;

        return message;
    }

    void getUserProfilePicture(final String userPreferredName,
                               final String emailAddress,
                               final String subject,
                               final String body,
                               final ICallback<Void> callback
    ){
          JsonObject returnObject;



        mGraphServiceClient.getMe().getPhoto().getContent().buildRequest().get(new ICallback<InputStream>() {

            @Override
            public void success(InputStream inputStream) {
                sendMail(
                        userPreferredName,
                        emailAddress,
                        subject,
                        body,
                        inputStream,
                        callback);

            }

            @Override
            public void failure(ClientException ex) {
                Log.e("GraphServiceController", "no picture found " + ex.getLocalizedMessage());
                sendMail(
                        userPreferredName,
                        emailAddress,
                        subject,
                        body,
                        null,
                        callback);

            }
        });

    }
}