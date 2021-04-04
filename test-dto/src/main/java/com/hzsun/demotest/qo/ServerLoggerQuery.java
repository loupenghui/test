package com.hzsun.demotest.qo;

import java.io.Serializable;
import java.util.Date;

public class ServerLoggerQuery implements Serializable{

	private static final long serialVersionUID = -966584401895484180L;
	private String recnum;

	private Integer exceptiontype;

	private Integer exceptionsource;

	private Date starttime;

	private Date endtime;

	private String starttimestr;

	private String endtimestr;

	public String getStarttimestr() {
		return starttimestr;
	}

	public void setStarttimestr(String starttimestr) {
		this.starttimestr = starttimestr;
	}

	public String getEndtimestr() {
		return endtimestr;
	}

	public void setEndtimestr(String endtimestr) {
		this.endtimestr = endtimestr;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getRecnum() {
		return recnum;
	}

	public void setRecnum(String recnum) {
		this.recnum = recnum;
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
}