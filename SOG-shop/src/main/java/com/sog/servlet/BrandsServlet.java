package com.sog.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sog.entity.Brand;
import com.sog.entity.Goods;
import com.sog.service.BrandsServiceI;
import com.sog.service.BrandsServiceImpl;
import com.sog.service.GoodsServiceI;
import com.sog.service.GoodsServiceImpl;

@WebServlet("/admin/BrandsServlet")

public class BrandsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if(null!=request.getParameter("flag")){
			
			
			if("del".equals(request.getParameter("flag"))) {
				BrandsServiceI<Brand> bsi=new BrandsServiceImpl();
				int brand_id=Integer.valueOf(request.getParameter("brand_id"));
				
				int curPage=Integer.valueOf(request.getParameter("cur"));
				int pageSize=6;
				try {
					if(bsi.remove(brand_id)) {
						Map<String, Object> map = bsi.getPageAll("", curPage, pageSize);
						int pageNum=Integer.valueOf(map.get("pageNum").toString());
						if(curPage>=pageNum) {
							curPage=pageNum;
						}
						//当记录全部删除时，pageNUm=0,导致curPage=0,分页查询的函数第二个参数不允许curPage=0，所以检测当curPage=0，令为1；
						if(curPage<=0) {
							curPage=1;
						}
						//这里对map和page再次赋值，是当前页面的记录全部删除后，需要重新获取map,否则就会显示没有记录的那一页
						map = bsi.getPageAll("",curPage, pageSize);
						pageNum=Integer.valueOf(map.get("pageNum").toString());	
						request.setAttribute("map", map);
						request.setAttribute("curPage", curPage);
					
						request.getRequestDispatcher("/admin/brands.jsp").forward(request, response);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if("edit".equals(request.getParameter("flag"))) {
				BrandsServiceI<Brand> bsi=new BrandsServiceImpl();
				Integer brand_id = Integer.valueOf(request.getParameter("brand_id"));
				Integer cur = Integer.valueOf(request.getParameter("cur"));
				try {
					List<Brand> list=bsi.GetIdBrands( brand_id );
					
					if (list.size() > 0) {
						Brand b = list.get(0);
						request.setAttribute("brands", b);
						request.setAttribute("cur", cur);
						request.getRequestDispatcher("/admin/addbrands.jsp").forward(request, response);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
	}
	else {
		BrandsServiceI<Brand> bsi=new BrandsServiceImpl();

		
		try {
			int curPage=1;
			int pageSize=6;
			if (null != request.getParameter("curPage")) {
				curPage = Integer.valueOf(request.getParameter("curPage"));
			}
			if (curPage <= 0) {
				curPage = 1;
			}
			
			Map<String, Object> map = bsi.getPageAll("", curPage, pageSize);
			int pageNum=Integer.valueOf(map.get("pageNum").toString());
			if(curPage>=pageNum) {
				curPage=pageNum;
			}
			request.setAttribute("map", map);
			request.setAttribute("curPage", curPage);
			//System.out.print(userlist.size());
			request.getRequestDispatcher("/admin/brands.jsp").forward(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BrandsServiceI<Brand> bsi=new BrandsServiceImpl();
		
		String brand_id=request.getParameter("brandsId");
		String brand_name=request.getParameter("brandsName");
		
		String brand_country=request.getParameter("brandsCountry");
	    String brand_level=request.getParameter("brandsLevel");
		
		
		
		if(null!=brand_id && !brand_id.equals(""))
		{
			Brand b=new Brand();
			b.setBrand_id(Integer.valueOf(brand_id));
			b.setBrand_name( brand_name);
			b.setBrand_country(brand_country);
			b.setBrand_level(Integer.valueOf(brand_level).intValue());
			Integer cur = Integer.valueOf(request.getParameter("cur"));
			try {
				if (bsi.modify(b)) {
					response.sendRedirect("/admin/BrandsServlet?curPage="+cur);
				} else {
					response.getWriter().write("修改失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			Brand b=new Brand();
			b.setBrand_name( brand_name);
			b.setBrand_country(brand_country);
			b.setBrand_level(Integer.valueOf(brand_level).intValue());
			try{
				if(bsi.add(b)) {
					response.sendRedirect("/admin/BrandsServlet");
				}else {
					response.getWriter().write("添加失败");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
	}


