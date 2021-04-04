package com.hzsun.demotest.dto.logger;

import java.io.Serializable;
import java.util.Date;

public class ExceptionlogDTO implements Serializable {
   
    private static final long serialVersionUID = 1L;

    private String recnum;

    private Integer exceptiontype;

    private Integer exceptionsource;

    private String exceptionmethod;

    private String exceptionurl;

    private String exceptiondetail;

    private Date happentime;

    private String happentimestr;

	private Integer timeout;

	public String getHappentimestr() {
		return happentimestr;
	}

	public void setHappentimestr(String happentimestr) {
		this.happentimestr = happentimestr;
	}

    public String getRecnum() {
        return recnum;
    }

    public void setRecnum(String recnum) {
        this.recnum = recnum == null ? null : recnum.trim();
    }

    public Integer getExceptiontype() {
        return exceptiontype;
    }

    public void setExceptiontype(Integer exceptiontype) {
        this.exceptiontype = exceptiontype;
    }

    public Integer getExceptionsource() {
        return exceptionsource;
    }

    public void setExceptionsource(Integer exceptionsource) {
        this.exceptionsource = exceptionsource;
    }

    public String getExceptionmethod() {
        return exceptionmethod;
    }

    public void setExceptionmethod(String exceptionmethod) {
        this.exceptionmethod = exceptionmethod == null ? null : exceptionmethod.trim();
    }

    public String getExceptionurl() {
        return exceptionurl;
    }

    public void setExceptionurl(String exceptionurl) {
        this.exceptionurl = exceptionurl == null ? null : exceptionurl.trim();
    }

    public String getExceptiondetail() {
        return exceptiondetail;
    }

    public void setExceptiondetail(String exceptiondetail) {
        this.exceptiondetail = exceptiondetail == null ? null : exceptiondetail.trim();
    }

    public Date getHappentime() {
        return happentime;
    }

    public void setHappentime(Date happentime) {
        this.happentime = happentime;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}