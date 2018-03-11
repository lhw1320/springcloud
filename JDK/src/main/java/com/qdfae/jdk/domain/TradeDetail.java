package com.qdfae.jdk.domain;

import java.math.BigDecimal;

/**
 * 交易明细
 * 
 * @author hongwei.lian 
 * @date 2018年3月10日 下午2:44:35
 */
public class TradeDetail {
	
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

	@Override
	public String toString() {
		return "TradeDetail [id=" + id + ", accountNo=" + accountNo + ", accountName=" + accountName + ", balance="
				+ balance + "]";
	}

}
