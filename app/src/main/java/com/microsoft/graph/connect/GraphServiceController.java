/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.connect;

import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
import com.microsoft.graph.extensions.IGraphServiceClient;
import com.microsoft.graph.extensions.User;

/**
 * Handles the creation of the message and contacting the
 * mail service to send the message. The app must have
 * connected to Office 365 and discovered the mail service
 * endpoints before using the createDraftMail method.
 */
public class GraphServiceController {

    private IGraphServiceClient mGraphServiceClient;

    public GraphServiceController() {
        mGraphServiceClient = GraphServiceClientManager.getGraphServiceClient();

        mGraphServiceClient.getMe().buildRequest().get(new ICallback<User> () {
            @Override
            public void success(final User user) {

            }
            @Override
            public void failure(ClientException clientException) {

            }
        }
        );
    }

    /**
     * Sends an email message using the Microsoft Graph API on Office 365. The mail is sent
     * from the address of the signed in user.
     *
     * @param emailAddress The recipient email address.
     * @param subject      The subject to use in the mail message.
     * @param body         The body of the message.
     * @param callback     UI callback to be invoked by Retrofit call when
     *                     operation completed
     */
//    public void sendMail(
//            final String emailAddress,
//            final String subject,
//            final String body,
//            Callback<Void> callback) {
//        // create the email
//        MessageWrapper msg = createMailPayload(subject, body, emailAddress);
//
//        // send it using our service
//        mMSGraphAPIService.sendMail("application/json", msg, callback);
//    }


//    private MessageWrapper createMailPayload(
//            String subject,
//            String body,
//            String address) {
//        EmailAddressVO emailAddressVO = new EmailAddressVO();
//        emailAddressVO.mAddress = address;
//
//        ToRecipientsVO toRecipientsVO = new ToRecipientsVO();
//        toRecipientsVO.emailAddress = emailAddressVO;
//
//        BodyVO bodyVO = new BodyVO();
//        bodyVO.mContentType = "HTML";
//        bodyVO.mContent = body;
//
//        MessageVO sampleMsg = new MessageVO();
//        sampleMsg.mSubject = subject;
//        sampleMsg.mBody = bodyVO;
//        sampleMsg.mToRecipients = new ToRecipientsVO[]{toRecipientsVO};
//
//        return new MessageWrapper(sampleMsg);
//    }

}