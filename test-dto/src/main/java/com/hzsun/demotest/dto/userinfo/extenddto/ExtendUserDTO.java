package com.hzsun.demotest.dto.userinfo.extenddto;

import com.hzsun.demotest.dto.userinfo.UserbindDTO;

import java.util.Date;

public class ExtendUserDTO extends UserbindDTO {
	private String appname;
	
	private String username;
	
	private String userid;
	
	private String binddateStr;
	
	private Short idtype;

    private String idno;

    private String contant;

    private String email;

    private Short authchannel;

    private Short gender;

    private String country;

    private String province;

    private String city;

    private String avatar;

    private Date createtime;

    private String paychannelname;

    private String flagValue;

    private String bindId;

    private String channelId;

	public String getBindId() {
		return bindId;
	}

	public void setBindId(String bindId) {
		this.bindId = bindId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getFlagValue() {
		return flagValue;
	}

	public void setFlagValue(String flagValue) {
		this.flagValue = flagValue;
	}

	public String getPaychannelname() {
		return paychannelname;
	}

	public void setPaychannelname(String paychannelname) {
		this.paychannelname = paychannelname;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Short getAuthchannel() {
		return authchannel;
	}

	public void setAuthchannel(Short authchannel) {
		this.authchannel = authchannel;
	}

	public Short getGender() {
		return gender;
	}

	public void setGender(Short gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getBinddateStr() {
		return binddateStr;
	}

	public void setBinddateStr(String binddateStr) {
		this.binddateStr = binddateStr;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
