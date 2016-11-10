package com.ysten.videoplus.client.module.vod.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 作者：Picasso on 2016/10/14 10:34
 * 详情：
 */
@Entity
public class VideoBean {
    @Id
    public Long id;
    public String name;
    public String title;
    public String url;
    public String pic;
    public String getPic() {
        return this.pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 90665172)
    public VideoBean(Long id, String name, String title, String url, String pic) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.url = url;
        this.pic = pic;
    }
    @Generated(hash = 2024490299)
    public VideoBean() {
    }
   
}
