package com.ysten.videoplus.client;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ysten.videoplus.client.greendao.DbCore;
import com.ysten.videoplus.client.greendao.VideoBeanDao;
import com.ysten.videoplus.client.module.vod.bean.VideoBean;
import com.ysten.videoplus.client.utils.LogCat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.content)
    FrameLayout content;
    @BindView(R.id.iv_watchlist)
    ImageView ivWatchlist;
    @BindView(R.id.tv_watchlist)
    TextView tvWatchlist;
    @BindView(R.id.ll_watchlist)
    LinearLayout llWatchlist;
    @BindView(R.id.iv_vod)
    ImageView ivVod;
    @BindView(R.id.tv_vod)
    TextView tvVod;
    @BindView(R.id.ll_vod)
    LinearLayout llVod;
    @BindView(R.id.iv_living)
    ImageView ivLiving;
    @BindView(R.id.tv_living)
    TextView tvLiving;
    @BindView(R.id.ll_living)
    LinearLayout llLiving;
    @BindView(R.id.iv_flow)
    ImageView ivFlow;
    @BindView(R.id.tv_flow)
    TextView tvFlow;
    @BindView(R.id.ll_flow)
    LinearLayout llFlow;
    @BindView(R.id.newMsgTip_img)
    ImageView newMsgTipImg;
    @BindView(R.id.iv_person)
    ImageView ivPerson;
    @BindView(R.id.tv_person)
    TextView tvPerson;
    @BindView(R.id.ll_person)
    LinearLayout llPerson;
    private Fragment mCurrentFragment = new Fragment();
    private long currentTimeMillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSelect(0);

        //GreenDao test demo
        VideoBeanDao videoBeanDao = DbCore.getDaoSession().getVideoBeanDao();
        VideoBean bean = new VideoBean();
        bean.setName("麻雀");
        bean.setTitle("第三集");
        bean.setUrl("www.baidu.com");
        bean.setPic("");
        videoBeanDao.insertOrReplace(bean);
    }

    public void setSelect(int i) {
        resetView();
        switch (i) {
            case 0:
                ivWatchlist.setImageResource(R.drawable.watchlist_selected);
                tvWatchlist.setTextColor(ContextCompat.getColor(this,R.color.colorPrimary));
                break;
            case 1:
                ivVod.setImageResource(R.drawable.vod_selected);
                tvVod.setTextColor(ContextCompat.getColor(this,R.color.colorPrimary));
                break;
            case 2:
                ivLiving.setImageResource(R.drawable.living_selected);
                tvLiving.setTextColor(ContextCompat.getColor(this,R.color.colorPrimary));
                break;
            case 3:
                ivFlow.setImageResource(R.drawable.flow_selected);
                tvFlow.setTextColor(ContextCompat.getColor(this,R.color.colorPrimary));
                break;
            case 4:
                ivPerson.setImageResource(R.drawable.person_selected);
                tvPerson.setTextColor(ContextCompat.getColor(this,R.color.colorPrimary));
                break;
        }
        Fragment fragment = FragmentControlFactory.getInstance(MainActivity.this).getFragment(i);
        switchFragment(fragment);
    }

    private void switchFragment(Fragment newFragment) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        LogCat.i("newFragment isAdded=" + newFragment.isAdded());
        if (newFragment.isAdded()) {
            //.setCustomAnimations(R.anim.fragment_anim_left_in,R.anim.fragment_anim_right_out)
            transaction.hide(mCurrentFragment).show(newFragment).commitAllowingStateLoss();
        } else {
            transaction.hide(mCurrentFragment).add(R.id.content, newFragment).commitAllowingStateLoss();
        }
        mCurrentFragment = newFragment;
    }

    /**
     * 重置图片
     */
    private void resetView() {

        ivWatchlist.setImageResource(R.drawable.watchlist_normal);
        ivVod.setImageResource(R.drawable.vod_normal);
        ivLiving.setImageResource(R.drawable.living_normal);
        ivFlow.setImageResource(R.drawable.flow_normal);
        ivPerson.setImageResource(R.drawable.person_normal);

        tvWatchlist.setTextColor(ContextCompat.getColor(this,R.color.font_color_gray_black));
        tvVod.setTextColor(ContextCompat.getColor(this,R.color.font_color_gray_black));
        tvLiving.setTextColor(ContextCompat.getColor(this,R.color.font_color_gray_black));
        tvFlow.setTextColor(ContextCompat.getColor(this,R.color.font_color_gray_black));
        tvPerson.setTextColor(ContextCompat.getColor(this,R.color.font_color_gray_black));

    }


    /**
     * 点击事件
     * @param view
     */
    @OnClick({R.id.ll_watchlist, R.id.ll_vod, R.id.ll_living, R.id.ll_flow, R.id.ll_person})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_watchlist:
                setSelect(0);
                break;
            case R.id.ll_vod:
                setSelect(1);
                break;
            case R.id.ll_living:
                setSelect(2);
                break;
            case R.id.ll_flow:
                setSelect(3);
                break;
            case R.id.ll_person:
                setSelect(4);
                break;
        }
    }


    @Override
    public void onBackPressed() {

        if (System.currentTimeMillis() - currentTimeMillis > 1000) {
            currentTimeMillis = System.currentTimeMillis();
            showToast(R.string.toast_exit_app_press_more);
        } else {
            finish();//否则退出程序
            LogCat.i("android.os.Process.myPid()="+android.os.Process.myPid());
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }
}
