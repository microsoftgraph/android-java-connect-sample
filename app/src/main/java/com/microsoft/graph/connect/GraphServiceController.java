/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.connect;

import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.extensions.BodyType;
import com.microsoft.graph.extensions.EmailAddress;
import com.microsoft.graph.extensions.IGraphServiceClient;
import com.microsoft.graph.extensions.ItemBody;
import com.microsoft.graph.extensions.Message;
import com.microsoft.graph.extensions.Recipient;

import java.util.Arrays;

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
    }

    /**
     * Sends an email message using the Microsoft Graph API on Office 365. The mail is sent
     * from the address of the signed in user.
     *
     * @param emailAddress The recipient email address.
     * @param subject      The subject to use in the mail message.
     * @param body         The body of the message.
     */
    public void sendMail(
            final String emailAddress,
            final String subject,
            final String body,
            ICallback<Void> callback
    ) {

        // create the email message
        Message message = createMailPayload(subject, body, emailAddress);

        mGraphServiceClient.getMe().getSendMail(message, true).buildRequest().post(callback);
    }


    private Message createMailPayload(
            String subject,
            String body,
            String address) {
        Message message = new Message();

        EmailAddress emailAddress = new EmailAddress();
        emailAddress.address = address;

        Recipient recipient = new Recipient();
        recipient.emailAddress = emailAddress;

        message.toRecipients = Arrays.asList(recipient);

        ItemBody itemBody = new ItemBody();
        itemBody.content = body;
        itemBody.contentType = BodyType.html;

        message.body = itemBody;

        message.subject = subject;

        return message;
    }

}