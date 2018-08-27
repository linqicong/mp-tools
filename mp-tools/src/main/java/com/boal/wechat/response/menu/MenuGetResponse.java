package com.boal.wechat.response.menu;

import com.boal.wechat.model.Menu;
import com.boal.wechat.model.Tag;
import com.boal.wechat.response.BaseResponse;

import java.util.List;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/22<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class MenuGetResponse extends BaseResponse {


    private List<Menu> button;

    public List<Menu> getButton() {
        return button;
    }

    public void setButton(List<Menu> button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "MenuGetResponse{" +
                "button=" + button +
                "} " + super.toString();
    }
}
