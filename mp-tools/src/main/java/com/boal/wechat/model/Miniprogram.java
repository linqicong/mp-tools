package com.boal.wechat.model;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/27<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class Miniprogram extends BaseModel {
    private static final long serialVersionUID = 168293502407284790L;

    private String appid;
    private String pagepath;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }

    @Override
    public String toString() {
        return "Miniprogram{" +
                "appid='" + appid + '\'' +
                ", pagepath='" + pagepath + '\'' +
                "} " + super.toString();
    }
}
