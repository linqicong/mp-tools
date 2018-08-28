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
public class ImageMsg extends BasicMsg {



    public ImageMsg() {
        super();
        this.msgType = "image";
    }


    @SerializedName("image")
    private ParamContent paramContent = new ParamContent();


    public ParamContent getParamContent() {
        return paramContent;
    }

    public static class ParamContent {
        /**
         * 图片消息媒体id，可以调用多媒体文件下载接口拉取数据
         */
        @SerializedName("media_id")
        private String mediaId;


        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

    }

    public String getMediaId() {
        return this.paramContent.mediaId;
    }

    public void setMediaId(String mediaId) {
        this.paramContent.mediaId = mediaId;
    }



}
