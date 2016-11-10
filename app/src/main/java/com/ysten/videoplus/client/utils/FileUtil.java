package com.ysten.videoplus.client.utils;

import android.os.Environment;

import com.ysten.videoplus.client.App;

import java.io.File;

/**
 * 作者：Picasso on 2016/8/31 17:40
 * 详情：文件操作api
 */
public class FileUtil {
    private static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    public static File getAvailableCacheDir() {
        if (isExternalStorageWritable()) {
            return App.singleton.getExternalCacheDir();
        } else {
            return App.singleton.getCacheDir();
        }
    }
}
