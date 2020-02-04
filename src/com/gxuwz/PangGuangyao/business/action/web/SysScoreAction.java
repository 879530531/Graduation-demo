package com.gxuwz.PangGuangyao.business.action.web;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.PangGuangyao.business.dao.SysScoreDAO;
import com.gxuwz.PangGuangyao.business.entity.SysScore;
import com.gxuwz.PangGuangyao.business.entity.SysUser;
import com.gxuwz.PangGuangyao.business.service.ISysRoleService;
import com.gxuwz.PangGuangyao.business.service.ISysScoreService;
import com.gxuwz.PangGuangyao.business.service.ISysUserService;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
/**
 * 
 * @author <a href=mailto:amu_1115@126.com> amu </a>
 * @version $ DepartmentAction.java 2015-7-27 下午05:11:18
 */
public class SysScoreAction extends BaseAction implements Preparable, ModelDriven{

	private static final long serialVersionUID = -4104125263890869018L;
	protected static final String LIST_JSP = "/WEB-INF/page/web/SysScore_list.jsp";
	protected static final String ADD_JSP = "/WEB-INF/page/web/SysScore_add.jsp";
	protected static final String EDIT_JSP = "/WEB-INF/page/web/SysScore_edit.jsp";
	protected static final String MESSAGE_JSP = "/WEB-INF/page/web/scoreMessage.jsp";
	
	protected final Log logger=LogFactory.getLog(getClass());
	@Autowired
	private ISysScoreService sysScoreService;
	
	private SysScore sysScore;//用户模型
	private Result<SysScore> pageResult;//分页
	private int actionState;//操作状态。1-操作成功（保存成功）
	
	public void prepare() throws Exception{
		if(null == sysScore){
			sysScore = new SysScore();
		}
	}
	
	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	public String list()throws Exception{
		pageResult = sysScoreService.find(sysScore, getPage(), getRow());
		setForwardView(LIST_JSP);
		return SUCCESS;
	}
	/**
	 * 添加用户
	 * @return
	 * @throws Exception
	 * @author 卢善坚，潘恒飞
	 * @date 2015.8.8
	 */
	public String add() throws Exception{
		sysScoreService.add(sysScore);
		return list();
	}
	/**
	 * 保存修改的用户信息
	 * @return
	 * @throws Exception
	 * @author 潘恒飞，卢善坚
	 * @Date 2015.08.09
	 */
	/*public String update() throws Exception{
		sysScoreService.update(sysScore,roleId, oldPassword);
		sysScore.setUserName(null);
		return list();
	}*/
	
	/**
	 * 保存用户个人修改的信息
	 * @param sysUser
	 * @param oldPassword
	 * @author 卢善坚
	 * @date 2015.09.25
	 */
	/*public String updateUserMessage(){
		sysScoreService.updateUserMessage(sysScore, oldPassword);
		actionState = 1;
		return openMessage();
	}*/
	
	/**
	 * 删除用户
	 * @param sysUser 模型
 * @author 潘恒飞，卢善坚
	 * @Date 2015.08.09
	 */
	public String delete() throws Exception{
		String id=String.valueOf(sysScore.getId());
		sysScoreService.delete(id);
		return list();
	}
	
	/**
	 * 页面跳转
	 * @return
	 */
	public String openList(){
		logger.info("##sysRole列表读取...");
		pageResult = sysScoreService.find(sysScore, getPage(),getRow());
		return SUCCESS;
	}
	/**
	 * 打开添加用户页面
	 * @return
	 * @author 潘恒飞，卢善坚
	 * @Date 2015.08.09
	 */
	public String openAdd(){
		//查询出所有角色信息
		//获取所有省（直辖市）
		//comDistricts = comDistrictService.findComDistrictByUpid(0);
		/*SysUserDAO S=new SysUserDAO();
		String number=String.valueOf(S.newNumber());
		ActionContext ac=ActionContext.getContext();
        Map<String, Object> session=ac.getSession();
        session.put("number",number);*/
		forwardView = ADD_JSP;
		return SUCCESS;
	}
	/**
	 * 打开修改信息页面
	 * @return
	 * @author 潘恒飞，卢善坚
	 * @Date 2015.08.09
	 */
	public String openEdit(){
		//先删除
		String id=String.valueOf(sysScore.getId());
		sysScoreService.delete(id);
		//再新增
		//查询角色的所有信息
		//comDistricts = comDistrictService.findComDistrictByUpid(0);
		//根据用户编号查询用户角色
		
		//根据用户id查询用户信息
		String ID=String.valueOf(sysScore.getId());
		sysScore = sysScoreService.findById(ID);
		if(null!=sysScore.getMerchantId()){
			//根据商家（单位）编号查询商家信息
			//sysMerchantUnit = sysMerchantUnitService.findById(sysUser.getMerchantId());
		}
		
		forwardView = EDIT_JSP;
		return SUCCESS;
	}
	/**
	 * 打开个人修改信息页面
	 * @return
	 */
	/*public String openMessage(){
		//根据用户id查询用户信息
		sysUser = sysUserService.findById(sysUser.getId());
		//根据用户编号查询用户角色
		userRoles = sysUserRoleService.findByUserId(sysUser.getUserId());
		forwardView = MESSAGE_JSP;
		return SUCCESS;
		
	}*/

	@Override
	public Object getModel() {
		
		return sysScore;
	}
	
	public SysScore getSysScore() {
		return sysScore;
	}

	public void setSysScore(SysScore sysScore) {
		this.sysScore = sysScore;
	}

	public Result<SysScore> getPageResult() {
		return pageResult;
	}

	public void setPageResult(Result<SysScore> pageResult) {
		this.pageResult = pageResult;
	}

	/*public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}

	public String[] getRoleId() {
		return roleId;
	}

	public void setRoleId(String[] roleId) {
		this.roleId = roleId;
	}

	public List<SysUserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<SysUserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}*/

	public int getActionState() {
		return actionState;
	}

	public void setActionState(int actionState) {
		this.actionState = actionState;
	}
	
}
