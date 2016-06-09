/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.connect;

import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.web.webdriver.DriverAtoms;
import android.support.test.espresso.web.webdriver.Locator;
import android.support.test.runner.AndroidJUnit4;

import com.microsoft.aad.adal.AuthenticationActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.web.sugar.Web.onWebView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AllOf.allOf;
import static android.support.test.espresso.web.webdriver.DriverAtoms.findElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.clearElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.webClick;

@RunWith(AndroidJUnit4.class)
public class ConnectActivityTests {
    @Rule
    public IntentsTestRule<ConnectActivity> mConnectActivityRule = new IntentsTestRule<>(ConnectActivity.class);

    @Test
    public void displayAzureADSignIn() throws InterruptedException{
        Constants.CLIENT_ID = "3d0d8ee3-e097-4039-82f3-8c11b64c8412";
        onView(withId(R.id.connectButton)).perform(click());

        onWebView()
                .withElement(findElement(Locator.ID, "cred_userid_inputtext"))
                .perform(clearElement())
                // Enter text into the input element
                .perform(DriverAtoms.webKeys("zrinkam@mod182601.onmicrosoft.com"))
                .withElement(findElement(Locator.ID, "cred_password_inputtext"))
                .perform(clearElement())
                // Enter text into the input element
                .perform(DriverAtoms.webKeys("pass@word1"));

        Thread.sleep(5000, 0);

        onWebView()
                .withElement(findElement(Locator.ID, "cred_sign_in_button"))
                .perform(webClick());

        Thread.sleep(5000, 0);

        onWebView()
                .withElement(findElement(Locator.ID, "cred_sign_in_button"))
                .perform(webClick());

        Thread.sleep(5000, 0);

        onView(withId(R.id.sendMailButton)).perform(click());

        intended(allOf(
            toPackage("com.microsoft.aad.adal.AuthenticationActivity")));
    }
}
