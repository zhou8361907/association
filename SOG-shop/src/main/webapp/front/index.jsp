<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Home</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
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
<meta name="keywords"
	content="Shopin Responsive web template, Bootstrap Web Templates, Flat Web Templates, AndroId Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!--theme-style-->
<link href="css/style4.css" rel="stylesheet" type="text/css" media="all" />
<!--//theme-style-->
<script src="js/jquery.min.js"></script>
<script src="js/islider.js" type="text/javascript" charset="utf-8"></script>
<!--- start-rate---->
<script src="js/jstarbox.js"></script>
<link rel="stylesheet" href="css/jstarbox.css" type="text/css"
	media="screen" charset="utf-8" />
<script type="text/javascript">
	jQuery(function() {
		jQuery('.starbox')
				.each(
						function() {
							var starbox = jQuery(this);
							starbox
									.starbox(
											{
												average : starbox
														.attr('data-start-value'),
												changeable : starbox
														.hasClass('unchangeable') ? false
														: starbox
																.hasClass('clickonce') ? 'once'
																: true,
												ghosting : starbox
														.hasClass('ghosting'),
												autoUpdateAverage : starbox
														.hasClass('autoupdate'),
												buttons : starbox
														.hasClass('smooth') ? false
														: starbox
																.attr('data-button-count') || 5,
												stars : starbox
														.attr('data-star-count') || 5
											})
									.bind(
											'starbox-value-changed',
											function(event, value) {
												if (starbox.hasClass('random')) {
													var val = Math.random();
													starbox.next().text(
															' ' + val);
													return val;
												}
											})
						});
	});
</script>
<!---//End-rate---->

