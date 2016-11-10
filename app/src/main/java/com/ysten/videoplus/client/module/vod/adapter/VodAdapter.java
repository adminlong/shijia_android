package com.ysten.videoplus.client.module.vod.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysten.videoplus.client.R;
import com.ysten.videoplus.client.module.vod.bean.VodBean;
import com.ysten.videoplus.client.utils.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：Picasso on 2016/10/12 16:44
 * 详情：
 */

public class VodAdapter extends RecyclerView.Adapter<VodAdapter.ViewHolder> {

    private List<VodBean> mList = new ArrayList<>();
    private Context mContext;

    /**
     * add onItemClick begin
     */
    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        mOnItemClickListener = listener;
    }


    public VodAdapter(Context context, List<VodBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vod_item_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String catgName = mList.get(position).getCatgName();
        int drawableId = getResource("_" + mList.get(position).getCatgId());

        holder.gridText.setText(catgName);
        ImageLoader.getInstance().showLocalIDImage(mContext,drawableId,holder.gridImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(view, position);
                }
            }
        });
    }

    public void setData(List<VodBean> list){
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    /**
     * 获取图片名称获取图片的资源id的方法
     *
     * @param imageName
     * @return
     */
    public int getResource(String imageName) {
        if (TextUtils.isEmpty(imageName)) {
            return 0;
        }
        int resId = mContext.getResources().getIdentifier(imageName,
                "drawable", mContext.getApplicationContext().getPackageName());
        return resId;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.grid_image)
        ImageView gridImage;
        @BindView(R.id.grid_text)
        TextView gridText;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
