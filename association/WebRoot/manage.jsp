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
    
    <title>���Ź���ҳ��</title>
    
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
    <!--��������-->
   <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default  navbar-fixed-top " role="navigation">
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
						 <a href="#panel-1" data-toggle="tab">��Ա����</a>
					</li>
					<li>
						 <a href="#panel-184155" data-toggle="tab">�����</a>
					</li>
					<li>
						 <a href="#panel-142094" data-toggle="tab">�������</a>
					</li>
				</ul>
				<div class="tab-content">
				<div class="tab-pane active" id="panel-1">
						
						<table class="table table-bordered">
				<thead>
					<tr>
						
						<th>
							����
						</th>
						<th>
							ѧԺ
						</th>
						<th>
							�ֻ�
						</th>
						<th>
							����
						</th>
						<th>
							ְ��
						</th>
						<th>
							����
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
 			����ְλ
			<select name="job"> 
 			<option value="��Ա">��Ա</option> 
 			<option value="����">����</option> 
 			
 			
 					<input type="submit"  value="����"></form>
					
					<form name="form" action="servlet/manage_choose" method="post"  > 
					<input name="a_id" value=<%=c.getA_id() %>  style="display:none"/>
					<input name="s_id" value=<%=st.getId() %>  style="display:none"/>
					<input name="type" value="0" style="display:none">
 			
 			
 			
 					<input type="submit"  value="ɾ��"></form>
							
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
							ѧ��
						</th>
						<th>
							����
						</th>
						<th>
							ѧԺ
						</th>
						<th>
							�ֻ�
						</th>
						<th>
							����
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
 			
 			
 					<input type="submit" name="type" value="ͬ��"></form>
 					
 					
 					<form name="form" action="servlet/manage_appli_no" method="post"  > 
					<input name="aid" value=<%=app.getA_id() %>  style="display:none"/>
					<input name="sid" value=<%=st.getId() %>  style="display:none"/>
					<input name="part" value=<%=app.getPart() %>  style="display:none"/>
 			
 			
 					<input type="submit" name="type" value="�ܾ�"></form>
					
							
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
							����
						</th>
						<th>
							���
						</th>
						<th>
							�����
						</th>
						<th>
							����
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
							�μ���
						</td>
						<%}else{ %>
						<td>
							�ݳ���
						</td>
						<%} %>
						<td>
						
						
							<form name="form" action="servlet/event_finish" method="post"  > 
					
					<input name="aid" value=<%=ev.getA_id() %>  style="display:none"/>	
					<input name="eid" value=<%=ev.getE_id() %>  style="display:none"/>
 					<input type="submit"  value="����">
 					</form>
 					
 					<%if(ev.getType()==1){  %>
 					<form name="form" action="servlet/attend_show" method="post"  > 
					
					
					<input name="id" value=<%=ev.getE_id() %>  style="display:none"/>
 					<input type="submit"  value="�鿴�μ���Ա">
 					</form>
 					
 					<%} %>
						</td>
						
						
						
						<%} %>
					</tr>
					
				</tbody>
			</table>
			
			<center><a href="hold.jsp?id=<%=a %>"><h2>�ٰ�</h2></a></center>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>





  </body>
</html>
