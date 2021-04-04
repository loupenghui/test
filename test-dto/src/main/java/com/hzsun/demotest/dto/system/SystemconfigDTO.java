package com.hzsun.demotest.dto.system;

import java.io.Serializable;

public class SystemconfigDTO  implements Serializable {
       
    private static final long serialVersionUID = 1L;

    private String cfgcode;

    private String cfgvalue;

    private String remark;

    public String getCfgcode() {
        return cfgcode;
    }

    public void setCfgcode(String cfgcode) {
        this.cfgcode = cfgcode == null ? null : cfgcode.trim();
    }

    public String getCfgvalue() {
        return cfgvalue;
    }

    public void setCfgvalue(String cfgvalue) {
        this.cfgvalue = cfgvalue == null ? null : cfgvalue.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}