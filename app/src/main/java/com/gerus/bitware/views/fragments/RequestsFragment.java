package com.gerus.bitware.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gerus.bitware.R;
import com.gerus.bitware.models.Cliente;
import com.gerus.bitware.utils.FileUtils;
import com.gerus.bitware.webconnection.Tasks;
import com.gerus.bitware.webconnection.interfaces.ResultInterface;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gerus-mac on 22/01/17.
 */

public class RequestsFragment extends GeneralFragment {

    private Tasks mRequests;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_requests, container, false);
        ButterKnife.bind(this, view);
        mRequests = new Tasks(getContext());
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListener.changeTitle(R.string.fragment_requests);
    }

    @OnClick(R.id.request_post)
    public void postClick(View view) {
        mProgressDialog.showProgressBar(R.string.loading);
        mRequests.requestPOST(FileUtils.getFromResources(getContext(), R.raw.post), new ResultInterface.POST() {
            @Override
            public void onResult(String id) {
                mProgressDialog.dismissDialog();
            }

            @Override
            public void onError(String errorMsg) {
                mProgressDialog.dismissDialog();
                mDialogs.showNegativeMessage(errorMsg);
            }
        });
    }

    @OnClick(R.id.request_get)
    public void getClick(View view) {
        mProgressDialog.showProgressBar(R.string.loading);
        mRequests.requestGET(new ResultInterface.GET() {
            @Override
            public void onResult(ArrayList<Cliente> poClientes) {
                mProgressDialog.dismissDialog();
                mDialogs.showPositiveMessage(String.format(getString(R.string.employess), poClientes.size()));
            }

            @Override
            public void onError(String errorMsg) {
                mProgressDialog.dismissDialog();
                mDialogs.showNegativeMessage(errorMsg);
            }
        });
    }

    @OnClick(R.id.request_put)
    public void putClick(View view) {
        mProgressDialog.showProgressBar(R.string.loading);
        mRequests.requestPUT(FileUtils.getFromResources(getContext(), R.raw.put), "59", new ResultInterface.POST() {
            @Override
            public void onResult(String id) {
                mProgressDialog.dismissDialog();
            }

            @Override
            public void onError(String errorMsg) {
                mProgressDialog.dismissDialog();
                mDialogs.showNegativeMessage(errorMsg);
            }
        });
    }
}
