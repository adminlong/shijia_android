package com.ysten.videoplus.client.retrofit;

import com.ysten.videoplus.client.module.load.bean.BIMSBean;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 作者：Picasso on 2016/9/1 10:55
 * 详情：BIMS相关的ApiService
 */
public interface ApiBIMS {

    @Headers({"Content-Type: application/json"})//这个接口需要添加头
    @POST("yst-bims-mobile-api/mobile/boot.json")
//    Call<BIMSBean> getBims(@Body RequestBody body);
    Observable<BIMSBean> getBims(@Body RequestBody body);
}
