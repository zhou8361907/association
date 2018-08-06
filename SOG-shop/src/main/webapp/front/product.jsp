<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Products</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Shopin Responsive web template, Bootstrap Web Templates, Flat Web Templates, AndroId Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--theme-style-->
<link href="css/style4.css" rel="stylesheet" type="text/css" media="all" />
<!--//theme-style-->
<script src="js/jquery.min.js"></script>
<script src="js/prototype.js"></script>
<!--- start-rate---->
<script src="js/jstarbox.js"></script>
<script src="js/prototype.js"></script>
<link rel="stylesheet" href="css/jstarbox.css" type="text/css"
	media="screen" charset="utf-8" />
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
<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<%
		String sizenum = "";
		
		Object obj1 = request.getAttribute("sizenum");

		if (null == obj1 ) {
			response.sendRedirect("/front/ProductsServlet?seid=0");
		}
	
	%>
	<!--header-->
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
				<div class="col-md-3 col-md-offset-9  header-login"
					style="font-size: 15px; font-family: castellar">
					<ul>
						<li><a href="login.html">登录</a></li>
						<li><a href="register.html">注册</a></li>
						<li><a href="checkout.html">购物车</a></li>
					</ul>
				</div>

				<div class="clearfix"></div>
			</div>
		</div>

		<div class="container">

			<div class="head-top">

				<div class="col-sm-8 col-md-offset-2 h_menu4">
					<nav class="navbar nav_bottom" role="navigation">

						<!-- Brand and toggle get grouped for better mobile display -->
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
									href="index.html">首页</a></li>
								<li class="dropdown mega-dropdown active"><a
									style="font-size: 15px;" class="color1" href="#"
									class="dropdown-toggle" data-toggle="dropdown">品牌<span
										class="caret"></span></a>
									<div class="dropdown-menu ">
										<div class="menu-top">
											<div class="col1">
												<div class="h_nav">
													<ul>
														<li><a href="brand.html">YSL</a></li>
														<li><a href="brand.html">迪奥</a></li>
														<li><a href="brand.html">香奈儿</a></li>

													</ul>
												</div>
											</div>
											<div class="col1">
												<div class="h_nav">
													<ul>
														<li><a href="brand.html">MAC</a></li>
														<li><a href="brand.html">兰蔻</a></li>
														<li><a href="brand.html">纪梵希</a></li>


													</ul>
												</div>
											</div>
											<div class="col1">
												<div class="h_nav">
													<ul>
														<li><a href="brand.html">CPB</a></li>
														<li><a href="brand.html">娇兰</a></li>
														<li><a href="brand.html">阿玛尼</a></li>

													</ul>
												</div>
											</div>
											<div class="col1">
												<div class="h_nav">
													<ul>
														<li><a href="brand.html">巴宝莉</a></li>
														<li><a href="brand.html">雅诗兰黛</a></li>
														<li><a href="brand.html">Tom Ford</a></li>
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
									href="product.html">购买</a></li>
								<li><a style="font-size: 15px;" class="color4"
									href="404.html">关于</a></li>
								<!--<li><a class="color5" href="typo.html">Short Codes</a></li>
				-->
								<li><a style="font-size: 15px;" class="color6" href="#">加入我们</a></li>
							</ul>
						</div>
						<!-- /.navbar-collapse -->

					</nav>
				</div>
				<div class="col-sm-2 search-right">
					<ul class="heart">
						<li><a href="checkout.html"> <span
								class="glyphicon glyphicon-heart" aria-hidden="true"></span>
						</a></li>
						<li><a class="play-icon popup-with-zoom-anim"
							href="#small-dialog"><i class="glyphicon glyphicon-search">
							</i></a></li>
					</ul>
					<div class="cart box_1">
						<a href="checkout.html">
							<h3 style="text-align: center;">
								<img src="images/cart.png" alt="" />
							</h3>
						</a>
						<p style="text-align: center;">
							<a href="javascript:;" class="simpleCart_empty">清空购物车</a>
						</p>

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
			<h1>Products</h1>
			<em></em>
			<h2>
				<a href="index.html">Home</a><label>/</label>Products</a>
			</h2>
		</div>
	</div>
	<!--content-->
	<div class="product" id="produ">
		<div class="container">
			<div class="col-md-9">
				<div class="mid-popular" id="addpro">
					<c:forEach items="${productsArray}" var="product"
						varStatus="status">

						<div class="col-md-4 item-grid1 simpleCart_shelfItem">
							<div class=" mid-pop">
								<div class="pro-img">
									<img src="${product.image.route}" style="height: 300px;weight:300px" class="img-responsive" alt=""
										id="01">
									<div class="zoom-icon ">
										<a class="picture" href="images/pi.png" rel="title"
											class="b-link-stripe b-animate-go  thickbox"><i
											class="glyphicon glyphicon-search icon "></i></a> <a
											href="single.html"><i
											class="glyphicon glyphicon-menu-right icon"></i></a>
									</div>
								</div>
								<div class="mid-1">
									<div class="women">
										<div class="women-top">
											<span id="02">${product.brand.brand_name}</span>
											<h6>
												<a href="single.html" id="03">${product.series.series_name}</a>
											</h6>
										</div>
										<div class="img item_add">
											<a href="#"><img src="images/ca.png" alt=""></a>
										</div>
										<div class="clearfix"></div>
									</div>
									<div class="mid-2">
										<p>
											<label id="04">￥${product.good_sell_price }</label><em
												class="item_price">￥${product.good_sale_price }</em>
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

			<div class="col-md-3 product-bottom">
				<!--categories-->

				<div id="pinpai">
					<h4 class="cate">品牌</h4>
					<ul class="menu-drop">
						<li class="item1"><span id="1id">YSL</span></li>
						<li class="item1">阿玛尼 </li>
						<li class="item1"><a href="#">雅诗兰黛</a></li>

					</ul>
					<h4 class="cate">系列</h4>
					<ul class="menu-drop">
						<li class="item1"><a href="#">YSL1 </a></li>
						<li class="item1"><a href="#">YSL </a></li>
						<li class="item1"><a href="#">YSL2 </a></li>

					</ul>
				</div>
				<!--initiate accordion-->
				<script type="text/javascript">
							$(function() {
							    var menu_ul = $('.menu-drop > li > ul'),
							           menu_a  = $('.menu-drop > li > a');
							    menu_ul.hide();
							    menu_a.click(function(e) {
							        e.preventDefault();
							        if(!$(this).hasClass('active')) {
							            menu_a.removeClass('active');
							            menu_ul.filter(':visible').slideUp('normal');
							            $(this).addClass('active').next().stop(true,true).slideDown('normal');
							        } else {
							            $(this).removeClass('active');
							            $(this).next().stop(true,true).slideUp('normal');
							        }
							    });
							
							});
						</script>
			</div>
		</div class="clearfix">
	</div>
	<!--products-->

	<!--//products-->
	<!--brand-->


	</div>
	<div class="footer" style="margin-top: 150px;">
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
	<script type="text/javascript">
			$(window).scroll(function(){
				var distance = $(document).scrollTop();
				if(distance>480)
				{					
					$("#pinpai").css("position","fixed");
					$("#pinpai").css("top","30px");
				}
				if(distance<480)
				{					
					$("#pinpai").css("position","static");
					$("#pinpai").css("top","30px");
				}
			})
		</script>
	<script type="text/javascript">

        var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		}
		 document.getElementById("1id").onclick=function()
		    {
			    var seid= document.getElementById("1id").value;
			    var parentNode=document.querySelector(".product"); 
		    	 xmlhttp.open("GET","/front/ProductsServlet?seid=1",true);
		    	 xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		         xmlhttp.send(null);
					// alert("传过去了");
						xmlhttp.onreadystatechange=function()
						{
							if (xmlhttp.readyState==4 && xmlhttp.status==200)
							{
						    var tableInfos=document.getElementById("addpro");
						  code="";
							var json =xmlhttp.responseText;
							var json1=json.evalJSON(); 
							for(var i=0;i<json1.length;i++)
								{
								code+='<div class="col-md-4 item-grid1 simpleCart_shelfItem">' + '<div class=" mid-pop">'
								+ '<div class="pro-img">' + '<img src='+json1[i].image.route+'  class="img-responsive" style="height:300px;weight:300px" alt="">' 
								+'<div class="zoom-icon">' + '<a class="picture" href="images/pi.png" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>'
								+ '<a href="single.html"><i class="glyphicon glyphicon-menu-right icon"></i></a>'
								+ '</div></div><div class="mid-1"> <div class="women">  <div class="women-top">' + '<span id="02">'+json1[i].brand.brand_name+"  </span>" +
								'<h6><a href="single.html" id="03">'+json1[i].series.series_name
								+'</a></h6></div><div class="img item_add"><a href="#"><img src="images/ca.png" alt=""></a>' +
								 '</div><div class="clearfix"></div></div><div class="mid-2"><p ><label id="04">￥' +
								json1[i].good_sell_price+ ' </label><em class="item_price">' + "￥" +json1[i].good_sale_price
								+'</em></p> <div class="block"><div class="starbox small ghosting"> </div>'
								+'</div><div class="clearfix"></div></div></div></div></div>';
	
                               

								}
                      
							tableInfos.innerHTML=code;
							/* for(var i=0;i<json1.length;i++)
							{  for(var key in json1[0])
                              {
                              alert(json1[0].brand.brand_name+"hahaahahahahaha");
                              };
							} */
								/* if(xmlhttp.responseText=="success"){
							    window.location.href="/front/product.jsp"; 
								}
 */                    
							 
						
							}
						}
			} 

		</script>
</body>
</html>