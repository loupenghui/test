package com.hzsun.demotest.qo;

import java.io.Serializable;

public class RoleQuery implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer rolenum;

	private String rolename;

	private Integer recflag;
	

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

}
