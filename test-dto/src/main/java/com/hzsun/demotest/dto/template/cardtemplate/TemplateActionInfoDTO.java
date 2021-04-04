package com.hzsun.demotest.dto.template.cardtemplate;

import com.alibaba.fastjson.annotation.JSONField;

public class TemplateActionInfoDTO {
	
//	└ code	String	必填	32	行动点业务CODE，商户自定义	TO_CLOCK_IN
	 @JSONField(ordinal=0)
	private String  code;
//	└ text	String	必填	6	行动点展示文案	打卡
	 @JSONField(ordinal=1)
	private String text;
//	└ url	String	必填	1024	行动点跳转链接	https://merchant.ali.com/ee/clock_in.do
	 @JSONField(ordinal=3)
	 
	private String url;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
