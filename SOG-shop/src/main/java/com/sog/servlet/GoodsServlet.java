package com.sog.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/admin/GoodsServlet")
@MultipartConfig
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
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
		
		if("del".equals(flag)) {			//删除
			try {
				int curPage=Integer.valueOf(request.getParameter("cur"));
				if (gsi.remove(Integer.valueOf(request.getParameter("id")))) {
					response.sendRedirect("/admin/GoodsServlet?curPage="+curPage);
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
			Integer curPage = Integer.valueOf(request.getParameter("cur"));
			System.out.println("aaaaa");
			try {
				List<Goods> list = gsi.getWhere(" and goods_id=" + id); 
				List<Series> seriesList ;
				List<Brand> brandList = bsi.findByAll();

				if (list.size() > 0) {
					Goods goods = list.get(0);
					 
					// 读取角色
					brandList = bsi.findByAll();
					request.setAttribute("brandList", brandList);
					int i = 0 ;
					for(Brand brand:brandList) {
						seriesList = ssi.getWhere(" and brand_id=" + brand.getBrand_id());
						request.setAttribute("seriesList"+i, seriesList);
						i++;
					}
					request.setAttribute("goods", goods);
					request.setAttribute("curs", curPage);
					System.out.println("aaaaa");
					//
					request.getRequestDispatcher("/admin/addgoods.jsp?curPage="+curPage).forward(request, response);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("add".equals(flag)) {		//添加在这转发
			List<Brand> brandList;
			List<Series> seriesList;
			List<Image_goods> imageList;
			List<Goods> goodList;

			try {
				// 读取系列
				
				// 读取品牌
				brandList = bsi.findByAll();
				seriesList = ssi.findByAll();
				Map<String,Object> goodMap = gsi.getFour("",1, 3);
				goodList = (List<Goods>)goodMap.get("list");
				int i = 1;
				for(Brand brand:brandList) {
					seriesList = ssi.getWhere(" and brand_id=" + brand.getBrand_id());
					request.setAttribute("seriesList"+i, seriesList);
					i++;
				}
				request.setAttribute("brandList", brandList);
				// 请求转发
				request.getRequestDispatcher("/admin/addgoods.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {		//显示在这
			
			HttpSession session = request.getSession(); 
			if(null!=request.getParameter("wheresql"))
			{
				session.removeAttribute("goods_query_session");
				session.removeAttribute("series_query_session");
				session.removeAttribute("brands_query_session");
			
			}
			
			
			try {
				int curPage = 1;
				int pageSize = 15;
				if (null != request.getParameter("curPage")) {
					curPage = Integer.valueOf(request.getParameter("curPage"));
				}
				if (curPage <= 0) {
					curPage = 1;
				}
				
				
				String goods_name="";
				String series_name="";
				String brands_name="";
				
				//对session判空 进行赋值。
				if(session.getAttribute("goods_query_session")!=null) {
					goods_name=(String) request.getSession().getAttribute("goods_query_session");
					
				}
				if(session.getAttribute("series_query_session")!=null) {
					series_name=(String) request.getSession().getAttribute("series_query_session");
					
				}
				if(session.getAttribute("brands_query_session")!=null) {
					brands_name=(String) request.getSession().getAttribute("brands_query_session");
					
				}
				if(null!=request.getParameter("query_series")||null!=request.getParameter("query_name")||null!=request.getParameter("query_brands")) {
					
					String query_series=request.getParameter("query_series");
					String query_name=request.getParameter("query_name");
					String query_brands=request.getParameter("query_brands");
					StringBuffer wheresql=new StringBuffer();
					
					//System.out.println(query_name);
					
					if(!query_name.equals("")) {
						byte source [] = query_name.getBytes("iso8859-1");//得到客户机提交的原始数据
						goods_name = new String (query_name.getBytes("iso8859-1"),"UTF-8");//解决乱码
						System.out.println(goods_name);
					}else
					{
						goods_name="";
					}
					if(!query_series.equals("")) {
						byte source [] = query_series.getBytes("iso8859-1");//得到客户机提交的原始数据
						series_name = new String (query_series.getBytes("iso8859-1"),"UTF-8");//解决乱码
						System.out.println(series_name);
					}else
					{
						series_name="";
					}
					if(!query_brands.equals("")) {
						byte source [] = query_brands.getBytes("iso8859-1");//得到客户机提交的原始数据
						brands_name = new String (query_brands.getBytes("iso8859-1"),"UTF-8");//解决乱码
						System.out.println(brands_name);
					}else
					{
						brands_name="";
					}
					session.setAttribute("series_query_session", series_name); 
					session.setAttribute("goods_query_session", goods_name); 
					session.setAttribute("brands_query_session", brands_name); 
				}

				
				
				Map<String,Object> goodMap = gsi.like_qurey(goods_name, series_name, brands_name, curPage, pageSize);
				int pageNum=Integer.valueOf(goodMap.get("pageNum").toString());
				// 通过 request 将获取到的数据传给页面
				if(curPage>=pageNum) {
					curPage=pageNum;
				}
				if(curPage<=0) {
					curPage=1;
				}
				goodMap = gsi.like_qurey(goods_name, series_name, brands_name, curPage, pageSize);
				
				
				request.setAttribute("map", goodMap);
				request.setAttribute("curPage", curPage);
				request.setAttribute("goods_name", goods_name);
				request.setAttribute("series_name", series_name);
				request.setAttribute("brands_name", brands_name);
				// 请求转发
				request.getRequestDispatcher("/admin/goods.jsp").forward(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//商品
		GoodsServiceI gsi = new GoodsServiceImpl();
		//图片
		ImageGoodServiceI igsi = new ImageGoodServiceImpl();
				
		System.out.println("aaa");
		String flag = request.getParameter("flag");

		String id = request.getParameter("id");
		
		if(null != id && !id.equals("")) {
			
			String good_name = request.getParameter("good_name");
			String series_name = request.getParameter("series_name");
			String brand_name = request.getParameter("brand_name");
			String txtEffect = request.getParameter("txtEffect");
			String txtStore = request.getParameter("txtStore");
			int curPage=Integer.valueOf(request.getParameter("cur"));

			Goods good = new Goods();
			good.setGoods_id(Integer.valueOf(id));
			good.setGoods_name(good_name);
			good.setSeries_id(Integer.valueOf(series_name));
			good.setEffect(txtEffect);
			good.setStore_number(Integer.valueOf(txtStore));
			good.setGood_buy_price(BigDecimal.valueOf(205.18));
			good.setGood_sell_price(BigDecimal.valueOf(500.10));
			good.setGood_sale_price(BigDecimal.valueOf(400.10));
			good.setIf_onsale(false);
			good.setAlert_num(105);
			good.setProducing_area("Manchester");
			good.setColor(good_name);
			good.setDescribe("hen ");
			try {
				if (gsi.modify(good)) {
					response.sendRedirect("/admin/GoodsServlet?curPage="+curPage);
				} else {
					response.getWriter().write("修改失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("add".equals(flag)) {

			String good_name = request.getParameter("good_name");
			String series_name = request.getParameter("series_name");
			String brand_name = request.getParameter("brand_name");
			String txtEffect = request.getParameter("txtEffect");
			String txtStore = request.getParameter("txtStore");
			
			System.out.println(series_name+"-------------------");
			//创建goods对象
			Goods good = new Goods();
			good.setGoods_name(good_name);
			good.setSeries_id(Integer.valueOf(series_name));
			good.setEffect(txtEffect);
			good.setStore_number(Integer.valueOf(txtStore));
			good.setGood_buy_price(BigDecimal.valueOf(205.18));
			good.setGood_sell_price(BigDecimal.valueOf(500.10));
			good.setGood_sale_price(BigDecimal.valueOf(400.10));
			good.setIf_onsale(false);
			good.setAlert_num(105);
			good.setProducing_area("Manchester");
			good.setColor(good_name);
			good.setDescribe("hen ");
			
			//添加图片
			//获取请求参数一定要写在开始，否则会出现乱码。
			// 获取输出流
			PrintWriter out = response.getWriter();
			// Part对象
			Part part = request.getPart("route");
			// 获取HTTP头信息headerInfo=（form-data; name="file" filename="文件名"）
			String headerInfo = part.getHeader("content-disposition");

			// 从HTTP头信息中获取文件名fileName=（文件名）
			String fileName = headerInfo.substring(headerInfo.lastIndexOf("=") + 2, headerInfo.length() - 1);
			// 获取扩展名
			String ext = fileName.substring(fileName.lastIndexOf("."), fileName.length());

			long filename = new Date().getTime();

			// 获得存储上传文件的文件夹路径 web目录
			String fileSavingFolder = this.getServletContext().getRealPath("/images_good");
			// long fileName=
			// 获得存储上传文件的完整路径（文件夹路径+文件名）
			// 文件夹位置固定，文件夹采用与上传文件的原始名字相同
			String fileSavingPath = fileSavingFolder + File.separator + filename + ext;
			// 将文件路径存入数据库
			Image_goods image = new Image_goods();
			image.setRoute(File.separator+"images_good"+File.separator + filename + ext);
			image.setSort(1);					

			try {
				if(gsi.add(good)) {
					Goods goods = (Goods)gsi.getWhere(" and goods_name='" + good_name + "'").get(0);
					image.setGoods_id(Integer.valueOf(goods.getGoods_id()));
					if(igsi.add(image)) {
						// 如果存储上传文件的文件夹不存在，则创建文件夹
						File f = new File(fileSavingFolder + File.separator);
						// 如果文件不存在则创建
						if (!f.exists()) {
							f.mkdirs();
						}
						System.out.println(part);
						System.out.println(fileSavingPath);
						// 将上传的文件内容写入服务器文件中
						part.write(fileSavingPath);				
						response.sendRedirect("/admin/GoodsServlet");	
						
					}else {
						response.getWriter().write("添加商品图片失败");
					}
				}else {
					response.getWriter().write("添加商品失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}else if("exist".equals(flag)) {
			
		}				
		

	}

}
