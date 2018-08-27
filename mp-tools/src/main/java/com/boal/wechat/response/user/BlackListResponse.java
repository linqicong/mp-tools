package com.boal.wechat.response.user;

import com.boal.wechat.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/17<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class BlackListResponse extends BaseResponse {


    private int total;

    private int count;

    private List<String> openid = new ArrayList<>();

    @SerializedName("next_openid")
    private String nextOpenid;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getOpenid() {
        return openid;
    }

    public void setOpenid(List<String> openid) {
        this.openid = openid;
    }

    public String getNextOpenid() {
        return nextOpenid;
    }

    public void setNextOpenid(String nextOpenid) {
        this.nextOpenid = nextOpenid;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "BlackListResponse{" +
                "total=" + total +
                ", count=" + count +
                ", openid=" + openid +
                ", nextOpenid='" + nextOpenid + '\'' +
                "} " + super.toString();
    }
}
