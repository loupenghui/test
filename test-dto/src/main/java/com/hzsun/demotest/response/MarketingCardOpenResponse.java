package com.hzsun.demotest.response;

import java.io.Serializable;

/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年5月8日  
**/
public class MarketingCardOpenResponse implements Serializable {
  
    private static final long serialVersionUID = 1L;
    
    private String bizCardNo  ;

    public String getBizCardNo() {
    
        return bizCardNo;
    }

    public void setBizCardNo(String bizCardNo) {
    
        this.bizCardNo = bizCardNo;
    }

    

}
  
    