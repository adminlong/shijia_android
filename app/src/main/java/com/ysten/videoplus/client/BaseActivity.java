package com.ysten.videoplus.client;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * 作者：Picasso on 2016/8/31 17:55
 * 详情：
 */
public class BaseActivity extends AppCompatActivity {


    /**
     * android从4.0开始可以改变系统的字体大小，如果不重写以下函数的话，apk的字体会跟着变
     * @return
     */
    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }

    /**
     * toast弹框
     * @param toastStr
     */
    public void showToast(String toastStr){
        Toast.makeText(this,toastStr,Toast.LENGTH_SHORT).show();
    }

    /**
     * toast弹框
     * @param toastId
     */
    public void showToast(int toastId){
        Toast.makeText(this,toastId,Toast.LENGTH_SHORT).show();
    }
}
