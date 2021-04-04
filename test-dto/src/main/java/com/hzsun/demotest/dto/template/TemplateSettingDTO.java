package com.hzsun.demotest.dto.template;

import java.io.Serializable;

public class TemplateSettingDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String templateid;

    private String remark;

    private String params;
    
    private String applicationid;

    private String paychannelid;
    
    // 其他
    private String appname;
    
    private String paychannelname;

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getPaychannelname() {
		return paychannelname;
	}

	public void setPaychannelname(String paychannelname) {
		this.paychannelname = paychannelname;
	}

	public String getTemplateid() {
		return templateid;
	}

	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getApplicationid() {
		return applicationid;
	}

	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}

	public String getPaychannelid() {
		return paychannelid;
	}

	public void setPaychannelid(String paychannelid) {
		this.paychannelid = paychannelid;
	}
    
    
}
