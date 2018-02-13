package com.qdfae.jdk.repayPlan;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Service;

/**
 * 一次性还本付息
 * 
 * @author hongwei.lian 
 * @date 2018年2月13日 下午10:22:39
 */
@Service("oneTimeDebtStragey")
public class BizRepayOneTimeDebtStragey implements BizrepayPlanGenStragey {

	@Override
	public int countPeriods(Date valueDate, Date expireDate) {
		return 1;
	}

	@Override
	public Date getNextValueDate(Date interestStartDate,Date expireDate,int settleInvestDay,int period) {
		return expireDate;
	}

	@Override
	public int getInterestType(GenInterestTypeParam param) {
		int interestType = InterestTypeEnum.按日计息.value;
		ProjectLimitTypeEnum limitType = ProjectLimitTypeEnum.getProjectLimitType(param.projectLimitType);
		switch (limitType) {
		case 天:
			interestType = InterestTypeEnum.按日计息.value;
			break;
		case 月:
			if(param.projectLimit%12==0){
				interestType = InterestTypeEnum.按年计息.value;
			}else{
				interestType = InterestTypeEnum.按日计息.value;
			}
			break;
		case 年:
			interestType = InterestTypeEnum.按年计息.value;
			break;
		default:
			break;
		}
		return interestType;
	}

	@Override
	public BigDecimal[] getPrincipal(BigDecimal totalPrincipal, BigDecimal investProfit, int period,int periods) {
		return new BigDecimal[]{totalPrincipal,totalPrincipal};
	}

	@Override
	public BigDecimal adjustmentInterest(BigDecimal totalPrincipal, BigDecimal principal, BigDecimal interest,
			BigDecimal investProfit, int interestType, int periods, Integer projectLimit, Integer projectLimitTypeId) {
		//一次性还本付息
		if(interestType == InterestTypeEnum.按年计息.value) {
			if(projectLimitTypeId == ProjectLimitTypeEnum.月.value)
				return interest.multiply(new BigDecimal(projectLimit)).divide(new BigDecimal(12), 2, BigDecimal.ROUND_DOWN);
			else 
				return interest.multiply(new BigDecimal(projectLimit));
		}else {
			return interest;
		}
	}

}
