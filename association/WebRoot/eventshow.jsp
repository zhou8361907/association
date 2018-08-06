<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="as.event"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="as.event,as.student,show.event_join,show.judge,show.student_show" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>展示活动具体信息</title>
    
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
td
{
text-align:center;
text-align:justify;
text-justify:distribute-all-lines;
text-align-last:justify
}
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
						
						<% student user=(student)session.getAttribute("user");
						  event ev=(event)request.getAttribute("events");
							event_join pan=new event_join();
							judge zan_ju=new judge();
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
		<div class="col-md-12 column">
		
		<div>
		<ol class="list-unstyled" >
				<li>
			
				<%if(user!=null){ %>
		<ul class="nav nav-pills" style="float:right">
		
		<%if(zan_ju.pan_zan(user.getId(),ev.getE_id())==1) {%>
				<li class="active">
					<a href="servlet/event_zan?s_id=<%=user.getId() %>&&e_id=<%=ev.getE_id() %>" /><span class="badge pull-right"><%=ev.getHope() %></span> 已点赞</a>
				</li>
				<%} else { %>
				<li >
					<a href="servlet/event_zan?s_id=<%=user.getId() %>&&e_id=<%=ev.getE_id() %>" /><span class="badge pull-right"><%=ev.getHope() %></span> 点赞</a><%} %>
				</li>
				
				
			<%} %>
		</ul>
								<center>
				<table >

				<tbody>		
				<tr class="text-center">
						<td width="150" >
							<h3>举办社团:</h3>
						</td>
						<td width="150" >
							<h3><%=ev.getA_id() %></h3>
						</td>
					
					</tr><tr class="text-center">
						<td>
							<h3>活动名:</h3>
						</td>
						<td>
							<h3><%=ev.getE_name() %></h3>
						</td>
					
					</tr>
					<tr class="text-center">
						<td>
							<h3>活动地点:</h3>
						</td>
						<td>
						<h3><%=ev.getE_hole_place() %></h3>
						</td>
					
					</tr>
					<tr class="text-center">
						<td>
							<h3>活动时间:</h3>
						</td>
						<td>
						<h3><%=ev.getE_hole_time() %></h3>
						</td>
					
					</tr >
					<tr class="text-center">
						<td>
						<h3>类型： </h3>
						</td>
						<td>
							<h3><%if(ev.getType()==0){ %><h3>演出式</h3><%  }else  {%><h3>参加式</h3> <% }%></h3>
						</td>
					
					</tr>
					<tr class="text-center">
						<td>
						<h3>状态： </h3>
						</td>
						<td>
						<h3><%if(ev.getE_state()==0){ %><h3>已结束</h3><%  }else  {%><h3>正在进行</h3> <% }%></h3>
						</td>
					
					</tr>
					<%if(ev.getType()==1){ %>
				<tr class="text-center">
						<td>
						<h3>参加人数： </h3>
						</td>
						<td>
						<%student_show stushow=new student_show();
						int i=stushow.event_num(ev.getE_id());
						 %>
						<h3>已有<%=i %>人参加！</h3>
						</td>
					
					</tr>
				<%} %>
				</tbody>
			</table>
				<br/>
				<h3>活动简介</h3>
				<h3><%=ev.getE_jian() %></h3>
				
				
		
					<%if(user!=null){if(ev.getType()!=0 && pan.pan_attend(ev.getE_id(),user.getId())==0){ %>

					<form name="form" action="servlet/events_attend" method="post"  > 
					<input name="e_id" value=<%=ev.getE_id() %>  style="display:none"/>
					<input name="s_id" value=<%=user.getId() %>  style="display:none"/>
					<input type="submit" value="我要 参加">


					 <%} else if(ev.getType()!=0 && pan.pan_attend(ev.getE_id(),user.getId())==1){%>
					 <p>你已参加了这项活动！</p>
					 
					 <% }} %>
					 </h2>
					 </center>
				</li>
			</ol>
		</div>
		</div>
	
	</div>
</div>
  </body>
</html>
