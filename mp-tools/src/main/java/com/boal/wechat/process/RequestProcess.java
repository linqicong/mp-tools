package com.boal.wechat.process;

import com.boal.wechat.cache.RedisMemoryCache;
import com.boal.wechat.config.WechatMpConfigs;
import com.boal.wechat.enums.PostMethod;
import com.boal.wechat.exception.WechatMpApiException;
import com.boal.wechat.mapping.Converter;
import com.boal.wechat.request.BaseRequest;
import com.boal.wechat.response.AccessTokenResponse;
import com.boal.wechat.response.BaseResponse;
import com.boal.wechat.util.GsonFactory;
import com.boal.wechat.util.HttpsUtils;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/20<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class RequestProcess {
    public static final String INVALID_ACCESS_TOKEN_CODE = "40001";
    public static final String TIMEOUT_ACCESS_TOKEN_CODE = "42001";
    private static final String TOKEN_URL_FORMAT = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    private static final String REDIS_ACCESS_TOKEN_KEY_FORMAT = "com.boal.wechat.AccessToken-%s";

    private String appid;
    private String secret;
    private String accessTokenKey;
    private String token_url;
    private RedisMemoryCache redisMemoryCache;

    public RequestProcess(String appid, String secret, String host, Integer port, Integer timeout, String password, Integer database) {
        super();
        this.appid = appid;
        this.secret = secret;
        this.accessTokenKey = String.format(REDIS_ACCESS_TOKEN_KEY_FORMAT,appid);
        this.token_url = String.format(TOKEN_URL_FORMAT, appid,secret);
        this.redisMemoryCache = new RedisMemoryCache(host,port,timeout,password,database);
    }
    public RequestProcess(WechatMpConfigs wechatMpConfigs) {
        super();
        this.appid = wechatMpConfigs.getAppid();
        this.secret = wechatMpConfigs.getSecret();
        this.accessTokenKey = String.format(REDIS_ACCESS_TOKEN_KEY_FORMAT,appid);
        this.token_url = String.format(TOKEN_URL_FORMAT, appid,secret);
        this.redisMemoryCache = new RedisMemoryCache(wechatMpConfigs.getHost(), wechatMpConfigs.getPort(), wechatMpConfigs.getTimeout(), wechatMpConfigs.getPassword(), wechatMpConfigs.getDatabase());
    }
    public  <T extends BaseResponse> T doProcess(BaseRequest<T> request){
       return doProcess(request,2);
    }

    private  <T extends BaseResponse> T doProcess(BaseRequest<T> request,int retry){
        String url = getUrlWithAccessToken(request.getUrl());
        String result = null ;
        System.out.println(request.toJsonString());
        if (request.getPostMethod()== PostMethod.GET){
            result = HttpsUtils.doGet(url,request.toMap());
        }else if (request.getPostMethod() == PostMethod.POST){
            result =  HttpsUtils.doPost(url,request.toJsonString());
        }else if (request.getPostMethod() == PostMethod.DOWNLOAD_FILE){
            return (T) HttpsUtils.httpDownloadFile(url,request.toMap());
        } else {
            result = HttpsUtils.doPost(url,request.toMap(),request.getFile());
        }
        final String r1 = result;
        T responseBody = Converter.toResponse(result, request.getConverterFunction());
        if (!responseBody.isSuccess()){
            //access_token过期刷新token重试
            if ((INVALID_ACCESS_TOKEN_CODE.equals(responseBody.getCode())||TIMEOUT_ACCESS_TOKEN_CODE.equals(responseBody.getCode()))
                    && retry >0){
                refreshAccessToken();
                return doProcess(request,--retry);
            }else {
                throw new WechatMpApiException(responseBody.getCode(),responseBody.getMsg());
            }
        }
        return responseBody;
    }



    private  String getUrlWithAccessToken(String url){
        return url+"?access_token="+getAccessToken(false);
    }

    public  String getAccessToken(boolean refreshAccessToken){
        if (!refreshAccessToken){
            AccessTokenResponse token = (AccessTokenResponse) redisMemoryCache.getValue(AccessTokenResponse.class,accessTokenKey);
            if (token != null && token.isAvailable()){
                return token.getAccessToken();
            }
        }
        return refreshAccessToken().getAccessToken();
    }

    /**
     * 强制刷新微信服务凭证
     */
    public  synchronized AccessTokenResponse refreshAccessToken() {
        AccessTokenResponse response =  GsonFactory.getGson().fromJson(HttpsUtils.doGet(token_url),AccessTokenResponse.class);
        if (response!=null && response.isSuccess()){
            response.setExpiresTime(response.getExpiresIn());
            redisMemoryCache.setValue(accessTokenKey,response);
            redisMemoryCache.expireAt(accessTokenKey,response.getExpiresTime());
            return response;
        }else if (response != null){
            throw new WechatMpApiException(response.getCode(),response.getMsg());
        }else {
            throw new WechatMpApiException("500","强制刷新微信服务凭证：返回结果为空");
        }

    }

}
