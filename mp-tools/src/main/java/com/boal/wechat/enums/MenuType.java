package com.boal.wechat.enums;

import com.google.gson.annotations.SerializedName;

public enum MenuType {

    /**
     * 菜单的响应动作类型
     * <p/>
     * click: 点击推事件
     * <p/>
     * view: 跳转URL
     * <p/>
     * scancode_push: 扫码推事件
     * <p/>
     * scancode_waitmsg: 扫码推事件
     * <p/>
     * pic_sysphoto: 弹出系统拍照发图
     * <p/>
     * pic_photo_or_album: 弹出拍照或者相册发
     * <p/>
     * pic_weixin: 弹出微信相册发图器
     * <p/>
     * location_select: 弹出地理位置选择器
     * <p/>
     * media_id: 下发消息(除文本消息)
     * <p/>
     * view_limited: 跳转图文消息URL
     * miniprogram: 跳转图文消息URL
     * <p/>
     */
    @SerializedName("click")
    CLICK,
    @SerializedName("view")
    VIEW,
    @SerializedName("scancode_push")
    SCANCODE_PUSH,
    @SerializedName("scancode_waitmsg")
    SCANCODE_WAITMSG,
    @SerializedName("pic_sysphoto")
    PIC_SYSPHOTO,
    @SerializedName("pic_photo_or_album")
    PIC_PHOTO_OR_ALBUM,
    @SerializedName("pic_weixin")
    PIC_WEIXIN,
    @SerializedName("location_select")
    LOCATION_SELECT,
    @SerializedName("media_id")
    MEDIA_ID,
    @SerializedName("view_limited")
    VIEW_LIMITED,
    @SerializedName("miniprogram")
    MINIPROGRAM,
    ;
}
