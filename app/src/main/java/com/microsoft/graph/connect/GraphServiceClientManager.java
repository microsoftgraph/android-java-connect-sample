package com.microsoft.graph.connect;

import com.microsoft.graph.authentication.IAuthenticationProvider;
import com.microsoft.graph.core.IClientConfig;
import com.microsoft.graph.extensions.IGraphServiceClient;
import com.microsoft.graph.http.IHttpRequest;
import com.microsoft.graph.extensions.GraphServiceClient;
import com.microsoft.graph.core.DefaultClientConfig;

/**
 * Created by ricalo on 4/27/16.
 */
public class GraphServiceClientManager implements IAuthenticationProvider {

    private IGraphServiceClient mGraphServiceClient;
    private static GraphServiceClientManager INSTANCE;

    private GraphServiceClientManager() {};

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

    @Override
    public void authenticateRequest(IHttpRequest request) {
        request.addHeader("Authorization", "Bearer " + AuthenticationManager.getInstance().getAccessToken());
    }
}
