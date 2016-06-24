/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.connect;

/**
 * Exception to throw when a token is not available in Authentication Manager.
 */
public class TokenNotFoundException extends Exception {
    public TokenNotFoundException() {
        super();
    }
}
