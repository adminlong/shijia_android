package com.ysten.videoplus.client.module.load.model;

import com.google.gson.Gson;
import com.ysten.videoplus.client.App;
import com.ysten.videoplus.client.module.BaseModelCallBack;
import com.ysten.videoplus.client.module.load.bean.BIMSBean;
import com.ysten.videoplus.client.module.load.bean.RequestBIMS;
import com.ysten.videoplus.client.utils.Constants;
import com.ysten.videoplus.client.utils.HttpUtil;
import com.ysten.videoplus.client.utils.LogCat;
import com.ysten.videoplus.client.utils.SaveValueToShared;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者：Picasso on 2016/8/31 21:01
 * 详情：Model层，实现逻辑
 */
public class LoadWindowModel {
    /**
     * 网络请求操作
     *
     * @param baseModelCallBack 从Presenter中传来的回调对象
     */
    public void getBIMS(final BaseModelCallBack baseModelCallBack) {

        RequestBIMS bims = new RequestBIMS();
        bims.setImei("861572031664192");
        bims.setImsi("861572031664192");
        bims.setDeviceCode("000000000000000");
        bims.setYstenId("00000000008615720316641920000001");
        bims.setMac("9c:a5:c0:18:53:2a");
        bims.setPhoneNum("");
        bims.setVersion("6.2.160706_multitest");
        bims.setAppType("");
        bims.setChannelId("X2GWTP");

        Gson gson = new Gson();
        String route = gson.toJson(bims);//通过Gson将Bean转化为Json字符串形式
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), route);

//        Call<BIMSBean> call = HttpUtil.getInstance().apiBIMS().getBims(body);
//        call.enqueue(new Callback<BIMSBean>() {
//            @Override
//            public void onResponse(Call<BIMSBean> call, Response<BIMSBean> response) {
//
//                if(response.code()== Constants.HTTP_OK){
//
//                    Map<String,String> bootEcho = parseBootEcho(response);
//
//                    saveToSP(bootEcho);
//                    baseModelCallBack.onResponse(response.body());
//                }else{
//                    baseModelCallBack.onError();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BIMSBean> call, Throwable t) {
//                baseModelCallBack.onFailure(t);
//            }
//        });

        HttpUtil.getInstance().apiBIMS().getBims(body)
                .doOnNext(new Action1<BIMSBean>() {
                    @Override
                    public void call(BIMSBean bimsBean) {
                        LogCat.i("getBims doONNext");
                        Map<String, String> bootEcho = parseBootEcho(bimsBean);
                        saveToSP(bootEcho);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BIMSBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        baseModelCallBack.onFailure(e);
                    }

                    @Override
                    public void onNext(BIMSBean bimsBean) {

                        baseModelCallBack.onResponse(bimsBean);
                    }
                });
    }

    /**
     * 保存数据到SharedPreferences
     *
     * @param bootEcho
     */
    private void saveToSP(Map<String, String> bootEcho) {
        // 点播epg域名
        String epg = bootEcho.get(Constants.KEY_BIMS_EPGVIPER);
        // vod ID
        String epgId = bootEcho.get(Constants.KEY_BIMS_MOBILE_EPG_GROUPID);
        // 敏感词库
        String wordFilter = bootEcho.get(Constants.KEY_BIMS_FILTER_LIBRARY_URL);

        SaveValueToShared.getInstance().saveToSP(App.singleton, SaveValueToShared.P_EPG, epg);
        SaveValueToShared.getInstance().saveToSP(App.singleton, SaveValueToShared.P_EPGID, epgId);
        SaveValueToShared.getInstance().saveToSP(App.singleton, SaveValueToShared.P_WFURL, wordFilter);
    }


    /**
     * 这里对于返回的对象要做下处理，以便后面方便保存
     *
     * @param response
     * @return
     */
    private Map<String, String> parseBootEcho(BIMSBean response) {
        List<BIMSBean.SysconfigBean> list = response.getSysconfig();
        Map<String, String> map = new HashMap<>();

        for (BIMSBean.SysconfigBean bean : list) {
            map.put(bean.getKey(), bean.getText());
        }
        map.put("resultcode", response.getResultcode());
        map.put("screenId", response.getScreenId());
        map.put("ystenId", response.getYstenId());

        return map;

    }

}
