package com.gerus.bitware.utils;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by gerus-mac on 22/01/17.
 */
public class FileUtils {

    public static String getFromResources(Context mContext, int idResource) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream is = mContext.getResources().openRawResource(idResource);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String str;

            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();
        } catch (Exception e) {
            Log.e(FileUtils.class.getSimpleName(), "Error reading file" + e.getLocalizedMessage());
            return null;
        }
        return sb.toString();
    }
}
