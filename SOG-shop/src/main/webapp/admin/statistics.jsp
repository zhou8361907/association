<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="UTF-8">
		<title>统计图表</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/index.css">
	</head>

	<body>
		<div class="container" style="margin-top: 10px;">
			<div class="row">
				<div class="col-md-3 col-sm-12 col-xs-12">
					<div class="panel panel-primary text-center no-boder bg-color-green">
						<div class="panel-body">
							<i class="glyphicon glyphicon-shopping-cart fa fa-5x"></i>
							<h3>${order_number }</h3>
						</div>
						<div class="panel-footer back-footer-green">
							订单数量
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-12 col-xs-12">
					<div class="panel panel-primary text-center no-boder bg-color-blue">
						<div class="panel-body">
							<i class="glyphicon glyphicon-yen glyphicon fa fa-5x"></i>
							<h3>${order_money } </h3>
						</div>
						<div class="panel-footer back-footer-blue">
							成交金额
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-12 col-xs-12">
					<div class="panel panel-primary text-center no-boder bg-color-red">
						<div class="panel-body">
							<i class="glyphicon glyphicon-retweet fa fa-5x "></i>
							<h3>${wait_pay } </h3>
						</div>
						<div class="panel-footer back-footer-red">
							待付款订单
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-12 col-xs-12">
					<div class="panel panel-primary text-center no-boder bg-color-brown">
						<div class="panel-body">
							<i class="glyphicon glyphicon-bed fa fa-5x"></i>
							<h3>${wait_com } </h3>
						</div>
						<div class="panel-footer back-footer-brown">
							待发货订单
						</div>
					</div>
				</div>
			</div>

			<!--条图-->
			<div class="row">

				<div class="col-md-9 col-sm-12 col-xs-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							月订单统计图
						</div>
						<div class="panel-body">
							<div id="morris-bar-chart"></div>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-12 col-xs-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							月成交量统计图
						</div>
						<div class="panel-body">
							<div id="morris-donut-chart"></div>
						</div>
					</div>
				</div>

			</div>
		</div>

		<!--引入js-->
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<!-- 图表插件 Js -->
		<script src="js/raphael-2.1.0.min.js"></script>
		<script src="js/morris.js"></script>
		<script type="text/javascript" src="js/charts.js" ></script>
	</body>

</html>