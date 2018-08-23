package com.boal.wechat.request.user;

import com.boal.wechat.enums.PostMethod;
import com.boal.wechat.request.BaseRequest;
import com.boal.wechat.response.NoParamResponse;
import com.boal.wechat.response.user.UserInfoResponse;
import com.google.gson.annotations.SerializedName;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/17<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class RemarkUpdateRequest extends BaseRequest<NoParamResponse> {

    private String url = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark";

    private PostMethod postMethod = PostMethod.POST;



    private ParamContent paramContent = new ParamContent();
    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public ParamContent getParamContent() {
        return paramContent;
    }

    @Override
    public Class<NoParamResponse> getResponseClass() {
        return NoParamResponse.class;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public PostMethod getPostMethod() {
        return postMethod;
    }

    public static class ParamContent {
        @SerializedName("openid")
        private String openId;

        @SerializedName("remark")
        private String remark;

        @Override
        public String toString() {
            return "ParamContent{" +
                    "openId='" + openId + '\'' +
                    ", remark='" + remark + '\'' +
                    '}';
        }

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
    public void setOpenId(String openId) {
        this.paramContent.openId = openId;
    }

    public String getRemark() {
        return this.paramContent.remark;
    }

    public void setRemark(String remark) {
        this.paramContent.remark = remark;
    }

    public String getOpenId() {
        return this.paramContent.openId;
    }
}
