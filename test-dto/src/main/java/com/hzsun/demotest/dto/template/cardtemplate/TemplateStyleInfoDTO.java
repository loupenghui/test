package com.hzsun.demotest.dto.template.cardtemplate;

import com.alibaba.fastjson.annotation.JSONField;

/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2017年6月19日  
**/
public class TemplateStyleInfoDTO {
    // └ card_show_name String 必填 10 钱包端显示名称（字符串长度） 花呗联名卡
    @JSONField(ordinal=0,name="card_show_name")
    private String card_show_name;
    // └ logo_id String 必填 1000
    // logo的图片ID，通过接口（alipay.offline.material.image.upload）上传图片
    // 图片说明：1M以内，格式bmp、png、jpeg、jpg、gif；
    // 尺寸不小于500*500px的正方形；
    // 请优先使用商家LOGO； 1T8Pp00AT7eo9NoAJkMR3AAAACMAAQEC
    @JSONField(ordinal=1,name="logo_id")
    private String logo_id;
    // └ color String 必填 64 卡片颜色 rgb(55,112,179)
    @JSONField(ordinal=2,name="color")
    private String color;
    // └ background_id String 必填 1000
    // 背景图片Id，通过接口（alipay.offline.material.image.upload）上传图片
    // 图片说明：2M以内，格式：bmp、png、jpeg、jpg、gif；
    // 尺寸不小于1020*643px；
    // 图片不得有圆角，不得拉伸变形 1T8Pp00AT7eo9NoAJkMR3AAAACMAAQEC
    @JSONField(ordinal=2,name="background_id")
    private String background_id;
    // └ bg_color String 必填 32 背景色 rgb(55,112,179)
    @JSONField(ordinal=3,name="bg_color")
    private String bg_color;
    // └ feature_descriptions String [] 可选 4000 特色信息，用于领卡预览 使用花呗卡可享受免费分期
    @JSONField(ordinal=4,name="feature_descriptions")
    private String[] feature_descriptions;
    // └ slogan String 可选 100 标语 会员权益享不停
    @JSONField(ordinal=5,name="slogan")
    private String slogan;
    // └ slogan_img_id String 可选 100 标语图片，
    // 通过接口（alipay.offline.material.image.upload）上传图片
    // 1T8Pp00AT7eo9NoAJkMR3AAAACMAAQEC
    @JSONField(ordinal=6,name="slogan_img_id")
    private String slogan_img_id;
    // └ brand_name String 可选 100 品牌商名称 可乐
    @JSONField(ordinal=7,name="brand_name")
    private String brand_name;
    // 文案信息分行展示，最多展示3行文案，每行文案分为label和value两部分； 
	//    文案实际内容随创建卡/更新卡时传入； 
	//    详见会员卡产品说明文档。
//    @JSONField(ordinal=8,name="front_text_list_enable")
//    private boolean front_text_list_enable;
    
    
	// 以下为 其他非模本字段
    @JSONField(serialize = false)  // toString时忽略
    private String logopath;// logo图片路径
    @JSONField(serialize = false)  
    private String backgroundpath;// 背景图片路径
	public String getLogopath() {
		return logopath;
	}
	public void setLogopath(String logopath) {
		this.logopath = logopath;
	}
	public String getBackgroundpath() {
		return backgroundpath;
	}
	public void setBackgroundpath(String backgroundpath) {
		this.backgroundpath = backgroundpath;
	}
	public String getCard_show_name() {
		return card_show_name;
	}
	public void setCard_show_name(String card_show_name) {
		this.card_show_name = card_show_name;
	}
	public String getLogo_id() {
		return logo_id;
	}
	public void setLogo_id(String logo_id) {
		this.logo_id = logo_id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBackground_id() {
		return background_id;
	}
	public void setBackground_id(String background_id) {
		this.background_id = background_id;
	}
	public String getBg_color() {
		return bg_color;
	}
	public void setBg_color(String bg_color) {
		this.bg_color = bg_color;
	}
	
	
	public String[] getFeature_descriptions() {
		return feature_descriptions;
	}
	public void setFeature_descriptions(String[] feature_descriptions) {
		this.feature_descriptions = feature_descriptions;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public String getSlogan_img_id() {
		return slogan_img_id;
	}
	public void setSlogan_img_id(String slogan_img_id) {
		this.slogan_img_id = slogan_img_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	
	
    
}
  
    