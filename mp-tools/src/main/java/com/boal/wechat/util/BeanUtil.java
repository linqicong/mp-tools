package com.boal.wechat.util;

import com.google.gson.annotations.SerializedName;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dowler
 */
public class BeanUtil {

    public static Map<String, Object> transBeanToMap(Object bean) {
        return transBeanToMap(bean, false);
    }
    
    public static Map<String, Object> transBeanToMap(Object bean, boolean ignoreNullField) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            if (bean == null) {
                return map;
            }
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                if (!"class".equals(key)) {
                    Field field = bean.getClass().getDeclaredField(key);
                    SerializedName jsonField = field.getAnnotation(SerializedName.class);
                    if (jsonField != null) {
                        key = jsonField.value();
                    }
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(bean);

                    if (ignoreNullField) {
                        if (value != null) {
                            map.put(key, value);
                        }
                    } else {
                        map.put(key, value);
                    }
                }
            }
            return map;
        } catch (Exception e) {
            throw new RuntimeException("An exception occurred while bean trans to map: ", e);
        }
    }

}