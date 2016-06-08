/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.connect;

import com.microsoft.graph.authentication.IAuthenticationProvider;
import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
import com.microsoft.graph.extensions.GraphServiceClient;
import com.microsoft.graph.extensions.IGraphServiceClient;
import com.microsoft.graph.http.IHttpRequest;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class GraphServiceClientManagerUnitTests implements IAuthenticationProvider {
    private GraphServiceClientManager graphServiceClientManager;
    private String accessToken;
    private String clientId = "3d0d8ee3-e097-4039-82f3-8c11b64c8412";
    private String username = "zrinkam@mod182601.onmicrosoft.com";
    private String password = "pass@word1";

    private final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    private final String GRANT_TYPE = "password";
    private final String TOKEN_ENDPOINT = "https://login.microsoftonline.com/common/oauth2/token";
    private final String RESOURCE = "https://graph.microsoft.com";
    private final String REQUEST_METHOD = "POST";

    private final String SUBJECT = "Email sent from unit test in android";
    private final String BODY = "<html><body>The body of the test email</body></html>";

    @Before
    public void getAccessTokenUsingPasswordGrant() throws IOException {
        HttpsURLConnection connection;
        URL url;

        url = new URL(TOKEN_ENDPOINT);
        connection = (HttpsURLConnection)url.openConnection();

        connection.setRequestMethod(REQUEST_METHOD);
        connection.setRequestProperty("Content-Type", CONTENT_TYPE);

        String urlParameters = String.format(
                "grant_type=%0$s&resource=%1$s&client_id=%2$s&username=%3$s&password=%4$s",
                GRANT_TYPE,
                RESOURCE,
                clientId,
                username,
                password
        );

        connection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        dataOutputStream.writeBytes(urlParameters);
        dataOutputStream.flush();
        dataOutputStream.close();

        int responseCode = connection.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());

        accessToken = response.toString();
    }

    @Test
    public void sendMail_messageSent(){
        GraphServiceController graphServiceController = new GraphServiceController(this);

        graphServiceController.sendMail(
                username,
                SUBJECT,
                BODY,
                null
        );
    }

    @Override
    public void authenticateRequest(IHttpRequest request) {
        request.addHeader("Authorization", "Bearer " + accessToken);
    }
}
