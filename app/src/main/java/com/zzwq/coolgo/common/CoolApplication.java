package com.zzwq.coolgo.common;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;

import com.alipay.euler.andfix.patch.PatchManager;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.SDKInitializer;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.zzwq.coolgo.R;
import com.zzwq.coolgo.util.ToastUtil;
import com.zzwq.coolgo.R;
import com.uuzuche.lib_zxing.ZApplication;
import com.yolanda.nohttp.NoHttp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import c.b.BP;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.update.BmobUpdateAgent;

/**
 * Created by asus on 2016/8/30.
 */
public class CoolApplication extends ZApplication {

    // 此为支付插件的官方最新版本号,请在更新时留意更新说明
    private static final int PLUGINVERSION = 7;
    private static CoolApplication appContext;
    private boolean flag = true;
    private List<BDLocation> mLocations = new ArrayList<>();
    private PatchManager mPatchManager;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;

        //NoHttp初始化
        NoHttp.initialize(this);
        //Fresco初始化
        Fresco.initialize(this);
        //百度地图初始化
        SDKInitializer.initialize(this);
        //Bmob初始化
        Bmob.initialize(this, AppConstant.BMOB_AppID);
        //热更新
        initAndfix();

        //Bmob检查更新
        if (flag) {
            flag = false;
            BmobUpdateAgent.initAppVersion();
        }
    }

    private void initAndfix() {
        //初始化patch管理类
        mPatchManager = new PatchManager(this);
        mPatchManager.init("1.0");//补丁版本
        mPatchManager.loadPatch();//加载补丁

        try {
            String path = "/data/data/com.myxh.coolshopping/";//补丁所在路径
            mPatchManager.addPatch(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CoolApplication getAppContext() {
        return appContext;
    }

    public List<BDLocation> getLocations() {
        return mLocations;
    }

    public void setLocations(List<BDLocation> locations) {
        mLocations = locations;
    }

    public String getAppVersion() {
        PackageManager manager = this.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(this.getPackageName(),0);
            String version = info.versionName;
            return this.getString(R.string.current_version) + version;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return this.getString(R.string.version_unknown);
        }
    }

    public String getAppPackageName() {
        PackageManager manager = this.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(this.getPackageName(),0);
            String packageName = info.packageName;
            return packageName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "com.netease.edu.study";
        }
    }
}