</head>
<body>
	<%
		String good1 = "";
		String good2 = "";
		String good3 = "";
		String Image1="";
		String Image2="";
		String Image3="";
		Object obj1 = request.getAttribute("good1");
		Object obj2 = request.getAttribute("good2");
		Object obj3 = request.getAttribute("good3");
		Object obj4 = request.getAttribute("Image1");
		Object obj5 = request.getAttribute("Image2");
		Object obj6 = request.getAttribute("Image3");

		if (null == obj1 || null == obj2 || null == obj3||null == obj4||null == obj5||null == obj6) {
			response.sendRedirect("/front/FrontIndexServlet");
		}
	
	%>
	
	
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
				<div class="clearfix"></div>
			</div>
		</div>

		<div class="container">

			<div class="head-top">

				<div class="col-sm-8 col-md-offset-2 h_menu4">
					<nav class="navbar nav_bottom" role="navigation"> <!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header nav_2">
						<button type="button"
							class="navbar-toggle collapsed navbar-toggle1"
							data-toggle="collapse" data-target="#bs-megadropdown-tabs">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
						<ul class="nav navbar-nav nav_1">
							<li><a style="font-size: 15px;" class="color"
								href="index.jap">首页</a></li>
							<li class="dropdown mega-dropdown active"><a
								style="font-size: 15px;" class="color1" href="#"
								class="dropdown-toggle" data-toggle="dropdown">品牌<span
									class="caret"></span></a>
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
										<div class="clearfix"></div>
									</div>
								</div></li>

							<li><a style="font-size: 15px;" class="color3"
								href="product.jsp">购买</a></li>
							<li><a style="font-size: 15px;" class="color4"
								href="404.html">关于</a></li>
							<!--<li><a class="color5" href="typo.html">Short Codes</a></li>
				-->
							<li><a style="font-size: 15px;" class="color6" href="#">加入我们</a></li>
						</ul>
					</div>
					<!-- /.navbar-collapse --> </nav>
				</div>
			
					<div class="clearfix"></div>
					<link href="css/popuo-box.css" rel="stylesheet" type="text/css"
						media="all" />
					<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
					<!---//pop-up-box---->
					<div id="small-dialog" class="mfp-hide">
						<div class="search-top">
							<div class="login-search">
								<input type="submit" value=""> <input type="text"
									value="Search.." onfocus="this.value = '';"
									onblur="if (this.value == '') {this.value = 'Search..';}">
							</div>
							<p>Shopin</p>
						</div>
					</div>
					<script>
						$(document).ready(function() {
							$('.popup-with-zoom-anim').magnificPopup({
								type : 'inline',
								fixedContentPos : false,
								fixedBgPos : true,
								overflowY : 'auto',
								closeBtnInside : true,
								preloader : false,
								midClick : true,
								removalDelay : 300,
								mainClass : 'my-mfp-zoom-in'
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
	<div id="myCarousel" class="carousel slide">
		<!-- 轮播（Carousel）指标 -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<!-- 轮播（Carousel）项目 -->
		<div class="carousel-inner">
			<div class="item active">
				<img src="images/ba11.jpg" alt="First slide">
				<!--<div class="carousel-caption">标题 1</div>-->
			</div>
			<div class="item">
				<img src="images/ba11.jpg" alt="Second slide">
				<!--<div class="carousel-caption">标题 2</div>-->
			</div>
			<div class="item">
				<img src="images/ba11.jpg" alt="Third slide">
				<!--	<div class="carousel-caption">标题 3</div>-->
			</div>
		</div>
		<!-- 轮播（Carousel）导航 -->
		<a class="arrow" style="margin-left: 1%" href="#myCarousel"
			role="button" data-slide="prev">&lt; </a> <a class="arrow"
			style="margin-left: 96%" href="#myCarousel" role="button"
			data-slide="next">&gt; </a>
	</div>

	<!--content-->
	<div class="content">
		<div class="container">
			<div class="content-top">
				<div class="col-md-6 col-md">
					<div class="col-1">
						<a href="/front/frontGoodsServlet?goods_id=${good1.goods_id }" class="b-link-stroke b-animate-go  thickbox">
							<img src="${Image1.route}"  style="height: 500px;" class="img-responsive" alt="" />
							<div class="b-wrapper1 long-img">
								<p class="b-animate b-from-right    b-delay03 "
									style="font-size: 20px;">纪梵希</p>
								<label class="b-animate b-from-right    b-delay03 "></label>
								<h3 class="b-animate b-from-left    b-delay03 ">${Series1.series_name }</h3>
							</div>
						</a>

			<a href="/front/frontGoodsServlet?goods_id=${good1.goods_id }"><img src="images/pi.jpg" class="img-responsive" alt=""></a>
					</div>
					<div class="col-2">
						<span>畅销</span>
						<h2>
							<a href="single.html">纪梵希&${Series1.series_name }</a>
						</h2>
						<p style="font-size: 20px; color: #4b4b4b;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${good1.describe }
						</p>
						<a href="/front/frontGoodsServlet?goods_id=${good1.goods_id }" class="buy-now" style="font-size: 20px;">点击购买</a>
					</div>
				</div>
				<div class="col-md-6 col-md1">
					<div class="shop col-3"">
						<a href="/front/frontGoodsServlet?goods_id=${good2.goods_id }" class="b-link-stroke b-animate-go  thickbox">
							<img src="${Image2.route}" class="img-responsive" alt="" />
						<div class="b-wrapper1 long-img">
								<p class="b-animate b-from-right    b-delay03 "
									style="font-size: 20px; margin-top: -90px;">阿玛尼</p>
								<label class="b-animate b-from-right    b-delay03 "></label>
								<h3 class="b-animate b-from-left    b-delay03 ">${Series2.series_name }</h3>
							</div>
						</a> </a>
					</div>
					<label class="describe">阿玛尼&${Series2.series_name}</label>
					<p style="display: inline; color: #4b4b4b;">
						&${good2.describe } </p>


					<!--<div class="col-3">
							 <a href="single.html" class="b-link-stroke b-animate-go  thickbox">
		  					 <img src="images/pi2.jpg" class="img-responsive" alt=""/><div class="b-wrapper1 long-img"><p class="b-animate b-from-right    b-delay03 " style="font-size: 20px; margin-top: -90px;">YSL圣罗兰</p><label class="b-animate b-from-right    b-delay03 "></label><h3 class="b-animate b-from-left    b-delay03 ">圆管</h3></div></a>

							<<div class="col-pic">
								<p>YSL圣罗兰</p>
								<label></label>
								<h5>圆管</h5>
							</div></a>							
						</div>-->
					<div class="shop col-3">
						<a href="/front/frontGoodsServlet?goods_id=${good3.goods_id }" class="b-link-stroke b-animate-go  thickbox">
							<img src="${Image3.route}"  class="img-responsive" alt="" />
						<div class="b-wrapper1 long-img">
								<p class="b-animate b-from-right    b-delay03 "
									style="font-size: 20px; margin-top: -90px;">MAC</p>
								<label class="b-animate b-from-right    b-delay03 "></label>
								<h3 class="b-animate b-from-left    b-delay03 ">${Series3.series_name}</h3>
							</div>
						</a>
						<!--
							<div class="col-pic">
								<p>MAC</p>
								<label></label>
								<h5>子弹头</h5>
							</div></a>-->
					</div>
					<label class="describe">MAC&${ Series3.series_name}</label>
					<p style="display: inline; color: #4b4b4b;">
					 ${good3.describe } 
	                </p>
				</div>
				<div class="clearfix"></div>
			</div>
			<!--products-->

			<div class="content-mid">
				<h3>Trending Items</h3>
				<label class="line"></label>
				<div class="mid-popular">
					<c:forEach items="${GoodsArray }" var="goods">
				
								<div class="col-md-3 item-grid simpleCart_shelfItem">
						<div class=" mid-pop">
							<div class="pro-img">
								<img src="${goods.image.route }" style="height:300px;width: 300px" class="img-responsive" alt="">
								<div class="zoom-icon ">
									<a class="picture" href="${goods.image.route }" rel="title"
										class="b-link-stripe b-animate-go  thickbox"><i
										class="glyphicon glyphicon-search icon "></i></a> <a
										href="/front/frontGoodsServlet?goods_id=${goods.goods_id }"><i
										class="glyphicon glyphicon-menu-right icon"></i></a>
								</div>
							</div>
							<div class="mid-1">
								<div class="women">
									<div class="women-top">
										<span>${goods.getBrand().brand_name }</span>
										<h6>
											<a href="/front/frontGoodsServlet?goods_id=${goods.goods_id }" style="font-size:15px">${goods.getSeries().series_name }</a>
										</h6>
									</div>
									<div class="img item_add">
										<a href="#"><img src="images/ca.png" alt=""></a>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="mid-2">
									<p>
										<label>￥${goods.good_sell_price }</label><em class="item_price">￥${goods.good_sale_price }</em>
									</p>
									<div class="block">
										<div class="starbox small ghosting"></div>
									</div>

									<div class="clearfix"></div>
								</div>

							</div>
						</div>
					</div>
					</c:forEach>
					
					<div class="clearfix"></div>
				</div>
				</div>
			<!--//products-->
			<!--brand-->
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
				<div class="col-md-3 brand-grid">
					<img class="center-block" src="images/brand_05.jpg"
						class="img-responsive" alt="">
				</div>
				<div class="col-md-3 brand-grid">
					<img class="center-block" src="images/brand_06.jpg"
						class="img-responsive" alt="">
				</div>
				<div class="col-md-3 brand-grid">
					<img class="center-block" src="images/brand_07.jpg"
						class="img-responsive" alt="">
				</div>
				<div class="col-md-3 brand-grid">
					<img class="center-block" src="images/brand_08.jpg"
						class="img-responsive" alt="">
				</div>
				<div class="clearfix"></div>
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
						<li><a href="#">Contact Us</a></li>
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
						<input type="text" value="Enter your E-mail"
							onfocus="this.value='';"
							onblur="if (this.value == '') {this.value ='Enter your E-mail';}">
						<input type="submit" value="Subscribe">
					</form>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>

		<div class="footer-bottom">
			<div class="container">
				<ul class="footer-bottom-top">
					<li><a href="#"><img src="images/f1.png"
							class="img-responsive" alt=""></a></li>
					<li><a href="#"><img src="images/f2.png"
							class="img-responsive" alt=""></a></li>
					<li><a href="#"><img src="images/f3.png"
							class="img-responsive" alt=""></a></li>
				</ul>
				<p class="footer-class">Copyright &copy; 2018.&nbsp;星玥制作，盗版必究</p>
				<div class="clearfix"></div>
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
	<link rel="stylesheet" href="css/chocolat.css" type="text/css"
		media="screen" charset="utf-8">
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

</body>
</html>