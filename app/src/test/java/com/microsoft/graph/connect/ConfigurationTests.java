/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.connect;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test to validate sample configuration
 */
public class ConfigurationTests {
    @Test
    public void configuration_client_id_not_empty() {
        assertTrue("Client ID value in Constants.java can't be empty", !Constants.CLIENT_ID.equals(""));
    }

    @Test
    public void configuration_client_id_not_default() {
        assertTrue("Configure a valid client ID in Constants.java", !Constants.CLIENT_ID.equals("ENTER_YOUR_CLIENT_ID"));
    }

}
