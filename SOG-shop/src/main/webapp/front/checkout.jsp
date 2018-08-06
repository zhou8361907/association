<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Checkout</title>
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
<!--//theme-style-->
<script src="js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/checkout.css	"/>
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
	<script type="text/javascript">
//			点击全选按钮事件点击次数
            var num=0;//记录
			function C_all(){
				if(num%2==0){
					$(".Checkbox").prop("checked",true);
					$(".all_click").prop("checked",true);						
					num++;
					$("#p1 span").innerHTML="";
				}
				else{
					$(".Checkbox").prop("checked",false);
					$(".all_click").prop("checked",false);	
					num++;					
				}
			}
			function Delete(){
				var del=document.getElementsByClassName('Checkbox')
				var arr=new Array();
				var num1=0;//记录数组长度
				for(var i=0;i<del.length;i++)
				{
					if(del[i].checked)
					{	
				document.getElementById(del[i].parentNode.id).remove();
				i--;
					}
				}
			}		
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
				    <div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
				        <ul class="nav navbar-nav nav_1">
				            <li><a style="font-size:15px;" class="color" href="index.jsp">首页</a></li>
				            
				    		<li class="dropdown mega-dropdown active">
							    <a  style="font-size:15px;"  class="color1" href="#" class="dropdown-toggle" data-toggle="dropdown">品牌<span class="caret"></span></a>				
								<div class="dropdown-menu ">
				                    <div class="menu-top">
										<div class="col1">
											<div class="h_nav">
													<ul>
														<li><a href="brand.jsp">香奈儿</a></li>
														<li><a href="brand.jsp">迪奥</a></li>
														<li><a href="brand.jsp">ysl</a></li>
														
														
													</ul>	
											</div>							
										</div>
										<div class="col1">
											<div class="h_nav">
												<ul>
													<li><a href="brand.jsp">纪梵希</a></li>
													<li><a href="brand.jsp">Tom Ford</a></li>
													<li><a href="brand.jsp">MAC</a></li>
													
													
												</ul>	
											</div>							
										</div>
										<div class="col1">
											<div class="h_nav">
												<ul>
													<li><a href="brand.jsp">雅诗兰黛</a></li>
													<li><a href="brand.jsp">巴宝莉</a></li>
													<li><a href="brand.jsp">阿玛尼</a></li>
																						
												</ul>								
											</div>							
										</div>
										<div class="col1">
											<div class="h_nav">												
												<ul>
													<li><a href="brand.jsp">CPB</a></li>
													<li><a href="brand.jsp">兰蔻</a></li>
													<li><a href="brand.jsp">娇兰</a></li>
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
							
							<li  ><a  style="font-size:15px;"  class="color3" href="product.jsp">出售</a></li>
							<li ><a  style="font-size:15px;"  class="color4" href="404.html">关于</a></li>
				            <!--<li><a class="color5" href="typo.html">Short Codes</a></li>
				-->           
							<li ><a  style="font-size:15px;"  class="color6" href="contact.html">加入我们</a></li>
				        </ul>
				     </div><!-- /.navbar-collapse -->
				
				</nav>
			</div>
		
					<div class="clearfix"> </div>
					
						<!----->

						<!---pop-up-box---->					  
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
<!--<div class="banner-top">
	<div class="container">
		<h1>购物车</h1>
		<em></em>
		<h2><a href="index.html">首页</a><label>/</label>购物车</a></h2>
	</div>
</div>-->
<!--login-->
	<script>$(document).ready(function(c) {
					$('.close1').on('click', function(c){
						$('.cart-header').fadeOut('slow', function(c){
							$('.cart-header').remove();
						});
						});	  
					});
			   </script>
<script>$(document).ready(function(c) {
					$('.close2').on('click', function(c){
						$('.cart-header1').fadeOut('slow', function(c){
							$('.cart-header1').remove();
						});
						});	  
					});
			   </script>
			   <script>$(document).ready(function(c) {
					$('.close3').on('click', function(c){
						$('.cart-header2').fadeOut('slow', function(c){
							$('.cart-header2').remove();
						});
						});	  
					});
			  </script>			   
 <table id="product_bar" class="col-lg-offset-1" style="width: 73rem;">
		<tr>
			<td>&nbsp;&nbsp;&nbsp; <input type="checkbox"class="all_click" onclick="C_all()">&nbsp;&nbsp;全选</input></td>
			<td>商品信息</td>
			<td>单价</td>
			<td>数量</td>
			<td>金额</td>
			<td>操作</td>
		</tr>		
	</table>
