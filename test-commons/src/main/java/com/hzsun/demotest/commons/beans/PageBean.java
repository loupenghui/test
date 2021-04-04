package com.hzsun.demotest.commons.beans;

import java.io.Serializable;

public class PageBean implements Serializable {

	private static final long serialVersionUID = -8756438460705012597L;

	private int page;

	private int limit;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
