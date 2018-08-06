<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="UTF-8">
		<title>图片管理</title>
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
					图片管理
					<c:if test="${image==null}">
						<small>添加图片</small>
					</c:if>
					<c:if test="${not empty image}">
						<small>编辑图片</small>
					</c:if>
				</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<!-- 用户列表--bootstrap高级表格使用 -->
				<div class="panel panel-success">
					<c:if test="${admin==null}">
						<div class="panel-heading col-md-6" >添加图片</div>
					</c:if>
					<c:if test="${not empty admin}">
						<div class="panel-heading col-md-6" >编辑图片</div>
					</c:if>
					<div class="panel-heading col-md-6" style="text-align: right; height: 41px;">
						<a href="/admin/ImageGoodServlet">
						<button type="button" id="btnBack" class="btn btn-success" style="margin-top:-7px">返回</button>
						</a>
					</div>
					<br><br>
					<div class="panel-body">
						<form action="/admin/ImageGoodServlet?flag=add" method="post" enctype="multipart/form-data">
							<input type="hidden" name="id" value="${image.image_id}">							
							<input type="hidden" name="good_id" value="">
							<input type="hidden" name="cur" value="${cur}">
							<div class="form-group">
								
								<label for="good_name">商品名称</label> <select id="good_name"
									name="good_name" class="form-control">
									<c:forEach items="${goodList}" var="good">
										<option value="${good.goods_id}">${good.goods_name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="route">图片路径</label> 
								<input type="file"
									name="route" value="" class="form-control"
									id="route">
							</div>
							
							<div class="form-group">
								<label for="txtSort">排序</label> 
								<input type="text"
									name="sort" value="${image.sort}" class="form-control"
									id="txtSort" placeholder="商品排序">
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