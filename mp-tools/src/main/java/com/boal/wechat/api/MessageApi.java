package com.boal.wechat.api;

import com.boal.wechat.model.TemplateMessage;
import com.boal.wechat.model.message.BasicMsg;
import com.boal.wechat.response.NoParamResponse;
import com.boal.wechat.response.message.TemplateMsgSendResponse;

public interface MessageApi {

    /**
     *  发送模板消息
     * @param templateMessage
     * @return
     */
    public TemplateMsgSendResponse sendTemplateMsg(TemplateMessage templateMessage);

    /**
     * 发送客服消息
     * @param msg
     * @return
     */
    public NoParamResponse sendBasicMsg(BasicMsg msg);
}
