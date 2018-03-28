package com.qdfae.jdk.domain;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

public class SystypeBaseVo implements Serializable {

	private static final long serialVersionUID = 4314655301995147424L;
	
	/**
	 * 自增id
	 */
	private Integer id;
	/**
	 * 分类id systype_base_category.id
	 */
	private Integer categoryId;
	/**
	 * 类型id
	 */
	private Integer typeId;
	/**
	 * 类型名称
	 */
	private String typeName;
	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	private java.util.Date createTime;
	/**
	 * 创建人
	 */
	private Integer createOperatorId;
	/**
	 * 更新时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	private java.util.Date updateTime;
	/**
	 * 更新人
	 */
	private Integer updateOperatorId;
	
	private String codeForPA;
	
	public SystypeBaseVo() {}

	public SystypeBaseVo(Integer id, Integer categoryId, Integer typeId, String typeName) {
		this.id = id;
		this.categoryId = categoryId;
		this.typeId = typeId;
		this.typeName = typeName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateOperatorId() {
		return createOperatorId;
	}

	public void setCreateOperatorId(Integer createOperatorId) {
		this.createOperatorId = createOperatorId;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUpdateOperatorId() {
		return updateOperatorId;
	}

	public void setUpdateOperatorId(Integer updateOperatorId) {
		this.updateOperatorId = updateOperatorId;
	}

	public String getCodeForPA() {
		return codeForPA;
	}

	public void setCodeForPA(String codeForPA) {
		this.codeForPA = codeForPA;
	}

	@Override
	public String toString() {
		return "SystypeBaseVo [id=" + id + ", categoryId=" + categoryId + ", typeId=" + typeId + ", typeName="
				+ typeName + ", createTime=" + createTime + ", createOperatorId=" + createOperatorId + ", updateTime="
				+ updateTime + ", updateOperatorId=" + updateOperatorId + ", codeForPA=" + codeForPA + "]";
	}
	
}
