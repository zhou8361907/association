<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zh-CN">

	<head>
		<meta charset="UTF-8">
		<title>商品管理</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="style/index.css" />
		<script src="js/jquery.min.js"></script>

		<body style="background-color: #F5F5DC;">
		
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<h1 class="page-header">
                          	商品管理
                          	<c:if test="${goods==null}">
								<small>添加商品</small>
							</c:if>
							<c:if test="${not empty goods}">
								<small>编辑商品</small>
							</c:if>
                          	 
                     </h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<!-- 用户列表--bootstrap高级表格使用 -->
						<div class="panel panel-success">
							<c:if test="${admin==null}">
								<div class="panel-heading col-md-6" >添加商品</div>
							</c:if>
							<c:if test="${not empty admin}">
								<div class="panel-heading col-md-6" >编辑商品</div>
							</c:if>
							<div class="panel-heading col-md-6" style="text-align: right; height: 41px;">
								<a href="/admin/GoodsServlet">
								<button type="button" id="btnBack" class="btn btn-success" style="margin-top:-7px">返回</button>
								</a>
							</div>
							<br><br>
							<div class="panel-body">
								<form action="/admin/GoodsServlet?flag=add" method="post" enctype="multipart/form-data">
							
					             <input type="hidden"  name="id" value="${goods.goods_id}">
								<input type="hidden" name="cur" value="${curs}">
									<div class="form-group">
										<label for="good_name">商品色号</label>
										<input type="text" class="form-control" id="good_name" placeholder="名称" name="good_name" value="${goods.color}">
									</div>
									
									<div class="form-group">								
										<label for="brand_name">所属品牌</label> 
										<select id="brand_name"	name="brand_name" class="form-control">
											<c:forEach items="${brandList}" var="brand">												
												<c:if test="${brand.brand_name == goods.brand.brand_name}">
													<option value="${brand.brand_id}" selected="selected">${brand.brand_name}</option>
												</c:if>
												<c:if test="${brand.brand_name != goods.brand.brand_name }">
													<option value="${brand.brand_id}">${brand.brand_name}</option>
												</c:if>
											</c:forEach>
										</select>
									</div>	
									
									<div class="form-group">								
										<label for="series_name">所属系列</label> 
										<select id="series_name" name="series_name" class="form-control">											
											<c:forEach items="${seriesList1}" var="series">											
												<c:if test="${series.series_name == goods.series.series_name}">
													<option value="${series.series_id}" selected="selected">${series.series_name}</option>
												</c:if>
												<c:if test="${series.series_name != goods.series.series_name }">
													<option value="${series.series_id}">${series.series_name}</option>
												</c:if>
											</c:forEach>
										</select>
									</div>										
										
									<c:if test="${goods==null}">
										<div class="form-group">
											<label for="route">图片路径</label> 
											<input type="file"
												name="route" value="" class="form-control"
												id="route">
										</div>
									</c:if>
									
									
									<div class="form-group">
										<label for="txtEffect">功效</label>
										<input type="text" class="form-control" id="txtEffect" placeholder="功效" name="txtEffect" value="${goods.effect}" >
									</div>
									
									<div class="form-group">
										<label for="txtStore">库存</label>
										<input type="text" class="form-control" id="txtStore" placeholder="库存" name="txtStore" value="${goods.store_number}" >
									</div>
									
									
									<button type="submit" class="btn btn-success">保存</button>
									<button type="reset" class="btn btn-info">重置</button>
								</form>
							</div>
						</div>
					</div>
					<!--表格结束 -->
				</div>
			</div>
		</body>
		<script type="text/javascript">
			$("#brand_name").change(function(){
				$("#series_name").empty();
				var id = $("#brand_name").val();
				if(id == 1){
					<c:forEach items="${seriesList1}" var="series">						
						$("#series_name").append("<option value='${series.series_id}'>${series.series_name}</option>")
					</c:forEach> 
				}
				if(id == 2){
					<c:forEach items="${seriesList2}" var="series">						
						$("#series_name").append("<option value='${series.series_id}'>${series.series_name}</option>")
					</c:forEach> 
				}
				if(id == 3){
					<c:forEach items="${seriesList3}" var="series">						
						$("#series_name").append("<option value='${series.series_id}'>${series.series_name}</option>")
					</c:forEach> 
				}
				if(id == 4){
					<c:forEach items="${seriesList4}" var="series">						
						$("#series_name").append("<option value='${series.series_id}'>${series.series_name}</option>")
					</c:forEach> 
				}
				if(id == 5){
					<c:forEach items="${seriesList5}" var="series">						
						$("#series_name").append("<option value='${series.series_id}'>${series.series_name}</option>")
					</c:forEach> 
				}
				if(id == 6){
					<c:forEach items="${seriesList6}" var="series">						
						$("#series_name").append("<option value='${series.series_id}'>${series.series_name}</option>")
					</c:forEach> 
				}
				if(id == 7){
					<c:forEach items="${seriesList7}" var="series">						
						$("#series_name").append("<option value='${series.series_id}'>${series.series_name}</option>")
					</c:forEach> 
				}
				if(id == 8){
					<c:forEach items="${seriesList8}" var="series">						
						$("#series_name").append("<option value='${series.series_id}'>${series.series_name}</option>")
					</c:forEach> 
				}
				if(id == 9){
					<c:forEach items="${seriesList9}" var="series">						
						$("#series_name").append("<option value='${series.series_id}'>${series.series_name}</option>")
					</c:forEach> 
				}
				if(id == 10){
					<c:forEach items="${seriesList10}" var="series">						
						$("#series_name").append("<option value='${series.series_id}'>${series.series_name}</option>")
					</c:forEach> 
				}
				if(id == 11){
					<c:forEach items="${seriesList11}" var="series">						
						$("#series_name").append("<option value='${series.series_id}'>${series.series_name}</option>")
					</c:forEach> 
				}
				if(id == 12){
					<c:forEach items="${seriesList12}" var="series">						
						$("#series_name").append("<option value='${series.series_id}'>${series.series_name}</option>")
					</c:forEach> 
				}
			})
			
		</script>
		
		
		
		
		
		
		
		
		
</html>