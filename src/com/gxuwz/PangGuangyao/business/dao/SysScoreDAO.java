package com.gxuwz.PangGuangyao.business.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gxuwz.PangGuangyao.business.entity.SysRoleRight;
import com.gxuwz.PangGuangyao.business.entity.SysScore;
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
 * @see com.gxuwz.PangGuangyao.business.dao.SysScore
 * @author MyEclipse Persistence Tools
 */

@Repository("sysScoreDAO")
public class SysScoreDAO extends BaseDaoImpl<SysScore>{
	
	public int newId(){
		int number=1;
		String num="";
		String Id="id";
		while(isHadValue(Id,num))
		{
	    number=number+1;
	    num=String.valueOf(number);
	    System.out.println("number:"+num);
		}
		System.out.println("number:"+num);
		return number;
	}
	
	
	/**
	 * 根据条件查找分页
	 * @param sysUser 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 * @author 卢善坚，潘恒飞
	 * @date 2015.8.8
	 */
	@SuppressWarnings("unchecked")
	public Result<SysScore> find(SysScore sysScore, int page, int size){
		String queryString = "from SysScore where 1=1";
		if(null != sysScore.getId()){
			queryString = queryString + " and id like '%"+sysScore.getId()+"%'";
		}
		int start=(page-1)*size;
		int limit =size;
		return (Result<SysScore> )super.find(queryString, null, null, start, limit);
	}
	
	/**
	 * 验证用户名是否重复
	 * @param userId
	 * @return
	 */
	/*@SuppressWarnings("unchecked")
	public List<SysScore> checkUserId(String Id){
		String hql = "from SysUser where Id = '"+Id+"'";
		return this.getHibernateTemplate().find(hql);
	}*/
	
	/**
	 * 判断服务器是否存在该值（用户名是否重复，手机号码是否重复等）
	 * @param property SysUser对象的属性
	 * @param value 值
	 * @return true -重复了，false-不重复
	 */
	public boolean isHadValue(String property,String value){
		boolean isT = false;
		String hql = "from SysScore where "+property+" = '"+value+"'";
		List<SysScore> list = this.getHibernateTemplate().find(hql);
		if(null != list && 0<list.size()){
			isT = true;
		}
		return isT;
	}

	/**
	 * 根据property属性的值value获取对象
	 * @param property SysUser对象的属性
	 * @param value 值
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public SysScore findSysScoreByProperty(String property,String value){
		SysScore sysScore = null;
		String hql = "from SysScore where "+property+" = '"+value+"'";
		List<SysScore> list = this.getHibernateTemplate().find(hql);
		if(null != list && 0<list.size()){
			sysScore = list.get(0);
		}
		return sysScore;
	}

	/*@SuppressWarnings("unchecked")
	public SysUser findSysUserByUserNameOrUserId(String userName){
		SysUser sysUser = null;
		sysUser = this.findSysScoreByProperty("userName", userName);
		if(null == sysUser){
			sysUser = this.findSysScoreByProperty("userId", userName);
		}
		return sysUser;
	}*/

	/**
	 * 根据property属性的值value获取对象
	 * @param property SysUser对象的属性
	 * @param value 值
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public SysScore fingById(String Id){
		SysScore sysScore = null;
		String hql = "from SysScore where id = '"+Id+"'";
		List<SysScore> list = this.getHibernateTemplate().find(hql);
		if(null != list && 0<list.size()){
			sysScore = list.get(0);
		}
		return sysScore;
	}
	/**
	 * 根据用户id查询用户的权限id
	 * @param userId
	 * @return
	 */
	/*@SuppressWarnings("unchecked")
	public List<SysRoleRight> findUserPermissions(String userId) {
		String queryString="select new com.gxuwz.PangGuangyao.business.entity.SysRoleRight(srr.rightId) " +
				   "from SysUser su,SysUserRole sur,SysRole sr,SysRoleRight srr "+
		           "where su.userId=sur.userId and sur.roleId=sr.roleId and sr.roleId=srr.roleId and su.userId='"+userId+"'";
		return getHibernateTemplate().find(queryString);
	}*/
}