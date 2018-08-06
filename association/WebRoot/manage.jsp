<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="as.student,as.event,as.appli,show.student_show,as.choose" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>社团管理页面</title>
    
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
			<nav class="navbar navbar-default  navbar-fixed-top " role="navigation">
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
				</form></center>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->

<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="tabbable" id="tabs-572269">
				<ul class="nav nav-tabs">
					<li class="active">
						 <a href="#panel-1" data-toggle="tab">人员管理</a>
					</li>
					<li>
						 <a href="#panel-184155" data-toggle="tab">活动管理</a>
					</li>
					<li>
						 <a href="#panel-142094" data-toggle="tab">申请管理</a>
					</li>
				</ul>
				<div class="tab-content">
				<div class="tab-pane active" id="panel-1">
						
						<table class="table table-bordered">
				<thead>
					<tr>
						
						<th>
							姓名
						</th>
						<th>
							学院
						</th>
						<th>
							手机
						</th>
						<th>
							部门
						</th>
						<th>
							职务
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				
				
				<tbody>
			
					<%
					List<choose> ch=new ArrayList<choose>();
					
				ch=(List)request.getAttribute("manage_choose");
			;
				for( choose c:ch){
				student_show ss=new student_show();
				student st=ss.student_info(c.getS_id());
				
				%>
				<tr>
					
						
						<td>
							<%=st.getName() %>
						</td>
						
						<td>
							<%=st.getAcademy() %>
						</td>
						<td>
						
							<%=st.getPhone() %>
						</td>
						<td>
						
							<%=c.getPart() %>
						</td>
						<td>
						
							<%=c.getJob() %>
						</td>
						
						<td>
						<form name="form" action="servlet/manage_choose" method="post"  > 
					<input name="a_id" value=<%=c.getA_id() %>  style="display:none"/>
					<input name="s_id" value=<%=st.getId() %>  style="display:none"/>
					<input name="type" value="1" style="display:none">
 			更改职位
			<select name="job"> 
 			<option value="团员">团员</option> 
 			<option value="部长">部长</option> 
 			
 			
 					<input type="submit"  value="更改"></form>
					
					<form name="form" action="servlet/manage_choose" method="post"  > 
					<input name="a_id" value=<%=c.getA_id() %>  style="display:none"/>
					<input name="s_id" value=<%=st.getId() %>  style="display:none"/>
					<input name="type" value="0" style="display:none">
 			
 			
 			
 					<input type="submit"  value="删除"></form>
							
						</td>
						
						
						
						<%} %>
					</tr>
					
				</tbody>
			</table>
						
						
					</div>
				
				
				
					<div class="tab-pane" id="panel-142094">
						
						<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							学号
						</th>
						<th>
							姓名
						</th>
						<th>
							学院
						</th>
						<th>
							手机
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				
				
				<tbody>
			<%String a=""; %>
					<%List<appli> appli_list=new ArrayList<appli>();
					List<event> event_hold=new ArrayList<event>();
					event_hold=(List)request.getAttribute("event_hold");
				appli_list=(List)request.getAttribute("manage_appli");
				String aaid="";
				for( appli app:appli_list){
				student_show ss=new student_show();
				student st=ss.student_info(app.getS_id());
				
				%>
				<tr>
					
						<td>
							<%=st.getId() %>
						</td>
						<td>
							<%=st.getName() %>
						</td>
						
						<td>
							<%=app.getPart() %>
						</td>
						<td>
						
							<%=st.getPhone() %>
						</td>
						<td>
						<form name="form" action="servlet/manage_appli" method="post"  > 
					<input name="aid" value=<%=app.getA_id() %>  style="display:none"/>
					<input name="sid" value=<%=st.getId() %>  style="display:none"/>
					<input name="part" value=<%=app.getPart() %>  style="display:none"/>
 			
 			
 					<input type="submit" name="type" value="同意"></form>
 					
 					
 					<form name="form" action="servlet/manage_appli_no" method="post"  > 
					<input name="aid" value=<%=app.getA_id() %>  style="display:none"/>
					<input name="sid" value=<%=st.getId() %>  style="display:none"/>
					<input name="part" value=<%=app.getPart() %>  style="display:none"/>
 			
 			
 					<input type="submit" name="type" value="拒绝"></form>
					
							
						</td>
						
						
						
						<%} %>
					</tr>
					
				</tbody>
			</table>
						
						
					</div>
					<div class="tab-pane" id="panel-184155">
						<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							活动编号
						</th>
						<th>
							活动名
						</th>
						<th>
							活动类型
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				
				
				<tbody>
			
					<%
				
				for( event ev:event_hold){
				
				%>
				<tr>
					
						<td>
							<a href="servlet/event_put?id=<%=ev.getE_id() %>"><%=ev.getE_id() %></a>
						</td>
						<td>
						<%
						student_show s=new student_show();
						a=ev.getA_id(); %>
						
							<%=ev.getE_name() %>
						</td>
						<%if(ev.getType()==1){ %>
						<td>
							参加类
						</td>
						<%}else{ %>
						<td>
							演出类
						</td>
						<%} %>
						<td>
						
						
							<form name="form" action="servlet/event_finish" method="post"  > 
					
					<input name="aid" value=<%=ev.getA_id() %>  style="display:none"/>	
					<input name="eid" value=<%=ev.getE_id() %>  style="display:none"/>
 					<input type="submit"  value="结束">
 					</form>
 					
 					<%if(ev.getType()==1){  %>
 					<form name="form" action="servlet/attend_show" method="post"  > 
					
					
					<input name="id" value=<%=ev.getE_id() %>  style="display:none"/>
 					<input type="submit"  value="查看参加人员">
 					</form>
 					
 					<%} %>
						</td>
						
						
						
						<%} %>
					</tr>
					
				</tbody>
			</table>
			
			<center><a href="hold.jsp?id=<%=a %>"><h2>举办活动</h2></a></center>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>





  </body>
</html>
