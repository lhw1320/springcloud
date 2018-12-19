package com.qdfae.jdk.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 项目交易起投金额个对应年化收益率
 *
 * @author hongwei.lian
 * @date 2018年4月13日 上午10:35:48
 */
public class ListingTradeInvestVo implements Serializable {

	private static final long serialVersionUID = 1273211355896054195L;
	
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
	 * 对应起投金额的上限
	 */
	private java.math.BigDecimal investAmountMax;
	/**
	 * 对应年化收益率,没有乘以%
	 */
	private java.math.BigDecimal investProfit;
	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	private java.util.Date createTime;
	/**
	 * 创建操作人Id
	 */
	private Integer createOperatorId;
	/**
	 * 更新时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	private java.util.Date updateTime;
	/**
	 * 更新操作人Id
	 */
	private Integer updateOperatorId;
	
	public ListingTradeInvestVo() {}
	
	public ListingTradeInvestVo(Integer id, Integer projectId, BigDecimal investAmountMin, BigDecimal investAmountMax) {
		this.id = id;
		this.projectId = projectId;
		this.investAmountMin = investAmountMin;
		this.investAmountMax = investAmountMax;
	}
	
	public ListingTradeInvestVo(Integer id, Integer projectId, BigDecimal investAmountMin, BigDecimal investAmountMax, BigDecimal investProfit) {
		this.id = id;
		this.projectId = projectId;
		this.investAmountMin = investAmountMin;
		this.investAmountMax = investAmountMax;
		this.investProfit = investProfit;
	}
	
	public ListingTradeInvestVo(BigDecimal investAmountMin, BigDecimal investAmountMax) {
		super();
		this.investAmountMin = investAmountMin;
		this.investAmountMax = investAmountMax;
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
	public java.math.BigDecimal getInvestAmountMax() {
		return investAmountMax;
	}
	public void setInvestAmountMax(java.math.BigDecimal investAmountMax) {
		this.investAmountMax = investAmountMax;
	}
	public void setInvestProfit(java.math.BigDecimal value) {
		this.investProfit = value;
	}
	public java.math.BigDecimal getInvestProfit() {
		return this.investProfit;
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
	public void setUpdateOperatorId(Integer value) {
		this.updateOperatorId = value;
	}
	public Integer getUpdateOperatorId() {
		return this.updateOperatorId;
	}
	@Override
	public String toString() {
		return "ListingTradeInvestVo [id=" + id + ", projectId=" + projectId + ", investAmountMin=" + investAmountMin
				+ ", investProfit=" + investProfit + ", createTime=" + createTime + ", createOperatorId="
				+ createOperatorId + ", updateTime=" + updateTime + ", updateOperatorId=" + updateOperatorId + "]";
	}
}

