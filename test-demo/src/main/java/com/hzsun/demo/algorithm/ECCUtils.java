package com.hzsun.demo.algorithm;

/**
 * @Description:
 * @Author: louph
 * @Date: 2019/5/8 0008
 */

import org.apache.tomcat.util.codec.binary.StringUtils;
import org.bouncycastle.util.encoders.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class ECCUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(ECCUtils.class);
	private static final String PROVIDER = "BC";

	private static final byte[] PUB_KEY_TL= new byte[26];

	static {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

		try {
			KeyPair keyPair = genKeyPair();
			PublicKey publicKeyExample = keyPair.getPublic();
			System.arraycopy(publicKeyExample.getEncoded(), 0, PUB_KEY_TL, 0, 26);
		} catch (Exception e) {
			LOGGER.error("无法初始化算法", e);
		}
	}

	public static KeyPair genKeyPair() throws NoSuchAlgorithmException, NoSuchProviderException {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC", PROVIDER);
		keyPairGenerator.initialize(256, new SecureRandom());
		return keyPairGenerator.generateKeyPair();
	}

	public static String encodePublicKey(PublicKey publicKey) {
		return StringUtils.newStringUtf8(Base64.encode(publicKey.getEncoded()));
	}

	public static PublicKey decodePublicKey(String keyStr)
			throws NoSuchProviderException, NoSuchAlgorithmException {
		byte[] keyBytes = getPubKeyTLV(keyStr);

		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("EC", PROVIDER);
		try {
			return keyFactory.generatePublic(keySpec);
		} catch (InvalidKeySpecException e) {
			LOGGER.error("无效的ECC公钥", e);
			return null;
		}
	}

	private static byte[] getPubKeyTLV(String keyStr) {
		byte[] keyBytes = Base64.decode(StringUtils.getBytesUtf8(keyStr));

		if(keyBytes.length == 65) {
			byte[] tlv = new byte[91];
			System.arraycopy(PUB_KEY_TL, 0, tlv, 0, 26);
			System.arraycopy(keyBytes, 0, tlv, 26, 65);
			return tlv;
		}

		return keyBytes;
	}

	public static String encodePrivateKey(PrivateKey privateKey) {
		return StringUtils.newStringUtf8(Base64.encode(privateKey.getEncoded()));
	}

	public static PrivateKey decodePrivateKey(String keyStr)
			throws NoSuchProviderException, NoSuchAlgorithmException {
		byte[] keyBytes = Base64.decode(StringUtils.getBytesUtf8(keyStr));
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("EC", PROVIDER);
		try {
			return keyFactory.generatePrivate(keySpec);
		} catch (InvalidKeySpecException e) {
			LOGGER.error("无效的ECC私钥", e);
			return null;
		}
	}

	public static byte[] encrypt(byte[] content, PublicKey publicKey)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchProviderException {
		Cipher cipher = Cipher.getInstance("ECIES", PROVIDER);
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return cipher.doFinal(content);
	}

	public static byte[] decrypt(byte[] content, PrivateKey privateKey)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchProviderException {
		Cipher cipher = Cipher.getInstance("ECIES", PROVIDER);
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		return cipher.doFinal(content);
	}

	public static byte[] signature(byte[] content, PrivateKey privateKey)
			throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
		Signature signature = Signature.getInstance("SHA256withECDSA");
		signature.initSign(privateKey);
		signature.update(content);
		return signature.sign();
	}

	public static boolean verify(byte[] content, byte[] sign, PublicKey publicKey)
			throws NoSuchAlgorithmException, InvalidKeyException {
		Signature signature = Signature.getInstance("SHA256withECDSA");
		signature.initVerify(publicKey);
		try {
			signature.update(content);
			return signature.verify(sign);
		} catch (SignatureException e) {
			LOGGER.warn("无效的签名", e);
			return false;
		}

	}
}
