package com.microsoft.graph.connect;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ricalo on 4/28/16.
 */
public class AuthenticationManagerUnitTests {
    @Test(expected = NullPointerException.class)
    public void getAccessToken_noTokenAvailable() {
        AuthenticationManager.getInstance().getAccessToken();
    }
}
