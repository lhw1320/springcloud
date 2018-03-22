package com.qdfae.jdk.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 交易明细
 * 
 * @author hongwei.lian 
 * @date 2018年3月10日 下午2:44:35
 */
public class TradeDetail implements Serializable {
	
	private static final long serialVersionUID = 3386554986241170136L;

	/**
	 * 交易明细主键
	 */
	private Integer id;
	
	/**
	 * 账号
	 */
	private String accountNo;
	
	/**
	 * 账户名称
	 */
	private String accountName;
	
	/**
	 * 交易金额（+表示入金，-表示出金）
	 */
	private BigDecimal balance;

	public TradeDetail() {}
	
	public TradeDetail(Integer id, String accountNo, String accountName, BigDecimal balance) {
		this.id = id;
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.balance = balance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	/**
	 * 针对accountNo重写hashCode()方法
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNo == null) ? 0 : accountNo.hashCode());
		return result;
	}

	/**
	 * 针对accountNo重写equals()方法
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TradeDetail other = (TradeDetail) obj;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TradeDetail [id=" + id + ", accountNo=" + accountNo + ", accountName=" + accountName + ", balance="
				+ balance + "]";
	}

}
