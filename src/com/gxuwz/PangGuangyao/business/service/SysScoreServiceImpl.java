package com.gxuwz.PangGuangyao.business.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.MyTime;

import com.gxuwz.PangGuangyao.SystemContext;
import com.gxuwz.PangGuangyao.business.dao.SysScoreDAO;
import com.gxuwz.PangGuangyao.business.dao.SysUserDAO;
import com.gxuwz.PangGuangyao.business.entity.SysRoleRight;
import com.gxuwz.PangGuangyao.business.entity.SysScore;
import com.gxuwz.PangGuangyao.business.entity.SysUser;
import com.gxuwz.PangGuangyao.business.entity.SysUserRole;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.util.UidUtils;

/**
 * <p>Title: 类名：用户-业务逻辑--实现</p>
 * <p>Description:mailsender-业务逻辑/n</p>
 * @author:	梧州学院 软件开发中心 庞光垚
 * @date:2015.07.31
 */

@Service("sysScoreService")
public class SysScoreServiceImpl implements ISysScoreService {

	@Autowired
	private SysScoreDAO sysScoreDAO;
	
	/**
	 * 根据用户编号查询用户对象
	 * @param userid 用户编号
	 * @return 用户对象
	 */
	public SysScore findById(String id){
		return sysScoreDAO.findSysScoreByProperty("id", id);
	}
	
	/**
	 * 添加用户
	 * @param sysUser
	 * @author 卢善坚
	 * @date 2015.8.8
	 */
	@Override
	public void add(SysScore sysScore) {
		sysScoreDAO.save(sysScore);
		
	}
	/**
	 * 删除用户
	 * @param sysUser 模型
 * @author 潘恒飞，卢善坚
	 * @Date 2015.08.09
	 */
	@Override
	public void delete(String id) {
		SysScore sysScore = findById(id);
		sysScoreDAO.remove(sysScore);
	}
	
	
	public int updateSex(String id,int sex){
		int numT = 0;
		SysScore sysScore = sysScoreDAO.findSysScoreByProperty("id", id);//
		if(null != sysScore){
			sysScore.setSex(sex);
			sysScoreDAO.update(sysScore);
			numT = 1;
		}
		return numT;
	}

	public int updateScore(String id, String score) {
		int numT = 0;
		SysScore sysScore = sysScoreDAO.findSysScoreByProperty("id", id);//
		if (null != sysScore) {
			sysScore.setScore(score);
			sysScoreDAO.update(sysScore);
			numT = 1;
		}
		return numT;
	}
	
	
	/**
	 * 获取令牌
	 * @param userId 用户编号
	 * @param sign 令牌
	 * @return true 令牌符合,false 令牌错误
	 */
	/*public boolean checkSign(String userId,String sign){
		boolean isS = false;
		SysUser sysUser = null;
		sysUser = sysScoreDAO.fingByUserid(userId);//手机
		//校验令牌
		if(SystemContext.passwdDecryption(sign,sysUser.getSign())){
			isS = true;
		}
		return isS;
	}*/
	
	/**
	 * 修改用户昵称
	 * @param userId 用户编号
	 * @param userName 用户昵称
	 * @return 1-成功；0-出错
	 */
	/*public int updateUserName(String userId,String userName){
		int numT = 0;
		SysUser sysUser = sysScoreDAO.findSysScoreByProperty("userId", userId);//
		if(null != sysUser){
			sysUser.setUserName(userName);
			sysScoreDAO.update(sysUser);
			numT = 1;
		}
		return numT;
	}*/
	
	/**
	 * 修改用户密码
	 * @param userId 用户编号
	 * @param userPassword  用户密码
	 * @return 1-成功；0-出错
	 */
	/*public int updateUserPassWd(String userId,String userPassword){
		int numT = 0;
		SysUser sysUser = sysScoreDAO.findSysUserByProperty("userId", userId);//
		if(null != sysUser){
			sysUser.setUserPassword(SystemContext.passwdEncryption(userPassword));
			sysScoreDAO.update(sysUser);
			numT = 1;
		}
		return numT;
	}*/
	
	/**
	 * 用户登录
	 * @param sysUser 用户对象
	 * @return true -允许登录；false -不允许登录
	 */
	/*public boolean isLogin(SysUser sysUser){
		//System.out.println("sysUser.getUserPassword()="+sysUser.getUserPassword());
		//System.out.println("sysUser.getUserName()="+sysUser.getUserName());
		boolean isL = false;//初始化临时变量
		SysUser sysUserTem = null;
		try {
			sysUserTem = sysScoreDAO.findSysUserByProperty("userName", sysUser.getUserName());
			if(null == sysUserTem){//用户名为空，再读用户编号
				sysUserTem = sysScoreDAO.findSysUserByProperty("userId", sysUser.getUserName());
			}
			if(null != sysUserTem){
				//System.out.println("sysUserTem.getUserPassword="+sysUserTem.getUserPassword());
				if(SystemContext.passwdDecryption(sysUser.getUserPassword(),sysUserTem.getUserPassword())){
					isL =true;
				}
			}
		} catch (Exception e) {
			
		}
		//isL = true;//测试
		
		return isL;
	}*/
	/**
	 * 根据条件查找分页
	 * @param sysUser 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 * @author 卢善坚，潘恒飞
	 * @date 2015.8.8
	 */
	public Result<SysScore> find(SysScore sysScore, int page, int row) {
		return sysScoreDAO.find(sysScore, page, row);
	}
	
