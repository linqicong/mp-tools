package com.boal.wechat.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * API基础响应信息。
 * 
 * @author fengsheng
 */
public class User implements Serializable {


    private static final long serialVersionUID = 6577534936839138215L;
    @SerializedName("name")
    private String              name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public User() {
    }
    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
