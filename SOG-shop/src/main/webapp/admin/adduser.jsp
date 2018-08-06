<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zh-CN">

	<head>
		<meta charset="UTF-8">
		<title>用户管理</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="style/index.css" />

		<body style="background-color: #F5F5DC;">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<h1 class="page-header">
                          	用户管理
                          	<c:if test="${user==null}">
						<small>添加角色</small>
					</c:if>
					<c:if test="${not empty user}">
						<small>编辑角色</small>
					</c:if>
                          	 
                     </h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<!-- 用户列表--bootstrap高级表格使用 -->
						<div class="panel panel-success">							
							<c:if test="${user==null}">
								<div class="panel-heading col-md-6" >添加角色</div>
							</c:if>
							<c:if test="${not empty user}">
								<div class="panel-heading col-md-6" >编辑角色</div>
							</c:if>						
							<div class="panel-heading col-md-6" style="text-align: right; height: 41px;">
								<a href="/admin/UserServlet">
								<button type="button" id="btnBack" class="btn btn-success" style="margin-top:-7px">返回</button>
								</a>
							</div>
							<br><br>
							<div class="panel-body">
								<form action="/admin/UserServlet" method="post">
								<input type="hidden" name="user_id" value="${user.user_id}">
								<input type="hidden" name="states" value="${user.states}">
								<input type="hidden" name="cur" value="${curs}">
									<div class="form-group">
										<label for="txtAccount">账户</label>
										<input type="text" class="form-control" id="txtAccount" placeholder="账号" name="account" value="${user.account}" >
									</div>
									<div class="form-group">
										<label for="txtUserName">姓名</label>
										<input type="text" class="form-control" id="txtUserName" placeholder="姓名" name="name" value="${user.user_name}">
									</div>
									<div class="form-group">
										<label for="txtMobile">联系方式</label>
										<input type="text" class="form-control" id="txtMobile" placeholder="手机号" name="phone" value="${user.user_phone}">
									</div>
									<div class="form-group">
										<label for="txtUserName">余额</label>
										<input type="text" class="form-control" id="txtUserName" placeholder="余额" name="money" value="${user.user_money}">
									</div>
									
									
									<div class="form-group">
										<label for="txtPassword">密码</label>
										<input type="password" class="form-control" id="txtPassword" placeholder="密码" name="password" value="${user.password}">
									</div>
									
									<div class="form-group">
										<label for="txtUserName">积分</label>
										<input type="text" class="form-control" id="txtUserName" placeholder="积分" name="score" value="${user.user_score }" >
									</div>
									
									<div class="form-group">
										<label for="txtUserName">状态</label>
										<input type="text" class="form-control" id="txtUserName" placeholder="状态" name="states" value="${user.states }" >
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
			</div>
		</body>

</html>