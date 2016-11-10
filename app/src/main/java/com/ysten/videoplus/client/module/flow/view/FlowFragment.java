package com.ysten.videoplus.client.module.flow.view;

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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：Picasso on 2016/10/12 10:13
 * 详情：
 */

public class FlowFragment extends BaseFragment {

    private static FlowFragment fragment = null;
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

    public static FlowFragment newInstance() {
        if (fragment == null) {
            fragment = new FlowFragment();
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
        View view = inflater.inflate(R.layout.fragment_flow_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initTitleBar();
    }

    private void initTitleBar() {
        ivLeft.setVisibility(View.GONE);
        ivRight.setVisibility(View.GONE);
        tvTitle.setText(R.string.flow);
    }

}
