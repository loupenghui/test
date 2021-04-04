package com.hzsun.demotest.commons.utils;

import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 通过map中的key获取不同类型的value值
 */
public class MapSafeGet {

    private static final Logger logger = LoggerFactory.getLogger(MapSafeGet.class);

    //根据key获取value
    public static <T> T safeGet(Map<String, Object> map, String key, Class<T> type) {
        return safeGet(map, key, type, null);
    }

    private static <T> T safeGet(Map<String, Object> map, String key, Class<T> type, T defaultValue) {
        if (map == null) {
            return null;
        }

        if (map.get(key) != null) {
            Object value = map.get(key);
            try {
                return (T) ConvertUtils.convert(value, type);
            } catch (Exception e) {
                logger.error("map process key error:{}",e.getMessage());
            }
        }

        return defaultValue;
    }
}
