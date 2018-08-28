package com.boal.wechat.model.message;

import java.util.Map;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/27<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class LocationMsg extends BasicMsg {

    /**
     * 地理位置维度
     */
    private String x;
    /**
     * 地理位置经度
     */
    private String y;
    /**
     * 地图缩放大小
     */
    private int scale;
    /**
     * 地理位置信息
     */
    private String label;

    public LocationMsg() {
        super();
        this.msgType = "location";
    }



    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


}
