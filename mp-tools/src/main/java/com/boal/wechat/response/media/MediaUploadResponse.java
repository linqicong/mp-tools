package com.boal.wechat.response.media;

import com.boal.wechat.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/28<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class MediaUploadResponse extends BaseResponse {

    private String type;

    @SerializedName("media_id")
    private String mediaId;

    @SerializedName("created_at")
    private long createdAt;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
