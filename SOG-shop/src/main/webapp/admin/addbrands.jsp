<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zh-CN">

	<head>
		<meta charset="UTF-8">
		<title>品牌管理</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="style/index.css" />

		<body style="background-color: #F5F5DC;">
		
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<h1 class="page-header">
                          	品牌管理
                          	<c:if test="${brands==null}">
						<small>添加品牌</small>
					</c:if>
					<c:if test="${not empty brands}">
						<small>编辑品牌</small>
					</c:if>
                          	 
                     </h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<!-- 用户列表--bootstrap高级表格使用 -->
						<div class="panel panel-success">							
							<c:if test="${brands==null}">
								<div class="panel-heading col-md-6" >添加品牌</div>
							</c:if>
							<c:if test="${not empty brands }">
								<div class="panel-heading col-md-6" >编辑品牌</div>
							</c:if>							
							<div class="panel-heading col-md-6" style="text-align: right; height: 41px;">
								<a href="/admin/BrandsServlet">
								<button type="button" id="btnBack" class="btn btn-success" style="margin-top:-7px">返回</button>
								</a>
							</div>
							<br><br>
							<div class="panel-body">
								<form action="/admin/BrandsServlet" method="post">
					             <input type="hidden"  name="brands_id" value="${brands.brand_id}">
								<input type="hidden" name="cur" value="${cur}">
									<c:if test="${not empty brands}">
									<div class="form-group">
										<label for="txtUserName">品牌编号</label>
										<input type="text" required="required" class="form-control" id="txtUserName" placeholder="品牌编号" name="brandsId" value="${brands.brand_id}">
									</div>
									</c:if>
									<div class="form-group">
										<label for="txtMobile">品牌名称</label>
										<input type="text" required="required" class="form-control" id="txtMobile" placeholder="名称" name="brandsName" value="${brands.brand_name}" >
									</div>
									<div class="form-group">
										<label for="txtUserName">品牌产地</label>
										<input type="text" required="required" class="form-control" id="txtUserName" placeholder="产地" name="brandsCountry" value="${brands.brand_country}" >
									</div>
									
									<div class="form-group">
										<label for="txtPassword">品牌等级</label>
										<input type="text" required="required" class="form-control" id="txtPassword" placeholder="等级" name="brandsLevel" value="${brands.brand_level}" >
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