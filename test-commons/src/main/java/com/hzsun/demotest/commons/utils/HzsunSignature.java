/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.hzsun.demotest.commons.utils;

import com.hzsun.demotest.commons.codec.Base64;
import com.hzsun.demotest.commons.exceptions.ApiErrorEnum;
import com.hzsun.demotest.commons.exceptions.ApiException;
import com.hzsun.demotest.commons.exceptions.ServiceErrorEnum;
import com.hzsun.demotest.commons.exceptions.ServiceException;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.*;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

/**
 * 
 * @author runzhi
 */
public class HzsunSignature {

    /** RSA最大加密明文大小 */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /** RSA最大解密密文大小 */
    private static final int MAX_DECRYPT_BLOCK = 128;

    public static String getSignatureContent(RequestParametersHolder requestHolder) {
        return getSignContent(getSortedMap(requestHolder));
    }

    public static Map<String, String> getSortedMap(RequestParametersHolder requestHolder) {
        Map<String, String> sortedParams = new TreeMap<String, String>();
        HzsunHashMap appParams = requestHolder.getApplicationParams();
        if (appParams != null && appParams.size() > 0) {
            sortedParams.putAll(appParams);
        }
        HzsunHashMap protocalMustParams = requestHolder.getProtocalMustParams();
        if (protocalMustParams != null && protocalMustParams.size() > 0) {
            sortedParams.putAll(protocalMustParams);
        }
        HzsunHashMap protocalOptParams = requestHolder.getProtocalOptParams();
        if (protocalOptParams != null && protocalOptParams.size() > 0) {
            sortedParams.putAll(protocalOptParams);
        }

        return sortedParams;
    }

