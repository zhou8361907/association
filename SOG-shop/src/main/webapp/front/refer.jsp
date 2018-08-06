<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <link href="css/font-awesome.min.css" rel="stylesheet">
 <link href="css/style.min.css" rel="stylesheet">
 <link href="css/animate.min.css" rel="stylesheet">
 <link rel="shortcut icon" href="favicon.ico">
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Shopin Responsive web template, Bootstrap Web Templates, Flat Web Templates, AndroId Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--theme-style-->
<link href="css/style4.css" rel="stylesheet" type="text/css" media="all" />	
<link rel="stylesheet" type="text/css" href="css/refer.css"/>
<!--//theme-style-->
<script src="js/jquery.min.js"></script>
<script src="js/islider.js" type="text/javascript" charset="utf-8"></script>
<!--- start-rate---->
<script src="js/jstarbox.js"></script>
	<link rel="stylesheet" href="css/jstarbox.css" type="text/css" media="screen" charset="utf-8" />
		<script type="text/javascript">
			jQuery(function() {
			jQuery('.starbox').each(function() {
				var starbox = jQuery(this);
					starbox.starbox({
					average: starbox.attr('data-start-value'),
					changeable: starbox.hasClass('unchangeable') ? false : starbox.hasClass('clickonce') ? 'once' : true,
					ghosting: starbox.hasClass('ghosting'),
					autoUpdateAverage: starbox.hasClass('autoupdate'),
					buttons: starbox.hasClass('smooth') ? false : starbox.attr('data-button-count') || 5,
					stars: starbox.attr('data-star-count') || 5
					}).bind('starbox-value-changed', function(event, value) {
					if(starbox.hasClass('random')) {
					var val = Math.random();
					starbox.next().text(' '+val);
					return val;
					} 
				})
			});
		});
		</script>		
<!---//End-rate---->
<style type="text/css">
	.sel_btn{
			margin-bottom: 30px;
			margin-left: 85%;
			margin-top: 30px;			
			color: black;
            line-height: 21px;
            padding: 0 11px;
            background: #AAAAAA;
            border: 1px #26bbdb solid;
            border-radius: 3px;
            /*color: #fff;*/
            display: inline-block;
            text-decoration: none;
            font-size: 20px;
            outline: none;
            padding-top: 7px;
            padding-bottom: 7px;
        }
</style>
</head>
<body>

