package com.boal.wechat.request.media;

import com.boal.wechat.enums.PostMethod;
import com.boal.wechat.model.Menu;
import com.boal.wechat.request.BaseRequest;
import com.boal.wechat.request.menu.MenuCreateRequest;
import com.boal.wechat.response.NoParamResponse;
import com.boal.wechat.response.media.MediaUploadResponse;
import com.google.gson.annotations.Expose;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/28<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class MediaUploadRequest extends BaseRequest<MediaUploadResponse> {
    private String url = "https://api.weixin.qq.com/cgi-bin/media/upload";

    private PostMethod postMethod = PostMethod.POST_FILE;



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
    public Class<MediaUploadResponse> getResponseClass() {
        return MediaUploadResponse.class;
    }
    @Override
    public File getFile(){
        return getMedia();
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

        private String type;

        @Expose(serialize = false)
        private File media;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public File getMedia() {
            return media;
        }

        public void setMedia(File media) {
            this.media = media;
        }
    }
    public String getType() {
        return this.paramContent.type;
    }

    public void setType(String type) {
        this.paramContent.type = type;
    }

    public File getMedia() {
        return this.paramContent.media;
    }

    public void setMedia(File media) {
        this.paramContent.media = media;
    }

}
