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
public class UserGetByTagResponse extends BaseResponse {

    private int count;

    private List<String> openid = new ArrayList<>();

    private String next_openid;

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

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }

    @Override
    public String toString() {
        return "UserGetByTagResponse{" +
                "count=" + count +
                ", openid=" + openid +
                ", next_openid='" + next_openid + '\'' +
                "} " + super.toString();
    }
}
