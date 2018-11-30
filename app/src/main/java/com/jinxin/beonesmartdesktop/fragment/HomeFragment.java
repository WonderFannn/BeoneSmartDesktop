package com.jinxin.beonesmartdesktop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.jinxin.beonesmartdesktop.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment implements View.OnClickListener, View.OnFocusChangeListener {

    @BindView(R.id.btn_home_video) FrameLayout mBtnHomeVideo;
    @BindView(R.id.btn_home_music) FrameLayout mBtnHomeMusic;
    @BindView(R.id.btn_home_weather) FrameLayout mBtnHomeWeather;


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
}
