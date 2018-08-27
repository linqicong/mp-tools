package com.boal.wechat.api;

import com.boal.wechat.model.Tag;
import com.boal.wechat.response.NoParamResponse;
import com.boal.wechat.response.user.*;
import com.sun.deploy.util.BlackList;

import java.util.List;

public interface UserApi {

    /**
     *
     * @param openid
     * @param lang
     * @return
     */
    public UserInfoResponse getUserInfo(String openid,String lang);

    /**
     * 修改备注
     * @param openId
     * @param remark
     * @return
     */
    public NoParamResponse updateRemark(String openId,String remark);

    /**
     * 创建标签
     * @param tag
     * @return
     */
    public TagCreateResponse createTag(Tag tag);

    /**
     * 刪除标签
     * @param tag
     * @return
     */
    public NoParamResponse delTag(Tag tag);

    /**
     * 修改标签
     * @param tag
     * @return
     */
    public NoParamResponse updateTag(Tag tag);

    /**
     * 获取公众号已创建的标签
     * @return
     */
    public TagsGetResponse getTags();

    /**
     *  获取标签下粉丝列表
     * @param openId
     * @return
     */
    public TagsGetByUserResponse getTagsByUser(String openId);

    /**
     *  批量为用户打标签
     * @param tagid
     * @param openidList
     * @return
     */
    public NoParamResponse batchTagging(int tagid,List<String> openidList);

    /**
     * 批量为用户取消标签
     * @param tagid
     * @param openidList
     * @return
     */
    public NoParamResponse batchUnTagging(int tagid,List<String> openidList);

    /**
     * 获取用户身上的标签列表
     * @param tagid
     * @param nextOpenid
     * @return
     */
    public UserGetByTagResponse getUsersByTagResponse(int tagid,String nextOpenid);

    /**
     * 批量拉取用户信息
     * @param openIds
     * @param lang
     * @return
     */
    public UserInfoBatchGetResponse batchGetUsers(List<String> openIds,String lang);

    /**
     * 获取用户列表
     * @param nextOpenId
     * @return
     */
    public UserListResponse getUserList(String nextOpenId);

    /**
     * 获取黑名单列表
     * @param nextOpenId
     * @return
     */
    public BlackListResponse getBlackList(String nextOpenId);

    /**
     * 批量添加黑名单
     * @param openIds
     * @return
     */
    public NoParamResponse batchBlackList(List<String> openIds);

    /**
     * 批量删除黑名单
     * @param openIds
     * @return
     */
    public NoParamResponse batchUnBlackList(List<String> openIds);
}
