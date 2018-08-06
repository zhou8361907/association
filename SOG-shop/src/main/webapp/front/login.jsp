<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Login</title>
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<!-- Custom Theme files -->
	<!--theme-style-->
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
	<!--//theme-style-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Shopin Responsive web template, Bootstrap Web Templates, Flat Web Templates, AndroId Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!--theme-style-->
	<link href="css/style4.css" rel="stylesheet" type="text/css" media="all" />	
	   <link href="css/animate.min.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<form class="pure-form">
		<link rel="stylesheet" href="css/pure框架.css" />	
	</form>
	<!--//theme-style-->
	<script src="js/jquery.min.js"></script>
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
</head>
<body>

<!--header-->
<div class="header">
<div class="header">
<div class="container">
		<div class="head">
			<div class=" logo">
				<a href="index.html"><img src="images/logo.png" alt=""></a>	
			</div>
		</div>
	</div>
	<div class="header-top">
		<div class="container-fluid">
		<c:if test="${empty user}">
			<div class="col-md-3 col-md-offset-9  header-login" style="font-size: 15px;font-family:castellar">
				<ul>
				
						<li><a  href="login.jsp">登录</a></li>
						<li><a href="register.jsp">注册</a></li>	
						</ul></div>
						</c:if>				
					
					<c:if test="${not empty user}">
					<div class="col-md-4 col-md-offset-8  header-login" style="font-size: 15px;font-family:castellar">
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
				            <li><a  style="font-size:15px;" class="color" href="index.html">首页</a></li>				            
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
<!--banner-->
<div class="banner-top">
	<div class="container">
		<h1 style="margin-bottom: -5px;">Login</h1>
		<em></em>
		<h2><a href="index.html">Home</a><label>/</label>Login</a></h2>
	</div>
</div>
<!--login-->
<div class="container">
		<div class="login">
		
			<form>
			<div class="col-md-6 login-do">				
					<input class="form-control" id="account" type="text" name="account" placeholder="账号" required="required" style="height: 50px; width: 450px;">
					<i  style="margin-left:415px;top:-35px;font-size: 20px;" class="glyphicon glyphicon-envelope"></i>	</br>				
					<input class="form-control" id="password" type="password" name="password" placeholder="密码" required="required" style="height: 50px; width: 450px;"	>
					<i style="margin-left:415px;top:-35px; font-size: 20px;" class="glyphicon glyphicon-lock"></i></br>				
				    <div class="checkclass">
						<input class="form-control" style="height: 30px; width: 80px;" type="text" placeholder="验证码" required="required" id="check">
						<div style="margin-left:90px;margin-top:-28px" >
							<img  border="0" src="/front/CreateVerServlet"	id="codeimage">

							验证码看不清？点击图片换一张试试<br> <br>
						</div>
					</div>			
					<label class="hvr-skew-backward" id="btnLogin">
						登录					
					</label>
				<!--<div class="">
					<a class="fa fa-qq" href=""></a>
					<a style="font-size: 100px;" class="fa fa-weibo" href=""></a>
				</div>-->
			</div>
			<div class="col-md-6 login-right">
				 <h3>欢迎您的使用</h3>
				 
				 <p>如果您尚未注册账号，可以点击下方按钮前往注册。</p>
				<a href="register.html" class=" hvr-skew-backward">注册</a>

			</div>
			
			<div class="clearfix"> </div>
			</form>
		</div>

</div>

<!--//login-->

			<!--brand-->
		<div class="container">
			<div class="brand">
				<div class="col-md-3 brand-grid">
					<img class="center-block" src="images/brand_01.jpg"
						class="img-responsive" alt="">
				</div>
				<div class="col-md-3 brand-grid">
					<img class="center-block" src="images/brand_02.jpg"
						class="img-responsive" alt="">
				</div>
				<div class="col-md-3 brand-grid">
					<img class="center-block" src="images/brand_03.jpg"
						class="img-responsive" alt="">
				</div>
				<div class="col-md-3 brand-grid">
					<img class="center-block" src="images/brand_04.jpg"
						class="img-responsive" alt="">
				</div>
				<div class="clearfix"></div>
			</div>
			</div>
			<!--//brand-->
			</div>
			
		</div>
	<!--//content-->
		<!--//footer-->
	<div class="footer">
		<div class="footer-middle">
				<div class="container">
					<div class="col-md-3 footer-middle-in">
						<a href="index.html"><img src="images/log.png" alt=""></a>
						<p>Glamour of lipstick monopoly</p>
					</div>
					
					<div class="col-md-3 footer-middle-in">
						<h6>Information</h6>
						<ul class=" in">
							<li><a href="contact.html">Contact Us</a></li>
							<li><a href="#">Team</a></li>
						</ul>
						<ul class="in in1">
							<li><a href="login.html">Login</a></li>
							<li><a href="register.html">Register</a></li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<div class="col-md-3 footer-middle-in">
						<h6>Tags</h6>
						<ul class="tag-in">
							<li><a href="#">Glamour</a></li>
							<li><a href="#">Lipstick</a></li>
							<li><a href="#">Monopoly</a></li>
							<li><a href="#">Secert</a></li>
							<li><a href="#">Makeup</a></li>
							<li><a href="#">Women</a></li>
							<li><a href="#">Elegant</a></li>
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
		<script type="text/javascript">

        var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		}


      document.getElementById("codeimage").onclick=function()
    {
    	// xmlhttp.open("POST","/front/CreateVerServlet",true);
    	 document.getElementById("codeimage").src="/front/CreateVerServlet?"+Math.random();
    	 
	} 
	    document.getElementById("btnLogin").onclick=function()
		    {
		         
		    	var account = document.getElementById("account").value;
				var password = document.getElementById("password").value;
				var codes= document.getElementById("check").value;
				var parentNode=document.querySelector(".login-do"); 
				xmlhttp.open("POST","/front/UserLoginServlet?flag=login",true);
				xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				xmlhttp.send("account="+account+"&password="+password+"&codes="+codes);
				if(account=="")
				{
					showinfo(parentNode,"账号不能为空！")
					return;
				}
			    if(password=="")
				{
					showinfo(parentNode,"密码不能为空！");
					return;
				}
				if(codes=="")
					{
					showinfo(parentNode,"验证码不能为空！");
					return 
					}
				else
				{
					
					xmlhttp.onreadystatechange=function()
				{
					if (xmlhttp.readyState==4 && xmlhttp.status==200)
					{
						if(xmlhttp.responseText=="success"){
							//showinfo(parentNode,"登陆成功");
						    window.location.href="index.jsp";
						}else if(xmlhttp.responseText=="fail1"){
							showinfo(parentNode,"用户名密码不正确，请重新输入！")
							//document.querySelector(".checkbox").innerText="用户名密码不正确";
								
						}

						else if (xmlhttp.responseText=="fail2")
						{
							showinfo(parentNode,"验证码输入错误，请重新输入！");
	
						}
					}
				}
				

			 }
					    
		    }
	    function showinfo(parentNode,info){
			//alert(parentNode.childNodes[1].nodeName==SPAN)
		 	if(parentNode.childNodes[1].nodeName=="SPAN"){
				parentNode.removeChild(parentNode.childNodes[1]); 
			}
			//创建节点
			var node=document.createElement("span");
			var textnode=document.createTextNode(info);
			//添加子节点到父节点
			node.appendChild(textnode);
			node.setAttribute("style","color:red");
			//向第一个元素前插入新节点
			parentNode.insertBefore(node,parentNode.childNodes[1]);
		}	

	</script>
	
</body>
</html>