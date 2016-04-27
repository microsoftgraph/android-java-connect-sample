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
public class GraphServiceClientManager {

    private static IGraphServiceClient mGraphServiceClient;

    public static synchronized IGraphServiceClient getGraphServiceClient() {
        if (mGraphServiceClient == null) {
            IClientConfig clientConfig = DefaultClientConfig.createWithAuthenticationProvider(
              AuthenticationManager.getInstance()
            );
            mGraphServiceClient = new GraphServiceClient.Builder().fromConfig(clientConfig).buildClient();
        }

        return mGraphServiceClient;
    }

    public static synchronized void resetGraphServiceClient() {
        mGraphServiceClient = null;
    }


}
