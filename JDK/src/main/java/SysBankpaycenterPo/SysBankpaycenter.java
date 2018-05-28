package SysBankpaycenterPo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 银行支付结算渠道
 * 
 * @author hongwei.lian 
 * @date 2018年5月26日 下午6:16:36
 */
public class SysBankpaycenter implements Serializable {
	
	private static final long serialVersionUID = 1540054122375184486L;

	/**
	 * 支付渠道id
	 */
	private Integer paycenterId;
	
	/**
	 * 支付渠道名称
	 */
	private String payCenterName;
	
	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	private Date createTime;
	
	/**
	 * 渠道类型  1=支付渠道 2=结算渠道
	 */
	private Integer payChannelType;

	/**
	 * 银行id sys_bank.id
	 */
	private Integer bankId;
	
	/**
	 * 银行账号（加密）
	 */
	private String accountName;
	
	/**
	 * 银行账户名称（加密）
	 */
	private String accountNumber;
	
	/**
	 * 省份
	 */
	private String province;
	
	/**
	 * 城市
	 */
	private String city;
	
	/**
	 * 银行账户所在分支行名称
	 */
	private String subBankName;
	
	/**
	 * 更新时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	private Date updateTime;
	
	/**
	 * 默认渠道 
	 * 默认结算银行渠道规则说明：
	 * 1、没有指定结算渠道的项目的资金默认归集到此渠道；
	 * 2、各项目的费用归集到此默认渠道
	 */
	private Integer defaultChannel;
	
	/**
	 * 交易所id exchange.id
	 */
	private Integer exchangeId;
	
	/**
	 * 联行号
	 */
	private String subBankNo;
	
	/**
	 * 账户类型 
	 * 1、个人账户 
	 * 2、企业账户 
	 * 3、支付账户
	 */
	private Integer accountType;
	
	/**
	 * 是否启用 
	 * 1、启用 
	 * 0、停用
	 */
	private Integer useEnabled;
	
	/**
	 * 渠道父类id(新增20160525)
	 */
	private Integer payChannelCategoryId;
	
	/**
	 * 渠道父类名
	 */
	private String payChannelCategoryName;
	
	/**
	 * 渠道使用类型 
	 * 1、机构用户 
	 * 2、个人用户 
	 * 3、通用
	 */
	private Integer payChannelUserType;
	
	/**
	 * 渠道结算机构号
	 */
	private String payChannelAgencyNo;
	
	/**
	 * 发送绑卡短信验证码开关 
	 * 0、关，
	 * 1、开
	 */
	private Integer bindCardSmsSwitch;
	
	/**
	 * 招行支行地区号
	 */
	private String subBankAreaCode;

	public SysBankpaycenter(Integer paycenterId, String payCenterName) {
		this.paycenterId = paycenterId;
		this.payCenterName = payCenterName;
	}

	public Integer getBindCardSmsSwitch() {
		return bindCardSmsSwitch;
	}
	
	public void setBindCardSmsSwitch(Integer bindCardSmsSwitch) {
		this.bindCardSmsSwitch = bindCardSmsSwitch;
	}
	
	public void setPaycenterId(Integer value) {
		this.paycenterId = value;
	}
	
	public Integer getPaycenterId() {
		return this.paycenterId;
	}
	
	public void setPayCenterName(String value) {
		this.payCenterName = value;
	}
	
	public String getPayCenterName() {
		return this.payCenterName;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setPayChannelType(Integer value) {
		this.payChannelType = value;
	}
	
	public Integer getPayChannelType() {
		return this.payChannelType;
	}
	
	public void setBankId(Integer value) {
		this.bankId = value;
	}
	
	public Integer getBankId() {
		return this.bankId;
	}
	
	public void setAccountName(String value) {
		this.accountName = value;
	}
	
	public String getAccountName() {
		return this.accountName;
	}
	
	public void setAccountNumber(String value) {
		this.accountNumber = value;
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public void setProvince(String value) {
		this.province = value;
	}
	
	public String getProvince() {
		return this.province;
	}
	
	public void setCity(String value) {
		this.city = value;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setSubBankName(String value) {
		this.subBankName = value;
	}
	
	public String getSubBankName() {
		return this.subBankName;
	}
	
	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}
	
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
	
	public void setDefaultChannel(Integer value) {
		this.defaultChannel = value;
	}
	
	public Integer getDefaultChannel() {
		return this.defaultChannel;
	}
	
	public void setSubBankNo(String value) {
		this.subBankNo = value;
	}
	
	public String getSubBankNo() {
		return this.subBankNo;
	}
	
	public void setAccountType(Integer value) {
		this.accountType = value;
	}
	
	public Integer getAccountType() {
		return this.accountType;
	}
	
	public void setUseEnabled(Integer value) {
		this.useEnabled = value;
	}
	
	public Integer getUseEnabled() {
		return this.useEnabled;
	}
	
	public void setPayChannelCategoryId(Integer value) {
		this.payChannelCategoryId = value;
	}
	
	public Integer getPayChannelCategoryId() {
		return this.payChannelCategoryId;
	}
	
	public void setPayChannelCategoryName(String value) {
		this.payChannelCategoryName = value;
	}
	
	public String getPayChannelCategoryName() {
		return this.payChannelCategoryName;
	}
	
	public void setPayChannelUserType(Integer value) {
		this.payChannelUserType = value;
	}
	
	public Integer getPayChannelUserType() {
		return this.payChannelUserType;
	}
	
	public void setPayChannelAgencyNo(String value) {
		this.payChannelAgencyNo = value;
	}
	
	public String getPayChannelAgencyNo() {
		return this.payChannelAgencyNo;
	}
	
	public Integer getExchangeId() {
		return exchangeId;
	}
	
	public void setExchangeId(Integer exchangeId) {
		this.exchangeId = exchangeId;
	}
	
	public String getSubBankAreaCode() {
		return subBankAreaCode;
	}
	
	public void setSubBankAreaCode(String subBankAreaCode) {
		this.subBankAreaCode = subBankAreaCode;
	}

}
