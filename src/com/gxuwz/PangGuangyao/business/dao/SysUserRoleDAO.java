package com.gxuwz.PangGuangyao.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gxuwz.PangGuangyao.business.entity.SysUserRole;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;

@Repository("sysUserRoleDAO")
public class SysUserRoleDAO extends BaseDaoImpl<SysUserRole>{

	
	/**
	 * 根据条件查找分页
	 * @param sysMerchantUnit 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 * @author 潘恒飞，蒙译文
	 */
	@SuppressWarnings("unchecked")
	public Result<SysUserRole> find(SysUserRole model, int page, int size) {
		String queryString="from SysUserRole where 1=1";
		int start=(page-1)*size;
		int limit =size;
		return (Result<SysUserRole>)super.find(queryString, null, null, start, limit);
	}
	/**
	 * 删除对象
	 * @param userId 用户编号
	 */
	public void deleteByUserId(String userId){
		String hql="delete from SysUserRole srr where srr.userId='"+userId+"'";
		this.getHibernateTemplate().bulkUpdate(hql);
	}
	/**
	 * 根据用户编号查询用户角色信息
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SysUserRole> findByUserId(String userId){
		String hql = "from SysUserRole where userId = '"+userId+"'";
		return (List<SysUserRole>)this.getHibernateTemplate().find(hql);
	}
}
