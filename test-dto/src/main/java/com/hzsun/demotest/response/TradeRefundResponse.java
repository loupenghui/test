package com.hzsun.demotest.response;

import java.util.Date;

/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年5月2日  
**/
public class TradeRefundResponse  {
    
    private String  refundAmount;
    
    private Date refundtime;
    
    private String  refundTradeNo;
    
    private String refundUserId;
    
    private Date  clearTime;
    
    private String remark;

    public String getRefundAmount() {
    
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
    
        this.refundAmount = refundAmount;
    }

    public Date getRefundtime() {
    
        return refundtime;
    }

    public void setRefundtime(Date refundtime) {
    
        this.refundtime = refundtime;
    }

    public String getRefundTradeNo() {
    
        return refundTradeNo;
    }

    public void setRefundTradeNo(String refundTradeNo) {
    
        this.refundTradeNo = refundTradeNo;
    }

    public String getRefundUserId() {
    
        return refundUserId;
    }

    public void setRefundUserId(String refundUserId) {
    
        this.refundUserId = refundUserId;
    }

    public Date getClearTime() {
    
        return clearTime;
    }

    public void setClearTime(Date clearTime) {
    
        this.clearTime = clearTime;
    }

    public String getRemark() {
    
        return remark;
    }

    public void setRemark(String remark) {
    
        this.remark = remark;
    }
    
    
    
}
  
    