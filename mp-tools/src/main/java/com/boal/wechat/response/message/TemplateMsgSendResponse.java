package com.boal.wechat.response.message;

import com.boal.wechat.model.Tag;
import com.boal.wechat.response.BaseResponse;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/22<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class TemplateMsgSendResponse extends BaseResponse {


    private String msgid;


    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    @Override
    public String toString() {
        return "TemplateMsgSendResponse{" +
                "msgid='" + msgid + '\'' +
                "} " + super.toString();
    }
}
