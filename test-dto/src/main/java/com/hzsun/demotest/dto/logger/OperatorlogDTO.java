package com.hzsun.demotest.dto.logger;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Author: louph
 * @Date: 2018/10/26 0026
 */
public class OperatorlogDTO implements Serializable {
	private static final long serialVersionUID = 8769490354260011432L;

	private String recnum;

	private Integer operatornum;

	private String ipaddress;

	private Integer operatetype;

	private Date operatetime;

	private String remark;

	private String systemnum;

	private String optname;//操作员

	private String operatecontent;

	private String operatetimestr;

//	private Date operatetime;
//	private Integer operatortype

	public String getRecnum() {
		return recnum;
	}

	public void setRecnum(String recnum) {
		this.recnum = recnum;
	}

	public Integer getOperatornum() {
		return operatornum;
	}

	public void setOperatornum(Integer operatornum) {
		this.operatornum = operatornum;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public Integer getOperatetype() {
		return operatetype;
	}

	public void setOperatetype(Integer operatetype) {
		this.operatetype = operatetype;
	}

	public Date getOperatetime() {
		return operatetime;
	}

	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSystemnum() {
		return systemnum;
	}

	public void setSystemnum(String systemnum) {
		this.systemnum = systemnum;
	}

	public String getOptname() {
		return optname;
	}

	public void setOptname(String optname) {
		this.optname = optname;
	}

	public String getOperatecontent() {
		return operatecontent;
	}

	public void setOperatecontent(String operatecontent) {
		this.operatecontent = operatecontent;
	}

	public String getOperatetimestr() {
		return operatetimestr;
	}

	public void setOperatetimestr(String operatetimestr) {
		this.operatetimestr = operatetimestr;
	}
}
