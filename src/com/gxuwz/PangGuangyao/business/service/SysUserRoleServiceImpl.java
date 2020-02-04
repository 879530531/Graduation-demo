package com.gxuwz.PangGuangyao.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuwz.PangGuangyao.business.dao.SysUserRoleDAO;
import com.gxuwz.PangGuangyao.business.entity.SysUserRole;

@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements ISysUserRoleService {
	@Autowired
	private SysUserRoleDAO sysUserRoleDAO;
	/**
	 * 添加用户角色
	 * @param sysUserRole
	 */
	@Override
	public void addUserRole(SysUserRole sysUserRole) {
		sysUserRoleDAO.save(sysUserRole);
	}
	/**
	 * 根据id删除用户角色
	 * @param sysUserRole
	 */
	@Override
	public void deleteUserRole(String id) {
		sysUserRoleDAO.deleteByUserId(id);
	}
	/**
	 * 根据用户编号查询出所有权限
	 * @param userId
	 * @return
	 */
	@Override
	public List<SysUserRole> findByUserId(String userId) {
		return sysUserRoleDAO.findByUserId(userId);
	}

}
