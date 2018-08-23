package com.boal.wechat.enums;

public enum PostMethod {
    POST("POST"),
    GET("GET");

    String value;
    PostMethod(String value){
        this.value = value;
    }
}
