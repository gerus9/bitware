package com.gerus.bitware.webconnection;

/**
 * Created by gerus-mac on 22/01/17.
 */

class NetworkModel {

    private int statusCode;
    private String message;

    public NetworkModel(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
