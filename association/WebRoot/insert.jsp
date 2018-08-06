<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="as.student,as.asso,as.event,show.as_show,show.event_show" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员页面</title>
    
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




<%if(user!=null&&user.getId().equals("admin")) {%>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="tabbable" id="tabs-610316">
				<ul class="nav nav-tabs">
					<li class="active">
						 <a href="#panel-1" data-toggle="tab">管理社团</a>
					</li>
					<li>
						 <a href="#panel-2" data-toggle="tab">管理活动</a>
					</li>
					<li>
						 <a href="#panel-3" data-toggle="tab">添加社团</a>
					</li>
				</ul>
				<div class="tab-content">
				
		
		
					<div class="tab-pane  active" id="panel-1">
						
						
						<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							社团名
						</th>
						<th>
							团长
						</th>
						<th>
							管理
						</th>
						<th>
							状态
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
				<%as_show as_show=new as_show();
				List<asso> list_as=as_show.manage_asshow();
				
				for(asso a:list_as){
				 %>
				
					<tr>
						<td>
							<%=a.getA_id() %>
						</td>
						<td>
							<%=a.getA_name() %>
						</td>
						<td>
							<%=a.getA_head() %>
						</td>
						<td>
							<%=a.getA_charge() %>
						</td>
						<td>
							<%if(a.getA_new()==1){ %> 新兴社团<%}else{ %>    热门社团<%} %>
						</td>
						<td>
							<form name="form" action="servlet/manage_as" method="post">
							<input name="id" value=<%=a.getA_id() %>  style="display:none"/>
							<input name="type" value="0"  style="display:none"/>
							<input type="submit" value="删除该社团"/>
							</form>
							
							<%if(a.getA_new()==1){ %>
							<form name="form" action="servlet/manage_as" method="post">
							<input name="id" value=<%=a.getA_id() %>  style="display:none"/>
							<input name="type" value="1"  style="display:none"/>
							<input type="submit" value="更改社团状态"/>
							</form>
							<%} %>
						</td>
					</tr>
					<%} %>
				</tbody>
			</table>
		</div>
	</div>
</div>		
					</div>
					
					
					
					<div class="tab-pane" id="panel-2">
						

							<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table">
				<thead>
					<tr>
						<th>
							活动名
						</th>
						<th>
							举办社团
						</th>
						
						<th>
							状态
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
				<%event_show event_show=new event_show();
				List<event> list_event=event_show.manage_eventshow();
				
				for(event e:list_event){
				 %>
				
					<tr>
						<td>
							<%=e.getE_name() %>
						</td>
						<td>
							<%=e.getA_id() %>
						</td>
					
						<td>
							<%if(e.getE_state()==1){ %> 正在进行<%}else{ %>    已结束<%} %>
						</td>
						<td>
							<form name="form" action="servlet/manage_event" method="post">
							<input name="id" value=<%=e.getE_id() %>  style="display:none"/>
							
							<input type="submit" value="删除该活动"/>
							</form>
							
						</td>
					</tr>
					<%} %>
				</tbody>
			</table>
		</div>
	</div>
</div>
					</div>
					
					
						<div class="tab-pane" id="panel-3">
				
				 <center>
   <h2>添加社团</h2>
   <form name="form" action="servlet/as_associ" method="post">
 <table width="458" height="331">

 
 <tr>
 <td><div align="right"><font color="#000000">社团编号</font>:</div></td>
 <td><div align="left"><input type="text" name="id" required/></div></td>
 </tr>
  <tr>
 <td><div align="right"><font color="#000000">社团名</font>:</div></td>
 <td><div align="left"><input type="text" name="name" required/></div></td>
 </tr>
 
  <tr>
 <td><div align="right"><font color="#000000">社团负责人</font>:</div></td>
 <td align="left"><input type="text" name="charge" required></td>
 </tr>
 

 <tr>
 <td><div align="right"><font color="#000000">社团团长</font>:</div></td>
 <td align="left"><input type="text" name="head" required></td>
 </tr>
  <tr>
 <td><div align="right"><font color="#000000">社团创建时间</font>:<br></div></td>
 
 <td align="left"><input type="" name="time" required></td>
 </tr>
 
 <tr>
  <td><div align="right"><font color="#000000">社团简介</font>:</div></td>
 <td align="left"><input type="" name="jian" required></td>
 </tr>

 </table>
<input type="submit" value="提交"/>
<input type="reset" value="重置"/>
 </form>
 
  </center>
		</div>
		
					
					
				</div>
			</div>
		</div>
	</div>
</div>



<%}else { %>

<center><h1>此页面只能由管理员操作</h1></center>
<%} %>




   
  
  
  
  
  </body>
</html>
