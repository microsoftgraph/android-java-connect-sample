package com.microsoft.graph.connect.util;


import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.microsoft.graph.connect.Connect;


/*
Contains methods that access the application manifest
 */
public class ManifestReader implements IManifestReader{

    /**
     * Gets the value of an AndroidManifest meta-data node. If the node value cannot be cast to String,
     * null is returned.
     * @param key String. The meta-data key value
     * @return String.  The value associated with the key
     */
    @Override
    public String getApplicationMetadataValueString(String key) {
        String returnValue = "";
        try {
            PackageInfo info = Connect.getContext().getPackageManager().getPackageInfo(
                    Connect.getContext().getPackageName(),
                    PackageManager.GET_META_DATA);
            if (info.applicationInfo.metaData != null) {
                Bundle bundle = info.applicationInfo.metaData;
                returnValue = bundle.getString(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}

