package com.hzsun.demotest.dto.template.cardtemplate;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * @Description:
 * @Author: dingjl
 * @Date: 2017年6月19日
 **/
public class CardTemplateInfoDTO extends ModifyCardTemplateDTO{

	@JSONField(ordinal=10,name="card_type")
    private String card_type = "OUT_MEMBER_CARD";

	// biz_no_suffix_len String 必须 2 业务卡号后缀长度，最大int值不能超过32-biz_no_suffix长度 10
    @JSONField(ordinal=30,name="biz_no_suffix_len")
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
