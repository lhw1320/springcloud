-- 兑付申请
SELECT 
  project_baseinfo.Id AS ProjectId,
  projectCode,
  projectFullName,
  rewardStatus AS projectRewardStatu, -- 项目兑付状态
  newestStatus,  -- 本期兑付状态
  ApplyStatus,
FROM project_baseinfo JOIN (SELECT 
  SUBSTRING_INDEX(GROUP_CONCAT(PayInvestStatus ORDER BY Id),',',1) AS newestStatus,
  ApplyStatus FROM bizpayinvest_result LEFT JOIN (SELECT RelationId,SUBSTRING_INDEX(GROUP_CONCAT(ApplyStatus ORDER BY Id),',',-1) AS ApplyStatus FROM project_money_apply WHERE ApplyType = 2 GROUP BY RelationId) project_money_apply 
ON bizpayinvest_result.Id=project_money_apply.RelationId
WHERE PayInvestStatus IN(1,3) 
AND (ApplyStatus IN(2,3) OR ApplyStatus IS NULL)
GROUP BY ProjectId) bizpayinvest_result
ON(project_baseinfo.Id=bizpayinvest_result.ProjectId)
WHERE project_baseinfo.ProductTypeId=1 -- 债务融资计划
AND project_baseinfo.ManageDuration=1 -- 资金经过交易所
AND project_baseinfo.ProjectStatus=10 -- 发行成功
AND project_baseinfo.RewardStatus IN(1,3) -- 未兑付和部分兑付
ORDER BY project_baseinfo.UpdateTime DESC


-- 杜甫复核
SELECT 
  project_baseinfo.Id AS ProjectId,
  projectCode,
  projectFullName,
  rewardStatus AS projectRewardStatu, -- 项目兑付状态
  bizpayinvest_result.PayInvestStatus AS newestStatus,  -- 本期兑付状态
  project_money_apply.ApplyStatus 
FROM project_baseinfo 
JOIN bizpayinvest_result ON(project_baseinfo.Id=bizpayinvest_result.ProjectId)
JOIN project_money_apply ON(bizpayinvest_result.Id=project_money_apply.RelationId)
WHERE project_money_apply.ApplyStatus=1
AND project_baseinfo.ProductTypeId=1 -- 债务融资计划
AND project_baseinfo.ManageDuration=1 -- 资金经过交易所
AND project_baseinfo.ProjectStatus=10 -- 发行成功
AND project_baseinfo.RewardStatus IN(1,3) -- 未兑付和部分兑付
GROUP BY ProjectId
ORDER BY project_baseinfo.UpdateTime DESC



-- 兑付查询
SELECT 
  project_baseinfo.Id AS ProjectId,
  projectCode,
  projectFullName,
  rewardStatus AS projectRewardStatu, -- 项目兑付状态
  newestStatus,  -- 本期兑付状态
  ApplyStatus
FROM project_baseinfo LEFT JOIN (SELECT 
  Id AS ResultId,ProjectId,CreateTime,
  SUBSTRING_INDEX(GROUP_CONCAT(PayInvestStatus ORDER BY Id),',',1) AS newestStatus,
  PaidInvestMoney,
  PeriodNumber,
  PayInvestMoney,
  ApplyStatus
FROM bizpayinvest_result
LEFT JOIN (SELECT RelationId,SUBSTRING_INDEX(GROUP_CONCAT(ApplyStatus ORDER BY Id),',',-1) AS ApplyStatus FROM project_money_apply WHERE ApplyType = 2 GROUP BY RelationId) project_money_apply 
ON bizpayinvest_result.Id=project_money_apply.RelationId
WHERE PayInvestStatus IN(1,3) 
AND (ApplyStatus IN(2,3) OR ApplyStatus IS NULL)
GROUP BY ProjectId) bizpayinvest_result
ON(project_baseinfo.Id=bizpayinvest_result.ProjectId)
WHERE project_baseinfo.ProductTypeId=1 -- 债务融资计划
AND project_baseinfo.ManageDuration=1 -- 资金经过交易所
AND project_baseinfo.ProjectStatus=10 -- 发行成功
ORDER BY project_baseinfo.UpdateTime DESC





-- 编写SQL思路
-- 1、
-- 
--
-- 








