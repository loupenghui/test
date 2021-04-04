package com.hzsun.demo.EasyExcel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: louph
 * @Date: 2019/11/22 0022
 */
public class OrderExcelBO extends BaseRowModel {

	@ExcelProperty(value = {"订单号","订单ID"}, index = 0)
	private String id;

	/**
	 * 订单描述
	 */
	@ExcelProperty(value = {"订单号","订单描述"}, index = 2)
	private String description;

	/**
	 * 订单对应产品id
	 */
	@ExcelProperty(value = {"","产品ID"}, index = 2)
	private Integer productId;

	/**
	 * 支付方式描述，如：apple pay
	 */
	@ExcelProperty(value = {"支付方式1","支付方式"}, index = 3)
	private String payMethod;

	/**
	 * create_time
	 */
	@ExcelProperty(value = {"时间","时间"}, index = 4)
	private String createTime;

	/**
	 * update_time
	 */
	private String updateTime;

	/**
	 * 产生订单的用户
	 */
	@ExcelProperty(value = {"","用户ID"}, index = 5)
	private Integer userId;

	/**
	 * 支付状态：0 未支付、1支付成功支付完成、-1支付失败
	 */
	@ExcelProperty(value = {"","支付状态"}, index = 6)
	private String status;

	/**
	 * 订单来源描述，如：ios 安卓
	 */
	@ExcelProperty(value = {"","手机型号"}, index = 7)
	private String platform;

	/**
	 * 订单流水
	 */
	@ExcelProperty(value = {"","订单流水号"}, index = 8)
	private String flowNum;

	/**
	 * 订单金额
	 */
	@ExcelProperty(value = {"","金额"}, index = 9)
	private BigDecimal price;

	// @ExcelProperty(value = {"","收据字段"}, index = 10)
	private String receipt;

	@ExcelProperty(value = {"","APP来源"}, index = 10)
	private String sources;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getFlowNum() {
		return flowNum;
	}

	public void setFlowNum(String flowNum) {
		this.flowNum = flowNum;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getSources() {
		return sources;
	}

	public void setSources(String sources) {
		this.sources = sources;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
