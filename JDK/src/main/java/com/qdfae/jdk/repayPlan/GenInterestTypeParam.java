package com.qdfae.jdk.repayPlan;

import java.util.Date;

/**
 * 计息方式参数
 * 
 * @author hongwei.lian 
 * @date 2018年2月13日 下午10:19:45
 */
public class GenInterestTypeParam {
	
	/**
	 * 起息日
	 */
	public Date interestStartDate;
	
	/**
	 * 下一期起息日
	 */
	public Date nextValueDate;
	
	/**
	 * 项目期限
	 */
	public Integer projectLimit;
	
	/**
	 * 项目期限类型
	 */
	public Integer projectLimitType;
	
	public GenInterestTypeParam(Date interestStartDate, Date nextValueDate, Integer projectLimit, Integer projectLimitType) {
		this.interestStartDate = interestStartDate;
		this.nextValueDate = nextValueDate;
		this.projectLimit = projectLimit;
		this.projectLimitType = projectLimitType;
	}

}
