package com.ysten.videoplus.client.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.ysten.videoplus.client.R;

/**
 * 作者：Picasso on 2016/8/31 16:23
 * 详情：
 */
public class ImageLoader {

    private static ImageLoader imageLoader = null;

    public static ImageLoader getInstance() {
        if (imageLoader == null) {
            imageLoader = new ImageLoader();
        }
        return imageLoader;
    }


    /**
     * 最简单的网络图片加载代码
     * @param context 对象
     * @param url 图片地址
     * @param imageView 需要显示的ImageView
     */
    public void showImage(Context context, String url, ImageView imageView) {
        //要先判断url是否为空，不然Picasso会报异常
        if(!TextUtils.isEmpty(url)){
            Picasso
                    .with(context)
                    .load(url)
                    .placeholder(R.drawable.place_holder_vertical)
                    .error(R.drawable.place_holder_vertical)
                    .into(imageView);
        }else{
            imageView.setBackgroundResource(R.drawable.place_holder_vertical);
        }

    }

    /**
     * 加载R.drawable.imgID的图片
     * @param context
     * @param id
     * @param imageView
     */
    public void showLocalIDImage(Context context, int id, ImageView imageView) {
        if(id==0){
            imageView.setBackgroundResource(R.drawable.place_holder_vertical);
        }else{
            Picasso
                    .with(context)
                    .load(id)
                    .placeholder(R.drawable.place_holder_vertical)
                    .error(R.drawable.place_holder_vertical)
                    .into(imageView);
        }
    }


    /**
     * 加载本地path的图片
     * @param context
     * @param path
     * @param imageView
     */
    public void showLocalPathImage(Context context, String path, ImageView imageView) {
        Picasso
                .with(context)
                .load(path)
                .placeholder(R.drawable.place_holder_vertical)
                .error(R.drawable.place_holder_vertical)
                .into(imageView);

    }
}
