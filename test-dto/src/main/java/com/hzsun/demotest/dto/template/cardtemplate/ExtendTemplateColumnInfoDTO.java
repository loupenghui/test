package com.hzsun.demotest.dto.template.cardtemplate;

public class ExtendTemplateColumnInfoDTO{

	public String useflag;
    private  String code;
    private MoreInfo more_info;
    private  String title;
    private  String operate_type;
    private  String value;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public MoreInfo getMore_info() {
		return more_info;
	}

	public void setMore_info(MoreInfo more_info) {
		this.more_info = more_info;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOperate_type() {
		return operate_type;
	}

	public void setOperate_type(String operate_type) {
		this.operate_type = operate_type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUseflag() {
		return useflag;
	}

	public void setUseflag(String useflag) {
		this.useflag = useflag;
	}

	
	
}
