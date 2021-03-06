package com.hzsun.demotest.commons.utils;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;


public class NumberFormat {
	
	private static DecimalFormat df = new DecimalFormat("###0");
	
	  private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
          "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	
	public static  String formatString (Object ob){
		if(ob!=null){
			return ob.toString().trim();
		}else {
			return "";
		}
		
	}
	
	public static BigDecimal formatBigDecimal(int data){
		return new BigDecimal(data);
	}
	
	public static BigDecimal formatBigDecimal(double data){
		return new BigDecimal(data);
	}
	
	public static byte  formatByte(Object ob){
		if(ob!=null && !"".equalsIgnoreCase(ob.toString())){
			return (byte)Integer.parseInt(ob.toString().trim());
		}else {
			return 0;
		}
	}
	
	public static byte  formatDeviceId(Object ob){
		if(ob!=null && !"".equalsIgnoreCase(ob.toString())){
			byte bt=(byte) Integer.parseInt(ob.toString().trim());
			if(bt==0){
				return (byte)1;
			}
			return bt;
		}else {
			return 0;
		}
	}
	
	
	
	public static short  formatShort(Object ob){
		if(ob!=null && !"".equalsIgnoreCase(ob.toString())){
			return (short) Integer.parseInt(ob.toString().trim());
		}else {
			return 0;
		}
	}
	
	public static int formatRMB(Object ob){
		if(ob!=null && !"".equalsIgnoreCase(ob.toString())){
			return (int) (Integer.valueOf(df.format(formatDouble(ob)*100)));
		}else {
			return 0;
		}
	}
	
	public static int formatCL(Object ob){
		if(ob!=null && !"".equalsIgnoreCase(ob.toString())){
			return (int) (Integer.valueOf(df.format(formatDouble(ob)*1000)));
		}else {
			return 0;
		}
	}
	
	public static short formatRMBShort(Object ob){
		if(ob!=null && !"".equalsIgnoreCase(ob.toString())){
			 return formatShort(df.format(formatDouble(ob)*100));
		}else {
			return 0;
		}
	}
	

	public static String formatNull(Object ob){
		if(ob!=null || "null".equalsIgnoreCase(ob.toString())){
			return ob.toString().trim();
		}else {
			return "";
		}
	}
	
	public static Integer formatInteger (Object ob){
		try{
			if(ob!=null && !"".equalsIgnoreCase(ob.toString())){
				return Integer.parseInt(ob.toString().trim());
			}else {
				return 0;
			}
			
		}catch(Exception e){
			return 0;
		}
		
	}
	
	public static Long formatLong (Object ob){
		if(ob!=null && !"".equalsIgnoreCase(ob.toString())){
			return Long.parseLong(ob.toString().trim());
		}else {
			return 0L;
		}
	}
	
	public static Integer formatNagetive (Object ob){
		if(ob!=null && !"".equalsIgnoreCase(ob.toString()) ){
			return Integer.parseInt(ob.toString().trim());
		}else {
			return -1;
		}
	}
	
	public static Double formatDouble (Object ob){
		if(ob!=null && !"".equals(ob.toString())){
			return Double.parseDouble((ob.toString().trim()));
		}else {
			return 0.00;
		}
	}
	
	public static Date formatDate (String time,String format){
		try{
			SimpleDateFormat  fmt=new SimpleDateFormat(format.trim());	
			return fmt.parse(time.trim());
		}catch(Exception e){
			
		}
		return new Date();
	}
	

	public static Integer  getTotalPage(Integer total,Integer rows){
		Integer  pages=1;
		if(total.equals(0)){
			pages=1;
		}else{
		
		if(total%rows==0){
			pages=total/rows;
		}else{
			pages=total/rows+1;
		}
		
		}
		return pages;
		
	}
	
	
	public static Integer  getWebpage(String page,Integer totalpages){
		Integer pg=1;
		if(page==null){
			pg=1;
			return pg;
		}else {
			pg=Integer.parseInt(page);
		
			if(pg<1){
				pg=1;
			}else if (pg>totalpages){
				pg=totalpages;
			}
		}
		return pg;
	}
	
	
	public  static String  getCurrentTime(){
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyyMMdd");
		String   str=sdf.format(new Date());
		Calendar  currentDate=Calendar.getInstance();
		Calendar tommorowDate = new GregorianCalendar(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE), 0, 0, 0);
		  str+=formatString((Calendar.getInstance().getTimeInMillis()-tommorowDate.getTimeInMillis())/1000);
		