<div id="biankuang" data-spy="scroll" data-target="#myScrollspy" data-offset="0"
     style="height:auto;overflow:auto; position: relative;">    
    	<div class="container col-lg-offset-1 ">
    	
    	<c:forEach items="${list}" var="choose">
    		<div class="section"> 
    		
				<div id="shop" class="product_frame">
						<input type="checkbox" class="Checkbox" />
						<img style="margin-left: 12%" src="images/ch.jpg"/><span class="name" style="margin-left:-30px" ><a href="/front/frontGoodsServlet?goods_id=${choose.getGood().goods_id }">${choose.getGood().goods_name }      </a></span>
						<div class="div_two" style="position: absolute;">
							<h3 style="margin-left: 200px" id="money_one${choose.getChoose_id() }" class="c_money_one">￥${choose.getGood().getGood_sale_price() }</h3>
							<button style="margin-left: 95px" id="reduce${choose.getChoose_id() }" class="c_reduce" onclick="reduce(${choose.getChoose_id() })">-</button><input type="text" id="num${choose.getChoose_id() }" class="textvalue" readonly="readonly" value="${choose.getNumber() }"/><button id="add${choose.getChoose_id() }" onclick="add(${choose.getChoose_id() })">+</button>
							<h3 id="all_money${choose.getChoose_id() }" class="c_all_money">￥${choose.getNumber() * choose.getGood().getGood_sale_price() }</h3>
							<a  style="margin-left:60px; background-color: white" id="btnDelete" href="javascript:void(0)" >删除</a>
							<input id="btndelete" type="hidden" value="${choose.getChoose_id() }" />	
							</div>
				</div>
			</div>
    	</c:forEach>	
		</div>	
</div>	
<!-- 描述：底部全选按钮，及结算按钮样式  -->
		<div class="product_frame1 col-lg-offset-1"style="width: 73rem;margin-bottom: 100px;">
                                                                         
			<input type="checkbox" class="all_click"" onclick="C_all()" />&nbsp;&nbsp;全选
			<a href="javascript:void(0);" onclick="Delete()">删除</a>			
			<p style="display: inline;" id="p1">已选商品<span id="shopnum" style="color: red;">0</span>件</p>
			<p style="display: inline;" id="p2">合计（不含运费）<span id="allmoney" style="color: red;">0.00</span>元</p>
			 <form name="form1" action="/front/ChooseServlet" >
		  	 <input type="hidden"  id="user_id" name="user_id" value="${user.user_id}">
			 <input type="hidden"  name="flag" value="balance">
			 <input type="hidden"  id="car_check_list" name="car_check_list" value=0 >
			 <input type="hidden"  id="car_num_list" name="car_num_list" value=0>
			 <input type="hidden"  id="money_all" name="money_all" value=0>
			 <button type="submit" class="btn btn-danger" style="position:relative;margin-left: 85%;margin-top: -3rem;">结算</button>
			  
			</form>
	</div>
