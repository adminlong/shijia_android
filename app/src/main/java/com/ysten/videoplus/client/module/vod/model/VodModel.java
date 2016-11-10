package com.ysten.videoplus.client.module.vod.model;

import com.ysten.videoplus.client.App;
import com.ysten.videoplus.client.module.BaseModelCallBack;
import com.ysten.videoplus.client.module.vod.bean.ProgramSeriesBean;
import com.ysten.videoplus.client.module.vod.bean.VodBean;
import com.ysten.videoplus.client.utils.Constants;
import com.ysten.videoplus.client.utils.HttpUtil;
import com.ysten.videoplus.client.utils.LogCat;
import com.ysten.videoplus.client.utils.SaveValueToShared;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 作者：Picasso on 2016/8/31 21:01
 * 详情：Model层，实现逻辑
 */
public class VodModel {
    /**
     * 网络请求操作
     *
     * @param baseModelCallBack 从Presenter中传来的回调对象
     */
    public void getMenuData(final BaseModelCallBack baseModelCallBack) {


        String templateId = SaveValueToShared.getInstance().getStringFromSP(App.singleton, SaveValueToShared.P_EPGID, Constants.TEMPLATE_ID);

        Map<String, String> map = new HashMap<>();
        map.put("catgItemId", "1");
        map.put("pageNumber", "1");
        map.put("pageSize", "100");
        map.put("templateId", templateId);
        map.put("STBext", Constants.STBext);

//        Call<List<VodBean>> call = HttpUtil.getInstance().apiVod().getcatgiteminfo(map);
//
//        call.enqueue(new Callback<List<VodBean>>() {
//            @Override
//            public void onResponse(Call<List<VodBean>> call, Response<List<VodBean>> response) {
//                if(response.code()==Constants.HTTP_OK){
//                    baseModelCallBack.onResponse(response.body());
//                }else{
//                    baseModelCallBack.onError();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<VodBean>> call, Throwable t) {
//                baseModelCallBack.onFailure(t);
//            }
//        });

        HttpUtil.getInstance().apiVod().getcatgiteminfo(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<VodBean>>() {
                    @Override
                    public void onCompleted() {
                        //当不会再有新的 onNext() 发出时，需要触发 onCompleted() 方法作为标志
                        LogCat.i("getcatgiteminfo onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        baseModelCallBack.onFailure(e);
                    }

                    @Override
                    public void onNext(List<VodBean> vodBeen) {
                        LogCat.i("getcatgiteminfo onNext");
                        baseModelCallBack.onResponse(vodBeen);
                    }
                });

        /**
         * 当 RxJava 形式的时候，Retrofit 把请求封装进 Observable ，
         * 在请求结束后调用 onNext() 或在请求失败后调用 onError()。
         *
         * 对比来看， Callback 形式和 Observable 形式长得不太一样，但本质都差不多，
         * 而且在细节上 Observable 形式似乎还比 Callback 形式要差点。
         * 那 Retrofit 为什么还要提供 RxJava 的支持呢？请看LoadWindowModel
         */
    }


    /**
     * 下面的代码只是为了讲解rxjava的用法，无其他用处
     */
    private void rxTest() {
        //RxJava最核心的两个东西是Observables（被观察者，事件源）和Subscribers（观察者）。Observables发出一系列事件，Subscribers处理这些事件。
        //通过subscribe函数就可以将我们定义的myObservable对象和mySubscriber对象关联起来，这样就完成了subscriber对observable的订阅。

        final String str = "Hello";
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext(str);
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("Observable.create onCompleted");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("Observable.create onNext s=" + s + "\n");
            }
        });

        //create() 方法是 RxJava 最基本的创造事件序列的方法。基于这个方法， RxJava 还提供了一些方法用来快捷创建事件队列,
        //just(T...) 的例子和 from(T[]) 的例子，都和之前的 create(OnSubscribe) 的例子是等价的。
        Observable.just("hello", "world")
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("Observable.just onNext s=" + s);
                    }
                });

        //上面的例子中，我们其实并不关心OnComplete和OnError，我们只需要在onNext的时候做一些处理，这时候就可以使用Action1类。
        Observable.just("helloworld")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println("s=" + s);
                    }
                });


        //map,filter不讲了，提一下flatmap
        Map<String, String> mapTest = new HashMap<>();
        HttpUtil.getInstance().apiVod().getcatgiteminfo(mapTest)
                .flatMap(new Func1<List<VodBean>, Observable<ProgramSeriesBean>>() {
                    @Override
                    public Observable<ProgramSeriesBean> call(List<VodBean> vodBeen) {
                        return HttpUtil.getInstance().apiVod().getMovieList(new HashMap<String, String>());
                    }
                })
//                .flatMap()
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber（Observer） 的回调发生在主线程
                .subscribe(new Observer<ProgramSeriesBean>() {
                    @Override
                    public void onCompleted() {
                        //当不会再有新的 onNext() 发出时，需要触发 onCompleted() 方法作为标志
                        LogCat.i("getcatgiteminfo onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    //                    @Override
                    public void onNext(ProgramSeriesBean vodBeen) {
                        LogCat.i("getcatgiteminfo onNext");
                    }
                });
    }
}
