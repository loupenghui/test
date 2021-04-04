package com.hzsun.demotest.dto.template.cardtemplate;

import com.alibaba.fastjson.annotation.JSONField;

/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2017年6月19日  
**/
public class TemplateFieldRuleDTO {

//    field_name String 必填 64 字段名称，现在支持如下几个Key（暂不支持自定义） 
//    Balance：金额 
//    Point：整数 
//    Level：任意字符串 
//    OpenDate：开卡日期 
//    ValidDate：过期日期 Balance
    @JSONField(ordinal=0,name="field_name")
    private String field_name;
//    └ rule_name String 必填 64 规则名 
//    1、ASSIGN_FROM_REQUEST: 以rule_value为key值，表示该栏位的值从会员卡开卡接口中获取，会员卡开卡接口的card_info中获取对应参数值 
//    2、DATE_IN_FUTURE: 生成一个未来的日期（格式YYYY-MM-DD)，当选择DATE_IN_FUTURE的时候，field_name 必须是OpenDate或ValidDate， 值为(10m或10d 分别表示10个月或10天) 
//    3、CONST: 常量，会员卡开卡接口进行开卡的时候使用模板创建时候设置的值，即取rule_value的值 ASSIGN_FROM_REQUEST
    @JSONField(ordinal=1,name="rule_name")
    private String rule_name;
//    └ rule_value String 必填 512 根据rule_name，采取相应取值策略 
//    CONST：直接取rule_value作为卡属性值 
//    DATE_IN_FUTURE：10m或10d 分别表示10个月或10天 
//    ASSIGN_FROM_REQUEST：在开卡Reuqest请求中按rule_value取值，现在和field_name对应的为（OpenDate、ValidDate、Level、Point、Balance） Balance
    @JSONField(ordinal=2,name="rule_value")
    private String rule_value;
	public String getField_name() {
		return field_name;
	}
	public void setField_name(String field_name) {
		this.field_name = field_name;
	}
	public String getRule_name() {
		return rule_name;
	}
	public void setRule_name(String rule_name) {
		this.rule_name = rule_name;
	}
	public String getRule_value() {
		return rule_value;
	}
	public void setRule_value(String rule_value) {
		this.rule_value = rule_value;
	}
    
    
    
    
    
}
  
    