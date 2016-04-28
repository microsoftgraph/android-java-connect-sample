package com.microsoft.graph.connect;

import com.microsoft.graph.extensions.Message;

import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class GraphServiceControllerUnitTests {
    @Test
    public void createMessage_messageNotNull() throws Exception {
        GraphServiceController graphServiceController = new GraphServiceController();
        Message message = graphServiceController.createMessage(
                "Fictitious Subject",
                "Fictitious Body",
                "fictitiousEmail@contoso.com"
        );

        assertNotNull(message);
    }

    @Test(expected = InvalidParameterException.class)
    public void createMessage_addressNotNull() throws Exception {
        GraphServiceController graphServiceController = new GraphServiceController();
        Message message = graphServiceController.createMessage(
                "Fictitious Subject",
                "Fictitious Body",
                null
        );
    }

    @Test(expected = InvalidParameterException.class)
    public void createMessage_addressNotEmpty() throws Exception {
        GraphServiceController graphServiceController = new GraphServiceController();
        Message message = graphServiceController.createMessage(
                "Fictitious Subject",
                "Fictitious Body",
                ""
        );
    }

    @Test(expected = InvalidParameterException.class)
    public void createMessage_wellFormedAddress() throws Exception {
        GraphServiceController graphServiceController = new GraphServiceController();
        Message message = graphServiceController.createMessage(
                "Fictitious Subject",
                "Fictitious Body",
                "Invalid@Address"
        );
    }
}