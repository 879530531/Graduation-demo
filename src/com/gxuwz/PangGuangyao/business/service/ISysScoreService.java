package com.gxuwz.PangGuangyao.business.service;


import java.util.List;

import com.gxuwz.PangGuangyao.business.entity.SysScore;
import com.gxuwz.PangGuangyao.business.entity.SysUser;
import com.gxuwz.core.pagination.Result;

/**
 * <p>Title: 类名：用户-业务逻辑--接口</p>
 * <p>Description:mailsender-业务逻辑/n</p>
 * @author:	梧州学院 软件开发中心 庞光垚
 * @date:2015.07.31
 */
public interface ISysScoreService {
	
	/**
	 * 根据用户编号查询用户对象
	 * @param userid 用户编号
	 * @return 用户对象
	 */
	public SysScore findById(String id);
	
	/**
	 * 修改用户昵称
	 * @param userId 用户编号
	 * @param userName 用户昵称
	 * @return 1-成功；0-出错
	 */
	public int updateScore(String id,String score);
	
	/**
	 * 修改用户密码
	 * @param userId 用户编号
	 * @param userPassword  用户密码
	 * @return 1-成功；0-出错
	 */
	public int updateSex(String id,int sex);
	
	/**
	 * 添加用户--所有的保存都要调用该方法，因为有加密
	 * @param sysUser
	 * @author 庞光垚
	 * @date 2015.8.8
	 */
	public void add(SysScore sysScore);
	
	/**
	 * 删除用户
	 * @param sysUser 模型
	 * @author 潘恒飞，卢善坚
	 * @Date 2015.08.09
	 */
	public void delete(String id);
	
	/**
	 * 根据条件查找分页
	 * @param sysUser 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 * @author 卢善坚，潘恒飞
	 * @date 2015.8.8
	 */
	public Result<SysScore> find(SysScore sysScore,int page, int row);
	
	
	/**
	 * 获取令牌
	 * @param userId 用户编号
	 * @param sign 令牌
	 * @return true 令牌符合,false 令牌错误
	 */
	//public boolean checkSign(String userId,String sign);

	/**
	 * 用户登录
	 * @param sysUser 用户对象
	 * @return true -允许登录；false -不允许登录
	 */
	//public boolean isLogin(SysUser sysUser);
	
	
	/**
	 * 添加用户
	 * @param sysUser
	 * @author 卢善坚,潘恒飞
	 * @date 2015.8.8
	 */
	//public void add(SysScore sysScore,String[] roleId);
	
	/**
	 * 根据Id查询单条记录
	 * @param id
	 * @return
	 * @author 潘恒飞，卢善坚
	 * @Date 2015.08.09
	 */
	//public SysUser findById(int id);
	/**
	 * 修改用户信息
	 * @param sysUser
	 * @author 潘恒飞，卢善坚
	 * @Date 2015.08.09
	 */
	//public void update(SysUser sysUser, String[] roleIds,String oldPassword);
	
	/**
	 * 保存用户个人修改的信息
	 * @param sysUser
	 * @param oldPassword
	 * @author 卢善坚
	 * @date 2015.09.25
	 */
	//public void updateScoreMessage(SysScore sysScore, String oldScore);
	
	/**
	 * 检验用户编号是否存在
	 * @param userId
	 * @return
	 * @author 卢善坚，汪嘉惠
	 * @date 2015.08.14
	 */
	//public boolean checkUserId(String userId);
	/**
	 * 校验用户密码
	 * @param rawPassword 数据库保存的加密的密码
	 * @param password 明文密码（需要匹配的用户输入的那份）
	 * @return
	 * @author 卢善坚，汪嘉惠
	 * @date 2015.08.14
	 */
	//public boolean checkPasswd(String rawPassword, String password);
	/**
	 * 根据用户名称查询用户信息
	 * @param userName 用户名称
	 * @return
	 */
	//public SysUser findByName(String userName);
	/**
	 * 根据用户id查找用户权限id
	 * @param userId
	 * @return
	 * @author 蒙译文
	 * @date 2015.09.15
	 */
	//public List<String> findUserPermissions(String userId);
}