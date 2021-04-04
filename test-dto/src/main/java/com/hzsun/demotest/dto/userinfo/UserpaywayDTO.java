package com.hzsun.demotest.dto.userinfo;

import java.io.Serializable;

public class UserpaywayDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String userbindid;

    private Integer paytype;

    private Integer sort;

    public String getUserbindid() {
        return userbindid;
    }

    public void setUserbindid(String userbindid) {
        this.userbindid = userbindid == null ? null : userbindid.trim();
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}