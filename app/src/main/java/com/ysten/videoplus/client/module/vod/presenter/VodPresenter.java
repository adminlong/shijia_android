package com.ysten.videoplus.client.module.vod.presenter;

import com.ysten.videoplus.client.module.BaseModelCallBack;
import com.ysten.videoplus.client.module.vod.bean.VodBean;
import com.ysten.videoplus.client.module.vod.contract.VodContract;
import com.ysten.videoplus.client.module.vod.model.VodModel;

import java.util.List;

/**
 * 作者：Picasso on 2016/8/31 20:58
 * 详情：Presenter，主要作为一个桥梁，Model 去访问一个网站数据，解析回来，Presenter通过View 接口回调给界面显示
 */
public class VodPresenter implements VodContract.Presenter {

//    private TestModel mModel;

    private VodContract.View mView;
    private VodModel mModel;

    public VodPresenter(VodContract.View view) {
        mView = view;
        mModel = new VodModel();
    }


    @Override
    public void getMenuData() {
//        mModel.getMenuData(new BaseModelCallBack<List<VodBean>>() {
//            @Override
//            public void onResponse(List<VodBean> response) {
//                mView.onSuccess(response);
//            }
//
//            @Override
//            public void onError() {
//
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });


        mModel.getMenuData(new BaseModelCallBack<List<VodBean>>() {

                               @Override
                               public void onResponse(List<VodBean> response) {
                                   mView.onSuccess(response);
                               }

                               @Override
                               public void onError() {

                               }

                               @Override
                               public void onFailure(Throwable t) {

                               }
                           }
        );
    }
}
