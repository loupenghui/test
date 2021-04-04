package com.hzsun.demotest.dto.template.cardtemplate;

import com.alibaba.fastjson.annotation.JSONField;

/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2017年8月3日  
**/
public class MoreInfo {
//    └ title String 必填 16 二级页面标题 会员专享权益
    @JSONField(ordinal=0)
    private String title;
//    └ url String 可选 256 超链接(选择openweb的时候必须填写url参数内容) http://www.baidu.com
    @JSONField(ordinal=1)
    private String url;
//    └ params String 可选 1024 扩展参数，需要URL地址回带的值，JSON格式(openweb时填) {}
    @JSONField(ordinal=2)
    private String params;
//    └ descs String [] 可选 1000 选择opennative的时候必须填写descs的内容 会员生日7折
    @JSONField(ordinal=3)
    private String[] descs;
    public String getTitle() {
    
        return title;
    }
    public void setTitle(String title) {
    
        this.title = title;
    }
    public String getUrl() {
    
        return url;
    }
    public void setUrl(String url) {
    
        this.url = url;
    }
    public String getParams() {
    
        return params;
    }
    public void setParams(String params) {
    
        this.params = params;
    }
    public String[] getDescs() {
    
        return descs;
    }
    public void setDescs(String[] descs) {
    
        this.descs = descs;
    }

}
  
    