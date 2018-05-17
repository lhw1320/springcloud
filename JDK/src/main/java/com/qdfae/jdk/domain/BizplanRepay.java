package com.qdfae.jdk.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 还款计划实体类
 *
 * @author hongwei.lian
 * @date 2018年5月17日 下午12:53:15
 */
public class BizplanRepay implements Serializable {

	private static final long serialVersionUID = 8581742494095931635L;
	
	/**
	 * 唯一id，自增主键
	 */
	private Integer id;
	
	/**
	 * 还款计划唯一id，用于web表现
	 */
	private String repayPlanGuid;
	
	/**
	 * 还款计划结算单号，用于支付结算
	 */
	private String planSettleCode;
	
	/**
	 * 融资人id
	 */
	private Integer loanUserId;
	
	/**
	 * 项目id
	 */
	private Integer projectId;
	
	/**
	 * 交易所id
	 */
	private Integer exchangeId;
	
	/**
	 * 项目所属会员id,uc_user.id,冗余字段
	 */
	private Integer memeberId;
	
	/**
	 * 还款期次
	 */
	private Integer periodNumber;
	
	/**
	 * 正常计息天数
	 */
	private Integer interestDay;
	
	/**
	 * 本期正常计息开始时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	private java.util.Date interestStartDate;
	
	/**
	 * 本期正常计息结束时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	private java.util.Date interestEndDate;
	
	/**
	 * 本期计息本金（元）
	 */
	private java.math.BigDecimal interestPrincipal;
	
	/**
	 * 计划应还日期
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	private java.util.Date planRepayDate;
	
	/**
	 * 本期应还本金（元）
	 */
	private java.math.BigDecimal principal = BigDecimal.ZERO;
	
	/**
	 * 本期应还利息（元）
	 */
	private java.math.BigDecimal interest = BigDecimal.ZERO;
	
	/**
	 * 累计逾期利息
	 */
	private java.math.BigDecimal overInterest = BigDecimal.ZERO;
	
	/**
	 * 累计逾期天数
	 */
	private Integer overDay;
	
	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	private java.util.Date createTime;
	
	/**
	 * 更新人
	 */
	private Integer createOperatorId;
	
	/**
	 * 更新时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	private java.util.Date updateTime;
	
	/**
	 * 更新时间
	 */
	private Integer updateOperatorId;
	
	/**
	 * 版本号
	 */
	private Integer versionNo = 1;
	
	/**
	 * 逾期罚息天数
	 */
	private Integer overPunishDay;
	
	/**
	 * 计息方式  1:按日计息，2:按月计息，3:按年计息
	 */
	private Integer interestType;
	
	/**
	 * 数据产生类型，0:三大web平台；1:开放API
	 */
	private Integer originType = 0;
	
	/**
	 * 数据生成者id，开放API是appId；三大平台是null值
	 */
	private String originatorId;
	
	/**
	 * 每期平台费用
	 */
	private BigDecimal platformFee;

	public BizplanRepay() {}
	
