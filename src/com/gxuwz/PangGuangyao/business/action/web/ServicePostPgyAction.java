package com.gxuwz.PangGuangyao.business.action.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gxuwz.PangGuangyao.business.entity.ServicePostPgy;
import com.gxuwz.PangGuangyao.business.entity.SysRole;
import com.gxuwz.PangGuangyao.business.entity.SysUser;
import com.gxuwz.PangGuangyao.business.entity.SysUserRole;
import com.gxuwz.PangGuangyao.business.service.IServicePostPgyService;
import com.gxuwz.PangGuangyao.business.service.ISysRoleService;
import com.gxuwz.PangGuangyao.business.service.ISysUserRoleService;
import com.gxuwz.PangGuangyao.business.service.ISysUserService;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
/**
 * 
 * @author <a href=mailto:amu_1115@126.com> amu </a>
 * @version $ DepartmentAction.java 2015-7-27 下午05:11:18
 */
public class ServicePostPgyAction extends BaseAction implements Preparable, ModelDriven{

	private static final long serialVersionUID = -4104125263890869018L;
	protected static final String ADD_JSP = "/WEB-INF/page/web/ServicePostPgy_add.jsp";
	
	@Autowired
	private IServicePostPgyService servicePostPgyService;
	
	private ServicePostPgy servicePostPgy; //用户角色模型
	private Result<SysUser> pageResult;//分页
	private int actionState;//操作状态。1-操作成功（保存成功）
	
	public void prepare() throws Exception{
		if(null == servicePostPgy){
			servicePostPgy = new ServicePostPgy();
		}
	}
	
	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
	/**
	 * 打开个人修改信息页面
	 * @return
	 */
	public String openAdd(){
		forwardView = ADD_JSP;
		return SUCCESS;
		
	}
	
	/**
	 * 打开个人修改信息页面
	 * @return
	 */
	public String doAdd(){
		//调用业务，保存结果		
		servicePostPgyService.add(getServicePostPgy());
		forwardView = ADD_JSP;
		return SUCCESS;
		
	}

	@Override
	public Object getModel() {
		
		return servicePostPgy;
	}

	public ServicePostPgy getServicePostPgy() {
		return servicePostPgy;
	}

	public void setServicePostPgy(ServicePostPgy servicePostPgy) {
		this.servicePostPgy = servicePostPgy;
	}

	public Result<SysUser> getPageResult() {
		return pageResult;
	}

	public void setPageResult(Result<SysUser> pageResult) {
		this.pageResult = pageResult;
	}

	public int getActionState() {
		return actionState;
	}

	public void setActionState(int actionState) {
		this.actionState = actionState;
	}
	
}
