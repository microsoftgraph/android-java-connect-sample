/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.connect;

import org.junit.Test;

/**
 * Unit tests for the AuthenticationManager class.
 */
public class AuthenticationManagerUnitTests {
    @Test(expected = TokenNotFoundException.class)
    public void getAccessToken_noTokenAvailable() throws Exception {
        AuthenticationManager.getInstance().getAccessToken();
    }
}
