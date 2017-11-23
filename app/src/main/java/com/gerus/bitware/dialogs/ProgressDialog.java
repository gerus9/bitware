package com.gerus.bitware.dialogs;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import com.gerus.bitware.R;
import com.gerus.bitware.interfaces.dialogs.OnProgressDialogInterface;

/**
 * Created by gerus-mac on 22/01/17.
 */

public class ProgressDialog {

    private OnProgressDialogInterface mListener;
    private TextView mTextView;
    private AlertDialog mProgressDialog;
    private Activity mContext;

    public ProgressDialog(Activity poContext){
        mContext = poContext;
    }

    public void showProgressBar(int piDMsg) {
        showProgressBar(mContext.getString(piDMsg), null);
    }

    public void showProgressBar(String psMessage) {
        showProgressBar(psMessage, null);
    }

    public void showProgressBar(int piDMsg, OnProgressDialogInterface poInterface) {
        showProgressBar(mContext.getString(piDMsg), poInterface);
    }

    public void showProgressBar(String psMessage, OnProgressDialogInterface poInterface) {
        final AlertDialog.Builder mAlertDialog = new AlertDialog.Builder(mContext);
        View mView = mContext.getLayoutInflater().inflate(R.layout.dialog_progress, null);

        mTextView = (TextView) mView.findViewById(android.R.id.text1);
        mListener = poInterface;
        mTextView.setText(psMessage);
        mAlertDialog.setCancelable(false);
        mAlertDialog.setView(mView);
        mProgressDialog = mAlertDialog.show();
    }

    public void dismissDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
            if(mListener!=null) mListener.onSucess();
        }
    }
}
