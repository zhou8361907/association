/******************************月同比*******************************************/
Morris.Bar({
	//加载图表div的id
	element: 'morris-bar-chart',
	data: [{
		y: '2018-01',
		a: 100,
		b: 90
	}, {
		y: '2018-02',
		a: 75,
		b: 65
	}, {
		y: '2018-03',
		a: 50,
		b: 40
	}, {
		y: '2018-04',
		a: 75,
		b: 65
	}, {
		y: '2018-05',
		a: 50,
		b: 40
	}, {
		y: '2018-06',
		a: 75,
		b: 65
	}, {
		y: '2018-07',
		a: 100,
		b: 90
	}],
	xkey: 'y',
	ykeys: ['a', 'b'],
	labels: ['本年度', '上年度'],
	hideHover: 'auto',
	resize: true
});

/***************************月成交量饼图********************************/
Morris.Donut({
	element: 'morris-donut-chart',
	data: [{
		label: "退货订单",
		value: 12
	}, {
		label: "已完成订单",
		value: 30
	}, {
		label: "未完成订单",
		value: 20
	}],
	resize: true
});