package com.hzsun.demotest.dto.merchant;

import java.io.Serializable;

public class MerchantApplicationExpandDTO implements Serializable{
	private static final long serialVersionUID = 837292484679777963L;
	private String appid;
	private String authid;
	private String authcontent;
	private byte[] cert;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getAuthid() {
		return authid;
	}
	public void setAuthid(String authid) {
		this.authid = authid;
	}
	public String getAuthcontent() {
		return authcontent;
	}
	public void setAuthcontent(String authcontent) {
		this.authcontent = authcontent;
	}
	public byte[] getCert() {
		return cert;
	}
	public void setCert(byte[] cert) {
		this.cert = cert;
	}
	
	
}
