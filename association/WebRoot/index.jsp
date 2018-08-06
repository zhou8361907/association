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
    
    <title>社团网页首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- 相关文件引入  -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  
    <!-- jQuery文件务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>






<!-- CSS代码 -->   
	
	
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
  
  <!--顶部导航-->
   <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class=" navbar-default navbar-fixed-top " role="navigation">
				<div class="navbar-header ">
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
</form>
				</center>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->




<!-- 轮播幻灯片 -->


<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="3000" >
	<!-- 轮播（Carousel）指标 -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>   
	<!-- 轮播（Carousel）项目 -->
	<div class="carousel-inner">
		<div class="item active">
			<center><img src="images/005.jpg" alt="First slide" height="200"></center>
			<div class="carousel-caption">新闻1</div>
		</div>
		<div class="item">
				<center><img src="images/006.jpg" alt="First slide" height="200"></center>
			<div class="carousel-caption">新闻2</div>
		</div>
		<div class="item">
				<center><img src="images/008.jpg" alt="First slide" height="200"></center>
			<div class="carousel-caption">新闻3</div>
		</div>
	</div>
	<!-- 轮播（Carousel）导航 -->
	<a class="carousel-control left" href="#myCarousel" 
	   data-slide="prev">&lsaquo;</a>
	<a class="carousel-control right" href="#myCarousel" 
	   data-slide="next">&rsaquo;</a>
</div> 
		</div>
		
	</div>
</div>



<!-- 活动页面 -->
<div class="demo">
<div class="container">
	<div class="row clearfix">
	<h2>热门活动展示</h2>
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
					<h3 >活动时间：<%=e.getE_hole_time() %></h3>
					<h3 >活动地点：<%=e.getE_hole_place() %></h3>
					<%if(e.getType()==1) {%><h3 class="title">活动类型：参加式</h3>
					<%}else{ %>
					<h3 >活动类型：演出式</h3>
					<%} %>
			
		</div>			
		</div>
		
		 <%} %>
		
	</div>
</div>
<a href="servlet/event_search?type=-1&&state=-1" style="float:right">>更多活动</a>
</div>

<!-- 热门社团展示 -->
<div class="container">
	<div class="row clearfix">
		<div class="col-md-6 column">
			<h2>
				热门社团展示
			</h2>
			
			
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>
							社团名称
						</th>
						<th>
							团长
						</th>
						<th>
							关注
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
			
				 <a class="btn" href="servlet/as_search?a_new=0">更多热门社团 »</a>
			
			</div>
		</div>
		
		<div class="col-md-6 column">
			<h2>
				新型社团
			</h2>
			
				<table class="table table-striped  table-hover">
				<thead>
					<tr>
						<th>
							社团名称
						</th>
						<th>
							团长
						</th>
						<th>
							关注
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
				 <a class="btn" href="servlet/as_search?a_new=1">更多新型社团 »</a>
			</div>
		</div>
	</div>
</div>

  </body>
</html>