<!--header-->
<div class="header">
<div class="container">
		<div class="head">
			<div class=" logo">
				<a href="index.jsp"><img src="images/logo.png" alt=""></a>	
			</div>
		</div>
	</div>
	<div class="header-top">
		<div class="container-fluid" >
						<c:if test="${empty user}">
						<div style="margin-top: -15px"  class="col-md-3 col-md-offset-9  header-login" style="font-size: 15px;font-family:castellar">
							<ul>
							
									<li><a  href="login.jsp">登录</a></li>
									<li><a href="register.jsp">注册</a></li>	
									</ul></div>
									</c:if>				
								
					<c:if test="${not empty user}">
					<div style="margin-top: -15px" class="col-md-4 col-md-offset-8  header-login" style="font-size: 15px;font-family:castellar">
					<ul>
						<li><P style="color:white;font-size:18px">${user.user_name }</P></li>
						<li><a href="/front/ChooseServlet?user_id=${user.user_id }">购物车</a></li>
						<li><a href="/front/frontOrdersServlet?user_id=${user.user_id }">我的订单</a></li>
						<li><a href="/front/AddressServlet?user_id=${user.user_id }">我的地址</a></li>
						<li><a href="/front/UserLoginServlet">注销</a></li>
				
					</ul>
		</div>			
				</c:if>	
				<div class="clearfix"> </div>
		</div>
		</div>
		
		<div class="container">
		
			<div class="head-top">
			
		 		<div class="col-sm-8 col-md-offset-2 h_menu4">
								<nav class="navbar nav_bottom" role="navigation">
				 
				 <!-- Brand and toggle get grouped for better mobile display -->
									<div class="navbar-header nav_2">
									     <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
									        <span class="sr-only">Toggle navigation</span>
									        <span class="icon-bar"></span>
									        <span class="icon-bar"></span>
									        <span class="icon-bar"></span>
									     </button>				     
									</div> 
				   <!-- Collect the nav links, forms, and other content for toggling -->
				    <div class="collapse navbar-collapse" id="bs-megadropdown-tabs" >
				        <ul class="nav navbar-nav nav_1">
				            <li><a  style="font-size:15px;" class="color" href="index.jsp">首页</a></li>				            
				    		<li class="dropdown mega-dropdown active">
							    <a  style="font-size:15px;" class="color1" href="#" class="dropdown-toggle" data-toggle="dropdown">品牌<span class="caret"></span></a>				
								<div class="dropdown-menu ">
				                    <div class="menu-top">
										<div class="col1">
											<div class="h_nav">
													<ul>
														<li><a href="brand.jsp">YSL</a></li>
														<li><a href="brand.jsp">迪奥</a></li>
														<li><a href="brand.jsp">香奈儿</a></li>										
														
													</ul>	
											</div>							
										</div>
										<div class="col1">
											<div class="h_nav">
												<ul>
													<li><a href="brand.jsp">MAC</a></li>
													<li><a href="brand.jsp">兰蔻</a></li>
													<li><a href="brand.jsp">纪梵希</a></li>
													
													
												</ul>	
											</div>							
										</div>
										<div class="col1">
											<div class="h_nav">
												<ul>
													<li><a href="brand.jsp">CPB</a></li>
													<li><a href="brand.jsp">娇兰</a></li>
													<li><a href="brand.jsp">阿玛尼</a></li>
																						
												</ul>								
											</div>							
										</div>
										<div class="col1">
											<div class="h_nav">												
												<ul>													
													<li><a href="brand.jsp">巴宝莉</a></li>
													<li><a href="brand.jsp">雅诗兰黛</a></li>
													<li><a href="brand.jsp">Tom Ford</a></li>
												</ul>	
											</div>							
										</div>
										<div class="col1 col5">
											<img src="images/me.jpeg" class="img-responsive" alt="">
										</div>
										<div class="clearfix">							
										</div>
									</div>                  
								</div>				
							</li>
							
							<li><a  style="font-size:15px;" class="color3" href="product.jsp">购买</a></li>
							<li><a  style="font-size:15px;" class="color4" href="404.html">关于</a></li>
				            <!--<li><a class="color5" href="typo.html">Short Codes</a></li>
				-->           
							<li ><a  style="font-size:15px;" class="color6" href="#">加入我们</a></li>
				        </ul>
				     </div><!-- /.navbar-collapse -->
				
				</nav>
			</div>
		
					<div class="clearfix"> </div>
			<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
			<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
			<!---//pop-up-box---->
			<div id="small-dialog" class="mfp-hide">
				<div class="search-top">
					<div class="login-search">
						<input type="submit" value="">
						<input type="text" value="Search.." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search..';}">		
					</div>
					<p>Shopin</p>
				</div>				
			</div>
		 <script>
			$(document).ready(function() {
			$('.popup-with-zoom-anim').magnificPopup({
			type: 'inline',
			fixedContentPos: false,
			fixedBgPos: true,
			overflowY: 'auto',
			closeBtnInside: true,
			preloader: false,
			midClick: true,
			removalDelay: 300,
			mainClass: 'my-mfp-zoom-in'
			});
																						
			});
		</script>		
						<!----->
			</div>
			<div class="clearfix"></div>
		</div>	
	</div>	
