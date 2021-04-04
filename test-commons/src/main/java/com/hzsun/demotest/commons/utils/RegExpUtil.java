package com.hzsun.demotest.commons.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpUtil {

	public static String YYYYMMDD_REGEXP = "^\\d{4}[0-1]\\d[0-3]\\d$";
	public static String LONG_REGEXP = "^\\d{1,19}$";
	public static String INTEGER_REGEXP = "^\\d{1,10}$";
	public static String MONEY_REGEXP = "^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){1,2})?$";
	// ip4地址
	public static String IP_REGEXP = "^((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))$";
	// ip4,192.168.1.233;ip4,192.168.1.234;
	public static String CUSTOMIPS_REGEXP = "^((i|I)(p|P)(4|6)(,)((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))));)*((i|I)(p|P)(4|6)(,)((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))));*)$";

	public static String TRADENO_REGEXP="^[A-Za-z0-9_]{1,64}$";
	
	public static String TRADEAMOUNT_REGEXP="^\\d{1,9}[.]{1}\\d{2}$";
	
	public static boolean matches(String str, String regExp) {
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	public   static void  main(String[] args){
	    String reg="99999.99";
	    System.out.println(matches(reg, TRADEAMOUNT_REGEXP));
	    
	} 
}
