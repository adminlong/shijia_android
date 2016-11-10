package com.ysten.videoplus.client.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.ysten.videoplus.client.App;
import com.ysten.videoplus.client.retrofit.ApiBIMS;
import com.ysten.videoplus.client.retrofit.ApiVod;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：Picasso on 2016/8/31 17:25
 * 详情：网络相关的一些常用方法
 */
public class HttpUtil {


    /******************************************************************
     * 域名URL                                                        *
     ******************************************************************/

    /**
     * boot启动地址
     */
    public static final String BOOT_URL = "http://bimsmobile.is.ysten.com:8084/";

    /******************************************************************
     * Retrofit api                                                   *
     ******************************************************************/
    private static HttpUtil util;
    private Cache cache;
    private ApiBIMS mApiBims;
    private ApiVod mApiVod;
    private int mTimeOut = 60;

    public HttpUtil() {
        //设置缓存 10M
        File httpCacheDirectory = new File(FileUtil.getAvailableCacheDir(), "responses");
        cache = new Cache(httpCacheDirectory, 20 * 1024 * 1024);
    }

    /**
     * 单例
     *
     * @return
     */
    public static HttpUtil getInstance() {
        if (util == null) {
            util = new HttpUtil();


        }
        return util;
    }

    /**
     * BIMS接口
     *
     * @return
     */
    public ApiBIMS apiBIMS() {
        if (mApiBims == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BOOT_URL)
                    .client(getClient(true))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mApiBims = retrofit.create(ApiBIMS.class);
        }
        return mApiBims;
    }

    /**
     * BIMS接口
     *
     * @return
     */
    public ApiVod apiVod() {

        String epg_host = SaveValueToShared.getInstance().getStringFromSP(App.singleton,SaveValueToShared.P_EPG,Constants.VOD_HOSTNAME);
        LogCat.i("epg_host="+epg_host);
        if (mApiVod == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(epg_host)
                    .client(getClient(true))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mApiVod = retrofit.create(ApiVod.class);
        }
        return mApiVod;
    }

    /**
     * OKHttp 初始化，加入插值器，缓存设置
     *
     * @return
     */
    private OkHttpClient getClient(boolean addHead) {
        OkHttpClient client;
        if (addHead) {
            client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .cache(cache)
                    .connectTimeout(mTimeOut, TimeUnit.SECONDS)
                    .readTimeout(mTimeOut, TimeUnit.SECONDS)
                    .writeTimeout(mTimeOut, TimeUnit.SECONDS)
                    .build();

        } else {
            client = new OkHttpClient.Builder()
                    .cache(cache)
                    .connectTimeout(mTimeOut, TimeUnit.SECONDS)
                    .readTimeout(mTimeOut, TimeUnit.SECONDS)
                    .writeTimeout(mTimeOut, TimeUnit.SECONDS)
                    .build();
        }

        return client;
    }


    /**
     * 插值器
     */
    Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request.Builder builder = chain.request().newBuilder();
//            builder.addHeader("User-Agent", "");
//            builder.addHeader("Accept", "application/json");
//            builder.addHeader("SFDeviceId", getIMEI());
//            builder.addHeader("Authorization", addImageHeader());

            Request request = builder.build();

//            Request request = chain.request();
            Response response = chain.proceed(request);
            LogCat.i("response = " + response);

            return response;
        }
    };

    /**
     * 获得IMEI
     *
     * @return
     */
    private String getIMEI() {

        String IMEI = ((TelephonyManager) App.singleton
                .getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();

        return IMEI;
    }
}
