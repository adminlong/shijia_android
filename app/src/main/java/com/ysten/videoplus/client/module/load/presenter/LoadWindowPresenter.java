package com.ysten.videoplus.client.module.load.presenter;

import com.ysten.videoplus.client.module.BaseModelCallBack;
import com.ysten.videoplus.client.module.load.bean.BIMSBean;
import com.ysten.videoplus.client.module.load.contract.LoadWindowContract;
import com.ysten.videoplus.client.module.load.model.LoadWindowModel;

/**
 * 作者：Picasso on 2016/8/31 20:58
 * 详情：Presenter，主要作为一个桥梁，Model 去访问一个网站数据，解析回来，Presenter通过View 接口回调给界面显示
 */
public class LoadWindowPresenter implements LoadWindowContract.Presenter{

//    private TestModel mModel;

    private LoadWindowContract.View mView;
    private LoadWindowModel mModel;

    public LoadWindowPresenter(LoadWindowContract.View view) {
        mView = view;
        mModel = new LoadWindowModel();
    }

    @Override
    public void getBIMS() {
        mModel.getBIMS(new BaseModelCallBack<BIMSBean>() {
            @Override
            public void onResponse(BIMSBean response) {
//                List<BIMSBean.SysconfigBean> list =  response.body().getSysconfig();
//
//                for(BIMSBean.SysconfigBean bean :list){
//                    String key = bean.getKey();
//                    String value = bean.getText();
//
//                    LogCat.i("present========> key="+key+"；value="+value);
//                }

                mView.onSuccess();
            }

            @Override
            public void onError() {

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
