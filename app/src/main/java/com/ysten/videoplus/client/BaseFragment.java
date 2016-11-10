package com.ysten.videoplus.client;

import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * 作者：Picasso on 2016/10/11 11:43
 * 详情：
 */

public class BaseFragment extends Fragment{


    /**
     * toast弹框
     * @param toastStr
     */
    public void showToast(String toastStr){
        Toast.makeText(this.getActivity(),toastStr,Toast.LENGTH_SHORT).show();
    }

    /**
     * toast弹框
     * @param toastId
     */
    public void showToast(int toastId){
        Toast.makeText(this.getActivity(),toastId,Toast.LENGTH_SHORT).show();
    }
}
