package com.boal.wechat.api.impl;

import com.boal.wechat.api.MessageApi;
import com.boal.wechat.config.WechatMpConfigs;
import com.boal.wechat.model.Menu;
import com.boal.wechat.model.TemplateMessage;
import com.boal.wechat.model.message.BasicMsg;
import com.boal.wechat.process.RequestProcess;
import com.boal.wechat.request.menu.MenuCreateRequest;
import com.boal.wechat.request.menu.MenuDelRequest;
import com.boal.wechat.request.menu.MenuGetRequest;
import com.boal.wechat.request.message.CustomMsgSendRequest;
import com.boal.wechat.request.message.TemplateMsgSendRequest;
import com.boal.wechat.response.NoParamResponse;
import com.boal.wechat.response.menu.MenuGetResponse;
import com.boal.wechat.response.message.TemplateMsgSendResponse;

import java.util.List;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/27<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class MessageApiImpl implements MessageApi {
    private RequestProcess requestProcess;

    public static MessageApiImpl getInstance(WechatMpConfigs wechatMpConfigs){
        MessageApiImpl messageApi = new MessageApiImpl();
        messageApi.setRequestProcess(new RequestProcess(wechatMpConfigs));
        return messageApi;
    }

    private void setRequestProcess(RequestProcess requestProcess){
        this.requestProcess = requestProcess;
    }


    @Override
    public TemplateMsgSendResponse sendTemplateMsg(TemplateMessage templateMessage) {
        TemplateMsgSendRequest request = new TemplateMsgSendRequest();
        request.setTemplateMessage(templateMessage);
        return requestProcess.doProcess(request);
    }

    @Override
    public NoParamResponse sendBasicMsg(BasicMsg msg) {
        CustomMsgSendRequest request = new CustomMsgSendRequest();
        request.setBasicMsg(msg);
        return requestProcess.doProcess(request);
    }
}
