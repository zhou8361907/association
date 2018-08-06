<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="as.student,show.student_show,as.appli,as.choose,as.event,as.asso"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生具体信息</title>
    
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
background-color: #f8f8f8;
}

td
{
text-align:center;
text-align:justify;
text-justify:distribute-all-lines;
text-align-last:justify;
font-size:20pt
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
  
  
  <div class="container">
	<div class="row clearfix">
		<div class="col-md-10 column" style="  height:460px;">
		
		<%student st=(student)session.getAttribute("user"); 
		student_show shetuan=new student_show();
		
		List<appli> list=shetuan.student_appli(st.getId());
		List<choose> list_choose=shetuan.student_choose(st.getId());
		String judge=shetuan.judge_charge(st.getId());
		%>
		<br/>
		<center>
		<table>
		<tr>
		
		<td width="150" >姓名:</td>
		<td width="150"><%=st.getName() %></td>
		</tr>
		
		<tr>
		
		<td>学号:</td>
		<td><%=st.getId() %></td>
		</tr>
		<tr>
		
		<td>性别:</td>
		<td><%=st.getSex() %></td>
		</tr>
		
		
		
		<tr>
		
		<td>学院:</td>
		<td><%=st.getAcademy() %></td>
		</tr>
		
		<tr>
		<td>申请:</td>
		<td><%
		
			for( appli app:list)
			{
			 %>
 			<%=shetuan.shetuan_name(app.getA_id()) %>
 			<%=app.getPart() %>&nbsp;&nbsp;
 			待审核<br/>
 
 			<%} %>
 			<%if(list.size()==0){ %>
 			暂无
 			
 			<%} %>
 			</td>
		</tr>
		
		<tr>
		<td>社团:</td>
		<td><%
		
			for( choose ch:list_choose)
			{
			 %>
			 <%=shetuan.shetuan_name(ch.getA_id()) %>
			 <%=ch.getPart() %>&nbsp;&nbsp;
 			<%=ch.getJob() %><br/>
 
			 <%} %>
			 
			 <%if(list_choose.size()==0){ %>
			 暂无
			 <%} %>
			 
			 </td>
		</tr>
		
		
		
		</table>
		<%if(judge!=""){ %>
		<a href="servlet/manage?id=<%=judge %>"><h3>管理我的社团</h3></a>
		
		<%} %>

		<%if(st.getId().equals("admin")){ %>
		<a href="insert.jsp"><h3>管理页面</h3></a>
		
		<%} %>
		</center>
		</div>
		<div class="col-md-2 column" style="border: 1px #ccc solid;">
		<P>我关注的活动</P>
		<%List<event> list_zan=shetuan.event_zan(st.getId()); 
		if(list_zan.size()==0){%>
		
		暂无关注
		<%}else{for( event e:list_zan){
		%>
		<a href="servlet/event_put?id=<%=e.getE_id() %>"><%=e.getE_name() %></a></br></br>
		<%}} %>
		
		<P>我关注的社团</P>
		<%List<asso> list_follow=shetuan.as_follow(st.getId());
		
		if(list_follow.size()==0){%>
		
		暂无关注
		
		<%}else{for( asso as_fol:list_follow){
		
		 %>
		<a href="servlet/as_put?id=<%=as_fol.getA_id() %>"><%=as_fol.getA_name() %></a></br></br>
		
		<%}} %>
		</div>
	</div>
</div>
  
   </body>
</html>
