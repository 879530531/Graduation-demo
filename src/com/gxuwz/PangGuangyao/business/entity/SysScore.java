package com.gxuwz.PangGuangyao.business.entity;

import com.gxuwz.PangGuangyao.business.dao.SysScoreDAO;
import com.gxuwz.PangGuangyao.business.dao.SysUserDAO;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public class SysScore implements java.io.Serializable {

	// Fields
    
	private Integer id;
	private Integer sex;
	private String score;
	private String merchantId;

	// Constructors

	/** default constructor */
	public SysScore() {
	}

	public SysScore(Integer id, Integer sex, String score,String merchantId) {
		super();
		this.id = id;
		this.sex = sex;
		this.score = score;
		this.merchantId=merchantId;
	}

	// Property accessors
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getMerchantId() {
		return this.merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
}


	