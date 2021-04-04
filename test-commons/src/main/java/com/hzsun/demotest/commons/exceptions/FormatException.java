package com.hzsun.demotest.commons.exceptions;

import com.hzsun.demotest.commons.utils.StringUtil;

/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年4月12日  
**/
public class FormatException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    private String code;
    
    private String message;
    
    
   public FormatException(){
       super();
   }
   
   public FormatException(String message){
       super(message);
   }
   
   public  FormatException(String errorCode,String message){
       super(message);
       this.code=errorCode;
   }
   
   public  FormatException(FormatErrorEnum errorEnum){
       super(errorEnum.getMessage());
       this.code=errorEnum.getErrorCode();
       this.message=errorEnum.getMsg();
       
   }
   
   public  FormatException(FormatErrorEnum errorEnum,String message){
       super(errorEnum.getMessage()+message);
       this.code=errorEnum.getErrorCode();
       this.message=message+errorEnum.getMessage();
   }
   
   public  FormatException(FormatErrorEnum errorEnum,Throwable e){
       super(e);
       this.code=errorEnum.getErrorCode();
       this.message=errorEnum.getMsg();
   }

   public String getErrorCode() {
       if(StringUtil.isBlank(code)){
           return "30001";
       }
       return code;
   }

   public String getMessage() {
       if(StringUtil.isBlank(message)){
           return super.getMessage(); 
        }
       return message;
   }
    
    
    
    
    
}
  
    