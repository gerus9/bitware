package com.gerus.bitware.webconnection;

import android.content.Context;
import android.util.Log;
import android.util.Pair;

import com.gerus.bitware.BuildConfig;
import com.gerus.bitware.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by gerus-mac on 22/01/17.
 */

class URLConnections {

    public static final int RESPONSE_OK = 200;
    public static final int RESPONSE_NO_FOUND = 400;

    protected Context mContext;
    protected URL urlConnect;
    protected HttpURLConnection conn = null;
    private NetworkModel mNetworkModel;


    public URLConnections(android.content.Context poContext) {
        mContext = poContext;
        mNetworkModel = new NetworkModel(0, poContext.getString(R.string.error_network));
    }


    private void prcLog(String psLog) {
        if (BuildConfig.DEBUG) {
            Log.i(this.getClass().getSimpleName(), psLog);
        }
    }

    public NetworkModel sendRequestGET(String psURL, int timeout) {
        try {
            prcLog(psURL);
            prcLog("GET");

            urlConnect = new URL(psURL);
            setConnect(urlConnect, timeout);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            int viCode = conn.getResponseCode();
            String vsMsg = convertStreamToString((viCode >= RESPONSE_OK && viCode < RESPONSE_NO_FOUND) ? conn.getInputStream() : conn.getErrorStream());

            prcLog("CODE:" + viCode);
            prcLog("MSG:" + vsMsg);

            mNetworkModel.setStatusCode(viCode);
            mNetworkModel.setMessage(vsMsg);

            return mNetworkModel;
        } catch (Exception e) {
            mNetworkModel.setStatusCode(404);
            e.printStackTrace();
        }
        return mNetworkModel;
    }

    /**
     * Establece el tipo de comunicación con el servidor
     *
     * @param urlConnect
     * @throws IOException
     */
    public void setConnect(URL urlConnect, int timeOut) throws IOException {
        if (urlConnect.getProtocol().startsWith("https")) {
            conn = (HttpsURLConnection) urlConnect.openConnection();
        } else {
            conn = (HttpURLConnection) urlConnect.openConnection();
        }
        conn.setConnectTimeout(timeOut); //set timeout to 5 seconds
        conn.setReadTimeout(timeOut /* milliseconds */);
    }

    public NetworkModel sendRequestPOST(String psURL, String psjson, int timeout) {

        try {
            prcLog(psURL);
            prcLog("POST");
            prcLog("JSON: " + psjson);

            urlConnect = new URL(psURL);
            setConnect(urlConnect, timeout);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-type", "application/json");

            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write(psjson);
            out.close();
            int viCode = conn.getResponseCode();

            String vsMsg = convertStreamToString((viCode >= RESPONSE_OK && viCode < RESPONSE_NO_FOUND) ? conn.getInputStream() : conn.getErrorStream());

            prcLog("CODE:" + viCode);
            prcLog("MSG:" + vsMsg);

            mNetworkModel.setStatusCode(viCode);
            mNetworkModel.setMessage(vsMsg);
            return mNetworkModel;
        } catch (Exception e) {
            mNetworkModel.setMessage(e.getMessage());
        }
        return mNetworkModel;
    }

    public NetworkModel sendRequestPUT(String psURL, String psjson, int timeout) {

        try {
            prcLog(psURL);
            prcLog("PUT");
            prcLog("JSON: " + psjson);

            urlConnect = new URL(psURL);
            setConnect(urlConnect, timeout);
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");

            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-type", "application/json");

            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write(psjson);
            out.close();
            int viCode = conn.getResponseCode();

            String vsMsg = convertStreamToString((viCode >= RESPONSE_OK && viCode < RESPONSE_NO_FOUND) ? conn.getInputStream() : conn.getErrorStream());

            prcLog("CODE:" + viCode);
            prcLog("MSG:" + vsMsg);

            mNetworkModel.setStatusCode(viCode);
            mNetworkModel.setMessage(vsMsg);

            return mNetworkModel;
        } catch (Exception e) {
            mNetworkModel.setMessage(e.getMessage());
        }
        return mNetworkModel;
    }


