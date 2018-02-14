package com.qdfae.jdk.repayPlan;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.qdfae.jdk.utils.DateUtil;

/**
 * 等额本息
 * 
 * @author hongwei.lian 
 * @date 2018年2月13日 下午10:52:29
 */
@Service("equalInstallmentStragey")
public class BizRepayEqualInstallmentStragey implements BizrepayPlanGenStragey {

	@SuppressWarnings("deprecation")
	@Override
	public int countPeriods(Date valueDate, Date expireDate) {
		return (expireDate.getYear() - valueDate.getYear()) * 12 + (expireDate.getMonth() - valueDate.getMonth())
				+ (expireDate.getDate() > valueDate.getDate() ? 1 : 0);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Date getNextValueDate(Date interestStartDate, Date expireDate, int settleInvestDay, int period) {
		Date nextValueDate = null;
		if (period == 1 && (interestStartDate.getDate() < settleInvestDay)) {
			nextValueDate = interestStartDate;
		} else {
			nextValueDate = DateUtil.add(interestStartDate, Calendar.MONTH, 1);
		}
		return DateUtil.setDays(nextValueDate, DateUtil.getMinDay(nextValueDate, settleInvestDay));
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getInterestType(GenInterestTypeParam param) {
		int interestType = InterestTypeEnum.按日计息.value;
		if (param.interestStartDate.getDate() == param.nextValueDate.getDate()) {
			// 当期是满月的
			interestType = InterestTypeEnum.按月计息.value;
		} else {
			// 当期不满月或者超过一个月
			interestType = InterestTypeEnum.按日计息.value;
		}
		return interestType;
	}

	@Override
	public BigDecimal[] getPrincipal(BigDecimal totalPrincipal, BigDecimal investProfit, int period, int periods) {
		// 月利率=年利率/12
		BigDecimal monthlyInterestRate = monthlyInterestRate(investProfit);

		// n-1期还款本金之和
		BigDecimal residualPrincipa = calcResidualPrincipa(totalPrincipal, monthlyInterestRate, period, periods);

		// 每月偿还的本金=贷款本金*月利率*(1+月利率)^(当前期次-1)/((1+月利率)^总期次-1)
		BigDecimal payPrincipal = calcPrincipal(totalPrincipal, monthlyInterestRate, period, periods);

		// 每月计息本金(剩余本金) = 贷款本金-已还本金
		BigDecimal interestPrincipal = totalPrincipal.subtract(residualPrincipa);

		// 修正尾期还款本金，尾期还款本金=剩余本金
		if (period == periods) {
			payPrincipal = interestPrincipal;
		}
		return new BigDecimal[] { payPrincipal, interestPrincipal };
	}

	public BigDecimal adjustmentInterest(BigDecimal totalPrincipal, BigDecimal principal, BigDecimal interest,
			BigDecimal investProfit, int interestType, int periods, Integer projectLimit, Integer projectLimitTypeId) {
		BigDecimal adjustmentInterest = interest;
		// 如果按月计息时，则需要调整利息
		if (InterestTypeEnum.按月计息.value == interestType) {
			// 月利率=年利率/12
			BigDecimal equalInstallment = calcEqualInstallment(totalPrincipal, monthlyInterestRate(investProfit),
					periods);

			adjustmentInterest = equalInstallment.subtract(principal).compareTo(BigDecimal.ZERO) >= 0
					? equalInstallment.subtract(principal)
					: BigDecimal.ZERO;
		}
		return adjustmentInterest;
	}

	/**
	 * 计算月利率
	 * 
	 * @param investProfit
	 * @return
	 */
	private BigDecimal monthlyInterestRate(BigDecimal investProfit) {
		return investProfit.divide(new BigDecimal(12), 20, BigDecimal.ROUND_DOWN);
	}

	/**
	 * 计算等额本息的每期还款额
	 * 
	 * @param totalPrincipal
	 * @param monthlyInterestRate
	 * @param periods
	 * @return
	 */
	private BigDecimal calcEqualInstallment(BigDecimal totalPrincipal, BigDecimal monthlyInterestRate, int periods) {

		if (monthlyInterestRate.compareTo(BigDecimal.ZERO) > 0) {

			// 每期还款额 = [本金×月利率×（1+月利率）^总期数]÷[（1+月利率）^总期数－1]
			return totalPrincipal.multiply(monthlyInterestRate)
					.multiply(monthlyInterestRate.add(BigDecimal.ONE).pow(periods))
					.divide(monthlyInterestRate.add(BigDecimal.ONE).pow(periods).subtract(BigDecimal.ONE), 2,
							BigDecimal.ROUND_DOWN);
		} else {
			// 本金×（1+利率）/期数
			return totalPrincipal.multiply(monthlyInterestRate.add(BigDecimal.ONE)).divide(new BigDecimal(periods), 2,
					BigDecimal.ROUND_DOWN);

		}
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
	private BigDecimal calcPrincipal(BigDecimal totalPrincipal, BigDecimal monthlyInterestRate, int period,
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

	/**
	 * 计算等额本息的n-1期还款本金之和
	 * 
	 * @param totalPrincipal
	 * @param monthlyInterestRate
	 * @param period
	 * @param periods
	 * @return
	 */
	private BigDecimal calcResidualPrincipa(BigDecimal totalPrincipal, BigDecimal monthlyInterestRate, int n, int periods) {
		// 已还本金缺省值为0
		BigDecimal residualPrincipa = BigDecimal.ZERO;

		// 已还本金=每次还款本金之和
		for (int i = 1; i < n; i++) {
			residualPrincipa = residualPrincipa.add(calcPrincipal(totalPrincipal, monthlyInterestRate, i, periods));
		}

		return residualPrincipa;
	}

}
