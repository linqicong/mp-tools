package com.boal.wechat.enums;

public enum PostMethod {
    POST("POST"),
    POST_FILE("POST_FILE"),
    DOWNLOAD_FILE("DOWNLOAD_FILE"),
    GET("GET");

    String value;
    PostMethod(String value){
        this.value = value;
    }
}
