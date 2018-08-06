<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="as.student"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册成功页面</title>
    
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






<!-- CSS代码 -->   
	
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</div>


<style>

body
{
padding:70px;
margin:0;
background-color: #f8f8f8;
}

.demo{padding: 1em 0;}


</style>
  </head>
  
  <body>
  
  <!--顶部导航-->
   <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class=" navbar-default navbar-fixed-top " role="navigation">
				<div class="navbar-header ">
					  <a class="navbar-brand" href="index.jsp">燕大社团</a>
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
						<% student users=(student)request.getAttribute("student"); %>
						<%session.setAttribute("user",users); 
						student user=(student)session.getAttribute("user");
						  
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

<center>
<h1>注册信息为：</h1>
<% 

%>
<br/>


姓名：<%=users.getName() %><br/>
账号：<%=users.getId() %><br/>
密码：<%=users.getPassword()%><br/>
性别：<%=users.getSex() %><br/>
学院：<%=users.getAcademy() %><br/>
手机：<%=users.getPhone() %><br/>


<div ><a href="../association/index.jsp"><input type="button" value="返回首页"></a>  
  </div>
  
  </center>
  </body>
</html>
