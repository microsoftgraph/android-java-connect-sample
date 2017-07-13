/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.connect;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
import com.microsoft.graph.extensions.Attachment;
import com.microsoft.graph.extensions.BodyType;
import com.microsoft.graph.extensions.DriveItem;
import com.microsoft.graph.extensions.EmailAddress;
import com.microsoft.graph.extensions.FileAttachment;
import com.microsoft.graph.extensions.IGraphServiceClient;
import com.microsoft.graph.extensions.ItemBody;
import com.microsoft.graph.extensions.Message;
import com.microsoft.graph.extensions.Permission;
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


    public enum StorageState {
        NOT_AVAILABLE, WRITEABLE, READ_ONLY
    }

    private final IGraphServiceClient mGraphServiceClient;

    public GraphServiceController() {
        mGraphServiceClient = GraphServiceClientManager.getInstance().getGraphServiceClient();
    }

    /**
     * Creates a draft email message using the Microsoft Graph API on Office 365. The mail is sent
     * from the address of the signed in user.
     *
     * @param senderPreferredName The mail senders principal user name (email addr)
     * @param emailAddress        The recipient email address.
     * @param subject             The subject to use in the mail message.
     * @param body                The body of the message.
     * @param callback            The callback method to invoke on completion of the POST request
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
            showException(ex, "exception on send mail","Send mail failed", "The send mail method failed");
        }
    }

    /**
     * Posts a file attachment in a draft message by message Id
     *
     * @param messageId   String. The id of the draft message to add an attachment to
     * @param picture     Byte[]. The picture in bytes
     * @param sharingLink String. The sharing link to the uploaded picture
     * @param callback
     */
    public void addPictureToDraftMessage(String messageId,
                                         byte[] picture,
                                         String sharingLink,
                                         ICallback<Attachment> callback) {
        try {
            byte[] attachementBytes = new byte[picture.length];

            if (picture.length > 0) {
                attachementBytes = picture;
            } else {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
                    attachementBytes = getDefaultPicture();
                }
                else {
                    attachementBytes = getTestPicture();
                }
            }

            FileAttachment fileAttachment = new FileAttachment();
            fileAttachment.oDataType = "#microsoft.graph.fileAttachment";
            fileAttachment.contentBytes = attachementBytes;
            //fileAttachment.contentType = "image/png";
            fileAttachment.name = "me.png";
            mGraphServiceClient
                    .getMe()
                    .getMessages(messageId)
                    .getAttachments()
                    .buildRequest()
                    .post(fileAttachment, callback);

        } catch (Exception ex) {
            showException(ex, "exception on add picture to draft message","Draft attachment failed", "The post file attachment method failed");
        }
    }

    /**
     * Sends a draft message to the specified recipients
     *
     * @param messageId String. The id of the message to send
     * @param callback
     */
    public void sendDraftMessage(String messageId,
                                 ICallback<Void> callback) {
        try {

            mGraphServiceClient
                    .getMe()
                    .getMessages(messageId)
                    .getSend()
                    .buildRequest()
                    .post(callback);

        } catch (Exception ex) {
            showException(ex, "exception on send draft message ","Send draft mail failed", "The send draft mail method failed");
        }
    }

    /**
     * Gets a draft message by message id
     * @param messageId
     * @param callback
     */
    public void getDraftMessage(String messageId, ICallback<Message> callback) {
        try {
            mGraphServiceClient.getMe()
                    .getMessages(messageId)
                    .buildRequest()
                    .getMessage(callback);

        } catch (Exception ex) {
            showException(ex, "exception on get draft message ","Get draft mail failed", "The get draft mail method failed");

        }
    }
    /**
     * Gets the profile picture of the signed in user from the Microsoft Graph
     *
     * @param callback
     */
    public void getUserProfilePicture(final ICallback<byte[]> callback) {
        try {
            mGraphServiceClient
                    .getMe()
                    .getPhoto()
                    .getContent()
                    .buildRequest()
                    .get(new ICallback<InputStream>() {

                        @Override
                        public void success(final InputStream inputStream) {
                            try {
                                byte[] pictureBytes = new byte[1024];
                                BufferedInputStream bufferedInputStream = (BufferedInputStream) inputStream;

                                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                                StrictMode.setThreadPolicy(policy);

                                //If the user's photo is not available, get the default test.jpg from the device external
                                //storage root folder
                                if (bufferedInputStream.available() < 1) {
                                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
                                        pictureBytes = getDefaultPicture();
                                    }
                                    else {
                                        pictureBytes = getTestPicture();
                                    }
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
                            byte[] pictureBytes = new byte[1024];
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
                                pictureBytes = getDefaultPicture();
                            }
                            else {
                                pictureBytes = getTestPicture();
                            }

                            if (pictureBytes.length > 0) {
                                callback.success(pictureBytes);
                            } else {
                                callback.failure(ex);
                            }
                        }
                    });
        } catch (Exception ex) {
            showException(ex, "exception on get user profile picture ","Get user profile picture failed", "The get user profile picture method failed");
        }
    }

    @VisibleForTesting
    Message createMessage(
            String subject,
            String body,
            String address) {

        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("The address parameter can't be null or empty.");
        } else {
            // perform a simple validation of the email address
            String addressParts[] = address.split("@");
            if (addressParts.length != 2 || addressParts[0].length() == 0 || addressParts[1].indexOf('.') == -1) {
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


    /**
     * Uploads a user picture as byte array to the user's OneDrive root folder
     *
     * @param picture  byte[] picture byte array
     * @param callback
     */
    public void uploadPictureToOneDrive(byte[] picture, ICallback<DriveItem> callback) {

        try {
            mGraphServiceClient
                    .getMe()
                    .getDrive()
                    .getRoot()
                    .getItemWithPath("me.png")
                    .getContent()
                    .buildRequest()
                    .put(picture, callback);
        } catch (Exception ex) {
            showException(ex, "exception on upload picture to OneDrive ","Upload picture failed", "The upload picture  method failed");
        }
    }

    public void getSharingLink(String id, ICallback<Permission> callback) {

        try {

            mGraphServiceClient
                    .getMe()
                    .getDrive()
                    .getItems(id)
                    .getCreateLink("organization", "view")
                    .buildRequest()
                    .post(callback);
        } catch (Exception ex) {
            showException(ex, "exception on get OneDrive sharing link ","Get sharing link failed", "The get sharing link method failed");
        }
    }

    /**
     * Gets a picture from the device external storage root folder
     *
     * @return byte[] the default picture in a byte array
     */
    private byte[] getDefaultPicture() {


        int bytesRead;
        byte[] bytes = new byte[1024];

        String pathName = Environment.getExternalStorageDirectory() + "/";
        String fileName = Connect.getContext().getString(R.string.defaultImageFileName);
        File file = new File(pathName, fileName);
        FileInputStream buf = null;
        if (file.exists() && file.canRead()) {
            int size = (int) file.length();

            bytes = new byte[size];
            try {
                buf = new FileInputStream(file);
                bytesRead = buf.read(bytes, 0, size);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bytes;
    }

    @TargetApi(21)
    private byte[] getTestPicture() {
        byte[] bytes = new byte[1024];
        int resId = Connect.getInstance().getResources().getIdentifier("test","drawable",Connect.getInstance().getPackageName());
        Drawable image = Connect.getInstance().getDrawable(resId);
        Bitmap bitmap = ((BitmapDrawable)image).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
        bytes = stream.toByteArray();
        return bytes;
    }
    /**
     * Gets the mounted state of device external storage
     *
     * @return
     */
    private StorageState getExternalStorageState() {
        StorageState result = StorageState.NOT_AVAILABLE;
        String state = Environment.getExternalStorageState();

        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return StorageState.WRITEABLE;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return StorageState.READ_ONLY;
        }
        return result;
    }

    /**
     * Converts a BufferedInputStream to a byte array
     *
     * @param inputStream
     * @param bufferLength
     * @return
     * @throws IOException
     */
    private byte[] convertBufferToBytes(BufferedInputStream inputStream, int bufferLength) throws IOException {
        if (inputStream == null)
            return null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[bufferLength];
        int x = inputStream.read(buffer, 0, bufferLength);
        Log.i("GraphServiceController", "bytes read from picture input stream " + String.valueOf(x));

        int n = 0;
        try {
            while ((n = inputStream.read(buffer, 0, bufferLength)) >= 0) {
                outputStream.write(buffer, 0, n);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        outputStream.close();
        return outputStream.toByteArray();
    }

    /*
    * Opens a user dialog that shows the failure result of an exception and writes a log entry
    * */
    private void showException(Exception ex, String exceptionAction, String exceptionTitle, String exceptionMessage){
        Log.e("GraphServiceController", exceptionAction + ex.getLocalizedMessage());
        AlertDialog.Builder alertDialogBuidler = new AlertDialog.Builder(Connect.getContext());
        alertDialogBuidler.setTitle(exceptionTitle);
        alertDialogBuidler.setMessage(exceptionMessage);
        alertDialogBuidler.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialogBuidler.show();

    }
}