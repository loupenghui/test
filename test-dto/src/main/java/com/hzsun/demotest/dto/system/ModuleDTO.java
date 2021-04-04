package com.hzsun.demotest.dto.system;

import java.io.Serializable;
import java.math.BigDecimal;

public class ModuleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String modulecode;

	private String parentcode;

	private String modulename;

	private Short sortid;

	private String remark;

	private BigDecimal isauthority;

	private String moduletag;
	
	private Integer rolenum;

	private String rolename;

	private Integer recflag;
	

	public String getModulecode() {
		return modulecode;
	}

	public void setModulecode(String modulecode) {
		this.modulecode = modulecode == null ? null : modulecode.trim();
	}

	public String getParentcode() {
		return parentcode;
	}

	public void setParentcode(String parentcode) {
		this.parentcode = parentcode == null ? null : parentcode.trim();
	}

	public String getModulename() {
		return modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename == null ? null : modulename.trim();
	}

	public Short getSortid() {
		return sortid;
	}

	public void setSortid(Short sortid) {
		this.sortid = sortid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public BigDecimal getIsauthority() {
		return isauthority;
	}

	public void setIsauthority(BigDecimal isauthority) {
		this.isauthority = isauthority;
	}

	public String getModuletag() {
		return moduletag;
	}

	public void setModuletag(String moduletag) {
		this.moduletag = moduletag == null ? null : moduletag.trim();
	}

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