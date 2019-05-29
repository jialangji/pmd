package com.jlj.pmd;

import android.app.Application;
import android.os.StrictMode;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;



public class AppContext extends Application {
    public static AppContext instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("QbSdk", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                Log.d("QbSdk", " onCoreInitFinished is " );
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
        //tbs 内核下载跟踪
        QbSdk.setTbsListener(new TbsListener() {
            @Override
            public void onDownloadFinish(int i) {
                //tbs 内核下载完成回调
                Log.d("QbSdk", " onDownloadFinish is " );
            }

            @Override
            public void onInstallFinish(int i) {
                //内核安装完成回调，
                Log.d("QbSdk", " onInstallFinish is " );
            }

            @Override
            public void onDownloadProgress(int i) {
                //下载进度监听
                Log.d("QbSdk", " onDownloadProgress is " );
            }
        });

        //android  7.0权限
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        builder.detectFileUriExposure();
        StrictMode.setVmPolicy(builder.build());

    }

    public static AppContext context() {
        return instance;
    }


}
