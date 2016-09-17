/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.connect;

public class Constants {
    public static final String AUTHORITY_URL = "https://login.microsoftonline.com/common";
    public static final String AUTHORIZATION_ENDPOINT = "/oauth2/v2.0/authorize";
    public static final String TOKEN_ENDPOINT = "/oauth2/v2.0/token";
    // Update these two constants with the values for your application:
    public static String CLIENT_ID = "ENTER_YOUR_CLIENT_ID";
    public static final String REDIRECT_URI = "ENTER_YOUR_REDIRECT_URI";
    public static final String SCOPES = "openid profile mail.send";
}
