<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zh-CN">

	<head>
		<meta charset="UTF-8">
		<title>日志管理</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="style/index.css" />

		<body style="background-color: #F5F5DC;">
		
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<h1 class="page-header">
                          	日志管理
                          	<c:if test="${logs==null}">
						<small>添加日志</small>
					</c:if>
					<c:if test="${not empty logs}">
						<small>编辑日志</small>
					</c:if>
                          	 
                     </h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<!-- 用户列表--bootstrap高级表格使用 -->
						<div class="panel panel-success">
							<c:if test="${admin==null}">
								<div class="panel-heading col-md-6" >添加日志</div>
							</c:if>
							<c:if test="${not empty admin}">
								<div class="panel-heading col-md-6" >编辑日志</div>
							</c:if>
							<div class="panel-heading col-md-6" style="text-align: right; height: 41px;">
								<a href="/admin/LogsServlet">
								<button type="button" id="btnBack" class="btn btn-success" style="margin-top:-7px">返回</button>
								</a>
							</div>
							<br><br>

					<div class="panel-body">
						<form action="/admin/LogsServlet" method="post">

							<input type="hidden" name="logsId" value="${logs.logs_id }">
   
                          <c:if test="${not empty logs}">
                           <div class="form-group">
								<label for="txtOperateContent">日志编号</label> <input type="text"
									class="form-control" id="txtId" placeholder="日志编号"
									name="日志编号" value="${logs.logs_id}">
							</div>
                          </c:if>
                       
							<div class="form-group">
								<label for="txtOperateContent">操作内容</label> <input type="text"
									class="form-control" id="txtOperateContent" placeholder="操作内容"
									name="OperateContent" value="${logs.operate_content}">
							</div>
							<div class="form-group">
								<label for="txtOperateTime">操作时间</label> <input type="date"
									class="form-control" id="txtOperateTime" placeholder="操作时间"
									name="OperateTime" value="${logs.operate_time}">
							</div>

							<div class="form-group">
								<label for="txtSecurity">安全等级</label> <input type="text"
									class="form-control" id="txtSecurity" placeholder="安全等级"
									name="Security" value="${logs.security_class}">
							</div>
							<div class="form-group">
								<label for="txtIfSuccess">是否成功</label> <input type="text"
									class="form-control" id="txtIfSuccess" placeholder="是否成功"
									name="IfSuccess" value="${logs.if_success}">
							</div>

							<div class="form-group">
								<label for="txtOperateType">操作类别</label> <input type="text"
									class="form-control" id="txtOperateType" placeholder="操作类别"
									name="OperateType" value="${logs.operate_type}">
							</div>
									<button type="submit" class="btn btn-success">保存</button>
									<button type="reset" class="btn btn-info">重置</button>
								</form>
						</div>		
									
							</div>
						</div>
					</div>
					<!--表格结束 -->
				</div>
			
		</body>

</html>