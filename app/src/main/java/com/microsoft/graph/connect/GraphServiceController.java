/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.connect;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Environment;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
import com.microsoft.graph.extensions.Attachment;
import com.microsoft.graph.extensions.BodyType;
import com.microsoft.graph.extensions.EmailAddress;
import com.microsoft.graph.extensions.FileAttachment;
import com.microsoft.graph.extensions.IGraphServiceClient;
import com.microsoft.graph.extensions.ItemBody;
import com.microsoft.graph.extensions.Message;
import com.microsoft.graph.extensions.Recipient;

import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

/**
 * Handles the creation of the message and using the GraphServiceClient to
 * send the message. The app must have connected to Office 365 before using the
 * {@link #createDraftMail(String, String, String, String, ICallback)}method.
 */
class GraphServiceController {


    public enum StorageState{
        NOT_AVAILABLE, WRITEABLE, READ_ONLY
    }
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
    public void createDraftMail(
            final String senderPreferredName,
            final String emailAddress,
            final String subject,
            final String body,
            ICallback<Message> callback
    ) {

        try {

            // create the email message
            Message message = createMessage(subject, body, emailAddress);

            mGraphServiceClient
                    .getMe()
                    .getMessages()
                    .buildRequest()
                    .post(message, callback);
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

    public void sendMailWithPicture(String messageId,
                                    byte[] picture,
                                    ICallback<Attachment> callback){
        try {
            byte[] attachementBytes = new byte[picture.length];

            if (picture.length > 0){
                attachementBytes = picture;
            } else {
                attachementBytes = getDefaultPicture();
                //Get the place holder photo when the user does not have a photo
            }

            FileAttachment fileAttachment = new FileAttachment();
            fileAttachment.oDataType = "#microsoft.graph.fileAttachment";
            fileAttachment.contentBytes = attachementBytes;
            fileAttachment.contentType = "image/png";
            fileAttachment.name = "me.png";


            mGraphServiceClient
                    .getMe()
                    .getMessages(messageId)
                    .getAttachments()
                    .buildRequest()
                    .post(fileAttachment, callback);

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

    public void getUserProfilePicture(final String userPreferredName,
                               final ICallback<byte[]> callback){
        mGraphServiceClient.getMe().getPhoto().getContent().buildRequest().get(new ICallback<InputStream>() {

            @Override
            public void success(final InputStream inputStream) {
                try {
                    byte[] pictureBytes = new byte[1024];
                    BufferedInputStream bufferedInputStream = (BufferedInputStream)inputStream;

                    if (bufferedInputStream.available() < 1) {
                        pictureBytes = getDefaultPicture();
                    } else {
                        pictureBytes = convertBufferToBytes(bufferedInputStream, inputStream.available());
                    }
                    callback.success(pictureBytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void failure(ClientException ex) {
                Log.e("GraphServiceController", "no picture found " + ex.getLocalizedMessage());
                byte[] pictureBytes = getDefaultPicture();
                if (pictureBytes.length > 0){
                    callback.success(pictureBytes);
                } else {
                    callback.failure(ex);
                }
            }
        });

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


    private byte[]  getDefaultPicture(){

        if (getExternalStorageState() == StorageState.NOT_AVAILABLE) {
            return null;
        }
        String pathName = Environment.getExternalStorageDirectory() + "/";
        String fileName = Connect.getContext().getString(R.string.defaultImageFileName);
        File file = new File(pathName, fileName);
        BufferedInputStream buf = null;
        if (file.exists() && file.canRead()){
            int size = (int) file.length();


            byte[] bytes = new byte[size];
            try {
                buf = new BufferedInputStream(new FileInputStream(file));
                buf.read(bytes, 0, bytes.length);

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return convertBufferToBytes(buf, (int)file.length());
    }
    private StorageState getExternalStorageState() {
        StorageState result = StorageState.NOT_AVAILABLE;
        String state = Environment.getExternalStorageState();

        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return StorageState.WRITEABLE;
        }
        else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return StorageState.READ_ONLY;
        }

        return result;
    }

    private byte[] convertBufferToBytes(BufferedInputStream inputStream, int bufferLength){
        if (inputStream == null)
            return null;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[bufferLength];
        int n = 0;
        try {
            while((n = inputStream.read(buffer)) >= 0){
                outputStream.write(buffer, 0, n);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputStream.toByteArray();
    }
}