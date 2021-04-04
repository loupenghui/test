package com.hzsun.demotest.dto.report;

/**
 * @Description:
 * @Author: louph
 * @Date: 2018/10/22 0022
 */
public class OrderByDayDTO extends BaseReportDTO {

	private static final long serialVersionUID = 7205058612368513210L;
	private String recnum;
	private Double transactionamount;
	private Double refundamount;
	private Integer transcount;
	private Integer refundcount;
	private String aggregatedatestr;

	public String getRecnum() {
		return recnum;
	}

	public void setRecnum(String recnum) {
		this.recnum = recnum;
	}

	public Double getTransactionamount() {
		return transactionamount;
	}

	public void setTransactionamount(Double transactionamount) {
		this.transactionamount = transactionamount;
	}

	public Double getRefundamount() {
		return refundamount;
	}

	public void setRefundamount(Double refundamount) {
		this.refundamount = refundamount;
	}

	public Integer getTranscount() {
		return transcount;
	}

	public void setTranscount(Integer transcount) {
		this.transcount = transcount;
	}

	public Integer getRefundcount() {
		return refundcount;
	}

	public void setRefundcount(Integer refundcount) {
		this.refundcount = refundcount;
	}

	public String getAggregatedatestr() {
		return aggregatedatestr;
	}

	public void setAggregatedatestr(String aggregatedatestr) {
		this.aggregatedatestr = aggregatedatestr;
	}
}
