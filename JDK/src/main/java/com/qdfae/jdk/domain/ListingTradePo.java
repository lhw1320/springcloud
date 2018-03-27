package com.qdfae.jdk.domain;

import org.springframework.format.annotation.DateTimeFormat;

public class ListingTradePo {
	/**
	 * 唯一id，自增主键
	 */
	private Integer id;
	/**
	 * 挂牌产品Id
	 */
	private Integer projectId;
	/**
	 * 起投金额
	 */
	private java.math.BigDecimal investAmountMin;
	/**
	 * 申购金额上限
	 */
	private java.math.BigDecimal investAmountMax;
	/**
	 * 申购追加金额，总投资金额应该是起投+N*追加
	 */
	private java.math.BigDecimal investAmountAppend;
	/**
	 * 拟定年化收益率,没有乘以%
	 */
	private java.math.BigDecimal investProfit;
	/**
	 * 发布时间,到该时间后产品变为可交易状态
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	private java.util.Date publishTime;
	/**
	 * 申购开始时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	private java.util.Date buyTimeStart;
	/**
	 * 申购结束时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	private java.util.Date buyTimeEnd;
	/**
	 * 保证金数值
	 */
	private java.math.BigDecimal guaranteeMoney;
	/**
	 * 保证金设值类型 金额=1 百分比=2
	 */
	private Integer guaranteeValueType;
	/**
	 * 转让成交后N个工作日支付尾款
	 */
	private Integer paySettleDay;
	/**
	 * 转让方式,拆分转让 =1 整体转让=2
	 */
	private Integer transferType;
	/**
	 * 交易方式：1-场内交易；2-场外交易
	 */
	private Integer tradeType;
	/**
	 * 是否允许转让，是-1，否-0
	 */
	private Integer canTransfer;
	/**
	 * 产品成立后几天可以转让
	 */
	private Integer transferAfter;
	/**
	 * 转让期限,二级转让中可交易天数
	 */
	private Integer transferLimit;
	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	private java.util.Date createTime;
	/**
	 * 创建人,member_operator.id
	 */
	private Integer createOperatorId;
	/**
	 * 更新时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	private java.util.Date updateTime;
	/**
	 * 更新人,member_operator.id
	 */
	private Integer upateOperatorId;
	/**
	 * 数据版本号,保障并发修改的唯一性
	 */
	private Integer versionNo;
	
	private Integer biddingMethod;
	
	private Boolean flag;
	
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	public void setId(Integer value) {
		this.id = value;
	}
	public Integer getId() {
		return this.id;
	}
	public void setProjectId(Integer value) {
		this.projectId = value;
	}
	public Integer getProjectId() {
		return this.projectId;
	}
	public void setInvestAmountMin(java.math.BigDecimal value) {
		this.investAmountMin = value;
	}
	public java.math.BigDecimal getInvestAmountMin() {
		return this.investAmountMin;
	}
	public void setInvestAmountMax(java.math.BigDecimal value) {
		this.investAmountMax = value;
	}
	public java.math.BigDecimal getInvestAmountMax() {
		return this.investAmountMax;
	}
	public void setInvestAmountAppend(java.math.BigDecimal value) {
		this.investAmountAppend = value;
	}
	public java.math.BigDecimal getInvestAmountAppend() {
		return this.investAmountAppend;
	}
	public void setInvestProfit(java.math.BigDecimal value) {
		this.investProfit = value;
	}
	public java.math.BigDecimal getInvestProfit() {
		return this.investProfit;
	}
	public void setPublishTime(java.util.Date value) {
		this.publishTime = value;
	}
	public java.util.Date getPublishTime() {
		return this.publishTime;
	}
	public void setBuyTimeStart(java.util.Date value) {
		this.buyTimeStart = value;
	}
	public java.util.Date getBuyTimeStart() {
		return this.buyTimeStart;
	}
	public void setBuyTimeEnd(java.util.Date value) {
		this.buyTimeEnd = value;
	}
	public java.util.Date getBuyTimeEnd() {
		return this.buyTimeEnd;
	}
	public void setGuaranteeMoney(java.math.BigDecimal value) {
		this.guaranteeMoney = value;
	}
	public java.math.BigDecimal getGuaranteeMoney() {
		return this.guaranteeMoney;
	}
	public void setGuaranteeValueType(Integer value) {
		this.guaranteeValueType = value;
	}
	public Integer getGuaranteeValueType() {
		return this.guaranteeValueType;
	}
	public void setPaySettleDay(Integer value) {
		this.paySettleDay = value;
	}
	public Integer getPaySettleDay() {
		return this.paySettleDay;
	}
	public void setTransferType(Integer value) {
		this.transferType = value;
	}
	public Integer getTransferType() {
		return this.transferType;
	}
	public void setTradeType(Integer value) {
		this.tradeType = value;
	}
	public Integer getTradeType() {
		return this.tradeType;
	}
	public void setCanTransfer(Integer value) {
		this.canTransfer = value;
	}
	public Integer getCanTransfer() {
		return this.canTransfer;
	}
	public void setTransferAfter(Integer value) {
		this.transferAfter = value;
	}
	public Integer getTransferAfter() {
		return this.transferAfter;
	}
	public void setTransferLimit(Integer value) {
		this.transferLimit = value;
	}
	public Integer getTransferLimit() {
		return this.transferLimit;
	}
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	public void setCreateOperatorId(Integer value) {
		this.createOperatorId = value;
	}
	public Integer getCreateOperatorId() {
		return this.createOperatorId;
	}
	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
	public void setUpateOperatorId(Integer value) {
		this.upateOperatorId = value;
	}
	public Integer getUpateOperatorId() {
		return this.upateOperatorId;
	}
	public void setVersionNo(Integer value) {
		this.versionNo = value;
	}
	public Integer getVersionNo() {
		return this.versionNo;
	}
	/**
	 * @return the biddingMethod
	 */
	public Integer getBiddingMethod() {
		return biddingMethod;
	}
	/**
	 * @param biddingMethod the biddingMethod to set
	 */
	public void setBiddingMethod(Integer biddingMethod) {
		this.biddingMethod = biddingMethod;
	}

}
