<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page import="java.util.*" %>
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
 <link rel="stylesheet" type="text/css" href="css/My_Order.css"/>
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Shopin Responsive web template, Bootstrap Web Templates, Flat Web Templates, AndroId Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--theme-style-->
<link href="css/style4.css" rel="stylesheet" type="text/css" media="all" />	
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
		<div class="container-fluid">
		<c:if test="${empty user}">
			<div  class="col-md-3 col-md-offset-9  header-login" style="font-size: 15px;font-family:castellar">
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
	<div class="row">
		<div class="title" style="height: 300px;">
			<div class="title1 col-md-offset-2 col-md-9">
				<div class="title2">
					<span class="text">所有订单</span>
					<span class="num"></span>
					<span id="frame1">&emsp;</span>
				</div>
				<div class="title2">
					<span class="text">待付款</span>
					<span class="num"></span>
					<span id="frame1">&emsp;</span>
				</div>
				<div class="title2">
					<span class="text">待发货</span>
					<span class="num"></span>
					<span id="frame1">&emsp;</span>
				</div>
				<div class="title2">
					<span class="text">待收货</span>
					<span class="num"></span>
					<span id="frame1">&emsp;</span>
				</div>
				<div class="title2">
					<span class="text">待评价</span>
					<span class="num"></span>
					<span id="frame1">&emsp;</span>
				</div>
			</div>
			<div class="shop_description col-md-offset-2 col-md-9">
				<span style="margin-left: 15%;">宝贝</span>
				<span style="margin-left: 15%">单价(元)</span>
				<span style="margin-left: 5%;">数量（个）</span>
				<span style="margin-left: 5%;">实付款（元）</span>
				<span style="margin-left: 5%;">交易状态</span>
				<span style="margin-left: 15%;">交易操作</span>			
			</div>
				<c:forEach items="${order_list }" var="order">
				
				
				
				<form action="/front/frontOrdersServlet">
				<input type="hidden" name="flag" value="pay">
				<input type="hidden" name="user_id" value="${user.user_id }">
				<input type="hidden" name="order_id" value="${order.orderId }">
					<div class="modal" id="mymodal-data" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
					 <div class="modal-dialog">
					 <div class="modal-content">
					  <div class="modal-header">
					  <button type="button" class="close" data-dismiss="modal">
					   <span aria-hidden="true">×</span>
					   <span class="sr-only">Close</span>
					  </button>
					  <h4 class="modal-title">总计￥${order.sumMoney}</h4>
					  </div>
					<center><img alt="" src="/front/images/tow_pay.png"></center>
					  <div class="modal-footer">
					  
					  <button id="baocun" type="submit" class="btn btn-primary">保存</button>
					  </div>
					 </div>
					 </div>
					</div>
					</form>
				
				
				
				<form action="/front/frontOrdersServlet">
				<input type="hidden" name="user_id" value="${user.user_id }">
				<input type="hidden" name="order_id" value="${order.orderId }">
				<div class="shop col-md-offset-2 col-md-9">
				<div class="shop_top">
					&emsp;<input type="checkbox" />
					<span class="data">${order.beginTime }</span>"		&emsp;
					<span>订单号:</span>
					<span class=" Order_number ">${order.orderId }</span>
				</div>
				<c:forEach items="${order.getContentList() }" var="content">
				
				<div class="shop_bottom">
					<img src="images/pc1.jpg" alt="" />
					<span class="money" >￥<span class="univalent">${content.goods.good_sale_price }</span></span>
					<span class="num">${content.order_number }</span><span></span>
					<span class="money2">￥</span><span class="true_money">${content.goods.good_sale_price * content.order_number}</span>
					<a href="/front/frontGoodsServlet?goods_id=${content.goods.goods_id }">${content.goods.goods_name }</a>
					<div class="state">
							<c:if test="${order.orderStage==0}">
							<span class="payment">买家未付款</span></br>
							<span class="delivery">仓库未发货</span>
							</c:if>
							<c:if test="${order.orderStage==1}">
							<span class="payment">买家已付款</span></br>
							<span class="delivery">仓库未发货</span>
							</c:if>
							<c:if test="${order.orderStage==2}">
							<span class="payment">买家已付款</span></br>
							<span class="delivery">仓库已发货</span>
							</c:if>
							<c:if test="${order.orderStage==3}">
							<span class="payment">买家已付款</span></br>
							<span class="delivery">仓库已发货</span>
							</c:if>
							
							<c:if test="${order.orderStage==5}">
							<span class="payment">买家已付款</span></br>
							<span class="delivery">已收货</span>
							</c:if>
							<c:if test="${order.orderStage==6}">
							<span class="payment">买家已付款</span></br>
							<span class="delivery">已收货</span>
							<span class="delivery">已评价</span>
							</c:if>
					
					</div>
					<c:if test="${order.orderStage==0}">
					
					
					 <button type="button"  id="but1" class="btn goods btn-primary delete" data-toggle="modal"data-target="#mymodal-data" data-whatever="@mdo" onclick="a()"> 付款</button>
							</c:if>
							<c:if test="${order.orderStage==1}">
							<input type="hidden" name="flag" value="returs">
							<button class="goods btn	 btn-navbar" id="but" type="submit">提醒发货</button>
							</c:if>
							<c:if test="${order.orderStage==2}">
							<input type="hidden" name="flag" value="take">
							<button class="goods btn	 btn-navbar" id="but" type="submit">退货</button>
							</c:if>
							<c:if test="${order.orderStage==3}">
							<input type="hidden" name="flag" value="sign">
							<button class="goods btn	 btn-navbar" id="but" type="submit">确认收货</button>
							</c:if>
							
							<c:if test="${order.orderStage==5}">
							<input type="hidden" name="flag" value="comments">
								
							<button class="goods btn	 btn-navbar" id="but" type="submit">评价</button>
							</c:if>
							<c:if test="${order.orderStage==6}">
						
								
							<button class="goods btn	 btn-navbar" id="but" >已评价</button>
							</c:if>
					
				</div>
				</c:forEach>
				</form>
			</div>
				</c:forEach>
			

			<div class="col-md-offset-2 col-md-9" style="height: 80px;"></div>
		</div>
	</div>
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
			$(".title2").click(function(){
				$(".title2").css({"border-bottom":"1px solid #dddddd"})
				$(this).css({"border-bottom":"2px solid red"});
			})
		</script>
	<script type="text/javascript">
			$(".title2").click(function(){
				$(".title2").css({"border-bottom":"1px solid #dddddd"})
				$(this).css({"border-bottom":"2px solid red"});
			})
		</script>
		<script type="text/javascript">
			$(".title2").click(function(){
			var text_content=$(this).children("span").get(0).innerHTML;
			var payment=document.getElementsByClassName("payment");
			var delivery=document.getElementsByClassName("delivery");
			var shop=document.getElementsByClassName("shop");
			var btn=document.getElementsByClassName("goods");
			$(".shop").hide();			
			if(text_content=="所有订单")
			{				
				$(".shop").show();
			}
			if(text_content=="待付款")
			{
				for(var i=0;i<payment.length;i++)
				{	
					if(payment[i].innerHTML=="买家未付款")
					{	
						
					$(payment[i]).parent().parent().parent().show()	;				
					}
				}
			}
			if(text_content=="待发货")
			{
				for(var i=0;i<payment.length;i++)
				{	
					if(delivery[i].innerHTML=="仓库未发货"&&payment[i].innerHTML!="买家未付款")
					{						
					$(delivery[i]).parent().parent().parent().show();							
					}
				}
			}
			if(text_content=="待收货")
			{
				for(var i=0;i<payment.length;i++)
				{	
					if(btn[i].innerHTML=="确认收货")
					{						
						$(btn[i]).parent().parent().show()					
					}
				}
			}
			if(text_content=="待评价")
			{
				for(var i=0;i<payment.length;i++)
				{	
					if(btn[i].innerHTML=="评价")
					{						
						$(btn[i]).parent().parent().show()					
					}
				}
			}			
			})
		</script>
		<script type="text/javascript">
			$(".goods").click(function(){				
				if($(this).html()=="确认收货")
				{
					$(this).parent().parent().children().children("button").html("待评价");

				}
				
			})
		</script>
		
		<script type="text/javascript">
			var xmlhttp;
			if(window.XMLHttpRequest){
					xmlhttp=new XMLHttpRequest();

				}
			document.querySelector("#btn").onclick=function(){
					alert("aaa");
				}



			
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

<script type="text/javascript">
	function a(){		var i = 15;//定义倒计时的总时间为5s
		var xx = window.setInterval(tt, 1000);
		function tt(){
	　i--;　　
		　　if(i == 0){
			
		　　window.clearInterval(xx);
		　　document.getElementById("baocun").click(); 

		}}
	}
		
	
	　　//这个链接写自己想要跳转到链接
	
	　　
</script>
</body>
</html>