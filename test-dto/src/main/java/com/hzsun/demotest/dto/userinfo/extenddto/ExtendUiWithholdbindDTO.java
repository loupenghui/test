package com.hzsun.demotest.dto.userinfo.extenddto;

import com.hzsun.demotest.dto.userinfo.UiWithholdbindDTO;

public class ExtendUiWithholdbindDTO extends UiWithholdbindDTO {

    private String username;

    private String appname;

    private String signtimeStr;

    private String invalidtimeStr;

    private String idno;

    private Short idtype;

    private String contant;

    private String email;

    private Short authchannel;

    private Short gender;

    private String country;

    private String province;

    private String city;

    private String paychannelname;

    public String getPaychannelname() {
        return paychannelname;
    }

    public void setPaychannelname(String paychannelname) {
        this.paychannelname = paychannelname;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public Short getIdtype() {
        return idtype;
    }

    public void setIdtype(Short idtype) {
        this.idtype = idtype;
    }

    public String getContant() {
        return contant;
    }

    public void setContant(String contant) {
        this.contant = contant;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getAuthchannel() {
        return authchannel;
    }

    public void setAuthchannel(Short authchannel) {
        this.authchannel = authchannel;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSigntimeStr() {
        return signtimeStr;
    }

    public void setSigntimeStr(String signtimeStr) {
        this.signtimeStr = signtimeStr;
    }

    public String getInvalidtimeStr() {
        return invalidtimeStr;
    }

    public void setInvalidtimeStr(String invalidtimeStr) {
        this.invalidtimeStr = invalidtimeStr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }
}