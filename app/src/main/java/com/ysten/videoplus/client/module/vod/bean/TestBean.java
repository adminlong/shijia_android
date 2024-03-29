package com.ysten.videoplus.client.module.vod.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 作者：Picasso on 2016/10/14 10:34
 * 详情：
 */
@Entity
public class TestBean {
    @Id
    public Long id;
    public String name;
    public String age;
    public String number;
    public String score;
    public String getScore() {
        return this.score;
    }
    public void setScore(String score) {
        this.score = score;
    }
    public String getNumber() {
        return this.number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
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
    @Generated(hash = 507955271)
    public TestBean(Long id, String name, String age, String number, String score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.number = number;
        this.score = score;
    }
    @Generated(hash = 2087637710)
    public TestBean() {
    }
}
