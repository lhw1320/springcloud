package com.qdfae.jdk.repayPlan;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 还款计划生成策略
 * 
 * @author hongwei.lian 
 * @date 2018年2月13日 下午10:19:04
 */
public interface BizrepayPlanGenStragey {
	
	/**
	 * 统计期数
	 * 
	 * @param valueDate
	 * @param expireDate
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年2月13日 下午10:18:00
	 */
	int countPeriods(Date valueDate, Date expireDate);
	
	/**
	 * 获取下期起息日
	 * 
	 * @param interestStartDate
	 * @param expireDate
	 * @param settleInvestDay
	 * @param period
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年2月13日 下午10:17:51
	 */
	Date getNextValueDate(Date interestStartDate, Date expireDate, int settleInvestDay, int period);
	
	/**
	 * 获取计息方式
	 * 
	 * @param param
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年2月13日 下午10:19:35
	 */
	int getInterestType(GenInterestTypeParam param);
	
	/**
	 * 获取应还本金和计息本金
	 * 
	 * @param totalPrincipal
	 * @param investProfit
	 * @param period
	 * @param periods
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年2月13日 下午10:17:20
	 */
	BigDecimal[] getPrincipal(BigDecimal totalPrincipal, BigDecimal investProfit, int period, int periods);
	

	/**
	 * 调整利息
	 * 
	 * @param totalPrincipal
	 * @param principal
	 * @param interest
	 * @param investProfit
	 * @param interestType
	 * @param periods
	 * @param projectLimit
	 * @param projectLimitTypeId
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年2月13日 下午10:16:58
	 */
	BigDecimal adjustmentInterest(BigDecimal totalPrincipal, BigDecimal principal, BigDecimal interest,
			BigDecimal investProfit, int interestType, int periods, Integer projectLimit, Integer projectLimitTypeId);

}
