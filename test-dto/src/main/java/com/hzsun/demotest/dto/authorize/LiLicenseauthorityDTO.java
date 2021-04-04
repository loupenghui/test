package com.hzsun.demotest.dto.authorize;

import java.io.Serializable;

public class LiLicenseauthorityDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String appid;

    private String interfacecode;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getInterfacecode() {
        return interfacecode;
    }

    public void setInterfacecode(String interfacecode) {
        this.interfacecode = interfacecode == null ? null : interfacecode.trim();
    }
}
