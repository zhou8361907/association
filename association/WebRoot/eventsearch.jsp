<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="as.event,as.student" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�����ҳ��</title>
    
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
</style>
	<!-- ����ļ�����  -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  
    <!-- jQuery�ļ������bootstrap.min.js ֮ǰ���� -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <!-- ���µ� Bootstrap ���� JavaScript �ļ� -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  
  <body>
    <!--��������-->
   <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
				<div class="navbar-header">
					 <a class="navbar-brand" href="index.jsp">�������</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					
					
										
					<ul class="nav navbar-nav navbar-right">
						<li>
							 <a href="index.jsp">��ҳ</a>
						</li>
						<li>
							 <a href="servlet/as_search?a_new=-1">����</a>
						</li>
						<li>
							 <a href="servlet/event_search?type=-1&&state=-1">���Ż</a>
						</li>
						
						<% student user=(student)session.getAttribute("user");
						  
						if(user==null){
						 %>
						<li>
							 <a  data-toggle="modal" data-target="#myModal">��¼</a>
						</li>
						
						<li>
							 <a href="register.jsp">ע��</a>
						</li>
						<%} else{ %>
						<li>
							 <a href="studentshow.jsp" onclick="exit"><%=user.getName() %></a>
						</li>
						<li>
						
							 <a href="servlet/as_exit"  >�˳�</a>
							 
							
						
						</li>
						<%} %>
						
					</ul>
				</div>
				
			</nav>
		</div>
	</div>
</div>



<!-- ģ̬���¼ -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					��¼
				</h4>
			</div>
			<center>
			<form name="form" action="servlet/as_login" method="post"  > 
 
<font color="#000000"><strong>�û���</strong></font>��<input placeholder="�������˺�" type="text" name="username"  align=middle  /><br><br><br> 
 <strong><font color="#000000">�� ��</font>:</strong>        <input placeholder="����������" type="password"  name="password" align=middle /><br><br><br>
<strong><input type="submit" value="��¼"></strong>
<a href="register.jsp"><input type="button" value="ע��"></input></a>
</form>
				</center>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->


<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
		 <h1>�����</h1>
		 <form name="form" action="servlet/event_search" method="post" >
			<ul class="breadcrumb">
				<li>
					 <p>���ͣ�</p>
				</li>
				<li>
					 	<input type="radio" name="type" value="-1" required>ȫ��</input>
				</li>
				<li>
						<input type="radio" name="type" value="1" required>�μ���</input>
				</li>
				<li>
					<input type="radio" name="type" value="0" required>�ݳ���</input>
				</li>
			</ul>
			<ul class="breadcrumb">
				<li>
					 <p>״̬��</p>
				</li>
				<li>
					 <input type="radio" name="state" value="-1" required>ȫ��</input>
				</li>
				<li>
					  <input type="radio" name="state" value="1" required>���ڽ���</input>
				</li>
				<li>
					 <input type="radio" name="state" value="0" required>�ѽ���</input>
				</li>
			</ul>
			<center>
			<input type="submit" value="����"/>
			<input type="reset" value="����"/>
			</center>
			</form>
			<%
			List<event> list =new ArrayList<event>();
			list=(List)request.getAttribute("event_search");
			
			%>
			
			
			<table border="1">
			<%
			for(event e:list)
			{
			 %>
			<tr>
				 <a href="servlet/event_put?id=<%=e.getE_id() %>" class="list-group-item active"><%=e.getE_name() %></a>
				<div class="list-group-item">
				�ٰ�ʱ�䣺  <%=e.getE_hole_time() %> 
				&nbsp;&nbsp;&nbsp;&nbsp;  �ٰ�ʱ�䣺 <%=e.getE_hole_place() %> 
				&nbsp;&nbsp;&nbsp;&nbsp;  ���ͣ� <%if(e.getType()==0){ %><h>�ݳ�ʽ</h><%  }else  {%><h>�μ�ʽ</h> <% }%>
				&nbsp;&nbsp;&nbsp;&nbsp;  ״̬��  <%if(e.getE_state()==0){ %><h>�ѽ���</h><%  }else  {%><h>���ڽ���</h> <% }%>
				</div>
				</tr>
			<%} %>
			</table>
		</div>
	</div>
</div>

  </body>
</html>
