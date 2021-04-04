package com.hzsun.demotest.qo;

import java.io.Serializable;

public class ApplicationpayParamQuery implements Serializable {
	private static final long serialVersionUID = -4359661460676255087L;

	private Integer flag;

    private String payparam;

    private String appid;

    private String paychannelid;
    
    private String merchantid;
    
    private String appname;
    
    private Integer classauth;

    private Integer authtype;

    private Integer defaultreceive; 
    
    public ApplicationpayParamQuery() {}
    public ApplicationpayParamQuery(String appid, String paychannelid) {
    	this.appid = appid;
    	this.paychannelid = paychannelid;
    }
	public Integer getClassauth() {
		return classauth;
	}

	public void setClassauth(Integer classauth) {
		this.classauth = classauth;
	}

	public Integer getAuthtype() {
		return authtype;
	}

	public void setAuthtype(Integer authtype) {
		this.authtype = authtype;
	}

	public Integer getDefaultreceive() {
		return defaultreceive;
	}

	public void setDefaultreceive(Integer defaultreceive) {
		this.defaultreceive = defaultreceive;
	}

	public String getMerchantid() {
		return merchantid;
	}

	public void setMerchantid(String merchantid) {
		this.merchantid = merchantid;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getPayparam() {
		return payparam;
	}

	public void setPayparam(String payparam) {
		this.payparam = payparam;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getPaychannelid() {
		return paychannelid;
	}

	public void setPaychannelid(String paychannelid) {
		this.paychannelid = paychannelid;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}
    
    
}
