package com.boal.wechat.api.impl;

import com.boal.wechat.api.UserApi;
import com.boal.wechat.config.WechatMpConfigs;
import com.boal.wechat.model.Tag;
import com.boal.wechat.process.RequestProcess;
import com.boal.wechat.request.user.*;
import com.boal.wechat.response.NoParamResponse;
import com.boal.wechat.response.user.*;
import com.boal.wechat.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/22<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class UserApiImpl extends BaseApiImpl implements UserApi {

    private RequestProcess requestProcess;



    public static UserApi getInstance(WechatMpConfigs wechatMpConfigs){
        UserApiImpl userApi = new UserApiImpl();
        userApi.setRequestProcess(new RequestProcess(wechatMpConfigs));
        return userApi;
    }

    private void setRequestProcess(RequestProcess requestProcess){
        this.requestProcess = requestProcess;
    }

    @Override
    public UserInfoResponse getUserInfo(String openid, String lang) {
        UserInfoRequest request = new UserInfoRequest();
        request.setOpenId(openid);
        if (StringUtils.isEmpty(lang)){
            lang = "zh-cn";
        }
        request.setLang(lang);
        return requestProcess.doProcess(request);
    }

    @Override
    public NoParamResponse updateRemark(String openId, String remark) {
        RemarkUpdateRequest remarkUpdateRequest = new RemarkUpdateRequest();
        remarkUpdateRequest.setOpenId(openId);
        remarkUpdateRequest.setRemark(remark);
        return requestProcess.doProcess(remarkUpdateRequest);
    }

    @Override
    public TagCreateResponse createTag(Tag tag) {
        TagCreateRequest request = new TagCreateRequest();
        request.setTag(tag);
        return requestProcess.doProcess(request);
    }

    @Override
    public NoParamResponse delTag(Tag tag) {
        TagDeleteRequest request = new TagDeleteRequest();
        request.setTag(tag);
        return requestProcess.doProcess(request);
    }

    @Override
    public NoParamResponse updateTag(Tag tag) {
        TagUpdateRequest request = new TagUpdateRequest();
        request.setTag(tag);
        return requestProcess.doProcess(request);
    }

    @Override
    public TagsGetResponse getTags() {
        return requestProcess.doProcess(new TagsGetRequest());
    }

    @Override
    public TagsGetByUserResponse getTagsByUser(String openId) {
        TagsGetByUserRequest request = new TagsGetByUserRequest();
        request.setOpenId(openId);
        return requestProcess.doProcess(request);
    }

    @Override
    public NoParamResponse batchTagging(int tagid, List<String> openidList) {
        UserBatchTaggingRequest request = new UserBatchTaggingRequest();
        request.setTagid(tagid);
        request.setOpenidList(openidList);
        return requestProcess.doProcess(request);
    }

    @Override
    public NoParamResponse batchUnTagging(int tagid, List<String> openidList) {
        UserBatchUnTaggingRequest request = new UserBatchUnTaggingRequest();
        request.setTagid(tagid);
        request.setOpenidList(openidList);
        return requestProcess.doProcess(request);
    }

    @Override
    public UserGetByTagResponse getUsersByTagResponse(int tagid, String nextOpenid) {
        UserGetByTagRequest request = new UserGetByTagRequest();
        request.setTagid(tagid);
        request.setNextOpenid(nextOpenid);
        return requestProcess.doProcess(request);
    }

    @Override
    public UserInfoBatchGetResponse batchGetUsers(List<String> openIds, String lang) {
        final String flang = lang;
        List<Map<String,Object>> list =openIds.stream().map(s -> {
            Map<String,Object> map = new HashMap<>();
            map.put("openid",s);
            map.put("lang",flang);
            return map;
        }).collect(Collectors.toList());
        UserInfoBatchGetRequest request = new UserInfoBatchGetRequest();
        request.setUserList(list);
        return requestProcess.doProcess(request);
    }

    @Override
    public UserListResponse getUserList(String nextOpenId) {
        UserListRequest request = new UserListRequest();
        request.setNextOpenid(nextOpenId);
        return requestProcess.doProcess(request);
    }

    @Override
    public BlackListResponse getBlackList(String nextOpenId) {
        BlackListRequest request = new BlackListRequest();
        request.setNextOpenid(nextOpenId);
        return requestProcess.doProcess(request);
    }

    @Override
    public NoParamResponse batchBlackList(List<String> openIds) {
        BlackListBatchRequest request = new BlackListBatchRequest();
        request.setOpenidList(openIds);
        return requestProcess.doProcess(request);
    }

    @Override
    public NoParamResponse batchUnBlackList(List<String> openIds) {
        BlackListBatchUnRequest request = new BlackListBatchUnRequest();
        request.setOpenidList(openIds);
        return requestProcess.doProcess(request);
    }


}
