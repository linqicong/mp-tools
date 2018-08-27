package com.boal.wechat.response.user;

import com.boal.wechat.model.User;
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
public class UserInfoBatchGetResponse extends BaseResponse {

    @SerializedName("user_info_list")
    private List<User> userList = new ArrayList<>();
}
