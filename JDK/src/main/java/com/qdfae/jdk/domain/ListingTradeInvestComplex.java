package com.qdfae.jdk.domain;

import java.math.BigDecimal;

public class ListingTradeInvestComplex extends ListingTradeInvestVo {
	
	private static final long serialVersionUID = -235382000947846977L;
	
	/**
	 * 每一个起投金额对应的上线，也就是下一个起投金额
	 */
	private BigDecimal investAmountMax;

	public BigDecimal getInvestAmountMax() {
		return investAmountMax;
	}

	public void setInvestAmountMax(BigDecimal investAmountMax) {
		this.investAmountMax = investAmountMax;
	}

}
