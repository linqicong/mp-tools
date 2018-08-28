package com.boal.wechat.api.impl;

import com.boal.wechat.api.MediaApi;
import com.boal.wechat.config.WechatMpConfigs;
import com.boal.wechat.process.RequestProcess;
import com.boal.wechat.request.media.MediaDownloadRequest;
import com.boal.wechat.request.media.MediaUploadRequest;
import com.boal.wechat.response.NoParamResponse;
import com.boal.wechat.response.media.MediaUploadResponse;
import com.boal.wechat.response.user.DownloadResponse;

import java.io.File;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/28<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class MediaApiImpl implements MediaApi {

    private RequestProcess requestProcess;



    public static MediaApiImpl getInstance(WechatMpConfigs wechatMpConfigs){
        MediaApiImpl mediaApi = new MediaApiImpl();
        mediaApi.setRequestProcess(new RequestProcess(wechatMpConfigs));
        return mediaApi;
    }

    private void setRequestProcess(RequestProcess requestProcess){
        this.requestProcess = requestProcess;
    }


    @Override
    public MediaUploadResponse uploadMedia(String type, File media) {
        MediaUploadRequest request = new MediaUploadRequest();
        request.setType(type);
        request.setMedia(media);
        return requestProcess.doProcess(request);
    }

    @Override
    public DownloadResponse getMedia(String mediaId) {
        MediaDownloadRequest request = new MediaDownloadRequest();
        request.setMediaId(mediaId);
        return requestProcess.doProcess(request);
    }
}
