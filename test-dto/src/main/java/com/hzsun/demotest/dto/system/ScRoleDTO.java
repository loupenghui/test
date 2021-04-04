package com.hzsun.demotest.dto.system;

import java.io.Serializable;

public class ScRoleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer rolenum;

	private String rolename;

	private Integer recflag;

	private String remark;

	private Integer roletype;

	public Integer getRolenum() {
		return rolenum;
	}

	public void setRolenum(Integer rolenum) {
		this.rolenum = rolenum;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Integer getRecflag() {
		return recflag;
	}

	public void setRecflag(Integer recflag) {
		this.recflag = recflag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getRoletype() {
		return roletype;
	}

	public void setRoletype(Integer roletype) {
		this.roletype = roletype;
	}

	
	

}