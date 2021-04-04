package com.hzsun.demotest.dto.template.cardtemplate;

import com.alibaba.fastjson.annotation.JSONField;

/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2017年6月19日  
**/
public class TemplateColumnInfoDTO {
    
    // └ code String 必填 32 标准栏位：行为由支付宝统一定，同时已经分配标准Code
    // BALANCE：会员卡余额
    // POINT：积分
    // LEVEL：等级
    // TELEPHOME：联系方式
    @JSONField(ordinal=0)
    private  String code;
    // 自定义栏位：行为由商户定义，自定义Code码（只要无重复） BENEFIT_INFO
    //  more_info MoreInfoDTO 可选 2048 扩展信息
    @JSONField(ordinal=1)
    private MoreInfo more_info;
    // └ title String 必填 16 栏目的标题 会员专享
    @JSONField(ordinal=2)
    private  String title;
    // └ operate_type String 必填 32 1、openNative：打开二级页面，展现 more中descs
    @JSONField(ordinal=3,name="operate_type")
    private  String operate_type;
    // 2、openWeb：打开URL
    // 3、staticinfo：静态信息 openWeb
    // └ value String 可选 16 卡包详情页面，卡栏位右边展现的值 80
    @JSONField(ordinal=4)
    private  String value;
    public String getCode() {
    
        return code;
    }
    public void setCode(String code) {
    
        this.code = code;
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
    public MoreInfo getMore_info() {
    
        return more_info;
    }
    public void setMore_info(MoreInfo more_info) {
    
        this.more_info = more_info;
    }

    
}
  
    