    public NetworkModel sendRequestPOST(String psURL, List<Pair> poListPair, int timeout) {
        try {
            prcLog(psURL);
            prcLog("POST");

            urlConnect = new URL(psURL);
            setConnect(urlConnect, timeout);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(getQuery(poListPair));
            writer.flush();
            writer.close();
            os.close();

            int viCode = conn.getResponseCode();
            String vsMsg = convertStreamToString((viCode >= RESPONSE_OK && viCode < RESPONSE_NO_FOUND) ? conn.getInputStream() : conn.getErrorStream());
            prcLog("CODE:" + viCode);
            prcLog("MSG:" + vsMsg);

            mNetworkModel.setStatusCode(viCode);
            mNetworkModel.setMessage(vsMsg);

            return mNetworkModel;
        } catch (Exception e) {
            mNetworkModel.setStatusCode(0);
            e.printStackTrace();
        }
        return mNetworkModel;
    }

    public NetworkModel sendRequestPUT(String psURL, int timeout) {
        try {
            prcLog(psURL);
            prcLog("PUT");
            urlConnect = new URL(psURL);
            setConnect(urlConnect, timeout);
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");

            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-type", "application/json");

            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.close();
            int viCode = conn.getResponseCode();

            String vsMsg = convertStreamToString((viCode >= RESPONSE_OK && viCode < RESPONSE_NO_FOUND) ? conn.getInputStream() : conn.getErrorStream());

            prcLog("CODE:" + viCode);
            prcLog("MSG:" + vsMsg);

            mNetworkModel.setStatusCode(viCode);
            mNetworkModel.setMessage(vsMsg);

            return mNetworkModel;
        } catch (Exception e) {
            mNetworkModel.setMessage(e.getMessage());
        }
        return mNetworkModel;
    }

    public NetworkModel sendRequestPUT(String psURL, List<Pair> poListPair, int timeout) {
        try {
            prcLog(psURL);
            prcLog("PUT");
            urlConnect = new URL(psURL);
            setConnect(urlConnect, timeout);
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");

            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-type", "application/json");

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(getQuery(poListPair));
            writer.flush();
            writer.close();
            os.close();
            int viCode = conn.getResponseCode();

            String vsMsg = convertStreamToString((viCode >= RESPONSE_OK && viCode < RESPONSE_NO_FOUND) ? conn.getInputStream() : conn.getErrorStream());

            prcLog("CODE:" + viCode);
            prcLog("MSG:" + vsMsg);

            mNetworkModel.setStatusCode(viCode);
            mNetworkModel.setMessage(vsMsg);

            return mNetworkModel;
        } catch (Exception e) {
            mNetworkModel.setMessage(e.getMessage());
        }
        return mNetworkModel;
    }

    //////////////////////////////////////////////////////////////////////
    /////////////////////////////   UTILS        /////////////////////////
    //////////////////////////////////////////////////////////////////////

    /**
     * Obtiene los valores
     *
     * @param params
     * @return
     * @throws UnsupportedEncodingException
     */
    private String getQuery(List<Pair> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (Pair pair : params) {
            if (first) {
                first = false;
            } else {
                result.append("&");
            }
            result.append(URLEncoder.encode(pair.first.toString(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.second.toString(), "UTF-8"));
        }
        return result.toString();
    }

    /**
     * Convierte el InputStream en string
     *
     * @param poInputStream
     * @return Json
     * @throws IOException
     */
    public String convertStreamToString(InputStream poInputStream) throws IOException {
        if (poInputStream != null) {
            Writer writer = new StringWriter();
            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(
                        new InputStreamReader(poInputStream, Charset.forName("UTF-8")));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                poInputStream.close();
            }
            return writer.toString();
        } else {
            return "";
        }
    }


}
