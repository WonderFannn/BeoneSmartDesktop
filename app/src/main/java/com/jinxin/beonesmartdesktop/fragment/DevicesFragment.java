package com.jinxin.beonesmartdesktop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jinxin.beonesmartdesktop.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DevicesFragment extends Fragment {

    @BindView(R.id.lv_gateway) ListView mLvGateway;
    @BindView(R.id.lv_devices) ListView mLvDevices;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_devices, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter1 =new ArrayAdapter<String>(getActivity(),R.layout.listview_item,getResources().getStringArray(R.array.names));
        ArrayAdapter<String> adapter2 =new ArrayAdapter<String>(getActivity(),R.layout.listview_item,getResources().getStringArray(R.array.names2));

        mLvGateway.setAdapter(adapter1);
        mLvDevices.setAdapter(adapter2);
    }
}
