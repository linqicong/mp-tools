package com.boal.wechat.exception;


/**
 * 
 * @author Boal Lin
 */
public class WechatMpApiException extends RuntimeException {

    private static final long serialVersionUID = -238091758285157331L;

    private String   errCode;
    private String   errMsg;

    public WechatMpApiException() {
        super();
    }

    public WechatMpApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public WechatMpApiException(String message) {
        super(message);
    }

    public WechatMpApiException(Throwable cause) {
        super(cause);
    }

    public WechatMpApiException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

}