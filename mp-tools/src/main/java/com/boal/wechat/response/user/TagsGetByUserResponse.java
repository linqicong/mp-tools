package com.boal.wechat.response.user;

import com.boal.wechat.model.Tag;
import com.boal.wechat.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/22<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class TagsGetByUserResponse extends BaseResponse {

    @SerializedName("tagid_list")
    private List<String> tagidList;


    public List<String> getTagidList() {
        return tagidList;
    }

    public void setTagidList(List<String> tagidList) {
        this.tagidList = tagidList;
    }

    @Override
    public String toString() {
        return "TagsGetByUserResponse{" +
                "tagidList=" + tagidList +
                "} " + super.toString();
    }
}
