package com.sog.servlet;

import java.io.IOException;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sog.entity.Admin;
import com.sog.entity.Brand;
import com.sog.entity.Goods;
import com.sog.entity.Image_goods;
import com.sog.entity.Series;
import com.sog.service.AdminServiceI;
import com.sog.service.AdminServiceImpl;
import com.sog.service.BrandsServiceI;
import com.sog.service.BrandsServiceImpl;
import com.sog.service.SeriesServiceI;
import com.sog.service.SeriesServiceImpl;

/**
 * 
 * @类名 SeriesServlet
 * @描述 TODO(一句话描述类的作用)
 * @作者 王帅
 * @日期 2018年6月30日 上午10:40:56
 *
 */

@WebServlet("/admin/SeriesServlet")
public class SeriesServlet extends HttpServlet {       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//系列
		SeriesServiceI ssi = new SeriesServiceImpl();
		//品牌
		BrandsServiceI bsi = new BrandsServiceImpl();
		
		String flag = request.getParameter("flag");
		
		if("del".equals(flag)) {			//删除
			try {
				if (ssi.remove(Integer.valueOf(request.getParameter("id")))) {
					int pageSize=7;
					int curPage=Integer.valueOf(request.getParameter("cur"));	
					System.out.println(curPage+":"+pageSize);
					Map<String, Object> map = ssi.getSeriesAndBrand(curPage, pageSize);
					int pageNum=Integer.valueOf(map.get("pageNum").toString());
					
					if(curPage>=pageNum) {
						curPage=pageNum;
					}
					//当记录全部删除时，pageNUm=0,导致curPage=0,分页查询的函数第二个参数不允许curPage=0，所以检测当curPage=0，令为1；
					if(curPage<=0) {
						curPage=1;
					}
					//这里对map和page再次赋值，是当前页面的记录全部删除后，需要重新获取map,否则就会显示没有记录的那一页
					map = ssi.getSeriesAndBrand(curPage, pageSize);
					pageNum=Integer.valueOf(map.get("pageNum").toString());		
					System.out.println(curPage+":"+pageSize);
					
					request.setAttribute("map", map);
					request.setAttribute("curPage", curPage);
					request.getRequestDispatcher("/admin/series.jsp").forward(request, response);
				} else {
					response.getWriter().write("修改失败");
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("edit".equals(flag)) {		//编辑
			Integer id = Integer.valueOf(request.getParameter("id"));
			Integer cur = Integer.valueOf(request.getParameter("cur"));
			System.out.println("aaaaa");
			try {
				List<Series> list = ssi.getWhere(" and series_id= "+id);
				List<Brand> brandList;
				System.out.println(list.size());
				if (list.size() > 0) {
					Series series = list.get(0);
					request.setAttribute("series", series);
					request.setAttribute("cur", cur);
					// 读取角色
					brandList = bsi.findByAll();
					request.setAttribute("brandList", brandList);
					System.out.println("aaaaa");
					//
					request.getRequestDispatcher("/admin/addSeries.jsp").forward(request, response);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("add".equals(flag)) {		//添加在这转发
			List<Brand> brandList;
			try {
				// 读取角色
				brandList = bsi.findByAll();
				request.setAttribute("brandList", brandList);
				// 请求转发
				request.getRequestDispatcher("/admin/addSeries.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {		//显示在这
			try {
				int curPage = 1;
				int pageSize = 7;
				if (null != request.getParameter("curPage")) {
					curPage = Integer.valueOf(request.getParameter("curPage"));
				}
				if (curPage <= 0) {
					curPage = 1;
				}
				
				Map<String,Object> adminMap = ssi.getSeriesAndBrand(curPage, pageSize);
				int pageNum=Integer.valueOf(adminMap.get("pageNum").toString());
				// 通过 request 将获取到的数据传给页面
				if(curPage>=pageNum) {
					curPage=pageNum;
				}
				System.out.println("aaaaa");
				request.setAttribute("map", adminMap);
				request.setAttribute("curPage", curPage);
				// 请求转发
				request.getRequestDispatcher("/admin/series.jsp").forward(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//系列
				SeriesServiceI ssi = new SeriesServiceImpl();
				System.out.println("aaa");
				String flag = request.getParameter("flag");

				String id = request.getParameter("id");
				
				if(null != id && !id.equals("")) {
					System.out.println(id);
					String series_name = request.getParameter("txtSeries");
					String brand_name = request.getParameter("brand_name");
					String sort = request.getParameter("sort");
					Series series = new Series();
					Integer cur = Integer.valueOf(request.getParameter("cur"));
					series.setSeries_id(Integer.valueOf(id));
					series.setSeries_name(series_name);
					series.setBrand_id(Integer.valueOf(brand_name));
					series.setSort_level(Integer.valueOf(sort));
					
					try {
						if (ssi.modify(series)) {
							response.sendRedirect("/admin/SeriesServlet?curPage="+cur);
						} else {
							response.getWriter().write("修改失败");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else if("add".equals(flag)) {
					String txtSeries = request.getParameter("txtSeries");
					String brand_name = request.getParameter("brand_name");
					String sort = request.getParameter("sort");
					
					//创建series对象
					Series series=new Series();
					series.setBrand_id(Integer.valueOf(brand_name));
					series.setSeries_name(txtSeries);
					series.setSort_level(Integer.valueOf(sort));
					try {
						if(ssi.add(series)) {
							response.sendRedirect("/admin/SeriesServlet");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}else if("exist".equals(flag)) {
					
				}				
				
		}
	}

