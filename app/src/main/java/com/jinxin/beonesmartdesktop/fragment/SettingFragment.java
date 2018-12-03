package com.jinxin.beonesmartdesktop.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jinxin.beonesmartdesktop.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingFragment extends Fragment implements View.OnFocusChangeListener {


    @BindView(R.id.btn_setting_wlan) LinearLayout mBtnSettingWlan;
    @BindView(R.id.btn_setting_bluetooth) LinearLayout mBtnSettingBluetooth;
    @BindView(R.id.btn_setting_ethernet) LinearLayout mBtnSettingEthernet;
    @BindView(R.id.btn_setting_netflow) LinearLayout mBtnSettingNetflow;
    @BindView(R.id.btn_setting_more) LinearLayout mBtnSettingMore;
    @BindView(R.id.btn_setting_usb) LinearLayout mBtnSettingUsb;
    @BindView(R.id.btn_setting_display) LinearLayout mBtnSettingDisplay;
    @BindView(R.id.btn_setting_warning_tone) LinearLayout mBtnSettingWarningTone;
    @BindView(R.id.btn_setting_notification) LinearLayout mBtnSettingNotification;
    @BindView(R.id.btn_setting_battery) LinearLayout mBtnSettingBattery;
    @BindView(R.id.btn_setting_battery_safer) LinearLayout mBtnSettingBatterySafer;
    @BindView(R.id.btn_setting_application) LinearLayout mBtnSettingApplication;
    @BindView(R.id.btn_setting_screen_capture) LinearLayout mBtnSettingScreenCapture;
    @BindView(R.id.btn_setting_location) LinearLayout mBtnSettingLocation;
    @BindView(R.id.btn_setting_safety) LinearLayout mBtnSettingSafety;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mBtnSettingWlan.setOnFocusChangeListener(this);
        mBtnSettingBluetooth.setOnFocusChangeListener(this);
        mBtnSettingEthernet.setOnFocusChangeListener(this);
        mBtnSettingNetflow.setOnFocusChangeListener(this);
        mBtnSettingMore.setOnFocusChangeListener(this);
        mBtnSettingUsb.setOnFocusChangeListener(this);
        mBtnSettingDisplay.setOnFocusChangeListener(this);
        mBtnSettingWarningTone.setOnFocusChangeListener(this);
        mBtnSettingNotification.setOnFocusChangeListener(this);
        mBtnSettingBattery.setOnFocusChangeListener(this);
        mBtnSettingBatterySafer.setOnFocusChangeListener(this);
        mBtnSettingApplication.setOnFocusChangeListener(this);
        mBtnSettingScreenCapture.setOnFocusChangeListener(this);
        mBtnSettingLocation.setOnFocusChangeListener(this);
        mBtnSettingSafety.setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus){
            v.setBackgroundColor(Color.parseColor("#fff34649"));

        }else {
            v.setBackgroundColor(Color.parseColor("#00000000"));

        }
    }
}
