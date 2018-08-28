package com.boal.wechat.util;

import com.boal.wechat.model.Template;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by liuyangkly on 15/6/26.
 * 使用google gson作为json序列化反序列化工具
 */
public class GsonFactory {
    private static  Type templateListType = new TypeToken<List<Template>>() {}.getType();

    private static class GsonHolder {

        private static Gson gson = new GsonBuilder()
                                .registerTypeAdapter(templateListType,templateSerializer)
                                .create();
        private static JsonParser jsonParser = new JsonParser();
    }

    public static Gson getGson() {
        return GsonHolder.gson;
    }

    public static JsonParser getJsonParser() {
        return GsonHolder.jsonParser;
    }


    public static JsonSerializer<List<Template>> templateSerializer =new JsonSerializer<List<Template>>() {
        @Override
        public JsonElement serialize(List<Template> src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject jsonTemplate = new JsonObject();

            for (Template template : src) {
                JsonObject jsonObject =  new JsonObject();
                jsonObject.addProperty("value",template.getValue());
                jsonObject.addProperty("color",template.getColor());
                jsonTemplate.add(template.getName(),jsonObject);
            }
            return jsonTemplate;
        }
    };
}
