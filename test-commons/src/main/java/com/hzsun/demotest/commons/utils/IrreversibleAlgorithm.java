package com.hzsun.demotest.commons.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @Author: dingjl
 * @Description: 不可逆算法集合
 * @Date: 2017-1-19
 */
public class IrreversibleAlgorithm {

	private static final String KEY_SHA = "SHA";
	private static final String KEY_MD5 = "MD5";
	private static final String KEY_MAC = "HmacMD5";

	/**
	 * MD5加密
	 * 
	 * @param data
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws Exception
	 */
	public static byte[] encryptMD5(byte[] data) throws NoSuchAlgorithmException {

		MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
		md5.update(data);
		return md5.digest();

	}
	
	public static String encryptMD5(String data) throws NoSuchAlgorithmException {
	    byte[] bytes = IrreversibleAlgorithm.encryptMD5(data.getBytes());
        StringBuffer buffer = new StringBuffer();
        for (byte bt : bytes) {
            buffer.append(Integer.toHexString((bt & 0xff) >> 4));
            buffer.append(Integer.toHexString(bt & 0x0f));
        }
        return buffer.toString().toUpperCase();
    }

	/**
	 * SHA加密
	 * 
	 * @param data
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static byte[] encryptSHA(byte[] data) throws NoSuchAlgorithmException {

		MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
		sha.update(data);
		return sha.digest();

	}
	
	
	public static String encryptSHA(String data) throws NoSuchAlgorithmException {
	    byte[] bytes = IrreversibleAlgorithm.encryptMD5(data.getBytes());
        StringBuffer buffer = new StringBuffer();
        for (byte bt : bytes) {
            buffer.append(Integer.toHexString((bt & 0xff) >> 4));
            buffer.append(Integer.toHexString(bt & 0x0f));
        }
        return buffer.toString().toUpperCase();
       

    }

	/**
	 * 初始化HMAC密钥
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String initMacKey() throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);

		SecretKey secretKey = keyGenerator.generateKey();
		return encryptBASE64(secretKey.getEncoded());
	}

	/**
	 * HMAC加密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	public static byte[] encryptHMAC(byte[] data, String key) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

		SecretKey secretKey = new SecretKeySpec(decryptBASE64(key), KEY_MAC);
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);

		return mac.doFinal(data);

	}
	
	/**
     * BASE64解密
     * 
     * @param key
     * @return
     * @throws IOException
     */
    public static byte[] decryptBASE64(String key) throws IOException {
        return (new sun.misc.BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64加密
     * 
     * @param key
     * @return
     */
    public static String encryptBASE64(byte[] key) {
        return (new sun.misc.BASE64Encoder()).encodeBuffer(key);
    }
    
    
    
    public static String AESEncrypt(String sSrc, String sKey, String sIv) throws Exception {

        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        int blockSize = cipher.getBlockSize();

        byte[] dataBytes = sSrc.getBytes();
        int plaintextLength = dataBytes.length;
        if (plaintextLength % blockSize != 0) {
            plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
        }

        byte[] plaintext = new byte[plaintextLength];
        System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

        SecretKeySpec keyspec = new SecretKeySpec(sKey.getBytes(), "AES");
        IvParameterSpec ivspec = new IvParameterSpec(sIv.getBytes());

        cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
        byte[] encrypted = cipher.doFinal(plaintext);

        return byte2hex(encrypted).toLowerCase();
    }

    public static String AESDecrypt(String sSrc, String sKey, String sIv) throws Exception {

        byte[] encrypted1      = hex2byte(sSrc);

        Cipher cipher          = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec keyspec  = new SecretKeySpec(sKey.getBytes(), "AES");
        IvParameterSpec ivspec = new IvParameterSpec(sIv.getBytes());

        cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

        byte[] original = cipher.doFinal(encrypted1);
        String originalString = new String(original);

        return originalString;
    }

    public static byte[] hex2byte(String strhex) {
        if (strhex == null) {
            return null;
        }
        int l = strhex.length();
        if (l % 2 == 1) {
            return null;
        }
        byte[] b = new byte[l / 2];
        for (int i = 0; i != l / 2; i++) {
            b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2),
                    16);
        }

        return b;
    }

    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }

        return hs.toUpperCase();
    }
    
}