    /**
     * 
     * @param sortedParams
     * @return
     */
    public static String getSignContent(Map<String, String> sortedParams) {
        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(sortedParams.keySet());
        Collections.sort(keys);
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = sortedParams.get(key);
            if (StringUtil.areNotEmpty(key, value)) {
                content.append((index == 0 ? "" : "&") + key + "=" + value);
                index++;
            }
        }
        return content.toString();
    }
    
    
    /**
     * 生成签名. 注意，若含有sign_type字段，必须和signType参数保持一致。
     *
     * @param data 待签名数据
     * @param key API密钥
     * @param signType 签名方式
     * @return 签名
     */
    public static String generateWechatSignature(final Map<String, String> data, String key, String signType) throws Exception {
        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (k.equals("sign")) {
                continue;
            }
            if (data.get(k).trim().length() > 0) // 参数值为空，则不参与签名
                sb.append(k).append("=").append(data.get(k).trim()).append("&");
        }
        sb.append("key=").append(key);
        if ("MD5".equals(signType)) {
            return MD5(sb.toString()).toUpperCase();
        }
        else if ("HMAC-SHA256".equals(signType)) {
            return HMACSHA256(sb.toString(), key);
        }
        else {
            throw new Exception(String.format("Invalid sign_type: %s", signType));
        }
    }
    
    
    /**
     * 生成 MD5
     *
     * @param data 待处理数据
     * @return MD5结果
     */
    public static String MD5(String data) throws Exception {
        java.security.MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }

    /**
     * 生成 HMACSHA256
     * @param data 待处理数据
     * @param key 密钥
     * @return 加密结果
     * @throws Exception
     */
    public static String HMACSHA256(String data, String key) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }
    
    

    /**
     * rsa内容签名
     * 
     * @param content
     * @param privateKey
     * @param charset
     * @return
     * @throws ApiException
     */
    public static String rsaSign(String content, String privateKey, String charset, String signType)
            throws ApiException {

        if (HzsunConstants.SIGN_TYPE_RSA.equals(signType)) {

            return rsaSign(content, privateKey, charset);
        } else if (HzsunConstants.SIGN_TYPE_RSA2.equals(signType)) {

            return rsa256Sign(content, privateKey, charset);
        } else {

            throw new ApiException("Sign Type is Not Support : signType=" + signType);
        }

    }

    /**
     * sha256WithRsa 加签
     * 
     * @param content
     * @param privateKey
     * @param charset
     * @return
     * @throws ApiException
     */
    public static String rsa256Sign(String content, String privateKey, String charset) throws ApiException {

        try {
            PrivateKey priKey = getPrivateKeyFromPKCS8(HzsunConstants.SIGN_TYPE_RSA,
                    new ByteArrayInputStream(privateKey.getBytes()));

            java.security.Signature signature = java.security.Signature
                    .getInstance(HzsunConstants.SIGN_SHA256RSA_ALGORITHMS);

            signature.initSign(priKey);

            if (StringUtil.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            byte[] signed = signature.sign();

            return new String(Base64.encodeBase64(signed));
        } catch (Exception e) {
            throw new ApiException("RSAcontent = " + content + "; charset = " + charset, e);
        }

    }

    /**
     * sha1WithRsa 加签
     * 
     * @param content
     * @param privateKey
     * @param charset
     * @return
     * @throws ApiException
     */
    public static String rsaSign(String content, String privateKey, String charset) throws ApiException {
        try {
            PrivateKey priKey = getPrivateKeyFromPKCS8(HzsunConstants.SIGN_TYPE_RSA,
                    new ByteArrayInputStream(privateKey.getBytes()));

            java.security.Signature signature = java.security.Signature.getInstance(HzsunConstants.SIGN_ALGORITHMS);

            signature.initSign(priKey);

            if (StringUtil.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            byte[] signed = signature.sign();

            return new String(Base64.encodeBase64(signed));
        } catch (InvalidKeySpecException ie) {
            throw new ApiException("RSA私钥格式不正确，请检查是否正确配置了PKCS8格式的私钥", ie);
        } catch (Exception e) {
            throw new ApiException("RSAcontent = " + content + "; charset = " + charset, e);
        }
    }

    public static String rsaSign(Map<String, String> params, String privateKey, String charset) throws ApiException {
        String signContent = getSignContent(params);

        return rsaSign(signContent, privateKey, charset);

    }

    public static PrivateKey getPrivateKeyFromPKCS8(String algorithm, InputStream ins) throws Exception {
        if (ins == null || StringUtil.isEmpty(algorithm)) {
            return null;
        }

        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);

        byte[] encodedKey = StreamUtil.readText(ins).getBytes();

        encodedKey = Base64.decodeBase64(encodedKey);

        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
    }

    public static String getSignCheckContentV1(Map<String, String> params) {
        if (params == null) {
            return null;
        }

        params.remove("sign");
        params.remove("sign_type");

        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            content.append((i == 0 ? "" : "&") + key + "=" + value);
        }

        return content.toString();
    }

    public static String getSignCheckContentV2(Map<String, String> params) {
        if (params == null) {
            return null;
        }

        params.remove("sign");

        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            content.append((i == 0 ? "" : "&") + key + "=" + value);
        }

        return content.toString();
    }

    public static boolean rsaCheckV1(Map<String, String> params, String publicKey, String charset) throws ApiException {
        String sign = params.get("sign");
        String content = getSignCheckContentV1(params);

        return rsaCheckContent(content, sign, publicKey, charset);
    }

    public static boolean rsaCheckV1(Map<String, String> params, String publicKey, String charset, String signType)
            throws ApiException {
        String sign = params.get("sign");
        String content = getSignCheckContentV1(params);

        return rsaCheck(content, sign, publicKey, charset, signType);
    }

    public static boolean rsaCheckV2(Map<String, String> params, String publicKey, String charset) throws ApiException {
        String sign = params.get("sign");
        String content = getSignCheckContentV2(params);

        return rsaCheckContent(content, sign, publicKey, charset);
    }

    public static boolean rsaCheckV2(Map<String, String> params, String publicKey, String charset, String signType)
            throws ApiException {
        String sign = params.get("sign");
        String content = getSignCheckContentV2(params);

        return rsaCheck(content, sign, publicKey, charset, signType);
    }

    public static boolean rsaCheck(String content, String sign, String publicKey, String charset, String signType)
            throws ApiException {

        if (HzsunConstants.SIGN_TYPE_RSA.equals(signType)) {

            return rsaCheckContent(content, sign, publicKey, charset);

        } else if (HzsunConstants.SIGN_TYPE_RSA2.equals(signType)) {

            return rsa256CheckContent(content, sign, publicKey, charset);

        } else {

            throw new ApiException("Sign Type is Not Support : signType=" + signType);
        }

    }

    public static boolean rsa256CheckContent(String content, String sign, String publicKey, String charset)
            throws ApiException {
        try {
            PublicKey pubKey = getPublicKeyFromX509("RSA", new ByteArrayInputStream(publicKey.getBytes()));

            java.security.Signature signature = java.security.Signature
                    .getInstance(HzsunConstants.SIGN_SHA256RSA_ALGORITHMS);

            signature.initVerify(pubKey);

            if (StringUtil.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            return signature.verify(Base64.decodeBase64(sign.getBytes()));
        } catch (Exception e) {
            throw new ApiException("RSAcontent = " + content + ",sign=" + sign + ",charset = " + charset, e);
        }
    }

    public static boolean rsaCheckContent(String content, String sign, String publicKey, String charset)
            throws ApiException {
        try {
            PublicKey pubKey = getPublicKeyFromX509("RSA", new ByteArrayInputStream(publicKey.getBytes()));

            java.security.Signature signature = java.security.Signature.getInstance(HzsunConstants.SIGN_ALGORITHMS);

            signature.initVerify(pubKey);

            if (StringUtil.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            return signature.verify(Base64.decodeBase64(sign.getBytes()));
        } catch (Exception e) {
            throw new ApiException("RSAcontent = " + content + ",sign=" + sign + ",charset = " + charset, e);
        }
    }

    public static PublicKey getPublicKeyFromX509(String algorithm, InputStream ins) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);

        StringWriter writer = new StringWriter();
        StreamUtil.io(new InputStreamReader(ins), writer);

        byte[] encodedKey = writer.toString().getBytes();

        encodedKey = Base64.decodeBase64(encodedKey);

        return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
    }

    /**
     * 验签并解密
     * <p>
     * <b>目前适用于公众号</b><br>
     * params参数示例： <br>
     * { <br>
     * biz_content=M0qGiGz+8kIpxe8aF4geWJdBn0aBTuJRQItLHo9R7o5JGhpic/MIUjvXo2BLB
     * ++BbkSq2OsJCEQFDZ0zK5AJYwvBgeRX30gvEj6eXqXRt16/
     * IkB9HzAccEqKmRHrZJ7PjQWE0KfvDAHsJqFIeMvEYk1Zei2QkwSQPlso7K0oheo/iT+
     * HYE8aTATnkqD/
     * ByD9iNDtGg38pCa2xnnns63abKsKoV8h0DfHWgPH62urGY7Pye3r9FCOXA2Ykm8X4/Bl1bWFN
     * /PFCEJHWe/HXj8KJKjWMO6ttsoV0xRGfeyUO8agu6t587Dl5ux5zD/
     * s8Lbg5QXygaOwo3Fz1G8EqmGhi4+soEIQb8DBYanQOS3X+m46tVqBGMw8Oe+
     * hsyIMpsjwF4HaPKMr37zpW3fe7xOMuimbZ0wq53YP/
     * jhQv6XWodjT3mL0H5ACqcsSn727B5ztquzCPiwrqyjUHjJQQefFTzOse8snaWNQTUsQS7aLsHq0FveGpSBYORyA90qPdiTjXIkVP7mAiYiAIWW9pCEC7F3XtViKTZ8FRMM9ySicfuAlf3jtap6v2KPMtQv70X
     * +hlmzO/IXB6W0Ep8DovkF5rB4r/BJYJLw/
     * 6AS0LZM9w5JfnAZhfGM2rKzpfNsgpOgEZS1WleG4I2hoQC0nxg9IcP0Hs+
     * nWIPkEUcYNaiXqeBc=, <br>
     * sign=rlqgA8O+RzHBVYLyHmrbODVSANWPXf3pSrr82OCO/
     * bm3upZiXSYrX5fZr6UBmG6BZRAydEyTIguEW6VRuAKjnaO/sOiR9BsSrOdXbD5Rhos/Xt7/
     * mGUWbTOt/F+3W0/XLuDNmuYg1yIC/6hzkg44kgtdSTsQbOC9gWM7ayB4J4c=,
     * sign_type=RSA, <br>
     * charset=UTF-8 <br>
     * }
     * </p>
     * 
     * @param params
     * @param alipayPublicKey
     *            支付宝公钥
     * @param cusPrivateKey
     *            商户私钥
     * @param isCheckSign
     *            是否验签
     * @param isDecrypt
     *            是否解密
     * @return 解密后明文，验签失败则异常抛出
     * @throws ApiException
     */
    public static String checkSignAndDecrypt(Map<String, String> params, String alipayPublicKey, String cusPrivateKey,
            boolean isCheckSign, boolean isDecrypt) throws ApiException {
        String charset = params.get("charset");
        String bizContent = params.get("biz_content");
        if (isCheckSign) {
            if (!rsaCheckV2(params, alipayPublicKey, charset)) {
                throw new ApiException("rsaCheck failure:rsaParams=" + params);
            }
        }

        if (isDecrypt) {
            return rsaDecrypt(bizContent, cusPrivateKey, charset);
        }

        return bizContent;
    }

    /**
     * 验签并解密
     * <p>
     * <b>目前适用于公众号</b><br>
     * params参数示例： <br>
     * { <br>
     * biz_content=M0qGiGz+8kIpxe8aF4geWJdBn0aBTuJRQItLHo9R7o5JGhpic/MIUjvXo2BLB
     * ++BbkSq2OsJCEQFDZ0zK5AJYwvBgeRX30gvEj6eXqXRt16/
     * IkB9HzAccEqKmRHrZJ7PjQWE0KfvDAHsJqFIeMvEYk1Zei2QkwSQPlso7K0oheo/iT+
     * HYE8aTATnkqD/
     * ByD9iNDtGg38pCa2xnnns63abKsKoV8h0DfHWgPH62urGY7Pye3r9FCOXA2Ykm8X4/Bl1bWFN
     * /PFCEJHWe/HXj8KJKjWMO6ttsoV0xRGfeyUO8agu6t587Dl5ux5zD/
     * s8Lbg5QXygaOwo3Fz1G8EqmGhi4+soEIQb8DBYanQOS3X+m46tVqBGMw8Oe+
     * hsyIMpsjwF4HaPKMr37zpW3fe7xOMuimbZ0wq53YP/
     * jhQv6XWodjT3mL0H5ACqcsSn727B5ztquzCPiwrqyjUHjJQQefFTzOse8snaWNQTUsQS7aLsHq0FveGpSBYORyA90qPdiTjXIkVP7mAiYiAIWW9pCEC7F3XtViKTZ8FRMM9ySicfuAlf3jtap6v2KPMtQv70X
     * +hlmzO/IXB6W0Ep8DovkF5rB4r/BJYJLw/
     * 6AS0LZM9w5JfnAZhfGM2rKzpfNsgpOgEZS1WleG4I2hoQC0nxg9IcP0Hs+
     * nWIPkEUcYNaiXqeBc=, <br>
     * sign=rlqgA8O+RzHBVYLyHmrbODVSANWPXf3pSrr82OCO/
     * bm3upZiXSYrX5fZr6UBmG6BZRAydEyTIguEW6VRuAKjnaO/sOiR9BsSrOdXbD5Rhos/Xt7/
     * mGUWbTOt/F+3W0/XLuDNmuYg1yIC/6hzkg44kgtdSTsQbOC9gWM7ayB4J4c=,
     * sign_type=RSA, <br>
     * charset=UTF-8 <br>
     * }
     * </p>
     * 
     * @param params
     * @param alipayPublicKey
     *            支付宝公钥
     * @param cusPrivateKey
     *            商户私钥
     * @param isCheckSign
     *            是否验签
     * @param isDecrypt
     *            是否解密
     * @return 解密后明文，验签失败则异常抛出
     * @throws ApiException
     */
    public static String checkSignAndDecrypt(Map<String, String> params, String alipayPublicKey, String cusPrivateKey,
            boolean isCheckSign, boolean isDecrypt, String signType) throws ApiException {
        String charset = params.get("charset");
        String bizContent = params.get("biz_content");
        if (isCheckSign) {
            if (!rsaCheckV2(params, alipayPublicKey, charset, signType)) {
                throw new ApiException("rsaCheck failure:rsaParams=" + params);
            }
        }

        if (isDecrypt) {
            return rsaDecrypt(bizContent, cusPrivateKey, charset);
        }

        return bizContent;
    }

    /**
     * 加密并签名<br>
     * <b>目前适用于公众号</b>
     * 
     * @param bizContent
     *            待加密、签名内容
     * @param alipayPublicKey
     *            支付宝公钥
     * @param cusPrivateKey
     *            商户私钥
     * @param charset
     *            字符集，如UTF-8, GBK, GB2312
     * @param isEncrypt
     *            是否加密，true-加密 false-不加密
     * @param isSign
     *            是否签名，true-签名 false-不签名
     * @return 加密、签名后xml内容字符串
     *         <p>
     *         返回示例： <alipay> <response>密文</response>
     *         <encryption_type>RSA</encryption_type> <sign>sign</sign>
     *         <sign_type>RSA</sign_type> </alipay>
     *         </p>
     * @throws ApiException
     */
    public static String encryptAndSign(String bizContent, String alipayPublicKey, String cusPrivateKey, String charset,
            boolean isEncrypt, boolean isSign) throws ApiException {
        StringBuilder sb = new StringBuilder();
        if (StringUtil.isEmpty(charset)) {
            charset = HzsunConstants.CHARSET_GBK;
        }
        sb.append("<?xml version=\"1.0\" encoding=\"" + charset + "\"?>");
        if (isEncrypt) {// 加密
            sb.append("<alipay>");
            String encrypted = rsaEncrypt(bizContent, alipayPublicKey, charset);
            sb.append("<response>" + encrypted + "</response>");
            sb.append("<encryption_type>RSA</encryption_type>");
            if (isSign) {
                String sign = rsaSign(encrypted, cusPrivateKey, charset);
                sb.append("<sign>" + sign + "</sign>");
                sb.append("<sign_type>RSA</sign_type>");
            }
            sb.append("</alipay>");
        } else if (isSign) {// 不加密，但需要签名
            sb.append("<alipay>");
            sb.append("<response>" + bizContent + "</response>");
            String sign = rsaSign(bizContent, cusPrivateKey, charset);
            sb.append("<sign>" + sign + "</sign>");
            sb.append("<sign_type>RSA</sign_type>");
            sb.append("</alipay>");
        } else {// 不加密，不加签
            sb.append(bizContent);
        }
        return sb.toString();
    }

    /**
     * 加密并签名<br>
     * <b>目前适用于公众号</b>
     * 
     * @param bizContent
     *            待加密、签名内容
     * @param alipayPublicKey
     *            支付宝公钥
     * @param cusPrivateKey
     *            商户私钥
     * @param charset
     *            字符集，如UTF-8, GBK, GB2312
     * @param isEncrypt
     *            是否加密，true-加密 false-不加密
     * @param isSign
     *            是否签名，true-签名 false-不签名
     * @return 加密、签名后xml内容字符串
     *         <p>
     *         返回示例： <alipay> <response>密文</response>
     *         <encryption_type>RSA</encryption_type> <sign>sign</sign>
     *         <sign_type>RSA</sign_type> </alipay>
     *         </p>
     * @throws ApiException
     */
    public static String encryptAndSign(String bizContent, String alipayPublicKey, String cusPrivateKey, String charset,
            boolean isEncrypt, boolean isSign, String signType) throws ApiException {
        StringBuilder sb = new StringBuilder();
        if (StringUtil.isEmpty(charset)) {
            charset = HzsunConstants.CHARSET_GBK;
        }
        sb.append("<?xml version=\"1.0\" encoding=\"" + charset + "\"?>");
        if (isEncrypt) {// 加密
            sb.append("<alipay>");
            String encrypted = rsaEncrypt(bizContent, alipayPublicKey, charset);
            sb.append("<response>" + encrypted + "</response>");
            sb.append("<encryption_type>RSA</encryption_type>");
            if (isSign) {
                String sign = rsaSign(encrypted, cusPrivateKey, charset, signType);
                sb.append("<sign>" + sign + "</sign>");
                sb.append("<sign_type>");
                sb.append(signType);
                sb.append("</sign_type>");
            }
            sb.append("</alipay>");
        } else if (isSign) {// 不加密，但需要签名
            sb.append("<alipay>");
            sb.append("<response>" + bizContent + "</response>");
            String sign = rsaSign(bizContent, cusPrivateKey, charset, signType);
            sb.append("<sign>" + sign + "</sign>");
            sb.append("<sign_type>");
            sb.append(signType);
            sb.append("</sign_type>");
            sb.append("</alipay>");
        } else {// 不加密，不加签
            sb.append(bizContent);
        }
        return sb.toString();
    }

    /**
     * 公钥加密
     * 
     * @param content
     *            待加密内容
     * @param publicKey
     *            公钥
     * @param charset
     *            字符集，如UTF-8, GBK, GB2312
     * @return 密文内容
     * @throws ApiException
     */
    public static String rsaEncrypt(String content, String publicKey, String charset) throws ApiException {
        try {
            PublicKey pubKey = getPublicKeyFromX509(HzsunConstants.SIGN_TYPE_RSA,
                    new ByteArrayInputStream(publicKey.getBytes()));
            Cipher cipher = Cipher.getInstance(HzsunConstants.SIGN_TYPE_RSA);
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            byte[] data = StringUtil.isEmpty(charset) ? content.getBytes() : content.getBytes(charset);
            int inputLen = data.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段加密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_ENCRYPT_BLOCK;
            }
            byte[] encryptedData = Base64.encodeBase64(out.toByteArray());
            out.close();

            return StringUtil.isEmpty(charset) ? new String(encryptedData) : new String(encryptedData, charset);
        } catch (Exception e) {
            throw new ApiException("EncryptContent = " + content + ",charset = " + charset, e);
        }
    }

    /**
     * 私钥解密
     * 
     * @param content
     *            待解密内容
     * @param privateKey
     *            私钥
     * @param charset
     *            字符集，如UTF-8, GBK, GB2312
     * @return 明文内容
     * @throws ApiException
     */
    public static String rsaDecrypt(String content, String privateKey, String charset) throws ApiException {
        try {
            PrivateKey priKey = getPrivateKeyFromPKCS8(HzsunConstants.SIGN_TYPE_RSA,
                    new ByteArrayInputStream(privateKey.getBytes()));
            Cipher cipher = Cipher.getInstance(HzsunConstants.SIGN_TYPE_RSA);
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            byte[] encryptedData = StringUtil.isEmpty(charset) ? Base64.decodeBase64(content.getBytes())
                    : Base64.decodeBase64(content.getBytes(charset));
            int inputLen = encryptedData.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_DECRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();

            return StringUtil.isEmpty(charset) ? new String(decryptedData) : new String(decryptedData, charset);
        } catch (Exception e) {
            throw new ApiException("EncodeContent = " + content + ",charset = " + charset, e);
        }
    }

    public static String encryptSHA(String encryptStr) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA");
            md.update(encryptStr.getBytes("UTF-8")); // step 3
            byte raw[] = md.digest(); // step 4
            String hash = (new BASE64Encoder()).encode(raw); // step 5
            return hash; // step 6
        } catch (NoSuchAlgorithmException e) {
            throw new ServiceException(ServiceErrorEnum.E_Sign_Error);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new ServiceException(ServiceErrorEnum.E_Sign_Error);
        }
    }
    
    
    public static String encryptSHA1(String encryptStr) {
        MessageDigest md;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");  
            digest.update(encryptStr.getBytes()); 
            byte messageDigest[] = digest.digest();  
            // Create Hex String  
            StringBuffer hexString = new StringBuffer();  
            // 字节数组转换为 十六进制 数  
            for (int i = 0; i < messageDigest.length; i++) {  
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);  
                if (shaHex.length() < 2) {  
                    hexString.append(0);  
                }  
                hexString.append(shaHex);  
            }  
            return hexString.toString().toLowerCase(); // step 6
        } catch (NoSuchAlgorithmException e) {
            throw new ServiceException(ServiceErrorEnum.E_Sign_Error);
        } 
    }
    
    
    /**
     * @desription signWithsha1withrsa 加签名
     * @param dataString
     * @return
     */
    public static String signWithsha1Withrsa(String dataString,byte[] pxfkey,String pxfpwd) {
        String signatureString = null;
       
        try {
            KeyStore ks = KeyStore.getInstance("PKCS12");
            InputStream fis = new ByteArrayInputStream(pxfkey);
            char[] nPassword = null;
            if ((pxfpwd == null)
                    || pxfpwd.trim().equals("")) {
                nPassword = null;
            } else {
                nPassword = pxfpwd.toCharArray();
            }
            ks.load(fis, nPassword);
            fis.close();
            System.out.println("keystore type=" + ks.getType());
            Enumeration<String> enums = ks.aliases();
            String keyAlias = null;
            if (enums.hasMoreElements()) 
            {
                keyAlias = (String) enums.nextElement();
                System.out.println("alias=[" + keyAlias + "]");
            }
            System.out.println("is key entry=" + ks.isKeyEntry(keyAlias));
            PrivateKey prikey = (PrivateKey) ks.getKey(keyAlias, nPassword);
            java.security.cert.Certificate cert = ks.getCertificate(keyAlias);
            PublicKey pubkey = cert.getPublicKey();
            System.out.println("cert class = " + cert.getClass().getName());
            System.out.println("cert = " + cert);
            System.out.println("public key = " + pubkey);
            System.out.println("private key = " + prikey);
            // SHA1withRSA算法进行签名
            Signature sign = Signature.getInstance("SHA1withRSA");
            sign.initSign(prikey);
            byte[] data = dataString.getBytes();
            byte[] dataBase= Base64.encodeBase64(data);
            // 更新用于签名的数据
            sign.update(dataBase);
            byte[] signature = sign.sign();
            signatureString = new String(Base64.encodeBase64(signature));
            System.out.println("--------signature is : " + signatureString);
        } catch (Exception e) {
            throw new ServiceException(ServiceErrorEnum.E_Sign_Error);
        }
        return signatureString;
    }
    
    
    
    /**
     * 读取cer并验证公钥签名
     */
    public  static  void read_cer_and_verify_sign(String requsetBody,byte[] cerkey, String signature) {
       
        X509Certificate cert = null;
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            InputStream fis = new ByteArrayInputStream(cerkey);
            cert = (X509Certificate) cf
                    .generateCertificate(fis);
            fis.close();
            PublicKey publicKey = cert.getPublicKey();
            String publicKeyString = new String(Base64.encodeBase64(publicKey
                    .getEncoded()));
            Signature verifySign = Signature.getInstance("SHA1withRSA");
            verifySign.initVerify(publicKey);
            // 用于验签的数据
            verifySign.update(requsetBody.getBytes());
            boolean flag = verifySign.verify(Base64
                    .decodeFast(signature));// 验签由第三方做
        } catch (Exception e) {
           throw new ApiException(ApiErrorEnum.A_Sign_Error);
        }

    }

}
