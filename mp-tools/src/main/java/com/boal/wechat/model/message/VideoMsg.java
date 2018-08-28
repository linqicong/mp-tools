package com.boal.wechat.model.message;


import com.google.gson.annotations.SerializedName;

import java.util.Map;
/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/27<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class VideoMsg extends BasicMsg {



    public VideoMsg() {
        super();
        this.msgType = "video";
    }






    @SerializedName("video")
    private ParamContent paramContent = new ParamContent();


    public ParamContent getParamContent() {
        return paramContent;
    }

    public static class ParamContent {
        /**
         * 视频消息媒体id,可以调用多媒体文件下载接口拉取数据
         */
        @SerializedName("media_id")
        private String mediaId;

        /**
         * 视频消息缩略图的媒体id,可以调用多媒体文件下载接口拉取数据
         */
        @SerializedName("thumb_media_id")
        private String thumbMediaId;

        /**
         * 视频消息的标题
         */
        private String title;

        /**
         * 视频消息的描述
         */
        private String description;


        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }

    public String getMediaId() {
        return this.paramContent.mediaId;
    }

    public void setMediaId(String mediaId) {
        this.paramContent.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return this.paramContent.thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.paramContent.thumbMediaId = thumbMediaId;
    }

    public String getTitle() {
        return this.paramContent.title;
    }

    public void setTitle(String title) {
        this.paramContent.title = title;
    }

    public String getDescription() {
        return this.paramContent.description;
    }

    public void setDescription(String description) {
        this.paramContent.description = description;
    }

}
