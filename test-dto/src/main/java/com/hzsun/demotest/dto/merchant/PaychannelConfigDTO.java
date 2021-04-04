package com.hzsun.demotest.dto.merchant;

import java.io.Serializable;

public class PaychannelConfigDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private String paychannelid;

    private String paychannelname;

    private Short paychanneltype;

    private Integer provincenum;

    private Integer citynum;

    private String componentname;

    private String logo;

    public String getPaychannelid() {
        return paychannelid;
    }

    public void setPaychannelid(String paychannelid) {
        this.paychannelid = paychannelid == null ? null : paychannelid.trim();
    }

    public String getPaychannelname() {
        return paychannelname;
    }

    public void setPaychannelname(String paychannelname) {
        this.paychannelname = paychannelname == null ? null : paychannelname.trim();
    }

    public Short getPaychanneltype() {
        return paychanneltype;
    }

    public void setPaychanneltype(Short paychanneltype) {
        this.paychanneltype = paychanneltype;
    }

    public Integer getProvincenum() {
        return provincenum;
    }

    public void setProvincenum(Integer provincenum) {
        this.provincenum = provincenum;
    }

    public Integer getCitynum() {
        return citynum;
    }

    public void setCitynum(Integer citynum) {
        this.citynum = citynum;
    }

    public String getComponentname() {
        return componentname;
    }

    public void setComponentname(String componentname) {
        this.componentname = componentname == null ? null : componentname.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }
}