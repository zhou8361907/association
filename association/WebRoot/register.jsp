<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="as.student" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ѧ��ע��</title>
    
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



<script type="text/javascript">
	 function beforesubmit(form){
	
	if(form.re_password.value!=form.password.value)
	 {
	 alert('�������벻��ͬ��');
	 return false;
	 
	 }
	 return true;
	 }
	</script>
	
	
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
  
  
   <center>
   <form name="form" action="servlet/as_register" method="post"  onSubmit="return beforesubmit(this);">
 <table width="458" height="331">

 
 <tr>
 <td><div align="right"><font color="#000000">����</font>:</div></td>
 <td><div align="left"><input type="text" name="name" required/></div></td>
 </tr>
  <tr>
 <td><div align="right"><font color="#000000">ѧ��</font>:</div></td>
 <td><div align="left"><input type="text" name="id" required/></div></td>
 </tr>
 
  <tr>
 <td><div align="right"><font color="#000000">����</font>:</div></td>
 <td align="left"><input type="password" name="password" required></td>
 </tr>
 

 <tr>
 <td><div align="right"><font color="#000000">�ظ�����</font>:</div></td>
 <td align="left"><input type="password" name="re_password" required></td>
 </tr>
  <tr>
 <td><div align="right"><font color="#000000">�Ա�</font>:<br></div></td>
 <td>
 
 <div align="left">
 �У�<input type="radio" name="sex" value="man" required/>
 Ů��<input type="radio" name="sex" value="woman" required/>

 </div> 
 </td>
 </tr>
 
 <tr>
  <td><div align="right"><font color="#000000">ѧԺ</font>:</div></td>
 <td align="left"><input type="" name="academy" required></td>
 </tr>
 <tr>
  <td><div align="right"><font color="#000000">�ֻ�</font>:</div></td>
 <td align="left"><input type="text" name="phone" required></td>
 </tr>
 
 </table>
<input type="submit" value="�ύ"/>
<input type="reset" value="����"/>
 </form>
  </center>
  </body>
</html>
