package com.hzsun.demotest.commons.utils;

import com.hzsun.demotest.commons.exceptions.FormatErrorEnum;
import com.hzsun.demotest.commons.exceptions.FormatException;

/**  
* @Description: 检查工具类 
 * @Author: dingjl  
* @Date: 2018年5月29日  
**/
public class CheckUtil {
    /**
     * @description 检查字符串
     * @param param 参数
     * @param isNull ture 可以为空 false 不为空
     * @param length 长度
     * @param name 提示名称
     * 
     * 
     * **/
    public  static  void checkString(String param,Boolean isNull,int length,String name){
        if(!isNull){
            if(StringUtil.isBlank(param)){
                throw new FormatException(FormatErrorEnum.Paramer_Format_IsNull,name);
            }
        }
        if(CollectionUtil.isNotEmpty(param)){
            int len=param.getBytes().length;
            if(len>length){
                throw new FormatException(FormatErrorEnum.Paramer_Format_length,name);
            }
        }

    }
    
  
}
  
    