<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>角色-新增</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/common.js"></script>
<script type="text/javascript" src="<%= basePath%>third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="<%= basePath%>third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">系统管理</a></li>
    <li><a href="#">新增岗位</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>角色基本信息</span></div>
    <form action="<%= basePath%>/biz/ServicePostPgy_doAdd.action" method="post" id="commonform">
    <ul class="forminfo">
    <li>
      <label>岗位编号</label><input name="postId" id="postId" type="text"  class="dfinput"/><i>英文</i><span id="gradeInfo"></span></li>
    <li>
      <label>岗位名称</label><input name="postName" id="postName" type="text" class="dfinput" /><i>不能超过20个汉字</i></li>
    <li><label>流程编号</label>
      <input name="flowId" id="flowId" type="text" class="dfinput" /><i></i></li>
    <li><label>&nbsp;</label><input name="add_btn" type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    
    </div>


</body>

</html>
