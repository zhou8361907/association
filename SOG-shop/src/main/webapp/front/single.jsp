<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!DOCTYPE html>
<html>
<head>
<title>Single</title>
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
<link rel="stylesheet" type="text/css" href="css/single.css"/>
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
<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
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
							<li ><a  style="font-size:15px;" class="color6" href="contact.html">加入我们</a></li>
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
		<h1>Single</h1>
		<em></em>
		<h2><a href="index.html">Home</a><label>/</label>Single</a></h2>
	</div>
</div>
<div class="single">

<div class="container">
<div class="col-md-9">
	<div class="col-md-5 grid">		
		<div class="flexslider">
			  <ul class="slides">
			    <li id="img2" data-thumb="images/Lipstick.png">
			        <div class="thumb-image"> <img  id="img1" src="images/Lipstick.png 	" data-imagezoom="true" class="img-responsive">			       
			        </div> 
			    </li>
			    <li data-thumb="images/Use effect.png">
			         <div class="thumb-image"> <img src="images/Use effect.png" data-imagezoom="true" class="img-responsive"> </div>
			    </li>
			    <li data-thumb="images/color.png">
			       <div class="thumb-image"> <img src="images/color.png" data-imagezoom="true" class="img-responsive"> </div>
			    </li> 
			  </ul>
		</div>
	</div>	
<div class="col-md-7 single-top-in">
						<div class="span_2_of_a1 simpleCart_shelfItem">
				<h3>${goods.goods_name }</h3>
				<p class="in-para">${goods.describe }</p>
			    <div class="price_single">
				  <span class="reducedfrom item_price">￥${goods.good_sale_price }</span>				
				 <div class="clearfix"></div>
				</div>				
				<div style="height: auto;">
					<div class="row" style="">
					
						<c:forEach items="${goods_list}" var="good">									
						<div class="col-lg-4"><a class="xielie" style="margin-top:5px;margin-bottom:5px;display: block;text-align: center;border: 1px solid #dddddd;color:#aaaaaa;" href="/front/frontGoodsServlet?goods_id=${good.goods_id }" class="col-lg-4 col-lg-offset-0" >${good.color }</a>
							</div>			
						</c:forEach>
					</div>
				
				</div>
			    <div class="wish-list">
				 
				 </div>
				 <div class="quantity"> 
								<div class="quantity-select">                           
									<div class="entry value-minus">&nbsp;</div>
									<div class="entry value" ><span>1</span></div>
									<div class="entry value-plus active">&nbsp;</div>
								</div>
							</div>
							<!--quantity-->
							<script type="text/javascript">
								function A() {
									alert(1);
							          var type = (slider.vars.controlNav === "thumbnails") ? 'control-thumbs' : 'control-paging',
							              j = 1,
							              item,
							              slide;
							
							          slider.controlNavScaffold = $('<ol class="'+ namespace + 'control-nav ' + namespace + type + '"></ol>');
							
							          if (slider.pagingCount > 1) {
							            for (var i = 0; i < slider.pagingCount; i++) {
							              slide = slider.slides.eq(i);
							              item = (slider.vars.controlNav === "thumbnails") ? '<img src="' + slide.attr( 'data-thumb' ) + '"/>' : '<a>' + j + '</a>';
							              if ( 'thumbnails' === slider.vars.controlNav && true === slider.vars.thumbCaptions ) {
							                var captn = slide.attr( 'data-thumbcaption' );
							                
							                if ( '' !== captn && undefined !== captn ) { item += '<span class="' + namespace + 'caption">' + captn + '</span>'; }
							              }
							              slider.controlNavScaffold.append('<li>' + item + '</li>');
							              j++;
							            }
							          }
							
							          // CONTROLSCONTAINER:
							          (slider.controlsContainer) ? $(slider.controlsContainer).append(slider.controlNavScaffold) : slider.append(slider.controlNavScaffold);
							          methods.controlNav.set();
							
							          methods.controlNav.active();
							
							          slider.controlNavScaffold.delegate('a, img', eventType, function(event) {
							            event.preventDefault();
							
							            if (watchedEvent === "" || watchedEvent === event.type) {
							              var $this = $(this),
							                  target = slider.controlNav.index($this);
							
							              if (!$this.hasClass(namespace + 'active')) {
							                slider.direction = (target > slider.currentSlide) ? "next" : "prev";
							                slider.flexAnimate(target, slider.vars.pauseOnAction);
							              }
							            }							
							            // setup flags to prevent event duplication
							            if (watchedEvent === "") {
							              watchedEvent = event.type;
							            }
							            methods.setToClearWatchedEvent();
							
							          });
							        }
        
							</script>
							<script type="text/javascript">
								function img_change(a){
								 document.getElementById("img1").src="images/back.jpg";								
								 $("#image").attr("src","images/back.jpg")
								 
								}
							</script>
							
	<script>
    $('.value-plus').on('click', function(){
    	var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10)+1;
    	divUpd.text(newVal);
    	document.getElementById("number").value=newVal;
      	document.getElementById("number1").value=newVal;
    });

    $('.value-minus').on('click', function(){
    	var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10)-1;
    	if(newVal>=1) divUpd.text(newVal);
    	document.getElementById("number").value=newVal;
    	document.getElementById("number1").value=newVal;
    });
	</script>
	<!--quantity-->
				 <form name="form1" action="/front/ChooseServlet" method="post" >
				  <input type="hidden"  name="goods_id" value="${goods.goods_id }">
 					<input type="hidden"  name="user_id" value="${user.user_id }" >
 					<input type="hidden"  name="number" id="number" value="1">
 					 <a href="javascript:document.form2.submit();" class="add-to item_add hvr-skew-backward">直接购买</a>
			    <a href="javascript:document.form1.submit();" class="add-to item_add hvr-skew-backward">加入购物车</a>
			    </form>
			     <form name="form2" action="/front/ChooseServlet" method="post" >
				    <input type="hidden"  name="goods_id" value="${goods.goods_id }">
 					<input type="hidden"  name="flag" value="buy">
 					<input type="hidden"  name="number" id="number1" value="1">
 					<input type="hidden"  name="user_id" value="${user.user_id }" >
 					 </form>
			<div class="clearfix"> </div>
			</div>
		
					</div>
			<div class="clearfix"> </div>
			<!---->
			
 			 <div class="clearfix"></div>
  </div>
			<!---->	
