package com.qdfae.jdk.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 产品推荐
 * 
 * @author hongwei.lian
 * 2018年2月7日 下午7:42:44
 */
public class ProductRecommendReq implements Serializable {

	/**
	 * @author hongwei.lian
	 * 2018年2月7日 下午7:41:20
	 */
	private static final long serialVersionUID = -2600951794825733218L;
	
	/**
	 * 产品id
	 */
    private int productId;
	
    /**
     * 核心企业id
     */
	private int coreCompanyId;
	
	/**
	 * 客户id列表
	 */
	private List<Integer> companyIds;
	
	/**
	 * 操作员id
	 */
	private int operatorId;
	
	public ProductRecommendReq(){}
	
	public ProductRecommendReq(List<Integer> companyIds){
		this.companyIds = companyIds;
	}
	
	public ProductRecommendReq(int productId,int coreCompanyId,List<Integer> companyIds,int operatorId){
		this.productId = productId;
		this.coreCompanyId = coreCompanyId;
		this.companyIds = companyIds;
		this.operatorId = operatorId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCoreCompanyId() {
		return coreCompanyId;
	}

	public void setCoreCompanyId(int coreCompanyId) {
		this.coreCompanyId = coreCompanyId;
	}

	public List<Integer> getCompanyIds() {
		return companyIds;
	}

	public void setCompanyIds(List<Integer> companyIds) {
		this.companyIds = companyIds;
	}

	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

}
