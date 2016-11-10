package com.ysten.videoplus.client.module.vod.bean;

import java.util.List;

/**
 * 作者：Picasso on 2016/10/12 17:21
 * 详情：
 */

public class VodBean {

    /**
     * catgId : 219721
     * parentCatgId : 1
     * catgName : 悦享专区
     * catgActionType : GetVPosterList
     * image :
     * outerImg :
     * childStyle : VERTICAL_SCREEN
     * subCatgs : [{"catgId":219724,"parentCatgId":219721,"catgName":"单点专区","catgActionType":"GetVPosterList","image":"","outerImg":"","childStyle":"VERTICAL_SCREEN","subCatgs":[]},{"catgId":219726,"parentCatgId":219721,"catgName":"优点影院","catgActionType":"GetVPosterList","image":"","outerImg":"","childStyle":"VERTICAL_SCREEN","subCatgs":[]},{"catgId":219909,"parentCatgId":219721,"catgName":"江西名师课堂","catgActionType":"GetVPosterList","image":"","outerImg":"","childStyle":"VERTICAL_SCREEN","subCatgs":[]},{"catgId":219872,"parentCatgId":219721,"catgName":"才智小天地","catgActionType":"GetVPosterList","image":"","outerImg":"","childStyle":"VERTICAL_SCREEN","subCatgs":[]}]
     */

    private int catgId;
    private int parentCatgId;
    private String catgName;
    private String catgActionType;
    private String image;
    private String outerImg;
    private String childStyle;
    /**
     * catgId : 219724
     * parentCatgId : 219721
     * catgName : 单点专区
     * catgActionType : GetVPosterList
     * image :
     * outerImg :
     * childStyle : VERTICAL_SCREEN
     * subCatgs : []
     */

    private List<SubCatgsBean> subCatgs;

    public int getCatgId() {
        return catgId;
    }

    public void setCatgId(int catgId) {
        this.catgId = catgId;
    }

    public int getParentCatgId() {
        return parentCatgId;
    }

    public void setParentCatgId(int parentCatgId) {
        this.parentCatgId = parentCatgId;
    }

    public String getCatgName() {
        return catgName;
    }

    public void setCatgName(String catgName) {
        this.catgName = catgName;
    }

    public String getCatgActionType() {
        return catgActionType;
    }

    public void setCatgActionType(String catgActionType) {
        this.catgActionType = catgActionType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOuterImg() {
        return outerImg;
    }

    public void setOuterImg(String outerImg) {
        this.outerImg = outerImg;
    }

    public String getChildStyle() {
        return childStyle;
    }

    public void setChildStyle(String childStyle) {
        this.childStyle = childStyle;
    }

    public List<SubCatgsBean> getSubCatgs() {
        return subCatgs;
    }

    public void setSubCatgs(List<SubCatgsBean> subCatgs) {
        this.subCatgs = subCatgs;
    }

    public static class SubCatgsBean {
        private int catgId;
        private int parentCatgId;
        private String catgName;
        private String catgActionType;
        private String image;
        private String outerImg;
        private String childStyle;
        private List<?> subCatgs;

        public int getCatgId() {
            return catgId;
        }

        public void setCatgId(int catgId) {
            this.catgId = catgId;
        }

        public int getParentCatgId() {
            return parentCatgId;
        }

        public void setParentCatgId(int parentCatgId) {
            this.parentCatgId = parentCatgId;
        }

        public String getCatgName() {
            return catgName;
        }

        public void setCatgName(String catgName) {
            this.catgName = catgName;
        }

        public String getCatgActionType() {
            return catgActionType;
        }

        public void setCatgActionType(String catgActionType) {
            this.catgActionType = catgActionType;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getOuterImg() {
            return outerImg;
        }

        public void setOuterImg(String outerImg) {
            this.outerImg = outerImg;
        }

        public String getChildStyle() {
            return childStyle;
        }

        public void setChildStyle(String childStyle) {
            this.childStyle = childStyle;
        }

        public List<?> getSubCatgs() {
            return subCatgs;
        }

        public void setSubCatgs(List<?> subCatgs) {
            this.subCatgs = subCatgs;
        }
    }
}
