package com.hzsun.demotest.qo;

import java.io.Serializable;

public class OperatorQuery implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer optnum;

	private String optname;

	private String idno;

	private Integer recflag;

	private String phoneno;

	private String email;

	private Integer rolenum;
	
	private String token;
	
	private String remark;
	
	private Short isDefaultPWD;
	
	public Short getIsDefaultPWD() {
		return isDefaultPWD;
	}

	public void setIsDefaultPWD(Short isDefaultPWD) {
		this.isDefaultPWD = isDefaultPWD;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getOptnum() {
		return optnum;
	}

	public void setOptnum(Integer optnum) {
		this.optnum = optnum;
	}

	public String getOptname() {
		return optname;
	}

	public void setOptname(String optname) {
		this.optname = optname;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public Integer getRecflag() {
		return recflag;
	}

	public void setRecflag(Integer recflag) {
		this.recflag = recflag;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRolenum() {
		return rolenum;
	}

	public void setRolenum(Integer rolenum) {
		this.rolenum = rolenum;
	}
	
	
	
	

}
