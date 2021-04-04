/**
 * 
 */
package com.hzsun.demotest.qo;

import java.io.Serializable;

/**
 * @ClassName TemplateSettingQuery
 * @Description 
 * @Author ZhaoXD Koliy
 * @Date 2018年5月10日 上午10:00:27
 */

public class TemplateSettingQuery implements Serializable {
	private static final long serialVersionUID = 1L;
	private String templateid;

    private String remark;

    private String params;
    
    private String applicationid;

    private String paychannelid;
    
    // 其他
    private String appname;
    
    private String paychannelname;

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
    
    
}
