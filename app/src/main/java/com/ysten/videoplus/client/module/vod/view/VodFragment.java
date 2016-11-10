package com.ysten.videoplus.client.module.vod.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ysten.videoplus.client.BaseFragment;
import com.ysten.videoplus.client.R;
import com.ysten.videoplus.client.module.vod.adapter.VodAdapter;
import com.ysten.videoplus.client.module.vod.bean.VodBean;
import com.ysten.videoplus.client.module.vod.contract.VodContract;
import com.ysten.videoplus.client.module.vod.presenter.VodPresenter;
import com.ysten.videoplus.client.utils.LogCat;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：Picasso on 2016/10/12 10:10
 * 详情：点播
 */

public class VodFragment extends BaseFragment implements VodContract.View {

    private static VodFragment fragment = null;
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
    @BindView(R.id.vod_recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.fragment_vod_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    private Context mContext;
    private VodAdapter mAdapter;
    private VodPresenter mPresenter;
    private List<VodBean> mList = new ArrayList<>();

    public static VodFragment newInstance() {
        if (fragment == null) {
            fragment = new VodFragment();
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
        View view = inflater.inflate(R.layout.fragment_vod_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new VodPresenter(this);

        initTitleBar();
        initView();
    }

    /**
     * 初始化
    */
    private void initView() {
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.brown);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 4);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        // 设置布局管理器
        mRecyclerView.setLayoutManager(gridLayoutManager);

        mAdapter = new VodAdapter(mContext,mList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new VodAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                LogCat.i("onItemClick,position="+position);
            }
        });

        refreshData();
    }


    /**
     * 初始化titlebar
     */
    private void initTitleBar() {
        ivLeft.setVisibility(View.GONE);
        ivRight.setVisibility(View.GONE);
        tvTitle.setText(R.string.vod_name);
    }



    /**
     * 更新数据
     */
    private void refreshData() {
        mPresenter.getMenuData();
    }

    @Override
    public void onSuccess(List<VodBean> response) {

        swipeRefreshLayout.setRefreshing(false);
        mList.clear();
        mList = response;
        LogCat.i("VOD FRAGMENT success mList.size="+mList.size());
        mAdapter.setData(mList);
    }
}
