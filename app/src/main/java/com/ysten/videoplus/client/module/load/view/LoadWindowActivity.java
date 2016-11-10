package com.ysten.videoplus.client.module.load.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.ysten.videoplus.client.BaseActivity;
import com.ysten.videoplus.client.MainActivity;
import com.ysten.videoplus.client.R;
import com.ysten.videoplus.client.module.load.contract.LoadWindowContract;
import com.ysten.videoplus.client.module.load.presenter.LoadWindowPresenter;

/**
 * 欢迎页
 */
public class LoadWindowActivity extends BaseActivity implements LoadWindowContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_window);

        registerMobile();
    }

    /**
     * 注册手机，未注册手机先向bims注册并存储ystenID，已注册手机则进行匿名用户登录和后续操作
     */
    private void registerMobile() {
        //TODO 先不做注册手机，直接boot，后续改
        LoadWindowPresenter presenter = new LoadWindowPresenter(this);
        presenter.getBIMS();
    }

    /**
     * 成功回调
     */
    @Override
    public void onSuccess() {

        //做个简单的延时操作
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LoadWindowActivity.this, MainActivity.class));
                finish();
            }
        }, 2 * 1000);


    }
}
