<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  
	<head>
		<meta charset="UTF-8">
		<title>商品管理</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/index.css" />
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
		<link rel="stylesheet" type="text/css" href="css/frame.css"/>
	</head>
	<body class="container-fluid frame col-lg-11">
		<div class="container-fluid ">
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<h1 class="page-header">
                          	商品管理 <small>商品列表</small>
                     </h1>
				</div>
			</div>
		
			<div class="row" style="width:1400px;">
				<div class="col-md-10 col-md-offset-1">
					<!-- 用户列表--bootstrap高级表格使用 -->
					<div class="panel panel-default">
						<div class="panel-heading">
							商品列表
						</div>
						<div class="panel-body ">
						<form action="/admin/GoodsServlet" class="col-md-12">	
							<input type="hidden" name="query" value="query">
								<div class="form-group col-md-4 col-md-offset-4">
									<label for="txtMobile">商品名称</label>
									<input type="text" class="form-control" id="txtMobile" placeholder="名称" name="query_name" value="${goods_name}">
								</div>
								<div class="form-group col-md-4 col-md-offset-4">
									<label for="txtUserName">系列</label>
									<input type="text" class="form-control" id="txtUserName" placeholder="系列" name="query_series" value="${series_name}">
								</div>
								<div class="form-group col-md-4 col-md-offset-4">
									<label for="txtUserName">品牌</label>
									<input type="text" class="form-control" id="txtUserName" placeholder="品牌" name="query_brands" value="${brands_name}">
								</div>
								<div class="col-md-4 col-md-offset-4">
									<button type="submit" class="btn btn-success">保存</button>
									<button type="reset" class="btn btn-info">重置</button>
								</div>
						</form>
							<!--table-responsive响应式表格，会自动添加滚动条-->
							<div class="table-responsive col-md-12">
								<a href="/admin/GoodsServlet?flag=add"><input class="btn btn-success" type="button" value="添加商品"></a>
								<table class="table table-striped table-bordered table-hover" id="dataTables-example">
									<thead>
										<tr>
											<th class="center">编号</th>
											<th class="center">商品图片</th>
											<th class="center">商品色号</th>
											<th class="center">系列</th>
											<th class="center">品牌</th>
											<th class="center">功效</th>
											<th class="center">库存</th>
											<th class="center">操作</th>
											
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${map.list}" var="goods">
											<tr class="odd gradeX">
												<td class="center">${goods.goods_id}</td>
												<td><img src="${goods.image.route}" border="1px" width="60" height="60"></td>
												<td class="center">${goods.color}</td>
												<td class="center">${goods.series.series_name}</td>
												<td class="center">${goods.brand.brand_name}</td>
												<td class="center">${goods.effect}</td>									
											  
												<td class="center">${goods.store_number}</td>
												<td>
													<a title="修改" class="t-edit glyphicon glyphicon-pencil" href="/admin/GoodsServlet?flag=edit&id=${goods.goods_id}&cur=${curPage }"></a>												
													<a title="图片" class="t-edit glyphicon glyphicon-picture" href="/admin/Good2ImageServlet?id=${goods.goods_id}"></a>
													<a title="删除" class="t-del glyphicon glyphicon-trash" href="/admin/GoodsServlet?flag=del&id=${goods.goods_id}&cur=${curPage }"></a>
												</td>
											</tr>
										</c:forEach>									
									</tbody>
								</table>
							</div>

							<!--分页显示-->
							<div class="row">
								<div class="col-md-6">
									<div class="pagination" style="margin: 0px;" role="alert"
										aria-live="polite" aria-relevant="all">显示 ${curPage}页   共${map.pageNum} 页 记录数${map.count}</div>
								</div>
								<div class="col-md-6" style="text-align: right;">
									<ul class="pagination" style="margin: 0px;">
										<c:if test="${curPage>1}">
											<li><a href="/admin/GoodsServlet?curPage=${curPage-1}"
												aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											</a></li>
										</c:if>
										
										
										<c:choose>
										<c:when test="${map.pageNum <= 5 }">
											<c:set var="begin" value="1" />
											<c:set var="end" value="${map.pageNum }" />
										</c:when>
										<c:otherwise>
										
											<c:set var="begin" value="${curPage-2}" />
											<c:set var="end" value="${curPage+2}" />	
											<c:if test="${begin < 1 }">
												<c:set var="begin" value="1" />
												<c:set var="end" value="5" />
											</c:if>	
											<c:if test="${end > map.pageNum }">
												<c:set var="begin" value="${map.pageNum - 4 }" />
												<c:set var="end" value="${map.pageNum }" />
											</c:if>	
										</c:otherwise>
									</c:choose>
									
										
									<c:forEach var="i" begin="${begin }" end="${end }">
										<c:choose>
											<c:when test="${i eq curPage }">
											<li><a href="#">${i }</a></li>
											</c:when>
											<c:otherwise>
												<li><a href="/admin/GoodsServlet?curPage=${i}">${i}</a></li>
											<c:set var="page" scope="request" value="${i}" />
											</c:otherwise>
										</c:choose>
									</c:forEach>
										
								
										
										
										
										<c:if test="${curPage<map.pageNum}">
											<li><a href="/admin/GoodsServlet?curPage=${curPage+1}"
												aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											</a></li>
										</c:if>
									
									</ul>
								</div>
							</div>
							<!--分页显示-->
						</div>
					</div>
					<!--表格结束 -->
				</div>
			</div>
		</div>
	</body>

</html>