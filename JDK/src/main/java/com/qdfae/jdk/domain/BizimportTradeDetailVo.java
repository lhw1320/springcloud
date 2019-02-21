package com.qdfae.jdk.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.qdfae.jdk.enums.CertificateTypeEnum;

public class BizimportTradeDetailVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9108985129103312017L;
	
	/**
	 * 主键
	 */
	private int id;

	/**
	 * 业务登记申请表id, bizimport_apply.id
	 */
	private int bizImportApplyId;

	/**
	 * 数据文件汇总信息表id, bizimport_file_summary.id
	 */
	private int bizImportFileSummaryId;

	/**
	 * 合作方交易流水号
	 */
	private String partnerTradeSeq;

	/**
	 * 产品挂牌id, project_baseinfo.id
	 */
	private int projectId;

	/**
	 * 承销商id/申请者会员id, uc_user.id
	 */
	private int applyMemberId;

	/**
	 * 交易时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date tradeTime;

	/**
	 * 渠道项目分期名称
	 */
	private String periodName;

	/**
	 * 渠道分期代码
	 */
	private String periodCode;

	/**
	 * 项目分期id（对应于本系统）
	 */
	private Integer projectPeriodId;

	/**
	 * 交易金额
	 */
	private java.math.BigDecimal tradeMoney;

	/**
	 * 客户Id
	 */
	private Integer userId;

	/**
	 * 是否本次新增的用户, 1-是, 0-否
	 */
	private Boolean isNewUser;

	/**
	 * 客户编号
	 */
	private String userCode;

	/**
	 * 手机号, 敏感数据加密
	 */
	private String phoneNumber;

	/**
	 * 注册时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date registerTime;

	/**
	 * 证件类型
	 */
	private CertificateTypeEnum idType;

	/**
	 * 证件号码, 敏感数据加密
	 */
	private String idNumber;

	/**
	 * 用户真实姓名, 敏感数据加密
	 */
	private String userRealName;

	/**
	 * 订单Id
	 */
	private Integer orderApplyId;

	/**
	 * 交易所id
	 */
	private Integer exchangeId;

	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date createTime;

	/**
	 * 更新时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date updateTime;
	
	/**
	 * 客户简称
	 */
	private String userName;
	
	private String projectCode;
	
	private String projectName;
	//风险承受能力测评分数
	private String evaluationScore;
	//风险偏好类型
	private String evaluationType;
	//首次测评日期
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date  evaluationBeginDate;
	//是否在有效期内
	private String evaluationEffect;
	//投资者账户
	private String cardAccount;
	//开户行
	private String channelName;
	
	public void setId(Integer value) {
		this.id = value;
	}

	public Integer getId() {
		return this.id;
	}

	public void setBizImportApplyId(Integer value) {
		this.bizImportApplyId = value;
	}

	public Integer getBizImportApplyId() {
		return this.bizImportApplyId;
	}

	public void setBizImportFileSummaryId(Integer value) {
		this.bizImportFileSummaryId = value;
	}

	public Integer getBizImportFileSummaryId() {
		return this.bizImportFileSummaryId;
	}

	public void setPartnerTradeSeq(String value) {
		this.partnerTradeSeq = value;
	}

	public String getPartnerTradeSeq() {
		return this.partnerTradeSeq;
	}

	public void setProjectId(Integer value) {
		this.projectId = value;
	}

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setApplyMemberId(Integer value) {
		this.applyMemberId = value;
	}

	public Integer getApplyMemberId() {
		return this.applyMemberId;
	}

	public void setTradeTime(java.util.Date value) {
		this.tradeTime = value;
	}

	public java.util.Date getTradeTime() {
		return this.tradeTime;
	}

	public void setPeriodName(String value) {
		this.periodName = value;
	}

	public String getPeriodName() {
		return this.periodName;
	}

	public void setPeriodCode(String value) {
		this.periodCode = value;
	}

	public String getPeriodCode() {
		return this.periodCode;
	}

	public void setProjectPeriodId(Integer value) {
		this.projectPeriodId = value;
	}

	public Integer getProjectPeriodId() {
		return this.projectPeriodId;
	}

	public void setTradeMoney(java.math.BigDecimal value) {
		this.tradeMoney = value;
	}

	public java.math.BigDecimal getTradeMoney() {
		return this.tradeMoney;
	}

	public void setUserId(Integer value) {
		this.userId = value;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public Boolean isNewUser() {
		return this.isNewUser;
	}

	public void setNewUser(Boolean value) {
		this.isNewUser = value;
	}

	public void setUserCode(String value) {
		this.userCode = value;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setPhoneNumber(String value) {
		this.phoneNumber = value;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setRegisterTime(java.util.Date value) {
		this.registerTime = value;
	}

	public java.util.Date getRegisterTime() {
		return this.registerTime;
	}

	public CertificateTypeEnum getIdType() {
		return this.idType;
	}

	public void setIdType(CertificateTypeEnum value) {
		this.idType = value;
	}

	public void setIdType(int value) {
		this.idType = CertificateTypeEnum.fromValue(value);
	}

	public void setIdNumber(String value) {
		this.idNumber = value;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setUserRealName(String value) {
		this.userRealName = value;
	}

	public String getUserRealName() {
		return this.userRealName;
	}

	public void setOrderApplyId(Integer value) {
		this.orderApplyId = value;
	}

	public Integer getOrderApplyId() {
		return this.orderApplyId;
	}

	public void setExchangeId(Integer value) {
		this.exchangeId = value;
	}

	public Integer getExchangeId() {
		return this.exchangeId;
	}

	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}

	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}

	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEvaluationScore() {
		return evaluationScore;
	}

	public void setEvaluationScore(String evaluationScore) {
		this.evaluationScore = evaluationScore;
	}

	public String getEvaluationType() {
		return evaluationType;
	}

	public void setEvaluationType(String evaluationType) {
		this.evaluationType = evaluationType;
	}

	public Date getEvaluationBeginDate() {
		return evaluationBeginDate;
	}

	public void setEvaluationBeginDate(Date evaluationBeginDate) {
		this.evaluationBeginDate = evaluationBeginDate;
	}

	public String getEvaluationEffect() {
		return evaluationEffect;
	}

	public void setEvaluationEffect(String evaluationEffect) {
		this.evaluationEffect = evaluationEffect;
	}

	public String getCardAccount() {
		return cardAccount;
	}

	public void setCardAccount(String cardAccount) {
		this.cardAccount = cardAccount;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

}
