package com.qdfae.jdk.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

public class ListingSaleagentVo implements Serializable {
	
	private static final long serialVersionUID = -1403869757243155545L;
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 产品id,project_baseinfo.id
	 */
	private Integer projectId;
	/**
	 * 承销会员id,uc_user.id
	 */
	private Integer saleMemberId;
	/**
	 * 承销类型Id,systype_base.CategoryId=2的typeid
	 */
	private Integer saleTypeId;
	/**
	 * 承销费率
	 */
	private java.math.BigDecimal saleFeeRate;
	/**
	 * 承销份额，单位份
	 */
	private java.math.BigDecimal saleAmount;
	/**
	 * 承销金额，单位元
	 */
	private java.math.BigDecimal saleMoney;
	
	/**
	 * 承销到账金额
	 */
	private java.math.BigDecimal saleReceivedMoney;
	/**
	 * 承销确权金额
	 */
	private java.math.BigDecimal saleCfmRightMoney;
	
	/**
	 * 产品所属会员id,uc_user.id,冗余字段
	 */
	private Integer memberId;
	/**
	 * 产品所属交易所id,fe_exchange.id,冗余字段
	 */
	private Integer exchangeId;
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
	private Integer updateOperatorId;
	
	
	private String saleMemberName;
	private String companyName;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getSaleMemberId() {
		return saleMemberId;
	}

	public void setSaleMemberId(Integer saleMemberId) {
		this.saleMemberId = saleMemberId;
	}

	public Integer getSaleTypeId() {
		return saleTypeId;
	}

	public void setSaleTypeId(Integer saleTypeId) {
		this.saleTypeId = saleTypeId;
	}

	public java.math.BigDecimal getSaleFeeRate() {
		return saleFeeRate;
	}

	public void setSaleFeeRate(java.math.BigDecimal saleFeeRate) {
		this.saleFeeRate = saleFeeRate;
	}

	public java.math.BigDecimal getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(java.math.BigDecimal saleAmount) {
		this.saleAmount = saleAmount;
	}

	public java.math.BigDecimal getSaleMoney() {
		return saleMoney;
	}

	public void setSaleMoney(java.math.BigDecimal saleMoney) {
		this.saleMoney = saleMoney;
	}

	public java.math.BigDecimal getSaleReceivedMoney() {
		return saleReceivedMoney;
	}

	public void setSaleReceivedMoney(java.math.BigDecimal saleReceivedMoney) {
		this.saleReceivedMoney = saleReceivedMoney;
	}

	public java.math.BigDecimal getSaleCfmRightMoney() {
		return saleCfmRightMoney;
	}

	public void setSaleCfmRightMoney(java.math.BigDecimal saleCfmRightMoney) {
		this.saleCfmRightMoney = saleCfmRightMoney;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(Integer exchangeId) {
		this.exchangeId = exchangeId;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateOperatorId() {
		return createOperatorId;
	}

	public void setCreateOperatorId(Integer createOperatorId) {
		this.createOperatorId = createOperatorId;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUpdateOperatorId() {
		return updateOperatorId;
	}

	public void setUpdateOperatorId(Integer updateOperatorId) {
		this.updateOperatorId = updateOperatorId;
	}

	public String getSaleMemberName() {
		return saleMemberName;
	}
	
	public void setSaleMemberName(String saleMemberName) {
		this.saleMemberName = saleMemberName;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public boolean formDataAllEmpty() {
		return (StringUtils.isNotBlank(saleMemberName) ||  StringUtils.isNotBlank(companyName)) && getSaleTypeId() == null
				&& getSaleMoney() == null && getSaleFeeRate() == null;
	}
	
	public BigDecimal getSaleFee() {
		if(getSaleCfmRightMoney() == null || getSaleFeeRate() == null)
			return BigDecimal.ZERO;
		return getSaleCfmRightMoney().multiply(getSaleFeeRate()).setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

}
