package com.ysten.videoplus.client.module.watchlist.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ysten.videoplus.client.BaseFragment;
import com.ysten.videoplus.client.R;
import com.ysten.videoplus.client.utils.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：Picasso on 2016/10/12 10:09
 * 详情：看单
 */

public class WatchListFragment extends BaseFragment {

    private static WatchListFragment fragment = null;
    @BindView(R.id.image_demo)
    ImageView imageDemo;
    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.rl_left)
    RelativeLayout rlLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.rl_right)
    RelativeLayout rlRight;
    private Context mContext;

    public static WatchListFragment newInstance() {
        if (fragment == null) {
            fragment = new WatchListFragment();
        }
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_watchlist_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initTitleBar();
        //举例Picasso封装使用
        String url = "http://images.is.ysten.com:8080/poster/2016-09-13/94fa96906a044451ac99b5a9dfa08111.jpg";
        ImageLoader.getInstance().showImage(mContext, url, imageDemo);
    }

    private void initTitleBar() {
        ivLeft.setVisibility(View.GONE);
        ivRight.setVisibility(View.GONE);
        tvTitle.setText("节目单");
    }

}
