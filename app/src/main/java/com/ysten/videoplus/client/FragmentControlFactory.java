package com.ysten.videoplus.client;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.ysten.videoplus.client.module.flow.view.FlowFragment;
import com.ysten.videoplus.client.module.live.view.LiveFragment;
import com.ysten.videoplus.client.module.person.view.PersonFragment;
import com.ysten.videoplus.client.module.vod.view.VodFragment;
import com.ysten.videoplus.client.module.watchlist.view.WatchListFragment;

/**
 * 作者：Picasso on 2016/10/12 10:04
 * 详情：fragent工厂，生产fragment
 */

public class FragmentControlFactory {
    private static FragmentControlFactory instance;
    private static Context mContext;

    private FragmentControlFactory(Context context) {

    }


    public static synchronized FragmentControlFactory getInstance(Context context) {
        if (instance == null) {
            instance = new FragmentControlFactory(context);
        }
        return instance;
    }


    public Fragment getFragment(int i) {
        Fragment fragment = null;
        switch (i) {
            case 0:
                fragment = WatchListFragment.newInstance();
                break;
            case 1:
                fragment = VodFragment.newInstance();
                break;
            case 2:
                fragment = LiveFragment.newInstance();
                break;
            case 3:
                fragment = FlowFragment.newInstance();
                break;
            case 4:
                fragment = PersonFragment.newInstance();
                break;
        }
        return fragment;
    }
}
