package com.hzsun.demotest.commons.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtil {

	private NumberUtil() {
	}

	/** 默认精度 */
	private static final int DEFAULT_SCALE = 2;
	public static final String FORMAT_1 = "##########0";
	public static final String FORMAT_2 = "##########0.00";
	public static final String FORMAT_3 = "##########0.000";
	public static final String FORMAT_4 = "##########0.0000";
	public static final String FORMAT_5 = "##########0.00000";
	public static final String FORMAT_6 = "##########0.000000";
	public static final String FORMAT_7 = "0000000000"; // 10位
	public static final String FORMAT_8 = "0000"; // 4位

	/**
	 * 根据借贷关系计算交易金额正负
	 * 
	 * @param b 是否为借方科目
	 * @param b1 是否发生借操作
	 * @param monDeal 金额
	 * @return
	 */
	public static final double getMonDealByDebitLender(boolean b, boolean b1, double monDeal) {
		/*
		 * 借发生借则加 借发生贷则减 贷发生贷则加 贷发生借则减
		 */
		if (b == b1) {
			return monDeal;
		} else {
			return multiply(monDeal, -1);
		}
	}

	/**
	 * 相加运算
	 * 
	 * @param value 加数
	 * @param value1 被加数
	 * @param scale 精度
	 * @return value + value1
	 */
	public static final double add(double value, double value1, int scale) {
		double v = 0;
		if (0 <= scale) {
			BigDecimal bd = new BigDecimal(Double.toString(value));
			BigDecimal bd1 = new BigDecimal(Double.toString(value1));
			v = round(bd.add(bd1).doubleValue(), scale);
		}
		return v;
	}

	/**
	 * 相加运算
	 * 
	 * @param value 加数
	 * @param value1 被加数
	 * @return value + value1
	 */
	public static final double add(double value, double value1) {
		BigDecimal bd = new BigDecimal(Double.toString(value));
		BigDecimal bd1 = new BigDecimal(Double.toString(value1));
		return bd.add(bd1).doubleValue();
	}

	public static void main(String[] args) {
		Double value = 0.05;
		Double value1 = 0.01;
		Double a = add(value, value1);
		System.out.println(a);
		System.out.println(value + value1);
		System.out.println(convertOutput(value + value1, FORMAT_2));
	}

	/**
	 * 相减运算
	 * 
	 * @param value 减数
	 * @param value1 被减数
	 * @param scale 精度
	 * @return value - value1
	 */
	public static final double subtract(double value, double value1, int scale) {
		double v = 0;
		if (0 <= scale) {
			BigDecimal bd = new BigDecimal(Double.toString(value));
			BigDecimal bd1 = new BigDecimal(Double.toString(value1));
			v = round(bd.subtract(bd1).doubleValue(), scale);
		}
		return v;
	}

	/**
	 * 相减运算
	 * 
	 * @param value 减数
	 * @param value1 被减数
	 * @return value - value1
	 */
	public static final double subtract(double value, double value1) {
		BigDecimal bd = new BigDecimal(Double.toString(value));
		BigDecimal bd1 = new BigDecimal(Double.toString(value1));
		return bd.subtract(bd1).doubleValue();
	}

	/**
	 * 相乘运算
	 * 
	 * @param value 乘数
	 * @param value1 被乘数
	 * @param scale 精度
	 * @return value * value1
	 */
	public static final double multiply(double value, double value1, int scale) {
		double v = 0;
		if (0 <= scale) {
			BigDecimal bd = new BigDecimal(Double.toString(value));
			BigDecimal bd1 = new BigDecimal(Double.toString(value1));
			v = round(bd.multiply(bd1).doubleValue(), scale);
		}
		return v;
	}

	/**
	 * 相乘运算
	 * 
	 * @param value 乘数
	 * @param value1 被乘数
	 * @return value * value1
	 */
	public static final double multiply(double value, double value1) {
		BigDecimal bd = new BigDecimal(Double.toString(value));
		BigDecimal bd1 = new BigDecimal(Double.toString(value1));
		return bd.multiply(bd1).doubleValue();
	}

	/**
	 * 相乘运算
	 * 
	 * @param value 乘数
	 * @param value1 被乘数
	 * @param scale 精度
	 * @param roundMode 舍入模式，BigDecimal常量
	 * @return value * value1
	 */
	public static final double multiply(double value, double value1, int scale, int roundMode) {
		BigDecimal bd = new BigDecimal(Double.toString(value));
		BigDecimal bd1 = new BigDecimal(Double.toString(value1));
		return bd.multiply(bd1).setScale(scale, roundMode).doubleValue();
	}

	/**
	 * 相除运算
	 * 
	 * @param value 除数
	 * @param value1 被除数
	 * @param scale 精度
	 * @return value / value1
	 */
	public static final double divide(double value, double value1, int scale) {
		double v = 0;
		if (0 != value1 && 0 <= scale) {
			BigDecimal bd = new BigDecimal(Double.toString(value));
			BigDecimal bd1 = new BigDecimal(Double.toString(value1));
			v = bd.divide(bd1, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		return v;
	}

	/**
	 * 相除运算
	 * 
	 * @param value 除数
	 * @param value1 被除数
	 * @param scale 精度
	 * @param roundMode 舍入模式，BigDecimal常量
	 * @return value / value1
	 */
	public static final double divide(double value, double value1, int scale, int roundMode) {
		double v = 0;
		if (0 != value1 && 0 <= scale) {
			BigDecimal bd = new BigDecimal(Double.toString(value));
			BigDecimal bd1 = new BigDecimal(Double.toString(value1));
			v = bd.divide(bd1, scale, roundMode).doubleValue();
		}
		return v;
	}

	/**
	 * 相除运算
	 * 
	 * @param value 除数
	 * @param value1 被除数
	 * @return value / value1
	 */
	public static final double divide(double value, double value1) {
		double v = 0;
		if (0 != value1) {
			BigDecimal bd = new BigDecimal(Double.toString(value));
			BigDecimal bd1 = new BigDecimal(Double.toString(value1));
			try {
				v = bd.divide(bd1).doubleValue();
			} catch (Exception e) {
				v = divide(value, value1, DEFAULT_SCALE);
			}
		}
		return v;
	}

	/**
	 * 四舍五入
	 * 
	 * @param value 需处理的数字
	 * @param scale 精度
	 * @return 处理后的数字
	 */
	public static final double round(double value, int scale) {
		double v = 0;
		if (0 <= scale) {
			BigDecimal bd = new BigDecimal(Double.toString(value));
			BigDecimal one = new BigDecimal("1");
			v = bd.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		return v;
	}

	/**
	 * 以format的格式显示d
	 * 
	 * @param d 数字
	 * @param format 格式
	 * @return 转换后的字符串
	 */
	public static String convertOutput(Double d, String format) {
		return convertFormat(d, format);
	}

	/**
	 * 以format的格式显示d
	 * 
	 * @param d 数字
	 * @param format 格式
	 * @return 转换后的字符串
	 */
	public static String convertOutput(Integer d, String format) {
		return convertFormat(d, format);
	}

	/**
	 * 检查浮点数
	 * 
	 * @param num 被检测数
	 * @param type "0+":非负浮点数 "+":正浮点数 "-0":非正浮点数 "-":负浮点数 "":浮点数
	 * @return true:是 false:否
	 */
	public static boolean checkFloat(String num, String type) {
		String eL = "";
		if (type.equals("0+"))
			eL = "^\\d+(\\.\\d+)?$";// 非负浮点数
		else if (type.equals("+"))
			eL = "^((\\d+\\.\\d*[1-9]\\d*)|(\\d*[1-9]\\d*\\.\\d+)|(\\d*[1-9]\\d*))$";// 正浮点数
		else if (type.equals("-0"))
			eL = "^((-\\d+(\\.\\d+)?)|(0+(\\.0+)?))$";// 非正浮点数
		else if (type.equals("-"))
			eL = "^(-((\\d+\\.\\d*[1-9]\\d*)|(\\d*[1-9]\\d*\\.\\d+)|(\\d*[1-9]\\d*)))$";// 负浮点数
		else
			eL = "^(-?\\d+)(\\.\\d+)?$";// 浮点数
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(num);
		boolean b = m.matches();
		return b;
	}

	/**
	 * 按照指定的格式f转化
	 * 
	 * @param d 数字
	 * @param f 格式
	 * @return 转换后的字符串
	 */
	private static String convertFormat(Object d, String f) {
		if (null == d) {
			d = 0D;
		}
		return new DecimalFormat(f).format(d);
	}

	/**
	 * 按照指定的规则格式自增
	 * 
	 * @param f 自增规则仅为 数字类型（例如“000”，“0000”...）
	 * @return
	 */
	public static String incFormat(String f) {
		String str = "";
		int len = f.length();
		for (int i = 0; i < len; i++) {
			if (f.charAt(i) != '0') {
				str = f.replace(f.charAt(i), '0');
			}
		}
		Integer i = Integer.parseInt(f);
		i++;
		return convertFormat(i, StringUtil.isNotBlank(str) ? str : f);
	}
}