package com.jinxin.beonesmartdesktop.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jinxin.beonesmartdesktop.R;
import com.jinxin.beonesmartdesktop.bean.MyAppInfo;
import com.jinxin.beonesmartdesktop.util.ApkTools;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;

public class ApplicationFragment extends Fragment implements View.OnFocusChangeListener, View.OnClickListener {



    @BindViews({ R.id.btn_application_1,
            R.id.btn_application_2,
            R.id.btn_application_3,
            R.id.btn_application_4,
            R.id.btn_application_5,
            R.id.btn_application_6,
            R.id.btn_application_7,
            R.id.btn_application_8 })
    List<LinearLayout> mBtnApps;

    List<MyAppInfo> appInfos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_application, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        for (LinearLayout btn:mBtnApps){
            btn.setOnFocusChangeListener(this);
            btn.setOnClickListener(this);
        }
        appInfos = ApkTools.scanLocalInstallAppList(getActivity().getPackageManager());
        for (int i = 0;i<8;i++){
            if (i < appInfos.size()){
                ImageView icon = (ImageView) mBtnApps.get(i).getChildAt(0);
                TextView name = (TextView) mBtnApps.get(i).getChildAt(1);
                icon.setImageDrawable(appInfos.get(i).getImage());
                name.setText(appInfos.get(i).getAppName());
                mBtnApps.get(i).setBackgroundResource(R.drawable.devices_background);
            }else {
                mBtnApps.get(i).setFocusable(false);
            }
        }
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus){
            ViewCompat.animate(v)
                    .setDuration(200)
                    .scaleX(1.1f)
                    .scaleY(1.1f)
                    .start();
        }else {
            ViewCompat.animate(v)
                    .setDuration(200)
                    .scaleX(1.0f)
                    .scaleY(1.0f)
                    .start();
        }
    }

    @Override
    public void onClick(View v) {

        for (int i =0;i<8;i++) {
            if (v == mBtnApps.get(i)){
                PackageManager packageManager = getActivity().getPackageManager();
                Intent intent = packageManager.getLaunchIntentForPackage(appInfos.get(i).getPackageName());
                startActivity(intent);
            }
        }
    }


}