package com.boal.wechat.response.user;

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
public class TagsGetResponse extends BaseResponse {


    private List<Tag> tags;


    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "TagsGetResponse{" +
                "tags=" + tags +
                "} " + super.toString();
    }
}
