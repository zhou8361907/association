package com.sog.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sog.dao.GoodsDaoI;
import com.sog.dao.GoodsDaoImpl;
import com.sog.dao.Image_goodsDaoI;
import com.sog.dao.Image_goodsDaoImpl;
import com.sog.entity.Admin;
import com.sog.entity.Goods;
import com.sog.entity.Image_goods;
import com.sog.entity.Roles;
import com.sog.service.GoodsServiceI;
import com.sog.service.GoodsServiceImpl;
import com.sog.service.ImageGoodServiceI;
import com.sog.service.ImageGoodServiceImpl;


/**
 * 
 * @类名 ImageGoodServlet
 * @描述 TODO(一句话描述类的作用)
 * @作者 王帅
 * @日期 2018年6月30日 上午12:08:23
 *
 */
@WebServlet("/admin/ImageGoodServlet")
@MultipartConfig
public class ImageGoodServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//图片
		ImageGoodServiceI igsi = new ImageGoodServiceImpl();
		//商品
		GoodsServiceI gsi = new GoodsServiceImpl();
		
		String flag = request.getParameter("flag");
		
		if("del".equals(flag)) {			//删除
			try {
				if (igsi.remove(Integer.valueOf(request.getParameter("id")))) {
					int pageSize=3;
					int curPage=Integer.valueOf(request.getParameter("cur"));
					Map<String,Object> adminMap = igsi.getImageAndGoodPageAll(curPage, pageSize);
					int pageNum=Integer.valueOf(adminMap.get("pageNum").toString());
					if(curPage>=pageNum) {
						curPage=pageNum;
					}
					//当记录全部删除时，pageNUm=0,导致curPage=0,分页查询的函数第二个参数不允许curPage=0，所以检测当curPage=0，令为1；
					if(curPage<=0) {
						curPage=1;
					}
					
					adminMap =  igsi.getImageAndGoodPageAll(curPage, pageSize);
					pageNum=Integer.valueOf(adminMap.get("pageNum").toString());
					
					request.setAttribute("map", adminMap);
					request.setAttribute("curPage", curPage);
					request.getRequestDispatcher("/admin/image_manage.jsp").forward(request, response);;
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
				List<Image_goods> list = igsi.getWhere(" and image_id= "+id);
				List<Goods> goodList;
				System.out.println(list.size());
				if (list.size() > 0) {
					Image_goods image_goods = list.get(0);
					request.setAttribute("image", image_goods);
					// 读取角色
					goodList = gsi.findByAll();
					request.setAttribute("goodList", goodList);
					request.setAttribute("cur", cur);
					//
					request.getRequestDispatcher("/admin/addImage.jsp").forward(request, response);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("add".equals(flag)) {		//添加在这转发
			List<Goods> goodList;
			try {
				// 读取角色
				goodList = gsi.findByAll();
				request.setAttribute("goodList", goodList);
				// 请求转发
				request.getRequestDispatcher("/admin/addImage.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {		//显示在这
			try {
				int curPage = 1;
				int pageSize = 3;
				if (null != request.getParameter("curPage")) {
					curPage = Integer.valueOf(request.getParameter("curPage"));
				}
				if (curPage <= 0) {
					curPage = 1;
				}
				
				Map<String,Object> adminMap = igsi.getImageAndGoodPageAll(curPage, pageSize);
				int pageNum=Integer.valueOf(adminMap.get("pageNum").toString());
				// 通过 request 将获取到的数据传给页面
				if(curPage>=pageNum) {
					curPage=pageNum;
				}
				System.out.println("aaaaa");
				request.setAttribute("map", adminMap);
				request.setAttribute("curPage", curPage);
				// 请求转发
				request.getRequestDispatcher("/admin/image_manage.jsp").forward(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ImageGoodServiceI igsi = new ImageGoodServiceImpl();
	
		String flag = request.getParameter("flag");
		String id = request.getParameter("id");
		
		
		if(null != id && !id.equals("")) {//修改在这
			String goods_id = request.getParameter("good_name");
			String route = request.getParameter("route");
			String sort = request.getParameter("sort");
			Image_goods image_goods = new Image_goods();
			image_goods.setImage_id(Integer.valueOf(id));
			image_goods.setGoods_id(Integer.valueOf(goods_id));
			
			image_goods.setSort(Integer.valueOf(sort));
			
			// 获得存储上传文件的文件夹路径 web目录
			String fileSavingFolder = this.getServletContext().getRealPath("/images_good");
			Part part = request.getPart("route");
			String headerInfo = part.getHeader("content-disposition");
			// 从HTTP头信息中获取文件名fileName=（文件名）
			String fileName = headerInfo.substring(headerInfo.lastIndexOf("=") + 2, headerInfo.length() - 1);
			long filename = new Date().getTime();
			// 获取扩展名
			String ext = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			String fileSavingPath = fileSavingFolder + File.separator + filename + ext;
			System.out.println(fileSavingPath);
			image_goods.setRoute(File.separator+"images_good"+File.separator + filename + ext);
			

			Integer cur = Integer.valueOf(request.getParameter("cur"));
			try {
				if (igsi.modify(image_goods)) {
					// 如果存储上传文件的文件夹不存在，则创建文件夹
					File f = new File(fileSavingFolder + File.separator);
					// 如果文件不存在则创建
					if (!f.exists()) {
						f.mkdirs();
					}
					// 将上传的文件内容写入服务器文件中
					part.write(fileSavingPath);
					response.sendRedirect("/admin/ImageGoodServlet?curPage="+cur);
				} else {
					response.getWriter().write("修改失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if("add".equals(flag)) {		//添加在这
			//获取请求参数一定要写在开始，否则会出现乱码。
			String good_id = request.getParameter("good_name");
			String sort = request.getParameter("sort");
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
			image.setGoods_id(Integer.valueOf(good_id));
			image.setRoute(File.separator+"images_good"+File.separator + filename + ext);
			image.setSort(Integer.valueOf(sort));
			
			
			try {
				if (igsi.add(image)) {
					// 如果存储上传文件的文件夹不存在，则创建文件夹
					File f = new File(fileSavingFolder + File.separator);
					// 如果文件不存在则创建
					if (!f.exists()) {
						f.mkdirs();
					}
					// 将上传的文件内容写入服务器文件中
					part.write(fileSavingPath);
					// 输出上传成功信息
					response.sendRedirect("/admin/ImageGoodServlet");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("exits".equals(flag)) {		//ajax表单验证
			
		}
				
	}

}
