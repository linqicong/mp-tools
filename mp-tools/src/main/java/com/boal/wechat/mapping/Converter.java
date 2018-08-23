package com.boal.wechat.mapping;

import com.boal.wechat.request.BaseRequest;
import com.boal.wechat.response.BaseResponse;
import com.google.gson.Gson;
import jdk.nashorn.internal.ir.RuntimeNode;

import java.util.function.Function;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2018/08/20<br/>
 *
 * @author Boal Lin
 * @version 1.0
 */
public class Converter {
    private static Gson gson = new Gson();
    public static  <T extends BaseResponse> T toResponse(String result, Function<String, T> func) {
        try {
            T response = (T) func.apply(result);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            // 进行异常处理
        }
        return null;
    }

}