		return str;
	}
	
	public static  Double  formatNumberDouble(Double ob){
		BigDecimal   bd=new BigDecimal(ob);
		return bd.setScale(0, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	

	
	public static boolean  isEmpty(Object ob){
		
		return ob==null || "".equals(ob) ;
	}
	

	public static  String  getUUid(){
		UUID uuid = UUID.randomUUID();
        String uid=uuid.toString().replace("-","");
        return uid;
	}
	
	public  static String getActiveCode(){
		return getUUid().substring(0,16);
	}
	

	public static String  md5(String str) throws NoSuchAlgorithmException{
		 MessageDigest md5 = MessageDigest.getInstance("MD5");
		 byte[]  strbt=md5.digest(str.getBytes());
		 StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < strbt.length; i++) {
		    sBuffer.append(byteToArrayString(strbt[i]));
		}
		return sBuffer.toString();
	}
	
	// ?????????????????????????????????
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    
    public static String  formatEwalletTranRange(String trange){
		StringBuffer str=new StringBuffer("00000000000000000000000000000000");
		String[] spit=trange.trim().split(";");
		for(String mark:spit){
			int  i=NumberFormat.formatInteger(mark);
			if(i!=0){
				str.replace(i-1, i, "1");
			}
			
		}
		return str.toString();
		
	}
    
    public  static int formatHexString(String hex){
    	int num=0;
    	switch (hex.toLowerCase().trim()) {
		case "a":
			num=10;
			break;
		case "b":
			num=11;
			break;
		case "c":
			num=12;
			break;
		case "d":
			num=13;
			break;
		case "e":
			num=14;
			break;
		case "f":
			num=15;
			break;
		default:
			num=Integer.parseInt(hex.trim());
			break;
		}
    	return num;
    	
    }
    
    public static double formatDFDouble(Object object){
    	double  db=0.00;
    	try{
    		 db=Double.parseDouble(object.toString());
    	}catch(Exception e){
    	}
    	 return db;
    }
    
    public static double formatCentToYuan(int object){
         return object/100.00;
    }
    
    public static String formatRMBString(double object){
        return  new DecimalFormat("0.00").format(object);
   }
   
    public static String formatRMBCentsString(double object){
        return  new DecimalFormat("#.##").format(object);
   }
    
    /**
    * ??????????????????????????????
    * @param v1 ?????????
    * @param v2 ??????
    * @return ??????????????????
    */
   public static double add(double v1,double v2){
       BigDecimal b1 = new BigDecimal(Double.toString(v1));
       BigDecimal b2 = new BigDecimal(Double.toString(v2));
       return b1.add(b2).doubleValue();
   }
   
   public static String addZeroForString(String str, String direction, int strLength) {
       int strLen = str.length();
       if (strLen < strLength) {
           while (strLen < strLength) {
               StringBuffer sb = new StringBuffer();
               if (direction.equalsIgnoreCase("left")) {
                   sb.append("0").append(str);// ??????0
               } else if (direction.equalsIgnoreCase("right")) {
                   sb.append(str).append("0");// ??????0
               }
               str = sb.toString();
               strLen = str.length();
           }
       }
       return str;
   }
   
   public static String byte2BCD(byte[] bytes){
       StringBuffer buffer=new StringBuffer();
       for(byte bt:bytes){
           buffer.append(Integer.toHexString((bt&0xff)>>4));
           buffer.append(Integer.toHexString(bt&0x0f));
       }
       return buffer.toString();
   }
   
   public static byte[]  BCD2Bytes(String bcd) {
       int size=bcd.length()/2;
       byte[] bytes=new byte[size];
       for(int i=0;i<size;i++){
           String bcdstr = bcd.substring(i*2,(i+1)*2);
           bytes[i]=(byte) ((Integer.parseInt(bcdstr.charAt(0) + "",16) << 4) + Integer.parseInt(bcdstr.charAt(1) + "",16));
       }
       return bytes;
   }
   
   public static byte[]  Hex2Bytes(String bcd) {
       int size=bcd.length()/2;
       byte[] bytes=new byte[size];
       for(int i=0;i<size;i++){
           String bcdstr = bcd.substring(i*2,(i+1)*2);
           bytes[i]=(byte)Integer.parseInt(bcdstr,16);
       }
       return bytes;
   }

   
    
	
	
	
}
