package com.hzsun.demotest.commons.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年4月12日  
**/
public class ExceptionUtils {
        /**
         * @Description 获取异常详细数据
         * @param e 异常对象
         * @return  异常对应打印信息
         * **/
      public static String getTrace(Throwable e){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.getBuffer().toString();
      }
}
  
    