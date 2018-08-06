<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  
	<head>
	
	<%  request.setCharacterEncoding( "utf-8");%>
<% response.setCharacterEncoding("utf-8"); %>
		<meta charset="UTF-8">
		<title>用户管理</title>
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
                          	用户管理 <small>用户列表</small>
                     </h1>
				</div>
			</div>
		
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<!-- 用户列表--bootstrap高级表格使用 -->
					<div class="panel panel-default">
						<div class="panel-heading">
							用户列表
						</div>
						<div class="panel-body">
						
							<form action="/admin/UserServlet" class="col-md-12">	
								<input type="hidden" name="query" value="query">
									<div class="form-group col-md-4 col-md-offset-4">
										<label for="txtMobile">账号</label>
										<input type="text" class="form-control" id="txtMobile" placeholder="账号" name="query_account" value="${user_query.account}">
									</div>
									<div class="form-group col-md-4 col-md-offset-4">
										<label for="txtUserName">姓名</label>
										<input type="text" class="form-control" id="txtUserName" placeholder="姓名" name="query_name" value="${user_query.user_name}">
									</div >
									<div class="col-md-4 col-md-offset-4">
										<button type="submit" class="btn btn-success">保存</button>
										<button type="reset" class="btn btn-info">重置</button>									
									</div>
							</form>
					
							<!--table-responsive响应式表格，会自动添加滚动条-->
							<div class="table-responsive col-md-12">
								<a href="/admin/adduser.jsp"><input class="btn btn-success" type="button" value="添加用户"></a>
								<table class="table table-striped table-bordered table-hover" id="dataTables-example">
									<thead>
										<tr>
											<th class="center">编号</th>
											<th class="center">账号</th>
											<th class="center">姓名</th>
											<th class="center">联系方式</th>
											<th class="center">余额</th>
											<th class="center">积分</th>
											<th class="center">最后登录日期</th>
											<th class="center">创建日期</th>
											<th class="center">状态</th>											
											<th class="center">操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${map.list}" var="user">
									<tr class="odd gradeX">
										<td class="center">${user.user_id}</td>
										<td class="center">${user.account}</td>
										<td class="center">${user.user_name}</td>
										<td class="center">${user.user_phone}</td>
									    <td class="center">${user.user_money}</td>
										<td class="center">${user.user_score}</td>
										<td class="center">${user.last_login_time}</td>
										<td class="center">${user.create_time}</td>
										
										<c:if test="${user.states==1}">
										<td class="center">启用</td>
										</c:if>
										<c:if test="${user.states!=1}">
										<td class="center">禁用</td>
										</c:if>
									
										
										<td>
												<a title="修改" class="t-edit glyphicon glyphicon-pencil" href="/admin/UserServlet?flag=edit&user_id=${user.user_id}&cur=${curPage }"></a>
												<a title="删除" class="t-del glyphicon glyphicon-trash" href="/admin/UserServlet?flag=del&user_id=${user.user_id}&cur=${curPage }"></a>
										</td>
									</tr>
								</c:forEach>
										
										
									</tbody>
								</table>
							</div>

							<!--分页显示-->
							<div class="row">
								<div class="col-md-6">
									<div class="pagination" style="margin: 0px;" role="alert" aria-live="polite" aria-relevant="all">显示 ${curPage}页   共${map.pageNum}页 记录数${map.count}</div>
								</div>
								<div class="col-md-6" style="text-align: right;">
									<ul class="pagination" style="margin: 0px;">
									<c:if test="${curPage>1}">
										<li>
											<a href="/admin/UserServlet?cur=${curPage }&act=111&num=${map.pageNum}" aria-label="Previous">
												<span aria-hidden="true">&laquo;</span>
											</a>
										</li>
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
												<li><a href="/admin/UserServlet?curPage=${i }">${i }</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
	
									<c:if test="${curPage<map.pageNum}">
										<li>
											<a href="/admin/UserServlet?cur=${curPage }&act=222&num=${map.pageNum}" aria-label="Next">
												<span aria-hidden="true">&raquo;</span>
											</a>
										</li>
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