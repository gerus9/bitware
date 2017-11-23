package com.gerus.bitware.webconnection;

import android.content.Context;
import android.os.AsyncTask;

import com.gerus.bitware.BuildConfig;
import com.gerus.bitware.R;
import com.gerus.bitware.models.Cliente;
import com.gerus.bitware.models.ErrorMsg;
import com.gerus.bitware.webconnection.interfaces.ResultInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static com.gerus.bitware.webconnection.URLConnections.RESPONSE_OK;

/**
 * Created by gerus-mac on 22/01/17.
 */

public class Tasks {

    protected static final String URL = BuildConfig.URL;
    protected static final String URL_CLIENTS = URL + "/NutriNET/Cliente ";
    protected static final String URL_CLIENTS_PUT = URL + "/NutriNET/Cliente/%s";

    protected AsyncTask mAsynkTask;
    protected Context mContext;
    protected URLConnections mConnect;

    protected static final int timeoutAsynctask = 15000;

    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").serializeNulls().create();

    public Tasks(Context context) {
        mConnect = new URLConnections(context);
        mContext = context;
    }

    public void cancel() {
        if (mAsynkTask != null) {
            mConnect.conn.disconnect();
            mAsynkTask.cancel(true);
        }
    }

    public void requestPOST(String psJsonClient, final ResultInterface.POST poResult) {
        String psURL = URL_CLIENTS;
        mAsynkTask = new AsyncTask<String, Void, NetworkModel>() {

            @Override
            protected NetworkModel doInBackground(String... params) {
                return mConnect.sendRequestPOST(params[0], params[1], timeoutAsynctask);
            }

            @Override
            protected void onPostExecute(NetworkModel poNetWorkModel) {
                try {
                    Type typeErrors = new TypeToken<ArrayList<ErrorMsg>>() {}.getType();
                    ArrayList<ErrorMsg> errorMsgs = gson.fromJson(poNetWorkModel.getMessage(), typeErrors);
                    if (poNetWorkModel.getStatusCode() == RESPONSE_OK) {
                        poResult.onError(Integer.toString(errorMsgs.get(0).getCve_Mensaje()));
                    } else {
                        poResult.onError(Integer.toString(errorMsgs.get(0).getCve_Mensaje()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    poResult.onError(mContext.getString(R.string.error_network));
                }
            }
        }.execute(psURL, psJsonClient);
    }

    public void requestGET(final ResultInterface.GET poResult) {
        String psURL = URL_CLIENTS;
        mAsynkTask = new AsyncTask<String, Void, NetworkModel>() {

            @Override
            protected NetworkModel doInBackground(String... params) {
                return mConnect.sendRequestGET(params[0], timeoutAsynctask);
            }

            @Override
            protected void onPostExecute(NetworkModel poNetWorkModel) {
                try {
                    if (poNetWorkModel.getStatusCode() == RESPONSE_OK) {
                        Type typeClients = new TypeToken<ArrayList<Cliente>>() {}.getType();
                        poResult.onResult(gson.<ArrayList<Cliente>>fromJson(poNetWorkModel.getMessage(), typeClients));
                    } else {
                        poResult.onError(mContext.getString(R.string.error_network));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    poResult.onError(mContext.getString(R.string.error_network));
                }
            }
        }.execute(psURL);
    }

    public void requestPUT(String psJsonClient, String psID, final ResultInterface.POST poResult) {
        String psURL = String.format(URL_CLIENTS_PUT, psID);
        mAsynkTask = new AsyncTask<String, Void, NetworkModel>() {

            @Override
            protected NetworkModel doInBackground(String... params) {
                return mConnect.sendRequestPUT(params[0], params[1], timeoutAsynctask);
            }

            @Override
            protected void onPostExecute(NetworkModel poNetWorkModel) {
                try {
                    Type typeErrors = new TypeToken<ArrayList<ErrorMsg>>() {}.getType();
                    ArrayList<ErrorMsg> errorMsgs = gson.fromJson(poNetWorkModel.getMessage(), typeErrors);
                    if (poNetWorkModel.getStatusCode() == RESPONSE_OK) {
                        poResult.onError(Integer.toString(errorMsgs.get(0).getCve_Mensaje()));
                    } else {
                        poResult.onError(Integer.toString(errorMsgs.get(0).getCve_Mensaje()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    poResult.onError(mContext.getString(R.string.error_network));
                }
            }
        }.execute(psURL, psJsonClient);
    }


}

