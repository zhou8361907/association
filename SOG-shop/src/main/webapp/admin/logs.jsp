<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  
	<head>
		<meta charset="UTF-8">
		<title>日志管理</title>
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
                          	日志管理 <small>日志列表</small>
                     </h1>
				</div>
			</div>
		
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<!-- 用户列表--bootstrap高级表格使用 -->
					<div class="panel panel-default">
						<div class="panel-heading">
							日志列表
						</div>
						<div class="panel-body">
							<!--table-responsive响应式表格，会自动添加滚动条-->
							<div class="table-responsive">
								<a href="/admin/addlogs.jsp"><input class="btn btn-success" type="button" value="添加日志"></a>
								<table class="table table-striped table-bordered table-hover" id="dataTables-example">
									<thead>
										<tr>
											<th class="center">日志编号</th>
											<th class="center">操作内容</th>
											<th class="center">操作时间</th>
											<th class="center">安全等级</th>
											<th class="center">是否成功</th>
											<th class="center">操作类型</th>
											<th class="center">操作</th>
									
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${map.list}" var="logs">
									<tr class="odd gradeX">
										<td class="center">${logs.logs_id}</td>
										<td class="center">${logs.operate_content}</td>
										<td class="center">${logs.operate_time}</td>
										 <td class="center"> ${logs.security_class}</td>
										<td class="center">${logs.if_success}</td>
										<td class="center">${logs.operate_type}</td>
										<td>
												<a title="修改" class="t-edit glyphicon glyphicon-pencil" href="/admin/LogsServlet?flag=edit&logs_id=${logs.logs_id}"></a>
												<a title="删除" class="t-del glyphicon glyphicon-trash" href="/admin/LogsServlet?flag=del&logs_id=${logs.logs_id}&cur=${curPage }"></a>
										</td>
									</tr>
								</c:forEach>
										
										
									</tbody>
								</table>
							</div>

							<!--分页显示-->
							<div class="row">
						<c:if test="${map.pageNum=='0' }">
								<div class="col-md-6">
									<div class="pagination" style="margin: 0px;" role="alert" aria-live="polite" aria-relevant="all">显示 1 到 ${map.pageNum+1}页 记录数${map.count}</div>
								</div>
						</c:if>
						<c:if test="${map.pageNum!='0' }">
								<div class="col-md-6">
									<div class="pagination" style="margin: 0px;" role="alert" aria-live="polite" aria-relevant="all">显示 1 到 ${map.pageNum}页 记录数${map.count}</div>
								</div>
						</c:if>
								<div class="col-md-6" style="text-align: right;">
									<ul class="pagination" style="margin: 0px;">
										<li>
											<a href="/admin/LogsServlet?cur=${curPage }&act=111&num=${map.pageNum}" aria-label="Previous">
												<span aria-hidden="true">&laquo;</span>
											</a>
										</li>
										<c:forEach  begin="1" end="${map.pageNum }" step="1" var="page">
											<li><a href="/admin/LogsServlet?curPage=${page }">${page }</a></li>
										
										</c:forEach>
										<li>
											<a href="/admin/LogsServlet?cur=${curPage }&act=222&num=${map.pageNum}" aria-label="Next">
												<span aria-hidden="true">&raquo;</span>
											</a>
										</li>
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