package com.gxuwz.PangGuangyao.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.PangGuangyao.business.dao.SysRoleRightDAO;
import com.gxuwz.PangGuangyao.business.entity.SysRoleRight;

@Service("sysRoleRightService")
public class SysRoleRightServiceImpl implements ISysRoleRightService {

	@Autowired
	private SysRoleRightDAO sysRoleRightDAO;
	
	@Override
	public void addRoleRight(SysRoleRight sysRoleRight) {
		sysRoleRightDAO.save(sysRoleRight);
		
	}

	
	/**
	 * 根据权限编号进行删除
	 * @param roleId 角色编号
	 */
	public void delete(String roleId) {
		sysRoleRightDAO.deleteByRoleId(roleId);
		
	}

	/**
	 * 根据角色编号查询出角色权限
	 * @param roleId 角色编号
	 */
	@Override
	public List<SysRoleRight> findByRole(String roleId) {
		
		return sysRoleRightDAO.findByRoleId(roleId);
	}
	
	

}
