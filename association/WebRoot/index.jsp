<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="show.event_show,as.event"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="show.event_show,as.event,as.asso,show.as_show,as.student" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>������ҳ��ҳ</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
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
.box{
		text-align: left;
		overflow: hidden;
		position: relative;
		//background:url(images/w.jpg) ;
		height: 300px;
		background-size:cover;
		float:left;
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




<!-- �ֲ��õ�Ƭ -->


<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="3000" >
	<!-- �ֲ���Carousel��ָ�� -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>   
	<!-- �ֲ���Carousel����Ŀ -->
	<div class="carousel-inner">
		<div class="item active">
			<center><img src="images/005.jpg" alt="First slide" height="200"></center>
			<div class="carousel-caption">����1</div>
		</div>
		<div class="item">
				<center><img src="images/006.jpg" alt="First slide" height="200"></center>
			<div class="carousel-caption">����2</div>
		</div>
		<div class="item">
				<center><img src="images/008.jpg" alt="First slide" height="200"></center>
			<div class="carousel-caption">����3</div>
		</div>
	</div>
	<!-- �ֲ���Carousel������ -->
	<a class="carousel-control left" href="#myCarousel" 
	   data-slide="prev">&lsaquo;</a>
	<a class="carousel-control right" href="#myCarousel" 
	   data-slide="next">&rsaquo;</a>
</div> 
		</div>
		
	</div>
</div>



<!-- �ҳ�� -->
<div class="demo">
<div class="container">
	<div class="row clearfix">
	<h2>���Żչʾ</h2>
	 <%
			 event_show events=new event_show();
			 List<event> list=events.eventshow();
			 
			 for(event e:list)
			 {
			 
			  %>			
		<div class="col-md-4 column">
		<div class="box">
					<center>
					<h3 ><a href="servlet/event_put?id=<%=e.getE_id() %>"><%=e.getE_name() %></a></h3>
					</center>
					<h3 >�ʱ�䣺<%=e.getE_hole_time() %></h3>
					<h3 >��ص㣺<%=e.getE_hole_place() %></h3>
					<%if(e.getType()==1) {%><h3 class="title">����ͣ��μ�ʽ</h3>
					<%}else{ %>
					<h3 >����ͣ��ݳ�ʽ</h3>
					<%} %>
			
		</div>			
		</div>
		
		 <%} %>
		
	</div>
</div>
<a href="servlet/event_search?type=-1&&state=-1" style="float:right">>����</a>
</div>

<!-- ��������չʾ -->
<div class="container">
	<div class="row clearfix">
		<div class="col-md-6 column">
			<h2>
				��������չʾ
			</h2>
			
			
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>
							��������
						</th>
						<th>
							�ų�
						</th>
						<th>
							��ע
						</th>
						
					</tr>
				</thead>
				<tbody>
				<%as_show asso=new as_show();
			List<asso> list_as=asso.asshow();
			
			for(asso a:list_as)
			{
			 %>
			 			 
			
			
					<tr>
						<td>
							<a href="servlet/as_put?id=<%=a.getA_id() %>"><%=a.getA_name() %></a>
						</td>
						<td>
							<%=a.getA_head() %>
						</td>
						<td>
							<%=a.getA_follow() %>
						</td>
					
					</tr>
					 <%} %>
				</tbody>
			</table>
			<div style="position:absolute;right:1%">
			
				 <a class="btn" href="servlet/as_search?a_new=0">������������ �0�3</a>
			
			</div>
		</div>
		
		<div class="col-md-6 column">
			<h2>
				��������
			</h2>
			
				<table class="table table-striped  table-hover">
				<thead>
					<tr>
						<th>
							��������
						</th>
						<th>
							�ų�
						</th>
						<th>
							��ע
						</th>
						
					</tr>
				</thead>
				<tbody>
				<%
		List<asso> list_as_new=asso.asshow_new();
			
			for(asso a_new:list_as_new){
			 %>
			 			 
			
			
					<tr>
						<td>
							<a href="servlet/as_put?id=<%=a_new.getA_id() %>"><%=a_new.getA_name() %></a>
						</td>
						<td>
							<%=a_new.getA_head() %>
						</td>
						<td>
							<%=a_new.getA_follow() %>
						</td>
					
					</tr>
					 <%} %>
				</tbody>
			</table>
			
			
			
			
			
			<div style="position:absolute;right:1%">
				 <a class="btn" href="servlet/as_search?a_new=1">������������ �0�3</a>
			</div>
		</div>
	</div>
</div>

  </body>
</html>
