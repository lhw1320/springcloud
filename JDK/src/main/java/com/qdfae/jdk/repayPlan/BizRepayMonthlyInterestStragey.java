package com.qdfae.jdk.repayPlan;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.qdfae.jdk.utils.DateUtil;

/**
 * 按月计息，到期还本
 * 
 * @author hongwei.lian
 * 2018年2月14日 上午10:19:04
 */
@Service("monthlyInterestStragey")
public class BizRepayMonthlyInterestStragey implements BizrepayPlanGenStragey{
	
	/**
	 * 统计期数 
	 * @return int
	 * @author qiang.wen
	 * 2016年5月9日 下午5:06:25
	 */
	@Override
	@SuppressWarnings("deprecation")
	public int countPeriods(Date valueDate, Date expireDate) {
		return (expireDate.getYear()- valueDate.getYear())*12 + (expireDate.getMonth()-valueDate.getMonth()) + (expireDate.getDate() > valueDate.getDate()? 1: 0);
	}

	/**
	 * 获取下期起息日
	 */
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

	/**
	 * 获取应还本金和计息本金
	 */
	@Override
	public BigDecimal[] getPrincipal(BigDecimal totalPrincipal, BigDecimal investProfit, int period,int periods) {
		//当期应还本金
		BigDecimal principal = BigDecimal.ZERO;
		if(period == periods){
			//最后一期
			principal = totalPrincipal;
		}
		//计息本金
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
	
	/**
	 * 计息方式
	 */
	@Override
	public int getInterestType(GenInterestTypeParam param) {
		return InterestTypeEnum.按日计息.value;
	}

}
