package com.boal.mptools;

import com.boal.wechat.api.WechatMpApi;
import com.boal.wechat.model.Template;
import com.boal.wechat.model.TemplateMessage;
import com.boal.wechat.model.message.TextMsg;
import com.boal.wechat.response.BaseResponse;
import com.boal.wechat.response.user.DownloadResponse;
import com.boal.wechat.util.GsonFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

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
public class MediaApiTest {
    @Autowired
    private WechatMpApi wechatMpApi;


    @Test
    public void uploadMedia(){
        TextMsg textMsg = new TextMsg("你好");
        textMsg.setToUser("oQTlxt53WkYwt2kHuCMc08WfAloI");
        BaseResponse response = wechatMpApi.mediaApi().uploadMedia("image",new File("C:/Users/Atos/Desktop/q.png"));
        System.out.println(GsonFactory.getGson().toJson(response));
    }

    @Test
    public void getMedia() throws IOException {
        DownloadResponse response = wechatMpApi.mediaApi().getMedia("fjFEN24daoaBZKQn6Nzaj_Dw8TaK0msAkW2SWfdkWVpyMkLDui3hPpqOFmaHZoLW");
        File zipFile=new File("C:/Users/Atos/Desktop/"+response.getFileName());
        ByteArrayOutputStream byteOSZip = response.getOutputStream();
        FileOutputStream fos2 = new FileOutputStream(zipFile);
        byteOSZip.writeTo(fos2);
        fos2.close();
        byteOSZip.close();
    }
}