	public BizplanRepay(Integer periodNumber, BigDecimal interestPrincipal, BigDecimal principal, BigDecimal interest) {
		this.periodNumber = periodNumber;
		this.interestPrincipal = interestPrincipal;
		this.principal = principal;
		this.interest = interest;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setRepayPlanGuid(String value) {
		this.repayPlanGuid = value;
	}
	
	public String getRepayPlanGuid() {
		return this.repayPlanGuid;
	}
	
	public void setPlanSettleCode(String value) {
		this.planSettleCode = value;
	}
	
	public String getPlanSettleCode() {
		return this.planSettleCode;
	}
	
	public void setProjectId(Integer value) {
		this.projectId = value;
	}
	
	public Integer getProjectId() {
		return this.projectId;
	}
	
	public void setExchangeId(Integer value) {
		this.exchangeId = value;
	}
	
	public Integer getExchangeId() {
		return this.exchangeId;
	}
	
	public void setMemeberId(Integer value) {
		this.memeberId = value;
	}
	
	public Integer getMemeberId() {
		return this.memeberId;
	}
	
	public void setPeriodNumber(Integer value) {
		this.periodNumber = value;
	}
	
	public Integer getPeriodNumber() {
		return this.periodNumber;
	}
	
	public void setInterestDay(Integer value) {
		this.interestDay = value;
	}
	
	public Integer getInterestDay() {
		return this.interestDay;
	}
	
	public void setInterestStartDate(java.util.Date value) {
		this.interestStartDate = value;
	}
	
	public java.util.Date getInterestStartDate() {
		return this.interestStartDate;
	}
	
	public void setInterestEndDate(java.util.Date value) {
		this.interestEndDate = value;
	}
	
	public java.util.Date getInterestEndDate() {
		return this.interestEndDate;
	}
	
	public void setInterestPrincipal(java.math.BigDecimal value) {
		this.interestPrincipal = value;
	}
	
	public java.math.BigDecimal getInterestPrincipal() {
		return this.interestPrincipal;
	}
	
	public void setPlanRepayDate(java.util.Date value) {
		this.planRepayDate = value;
	}
	
	public java.util.Date getPlanRepayDate() {
		return this.planRepayDate;
	}
	
	public void setPrincipal(java.math.BigDecimal value) {
		this.principal = value;
	}
	
	public java.math.BigDecimal getPrincipal() {
		return this.principal;
	}
	
	public void setInterest(java.math.BigDecimal value) {
		this.interest = value;
	}
	
	public java.math.BigDecimal getInterest() {
		return this.interest;
	}
	
	public void setOverInterest(java.math.BigDecimal value) {
		this.overInterest = value;
	}
	
	public java.math.BigDecimal getOverInterest() {
		return this.overInterest;
	}
	
	public void setOverDay(Integer value) {
		this.overDay = value;
	}
	
	public Integer getOverDay() {
		return this.overDay;
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
	
	public void setVersionNo(Integer value) {
		this.versionNo = value;
	}
	
	public Integer getVersionNo() {
		return this.versionNo;
	}
	
	public void setOverPunishDay(Integer value) {
		this.overPunishDay = value;
	}
	
	public Integer getOverPunishDay() {
		return this.overPunishDay;
	}
	
	public void setInterestType(Integer value) {
		this.interestType = value;
	}
	
	public Integer getInterestType() {
		return this.interestType;
	}

	public Integer getOriginType() {
		return originType;
	}

	public void setOriginType(Integer originType) {
		this.originType = originType;
	}

	public String getOriginatorId() {
		return originatorId;
	}

	public void setOriginatorId(String originatorId) {
		this.originatorId = originatorId;
	}
	
	public Integer getLoanUserId() {
		return loanUserId;
	}
	
	public void setLoanUserId(Integer loanUserId) {
		this.loanUserId = loanUserId;
	}
	
	/**
	 * @return the platformFee
	 */
	public BigDecimal getPlatformFee() {
		return platformFee;
	}
	
	/**
	 * @param platformFee the platformFee to set
	 */
	public void setPlatformFee(BigDecimal platformFee) {
		this.platformFee = platformFee;
	}

	@Override
	public String toString() {
		return "BizplanRepay [id=" + id + ", repayPlanGuid=" + repayPlanGuid + ", planSettleCode=" + planSettleCode
				+ ", loanUserId=" + loanUserId + ", projectId=" + projectId + ", exchangeId=" + exchangeId
				+ ", memeberId=" + memeberId + ", periodNumber=" + periodNumber + ", interestDay=" + interestDay
				+ ", interestStartDate=" + interestStartDate + ", interestEndDate=" + interestEndDate
				+ ", interestPrincipal=" + interestPrincipal + ", planRepayDate=" + planRepayDate + ", principal="
				+ principal + ", interest=" + interest + ", overInterest=" + overInterest + ", overDay=" + overDay
				+ ", createTime=" + createTime + ", createOperatorId=" + createOperatorId + ", updateTime=" + updateTime
				+ ", updateOperatorId=" + updateOperatorId + ", versionNo=" + versionNo + ", overPunishDay="
				+ overPunishDay + ", interestType=" + interestType + ", originType=" + originType + ", originatorId="
				+ originatorId + ", platformFee=" + platformFee + "]";
	}

}
