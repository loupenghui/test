package com.hzsun.demotest.qo;

import java.io.Serializable;

/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年4月27日  
**/
public class ApplicationPayQuery  implements Serializable {   
    private static final long serialVersionUID = 1L;

    private String appid;

    private String paychannelid;
    
    private Integer flag;

    public String getAppid() {
    
        return appid;
    }

    public void setAppid(String appid) {
    
        this.appid = appid;
    }

    public String getPaychannelid() {
    
        return paychannelid;
    }

    public void setPaychannelid(String paychannelid) {
    
        this.paychannelid = paychannelid;
    }

    public Integer getFlag() {
    
        return flag;
    }

    public void setFlag(Integer flag) {
    
        this.flag = flag;
    }
    

}
  
    