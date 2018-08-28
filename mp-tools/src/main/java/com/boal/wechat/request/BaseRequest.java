package com.boal.wechat.request;


import com.boal.wechat.enums.PostMethod;
import com.boal.wechat.response.BaseResponse;
import com.boal.wechat.util.BeanUtil;
import com.boal.wechat.util.GsonFactory;
import com.google.gson.Gson;

import java.io.File;
import java.util.Map;
import java.util.function.Function;

/**
 * 
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/8/17<br/>
 * @author Boal Lin
 * 
 */
public abstract class BaseRequest<T extends BaseResponse> {


    /**
     * 验证请求对象
     * @return
     */
    public abstract boolean validate();

    /**
     *  获取ParamContent对象，用于下一步转换为json字符串
     * @return
     */
    public abstract Object getParamContent();

    /**
     * 将ParamContent对象转换为json字符串
     * @return
     */
    public String toJsonString() {
        return GsonFactory.getGson().toJson(this.getParamContent());
    }

    public Map<String,Object> toMap(){
       if (this.getParamContent() == null){
            return null;
       }
        return BeanUtil.transBeanToMap(this.getParamContent(),true);
    }

    public File getFile(){
        return null;
    }
    /**
     * 得到当前API的响应结果类型
     *
     * @return 响应类型
     */
    public abstract Class<T> getResponseClass();

    /**
     * 获取请求方法
     * @return
     */
    public abstract PostMethod getPostMethod();

    /**
     * 获取接口URL
     * @return
     */
    public abstract String getUrl();

    public  Function<String, T> getConverterFunction(){
        Gson gson = GsonFactory.getGson();
        return new Function<String, T>() {
            @Override
            public T apply(String s) {
                return gson.fromJson(s,getResponseClass());
            }
        };
    }
}
