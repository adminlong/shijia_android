package com.ysten.videoplus.client.module.load.bean;

/**
 * 作者：Picasso on 2016/9/1 14:46
 * 详情：
 */
public class RequestBIMS {

    /**
     * imei : 861572031664192
     * imsi : 861572031664192
     * deviceCode : 000000000000000
     * ystenId : 00000000008615720316641920000001
     * mac : 9c:a5:c0:18:53:2a
     * phoneNum :
     * version : 6.2.160706_multitest
     * appType :
     * channelId : SCMBH
     */

    private String imei;
    private String imsi;
    private String deviceCode;
    private String ystenId;
    private String mac;
    private String phoneNum;
    private String version;
    private String appType;
    private String channelId;

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getYstenId() {
        return ystenId;
    }

    public void setYstenId(String ystenId) {
        this.ystenId = ystenId;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
