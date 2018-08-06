package com.sog.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sog.entity.Brand;
import com.sog.entity.Goods;
import com.sog.entity.Image_goods;
import com.sog.entity.Series;
import com.sog.service.BrandsServiceI;
import com.sog.service.BrandsServiceImpl;
import com.sog.service.GoodsServiceI;
import com.sog.service.GoodsServiceImpl;
import com.sog.service.ImageGoodServiceI;
import com.sog.service.ImageGoodServiceImpl;
import com.sog.service.SeriesServiceI;
import com.sog.service.SeriesServiceImpl;

					
@WebServlet("/admin/FinanceServlet")
public class FinanceServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//商品
		GoodsServiceI<Goods> gsi = new GoodsServiceImpl();
		//系列
		SeriesServiceI<Series> ssi = new SeriesServiceImpl();
		//品牌
		BrandsServiceI<Brand> bsi = new BrandsServiceImpl();
		//图片
		ImageGoodServiceI igsi = new ImageGoodServiceImpl();
		
		String flag = request.getParameter("flag");
		
			//显示在这
		try {
			int curPage = 1;
			int pageSize = 15;
			if (null != request.getParameter("curPage")) {
				curPage = Integer.valueOf(request.getParameter("curPage"));
			}
			if (curPage <= 0) {
				curPage = 1;
			}
			
			Map<String,Object> goodMap = gsi.getFour("", curPage, pageSize);
			int pageNum=Integer.valueOf(goodMap.get("pageNum").toString());
			// 通过 request 将获取到的数据传给页面
			if(curPage>=pageNum) {
				curPage=pageNum;
			}
			System.out.println("aaaaa");
			request.setAttribute("map", goodMap);
			request.setAttribute("curPage", curPage);
			// 请求转发
			request.getRequestDispatcher("/admin/finance_manage.jsp").forward(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		

	}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

}
