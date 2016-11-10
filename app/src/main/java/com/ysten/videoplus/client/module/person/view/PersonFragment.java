package com.ysten.videoplus.client.module.person.view;

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
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 作者：Picasso on 2016/10/12 10:11
 * 详情：我的fragment界面
 */

public class PersonFragment extends BaseFragment {

    private static PersonFragment fragment = null;
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
    @BindView(R.id.circle_image)
    CircleImageView circleImage;

    private Context mContext;

    public static PersonFragment newInstance() {
        if (fragment == null) {
            fragment = new PersonFragment();
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
        View view = inflater.inflate(R.layout.fragment_person_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initTitleBar();

        String url = "http://ysten.b0.upaiyun.com/uploads/20160905/3hjoq1974558njjb7aw4phwrrlt6rwry.jpg";
        ImageLoader.getInstance().showImage(mContext,url,circleImage);
    }

    private void initTitleBar() {
        ivLeft.setVisibility(View.GONE);
        ivRight.setImageResource(R.drawable.scan_btn);
        tvTitle.setText(R.string.personal_name);
    }

    @OnClick(R.id.rl_right)
    public void startScan(){
        //TODO something
    }
}
