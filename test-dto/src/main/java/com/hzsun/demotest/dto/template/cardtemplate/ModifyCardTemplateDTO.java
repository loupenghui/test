package com.hzsun.demotest.dto.template.cardtemplate;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;


/**
 * @Description:
 * @Author: dingjl
 * @Date: 2017年6月19日
 **/
public class ModifyCardTemplateDTO {

    // request_id String 必须 32 请求ID，由开发者生成并保证唯一性 2016072600000000000000001
    @JSONField(ordinal=0,name="request_id")
    private String request_id;
    // card_type String 必须 32 卡类型为固定枚举类型，可选类型如下：
    // OUT_MEMBER_CARD：外部权益卡 OUT_MEMBER_CARD
    @JSONField(ordinal=1)
    private String template_id;
    
    // 修改中没有该参数
//    @JSONField(ordinal=10,name="card_type")
//    private String card_type = "OUT_MEMBER_CARD";
    
    // biz_no_prefix String 可选 10 业务卡号前缀，由商户自定义 prex
    @JSONField(ordinal=20,name="biz_no_prefix")
    
    private String biz_no_prefix;
 // 修改中没有该参数
//    // biz_no_suffix_len String 必须 2 业务卡号后缀长度，最大int值不能超过32-biz_no_suffix长度 10
//    @JSONField(ordinal=30,name="biz_no_suffix_len")
//    private String biz_no_suffix_len;
    
    
    // write_off_type String 必须 32 卡包详情页面中展现出的卡码（可用于扫码核销）
    // qrcode: 二维码
    // dqrcode: 动态二维码
    // barcode: 条码
    // dbarcode: 动态条码
    // text: 文本
    @JSONField(ordinal=4,name="write_off_type")
    private String  write_off_type;
    @JSONField(ordinal=5) //name="template_benefit_info"
    private TemplateStyleInfoDTO     template_style_info;                      //templateStyleInfo;
    @JSONField(ordinal=6) //name="column_info_list" 
    private List<TemplateColumnInfoDTO>  column_info_list ;//listTemplateColumnInfo;
    
    
    @JSONField(ordinal=7)  //name="field_rule_list"
    private List<TemplateFieldRuleDTO>   field_rule_list ;//; listTemplateFieldRule;
    
    @JSONField(ordinal=8)  //name="field_rule_list"
    private List<TemplateActionInfoDTO>   card_action_list ;//; listTemplateFieldRule;
    
    
    @JSONField(ordinal=20,name="card_spec_tag")
    private String  cardspectag="COLLEGE_CARD";
    
	public String getRequest_id() {
		return request_id;
	}

	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getBiz_no_prefix() {
		return biz_no_prefix;
	}

	public void setBiz_no_prefix(String biz_no_prefix) {
		this.biz_no_prefix = biz_no_prefix;
	}

	public String getWrite_off_type() {
		return write_off_type;
	}

	public void setWrite_off_type(String write_off_type) {
		this.write_off_type = write_off_type;
	}

	public TemplateStyleInfoDTO getTemplate_style_info() {
		return template_style_info;
	}

	public void setTemplate_style_info(TemplateStyleInfoDTO template_style_info) {
		this.template_style_info = template_style_info;
	}

	public List<TemplateColumnInfoDTO> getColumn_info_list() {
		return column_info_list;
	}

	public void setColumn_info_list(List<TemplateColumnInfoDTO> column_info_list) {
		this.column_info_list = column_info_list;
	}

	public List<TemplateFieldRuleDTO> getField_rule_list() {
		return field_rule_list;
	}

	public void setField_rule_list(List<TemplateFieldRuleDTO> field_rule_list) {
		this.field_rule_list = field_rule_list;
	}

	public List<TemplateActionInfoDTO> getCard_action_list() {
		return card_action_list;
	}

	public void setCard_action_list(List<TemplateActionInfoDTO> card_action_list) {
		this.card_action_list = card_action_list;
	}

    public String getCardspectag() {
        return cardspectag;
    }

    public void setCardspectag(String cardspectag) {
        this.cardspectag = cardspectag;
    }


}
