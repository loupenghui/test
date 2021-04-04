package com.hzsun.demotest.dto.report;

import java.io.Serializable;

/**
 * @Description:
 * @Author: louph
 * @Date: 2018/10/19 0019
 */
public class BaseReportDTO implements Serializable {

	private static final long serialVersionUID = 8502449007149623515L;
	private String merchantid;

	private String merchantname;

	private String appid;

	private String appname;

	private String paychannelid;

	private String paychannelname;

	private String flagname;

	private Integer num;

	public String getMerchantid() {
		return merchantid;
	}

	public void setMerchantid(String merchantid) {
		this.merchantid = merchantid;
	}

	public String getMerchantname() {
		return merchantname;
	}

	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getPaychannelid() {
		return paychannelid;
	}

	public void setPaychannelid(String paychannelid) {
		this.paychannelid = paychannelid;
	}

	public String getPaychannelname() {
		return paychannelname;
	}

	public void setPaychannelname(String paychannelname) {
		this.paychannelname = paychannelname;
	}

	public String getFlagname() {
		return flagname;
	}

	public void setFlagname(String flagname) {
		this.flagname = flagname;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}
