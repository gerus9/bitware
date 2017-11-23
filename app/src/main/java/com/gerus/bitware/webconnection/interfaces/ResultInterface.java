package com.gerus.bitware.webconnection.interfaces;

import com.gerus.bitware.models.Cliente;

import java.util.ArrayList;

/**
 * Created by gerus-mac on 22/01/17.
 */

public interface ResultInterface {

    interface POST {
        void onResult(String id);
        void onError(String errorMsg);
    }

    interface GET {
        void onResult(ArrayList<Cliente> poClientes);
        void onError(String errorMsg);
    }

}
