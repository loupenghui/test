package com.hzsun.demotest.commons.utils;

import com.hzsun.demotest.commons.exceptions.ServiceException;
import org.apache.log4j.Logger;

public class PasswordUtil {

	private static final Logger logger = Logger.getLogger(PasswordUtil.class);

	public static String encrypt(String plainText, String secretKey) {
		String cipherText = null;
		try {
			cipherText = DesAlgorithmUtil.encrypt(plainText, StringUtil.filRight(secretKey, '0', 8));
		} catch (Exception e) {
			logger.error(ExceptionUtils.getTrace(e));
			throw new ServiceException("加密错误：" + e.getMessage());
		}
		return cipherText;
	}
	
	public static String decrypt(String cipherText, String secretKey) {
		String plainText = null;
		try {
			plainText = DesAlgorithmUtil.decrypt(cipherText, StringUtil.filRight(secretKey, '0', 8));
		} catch (Exception e) {
			logger.error(ExceptionUtils.getTrace(e));
			throw new ServiceException("解密错误：" + e.getMessage());
		}
		return plainText;
	}
	
	public static void main(String[] args) {
		String cipherText = encrypt("123456", "100010");
		System.out.println(cipherText);
		
		String plainText = decrypt("DK+uTyPdWHE=", "100001");
		System.out.println(plainText);
    }

}
