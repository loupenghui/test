package com.hzsun.demotest.response;

import java.util.Date;

/**
 * @Description:
 * @Author: dingjl
 * @Date: 2018年4月23日
 **/
public class TradePayResponse {
    // * @param payChannelId 支付渠道标识
    // * @param isSuccess 订单状态
    // * @param payAmount 订单支付金额
    // * @param paytime 支付日期
    // * @param payTradeNo 支付流水标识
    // * @param payUserId 支付用户标识
    // * @param clearTime 清算日期
    
    private  String  payChannelId;
    
    private  boolean  isSuccess;
    
    private String  payAmount;
    
    private Date paytime;
    
    private String  payTradeNo;
    
    private String payUserId;
    
    private Date  clearTime;
    
    private String tradeState;
    
    private String remark;

    private String code;
    private String msg;
    private String TRACEID;

	public String getTRACEID() {
		return TRACEID;
	}

	public void setTRACEID(String TRACEID) {
		this.TRACEID = TRACEID;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPayChannelId() {
    
        return payChannelId;
    }

    public void setPayChannelId(String payChannelId) {
    
        this.payChannelId = payChannelId;
    }

    public boolean isSuccess() {
    
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
    
        this.isSuccess = isSuccess;
    }

    public String getPayAmount() {
    
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
    
        this.payAmount = payAmount;
    }

    public Date getPaytime() {
    
        return paytime;
    }

    public void setPaytime(Date paytime) {
    
        this.paytime = paytime;
    }

    public String getPayTradeNo() {
    
        return payTradeNo;
    }

    public void setPayTradeNo(String payTradeNo) {
    
        this.payTradeNo = payTradeNo;
    }

    public String getPayUserId() {
    
        return payUserId;
    }

    public void setPayUserId(String payUserId) {
    
        this.payUserId = payUserId;
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

    public String getTradeState() {
    
        return tradeState;
    }

    public void setTradeState(String tradeState) {
    
        this.tradeState = tradeState;
    }

    @Override
    public String toString() {
        return "TradePayResponse [payChannelId=" + payChannelId + ", isSuccess=" + isSuccess + ", payAmount="
                + payAmount + ", paytime=" + paytime + ", payTradeNo=" + payTradeNo + ", payUserId=" + payUserId
                + ", clearTime=" + clearTime + ", tradeState=" + tradeState + ", remark=" + remark + "]";
    }

}
