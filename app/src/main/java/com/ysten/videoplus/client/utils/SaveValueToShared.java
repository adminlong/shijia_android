package com.ysten.videoplus.client.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 作者：Picasso on 2016/10/11 10:50
 * 详情：
 */

public class SaveValueToShared {

    private String spName = "shijia_sp";/*SharedPreferences的名称*/


    public static final String P_SERVERTIMEDIFFER = "serverTimeDifference";
    public static final String P_XMPPADDRESS = "xmppAddress";
    public static final String P_SOCIAL = "social";
    public static final String P_UPDATE = "update";
    public static final String P_SHAREHOST = "shareHost";
    public static final String P_APIDOMAIN = "apiDomain";
    public static final String P_APKURL = "apkUrl";
    // Broadcast广播key------end
    public static final String P_IP = "dingxiangLiuliangIp";
    public static final String P_STBEXT = "STBext";
    public static final String P_WFURL = "WF_URL";
    public static final String P_MYLOOK_NEW = "mylook_new";
    public static final String P_YSTENID = "ystenId";
    public static final String P_IPINFO = "IPInfo";
    public static final String P_EPG = "epg";
    public static final String P_EPGID = "epgId";
    public static final String P_EPGLOW = "epgLow";
    public static final String P_EPGDOMAIN = "epgDomain";
    public static final String P_LIVE = "live";
    public static final String P_LIVEID = "liveId";
    public static final String P_LIVEDOMAIN = "liveDomain";
    public static final String P_KANDIAN = "kanDian";
    public static final String P_KANDIANID = "kanDianID";
    public static final String P_USERCENTER = "userCenter";
    public static final String P_MC = "mc";
    public static final String P_MSG = "msg";
    public static final String P_MYLOOK = "myLook";
    public static final String P_LOADING = "loading";
    public static final String P_SEARCH = "search";
    public static final String P_RECOMMEND = "recommend";
    public static final String P_KANDANCENTER = "kandanCenter";
    public static final String P_BIMSDOMAIN = "bimsDomain";//是否播放直播节目
    public static final String P_DISABLEMODULE = "disableModule";//屏蔽哪些功能
    public static final String P_OFFLINECOLUMN = "offlineColumn";//屏蔽哪些功能
    public static final String P_OFFLINECHANNEL = "offlineChannel";//屏蔽哪些功能
    public static final String P_ORDERHOST = "orderHost";//是否播放直播节目
    public static final String P_LOGGER = "logger";//是否播放直播节目
    public static final String P_THUMB = "thumb";//是否播放直播节目
    public static final String P_PAY = "pay";//是否播放直播节目
    public static final String P_ALBUM = "album";//是否播放直播节目
    public static final String P_LIVEOPEN = "liveOpen";//是否播放直播节目
    public static final String P_ALBUMUPLOAD = "albumUpload";//是否播放直播节目
    public static final String P_CHATROOMTYPE = "chatroomType";// 聊天室类型
    public static final String P_PLAYSERIES = "playSeriesNum";// 播放到第几集
    public static final String P_UID = "uid";// 登陆用户的uid
    public static final String N_UID = "n_uid";// 匿名用户的uid
    public static final String P_IDENTIFYCODE = "identifyCode";// 用户数据是否过期标识
    public static final String P_USERQR = "userQR";// 登陆用户的uid
    public static final String P_TVIP = "tvIp";// (isLan)电视ip地址用于投屏和遥控器
    public static final String P_DEVICECODE = "devicecode";// (isLan)设备号
    public static final String P_ACTIVITYNAME = "activityName";
    public static final String P_DEVICE_ID = "device_id";// deviceId保存默认选择的关联设备id
    public static final String P_DEVICE_UUID = "device_uuid";// 保存生成的uuid
    public static final String P_TIME_FRIENDLIST = "friendList";// 获取朋友列表时间戳
    public static final String P_TIME_PERSONALWATCHLIST = "personalWatchList";// 获取个人看单时间戳
    public static final String P_TIME_WATCHLIST = "watchList";// 获取看单时间戳
    public static final String P_TIME_CHANNELDATA = "channelData";// 获取频道列表时间戳
    public static final String P_TIME_CATGMENU = "catgMenu";// 获取点播菜单时间戳
    public static final String P_TIME_SECONDCATGMENU = "catgSecondMenu";// 获取点播二级菜单时间戳
    public static final String P_TIME_PROGRAMINFO = "prigramInfo";// 获取频道节目单时间戳
    public static final String P_TIME_KANDANMYSELF = "kandanMyself";// 获取我的看单时间戳
    public static final String P_TIME_KANDANRECOMMOND = "kandanRecommond";// 获取推荐看单时间戳
    public static final String P_TIME_KANDANFRIEND = "kandanFreind";// 获取好友看单时间戳
    public static final String P_TIME_DEVICES = "devices";// 获取关联设备时间戳
    public static final String P_HOTWORDS = "hotwords";// 热词
    public static final String P_SEARCHHISTORY = "searchHistory";// 搜索历史
    public static final long P_TIME_ADAY = 24 * 3600 * 1000;// 一天
    public static final long P_TIME_HALFDAY = 12 * 3600 * 1000;// 半天
    public static final long P_TIME_TWOHOURS = 2 * 3600 * 1000;// 2小时
    public static final long P_TIME_HALFHOUR = 30 * 60 * 1000;// 半小时
    public static final long P_TIME_10MINS = 10 * 60 * 1000;// 十分钟
    public static final long P_TIME_5MINS = 5 * 60 * 1000;// 五分钟
    public static final long P_TIME_1MINS = 1 * 60 * 1000;// 一分钟
    public static final long P_TIME_HALFMINS = 1 * 30 * 1000;// 半分钟
    public static final String P_USERAUTH = "userAuth";
    public static final String P_CONTACTAUTH = "contactAuth";
    public static final String P_NEWSAUTH = "newsAuth";
    public static final String P_NOTIFYAUTH = "notifyAuth";
    public static final String P_ADVAUTH = "advAuth";
    public static final String P_FIRSTRUN = "firstrun";


