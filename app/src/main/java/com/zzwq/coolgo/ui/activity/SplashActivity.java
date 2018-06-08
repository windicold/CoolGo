package com.zzwq.coolgo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.zzwq.coolgo.R;
import com.zzwq.coolgo.common.LocationService;
import com.zzwq.coolgo.ui.base.BaseActivity;
import com.zzwq.coolgo.util.SharePreferenceUtil;

/**
 * Created by asus on 2016/8/28.
 */
public class SplashActivity extends BaseActivity {

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //开启定位服务
        startService(new Intent(this, LocationService.class));

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean isFirst = SharePreferenceUtil.getBoolean(SplashActivity.this,"isFirst",true);
                if (isFirst) {
                    SharePreferenceUtil.putBoolean(SplashActivity.this,"isFirst",false);
                    openActivity(GuideActivity.class);
                } else {
                    openActivity(MainActivity.class);
                }
                finish();
            }
        },2000);
    }

}
