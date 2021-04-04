package com.hzsun.demotest.qo;

import java.io.Serializable;

public class LiLicenseinterfaceQuery implements Serializable{

	private static final long serialVersionUID = -139475182200550669L;

	private String appid;

	private String interfacecode;

    private String interfacename;

    private String parentcode;

    private Integer permission;

    private Integer sortid;

    private String remark;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getInterfacecode() {
		return interfacecode;
	}

	public void setInterfacecode(String interfacecode) {
		this.interfacecode = interfacecode;
	}

	public String getInterfacename() {
		return interfacename;
	}

	public void setInterfacename(String interfacename) {
		this.interfacename = interfacename;
	}

	public String getParentcode() {
		return parentcode;
	}

	public void setParentcode(String parentcode) {
		this.parentcode = parentcode;
	}

	public Integer getPermission() {
		return permission;
	}

	public void setPermission(Integer permission) {
		this.permission = permission;
	}

	public Integer getSortid() {
		return sortid;
	}

	public void setSortid(Integer sortid) {
		this.sortid = sortid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
    
}
