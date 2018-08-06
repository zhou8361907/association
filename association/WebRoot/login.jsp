<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="as.student" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- 相关文件引入  -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  
    <!-- jQuery文件务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</style>
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
	<script type="text/javascript">
	function beforesubmit(form)
	{
if(form.username.value==''){
alert('用户名不能为空！');
form.username.focus();
return false;
}
if(form.password.value==''){
alert('密码不能为空！');
form.password.focus();
return false;
}
return true;
	}
	</script>
  </head>
  
  <body>
   <!--顶部导航-->
   <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle </span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">社团</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					
					
										
					<ul class="nav navbar-nav navbar-right">
						<li>
							 <a href="index.jsp">首页</a>
						</li>
						<li>
							 <a href="servlet/as_search?a_new=-1">社团</a>
						</li>
						<li>
							 <a href="servlet/event_search?type=-1&&state=-1">社团活动</a>
						</li>
						
						<% student user=(student)session.getAttribute("user");
						  
						if(user==null){
						 %>
						<li>
							 <a  data-toggle="modal" data-target="#myModal">登录</a>
						</li>
						
						<li>
							 <a href="register.jsp">注册</a>
						</li>
						<%} else{ %>
						<li>
							 <a href="studentshow.jsp" onclick="exit"><%=user.getName() %></a>
						</li>
						<li>
						
							 <a href="servlet/as_exit"  >退出</a>
							 
							
						
						</li>
						<%} %>
						
					</ul>
				</div>
				
			</nav>
		</div>
	</div>
</div>
  
  
  
  <h1 align="center">登录管理</h1>
<center>
<form name="form" action="servlet/as_login" method="post" onSubmit="return beforesubmit(this);" > 
 
<font color="#000000"><strong>用户名</strong></font>：<input placeholder="请输入账号" type="text" name="username"  align=middle value="" /><br><br><br> 
 <strong><font color="#000000">密 码</font>:</strong>        <input placeholder="请输入密码" type="password"  name="password" align=middle value=""/><br><br><br>
<strong><input type="submit" value="登录"></strong>
<a href="register.html"><input type="button" value="注册"></input></a>

</form>
</center>
  </body>
</html>
