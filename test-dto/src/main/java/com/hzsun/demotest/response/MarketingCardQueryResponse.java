package com.hzsun.demotest.response;

import java.io.Serializable;

/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年5月8日  
**/
public class MarketingCardQueryResponse implements Serializable {
  
    private static final long serialVersionUID = 1L;
    
    private String schemaUrl;

    public String getSchemaUrl() {
    
        return schemaUrl;
    }

    public void setSchemaUrl(String schemaUrl) {
    
        this.schemaUrl = schemaUrl;
    }
    

}
  
    