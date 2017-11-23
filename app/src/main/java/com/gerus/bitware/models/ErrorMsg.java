package com.gerus.bitware.models;

/**
 * Created by gerus-mac on 22/01/17.
 */

public class ErrorMsg {

    private int Cve_Mensaje;
    private String Mensaje;

    public int getCve_Mensaje() {
        return Cve_Mensaje;
    }

    public void setCve_Mensaje(int Cve_Mensaje) {
        this.Cve_Mensaje = Cve_Mensaje;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }
}
