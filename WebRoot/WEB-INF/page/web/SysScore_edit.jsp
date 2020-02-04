<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户-修改</title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/css/select.css" rel="stylesheet" type="text/css" />

<script type="text/javascript"
	src="<%= basePath%>/third/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript"
	src="<%= basePath%>/third/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript"
	src="<%= basePath%>/third/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript" src="<%=path %>/js/select-ui.min.js"></script>
<script type="text/javascript">
        $(function(){
		
			//如果是新增成功，会返回1，如果是1，则提示保存成功
			if("1" == "${actionState}"){
				alert('保存成功！');
			}
			});
			
			
</script>


<script type="text/javascript">
	$(document).ready(function(e){
		$(".select2").uedSelect({
			width:155
		});
	});
</script>
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">系统管理</a></li>
			<li><a href="#">修改信息</a></li>
		</ul>
	</div>

	<div class="formbody" id="tab1">

		<div class="formtitle">
			<span>基本信息</span>
		</div>
		<form action="<%= basePath%>/biz/SysScore_add.action" method="post"
			id="commonform">
			<ul class="forminfo">
				</li>
			</ul>
			<li><label>id</label><input name="sysScore.id" type="text" readonly="ture" id="id" class="dfinput" value="${sysScore.id}" id="${sysScore.id}"/><i><font color="#FF0000">*id不可更改</font></i><span id="gradeInfo"></span></li>
			
			<li><label><font style="font-weight: bold">sex</font></label>
				<label><input class="radio1" type="radio"
					name="sysScore.sex" value="0"></input> 女</label> <label><input
					class="radio1" type="radio" name="sysScore.sex" value="1"
					checked="checked"></input>男</label></li>
			<li><label>score</label><input name="sysScore.score" type="text"
				class="dfinput" /><i><font color="#FF0000">*必填</font>from 0 to
					100</i></li>
			</ul>
			<ul class="forminfo">
				<li><label>&nbsp;</label><input name="" type="submit"
					class="btn" value="提交" /></li>
			</ul>
		</form>

	</div>

</body>
</html>
