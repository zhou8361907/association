<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<div class="container-fluid "><!--frame调整整体位置-->
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<h1 class="page-header">
                        	${good.goods_name }的图片管理<small>图片列表</small>
                     </h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<!-- 分类列表--bootstrap高级表格使用 -->
					<div class="panel panel-default">
						<div class="panel-heading col-md-6">
							图片列表
						</div>
						<div class="panel-heading col-md-6" style="text-align: right; height: 41px;">
							<a href="/admin/GoodsServlet?&id=${good.goods_id }">
							<button type="button" id="btnBack" class="btn btn-success" style="margin-top:-7px">返回</button>
							</a>
						</div>
						<br><br>
						<div class="panel-body">
							<!--table-responsive响应式表格，会自动添加滚动条-->
							<div class="table-responsive">							
								<a href="/admin/Good2ImageServlet?flag=add&id=${good.goods_id }"><input class="btn btn-success" type="button" value="添加图片"></a>
								<table class="table table-striped table-bordered table-hover" id="dataTables-example">
									<thead>
										<tr>
											<th>编号</th>
											<th>图片</th>
											<th>图片路径</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${imageList}" var="image">
											<tr class="odd gradeX">
												<td class="center">${image.image_id}</td>
												<td><img src="${image.route}" border="1px" width="60" height="60"></td>
												<td class="center">${image.route}</td>
												<td class="center">${image.sort}</td>
												<td>
													<a title="修改"
													href="/admin/Good2ImageServlet?id=${image.image_id}&flag=edit&goodId=${good.goods_id}" class="t-edit glyphicon glyphicon-pencil">
													</a> 
													<a title="删除"
													href="/admin/Good2ImageServlet?id=${image.image_id}&flag=del&goodId=${good.goods_id}" class="t-del glyphicon glyphicon-trash">
													</a>
												</td>
											</tr>
										</c:forEach>
										
									</tbody>
								</table>
							</div>

						</div>
					</div>
					<!--表格结束 -->
				</div>
			</div>
		</div>
	</body>

</html>