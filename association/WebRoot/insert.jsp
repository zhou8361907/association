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
    
    <title>����Աҳ��</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- ����ļ�����  -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  
    <!-- jQuery�ļ������bootstrap.min.js ֮ǰ���� -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <!-- ���µ� Bootstrap ���� JavaScript �ļ� -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>






<!-- CSS���� -->   
	
	
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




<%if(user!=null&&user.getId().equals("admin")) {%>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="tabbable" id="tabs-610316">
				<ul class="nav nav-tabs">
					<li class="active">
						 <a href="#panel-1" data-toggle="tab">��������</a>
					</li>
					<li>
						 <a href="#panel-2" data-toggle="tab">����</a>
					</li>
					<li>
						 <a href="#panel-3" data-toggle="tab">�������</a>
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
							���
						</th>
						<th>
							������
						</th>
						<th>
							�ų�
						</th>
						<th>
							����
						</th>
						<th>
							״̬
						</th>
						<th>
							����
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
							<%if(a.getA_new()==1){ %> ��������<%}else{ %>    ��������<%} %>
						</td>
						<td>
							<form name="form" action="servlet/manage_as" method="post">
							<input name="id" value=<%=a.getA_id() %>  style="display:none"/>
							<input name="type" value="0"  style="display:none"/>
							<input type="submit" value="ɾ��������"/>
							</form>
							
							<%if(a.getA_new()==1){ %>
							<form name="form" action="servlet/manage_as" method="post">
							<input name="id" value=<%=a.getA_id() %>  style="display:none"/>
							<input name="type" value="1"  style="display:none"/>
							<input type="submit" value="��������״̬"/>
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
							���
						</th>
						<th>
							�ٰ�����
						</th>
						
						<th>
							״̬
						</th>
						<th>
							����
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
							<%if(e.getE_state()==1){ %> ���ڽ���<%}else{ %>    �ѽ���<%} %>
						</td>
						<td>
							<form name="form" action="servlet/manage_event" method="post">
							<input name="id" value=<%=e.getE_id() %>  style="display:none"/>
							
							<input type="submit" value="ɾ���û"/>
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
   <h2>�������</h2>
   <form name="form" action="servlet/as_associ" method="post">
 <table width="458" height="331">

 
 <tr>
 <td><div align="right"><font color="#000000">���ű��</font>:</div></td>
 <td><div align="left"><input type="text" name="id" required/></div></td>
 </tr>
  <tr>
 <td><div align="right"><font color="#000000">������</font>:</div></td>
 <td><div align="left"><input type="text" name="name" required/></div></td>
 </tr>
 
  <tr>
 <td><div align="right"><font color="#000000">���Ÿ�����</font>:</div></td>
 <td align="left"><input type="text" name="charge" required></td>
 </tr>
 

 <tr>
 <td><div align="right"><font color="#000000">�����ų�</font>:</div></td>
 <td align="left"><input type="text" name="head" required></td>
 </tr>
  <tr>
 <td><div align="right"><font color="#000000">���Ŵ���ʱ��</font>:<br></div></td>
 
 <td align="left"><input type="" name="time" required></td>
 </tr>
 
 <tr>
  <td><div align="right"><font color="#000000">���ż��</font>:</div></td>
 <td align="left"><input type="" name="jian" required></td>
 </tr>

 </table>
<input type="submit" value="�ύ"/>
<input type="reset" value="����"/>
 </form>
 
  </center>
		</div>
		
					
					
				</div>
			</div>
		</div>
	</div>
</div>



<%}else { %>

<center><h1>��ҳ��ֻ���ɹ���Ա����</h1></center>
<%} %>




   
  
  
  
  
  </body>
</html>
