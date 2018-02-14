package com.qdfae.jdk.repayPlan;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.qdfae.jdk.utils.DateUtil;

/**
 * 等额本金，按月还款
 * 
 * @author hongwei.lian
 * 2018年2月14日 上午10:28:10
 */
@Service("monthlyPrincipalStragey")
public class BizRepayMonthlyPrincipalStragey implements BizrepayPlanGenStragey {

	@SuppressWarnings("deprecation")
	@Override
	public int countPeriods(Date valueDate, Date expireDate) {
		return (expireDate.getYear()- valueDate.getYear())*12 + (expireDate.getMonth()-valueDate.getMonth()) + (expireDate.getDate() > valueDate.getDate()? 1: 0);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Date getNextValueDate(Date interestStartDate,Date expireDate,int settleInvestDay,int period) {
		Date nextValueDate = null;
		if(period == 1 && (interestStartDate.getDate() < settleInvestDay)){
			nextValueDate = interestStartDate;
		}else{
			nextValueDate = DateUtil.add(interestStartDate, Calendar.MONTH, 1);
		}
		return DateUtil.setDays(nextValueDate, DateUtil.getMinDay(nextValueDate, settleInvestDay));
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getInterestType(GenInterestTypeParam param) {
		int interestType = InterestTypeEnum.按日计息.value;
		if(param.interestStartDate.getDate() == param.nextValueDate.getDate()){
			//当期是满月的
			interestType = InterestTypeEnum.按月计息.value;
		}else{
			//当期不满月或者超过一个月
			interestType = InterestTypeEnum.按日计息.value;
		}
		return interestType;
	}

	@Override
	public BigDecimal[] getPrincipal(BigDecimal totalPrincipal, BigDecimal investProfit, int period,
			int periods) {
		//每月偿还的本金
		BigDecimal payPrincipal = totalPrincipal.divide(new BigDecimal(periods),2, BigDecimal.ROUND_DOWN);
		//每月计息本金
		BigDecimal interestPrincipal = totalPrincipal.subtract(payPrincipal.multiply(new BigDecimal(period-1)));
		//最后一期偿还本金
		if(period == periods){
			payPrincipal = interestPrincipal;
		}		
		return new BigDecimal[]{payPrincipal,interestPrincipal};
	}

	/**
	 * 调整利息
	 * 
	 * @param totalPrincipal
	 * @param interest
	 * @param investProfit
	 * @param interestType
	 * @param period
	 * @param periods
	 * @return
	 */
	public BigDecimal adjustmentInterest(BigDecimal totalPrincipal, BigDecimal principal, BigDecimal interest,
			BigDecimal investProfit, int interestType, int periods, Integer projectLimit, Integer projectLimitTypeId) {
		return interest;
	}
}
