package com.hzsun.demotest.commons;
/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年7月30日  
**/

import com.hzsun.demotest.commons.exceptions.ServiceErrorEnum;
import com.hzsun.demotest.commons.exceptions.ServiceException;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年4月18日  
**/
public class AESSignatureUtil {
    
    /**
     * AES加密字符串
     * 
     * @param content
     *            需要被加密的字符串
     * @param password
     *            加密需要的密码
     * @return 密文
     */

    public static  String  encrypt(String content, String password){
        try {      
          return encrptUPAES(content, password);
      } catch (Exception e) {
          //TODO  
          throw new ServiceException(ServiceErrorEnum.E_System_AESError);
      }
    } 
    
    /**
//     * 解密AES加密过的字符串
//     * 
//     * @param content
//     *            AES加密过过的内容
//     * @param password
//     *            加密时的密码
//     * @return 明文
//     */
    
    private static String decrypt(String content , String password) {
        byte[] contentBts;
        try { 
            return decrptUPAES(content, password);
        } catch (Exception e) {
            //TODO  
            throw new ServiceException(ServiceErrorEnum.E_System_AESError);
        }
 
    }
    
 
//    
    private static byte[] encrptUP(byte[] data ,byte[] key) throws Exception{
        SecretKey secretkey= new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(Cipher.ENCRYPT_MODE, secretkey);
        return cipher.doFinal(data);
    }
//    
    private static String encrptUPAES(String data ,String key) throws Exception{
      
        return Base64.encodeBase64String(encrptUP(data.getBytes("UTF-8"), Base64.decodeBase64(key)));
    }
    
    private static byte[] decrptUP(byte[] data ,byte[] key) throws Exception{
        SecretKey secretkey= new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(Cipher.DECRYPT_MODE, secretkey);
        return cipher.doFinal(data);
    }
    
    private static String decrptUPAES(String data ,String key) throws Exception{
      
        return new String(decrptUP(Base64.decodeBase64(data), Base64.decodeBase64(key)),"UTF-8");
    }
    
    
    
}
  
    
  
    