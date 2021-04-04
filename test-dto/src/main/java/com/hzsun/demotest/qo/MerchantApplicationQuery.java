package com.hzsun.demotest.qo;

import java.io.Serializable;

public class MerchantApplicationQuery implements Serializable{

	private static final long serialVersionUID = 6088464907088475793L;
	
	private String appid;
    
    private String merchantid;

    private String appname;

    private Integer defaultapplication;

    private Integer defaultsend;

    private Integer encrypttype;

    private String publickey;

    private String systempublickey;

    private String systemprivatekey;

    private String authurl;

    private String redirecturl;

    private String contact;

    private String contacttel;

    private Integer flag;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMerchantid() {
		return merchantid;
	}

	public void setMerchantid(String merchantid) {
		this.merchantid = merchantid;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public Integer getDefaultapplication() {
		return defaultapplication;
	}

	public void setDefaultapplication(Integer defaultapplication) {
		this.defaultapplication = defaultapplication;
	}

	public Integer getDefaultsend() {
		return defaultsend;
	}

	public void setDefaultsend(Integer defaultsend) {
		this.defaultsend = defaultsend;
	}

	public Integer getEncrypttype() {
		return encrypttype;
	}

	public void setEncrypttype(Integer encrypttype) {
		this.encrypttype = encrypttype;
	}

	public String getPublickey() {
		return publickey;
	}

	public void setPublickey(String publickey) {
		this.publickey = publickey;
	}

	public String getSystempublickey() {
		return systempublickey;
	}

	public void setSystempublickey(String systempublickey) {
		this.systempublickey = systempublickey;
	}

	public String getSystemprivatekey() {
		return systemprivatekey;
	}

	public void setSystemprivatekey(String systemprivatekey) {
		this.systemprivatekey = systemprivatekey;
	}

	public String getAuthurl() {
		return authurl;
	}

	public void setAuthurl(String authurl) {
		this.authurl = authurl;
	}

	public String getRedirecturl() {
		return redirecturl;
	}

	public void setRedirecturl(String redirecturl) {
		this.redirecturl = redirecturl;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContacttel() {
		return contacttel;
	}

	public void setContacttel(String contacttel) {
		this.contacttel = contacttel;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
}
