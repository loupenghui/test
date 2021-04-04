package com.hzsun.demotest.dto.merchant;

import java.io.Serializable;

public class ApplicationpayParamDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private Integer flag;

    private String payparam;

    private String appid;

    private String paychannelid;
    
    private String paychannelname;
    
    private String appname;
    
    private Integer classauth;

    private Integer authtype;

    private Integer defaultreceive;

    public String getPaychannelname() {
		return paychannelname;
	}

	public void setPaychannelname(String paychannelname) {
		this.paychannelname = paychannelname;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

    public String getAppid() {

        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getPaychannelid() {
        return paychannelid;
    }

    public void setPaychannelid(String paychannelid) {
        this.paychannelid = paychannelid;
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
        this.payparam = payparam == null ? null : payparam.trim();
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
    
    
}