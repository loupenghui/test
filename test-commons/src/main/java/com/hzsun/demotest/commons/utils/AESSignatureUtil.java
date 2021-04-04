package com.hzsun.demotest.commons.utils;

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
    
//    /**
//     * AES加密字符串
//     * 
//     * @param content
//     *            需要被加密的字符串
//     * @param password
//     *            加密需要的密码
//     * @return 密文
//     */
//    private  static byte[] encryptAES(String content, String password) {
//        try {
//            KeyGenerator kgen = KeyGenerator.getInstance("AES");// 创建AES的Key生产者
//
//            kgen.init(128, new SecureRandom(password.getBytes()));// 利用用户密码作为随机数初始化出
//                                                                    // 128位的key生产者
//            //加密没关系，SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以解密只要有password就行
//
//            SecretKey secretKey = kgen.generateKey();// 根据用户密码，生成一个密钥
//
//            byte[] enCodeFormat = secretKey.getEncoded();// 返回基本编码格式的密钥，如果此密钥不支持编码，则返回
//                                                            // null。
//
//            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");// 转换为AES专用密钥
//
//            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
//
//            byte[] byteContent = content.getBytes("utf-8");
//
//            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化为加密模式的密码器
//
//            byte[] result = cipher.doFinal(byteContent);// 加密
//
//            return result;
//
//        }  catch (Exception e) {
//           throw new ServiceException(ServiceErrorEnum.E_System_AESError);
//        }
//    }
//    
//    /**
//     * 解密AES加密过的字符串
//     * 
//     * @param content
//     *            AES加密过过的内容
//     * @param password
//     *            加密时的密码
//     * @return 明文
//     */
//    private  static byte[] decryptAES(byte[] content, String password) {
//        try {
//            KeyGenerator kgen = KeyGenerator.getInstance("AES");// 创建AES的Key生产者
//            kgen.init(128, new SecureRandom(password.getBytes()));
//            SecretKey secretKey = kgen.generateKey();// 根据用户密码，生成一个密钥
//            byte[] enCodeFormat = secretKey.getEncoded();// 返回基本编码格式的密钥
//            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");// 转换为AES专用密钥
//            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
//            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化为解密模式的密码器
//            byte[] result = cipher.doFinal(content);  
//            return result; // 明文   
//            
//        }  catch (Exception e) {
//            throw new ServiceException(ServiceErrorEnum.E_System_AESError);
//        }
//        
//    }
    
    
    public static  String  encrypt(String content, String password){
       // return encryptBASE64(encryptAES(content, password));
        try {
//          contentBts = decryptBASE64(content);
//          byte[] bts=decryptAES(contentBts, password);
//          return  new String(bts,"utf-8");
          return encrptUPAES(content, password);
      } catch (Exception e) {
          //TODO  
          throw new ServiceException(ServiceErrorEnum.E_System_AESError);
      }
    } 
    
    
    public static String decrypt(String content , String password) {
        byte[] contentBts;
        try {
//            contentBts = decryptBASE64(content);
//            byte[] bts=decryptAES(contentBts, password);
//            return  new String(bts,"utf-8");
            return decrptUPAES(content, password);
        } catch (Exception e) {
            //TODO  
            throw new ServiceException(ServiceErrorEnum.E_System_AESError);
        }
 
    }
    
//    /**
//     * BASE64解密
//     * 
//     * @param key
//     * @return
//     * @throws IOException
//     */
//    @SuppressWarnings("restriction")
//    public static byte[] decryptBASE64(String key) throws IOException  {
//        return (new sun.misc.BASE64Decoder()).decodeBuffer(key);
//    }

//    /**
//     * BASE64加密
//     * 
//     * @param key
//     * @return
//     */
//    public static String encryptBASE64(byte[] key) {
//        return (new sun.misc.BASE64Encoder()).encodeBuffer(key);
//    }
//    
//    
    public static byte[] encrptUP(byte[] data ,byte[] key) throws Exception{
        SecretKey secretkey= new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(Cipher.ENCRYPT_MODE, secretkey);
        return cipher.doFinal(data);
    }
//    
    public static String encrptUPAES(String data ,String key) throws Exception{
      
        return Base64.encodeBase64String(encrptUP(data.getBytes("UTF-8"), Base64.decodeBase64(key)));
    }
    
    public static byte[] decrptUP(byte[] data ,byte[] key) throws Exception{
        SecretKey secretkey= new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(Cipher.DECRYPT_MODE, secretkey);
        return cipher.doFinal(data);
    }
    
    public static String decrptUPAES(String data ,String key) throws Exception{
      
        return new String(decrptUP(Base64.decodeBase64(data), Base64.decodeBase64(key)),"UTF-8");
    }
    
    
    
}
  
    