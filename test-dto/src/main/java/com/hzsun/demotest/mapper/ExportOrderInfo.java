package com.hzsun.demotest.mapper;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname ExportOrderInfo
 * @Description TODO 专门用来导出order用的Bean
 * @Date 2018/10/29 20:25
 * @Created by Koliy
 */
public class ExportOrderInfo implements Serializable{

    private static final long serialVersionUID = 1L;
    private String ordernum;
    private String merchantname;
    private String appname;
    private String paychannelname;
    private String outpayid;
    private String orderstatusname;
    private String checkstatusname;
    private String ordertypename;
    private Double originalamount;
    private Double payamount;
    private Date createtime;
    private Date paytime;
    private String outtradeno;
    private String paytradeno;
    private Integer orderstatus;
    private Integer ordertype;
    private Integer checkstatus;

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

    public Integer getCheckstatus() {
        return checkstatus;
    }

    public void setCheckstatus(Integer checkstatus) {
        this.checkstatus = checkstatus;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
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

    public String getOutpayid() {
        return outpayid;
    }

    public void setOutpayid(String outpayid) {
        this.outpayid = outpayid;
    }

    public String getOrderstatusname() {
        return orderstatusname;
    }

    public void setOrderstatusname(String orderstatusname) {
        this.orderstatusname = orderstatusname;
    }

    public String getCheckstatusname() {
        return checkstatusname;
    }

    public void setCheckstatusname(String checkstatusname) {
        this.checkstatusname = checkstatusname;
    }

    public String getOrdertypename() {
        return ordertypename;
    }

    public void setOrdertypename(String ordertypename) {
        this.ordertypename = ordertypename;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public String getOuttradeno() {
        return outtradeno;
    }

    public void setOuttradeno(String outtradeno) {
        this.outtradeno = outtradeno;
    }

    public String getPaytradeno() {
        return paytradeno;
    }

    public void setPaytradeno(String paytradeno) {
        this.paytradeno = paytradeno;
    }
}
