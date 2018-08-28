package com.boal.wechat.api;

import com.boal.wechat.response.NoParamResponse;
import com.boal.wechat.response.media.MediaUploadResponse;
import com.boal.wechat.response.user.DownloadResponse;

import java.io.File;

public interface MediaApi {

    public MediaUploadResponse uploadMedia(String type, File media);

    public DownloadResponse getMedia(String mediaId);
}
