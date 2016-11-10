package com.ysten.videoplus.client;

import android.app.Application;

import com.ysten.videoplus.client.greendao.DbCore;

import okhttp3.OkHttpClient;

/**
 * 作者：Picasso on 2016/8/31 17:39
 * 详情：
 */
public class App extends Application {
    public static App singleton = null;

    private OkHttpClient client;

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;

        //初始化greenDao
        DbCore.init(singleton,"ShiJia.db");
        DbCore.enableQueryBuilderLog();
    }

}