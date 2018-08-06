package com.sog.servlet;

import java.awt.Image;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.alibaba.fastjson.JSON;
import com.sog.dao.BrandSeriesDaoI;
import com.sog.dao.BrandSeriesDaoImpl;
import com.sog.entity.Goods;
import com.sog.entity.Image_goods;
import com.sog.entity.Series;
import com.sog.service.ImageGoodServiceI;
import com.sog.service.ImageGoodServiceImpl;

/**
 * Servlet implementation class ProductsServlet
 */
@WebServlet("/front/ProductsServlet")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 BrandSeriesDaoI<Series> bsdi=new BrandSeriesDaoImpl();
		 ImageGoodServiceI<Image_goods> igsi = new ImageGoodServiceImpl();
		 String seid=request.getParameter("seid");
		 Integer seidnum= Integer.valueOf(seid);
		 System.out.println("标识符"+seidnum);
		 try {
			 if(seidnum!=0)
			 {				 
				 
				    List<Goods> golist= bsdi.findgoodsByBrand("group by series.series_id and brand.brand_id="+seidnum);
				    System.out.println(golist.size()+"第一个品牌商品个数");
				    System.out.println(JSON.toJSON(golist).toString());
				    response.setContentType("application/json;charset=utf-8"); 
				    PrintWriter writer = response.getWriter();
				    writer.append(JSON.toJSON(golist).toString());
				   
				   /*JSONArray jsonArray=new JSONArray();*/
				 /*JSONArray jsonArray = JSONArray.fromObject(golist);
				    String json = jsonArray.toString();
*/				/*    response.setContentType("application/json; charset=utf-8");*/
				  /*  PrintWriter out =ServletActionContext.getResponse().getWriter();//获取PrintWriter对象
				    out.print(json);//把json字符串返回的页面 
*/				/*	response.setCharacterEncoding("UTF-8");  
					  
					PrintWriter writer = response.getWriter();
					writer.append(json);
				    
				    request.setAttribute("productsArray", golist);
					request.setAttribute("sizenum", golist.size());
					response.getWriter().write("success");*/
					/*request.getRequestDispatcher("/front/product.jsp").forward(request, response);*/
			 }
			 else{
				 List<Goods> golist= bsdi.findgoodsByBrand("group by series_id");
			  System.out.println(golist.size()+"商品个数");
			  System.out.println(golist.get(0).getSeries().getSeries_name()+"第一个品牌个数");
				request.setAttribute("productsArray", golist);
				request.setAttribute("sizenum", golist.size());
				request.getRequestDispatcher("/front/product.jsp").forward(request, response);
			 }
		 }
		 catch (Exception e) {
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
