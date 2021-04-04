package com.hzsun.demotest.dto.system;

import java.io.Serializable;

public class ScDictDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer typenum;

	private Integer dictnum;
	
    private String dictcode;

	private String dictname;

	private Integer parentdictnum;

	private String remark;

	public String getDictcode() {
		return dictcode;
	}

	public void setDictcode(String dictcode) {
		this.dictcode = dictcode == null ? null : dictcode.trim();
	}

	public String getDictname() {
		return dictname;
	}

	public void setDictname(String dictname) {
		this.dictname = dictname == null ? null : dictname.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Integer getTypenum() {
		return typenum;
	}

	public void setTypenum(Integer typenum) {
		this.typenum = typenum;
	}

	public Integer getDictnum() {
		return dictnum;
	}

	public void setDictnum(Integer dictnum) {
		this.dictnum = dictnum;
	}

	public Integer getParentdictnum() {
		return parentdictnum;
	}

	public void setParentdictnum(Integer parentdictnum) {
		this.parentdictnum = parentdictnum;
	}
	
	
}