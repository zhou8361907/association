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
    
    <title>������Ϣҳ��</title>
    
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
			<nav class=" navbar-default navbar-fixed-top " role="navigation">
				<div class="navbar-header ">
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
					<a href="servlet/as_follow?s_id=<%=user.getId() %>&&a_id=<%=as.getA_id() %>"><span class="badge pull-right"><%=as.getA_follow() %></span> �ѹ�ע</a>
					
					
					
					
				</li>
		</ul>
		<%}else{%>
			<ul class="nav nav-pills" style="float:right">
				<li >
					<a href="servlet/as_follow?s_id=<%=user.getId() %>&&a_id=<%=as.getA_id() %>"><span class="badge pull-right"><%=as.getA_follow() %></span> ��ע</a>
					
					
					
					
				</li>
		</ul>
		
		
		
		<% }} %>
		
		<br/>
		<h2>��������<%=as.getA_name() %></h2>
		<h2>�ų�����<%=as.getA_head() %></h2>
		<h2>���Ŵ���ʱ�䣺<%=as.getA_time() %></h2>
		<h2>���ż�飺<%=as.getA_jian() %></h2>
	
		
		<%if(user!=null){
		
		student_show st_show=new student_show();
		int i=st_show.attend_s(user.getId(),as.getA_id());
		if(i==0){
		 %>
		
		
		<form name="form" action="servlet/as_join" method="post"  > 
		<input name="a_id" value=<%=as.getA_id() %>  style="display:none"/>
		<input name="s_id" value=<%=user.getId() %>  style="display:none"/>
		��ѡ����Ҫ����Ĳ��� 
			<select name="part"> 
 			<option value="���鲿">���鲿</option> 
 			<option value="������">������</option> 
 			<option value="������">������</option> 
 			
 			</select> 
 			<input type="submit" value="�������">
		</form>
		<%}else{%>
		<h2>���Ѽ���������˸�����</h2>
		
		
		<%} } %>
		</center>
		</div>
		<div class="col-md-2 column" style=" border: 1px #ccc solid">
	
			<ol>
			<p>���ڽ��еĻ</p>
			<% as_show asso=new as_show();
			List<event> list_now=asso.asshow_hold_now(as.getA_name());
			 if(list_now.size()==0){
			%>
				<p>���޽��еĻ</p>
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
			<p>��ʷ�</p>
			<% List<event> list_done=asso.asshow_hold_done(as.getA_name());
			if(list_done.size()==0){
			%>
				<p>������ʷ�</p>
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
