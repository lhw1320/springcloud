package com.qdfae.jdk.repayPlan;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.qdfae.jdk.utils.DateUtil;

/**
 * 按年计息，到期还本
 * 
 * @author hongwei.lian
 * 2018年2月14日 上午10:33:35
 */
@Service("yearInterestStragey")
public class BizRepayYearInterestStragey implements BizrepayPlanGenStragey {
	
	@SuppressWarnings("deprecation")
	@Override
	public int countPeriods(Date valueDate, Date expireDate) {
		//按年统计
		int periods = 0;
		//相差年份
		periods += (expireDate.getYear()- valueDate.getYear());
		//相差月份
		int months = (expireDate.getMonth()-valueDate.getMonth());
		if(months > 0){
			periods += 1;
		}else if(months == 0){
			periods += (expireDate.getDate() > valueDate.getDate()? 1: 0);
		}
		return periods;
	}
	

	@SuppressWarnings("deprecation")
	@Override
	public Date getNextValueDate(Date interestStartDate,Date expireDate,int settleInvestDay,int period) {
		Date nextValueDate = DateUtil.add(interestStartDate, Calendar.YEAR, 1);
		//第一期
		if(period == 1){
			int expireMonth = expireDate.getMonth()+1;
			int startMonth = interestStartDate.getMonth()+1;
			int settleMonth = settleInvestDay/100;
			//1、   起息月<结息月  2、起息月=到期月=结息月 && 起息日<结息日 这两种情况需要调整第一期的周期
			boolean needAdapter = (startMonth < settleMonth) ||
					((expireMonth == startMonth && expireMonth == settleMonth) && (interestStartDate.getDate()< settleInvestDay%100));
			if(needAdapter){
				//下一期起息日
				nextValueDate = interestStartDate;
			}
		}
		//每年的结息日(mmDD) 
		// 修改月份之前一定要先修改日期
		nextValueDate = DateUtil.setDays(nextValueDate, DateUtil.getMinDay(nextValueDate,settleInvestDay%100));
		nextValueDate = DateUtil.setMonths(nextValueDate, settleInvestDay/100-1);
		return nextValueDate;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int getInterestType(GenInterestTypeParam param) {
		int interestType = InterestTypeEnum.按日计息.value;
		if(param.interestStartDate.getMonth() == param.nextValueDate.getMonth() && param.interestStartDate.getDate() == param.nextValueDate.getDate()){
			//当期是满年的
			interestType = InterestTypeEnum.按年计息.value;
		}else{
			//当期不满年或者超过一年
			interestType = InterestTypeEnum.按日计息.value;
		}
		return interestType;
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
