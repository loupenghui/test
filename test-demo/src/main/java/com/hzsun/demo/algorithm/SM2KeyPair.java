package com.hzsun.demo.algorithm;

import org.bouncycastle.math.ec.ECPoint;

import java.math.BigInteger;

/**
 * 	 <B>说	明<B/>:SM2公私钥实体类
 *
 * @version 版   本  号：1.0.<br/>
 *          创建时间：2018年3月6日 上午9:43:56
 */
public class SM2KeyPair {

	/** 公钥 */
	private  ECPoint publicKey;

	/** 私钥 */
	private BigInteger privateKey;

	SM2KeyPair(ECPoint publicKey, BigInteger privateKey) {
		this.publicKey = publicKey;
		this.privateKey = privateKey;
	}

	public ECPoint getPublicKey() {
		return publicKey;
	}

	public BigInteger getPrivateKey() {
		return privateKey;
	}

}
