package com.qdfae.jdk.repayPlan;

import java.util.Calendar;
import java.util.Date;

import com.qdfae.jdk.enums.TimeLimitTypeEnum;
import com.qdfae.jdk.utils.DateUtil;

/**
 * 还款计划分期参数
 * 
 * @author hongwei.lian
 * 2018年2月24日 下午5:40:54
 */
public class GenRepayStageParam {
	
	/**
	 * 放款时间
	 */
	private Date releaseTime;
	
	/**
	 * 融资期限
	 */
	private Integer timeLimit;
	
	/**
	 * 融资期限类型
	 */
	private Integer timeLimitType;
	
	/**
	 * 还款方式
	 */
	private Integer repayType;
	
	/**
	 * 固定期数，如果该值不为空则使用该值，主要提供给提前还款使用
	 */
	private Integer fixedPeriods;
	
	public GenRepayStageParam(Date releaseTime, Integer timeLimit, Integer timeLimitType, Integer repayType){
		this.releaseTime = releaseTime;
		this.timeLimit = timeLimit;
		this.timeLimitType = timeLimitType;
		this.repayType = repayType;
	}
	
	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public Integer getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
	}

	public Integer getTimeLimitType() {
		return timeLimitType;
	}

	public void setTimeLimitType(Integer timeLimitType) {
		this.timeLimitType = timeLimitType;
	}

	public Integer getRepayType() {
		return repayType;
	}

	public void setRepayType(Integer repayType) {
		this.repayType = repayType;
	}

	public Integer getFixedPeriods() {
		return fixedPeriods;
	}

	public void setFixedPeriods(Integer fixedPeriods) {
		this.fixedPeriods = fixedPeriods;
	}
	
	/**
	 * 计算起息日
	 * 放款时间即为起息日
	 * 
	 * @return
	 * @author hongwei.lian
	 * 2018年2月24日 下午6:22:33
	 */
	public Date getValueDate() {
		return releaseTime;
	}
	
	/**
	 * 计算到期日
	 * 到期日=起息日+融资期限（根据期限类型进行计算）
	 * 
	 * @return
	 * @author hongwei.lian
	 * 2018年2月24日 下午6:22:21
	 */
	public Date getExpireDate() {
		Date expireDate = null;
		TimeLimitTypeEnum timeLimitTypeEnum = TimeLimitTypeEnum.getTimeLimitType(getTimeLimitType());
		switch (timeLimitTypeEnum) {
		case 天:
			expireDate = DateUtil.add(getValueDate(), Calendar.DATE, getTimeLimit());
			break;
		case 月:
			expireDate = DateUtil.add(getValueDate(), Calendar.MONTH, getTimeLimit());
			break;
		case 年:
			expireDate = DateUtil.add(getValueDate(), Calendar.YEAR, getTimeLimit());
			break;
		default:
			break;
		}
		return expireDate;
	}

}
