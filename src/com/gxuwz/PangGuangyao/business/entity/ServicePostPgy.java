package com.gxuwz.PangGuangyao.business.entity;

/**
 * ServicePostPgy entity. @author MyEclipse Persistence Tools
 */

public class ServicePostPgy implements java.io.Serializable {

	// Fields

	private Integer id;
	private String postId;
	private String postName;
	private String flowId;

	// Constructors

	/** default constructor */
	public ServicePostPgy() {
	}

	/** full constructor */
	public ServicePostPgy(String postId, String postName, String flowId) {
		this.postId = postId;
		this.postName = postName;
		this.flowId = flowId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPostId() {
		return this.postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return this.postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getFlowId() {
		return this.flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

}