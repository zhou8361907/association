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
    
    <title>ѧ��������Ϣ</title>
    
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
		
		<td width="150" >����:</td>
		<td width="150"><%=st.getName() %></td>
		</tr>
		
		<tr>
		
		<td>ѧ��:</td>
		<td><%=st.getId() %></td>
		</tr>
		<tr>
		
		<td>�Ա�:</td>
		<td><%=st.getSex() %></td>
		</tr>
		
		
		
		<tr>
		
		<td>ѧԺ:</td>
		<td><%=st.getAcademy() %></td>
		</tr>
		
		<tr>
		<td>����:</td>
		<td><%
		
			for( appli app:list)
			{
			 %>
 			<%=shetuan.shetuan_name(app.getA_id()) %>
 			<%=app.getPart() %>&nbsp;&nbsp;
 			�����<br/>
 
 			<%} %>
 			<%if(list.size()==0){ %>
 			����
 			
 			<%} %>
 			</td>
		</tr>
		
		<tr>
		<td>����:</td>
		<td><%
		
			for( choose ch:list_choose)
			{
			 %>
			 <%=shetuan.shetuan_name(ch.getA_id()) %>
			 <%=ch.getPart() %>&nbsp;&nbsp;
 			<%=ch.getJob() %><br/>
 
			 <%} %>
			 
			 <%if(list_choose.size()==0){ %>
			 ����
			 <%} %>
			 
			 </td>
		</tr>
		
		
		
		</table>
		<%if(judge!=""){ %>
		<a href="servlet/manage?id=<%=judge %>"><h3>�����ҵ�����</h3></a>
		
		<%} %>

		<%if(st.getId().equals("admin")){ %>
		<a href="insert.jsp"><h3>����ҳ��</h3></a>
		
		<%} %>
		</center>
		</div>
		<div class="col-md-2 column" style="border: 1px #ccc solid;">
		<P>�ҹ�ע�Ļ</P>
		<%List<event> list_zan=shetuan.event_zan(st.getId()); 
		if(list_zan.size()==0){%>
		
		���޹�ע
		<%}else{for( event e:list_zan){
		%>
		<a href="servlet/event_put?id=<%=e.getE_id() %>"><%=e.getE_name() %></a></br></br>
		<%}} %>
		
		<P>�ҹ�ע������</P>
		<%List<asso> list_follow=shetuan.as_follow(st.getId());
		
		if(list_follow.size()==0){%>
		
		���޹�ע
		
		<%}else{for( asso as_fol:list_follow){
		
		 %>
		<a href="servlet/as_put?id=<%=as_fol.getA_id() %>"><%=as_fol.getA_name() %></a></br></br>
		
		<%}} %>
		</div>
	</div>
</div>
  
   </body>
</html>
