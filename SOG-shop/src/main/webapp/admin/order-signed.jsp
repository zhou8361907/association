<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">

	<head>
		<meta charset="UTF-8">
		<title>已签收订单管理</title>
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
                          	已签收订单设置 <small>已签收状态订单列表</small>
                     </h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<!-- 用户列表--bootstrap高级表格使用 -->
					<div class="panel panel-default">
						<div class="panel-heading">
							订单列表
						</div>
						<div class="panel-body">
							<!--table-responsive响应式表格，会自动添加滚动条-->
							<div class="table-responsive">
								<!-- <a href="/admin/AdminServlet?flag=add"> --><input class="btn btn-success" type="button" value="添加已签收订单信息"><!-- </a> -->
								<table class="table table-striped table-bordered table-hover" id="dataTables-example">
									<thead>
										<tr>
											
											<th class="center">订单编号</th>
											<th class="center">用户编号</th>
											<th class="center">物流单号</th>
											<th class="center">发货状态</th>
											<th class="center">总金额</th>
											<th class="center">订单创建时间</th>											
											<th class="center">订单结束时间</th>
												<th class="center">操作</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${map.list}" var="order">
										<tr class="odd gradeX">
											<td class="center">${order.orderId }</td>
											<td class="center">${order.userId }</td>
											<td class="center">${order.transportId }</td>
											<td class="center">已签收</td>
											<td class="center">${order.sumMoney }</td>
											<td class="center">${order.beginTime }</td>
											<td class="center">${order.finishTime}</td>
											<td>
											<form action="/admin/OrdersServlet?id=${order.orderId}&flag=edit&cur=${curPage}&selectid=2" method="post">
											<select name="change">
                                            <option  value ="0">未付款</option>
                                            <option value ="1">未发货</option>
                                            <option value ="2">已发货</option>
                                            <option value ="3">已送达</option>
                                            <option value ="4">已退货</option>
                                            <option value ="5">已签收</option>
                                            </select>
												<%--  <a title="修改"
												href="/admin/OrdersServlet?id=${admin.id}&flag=edit&cur=${curPage }" class="t-edit glyphicon glyphicon-pencil">
											</a>  --%>
											
											 <input type="submit" value="提交" id="an">
							                </form>
												
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
											<li><a href="/admin/OrdersServlet?selectid=2&curPage=${curPage-1}"
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
												<li><a href="/admin/OrdersServlet?selectid=2&curPage=${i}">${i}</a></li>
												<c:set var="page" scope="request" value="${i}" />
											</c:otherwise>
										</c:choose>
									</c:forEach>
													
										<c:if test="${curPage<map.pageNum}">
											<li><a href="/admin/OrdersServlet?selectid=2&curPage=${curPage+1}"
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