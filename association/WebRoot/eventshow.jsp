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
    
    <title>չʾ�������Ϣ</title>
    
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
						  event ev=(event)request.getAttribute("events");
							event_join pan=new event_join();
							judge zan_ju=new judge();
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
					<a href="servlet/event_zan?s_id=<%=user.getId() %>&&e_id=<%=ev.getE_id() %>" /><span class="badge pull-right"><%=ev.getHope() %></span> �ѵ���</a>
				</li>
				<%} else { %>
				<li >
					<a href="servlet/event_zan?s_id=<%=user.getId() %>&&e_id=<%=ev.getE_id() %>" /><span class="badge pull-right"><%=ev.getHope() %></span> ����</a><%} %>
				</li>
				
				
			<%} %>
		</ul>
								<center>
				<table >

				<tbody>		
				<tr class="text-center">
						<td width="150" >
							<h3>�ٰ�����:</h3>
						</td>
						<td width="150" >
							<h3><%=ev.getA_id() %></h3>
						</td>
					
					</tr><tr class="text-center">
						<td>
							<h3>���:</h3>
						</td>
						<td>
							<h3><%=ev.getE_name() %></h3>
						</td>
					
					</tr>
					<tr class="text-center">
						<td>
							<h3>��ص�:</h3>
						</td>
						<td>
						<h3><%=ev.getE_hole_place() %></h3>
						</td>
					
					</tr>
					<tr class="text-center">
						<td>
							<h3>�ʱ��:</h3>
						</td>
						<td>
						<h3><%=ev.getE_hole_time() %></h3>
						</td>
					
					</tr >
					<tr class="text-center">
						<td>
						<h3>���ͣ� </h3>
						</td>
						<td>
							<h3><%if(ev.getType()==0){ %><h3>�ݳ�ʽ</h3><%  }else  {%><h3>�μ�ʽ</h3> <% }%></h3>
						</td>
					
					</tr>
					<tr class="text-center">
						<td>
						<h3>״̬�� </h3>
						</td>
						<td>
						<h3><%if(ev.getE_state()==0){ %><h3>�ѽ���</h3><%  }else  {%><h3>���ڽ���</h3> <% }%></h3>
						</td>
					
					</tr>
					<%if(ev.getType()==1){ %>
				<tr class="text-center">
						<td>
						<h3>�μ������� </h3>
						</td>
						<td>
						<%student_show stushow=new student_show();
						int i=stushow.event_num(ev.getE_id());
						 %>
						<h3>����<%=i %>�˲μӣ�</h3>
						</td>
					
					</tr>
				<%} %>
				</tbody>
			</table>
				<br/>
				<h3>����</h3>
				<h3><%=ev.getE_jian() %></h3>
				
				
		
					<%if(user!=null){if(ev.getType()!=0 && pan.pan_attend(ev.getE_id(),user.getId())==0){ %>

					<form name="form" action="servlet/events_attend" method="post"  > 
					<input name="e_id" value=<%=ev.getE_id() %>  style="display:none"/>
					<input name="s_id" value=<%=user.getId() %>  style="display:none"/>
					<input type="submit" value="��Ҫ �μ�">


					 <%} else if(ev.getType()!=0 && pan.pan_attend(ev.getE_id(),user.getId())==1){%>
					 <p>���Ѳμ���������</p>
					 
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
