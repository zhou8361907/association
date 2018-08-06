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

import com.sog.dao.LogsDaoI;
import com.sog.entity.Goods;
import com.sog.entity.Image_goods;
import com.sog.service.GoodsServiceI;
import com.sog.service.GoodsServiceImpl;
import com.sog.service.ImageGoodServiceI;
import com.sog.service.ImageGoodServiceImpl;

@WebServlet("/admin/Good2ImageServlet")
@MultipartConfig
public class Good2ImageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//图片
				ImageGoodServiceI igsi = new ImageGoodServiceImpl();
				//商品
				GoodsServiceI gsi = new GoodsServiceImpl();
				
				String flag = request.getParameter("flag");
				
				if("del".equals(flag)) {			//删除
					try {
						String goodId = request.getParameter("goodId");
						List<Goods> goodlist = gsi.getWhere(" and goods_id=" + goodId);
						Goods good = goodlist.get(0);
						request.setAttribute("good", good);
						if (igsi.remove(Integer.valueOf(request.getParameter("id")))) {
							List<Image_goods> imageList = igsi.getWhere(" and goods_id=" + goodId);
							request.setAttribute("imageList", imageList);
							request.getRequestDispatcher("/admin/good2image.jsp").forward(request, response);
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

					try {
						List<Image_goods> list = igsi.getWhere(" and image_id= "+id);
						String goodId = request.getParameter("goodId");
						System.out.println(goodId);
						if (list.size() > 0) {
							List<Goods> goodList = gsi.getWhere(" and goods_id=" + goodId);
							Goods goods = goodList.get(0);
							Image_goods image_goods = list.get(0);
							request.setAttribute("image", image_goods);
							// 读取角色
							goodList = gsi.findByAll();
							request.setAttribute("good", goods);
							//
							request.getRequestDispatcher("/admin/addgood2image.jsp").forward(request, response);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}else if("add".equals(flag)) {		//添加在这转发
					try {
						String goodId = request.getParameter("id");
						List<Goods> goodlist = gsi.getWhere(" and goods_id=" + goodId);
						Goods good = goodlist.get(0);
						request.setAttribute("good", good);
						// 请求转发
						request.getRequestDispatcher("/admin/addgood2image.jsp").forward(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else {		//显示在这
					try {
						String goodId = request.getParameter("id");
						List<Image_goods> imageList = igsi.getWhere(" and goods_id=" + goodId);
						List<Goods> goodList = gsi.getWhere(" and goods_id=" + goodId);
						Goods good = goodList.get(0);
						// 通过 request 将获取到的数据传给页面

						request.setAttribute("imageList", imageList);
						request.setAttribute("good", good);
						// 请求转发
						request.getRequestDispatcher("/admin/good2image.jsp").forward(request, response);
						
					} catch (Exception e) {
						
						e.printStackTrace();
					}
					
					
				}
				
				
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ImageGoodServiceI igsi = new ImageGoodServiceImpl();
		
		String flag = request.getParameter("flag");
		String id = request.getParameter("id");
		
		
		if(null != id && !id.equals("")) {//修改在这

			String good_id = request.getParameter("good_id");
			String route = request.getParameter("route");
			String sort = request.getParameter("sort");
			Image_goods image_goods = new Image_goods();
			image_goods.setImage_id(Integer.valueOf(id));
			image_goods.setGoods_id(Integer.valueOf(good_id));
			
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
					response.sendRedirect("/admin/Good2ImageServlet?&id="+good_id);
				} else {
					response.getWriter().write("修改失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if("add".equals(flag)) {		//添加在这
			//获取请求参数一定要写在开始，否则会出现乱码。
			String good_id = request.getParameter("good_id");
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
					response.sendRedirect("/admin/Good2ImageServlet?&id="+good_id);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("exits".equals(flag)) {		//ajax表单验证
			
		}
				
	}

}
