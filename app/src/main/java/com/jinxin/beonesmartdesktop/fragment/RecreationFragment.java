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
import android.widget.ImageView;
import android.widget.Toast;

import com.jinxin.beonesmartdesktop.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecreationFragment extends Fragment implements View.OnFocusChangeListener, View.OnClickListener {


    @BindView(R.id.btn_recreation_movie) ImageView mBtnRecreationMovie;
    @BindView(R.id.btn_recreation_info_video) ImageView mBtnRecreationInfoVideo;
    @BindView(R.id.btn_recreation_music) ImageView mBtnRecreationMusic;
    @BindView(R.id.btn_recreation_tv) ImageView mBtnRecreationTv;
    @BindView(R.id.btn_recreation_variety) ImageView mBtnRecreationVariety;
    @BindView(R.id.btn_recreation_child) ImageView mBtnRecreationChild;
    @BindView(R.id.btn_recreation_sports) ImageView mBtnRecreationSports;
    @BindView(R.id.btn_recreation_cartoon) ImageView mBtnRecreationCartoon;
    @BindView(R.id.btn_recreation_documentary) ImageView mBtnRecreationDocumentary;
    @BindView(R.id.btn_recreation_opera) ImageView mBtnRecreationOpera;
    @BindView(R.id.btn_recreation_app_recommend) ImageView mBtnRecreationAppRecommend;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recreation, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mBtnRecreationMovie.setOnClickListener(this);
        mBtnRecreationInfoVideo.setOnClickListener(this);
        mBtnRecreationMusic.setOnClickListener(this);
        mBtnRecreationTv.setOnClickListener(this);
        mBtnRecreationVariety.setOnClickListener(this);
        mBtnRecreationChild.setOnClickListener(this);
        mBtnRecreationSports.setOnClickListener(this);
        mBtnRecreationCartoon.setOnClickListener(this);
        mBtnRecreationDocumentary.setOnClickListener(this);
        mBtnRecreationOpera.setOnClickListener(this);
        mBtnRecreationAppRecommend.setOnClickListener(this);
        
        mBtnRecreationMovie.setOnFocusChangeListener(this);
        mBtnRecreationInfoVideo.setOnFocusChangeListener(this);
        mBtnRecreationMusic.setOnFocusChangeListener(this);
        mBtnRecreationTv.setOnFocusChangeListener(this);
        mBtnRecreationVariety.setOnFocusChangeListener(this);
        mBtnRecreationChild.setOnFocusChangeListener(this);
        mBtnRecreationSports.setOnFocusChangeListener(this);
        mBtnRecreationCartoon.setOnFocusChangeListener(this);
        mBtnRecreationDocumentary.setOnFocusChangeListener(this);
        mBtnRecreationOpera.setOnFocusChangeListener(this);
        mBtnRecreationAppRecommend.setOnFocusChangeListener(this);
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

        openActivity("com.zbmv");
        
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
