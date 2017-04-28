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
    public static String CLIENT_ID = "efd07474-45a0-414a-9190-0388368aa2ee";
    public static final String REDIRECT_URI = "https://login.microsoftonline.com/common/oauth2/nativeclient";
    public static final String SCOPES = "openid profile Mail.ReadWrite mail.send Files.ReadWrite User.ReadBasic.All";
}
