package com.gerus.bitware.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.gerus.bitware.dialogs.Dialogs;
import com.gerus.bitware.dialogs.ProgressDialog;
import com.gerus.bitware.interfaces.activities.OnMenuActivityInterface;

/**
 * Created by gerus-mac on 22/01/17.
 */

abstract class GeneralFragment extends Fragment {

    protected final String TAG = this.getClass().getSimpleName();
    protected OnMenuActivityInterface mListener;
    protected Context mContext;
    protected ProgressDialog mProgressDialog;
    protected Dialogs mDialogs;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog = new ProgressDialog(getActivity());
        mDialogs = new Dialogs(getActivity());
    }

    @Override
    public void onAttach(Context poContext) {
        super.onAttach(poContext);
        mContext = poContext;
        if (poContext instanceof OnMenuActivityInterface) {
            mListener = (OnMenuActivityInterface) mContext;
        } else {
            String psError = "***** "+ getActivity().getClass().getSimpleName() + " must implement "+OnMenuActivityInterface.class.getSimpleName() +"***** ";
            Log.e(TAG, psError);
            throw new RuntimeException(psError);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
