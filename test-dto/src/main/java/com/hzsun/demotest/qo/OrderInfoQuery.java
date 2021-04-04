package com.hzsun.demotest.qo;

import java.io.Serializable;
import java.util.Date;

/**  
* @Description:  
 * @Author: dingjl  
* @Date: 2018年4月20日  
**/
public class OrderInfoQuery implements Serializable { 
    private static final long serialVersionUID = 1L;
    
    private String ordernum;

    private String merchantid;
    
    private String merchantname;

    private String appid;

    private Integer paychannelid;

    private String outtradeno;

    private String userid;

    private Integer orderstatus;

    private Integer ordertype;

    private String refundordernum;

    private String authcode;

    private Date paytime;

    private String paytradeno;

    private Integer checkstatus;

    private Integer handlerflag;

    private Double payamountmin;
    private Double payamountmax;
    private String paytimemin;
    private String paytimemax;
    private String createtimemin;
    private String createtimemax;
    private String ordernummin;
    private String ordernummax;

    private long startcount; //分页检索 手动设置
    private long endcount; //分页检索 手动设置

    public String getOrdernummin() {
        return ordernummin;
    }

    public void setOrdernummin(String ordernummin) {
        this.ordernummin = ordernummin;
    }

    public String getOrdernummax() {
        return ordernummax;
    }

    public void setOrdernummax(String ordernummax) {
        this.ordernummax = ordernummax;
    }

    public long getEndcount() {
        return endcount;
    }

    public void setEndcount(long endcount) {
        this.endcount = endcount;
    }

    public long getStartcount() {
        return startcount;
    }

    public void setStartcount(long startcount) {
        this.startcount = startcount;
    }

    public String getCreatetimemin() {
		return createtimemin;
	}

	public void setCreatetimemin(String createtimemin) {
		this.createtimemin = createtimemin;
	}

	public String getCreatetimemax() {
		return createtimemax;
	}

	public void setCreatetimemax(String createtimemax) {
		this.createtimemax = createtimemax;
	}

	public Double getPayamountmin() {
		return payamountmin;
	}

	public void setPayamountmin(Double payamountmin) {
		this.payamountmin = payamountmin;
	}

	public Double getPayamountmax() {
		return payamountmax;
	}

	public void setPayamountmax(Double payamountmax) {
		this.payamountmax = payamountmax;
	}


	public String getPaytimemin() {
		return paytimemin;
	}

	public void setPaytimemin(String paytimemin) {
		this.paytimemin = paytimemin;
	}

	public String getPaytimemax() {
		return paytimemax;
	}

	public void setPaytimemax(String paytimemax) {
		this.paytimemax = paytimemax;
	}

	public String getMerchantname() {
		return merchantname;
	}

	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}

	public String getOrdernum() {
    
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
    
        this.ordernum = ordernum;
    }

    public String getMerchantid() {
    
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
    
        this.merchantid = merchantid;
    }

    public String getAppid() {
    
        return appid;
    }

    public void setAppid(String appid) {
    
        this.appid = appid;
    }

    public Integer getPaychannelid() {
    
        return paychannelid;
    }

    public void setPaychannelid(Integer paychannelid) {
    
        this.paychannelid = paychannelid;
    }

    public String getOuttradeno() {
    
        return outtradeno;
    }

    public void setOuttradeno(String outtradeno) {
    
        this.outtradeno = outtradeno;
    }

    public String getUserid() {
    
        return userid;
    }

    public void setUserid(String userid) {
    
        this.userid = userid;
    }

    public Integer getOrderstatus() {
    
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
    
        this.orderstatus = orderstatus;
    }

    public Integer getOrdertype() {
    
        return ordertype;
    }

    public void setOrdertype(Integer ordertype) {
    
        this.ordertype = ordertype;
    }

    public String getRefundordernum() {
    
        return refundordernum;
    }

    public void setRefundordernum(String refundordernum) {
    
        this.refundordernum = refundordernum;
    }

    public String getAuthcode() {
    
        return authcode;
    }

    public void setAuthcode(String authcode) {
    
        this.authcode = authcode;
    }

    public Date getPaytime() {
    
        return paytime;
    }

    public void setPaytime(Date paytime) {
    
        this.paytime = paytime;
    }

    public String getPaytradeno() {
    
        return paytradeno;
    }

    public void setPaytradeno(String paytradeno) {
    
        this.paytradeno = paytradeno;
    }

    public Integer getCheckstatus() {
    
        return checkstatus;
    }

    public void setCheckstatus(Integer checkstatus) {
    
        this.checkstatus = checkstatus;
    }

    public Integer getHandlerflag() {
    
        return handlerflag;
    }

    public void setHandlerflag(Integer handlerflag) {
    
        this.handlerflag = handlerflag;
    }

    

}
  
    