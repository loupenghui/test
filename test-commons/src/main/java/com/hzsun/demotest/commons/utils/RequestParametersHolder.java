package com.hzsun.demotest.commons.utils;

public class RequestParametersHolder {
	private HzsunHashMap protocalMustParams;
	private HzsunHashMap protocalOptParams;
	private HzsunHashMap applicationParams;

	public HzsunHashMap getProtocalMustParams() {
		return protocalMustParams;
	}
	public void setProtocalMustParams(HzsunHashMap protocalMustParams) {
		this.protocalMustParams = protocalMustParams;
	}
	public HzsunHashMap getProtocalOptParams() {
		return protocalOptParams;
	}
	public void setProtocalOptParams(HzsunHashMap protocalOptParams) {
		this.protocalOptParams = protocalOptParams;
	}
	public HzsunHashMap getApplicationParams() {
		return applicationParams;
	}
	public void setApplicationParams(HzsunHashMap applicationParams) {
		this.applicationParams = applicationParams;
	}
	
}
