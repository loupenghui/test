package com.hzsun.demotest.dto.merchant;

import java.io.Serializable;

public class MerchantApplicationDTO implements Serializable {
	private static final long serialVersionUID = 4345205308042539941L;

	private String appid;
    
    private String merchantid;
    
    private String merchantname;

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

    public String getMerchantname() {
		return merchantname;
	}

	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}

	public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname == null ? null : appname.trim();
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
        this.publickey = publickey == null ? null : publickey.trim();
    }

    public String getSystempublickey() {
        return systempublickey;
    }

    public void setSystempublickey(String systempublickey) {
        this.systempublickey = systempublickey == null ? null : systempublickey.trim();
    }

    public String getSystemprivatekey() {
        return systemprivatekey;
    }

    public void setSystemprivatekey(String systemprivatekey) {
        this.systemprivatekey = systemprivatekey == null ? null : systemprivatekey.trim();
    }

    public String getAuthurl() {
        return authurl;
    }

    public void setAuthurl(String authurl) {
        this.authurl = authurl == null ? null : authurl.trim();
    }

    public String getRedirecturl() {
        return redirecturl;
    }

    public void setRedirecturl(String redirecturl) {
        this.redirecturl = redirecturl == null ? null : redirecturl.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getContacttel() {
        return contacttel;
    }

    public void setContacttel(String contacttel) {
        this.contacttel = contacttel == null ? null : contacttel.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getMerchantid() {
    
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
    
        this.merchantid = merchantid;
    }
    
    
}