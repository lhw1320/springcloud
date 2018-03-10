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
	 * 交易明细出金账号
	 */
	private String outAccountNo;
	
	/*
	 * 交易明细出金账户名称
	 */
	private String outAccountName;
	
	/**
	 * 交易明细入金账号
	 */
	private String inAccountNo;
	
	/**
	 * 交易明细入金账户名称
	 */
	private String InAccountName;
	
	/**
	 * 交易金额
	 */
	private BigDecimal balance;

	public TradeDetail() {}
	
	public TradeDetail(Integer id, String inAccountNo) {
		this.id = id;
		this.inAccountNo = inAccountNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOutAccountNo() {
		return outAccountNo;
	}

	public void setOutAccountNo(String outAccountNo) {
		this.outAccountNo = outAccountNo;
	}

	public String getOutAccountName() {
		return outAccountName;
	}

	public void setOutAccountName(String outAccountName) {
		this.outAccountName = outAccountName;
	}

	public String getInAccountNo() {
		return inAccountNo;
	}

	public void setInAccountNo(String inAccountNo) {
		this.inAccountNo = inAccountNo;
	}

	public String getInAccountName() {
		return InAccountName;
	}

	public void setInAccountName(String inAccountName) {
		InAccountName = inAccountName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "TradeDetail [id=" + id + ", outAccountNo=" + outAccountNo + ", outAccountName=" + outAccountName
				+ ", inAccountNo=" + inAccountNo + ", InAccountName=" + InAccountName + ", balance=" + balance + "]";
	}

}
