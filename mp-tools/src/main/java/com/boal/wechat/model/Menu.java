package com.boal.wechat.model;


import com.boal.wechat.enums.MenuType;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义菜单
 *
 * @author boal
 */
public class Menu extends BaseModel {

    private static final long serialVersionUID = 5068357646623964955L;
    /**
     * 菜单标题，不超过16个字节，子菜单不超过40个字节
     */
    private String name;

    /**
     * 点击类型菜单KEY值，用于消息接口推送，不超过128字节
     */
    private String key;


    private MenuType type;

    /**
     * 网页链接，用户点击菜单可打开链接，不超过256字节
     */
    private String url;

    /**
     * 二级菜单
     */
    @SerializedName(value = "sub_button")
    private List<Menu> subButtons = new ArrayList<>();


    private String appid;

    private String pagepath;


    @SerializedName("media_id")
    private String mediaId;
    /**
     * 构造函数
     */
    public Menu() {}

    public Menu(String name, MenuType type, String url) {
        this.name = name;
        this.type = type;
        this.url = url;
    }

    /**
     * 一级菜单构造函数
     * 
     * @param name
     *            菜单名字
     */
    public Menu(String name) {
        setName(name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Menu> getSubButtons() {
        return subButtons;
    }

    public void setSubButtons(List<Menu> subButtons) {
        this.subButtons = subButtons;
    }



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
}
