/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.connect;

public class Constants {
    public static final String CONSUMER_ACCOUNT = "consumer";
    public static final String CORPSCHOOL_ACCOUNT = "corp_school";
    public static final String AUTHORITY_URL = "https://login.microsoftonline.com/common";
    public static final String AUTHORIZATION_ENDPOINT = "/oauth2/v2.0/authorize";
    public static final String TOKEN_ENDPOINT = "/oauth2/v2.0/token";
    // The Microsoft Graph delegated permissions that you set in the application
    // registration portal must match these scope values.
    // Update this constant with the scope (permission) values for your application:
    public static final String[] SCOPES = {"openid", "Mail.ReadWrite","mail.send","Files.ReadWrite","User.ReadBasic.All"};
}
