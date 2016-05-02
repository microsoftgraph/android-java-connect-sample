package com.microsoft.graph.connect;

import org.junit.Test;

/**
 * Unit tests for the AuthenticationManager class.
 */
public class AuthenticationManagerUnitTests {
    @Test(expected = NullPointerException.class)
    public void getAccessToken_noTokenAvailable() {
        AuthenticationManager.getInstance().getAccessToken();
    }
}
