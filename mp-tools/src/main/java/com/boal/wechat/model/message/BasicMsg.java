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
public class BasicMsg {

    /**
     * 微信公众号Id/OpenId
     */
    @SerializedName("touser")
    protected String toUser;

    /**
     * 消息创建时间 (整型)
     */
    protected int createTime;
    /**
     * 消息类型: text, image, voice ...
     */
    @SerializedName("msgtype")
    protected String msgType;
    /**
     * 消息Id, 64位整型
     */
    protected long msgId;

    /**
     * 默认构造方法
     */
    public BasicMsg() {
        this.createTime = Long.valueOf(System.currentTimeMillis() / 1000).intValue();
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

    @Override
    public String toString() {
        return "BasicMsg{" +
                "toUser='" + toUser + '\'' +
                ", createTime=" + createTime +
                ", msgType='" + msgType + '\'' +
                ", msgId=" + msgId +
                '}';
    }
}