</div>	
		<div class="confirm-address ">
			<p >确认收货地址	</p>
		</div>	
		
			<c:forEach items="${location_list}" var="loc">
				<div class="new_address">
				<span class="glyphicon glyphicon-home"></span>
				<span>寄送到</span>
				<input type="radio" name="address" class="address"   value="" /><span class="dizhi">${loc.location }（${loc.name } 收）电话：${loc.phone }</span><a  href="/front/AddressServlet?flag=delete&user_id=${user.user_id }&location_id=${loc.locationId}" style="float: right;font-size:14px;padding:6px 12px">删除</a><a  href="#modal-container-598581" role="button" class="btn" data-toggle="modal" style="float: right;"onclick="A('${loc.locationId}','${loc.location }','${loc.name } ','${loc.phone }')">修改该地址 </a>
			</div>
			
			
			</c:forEach>
			<a href="#modal-container-598582" role="button" class="btn sel_btn" data-toggle="modal" style="">添加新地址 </a>
		
		
	
		<form name="form1" action="/front/AddressServlet" method="post">		
			<div class="modal fade" id="modal-container-598581" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h3>修改地址：</h3></br>
							地址：&emsp;<input type="text" style="width: 60%;" id="location1" name="location" value=""/></br></br>
							姓名：&emsp;<input type="text" style="width: 60%;" id="name1" name="name"  value=""/></br></br>
							手机号：<input type="text" style="width: 60%;" id="phone1" name="phone"  value=""/>
							<input type="hidden" id="location_id"  name="location_id" value="0">
							<input type="hidden" name="user_id" value="${user.user_id }">
							<input type="hidden" name="flag" value="update">
						</div>	
						<button style="margin-left: 70%;margin-top: 20px;margin-bottom: 20px;" type="submit" class="btn btn-default" data-dismiss="modal">关闭</button> <button  style="margin-top: 20px; margin-bottom: 20px;" type="submit" class="btn btn-primary">保存</button>
					</div>							
				</div>						
			</div>		
		</form>
		<form name="form2" action="/front/AddressServlet" method="post">		
			<div class="modal fade" id="modal-container-598582" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h3>新增地址：</h3></br>
							地址：&emsp;<input type="text" style="width: 60%;" name="location" value=""/></br></br>
							姓名：&emsp;<input type="text" style="width: 60%;" name="name" value=""/></br></br>
							手机号：<input type="text" style="width: 60%;" name="phone" value=""/>
								<input type="hidden" name="user_id" value="${user.user_id }">
								<input type="hidden" name="flag" value="add">
						</div>	
						<button style="margin-left: 70%;margin-top: 20px;margin-bottom: 20px;" class="btn btn-default" data-dismiss="modal">关闭</button> 
						<button  style="margin-top: 20px; margin-bottom: 20px;" type="submit" class="btn btn-primary" >保存</button>
					</div>							
				</div>						
			</div>		
		</form>
		<script type="text/javascript">
			
				$(".address").click(function (){
				
				$(".old_address").attr("class","new_address");
				$(this).parent().attr("class","old_address")

			})
		</script>
	<div class="footer">
	<div class="footer-middle">
				<div class="container">
					<div class="col-md-3 footer-middle-in">
						<a href="index.html"><img src="images/log.png" alt=""></a>
						<p>Suspendisse sed accumsan risus. Curabitur rhoncus, elit vel tincidunt elementum, nunc urna tristique nisi, in interdum libero magna tristique ante. adipiscing varius. Vestibulum dolor lorem.</p>
					</div>
					
					<div class="col-md-3 footer-middle-in">
						<h6>Information</h6>
						<ul class=" in">
							<li><a href="404.html">About</a></li>
							<li><a href="contact.html">Contact Us</a></li>
							<li><a href="#">Returns</a></li>
							<li><a href="contact.html">Site Map</a></li>
						</ul>
						<ul class="in in1">
							<li><a href="#">Order History</a></li>
							<li><a href="wishlist.html">Wish List</a></li>
							<li><a href="login.html">Login</a></li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<div class="col-md-3 footer-middle-in">
						<h6>Tags</h6>
						<ul class="tag-in">
							<li><a href="#">Lorem</a></li>
							<li><a href="#">Sed</a></li>
							<li><a href="#">Ipsum</a></li>
							<li><a href="#">Contrary</a></li>
							<li><a href="#">Chunk</a></li>
							<li><a href="#">Amet</a></li>
							<li><a href="#">Omnis</a></li>
						</ul>
					</div>
					<div class="col-md-3 footer-middle-in">
						<h6>Newsletter</h6>
						<span>Sign up for News Letter</span>
							<form>
								<input type="text" value="Enter your E-mail" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='Enter your E-mail';}">
								<input type="submit" value="Subscribe">	
							</form>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>		
		</div>
			<div class="footer-bottom">
				<div class="container">
					<ul class="footer-bottom-top">
						<li><a href="#"><img src="images/f1.png" class="img-responsive" alt=""></a></li>
						<li><a href="#"><img src="images/f2.png" class="img-responsive" alt=""></a></li>
						<li><a href="#"><img src="images/f3.png" class="img-responsive" alt=""></a></li>
					</ul>
					<p class="footer-class">Copyright &copy; 2018.&nbsp;星玥制作，盗版必究 </p>
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
		<!--//footer-->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/simpleCart.min.js"> </script>
<!-- slide -->
<script src="js/bootstrap.min.js"></script>
<!--light-box-files -->
<script src="js/jquery.chocolat.js"></script>	
		<link rel="stylesheet" href="css/chocolat.css" type="text/css" media="screen" charset="utf-8">
		<!--light-box-files -->
		<script type="text/javascript" charset="utf-8">
		$(function() {
			$('a.picture').Chocolat();
		});
		</script>
		<!--<script type="text/javascript">
			window.onresize=function()
			{
				var width=$(".carousel img").width();
				$(".item").attr("width","width");
				var top =$(".carousel img").offset().top;
				$(".arrow").attr("margintop","top+width/2")
				
			}
		</script>-->
	<script>
 function A(a,b,c,d){
$("#location1").attr("value",b);
$("#name1").attr("value",c);
$("#phone1").attr("value",d);
$("#location_id").attr("value",a);
	 }
	</script>
</body>
</html>