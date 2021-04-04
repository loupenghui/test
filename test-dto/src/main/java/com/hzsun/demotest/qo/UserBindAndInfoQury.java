package com.hzsun.demotest.qo;

import java.io.Serializable;

public class UserBindAndInfoQury extends UserbindQuery implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userid;// 用户表示

	private String username;

	// 用户证件类型 0:身份证1:护照2:军官证3:士兵证4:回乡证5:临时身份证6:户口簿7:警官证8:台胞证9:营业执照
	// 10:其他证件11:港澳居民来往内地通行证12:台湾居民来往内地通行证
	private Short idtype;

	private String idno;// 用户证件号

	private String contant; // 联系方式

	private short gender; // 性别

	private String email;

	private short authchannel; // 认证渠道 1 支付宝 2 微信 3 银联 4 校园卡

	private short flag;// userbind-有效表示

	private String binddate;// userbind-绑定时间

	private String appname;// 应用名称

	private String binddatemin; // 最小领卡时间

	private String binddatemax; // 最大领卡时间

	public String getBinddatemin() {
		return binddatemin;
	}

	public void setBinddatemin(String binddatemin) {
		this.binddatemin = binddatemin;
	}

	public String getBinddatemax() {
		return binddatemax;
	}

	public void setBinddatemax(String binddatemax) {
		this.binddatemax = binddatemax;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public short getGender() {
		return gender;
	}

	public void setGender(short gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public short getAuthchannel() {
		return authchannel;
	}

	public void setAuthchannel(short authchannel) {
		this.authchannel = authchannel;
	}

	public short getFlag() {
		return flag;
	}

	public void setFlag(short flag) {
		this.flag = flag;
	}

	public String getBinddate() {
		return binddate;
	}

	public void setBinddate(String binddate) {
		this.binddate = binddate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Short getIdtype() {
		return idtype;
	}

	public void setIdtype(Short idtype) {
		this.idtype = idtype;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getContant() {
		return contant;
	}

	public void setContant(String contant) {
		this.contant = contant;
	}

}
