package com.boal.wechat.request.media;

import com.boal.wechat.enums.PostMethod;
import com.boal.wechat.request.BaseRequest;
import com.boal.wechat.response.media.MediaUploadResponse;
import com.boal.wechat.response.user.DownloadResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.File;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/28<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class MediaDownloadRequest extends BaseRequest<DownloadResponse> {
    private String url = "https://api.weixin.qq.com/cgi-bin/media/get";

    private PostMethod postMethod = PostMethod.DOWNLOAD_FILE;



    private ParamContent paramContent = new ParamContent();
    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public ParamContent getParamContent() {
        return paramContent;
    }

    @Override
    public Class<DownloadResponse> getResponseClass() {
        return DownloadResponse.class;
    }
    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public PostMethod getPostMethod() {
        return postMethod;
    }



    public static class ParamContent {

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
