package com.boal.wechat.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by liuyangkly on 15/6/26.
 * 使用google gson作为json序列化反序列化工具
 */
public class GsonFactory {

    private static class GsonHolder {

        private static Gson gson = new GsonBuilder()
                                .create();
        private static JsonParser jsonParser = new JsonParser();
    }

    public static Gson getGson() {
        return GsonHolder.gson;
    }

    public static JsonParser getJsonParser() {
        return GsonHolder.jsonParser;
    }
}
