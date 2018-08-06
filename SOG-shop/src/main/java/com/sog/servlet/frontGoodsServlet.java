package com.sog.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sog.entity.Comment;
import com.sog.entity.Goods;
import com.sog.service.CommentServiceI;
import com.sog.service.CommentServiceImpl;
import com.sog.service.GoodsServiceI;
import com.sog.service.GoodsServiceImpl;
import com.sog.service.SeriesServiceI;
import com.sog.service.SeriesServiceImpl;

/**
 * Servlet implementation class frontGoodsServlet
 */
@WebServlet("/front/frontGoodsServlet")
public class frontGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int goods_id=Integer.valueOf(request.getParameter("goods_id"));
		Goods good=new Goods();
		GoodsServiceI gsi=new GoodsServiceImpl();
		SeriesServiceI ssi=new SeriesServiceImpl();
		Comment comment=new Comment();
		List<Comment> comment_list=new ArrayList();//获得评论列表
		List<Goods> goods_list=new ArrayList();//存储这个商品系列下的所有色号产品
		CommentServiceI csi=new CommentServiceImpl();
		try {
			good=(Goods)gsi.getWhere(" and goods_id="+goods_id).get(0);
			
			goods_list=gsi.getWhere(" and series_id="+good.getSeries_id());
			comment_list=csi.getWhere(" and goods_id="+goods_id);
			request.setAttribute("goods", good);
			request.setAttribute("comment_list", comment_list);
			request.setAttribute("goods_list", goods_list);
			request.getRequestDispatcher("/front/single.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
