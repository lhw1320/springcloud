package com.qdfae.jdk.repayPlan;

import java.util.Date;

import com.qdfae.jdk.utils.DateUtil;

public class GenRepayStageParam {
	//起息日
	public Date valueDate;
	//到期日
	public Date expireDate;
	//结息日
	public Integer settleInvestDay;
	//还款期限
	public Integer repayPeriodDay;
	//项目期限
	public Integer projectLimit;
	//项目期限类型
	public Integer projectLimitType;
	//还款方式
	public Integer repayTypeId;
	//固定期数，如果该值不为空则使用该值，主要提供给提前还款使用
	public Integer fixedPeriods;
	
	
	
	@SuppressWarnings("deprecation")
	public GenRepayStageParam(Date valueDate,Date expireDate,Integer settleInvestDay,
			Integer repayPeriodDay,Integer projectLimit,Integer projectLimitType,Integer repayTypeId){
		this.valueDate = valueDate;
		this.expireDate = expireDate;
		this.settleInvestDay = settleInvestDay;
		this.repayPeriodDay = repayPeriodDay;
		this.projectLimit = projectLimit;
		this.projectLimitType = projectLimitType;
		this.repayTypeId = repayTypeId;
		if(this.settleInvestDay == null || this.settleInvestDay == 0){
			//this.projectLimitType.intValue() == ProjectLimitType.年.type
			if(this.repayTypeId.intValue() == RepayTypeEnum.按年付息到期还本.value){
				this.settleInvestDay = Integer.parseInt(DateUtil.formatDate(this.valueDate,"MMdd"));
			}else{
				this.settleInvestDay = this.valueDate.getDate();
			}
			
		}
	}
	
	public void setSettleInvestDay(Integer settleInvestDay) {
		this.settleInvestDay = settleInvestDay;
	}

	public Integer getFixedPeriods() {
		return fixedPeriods;
	}

	public void setFixedPeriods(Integer fixedPeriods) {
		this.fixedPeriods = fixedPeriods;
	}
	
	
}
