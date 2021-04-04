package com.hzsun.demotest.qo;

import java.io.Serializable;

public class UserbindQuery  implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userbindid;

    private String appid;

    private String appuserid;

    private String paychanneluserid;

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

    public String getPaychannelid() {

        return paychannelid;
    }

    public void setPaychannelid(String paychannelid) {

        this.paychannelid = paychannelid;
    }

}