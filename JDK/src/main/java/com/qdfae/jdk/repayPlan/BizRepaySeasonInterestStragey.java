package com.qdfae.jdk.repayPlan;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.qdfae.jdk.utils.DateUtil;

/**
 * 按季计息，到期还本
 * 
 * @author hongwei.lian
 * 2018年2月14日 上午10:30:06
 */
@Service("seasonInterestStragey")
public class BizRepaySeasonInterestStragey implements BizrepayPlanGenStragey {
	
	@SuppressWarnings("deprecation")
	@Override
	public int countPeriods(Date valueDate, Date expireDate) {
		//按季统计
		int periods = 0;
		//相差月份
		int months = (expireDate.getYear()- valueDate.getYear())*12 + (expireDate.getMonth()-valueDate.getMonth()) + (expireDate.getDate() > valueDate.getDate()? 1: 0);
		if(months%3 == 0){
			periods += months/3;
		}else{
			periods += months/3 + 1;
		}
		return periods;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Date getNextValueDate(Date interestStartDate,Date expireDate,int settleInvestDay,int period) {
		Date nextValueDate = null;
		//期数为1且相差月份是3的倍数且起息日的日期<结息日
		if(period == 1 && (expireDate.getMonth()-interestStartDate.getMonth())%3==0 
				&& interestStartDate.getDate() < settleInvestDay){
			nextValueDate = interestStartDate;
		}else{
			nextValueDate = DateUtil.add(interestStartDate, Calendar.MONTH, 3);
		}
		return DateUtil.setDays(nextValueDate, DateUtil.getMinDay(nextValueDate, settleInvestDay));
	}

	@Override
	public int getInterestType(GenInterestTypeParam param) {
		return InterestTypeEnum.按日计息.value;
	}

	@Override
	public BigDecimal[] getPrincipal(BigDecimal totalPrincipal, BigDecimal investProfit, int period,
			int periods) {
		//当期应还本金
		BigDecimal principal = BigDecimal.ZERO;
		if(period == periods){
			//最后一期
			principal = totalPrincipal;
		}
		BigDecimal interestPrincipal = totalPrincipal;
		return new BigDecimal[]{principal,interestPrincipal};
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
