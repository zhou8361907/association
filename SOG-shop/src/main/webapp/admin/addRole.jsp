<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="UTF-8">
		<title>角色管理</title>
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
					角色管理
					<c:if test="${role==null}">
						<small>添加角色</small>
					</c:if>
					<c:if test="${not empty role}">
						<small>编辑角色</small>
					</c:if>
				</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<!-- 用户列表--bootstrap高级表格使用 -->
				<div class="panel panel-success">
					<c:if test="${role==null}">
						<div class="panel-heading col-md-6">添加角色</div>
					</c:if>
					<c:if test="${not empty role}">
						<div class="panel-heading col-md-6">编辑角色</div>
					</c:if>
					<div class="panel-heading col-md-6" style="text-align: right; height: 41px;">
						<a href="/admin/RolesServlet">
							<button type="button" id="btnBack" class="btn btn-success" style="margin-top:-7px">返回</button>
						</a>
					</div>
					<br><br>
					<div class="panel-body">
						<form action="/admin/RolesServlet" method="post">
							<input type="hidden" name="id" value="${role.role_id}">
							<input type="hidden" name="cur" value="${cur}">
							<div class="form-group">
								<label for="txtPosition">角色名称</label> 
								<input type="text"
									name="role_position" value="${role.role_position}" class="form-control"
									id="txtAccount" placeholder="角色名称">
							</div>
							<div class="form-group">
								<label for="txtPrivilege">角色权限等级</label> 
								<input type="text"
									name="role_privilege" value="${role.role_privilege}" class="form-control"
									id="txtAccount" placeholder="角色权限等级">
							</div>
							<button type="submit" class="btn btn-success">保存</button>
							<button type="reset" class="btn btn-info">重置</button>
						</form>
					</div>
				</div>
			</div>
			<!--表格结束 -->
		</div>
	</div>
</body>
</html>