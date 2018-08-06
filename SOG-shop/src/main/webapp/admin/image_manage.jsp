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
                        	图片管理<small>图片列表</small>
                     </h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<!-- 分类列表--bootstrap高级表格使用 -->
					<div class="panel panel-default">
						<div class="panel-heading">
							图片列表
						</div>
						<div class="panel-body">
							<!--table-responsive响应式表格，会自动添加滚动条-->
							<div class="table-responsive">							
								<a href="/admin/ImageGoodServlet?flag=add"><input class="btn btn-success" type="button" value="添加图片"></a>
								<table class="table table-striped table-bordered table-hover" id="dataTables-example">
									<thead>
										<tr>
											<th>编号</th>
											<th>图片</th>
											<th>所属商品名称</th>
											<th>图片路径</th>
											<th>排序</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${map.list}" var="image">
											<tr class="odd gradeX">
												<td class="center">${image.image_id}</td>
												<td><img src="${image.route}" border="1px" width="60" height="60"></td>
												<td class="center">${image.good.goods_name}</td>
												<td class="center">${image.route}</td>
												<td class="center">${image.sort}</td>
												<td>
													<a title="修改"
													href="/admin/ImageGoodServlet?id=${image.image_id}&flag=edit&cur=${curPage }" class="t-edit glyphicon glyphicon-pencil">
													</a> 
													<a title="删除"
													href="/admin/ImageGoodServlet?id=${image.image_id}&flag=del&cur=${curPage }" class="t-del glyphicon glyphicon-trash">
													</a>
												</td>
											</tr>
										</c:forEach>
										
									</tbody>
								</table>
							</div>

							<!--	<div class="container">-->
							<!--分页显示-->
							<div class="row">
								<div class="col-md-6">
									<div class="pagination" style="margin: 0px;" role="alert"
										aria-live="polite" aria-relevant="all">显示 ${curPage}页   共${map.pageNum} 页 记录数${map.count}</div>
								</div>
								<div class="col-md-6" style="text-align: right;">
									<ul class="pagination" style="margin: 0px;">
										<c:if test="${curPage>1}">
											<li><a href="/admin/ImageGoodServlet?curPage=${curPage-1}"
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
												<li><a href="/admin/ImageGoodServlet?curPage=${i}">${i}</a></li>
											<c:set var="page" scope="request" value="${i}" />
											</c:otherwise>
										</c:choose>
									</c:forEach>
										
								
										
										
										
										<c:if test="${curPage<map.pageNum}">
											<li><a href="/admin/ImageGoodServlet?curPage=${curPage+1}"
												aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											</a></li>
										</c:if>
									
									</ul>
								</div>
							</div>
							<!--分页显示-->
							<!--</div>-->
						</div>
					</div>
					<!--表格结束 -->
				</div>
			</div>
		</div>
	</body>

</html>