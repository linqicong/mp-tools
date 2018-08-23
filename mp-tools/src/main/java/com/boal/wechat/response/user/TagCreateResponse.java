package com.boal.wechat.response.user;

import com.boal.wechat.model.Tag;
import com.boal.wechat.response.BaseResponse;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/22<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class TagCreateResponse extends BaseResponse {


    private Tag tag;

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "TagCreateResponse{" +
                "tag=" + tag +
                "} " + super.toString();
    }
}
