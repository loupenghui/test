package com.hzsun.demotest.dto.userinfo;

import java.io.Serializable;
import java.util.Date;

public class UserbindDTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userbindid;

    private String appid;

    private String appuserid;

    private String paychanneluserid;

    private Integer bindtype;

    private String bindno;

    private String externalcardno;

    private String bizcardno;

    private Short flag;

    private Date binddate;

    private String paychannelid;

    public String getUserbindid() {
        return userbindid;
    }

    public void setUserbindid(String userbindid) {
        this.userbindid = userbindid == null ? null : userbindid.trim();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getAppuserid() {
        return appuserid;
    }

    public void setAppuserid(String appuserid) {
        this.appuserid = appuserid == null ? null : appuserid.trim();
    }

    public String getPaychanneluserid() {
        return paychanneluserid;
    }

    public void setPaychanneluserid(String paychanneluserid) {
        this.paychanneluserid = paychanneluserid == null ? null : paychanneluserid.trim();
    }

    public String getExternalcardno() {
        return externalcardno;
    }

    public void setExternalcardno(String externalcardno) {
        this.externalcardno = externalcardno == null ? null : externalcardno.trim();
    }

    public String getBizcardno() {
        return bizcardno;
    }

    public void setBizcardno(String bizcardno) {
        this.bizcardno = bizcardno == null ? null : bizcardno.trim();
    }

    public Short getFlag() {
        return flag;
    }

    public void setFlag(Short flag) {
        this.flag = flag;
    }

    public Date getBinddate() {
        return binddate;
    }

    public void setBinddate(Date binddate) {
        this.binddate = binddate;
    }

    public Integer getBindtype() {
    
        return bindtype;
    }

    public void setBindtype(Integer bindtype) {
    
        this.bindtype = bindtype;
    }

    public String getBindno() {
    
        return bindno;
    }

    public void setBindno(String bindno) {
    
        this.bindno = bindno;
    }

    public String getPaychannelid() {

        return paychannelid;
    }

    public void setPaychannelid(String paychannelid) {

        this.paychannelid = paychannelid;
    }



    
}