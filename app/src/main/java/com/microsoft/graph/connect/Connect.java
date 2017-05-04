package com.microsoft.graph.connect;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

public class Connect extends MultiDexApplication {
    public static Connect instance;

    public static Connect getInstance() {
        return instance;
    }

    public static Context getContext(){
        return instance;
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
    @Override
    public void onCreate(){
        instance = this;
        super.onCreate();
    }
}
