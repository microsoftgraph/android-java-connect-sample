package com.microsoft.graph.connect;

import com.microsoft.graph.authentication.IAuthenticationProvider;
import com.microsoft.graph.core.DefaultClientConfig;
import com.microsoft.graph.core.IClientConfig;
import com.microsoft.graph.extensions.GraphServiceClient;
import com.microsoft.graph.extensions.IGraphServiceClient;
import com.microsoft.graph.http.IHttpRequest;

/**
 * Singleton class that manages a GraphServiceClient object.
 * It implements IAuthentication provider to authenticate requests using an access token.
 */
public class GraphServiceClientManager implements IAuthenticationProvider {
    private IGraphServiceClient mGraphServiceClient;
    private static GraphServiceClientManager INSTANCE;

    private GraphServiceClientManager() {}

    /**
     * Appends an access token obtained from the {@link AuthenticationManager} class to the
     * Authorization header of the request.
     * @param request
     */
    @Override
    public void authenticateRequest(IHttpRequest request) {
        request.addHeader("Authorization", "Bearer " + AuthenticationManager.getInstance().getAccessToken());
    }

    public static synchronized GraphServiceClientManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new GraphServiceClientManager();
        }
        return INSTANCE;
    }

    public synchronized void resetInstance() {
        INSTANCE.mGraphServiceClient = null;
        INSTANCE = null;
    }

    public synchronized IGraphServiceClient getGraphServiceClient() {
        if (mGraphServiceClient == null) {
            IClientConfig clientConfig = DefaultClientConfig.createWithAuthenticationProvider(
              this
            );
            mGraphServiceClient = new GraphServiceClient.Builder().fromConfig(clientConfig).buildClient();
        }

        return mGraphServiceClient;
    }
}
