/**
 * 
 */
package com.hzsun.demotest.commons.utils;

import com.hzsun.demotest.commons.enums.DateFormatEnum;
import com.hzsun.demotest.commons.exceptions.FormatErrorEnum;
import com.hzsun.demotest.commons.exceptions.FormatException;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description 日期工具类
 * @author Djl
 * @version 2018-04-16
 */


public final  class DateUtils  {
	
	/**
	 *@Description 得到当前日期字符串
	 *@param dateEnum 日期枚举 {@link DateFormatEnum}
	 *@return 返回格式化日期字符串
	 */
	public static String getCurrentDate(DateFormatEnum  dateEnum) {
		return format(new Date(), dateEnum);
	}

	public static  String getCurrentDateByZero(DateFormatEnum  dateEnum){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date zero = calendar.getTime();
		return format(zero, dateEnum);
	}
	
	/**
     *@Description 得到当前日期
     *@return  当前时间
     */
    public static Date getCurrentDate() {
        return new Date();
    }
	
    /***
     * @Description 日期字符串转换指定类型的日期
     * @param datestr 日期字符串
     * @param  dateEnum 日期枚举 {@link DateFormatEnum}
     * @return 转化后日期
     * **/
	
	public  static final Date parse(String datestr,DateFormatEnum dateEnum){
        SimpleDateFormat sdf=new SimpleDateFormat(dateEnum.getFormat());
        try {
            return sdf.parse(datestr);
        } catch (ParseException e) {
            throw new FormatException(FormatErrorEnum.Date_Format_Error,e);
        }
        
    }
	
	
	/***
     * @Description 日期转换指定类型的日期字符串
     * @param date 日期
     * @param  dateEnum 日期枚举 {@link DateFormatEnum}
     * @return 转化后日期字符串
     * **/

    public  static final String format(Date date,DateFormatEnum dateEnum){
        if(date!=null){
            SimpleDateFormat sdf=new SimpleDateFormat(dateEnum.getFormat());
            return sdf.format(date);
        }else{
            return null;
        }

    }
	
	
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}
	


	/**
	 * 获取过去的天数
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(24*60*60*1000);
	}

	/**
	 * 获取过去的小时
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*60*1000);
	}
	
	/**
	 * 获取过去的分钟
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*1000);
	}
	
	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * @param timeMillis
	 * @return
	 */
    public static String formatDateTime(long timeMillis){
		long day = timeMillis/(24*60*60*1000);
		long hour = (timeMillis/(60*60*1000)-day*24);
		long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
		long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
		long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
		return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
    }
	
	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}
	/**
	 * 获取两个日期之间的具体某一天
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static String[] getTimePerid(Date before,Date after){
		int day=(int) DateUtils.getDistanceOfTwoDate(before, after)+1;
		String []str=new String[day];
		long ll=before.getTime();
		for(int i=0;i<day;i++){
			   	long ll_s=ll+(1000*60*60*24)*i;
			   	Date date=new Date(ll_s);
			   	String d_date=DateUtils.formatDate(date);
			   	str[i]=d_date;
		}
		return str;
	}
	
	/**
	 * 获取前三年后三年的年份
	 * 
	 * @param before 当年往前推算年份
	 * @param after  当年往后推算年份
	 * @return
	 */
	public static Integer[] getCurrentYear(Integer before,Integer after){
		Integer []str=new Integer[before+after];
		Calendar calendar = Calendar.getInstance();
		int i=0;
		for(;i<before;i++){
			int year=calendar.get(Calendar.YEAR)-(before-i);
			str[i]=year;
		}
		str[i]=calendar.get(Calendar.YEAR);
		for(int j=0;j<after;j++){
			int year=calendar.get(Calendar.YEAR)+j;
			str[j+i]=year;			
		}
     return str;
	}	
	/**
	 * 获取本周周日的字符串日期
	 * @param  weekday   Calendar.MONDAY （周一 ） Calendar.SUNDAY （周日） 等
	 * @return 日期格式的字符串
	 */	
	public static String  getWeekDayDate(int weekday){
		Calendar can = Calendar.getInstance();
		//can.setTime(new Date().);
		can.set(can.get(Calendar.YEAR),can.get(Calendar.MONTH), can.get(Calendar.DAY_OF_MONTH), 0, 0,0);
		can.set(Calendar.DAY_OF_WEEK, weekday);
		//String  dt = sdf.format(can.getTime());
		//System.out.println(dt);
		long ss = (can.getTime().getTime()+7*24*60*60*1000);
		can.setTimeInMillis(ss);
	    String dd= DateUtils.formatDateTime(can.getTime());
		return dd;
	}
	
	
	public static Date addYear(Date date, Integer yearNums) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);   //设置当前日期
        c.add(Calendar.YEAR, yearNums); //日期加1天
        date = c.getTime();
        return date;
    }
	
	 /**
     * @param format
     * @return format格式的当前日期时间
     */
    public static String get(String format) {
        if (format == null) {
            return null;
        }
        return new SimpleDateFormat(format).format(new Date());
    }
    
	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		String currentDateByZero = DateUtils.getCurrentDateByZero(DateFormatEnum.yyyy_MM_dd_HH_mm_ss);
		System.err.println(currentDateByZero);
		//String ss=DateUtils.formatDate(, "yyyy-MM-dd") ;
		//calendar.get
		//String ss=DateUtils.getYear();
//       Date d1=DateUtils.parseDate("2016-04-10");
//       Date d2=DateUtils.parseDate("2016-04-12");
//		String[]ss=getTimePerid(d1,d2);
//		for(int i=0;i<ss.length;i++){
//			System.out.println("ss的长度："+ss.length+"afda"+ss[i]);
//		}
//		System.out.println(formatDate(parseDate("2010/3/6")));
//		System.out.println(getDate("yyyy年MM月dd日 E"));
//		long time = new Date().getTime()-parseDate("2012-11-19").getTime();
		Integer []str=getCurrentYear(3,3);
		for(int i=0;i<str.length;i++){
			System.out.println(str[i]);
		}
		
		
	  
	}
}
