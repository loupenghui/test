package com.hzsun.demotest.commons.utils;

import java.util.Arrays;

/**
 *  对数组进行扩容的提取
 */
public class ArrayUtils {

    /**
     *  对数组进行扩容
     * @param datas 原始数组
     * @param newLen 扩容大小
     * @param <T>
     * @return T[]
     */
    public static <T> T[] expandCapacity(T[] datas, int newLen){
        newLen = newLen < 0 ? datas.length : datas.length + newLen;
        // 生成一个新的数组
        return Arrays.copyOf(datas, newLen);
    }

    /**
     *  对数组进行扩容处理
     * @param datas 原始数组
     * @param mulitiple 扩容倍数
     * @param <T>
     * @return T[]
     */
    public static <T> T[] expandCapacityMul(T[] datas, int mulitiple){
        mulitiple = mulitiple < 0 ? 1 : mulitiple;
        int newLen = datas.length * mulitiple;
        return Arrays.copyOf(datas, newLen);
    }

    /**
     *  对数组进行扩容处理,1.5倍
     * @param datas 原始数组
     * @param <T>
     * @return T[]
     */
    public static <T> T[] expandCapacity(T[] datas){
        // 扩容原始数组的1.5倍
        int newLen = (datas.length * 3) / 2;
        // 生成一个新的数组
        return Arrays.copyOf(datas, newLen);
    }
}
