package com.gxuwz.PangGuangyao.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.PangGuangyao.business.dao.ServicePostPgyDAO;
import com.gxuwz.PangGuangyao.business.dao.SysUserRoleDAO;
import com.gxuwz.PangGuangyao.business.entity.ServicePostPgy;

@Service("servicePostPgyService")
public class ServicePostPgyServiceImpl implements IServicePostPgyService {

	@Autowired
	private ServicePostPgyDAO servicePostPgyDAO;
	
	/**
	 * 保存单个对象
	 * @param servicePostPgy 岗位对象
	 */
	public void add(ServicePostPgy servicePostPgy){
		servicePostPgyDAO.save(servicePostPgy);
	}
}
