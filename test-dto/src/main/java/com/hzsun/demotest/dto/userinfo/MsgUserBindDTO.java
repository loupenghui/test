package com.hzsun.demotest.dto.userinfo;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @Description:
 * @Author: louph
 * @Date: 2019/5/13 0013
 */
public class MsgUserBindDTO implements Serializable {

	//	是否有效
	private String flag;
	//  用户昵称
	private String username;
	//	个人编号
	@JSONField(name="personcode")
	private String externalcardno;
	// 渠道用户标识
	@JSONField(name="outbindid")
	private String paychanneluserid;
	@JSONField(name="bindtime")
	private String binddateStr;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getExternalcardno() {
		return externalcardno;
	}

	public void setExternalcardno(String externalcardno) {
		this.externalcardno = externalcardno;
	}

	public String getPaychanneluserid() {
		return paychanneluserid;
	}

	public void setPaychanneluserid(String paychanneluserid) {
		this.paychanneluserid = paychanneluserid;
	}

	public String getBinddateStr() {
		return binddateStr;
	}

	public void setBinddateStr(String binddateStr) {
		this.binddateStr = binddateStr;
	}
}
    