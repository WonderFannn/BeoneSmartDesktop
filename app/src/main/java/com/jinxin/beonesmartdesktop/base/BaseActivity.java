package com.jinxin.beonesmartdesktop.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import butterknife.ButterKnife;

/**
 * Created by wangfan on 2017/11/3.
 */

public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        ButterKnife.bind(this);
//        EventBus.getDefault().register(this);
        initData();
    }

    protected abstract void initView();
    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }
}
