package com.hzsun.demotest.dto.extend;

import java.io.Serializable;
import java.util.Date;

/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年7月3日  
**/
public class PaywayApapterExpands implements Serializable{

    private static final long serialVersionUID = 1L;
    //订单创建时间
    private Date createDate;
    //扩展信息
    private String params;
    //设备编号
    private String  devicenum;
    //用户账号
    private String  accnum;
    //支付码
    private String authcode;
    //订单状态 1 待付款  2 支付成功  3 支付失败 4 退款中 5 退款成功
    private Integer orderstatus;
    //原订单订单号(退款时候用)
    private String originordernum;
    private String otherValue;//其他值
    private String totalamount;
	private String notifyUrl;//回调ip
	private String appid;//应用id
	private Date originorderdate;//原订单创建时间

	public Date getOriginorderdate() {
		return originorderdate;
	}

	public void setOriginorderdate(Date originorderdate) {
		this.originorderdate = originorderdate;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getOtherValue() {
		return otherValue;
	}

	public void setOtherValue(String otherValue) {
		this.otherValue = otherValue;
	}

	public Date getCreateDate() {
    
        return createDate;
    }

    public void setCreateDate(Date createDate) {
    
        this.createDate = createDate;
    }

    public String getParams() {
    
        return params;
    }

    public void setParams(String params) {
    
        this.params = params;
    }

    public String getDevicenum() {
    
        return devicenum;
    }

    public void setDevicenum(String devicenum) {
    
        this.devicenum = devicenum;
    }

    public String getAccnum() {
    
        return accnum;
    }

    public void setAccnum(String accnum) {
    
        this.accnum = accnum;
    }

    public String getAuthcode() {
    
        return authcode;
    }

    public void setAuthcode(String authcode) {
    
        this.authcode = authcode;
    }

    public Integer getOrderstatus() {
    
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
    
        this.orderstatus = orderstatus;
    }

    public String getOriginordernum() {
    
        return originordernum;
    }

    public void setOriginordernum(String originordernum) {
    
        this.originordernum = originordernum;
    }

    public String getTotalamount() {
    
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
    
        this.totalamount = totalamount;
    }
    
    
    

}
  
    