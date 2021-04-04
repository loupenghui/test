package com.hzsun.demotest.response;

import java.io.Serializable;

/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年5月4日  
**/
public class SystemOauthTokenResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String userId;
    
    private String accessToken;

    public String getUserId() {
    
        return userId;
    }

    public void setUserId(String userId) {
    
        this.userId = userId;
    }

    public String getAccessToken() {
    
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
    
        this.accessToken = accessToken;
    }
    
}
  
    