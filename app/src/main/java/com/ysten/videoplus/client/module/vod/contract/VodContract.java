package com.ysten.videoplus.client.module.vod.contract;

import com.ysten.videoplus.client.module.BasePresenter;
import com.ysten.videoplus.client.module.BaseView;
import com.ysten.videoplus.client.module.vod.bean.VodBean;

import java.util.List;

/**
 * 作者：Picasso on 2016/8/31 20:54
 * 详情：契约类
 * 契约类来统一管理view与presenter的所有的接口，
 * 这种方式使得view与presenter中有哪些功能，一目了然，维护起来也方便
 */
public class VodContract {
    //mvp中的view层回调函数
    public interface View extends BaseView<Presenter> {
        void onSuccess(List<VodBean> response);
    }

    //mvp中的presenter层的回调函数
    public interface Presenter extends BasePresenter {
        void getMenuData();
    }
}
