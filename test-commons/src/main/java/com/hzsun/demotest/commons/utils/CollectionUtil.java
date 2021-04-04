package com.hzsun.demotest.commons.utils;

import org.apache.commons.collections.CollectionUtils;

import java.util.Map;

/**
 * @Description:
 * @Author: dingjl
 * @Date: 2018年4月12日
 **/
public class CollectionUtil extends CollectionUtils {
    public static final boolean isNotEmpty(Map<?, ?> map) {
        return (null != map) && (!map.isEmpty());
    }

    public static final boolean isEmpty(Map<?, ?> map) {
        return (null == map) || (map.isEmpty());
    }
    
    public static final boolean isEmpty(Object obj) {
        return (null == obj || "null"==obj.toString());
    }
    
    public static final boolean isNotEmpty(Object obj) {
        return !(null == obj || "null"==obj.toString());
    }
}
