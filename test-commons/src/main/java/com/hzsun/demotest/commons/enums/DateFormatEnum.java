package com.hzsun.demotest.commons.enums;

/**
 * @Description:
 * @Author: dingjl
 * @Date: 2018年4月16日
 **/
public enum DateFormatEnum {
    yyyy_MM_dd("yyyy-MM-dd"),
    MMDDhhmmss("MMDDhhmmss"),
    yyyyMMdd("yyyyMMdd"),
    YYYYMM("yyyy-MM"),
    MMdd("MM-dd"),
    MMDD("MMdd"),
    yyMMddHHmmss("yyMMddHHmmss"),
    HHmm("HHmm"),
    HH("HH"),
    yyyyMMddHHmmss("yyyyMMddHHmmss"),
    yyyy_MM_dd_HH_mm_ss("yyyy-MM-dd HH:mm:ss"),
	yyyyMMdd_HH_mm_ss("yyyyMMddHH:mm:ss"),
    yyyy_MM_dd_HH_mm_ss_SSS("yyyy-MM-dd HH:mm:ss.SSS"),
    yyyy_MM_dd_HH_mm("yyyy-MM-dd HH:mm"),
    YYYY("yyyy"),
    YYYYMMDDHHMMSSSSS("yyyyMMddHHmmssSSS"),
    yyyyMMdd_HHmmss("yyyyMMdd HHmmss"),;
    
    private String format;
    
    DateFormatEnum(String format){
        this.format=format;
    }

    public String getFormat() {
    
        return format;
    }

}
