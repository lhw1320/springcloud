package com.qdfae.jdk;

import java.math.BigDecimal;

import org.junit.Test;

public class RepayTest {
	
	@Test
	public void testRepay() {
		BigDecimal totalPrincipal = new BigDecimal("10000");
		BigDecimal monthlyInterestRate = new BigDecimal("0.01");
		System.out.println(monthlyInterestRate);
		int period = 2;
		int periods= 12;
//		BigDecimal result = totalPrincipal.multiply(monthlyInterestRate)
//		                                                       .multiply(monthlyInterestRate.add(BigDecimal.ONE).pow(period - 1))
//		                                                       .divide((monthlyInterestRate.add(BigDecimal.ONE).pow(periods).subtract(BigDecimal.ONE)), 2, BigDecimal.ROUND_DOWN);
//	    System.out.println(result);
	    
	    
	    BigDecimal residualPrincipa = calcResidualPrincipa(totalPrincipal, monthlyInterestRate, period, periods);
	    System.out.println(residualPrincipa);
	    
		 // 每月计息本金(剩余本金) = 贷款本金-已还本金
		 BigDecimal interestPrincipal = totalPrincipal.subtract(residualPrincipa);
		 System.out.println(interestPrincipal);
		 
		 
		// 每月偿还的本金=贷款本金*月利率*(1+月利率)^(当前期次-1)/((1+月利率)^总期次-1)
		BigDecimal payPrincipal = calcPrincipal(totalPrincipal, monthlyInterestRate, period, periods);
		System.out.println(payPrincipal);
	}
	
	/**
	 * 计算等额本息的n-1期还款本金之和
	 * 
	 * @param totalPrincipal
	 * @param monthlyInterestRate
	 * @param period
	 * @param periods
	 * @return
	 */
	private static BigDecimal calcResidualPrincipa(BigDecimal totalPrincipal, BigDecimal monthlyInterestRate, int n,
			int periods) {
		// 已还本金缺省值为0
		BigDecimal residualPrincipa = BigDecimal.ZERO;
		// 已还本金=每次还款本金之和
		for (int i = 1; i < n; i++) {
			residualPrincipa = residualPrincipa.add(calcPrincipal(totalPrincipal, monthlyInterestRate, i, periods));
		}
		return residualPrincipa;
	}
	
	/**
	 * 计算等额本息的每期还款本金
	 * 
	 * @param totalPrincipal
	 * @param monthlyInterestRate
	 * @param period
	 * @param periods
	 * @return
	 */
	private static BigDecimal calcPrincipal(BigDecimal totalPrincipal, BigDecimal monthlyInterestRate, int period,
			int periods) {
		if (monthlyInterestRate.compareTo(BigDecimal.ZERO) > 0) {
			// 每月偿还的本金=贷款本金*月利率*(1+月利率)^(当前期次-1)/((1+月利率)^总期次-1)
			return totalPrincipal.multiply(monthlyInterestRate)
					.multiply(monthlyInterestRate.add(BigDecimal.ONE).pow(period - 1))
					.divide((monthlyInterestRate.add(BigDecimal.ONE).pow(periods).subtract(BigDecimal.ONE)), 2,
							BigDecimal.ROUND_DOWN);
		} else {
			// 本金/期数
			return totalPrincipal.divide(new BigDecimal(periods), 2, BigDecimal.ROUND_DOWN);
		}
	}

}
