package com.ysten.videoplus.client.retrofit;

import com.ysten.videoplus.client.module.vod.bean.ProgramSeriesBean;
import com.ysten.videoplus.client.module.vod.bean.VodBean;

import java.util.List;
import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * 作者：Picasso on 2016/10/12 17:16
 * 详情：点播的所有接口
 */

public interface ApiVod {

    //获取点播一级菜单
//    @POST("web/getcatgiteminfo.json")
//    Call<List<VodBean>> getcatgiteminfo(@QueryMap Map<String,String> map);

    // 获取点播一级菜单
    // RxJava
    @POST("web/getcatgiteminfo.json")
    Observable<List<VodBean>> getcatgiteminfo(@QueryMap Map<String,String> map);


    //获取点播内容列表
    @POST("web/getMovieList.json")
    Observable<ProgramSeriesBean> getMovieList(@QueryMap Map<String,String> map);
}
