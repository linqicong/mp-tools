package com.boal.wechat.model.message;


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

    /**
     * 视频消息媒体id,可以调用多媒体文件下载接口拉取数据
     */
    private String mediaId;

    /**
     * 视频消息缩略图的媒体id,可以调用多媒体文件下载接口拉取数据
     */
    private String thumbMediaId;

    /**
     * 视频消息的标题
     */
    private String title;

    /**
     * 视频消息的描述
     */
    private String description;

    public VideoMsg() {
        super();
        this.msgType = "video";
    }




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
