package com.boal.wechat.api.impl;

import com.boal.wechat.api.MenuApi;
import com.boal.wechat.api.UserApi;
import com.boal.wechat.config.WechatMpConfigs;
import com.boal.wechat.model.Menu;
import com.boal.wechat.process.RequestProcess;
import com.boal.wechat.request.menu.MenuCreateRequest;
import com.boal.wechat.request.menu.MenuDelRequest;
import com.boal.wechat.request.menu.MenuGetRequest;
import com.boal.wechat.response.NoParamResponse;
import com.boal.wechat.response.menu.MenuGetResponse;

import java.util.List;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/27<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class MenuApiImpl implements MenuApi {
    private RequestProcess requestProcess;



    public static MenuApiImpl getInstance(WechatMpConfigs wechatMpConfigs){
        MenuApiImpl menuApi = new MenuApiImpl();
        menuApi.setRequestProcess(new RequestProcess(wechatMpConfigs));
        return menuApi;
    }

    private void setRequestProcess(RequestProcess requestProcess){
        this.requestProcess = requestProcess;
    }

    @Override
    public NoParamResponse createMenu(List<Menu> menuList) {
        MenuCreateRequest request = new MenuCreateRequest();
        request.setButton(menuList);
        return requestProcess.doProcess(request);
    }

    @Override
    public MenuGetResponse getMenus() {
        MenuGetRequest request = new MenuGetRequest();
        return requestProcess.doProcess(request);
    }

    @Override
    public NoParamResponse delMenus() {
        MenuDelRequest request = new MenuDelRequest();
        return requestProcess.doProcess(request);
    }
}
