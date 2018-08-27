package com.boal.mptools;

import com.boal.wechat.api.WechatMpApi;
import com.boal.wechat.enums.MenuType;
import com.boal.wechat.model.Menu;
import com.boal.wechat.response.BaseResponse;
import com.boal.wechat.response.user.UserInfoBatchGetResponse;
import com.boal.wechat.response.user.UserInfoResponse;
import com.boal.wechat.util.GsonFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
public class MenuApiTest {
    @Autowired
    private WechatMpApi wechatMpApi;

    @Test
    public void createMenu(){
        List<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu("baidu",MenuType.VIEW,"http://www.baidu.com"));
        Menu menu2 = new Menu("baidu2");

        menu2.getSubButtons().add(new Menu("baidu",MenuType.VIEW,"http://www.baidu.com"));
        menuList.add(menu2);

        BaseResponse response = wechatMpApi.menuApi().createMenu(menuList);
        System.out.println(GsonFactory.getGson().toJson(response));
    }

    @Test
    public void getMenus(){
        BaseResponse response = wechatMpApi.menuApi().getMenus();
        System.out.println(GsonFactory.getGson().toJson(response));
    }

    @Test
    public void delMenus(){
        BaseResponse response = wechatMpApi.menuApi().delMenus();
        System.out.println(GsonFactory.getGson().toJson(response));
    }
}
