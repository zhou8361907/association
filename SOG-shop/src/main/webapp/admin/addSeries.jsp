<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="UTF-8">
		<title>系列管理</title>
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
					系列管理
					<c:if test="${series==null}">
						<small>系列图片</small>
					</c:if>
					<c:if test="${not empty series}">
						<small>系列图片</small>
					</c:if>
				</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<!-- 用户列表--bootstrap高级表格使用 -->
				<div class="panel panel-default">
					<c:if test="${series==null}">
						<div class="panel-heading col-md-6">添加系列</div>
					</c:if>
					<c:if test="${not empty series}">
						<div class="panel-heading col-md-6">编辑系列</div>
					</c:if>
					<div class="panel-heading col-md-6" style="text-align: right; height: 41px;">
						<a href="/admin/SeriesServlet">
						<button type="button" id="btnBack" class="btn btn-success" style="margin-top:-7px">返回</button>
						</a>
					</div>
					<br><br>
					<div class="panel-body">
						<form action="/admin/SeriesServlet?flag=add" method="post" >
							<input type="hidden" name="id" value="${series.series_id}">							
							<input type="hidden" name="brand_id" value="">
							<input type="hidden" name="cur" value="${cur }">
							<div class="form-group">
								<label for="txtSeries">系列名称</label> 
								<input type="text"
									name="txtSeries" value="${series.series_name}" class="form-control"
									id="txtSeries" placeholder="系列名称">
							</div>
							
							<div class="form-group">								
								<label for="brand_name">所属品牌</label> <select id="brand_name"
									name="brand_name" class="form-control">
									<c:forEach items="${brandList}" var="brand">
										<option value="${brand.brand_id}">${brand.brand_name}</option>
									</c:forEach>
								</select>
							</div>							
							
							<div class="form-group">
								<label for="txtSort">排序</label> 
								<input type="text"
									name="sort" value="${series.sort_level}" class="form-control"
									id="txtSort" placeholder="系列排序">
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