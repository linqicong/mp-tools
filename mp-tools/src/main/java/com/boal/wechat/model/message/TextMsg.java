package com.boal.wechat.model.message;


import com.boal.wechat.request.user.UserListRequest;
import com.google.gson.annotations.SerializedName;

import java.util.Map;
/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/27<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class TextMsg extends BasicMsg {

    @SerializedName("text")
    private ParamContent paramContent = new ParamContent();

    public TextMsg() {
        super();
        this.msgType = "text";
    }
    public TextMsg(String content) {
        super();
        super.msgType = "text";
        this.paramContent.setContent(content);
    }

    public ParamContent getParamContent() {
        return paramContent;
    }

    public static class ParamContent {
        @SerializedName("content")
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
    public String getContent() {
        return this.paramContent.content;
    }

    public void setContent(String content) {
        this.paramContent.content = content;
    }

}
