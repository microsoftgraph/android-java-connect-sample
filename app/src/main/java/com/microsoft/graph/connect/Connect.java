package com.microsoft.graph.connect;

import android.app.Application;
import android.content.Context;

public class Connect extends Application {
    public static Connect instance;

    public static Connect getInstance() {
        return instance;
    }

    public static Context getContext(){
        return instance;
    }

    @Override
    public void onCreate(){
        instance = this;
        super.onCreate();
    }
}
