package com.jinxin.beonesmartdesktop.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jinxin.beonesmartdesktop.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingFragment extends Fragment implements View.OnFocusChangeListener, View.OnClickListener {


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
        
        mBtnSettingWlan.setOnClickListener(this);
        mBtnSettingBluetooth.setOnClickListener(this);
        mBtnSettingEthernet.setOnClickListener(this);
        mBtnSettingNetflow.setOnClickListener(this);
        mBtnSettingMore.setOnClickListener(this);
        mBtnSettingUsb.setOnClickListener(this);
        mBtnSettingDisplay.setOnClickListener(this);
        mBtnSettingWarningTone.setOnClickListener(this);
        mBtnSettingNotification.setOnClickListener(this);
        mBtnSettingBattery.setOnClickListener(this);
        mBtnSettingBatterySafer.setOnClickListener(this);
        mBtnSettingApplication.setOnClickListener(this);
        mBtnSettingScreenCapture.setOnClickListener(this);
        mBtnSettingLocation.setOnClickListener(this);
        mBtnSettingSafety.setOnClickListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus){
            v.setBackgroundColor(Color.parseColor("#fff34649"));
        }else {
            v.setBackgroundColor(Color.parseColor("#00000000"));
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btn_setting_wlan:
                intent =  new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(intent);
                break;
            case R.id.btn_setting_bluetooth:
                intent =  new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
                startActivity(intent);
                break;
            case R.id.btn_setting_ethernet:
                intent =  new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
                startActivity(intent);
                break;
            case R.id.btn_setting_netflow:
                intent =  new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS);
                startActivity(intent);
                break;
            case R.id.btn_setting_more:
                intent =  new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
                startActivity(intent);
                break;
            case R.id.btn_setting_usb:
                intent =  new Intent(Settings.ACTION_SETTINGS);
                startActivity(intent);
                break;
            case R.id.btn_setting_display:
                intent =  new Intent(Settings.ACTION_DISPLAY_SETTINGS);
                startActivity(intent);
                break;
            case R.id.btn_setting_warning_tone:
                intent =  new Intent(Settings.ACTION_SOUND_SETTINGS);
                startActivity(intent);
                break;
            case R.id.btn_setting_notification:
                intent =  new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS);
                startActivity(intent);
                break;
            case R.id.btn_setting_battery:
                intent =  new Intent(Settings.ACTION_BATTERY_SAVER_SETTINGS);
                startActivity(intent);
                break;
            case R.id.btn_setting_battery_safer:
                intent =  new Intent(Settings.ACTION_BATTERY_SAVER_SETTINGS);
                startActivity(intent);
                break;
            case R.id.btn_setting_application:
                intent =  new Intent(Settings.ACTION_APPLICATION_SETTINGS);
                startActivity(intent);
                break;
            case R.id.btn_setting_screen_capture:
                intent =  new Intent(Settings.ACTION_SETTINGS);
                startActivity(intent);
                break;
            case R.id.btn_setting_location:
                intent =  new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
                break;
            case R.id.btn_setting_safety:
                intent =  new Intent(Settings.ACTION_SECURITY_SETTINGS);
                startActivity(intent);
                break;
            default:break;
        }

    }
}