</div>
<!----->

<!--brand-->	

			<!--//brand-->
</div>
	
		<div class="comment">
			<h3 id="user_reviews" style="margin-bottom: 100px">用户评论</h3>
			
			<h5 id="evaluate">总评价&emsp;&emsp;&emsp;<span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span>&emsp;&emsp;&emsp;&emsp;共有${comment_list.size() }条评价</h5>
			
		</div>		
		<c:forEach items="${comment_list}" var="comment">		
		
			<div class="pingjia" style="height: auto;">
				<div class="row">
				<div class="user_img col-lg-1"><img src="images/brand_02.jpg" alt="" /></div>
					<div class="introduce col-lg-offset-3 col-lg-8">					
						<lable class="lable1">&emsp;效果好&emsp;</lable>&emsp;&emsp;<lable class="lable1">&emsp;物流快&emsp;</lable>&emsp;&emsp;<lable class="lable1">&emsp;包装完好&emsp;</lable>
						<div class="div1">
							<lable class="lable2">${comment.commentContent }</lable>
						</div></br>
							<lable class="lable2">线上购买</lable></br>
							<lable class="lable2">${comment.commentTime }</lable></br>
							<lable class="lable2"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span></lable>
					</div>	
				</div>
			</div>
			
			
			
			
		</c:forEach>
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
<script src="js/imagezoom.js"></script>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script defer src="js/jquery.flexslider.js"></script>
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />

<script>
// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    controlNav: "thumbnails"
  });
});
</script>

	<script src="js/simpleCart.min.js"> </script>
<!-- slide -->
<script src="js/bootstrap.min.js"></script>


</body>
</html>