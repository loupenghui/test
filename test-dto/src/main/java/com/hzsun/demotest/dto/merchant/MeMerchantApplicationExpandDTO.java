package com.hzsun.demotest.dto.merchant;

import java.io.Serializable;

public class MeMerchantApplicationExpandDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String appid;

    private String authid;

    private String authcontent;

    private byte[] cert;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getAuthid() {
        return authid;
    }

    public void setAuthid(String authid) {
        this.authid = authid == null ? null : authid.trim();
    }

    public String getAuthcontent() {
        return authcontent;
    }

    public void setAuthcontent(String authcontent) {
        this.authcontent = authcontent == null ? null : authcontent.trim();
    }

    public byte[] getCert() {
        return cert;
    }

    public void setCert(byte[] cert) {
        this.cert = cert;
    }
}