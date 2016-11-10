package com.ysten.videoplus.client.module.load.bean;

import java.util.List;

/**
 * 作者：Picasso on 2016/9/1 10:43
 * 详情：
 */
public class BIMSBean {

    /**
     * resultcode : 111
     * screenId :
     * ystenId : 00000000008615720316641920000001
     * sysconfig : [{"key":"BIMS_APK_UPDATE","text":"http://bimsboot.ysten.com:8081/yst-bims-facade/"},{"key":"BIMS_APK_UPDATE_RESULT","text":"http://bimsboot.ysten.com:8083/yst-bims-device-api/"},{"key":"BIMS_SOCIAL_ADDR","text":"http://social.cmsc.taipan.ysten.com:80"},{"key":"BIMS_XMPP_REGION","text":"http://msg.cmsc.taipan.ysten.com"},{"key":"BIMS_MYLOOK_NEW","text":"http://myepg.cmsc.taipan.ysten.com:8080"},{"key":"BIMS_MULTISCREEN","text":"http://mc.cmsc.taipan.ysten.com:8080"},{"key":"BIMS_LIVE_TEMPLATEID","text":"0282"},{"key":"BIMS_SEARCH","text":"http://vipersearch.cmsc.ysten.com:8080/viper-search/"},{"key":"BIMS_MOBILE_LOADING","text":"http://images.is.ysten.com/images/ysten/images/PANEL_image/icon/mbh/loading.png"},{"key":"BIMS_MOBILE_RECOMMEND","text":"http://images.is.ysten.com:8080/images/ysten/images/phone_application/recommendlist.xml"},{"key":"BIMS_SEEN","text":"http://seen.cmsc.ysten.com:80"},{"key":"BIMS_MOBILE_LIVE_LOOK_GROUPID","text":"66666"},{"key":"BIMS_MOBILE_EPG_GROUPID","text":"51000004"},{"key":"BIMS_EPGVIPER","text":"http://epg.is.ysten.com:8080"},{"key":"BIMS_PHONEAPK","text":"http://mc.cmsc.taipan.ysten.com:8080/download/ScreenMovingTaiPan0810.apk"},{"key":"BIMS_MOBILE_MSG","text":"http://mc.cmsc.taipan.ysten.com:8080/yst-ms-facade"},{"key":"BIMS_LIVE_EPG","text":"http://looktvepg.sc.ysten.com:7070"},{"key":"BIMS_SHOW_OLYMPIC_FLOATWINDOW","text":""},{"key":"BIMS_MOBILE_LIVE_CCTV5","text":"http://218.205.238.198:8080/ysten-businessmbble/live/cctv-5/24075572.m3u8"},{"key":"BIMS_IP_DINGXIANG","text":"http://218.205.238.198"},{"key":"BIMS_VIDEO_SHARE_SERVICE","text":"http://wxh5.ysten.com"},{"key":"BIMS_CLOUD_SERVICE","text":"http://ysten.b0.upaiyun.com"},{"key":"STBext","text":"{\"deviceGroupIds\":[],\"userGroupIds\":[],\"districtCode\":\"\",\"abilities\":[\"4K-0\"]}"},{"key":"BIMS_LIVE_OPEN_FLAG","text":"1"},{"key":"BIMS_FILTER_LIBRARY_URL","text":"http://ysten.b0.upaiyun.com/upgrade/wordfilter.txt.zip"}]
     */

    private String resultcode;
    private String screenId;
    private String ystenId;
    /**
     * key : BIMS_APK_UPDATE
     * text : http://bimsboot.ysten.com:8081/yst-bims-facade/
     */

    private List<SysconfigBean> sysconfig;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public String getYstenId() {
        return ystenId;
    }

    public void setYstenId(String ystenId) {
        this.ystenId = ystenId;
    }

    public List<SysconfigBean> getSysconfig() {
        return sysconfig;
    }

    public void setSysconfig(List<SysconfigBean> sysconfig) {
        this.sysconfig = sysconfig;
    }

    public static class SysconfigBean {
        private String key;
        private String text;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
