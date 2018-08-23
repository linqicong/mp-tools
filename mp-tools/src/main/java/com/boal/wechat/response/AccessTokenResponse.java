package com.boal.wechat.response;

import com.boal.wechat.util.StringUtils;
import com.google.gson.annotations.SerializedName;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/20<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class AccessTokenResponse extends BaseResponse {

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("expires_in")
    private Long expiresIn;

    private Long expiresTime;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public Long getExpiresTime() {
        return this.expiresTime;
    }
    public void setExpiresTime(Long expiresIn){
        this.expiresTime = System.currentTimeMillis() + (expiresIn - 120) * 1000;
    }
    public void setExpiresIn(long expiresIn) {
        // 考虑到服务器时间同步,故将刷新时间提前120秒.
       this.expiresIn = expiresIn;
    }
    public boolean isAvailable() {
        if (!StringUtils.isEmpty(accessToken) && this.getExpiresTime() >= System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "AccessTokenResponse{" +
                "accessToken='" + accessToken + '\'' +
                ", expiresIn=" + expiresIn +
                "} " + super.toString();
    }
}
