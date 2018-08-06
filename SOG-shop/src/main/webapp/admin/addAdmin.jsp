<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="UTF-8">
		<title>用户管理</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/index.css" />
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
		<link rel="stylesheet" type="text/css" href="css/frame.css"/>
	</head>
<body class="container-fluid frame col-lg-11">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<h1 class="page-header">
					管理员管理
					<c:if test="${admin==null}">
						<small>添加管理员</small>
					</c:if>
					<c:if test="${not empty admin}">
						<small>编辑管理员</small>
					</c:if>
				</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<!-- 用户列表--bootstrap高级表格使用 -->
				<div class="panel panel-success">
					<c:if test="${admin==null}">
						<div class="panel-heading col-md-6" >添加管理员</div>
					</c:if>
					<c:if test="${not empty admin}">
						<div class="panel-heading col-md-6" >编辑管理员</div>
					</c:if>
					<div class="panel-heading col-md-6" style="text-align: right; height: 41px;">
						<a href="/admin/AdminServlet">
						<button type="button" id="btnBack" class="btn btn-success" style="margin-top:-7px">返回</button>
						</a>
					</div>
					<br><br>
					<div class="panel-body">
						<form action="/admin/AdminServlet?flag=add" method="post">
							<input type="hidden" name="id" value="${admin.id}">
							<input type="hidden" name="cur" value="${cur}">
							<div class="form-group">
								<label for="txtAccount">账户</label> <input type="text"
									name="txtAccount" value="${admin.acount}" class="form-control" id="txtAccount"
									placeholder="账号">
							</div>
							<div class="form-group">
								<label for="txtUserName">姓名</label> <input type="text"
									name="txtUserName" value="${admin.name}" class="form-control" id="txtUserName"
									placeholder="姓名">
							</div>
							<c:if test="${admin==null}">
								<div class="form-group">
									<label for="txtGender">性别</label>
									<label class="radio-inline">
										<input type="radio" name="txtGender"
										id="txtGender" value="1" checked="">男
									</label>
									<label class="radio-inline">
										<input type="radio" name="txtGender"
										id="txtGender" value="0" >女
									</label>
								</div>
							</c:if>
							
							<div class="form-group">
								<label for="txtMobile">手机号</label> <input type="text"
									name="txtMobile" value="${admin.phone}" class="form-control" id="txtMobile"
									placeholder="手机号">
							</div>				
							
							<c:if test="${admin==null}">
								<div class="form-group">
								<label for="txtPassword">密码</label> <input type="password"
									name="txtPassword"  class="form-control" id="txtPassword"
									placeholder="密码">
								</div>
								<div class="form-group">
									<label for="txtRePassword">确认密码</label> <input type="password"
										name="txtRePassword" class="form-control" id="txtRePassword"
										placeholder="确认密码">
								</div>
							</c:if>	
								
							<c:if test="${not empty admin}">
								<div class="form-group">
								<label for="txtPassword">密码</label> <input type="text"
									name="txtPassword" value="${admin.password}" class="form-control" id="txtPassword"
									placeholder="密码">
								</div>		
								<input type="hidden" name="txtGender" value="${admin.gender}">						
							</c:if>	
							
							<div class="form-group">
								<label for="roleType">角色</label> <select id="roleType"
									name="roleType" class="form-control">
									<c:forEach items="${roleList}" var="role">
										<option value="${role.role_id}">${role.role_position}</option>
									</c:forEach>
								</select>
							</div>
							
							<button type="submit" id="save" class="btn btn-success">保存</button>
							<button type="reset" class="btn btn-info">重置</button>
						</form>
					</div>
				</div>
			</div>
			<!--表格结束 -->
		</div>
	</div>
</body>
<script type="text/javascript" src="js/admin.js"></script>
<script type="text/javascript">
	//返回
	document.querySelector("#btnBack").onclick = function() {
		window.location.href = "/admin/AdminServlet";
	};
	var form = document.querySelector("form");
	//添加事件
	document.querySelector("#save").onclick = function() {
		var account = document.querySelector("#txtAccount").value;
		var password = document.querySelector("#txtPassword").value;
		var rePassword = document.querySelector("#txtRePassword").value;
		//数据校验
		if (account == "") {
			showinfo(form, "账号不能为空！");
			return;
		} else if (password == "") {
			showinfo(form, "密码不能为空！");
			return;
		}
		
		//
		if (password != rePassword) {
			showinfo(form, "确认密码不正确！");
			return;
		}
		//表单提交
		form.submit();
	}
	//账号验证,失去焦点事件
	document.querySelector("#txtAccount").onblur = function() {
		var account = document.querySelector("#txtAccount").value;
		//数据校验
		if (account == "") {
			showinfo(form, "账号不能为空！");
			return;
		}
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		}
		xmlhttp.open("POST", "/admin/AdminServlet", true);
		xmlhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xmlhttp.send("flag=exist&txtAccount=" + account);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				if (xmlhttp.responseText == 1) {
					showinfo(form, "账号已存在！");
				} else {
					showinfo(form, "");
				}
			}
		}
	}
	//获取焦点事件
	document.querySelector("#txtAccount").onfocus = function() {
		showinfo(form, "");
	}
</script>
</html>