package com.hzsun.demotest.dto.template.cardtemplate;

public class ExchangeCardTemplateInfoDTO extends ExchangeModifyCardTemplateDTO{

    private String card_type = "OUT_MEMBER_CARD";
    private String biz_no_suffix_len;
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public String getBiz_no_suffix_len() {
		return biz_no_suffix_len;
	}
	public void setBiz_no_suffix_len(String biz_no_suffix_len) {
		this.biz_no_suffix_len = biz_no_suffix_len;
	}
    
    
}
