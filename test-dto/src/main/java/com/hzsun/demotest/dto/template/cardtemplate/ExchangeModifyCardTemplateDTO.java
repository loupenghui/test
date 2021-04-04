package com.hzsun.demotest.dto.template.cardtemplate;

import java.util.List;

public class ExchangeModifyCardTemplateDTO {


    private String request_id;
    private String template_id;
    private String biz_no_prefix;
    private String  write_off_type;
    private TemplateStyleInfoDTO     template_style_info;                      //templateStyleInfo;
    private List<ExtendTemplateColumnInfoDTO>  column_info_list ;//listTemplateColumnInfo;
    private List<TemplateFieldRuleDTO>   field_rule_list ;//; listTemplateFieldRule;
    private List<ExtendTemplateActionInfoDTO>   card_action_list ;//; listTemplateFieldRule;
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
	public List<ExtendTemplateColumnInfoDTO> getColumn_info_list() {
		return column_info_list;
	}
	public void setColumn_info_list(List<ExtendTemplateColumnInfoDTO> column_info_list) {
		this.column_info_list = column_info_list;
	}
	public List<TemplateFieldRuleDTO> getField_rule_list() {
		return field_rule_list;
	}
	public void setField_rule_list(List<TemplateFieldRuleDTO> field_rule_list) {
		this.field_rule_list = field_rule_list;
	}
	public List<ExtendTemplateActionInfoDTO> getCard_action_list() {
		return card_action_list;
	}
	public void setCard_action_list(List<ExtendTemplateActionInfoDTO> card_action_list) {
		this.card_action_list = card_action_list;
	}

    
}
