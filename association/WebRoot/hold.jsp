<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import ="as.student" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>举办活动</title>
    
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

<style>

body
{
padding:70px;
margin:0;
background-color: #f8f8f8;
}
</style>

  </head>
  
  <body>
     <!--顶部导航-->
   <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
				<div class="navbar-header">
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


<!-- 模态框登录 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					登录
				</h4>
			</div>
			<center>
			<form name="form" action="servlet/as_login" method="post"  > 
 
<font color="#000000"><strong>用户名</strong></font>：<input placeholder="请输入账号" type="text" name="username"  align=middle  /><br><br><br> 
 <strong><font color="#000000">密 码</font>:</strong>        <input placeholder="请输入密码" type="password"  name="password" align=middle /><br><br><br>
<strong><input type="submit" value="登录"></strong>
<a href="register.jsp"><input type="button" value="注册"></input></a>
			</form>	</center>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->


<center>
<form name="form" action="servlet/as_event" method="post"  ">
 <table width="458" height="331">

 
 <tr>
 <td><div align="right"><font color="#000000">活动编号</font>:</div></td>
 <td><div align="left"><input type="text" name="id" required/></div></td>
 </tr>
  <tr>
 <td><div align="right"><font color="#000000">活动名</font>:</div></td>
 <td><div align="left"><input type="text" name="name" required/></div></td>
 </tr>
 
  <tr>
 <td><div align="right"><font color="#000000">活动类型</font>:</div></td>
 <td align="left"><input type="text" name="type" required></td>
 </tr>
 

 <tr>
 <td><div align="right"><font color="#000000">活动时间</font>:</div></td>
 <td align="left"><input type="text" name="time" required></td>
 </tr>
  <tr>
 <td><div align="right"><font color="#000000">活动地点</font>:</div></td>
 <td align="left"><input type="text" name="place" required></td>
 </tr>
 
 
 <tr>
  <td><div align="right"><font color="#000000">活动简介</font>:</div></td>
 <td align="left"><input type="" name="jian" required></td>
 </tr>
<input name="aid" value=<%=request.getParameter("id") %>  style="display:none"/>


 </table>
<input type="submit" value="提交"/>
<input type="reset" value="重置"/>
 </form>

</center>
  </body>
</html>
