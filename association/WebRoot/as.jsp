<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import='as.asso,as.student,show.as_show,as.event,show.event_show,show.student_show,show.judge' %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>社团信息页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>

body
{
padding:70px;
margin:0;
background-color: #f8f8f8
}


</style>


	<!-- 相关文件引入  -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  
    <!-- jQuery文件务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
</form>
				</center>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->



<div class="container">
	<div class="row clearfix">
		<div class="col-md-10 column" style=" border: 0px #ccc solid;height:460px; ">
		<center>
		<%asso as=(asso)request.getAttribute("st"); 
		%>
		<%if(user!=null){ %>
		<% judge ju=new judge();
		if(ju.pan_follow(user.getId(),as.getA_id())==1){
		%>
		<ul class="nav nav-pills" style="float:right">
				<li class="active">
					<a href="servlet/as_follow?s_id=<%=user.getId() %>&&a_id=<%=as.getA_id() %>"><span class="badge pull-right"><%=as.getA_follow() %></span> 已关注</a>
					
					
					
					
				</li>
		</ul>
		<%}else{%>
			<ul class="nav nav-pills" style="float:right">
				<li >
					<a href="servlet/as_follow?s_id=<%=user.getId() %>&&a_id=<%=as.getA_id() %>"><span class="badge pull-right"><%=as.getA_follow() %></span> 关注</a>
					
					
					
					
				</li>
		</ul>
		
		
		
		<% }} %>
		
		<br/>
		<h2>社团名：<%=as.getA_name() %></h2>
		<h2>团长名：<%=as.getA_head() %></h2>
		<h2>社团创建时间：<%=as.getA_time() %></h2>
		<h2>社团简介：<%=as.getA_jian() %></h2>
	
		
		<%if(user!=null){
		
		student_show st_show=new student_show();
		int i=st_show.attend_s(user.getId(),as.getA_id());
		if(i==0){
		 %>
		
		
		<form name="form" action="servlet/as_join" method="post"  > 
		<input name="a_id" value=<%=as.getA_id() %>  style="display:none"/>
		<input name="s_id" value=<%=user.getId() %>  style="display:none"/>
		请选择你要加入的部门 
			<select name="part"> 
 			<option value="秘书部">秘书部</option> 
 			<option value="外联部">外联部</option> 
 			<option value="技术部">技术部</option> 
 			
 			</select> 
 			<input type="submit" value="申请加入">
		</form>
		<%}else{%>
		<h2>您已加入或申请了该社团</h2>
		
		
		<%} } %>
		</center>
		</div>
		<div class="col-md-2 column" style=" border: 1px #ccc solid">
	
			<ol>
			<p>正在进行的活动</p>
			<% as_show asso=new as_show();
			List<event> list_now=asso.asshow_hold_now(as.getA_name());
			 if(list_now.size()==0){
			%>
				<p>暂无进行的活动</p>
				<%}else{ 
			for(event e:list_now)
			{
			 %>
				<li>
					<a href="servlet/event_put?id=<%=e.getE_id() %>"><%=e.getE_name() %></a>
				</li>
				
			
				<%}} %>
			</ol>
			<ol>
			<p>历史活动</p>
			<% List<event> list_done=asso.asshow_hold_done(as.getA_name());
			if(list_done.size()==0){
			%>
				<p>暂无历史活动</p>
				<%}else{ 
				
				for(event e_done:list_done)
				{				
				%>
				<li>
					<a href="servlet/event_put?id=<%=e_done.getE_id() %>"><%=e_done.getE_name() %></a>
				</li>
				
				
				<%} }%>
			</ol>
		</div>
	</div>
</div>

  </body>
</html>
