package com.jinxin.beonesmartdesktop.fragment;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.jinxin.beonesmartdesktop.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment implements View.OnClickListener, View.OnFocusChangeListener {

    @BindView(R.id.btn_home_video)
    FrameLayout mBtnHomeVideo;
    @BindView(R.id.btn_home_music)
    FrameLayout mBtnHomeMusic;
    @BindView(R.id.btn_home_weather)
    FrameLayout mBtnHomeWeather;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mBtnHomeVideo.setOnClickListener(this);
        mBtnHomeMusic.setOnClickListener(this);
        mBtnHomeWeather.setOnClickListener(this);
        mBtnHomeVideo.setOnFocusChangeListener(this);
        mBtnHomeMusic.setOnFocusChangeListener(this);
        mBtnHomeWeather.setOnFocusChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_home_video:
                openActivity("com.ktcp.tvvideo");
                break;
            case R.id.btn_home_music:
                openActivity("com.tencent.qqmusictv");
                break;
            case R.id.btn_home_weather:
                Toast.makeText(getActivity(), "天气功能开发中", Toast.LENGTH_LONG).show();
            default:break;
        }

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            ViewCompat.animate(v)
                    .setDuration(200)
                    .scaleX(1.1f)
                    .scaleY(1.1f)
                    .start();
        } else {
            ViewCompat.animate(v)
                    .setDuration(200)
                    .scaleX(1.0f)
                    .scaleY(1.0f)
                    .start();
        }
    }

    private void openActivity(String packname) {

        PackageManager packageManager = getActivity().getPackageManager();
        if(checkPackInfo(packname)) {
            Intent intent = packageManager.getLaunchIntentForPackage(packname);
            startActivity(intent);
        } else {
            Toast.makeText(getActivity(), "没有安装" + packname, Toast.LENGTH_LONG).show();
        }
    }
    /**
     * 检查包是否存在
     */
    private boolean checkPackInfo(String packname) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = getActivity().getPackageManager().getPackageInfo(packname, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo != null;
    }

}