<!--//login-->
<!--brand-->
		
	<!--//content-->
	<!--//footer-->
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
			<div class="footer-bottom">
				<div class="container">
					<ul class="footer-bottom-top">
						<li><a href="#"><img src="images/f1.png" class="img-responsive" alt=""></a></li>
						<li><a href="#"><img src="images/f2.png" class="img-responsive" alt=""></a></li>
						<li><a href="#"><img src="images/f3.png" class="img-responsive" alt=""></a></li>
					</ul>
					<p class="footer-class">Copyright &copy; 2016.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
		<!--//footer-->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

	<script src="js/simpleCart.min.js"> </script>
		<script type="text/javascript">
		var ch_id_list=new Array();//存放在购物车里的所有choose_id
		var check_list=new Array();//存放被选中的所有choose_id；
		var num_list=new Array();//存放被选的数量；
		<c:forEach items="${list}" var="a"> 
		ch_id_list.push(${a.choose_id }); //生成如 array.push(123)的字符串 这样前台拿到后就是js 
		</c:forEach> 

			
			function update(){
				var del=document.getElementsByClassName("Checkbox");
				var value=document.getElementsByClassName("textvalue");
				var money=document.getElementsByClassName("c_all_money");
				var arr=new Array();
				var num1=0;<!--//记录数组长度-->
				var shopnum=0;<!--//记录总件数-->
				var moneynum=0; //纪录总钱数
				var mid_variable;//<!--中间变量-->
				
				
				for(var i=0;i<del.length;i++)
				{
					if(del[i].checked)
					{	
					check_list[num1]=ch_id_list[num1];
					num_list[num1]=document.getElementById("num"+check_list[num1]).value;
					document.getElementById("car_check_list").value=check_list;
					document.getElementById("car_num_list").value=num_list;
					arr[num1]=i;
					num1++;					
					}
				}
				for(var i=0;i<num1;i++){
					 	
					 	mid_variable=arr[i];
					 	arr[i]=value[mid_variable].value;					 	
					 	arr[num1+i]=money[mid_variable].innerHTML.substring(1);					 	
						
				}
					for(var i=0;i<num1;i++){					 	
					 shopnum=parseInt(shopnum)+parseInt(arr[i]);						
					 moneynum=parseInt(moneynum)+parseInt(arr[num1+i])				
					 
				}
					document.getElementById("allmoney").innerHTML=moneynum.toFixed(2); 	
					document.getElementById("shopnum").innerHTML=shopnum;		
					document.getElementById("money_all").value=moneynum.toFixed(2);
			}
			$("input:checkbox").click(function() {
				update();
			})	
		function Det(a){	
	
		
	    var size=${list.size()};
	    for( var i= 0;i<size;i++)
		    {
				if(ch_id_list[i]==a){
					document.getElementById("shop"+a ).remove();
				}
		    }
	    
		}
		function add(a){

			var size=${list.size()};
		    for( var i= 0;i<size;i++)
			    {
		    	
					if(ch_id_list[i]==a){

						
						var num;
						var money=document.getElementById("money_one"+a  ).innerHTML;	
						var money_one=money.substring(1,money.length);		
						num=document.getElementById("num"+a).value;						
						if(num<=9)
						{	
							num++;
						}
						else{
							alert("不好意思，我们一次最多只可以购买10个")
						}
						document.getElementById("num"+a).value=num;
						document.getElementById("all_money"+a).innerHTML="￥"+(money_one*num).toFixed(2);
						update();
					}
			    }

			
	
		}
		function reduce(a){

			var size=${list.size()};
		    for( var i= 0;i<size;i++)
			    {
		    	
					if(ch_id_list[i]==a){

						var num;
						num=document.getElementById("num"+a).value;
						if(num>1)
						{
							num--;
						}			
						document.getElementById("num"+a).value=num;
						var money=document.getElementById("money_one"+a).innerHTML;				
						var money_one=money.substring(1,money.length);			
						document.getElementById("all_money"+a).innerHTML="￥"+(money_one*num).toFixed(2);
						update();

					}


			    }	
		}
		
	</script>- slide -->
	 <script src="js/bootstrap.min.js"></script>
 <script src="js/admin.js"></script>
<script type="text/javascript">
				$(document).ready(function(){
					var num=$(".product_frame");					
					if(num.length>2)
						{							
							$("#biankuang").css("height","450px");
						}
					else{
						$("#biankuang").css("height","auto");
						}
					})
			</script> 
 <script type="text/javascript">

        var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		}
		   $("#btnDelete").click(function()
		    {			   
			var choose_id = document.getElementById("btndelete").value;
		
		
			xmlhttp.open("Post","/front/ChooseServlet?flag=delete",true);
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xmlhttp.send("choose_id="+ choose_id.toString());
				xmlhttp.onreadystatechange=function()
			{
					if(xmlhttp.responseText=="success"){
						
					    window.location.href="/front/ChooseServlet?user_id="+${user.user_id};
					}else if(xmlhttp.responseText=="fail"){
						showinfo(parentNode,"用户名密码不正确，请重新输入！");
							
					}
			}
			})
		   
	</script>
			
</body>
</html>
