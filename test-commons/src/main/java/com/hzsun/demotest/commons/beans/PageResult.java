package com.hzsun.demotest.commons.beans;

import java.io.Serializable;
import java.util.List;

public class PageResult<E> implements Serializable {

	private static final long serialVersionUID = 1622719678552104206L;

	private long totalCount;

	private List<E> records;

	public PageResult(List<E> records, long totalCount) {
		super();
		this.totalCount = totalCount;
		this.records = records;
	}

	public PageResult() {
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public List<E> getRecords() {
		return records;
	}

	public void setRecords(List<E> records) {
		this.records = records;
	}
}