    private static SaveValueToShared instance = null;
    public static SaveValueToShared getInstance(){
        if(instance == null){
            instance = new SaveValueToShared();
        }
        return instance;
    }
    
    public void saveToSP(Context mContext, String key, Boolean value) {
        SharedPreferences sPreferences = mContext.getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public void saveToSP(Context mContext, String key, String value){
        SharedPreferences sPreferences = mContext.getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void saveToSP(Context mContext, String key, int value){
        SharedPreferences sPreferences = mContext.getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public void saveToSP(Context mContext,  String key, long value){
        SharedPreferences sPreferences = mContext.getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.putLong(key, value);
        editor.commit();
    }
    public void saveToSP(Context mContext,  String key, float value){
        SharedPreferences sPreferences = mContext.getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    public Boolean getBooleanFromSP(Context mContext,  String key){
        SharedPreferences sPreferences = mContext.getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sPreferences.getBoolean(key, false);
    }

    public Boolean getBooleanFromSP(Context mContext,  String key,boolean value){
        SharedPreferences sPreferences = mContext.getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sPreferences.getBoolean(key, value);
    }

    public String getStringFromSP(Context mContext,  String key, String value){
        SharedPreferences sPreferences = mContext.getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sPreferences.getString(key, value);
    }

    public int getIntFromSP(Context mContext,  String key, int value){
        SharedPreferences sPreferences = mContext.getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sPreferences.getInt(key, value);
    }

    public long getLongFromSP(Context mContext,  String key, long value){
        SharedPreferences sPreferences = mContext.getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sPreferences.getLong(key, value);
    }
    public float getFloatFromSP(Context mContext,  String key, float value){
        SharedPreferences sPreferences = mContext.getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sPreferences.getFloat(key, value);
    }
}
