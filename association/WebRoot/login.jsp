<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="as.student" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�û���¼</title>
    
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

</style>
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
	<script type="text/javascript">
	function beforesubmit(form)
	{
if(form.username.value==''){
alert('�û�������Ϊ�գ�');
form.username.focus();
return false;
}
if(form.password.value==''){
alert('���벻��Ϊ�գ�');
form.password.focus();
return false;
}
return true;
	}
	</script>
  </head>
  
  <body>
   <!--��������-->
   <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle </span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">����</a>
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
  
  
  
  <h1 align="center">��¼����</h1>
<center>
<form name="form" action="servlet/as_login" method="post" onSubmit="return beforesubmit(this);" > 
 
<font color="#000000"><strong>�û���</strong></font>��<input placeholder="�������˺�" type="text" name="username"  align=middle value="" /><br><br><br> 
 <strong><font color="#000000">�� ��</font>:</strong>        <input placeholder="����������" type="password"  name="password" align=middle value=""/><br><br><br>
<strong><input type="submit" value="��¼"></strong>
<a href="register.html"><input type="button" value="ע��"></input></a>

</form>
</center>
  </body>
</html>
