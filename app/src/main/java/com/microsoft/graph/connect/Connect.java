package com.microsoft.graph.connect;

import android.app.Activity;
import android.content.Context;
import android.os.StrictMode;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.microsoft.identity.client.ILoggerCallback;
import com.microsoft.identity.client.Logger;

public class Connect extends MultiDexApplication {
    public static Connect instance;

    public static Connect getInstance() {
        return instance;
    }

    public static Context getContext(){
        return instance;
    }

    private Activity mConnectActivity;

    private StringBuffer mLogs;
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
    @Override
    public void onCreate(){
        instance = this;
        super.onCreate();

        mLogs = new StringBuffer();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        // Logging can be turned on four different levels: error, warning, info, and verbose. By default the sdk is turning on
        // verbose level logging. Any apps can use Logger.getInstance().setLogLevel(Loglevel) to enable different level of logging.
        Logger.getInstance().setExternalLogger(new ILoggerCallback() {
            @Override
            public void log(String tag, Logger.LogLevel logLevel, String message, boolean containsPII) {
                // contains PII indicates that if the log message contains PII information. If Pii logging is
                // disabled, the sdk never returns back logs with Pii.
                mLogs.append(message).append('\n');
            }
        });
    }
    String getLogs() {
        return mLogs.toString();
    }

    void clearLogs() {
        mLogs = new StringBuffer();
    }

    public Activity getConnectActivity() {
        return mConnectActivity;
    }

    public void setConnectActivity(Activity connectActivity) {
        mConnectActivity = connectActivity;
    }
}
