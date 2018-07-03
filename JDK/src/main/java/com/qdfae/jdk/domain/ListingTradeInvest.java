package com.qdfae.jdk.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * ListingTradeInvest
 *
 * @author hongwei.lian
 * @date 2018年4月16日 下午3:45:31
 */
public class ListingTradeInvest implements Serializable,Comparable<ListingTradeInvest> {
	
	private static final long serialVersionUID = 1214695499385402108L;
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
    
	public ListingTradeInvest() {}
	public ListingTradeInvest(Integer id, BigDecimal investAmountMin, BigDecimal investProfit) {
		this.id = id;
		this.investAmountMin = investAmountMin;
		this.investProfit = investProfit;
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
		return "ListingTradeInvest [id=" + id + ", projectId=" + projectId + ", investAmountMin=" + investAmountMin
				+ ", investProfit=" + investProfit + ", createTime=" + createTime + ", createOperatorId="
				+ createOperatorId + ", updateTime=" + updateTime + ", updateOperatorId=" + updateOperatorId + "]";
	}
	
	@Override
	public int compareTo(ListingTradeInvest o) {
		return 0;
	}
	
}
