package com.gxuwz.PangGuangyao.business.dao;

import org.springframework.stereotype.Repository;

import com.gxuwz.PangGuangyao.business.entity.SysRight;
import com.gxuwz.PangGuangyao.business.entity.SysRole;
import com.gxuwz.PangGuangyao.business.entity.SysUser;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;

/**
 * A data access object (DAO) providing persistence and search support for
 * SysUser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.gxuwz.PangGuangyao.business.dao.SysUser
 * @author MyEclipse Persistence Tools
 */

@Repository("sysRoleDAO")
public class SysRoleDAO extends BaseDaoImpl<SysRole>{
	
	/**
	 * 根据条件查找分页
	 * @param SysRole 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<SysRole> find(SysRole model, int page, int size) {
		String queryString="from SysRole where 1=1";
		if(null != model.getRoleName()){
			queryString = queryString + " and role_name like '%"+model.getRoleName()+"%'";
		}
		int start=(page-1)*size;
		int limit =size;
		return (Result<SysRole>)super.find(queryString, null, null, start, limit);
	}
	
	@SuppressWarnings("unchecked")
	public Result<SysRight> findRightAll(SysRight sysRight){
		String queryString = "from SysRight where 1=1";
		return (Result<SysRight>)super.find(queryString, null, null, 0, 0);
	}
}