	/**
	 * 添加用户--所有的保存都要调用该方法，因为有加密
	 * @param sysUser
	 * @author 庞光垚
	 * @date 2015.8.8
	 */
	/*public void add(SysScorer sysScore){
		//密码需要加密
		sysScore.setUserPassword(SystemContext.passwdEncryption(sysScore.getUserPassword()));
		sysScoreDAO.save(sysScore);
	}*/
	
	/**
	 * 根据Id查询单条记录
	 * @param id
	 * @return
	 * @author 潘恒飞，卢善坚
	 * @Date 2015.08.09ss
	 */
	/*@Override
	public SysUser findById(int id) {
		return sysScoreDAO.get(SysUser.class,id);
	}*/
	/**
	 * 保存修改用户信息
	 * @param sysUser
	 * @author 潘恒飞，卢善坚
	 * @Date 2015.08.09
	 */
	/*@Override
	public void update(SysUser sysUser, String[] roleIds, String oldPassword) {
		//先根据用户编号删除用户角色
		sysUserRoleService.deleteUserRole(sysUser.getUserId());
		System.out.println("roleIds2===="+roleIds);
		if(null != roleIds){
			//再循环添加用户角色
			for(int i = 0; i < roleIds.length; i++){
				SysUserRole sysUserRole = new SysUserRole();
				sysUserRole.setUserId(sysUser.getUserId());
				sysUserRole.setRoleId(roleIds[i]);
				sysUserRoleService.addUserRole(sysUserRole);
			}
		}
		
		if(sysUser.getUserPassword().equals("")){     //如果用户修改的密码为空，则是用户不修改密码，不用加密直接保存到数据库
			sysUser.setUserPassword(oldPassword);
		}else{
			//否则为已经修改了密码需要加密
			sysUser.setUserPassword(SystemContext.passwdEncryption(sysUser.getUserPassword()));
		}
		//更新用户信息
		sysScoreDAO.update(sysUser);
	}*/
	
	/**
	 * 检验用户编号是否存在
	 * @param userId
	 * @return
	 * @author 卢善坚，汪嘉惠
	 * @date 2015.08.14
	 */
	/*@Override
	public boolean checkUserId(String userId){
		boolean result = false;
		List<SysUser> sysUser = sysScoreDAO.checkUserId(userId);
		if(null != sysUser && sysUser.size()>0){
			result = true;
		}
		return result;
	}*/
	/**
	 * 校验用户密码
	 * @param rawPassword 数据库保存的加密的密码
	 * @param password 明文密码（需要匹配的用户输入的那份）
	 * @return
	 * @author 卢善坚，汪嘉惠
	 * @date 2015.08.14
	 */
	/*@Override
	public boolean checkPasswd(String rawPassword, String password) {
		return SystemContext.passwdDecryption(rawPassword, password);
	}*/
	/**
	 * 根据用户名称查询用户信息
	 * @param userName 用户名称
	 * @return
	 */
	//@Override
	/*public SysUser findByName(String userName) {
		return sysScoreDAO.findSysUserByUserNameOrUserId(userName);
	}*/
	
	/**
	 * 根据用户id查找用户权限id
	 * @param userId
	 * @return
	 * @author 蒙译文
	 * @date 2015.09.15
	 */
	/*@Override
	public List<String> findUserPermissions(String userId) {
		List<String> strList=new ArrayList<String>();
		List<SysRoleRight> list=sysScoreDAO.findUserPermissions(userId);
		for(int i=0;i<list.size();i++){
			strList.add(list.get(i).getRightId());
		}
		return strList;
	}*/
	
	/**
	 * 保存用户个人修改的信息
	 * @param sysUser
	 * @param oldPassword
	 * @author 卢善坚
	 * @date 2015.09.25
	 */
	/*@Override
	public void updateUserMessage(SysScore sysScore, String oldPassword) {
		
		if(sysScore.getUserPassword().equals("")){     //如果用户修改的密码为空，则是用户不修改密码，不用加密直接保存到数据库
			sysScore.setUserPassword(oldPassword);
		}else{
			//否则为已经修改了密码需要加密
			sysScore.setUserPassword(SystemContext.passwdEncryption(sysScore.getUserPassword()));
		}
		//更新用户信息
		sysScoreDAO.update(sysScore);
	}*/
}
