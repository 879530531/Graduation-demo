package com.gxuwz.PangGuangyao.business.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.gxuwz.PangGuangyao.business.entity.ServicePostPgy;
import com.gxuwz.core.dao.impl.BaseDaoImpl;

/**
 * A data access object (DAO) providing persistence and search support for
 * ServicePostPgy entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.gxuwz.PangGuangyao.business.dao.ServicePostPgy
 * @author MyEclipse Persistence Tools
 */

@Repository("servicePostPgyDAO")
public class ServicePostPgyDAO extends BaseDaoImpl<ServicePostPgy> {
	private static final Logger log = LoggerFactory
			.getLogger(ServicePostPgyDAO.class);
	// property constants
	public static final String POST_ID = "postId";
	public static final String POST_NAME = "postName";
	public static final String FLOW_ID = "flowId";

	protected void initDao() {
		// do nothing
	}
}