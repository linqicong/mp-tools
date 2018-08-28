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
public class VoiceMsg extends BasicMsg {

    /**
     * 语音消息媒体id,可以调用多媒体文件下载接口拉取数据
     */
    private String mediaId;
    /**
     * 语音格式,如amr,speex等
     */
    private String format;
    /**
     * 语音识别结果,UTF8编码
     */
    private String recognition;

    public VoiceMsg() {
        super();
        this.msgType = "voice";
    }



    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }


}
