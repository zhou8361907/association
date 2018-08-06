<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zh-CN">

	<head>
		<meta charset="UTF-8">
		<title>级别管理</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="style/index.css" />

		<body style="background-color: #F5F5DC;">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<h1 class="page-header">
                          	级别管理
                          	<c:if test="${level==null}">
						<small>添加级别</small>
					</c:if>
					<c:if test="${not empty level}">
						<small>编辑级别</small>
					</c:if>
                          	 
                     </h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<!-- 用户列表--bootstrap高级表格使用 -->
						<div class="panel panel-success">							
							<c:if test="${user==null}">
								<div class="panel-heading col-md-6" >添加级别</div>
							</c:if>
							<c:if test="${not empty user}">
								<div class="panel-heading col-md-6" >编辑级别</div>
							</c:if>						
							<div class="panel-heading col-md-6" style="text-align: right; height: 41px;">
								<a href="/admin/LevelServlet">
								<button type="button" id="btnBack" class="btn btn-success" style="margin-top:-7px">返回</button>
								</a>
							</div>
							<br><br>
							<div class="panel-body">
								<form action="/admin/LevelServlet" method="post">
								<input type="hidden" name="id" value="${level.level_id}">
								<input type="hidden" name="cur" value="${cur}">
									<div class="form-group">
										<label for="txtAccount">级别名称</label>
										<input type="text" class="form-control" id="txtAccount" placeholder="名称" name="name" value="${level.level_name}" >
									</div>
									<div class="form-group">
										<label for="txtUserName">级别积分</label>
										<input type="text" class="form-control" id="txtUserName" placeholder="积分" name="score" value="${level.level_score}">
									</div>
									<div class="form-group">
										<label for="txtMobile">级别折扣</label>
										<input type="text" class="form-control" id="txtMobile" placeholder="折扣" name="discount" value="${level.level_discount}">
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