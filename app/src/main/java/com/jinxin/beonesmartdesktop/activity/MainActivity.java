package com.jinxin.beonesmartdesktop.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.jinxin.beonesmartdesktop.R;
import com.jinxin.beonesmartdesktop.base.BaseActivity;
import com.jinxin.beonesmartdesktop.fragment.ApplicationFragment;
import com.jinxin.beonesmartdesktop.fragment.DevicesFragment;
import com.jinxin.beonesmartdesktop.fragment.HomeFragment;
import com.jinxin.beonesmartdesktop.fragment.MineFragment;
import com.jinxin.beonesmartdesktop.fragment.RecreationFragment;
import com.jinxin.beonesmartdesktop.fragment.SettingFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.btn_navbar_home) LinearLayout mBtnNavbarHome;
    @BindView(R.id.btn_navbar_recreation) LinearLayout mBtnNavbarRecreation;
    @BindView(R.id.btn_navbar_devices) LinearLayout mBtnNavbarDevices;
    @BindView(R.id.btn_navbar_application) LinearLayout mBtnNavbarApplication;
    @BindView(R.id.btn_navbar_mine) LinearLayout mBtnNavbarMine;
    @BindView(R.id.btn_navbar_setting) LinearLayout mBtnNavbarSetting;
    @BindView(R.id.vp_show) ViewPager mViewPager;

    //适配器
    private FragmentPagerAdapter mAdapter;
    //装载Fragment的集合
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

        mBtnNavbarHome.setOnClickListener(this);
        mBtnNavbarRecreation.setOnClickListener(this);
        mBtnNavbarDevices.setOnClickListener(this);
        mBtnNavbarApplication.setOnClickListener(this);
        mBtnNavbarMine.setOnClickListener(this);
        mBtnNavbarSetting.setOnClickListener(this);

        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new RecreationFragment());
        mFragments.add(new DevicesFragment());
        mFragments.add(new ApplicationFragment());
        mFragments.add(new MineFragment());
        mFragments.add(new SettingFragment());

        //初始化适配器
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {//从集合中获取对应位置的Fragment
                return mFragments.get(position);
            }
            @Override
            public int getCount() {//获取集合中Fragment的总数
                return mFragments.size();
            }

        };
        //设置ViewPager的适配器
        mViewPager.setAdapter(mAdapter);
        //设置ViewPager的切换监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            //页面滚动事件
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            //页面选中事件
            @Override
            public void onPageSelected(int position) {
                //设置position对应的集合中的Fragment
                mViewPager.setCurrentItem(position);
                selectTab(position);
            }
            @Override
            //页面滚动状态改变事件
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void resetBackground() {
        mBtnNavbarHome.setBackground(getDrawable(R.drawable.navbar_background));
        mBtnNavbarRecreation.setBackground(getDrawable(R.drawable.navbar_background));
        mBtnNavbarDevices.setBackground(getDrawable(R.drawable.navbar_background));
        mBtnNavbarApplication.setBackground(getDrawable(R.drawable.navbar_background));
        mBtnNavbarMine.setBackground(getDrawable(R.drawable.navbar_background));
        mBtnNavbarSetting.setBackground(getDrawable(R.drawable.navbar_background));
    }

    private void selectTab(int i) {
        resetBackground();
        //根据点击的Tab设置对应的ImageButton为绿色
        switch (i) {
            case 0:
                mBtnNavbarHome.setBackground(getDrawable(R.drawable.navbar_background_selected));
                break;
            case 1:
                mBtnNavbarRecreation.setBackground(getDrawable(R.drawable.navbar_background_selected));
                break;
            case 2:
                mBtnNavbarDevices.setBackground(getDrawable(R.drawable.navbar_background_selected));
                break;
            case 3:
                mBtnNavbarApplication.setBackground(getDrawable(R.drawable.navbar_background_selected));
                break;
            case 4:
                mBtnNavbarMine.setBackground(getDrawable(R.drawable.navbar_background_selected));
                break;
            case 5:
                mBtnNavbarSetting.setBackground(getDrawable(R.drawable.navbar_background_selected));
                break;

        }
        //设置当前点击的Tab所对应的页面
        mViewPager.setCurrentItem(i);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_navbar_home:selectTab(0);break;
            case R.id.btn_navbar_recreation:selectTab(1);break;
            case R.id.btn_navbar_devices:selectTab(2);break;
            case R.id.btn_navbar_application:selectTab(3);break;
            case R.id.btn_navbar_mine:selectTab(4);break;
            case R.id.btn_navbar_setting:selectTab(5);break;
        }


    }
}
