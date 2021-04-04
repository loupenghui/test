package com.hzsun.demotest.dto.order;

import java.io.Serializable;
import java.util.Date;

public class OrderinfoDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String ordernum;

    private String merchantid;

    private String appid;

    private String paychannelid;

    private String outtradeno;

    private String userid;

    private String outpayid;

    private Integer orderstatus;

    private Integer ordertype;

    private String refundordernum;

    private String authcode;

    private Date createtime;

    private Double originalamount;

    private Double payamount;

    private Date paytime;

    private String paytradeno;

    private String payuserid;

    private Date cleartime;

    private Integer checkstatus;

    private Integer handlerflag;

    private String ordertitle;

    private String orderdescription;
    
    /** 2018 08 09 增加 returnurl 和 notifyurl */
    private String returnurl;

    private String notifyurl;

    private String operatornum;

    private String consumeplace;

    private String devicenum;

    private Long tac;

    private String checkcode;

    private Date finishtime;

    private Date checktime;

    private Integer checkcount;
    
    private String merchantname;
	private String appname;
	private String paychannelname;
	private String username;
	private double paytotalamount; // 支付总金额
	private Integer paytotal; // 支付总笔数
	private Integer refundcount;// 退款记录数  包含退款中+退款成功
	private double refundamount;// 退款金额
	
	public String getReturnurl() {
		return returnurl;
	}

	public void setReturnurl(String returnurl) {
		this.returnurl = returnurl;
	}

	public String getNotifyurl() {
		return notifyurl;
	}

	public void setNotifyurl(String notifyurl) {
		this.notifyurl = notifyurl;
	}

	public Integer getRefundcount() {
		return refundcount;
	}

	public void setRefundcount(Integer refundcount) {
		this.refundcount = refundcount;
	}

	public double getRefundamount() {
		return refundamount;
	}

	public void setRefundamount(double refundamount) {
		this.refundamount = refundamount;
	}

	public double getPaytotalamount() {
		return paytotalamount;
	}

	public void setPaytotalamount(double paytotalamount) {
		this.paytotalamount = paytotalamount;
	}

	public Integer getPaytotal() {
		return paytotal;
	}

	public void setPaytotal(Integer paytotal) {
		this.paytotal = paytotal;
	}

	public String getMerchantname() {
		return merchantname;
	}

	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getPaychannelname() {
		return paychannelname;
	}

	public void setPaychannelname(String paychannelname) {
		this.paychannelname = paychannelname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid == null ? null : merchantid.trim();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getPaychannelid() {
        return paychannelid;
    }

    public void setPaychannelid(String paychannelid) {
        this.paychannelid = paychannelid;
    }

    public String getOuttradeno() {
        return outtradeno;
    }

    public void setOuttradeno(String outtradeno) {
        this.outtradeno = outtradeno == null ? null : outtradeno.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getOutpayid() {
        return outpayid;
    }

    public void setOutpayid(String outpayid) {
        this.outpayid = outpayid == null ? null : outpayid.trim();
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
        this.refundordernum = refundordernum == null ? null : refundordernum.trim();
    }

    public String getAuthcode() {
        return authcode;
    }

    public void setAuthcode(String authcode) {
        this.authcode = authcode == null ? null : authcode.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Double getOriginalamount() {
        return originalamount;
    }

    public void setOriginalamount(Double originalamount) {
        this.originalamount = originalamount;
    }

    public Double getPayamount() {
        return payamount;
    }

    public void setPayamount(Double payamount) {
        this.payamount = payamount;
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
        this.paytradeno = paytradeno == null ? null : paytradeno.trim();
    }

    public String getPayuserid() {
        return payuserid;
    }

    public void setPayuserid(String payuserid) {
        this.payuserid = payuserid == null ? null : payuserid.trim();
    }

    public Date getCleartime() {
        return cleartime;
    }

    public void setCleartime(Date cleartime) {
        this.cleartime = cleartime;
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

    public String getOrdertitle() {
        return ordertitle;
    }

    public void setOrdertitle(String ordertitle) {
        this.ordertitle = ordertitle == null ? null : ordertitle.trim();
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription == null ? null : orderdescription.trim();
    }

    public String getOperatornum() {
        return operatornum;
    }

    public void setOperatornum(String operatornum) {
        this.operatornum = operatornum == null ? null : operatornum.trim();
    }

    public String getConsumeplace() {
        return consumeplace;
    }

    public void setConsumeplace(String consumeplace) {
        this.consumeplace = consumeplace == null ? null : consumeplace.trim();
    }

    public String getDevicenum() {
        return devicenum;
    }

    public void setDevicenum(String devicenum) {
        this.devicenum = devicenum == null ? null : devicenum.trim();
    }

    public Long getTac() {
        return tac;
    }

    public void setTac(Long tac) {
        this.tac = tac;
    }

    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode == null ? null : checkcode.trim();
    }

    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    public Integer getCheckcount() {
        return checkcount;
    }

    public void setCheckcount(Integer checkcount) {
        this.checkcount = checkcount;
    }
}
  
    