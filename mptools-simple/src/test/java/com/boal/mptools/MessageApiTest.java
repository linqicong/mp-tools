package com.boal.mptools;

import com.boal.wechat.api.WechatMpApi;
import com.boal.wechat.model.Template;
import com.boal.wechat.model.TemplateMessage;
import com.boal.wechat.model.message.Article;
import com.boal.wechat.model.message.ImageMsg;
import com.boal.wechat.model.message.NewsMsg;
import com.boal.wechat.model.message.TextMsg;
import com.boal.wechat.response.BaseResponse;
import com.boal.wechat.util.GsonFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/27<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageApiTest {
    @Autowired
    private WechatMpApi wechatMpApi;

    @Test
    public void sendTemplateMsg(){
        TemplateMessage templateMessage = new TemplateMessage();
        templateMessage.setTouser("oQTlxt53WkYwt2kHuCMc08WfAloI");
        templateMessage.setTemplateId("su0yN_7UUFGXwOp1GTvezfEPsAc_KpozvjQlRvFJlMg");
        templateMessage.setUrl("www.baidu.com");
        templateMessage.getTemplates().add(new Template("first","tittle"));
        templateMessage.getTemplates().add(new Template("keyword1","结算时间"));
        templateMessage.getTemplates().add(new Template("keyword2","结算金额"));
        templateMessage.getTemplates().add(new Template("remark","remark"));

        BaseResponse response = wechatMpApi.messageApi().sendTemplateMsg(templateMessage);
        System.out.println(GsonFactory.getGson().toJson(response));
    }

    /**
     * 文本消息
     */
    @Test
    public void sendBasicMsg(){
        TextMsg textMsg = new TextMsg("你好");
        textMsg.setToUser("oQTlxt53WkYwt2kHuCMc08WfAloI");
        BaseResponse response = wechatMpApi.messageApi().sendBasicMsg(textMsg);
        System.out.println(GsonFactory.getGson().toJson(response));
    }

    /**
     * 图片消息
     */
    @Test
    public void sendImageMsg(){
        ImageMsg msg = new ImageMsg();
        msg.setToUser("oQTlxt53WkYwt2kHuCMc08WfAloI");
        msg.setMediaId("fjFEN24daoaBZKQn6Nzaj_Dw8TaK0msAkW2SWfdkWVpyMkLDui3hPpqOFmaHZoLW");
        BaseResponse response = wechatMpApi.messageApi().sendBasicMsg(msg);
        System.out.println(GsonFactory.getGson().toJson(response));
    }

    /**
     * 图文消息
     */
    @Test
    public void sendNewsMsg(){
        NewsMsg msg = new NewsMsg();
        msg.getArticles().add(new Article("百度","baidu","https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2920084749,2018893236&fm=58&s=39C718720E8EBE011B398BAC0300F024&bpow=121&bpoh=75","www.baidu.com"));
        msg.getArticles().add(new Article("谷歌","Google","http://www.google.cn/landing/cnexp/google-search.png","www.google.com"));
        msg.setToUser("oQTlxt53WkYwt2kHuCMc08WfAloI");
        BaseResponse response = wechatMpApi.messageApi().sendBasicMsg(msg);
        System.out.println(GsonFactory.getGson().toJson(response));
    }
}
