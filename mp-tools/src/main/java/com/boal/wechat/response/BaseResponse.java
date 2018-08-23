package com.boal.wechat.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Map;

/**
 * API基础响应信息。
 * 
 * @author fengsheng
 */
public class BaseResponse implements Serializable {

    private static final long   serialVersionUID = 5014379068811962022L;

    public static final String SUCCESS_CODE = "0";

    @SerializedName("errcode")
    private String code = SUCCESS_CODE;

    @SerializedName("errmsg")
    private String msg;


    /**
     * Getter method for property <tt>code</tt>.
     * 
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     * 
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess(){
        return SUCCESS_CODE.equals(getCode());
    }

    @Override
    public String toString() {
        return "response{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
