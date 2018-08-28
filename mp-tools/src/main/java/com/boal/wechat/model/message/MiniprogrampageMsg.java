package com.boal.wechat.model.message;

import com.google.gson.annotations.SerializedName;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/27<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class MiniprogrampageMsg extends BasicMsg {



    public MiniprogrampageMsg() {
        super();
        this.msgType = "miniprogrampage";
    }

    public ParamContent getParamContent() {
        return paramContent;
    }
    @SerializedName("miniprogrampage")
    private ParamContent paramContent = new ParamContent();

    public static class ParamContent {
        /**
         * 文本内容
         */
        private String title;

        private String appid;

        @SerializedName("pagepath")
        private String pagePath;

        @SerializedName("thumb_media_id")
        private String thumbMediaId;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getPagePath() {
            return pagePath;
        }

        public void setPagePath(String pagePath) {
            this.pagePath = pagePath;
        }

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }
    }



    public String getTitle() {
        return this.paramContent.title;
    }

    public void setTitle(String title) {
        this.paramContent.title = title;
    }

    public String getAppid() {
        return this.paramContent.appid;
    }

    public void setAppid(String appid) {
        this.paramContent.appid = appid;
    }

    public String getPagePath() {
        return this.paramContent.pagePath;
    }

    public void setPagePath(String pagePath) {
        this.paramContent.pagePath = pagePath;
    }

    public String getThumbMediaId() {
        return this.paramContent.thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.paramContent.thumbMediaId = thumbMediaId;
    }

}
