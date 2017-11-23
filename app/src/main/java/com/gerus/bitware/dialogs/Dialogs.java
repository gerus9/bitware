package com.gerus.bitware.dialogs;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.TextView;

import com.gerus.bitware.R;

/**
 * Created by gerus-mac on 22/01/17.
 */

public class Dialogs implements View.OnClickListener {

    private Activity mActivity;
    private AlertDialog mDialog = null;

    public Dialogs(Activity poContext) {
        mActivity = poContext;
    }

    public void showPositiveMessage(String psMsg, String psBtn, DialogInterface.OnDismissListener poDismissListener) {
        showGenericDialog(psMsg, psBtn, poDismissListener, true);
    }

    public void showPositiveMessage(String psMsg) {
        showGenericDialog(psMsg,mActivity.getString(android.R.string.ok), null, true);
    }

    public void showPositiveMessage(int piID) {
        showGenericDialog(mActivity.getString(piID),mActivity.getString(android.R.string.ok), null, true);
    }

    public void showPositiveMessage(int piID, DialogInterface.OnDismissListener poDismissListener) {
        showGenericDialog(mActivity.getString(piID),mActivity.getString(android.R.string.ok), poDismissListener, true);
    }

    public void showNegativeMessage(String psMsg) {
        showGenericDialog(psMsg,mActivity.getString(android.R.string.ok), null, false);
    }

    public void showNegativeMessage(int piID, DialogInterface.OnDismissListener poDismissListener) {
        showGenericDialog(mActivity.getString(piID),mActivity.getString(android.R.string.ok), poDismissListener, false);
    }

    public void showNegativeMessage(String psMsg, DialogInterface.OnDismissListener poDismissListener) {
        showGenericDialog(psMsg, mActivity.getString(android.R.string.ok), poDismissListener, false);
    }

    public void showNegativeMessage(String psMsg, String psBtn, DialogInterface.OnDismissListener poDismissListener) {
        showGenericDialog(psMsg, psBtn, poDismissListener, false);
    }

    private void showGenericDialog(String psMsg, String psBtn, DialogInterface.OnDismissListener poDismissListener,boolean isPositive) {
        final AlertDialog.Builder mAlertDialog = new AlertDialog.Builder(mActivity);
        View mView = mActivity.getLayoutInflater().inflate(R.layout.dialog_generic, null);
        mAlertDialog.setView(mView);
        ((TextView) mView.findViewById(android.R.id.text1)).setText(psMsg);
        ((AppCompatImageView) mView.findViewById(android.R.id.icon)).setImageResource((isPositive)? R.drawable.vc_approved:R.drawable.vc_error);
        mAlertDialog.setCancelable(poDismissListener==null);
        mAlertDialog.setOnDismissListener(poDismissListener);
        mView.findViewById(R.id.submit).setOnClickListener(this);

        mDialog = mAlertDialog.show();
    }

    @Override
    public void onClick(View v) {
        if(mDialog!=null && mDialog.isShowing()) mDialog.dismiss();
    }
}
