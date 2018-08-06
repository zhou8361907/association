<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>表头</h1></center>

<h2>确认收货地址</h2>

<c:forEach items="${location_list}" var="loc">
<input type="radio" name="lo"  value="${loc.locationId }">地址：${loc.location }    香蕉电话：${loc.phone }       联系人：${loc.name }</input></br>
<input type="radio" name="fu" value="香蕉">香蕉
</c:forEach>


<h2>确认订单</h2>
	 <table id="product_bar">
		<tr>
			<td>&nbsp;&nbsp;&nbsp; <input type="checkbox"class="all_click" onclick="C_all()">&nbsp;&nbsp;全选</input></td>
			<td>商品信息${user_id }</td>
			<td>单价${choose_list.size() }</td>
			<td>数量${money_all }</td>
			<td>金额</td>
			<td>操作</td>
		</tr>		
	
	</table>
	
	<c:forEach items="${choose_list}" var="choose">
		<div id="shop" class="product_frame">
						<input type="checkbox" class="Checkbox" />
						<img src="images/ch.jpg"/><span class="name" ><a href="">${choose.getGood().goods_name }</a></span>
						<div class="div_two" style="position: absolute;">
							<h3 id="money_one" class="c_money_one">￥${choose.getGood().getGood_sale_price() }</h3>
								<h3 id="money_one" class="c_money_one">数量：${choose.getNumber() }</h3>
							<h3 id="all_money" class="c_all_money">总计￥${choose.getGood().getGood_sale_price()*choose.getNumber() }</h3>
						
						</div>
				</div>
			</div>
	</c:forEach> 
	
	<center><h2>订单总金额${money_all }</h2></center>
	 <form name="form1" action="/front/ChooseServlet" method="post">
	
	 <input type="hidden" name="choose_list" value="${choose_list }"/>
	  <input type="hidden" name="user_id" value="${user_id }"/>
	   <input type="hidden" name="money_all" value="${money_all }"/>

	<center><input type="submit" value="提交订单"/></center>
	
	</form>
</body>
</html>