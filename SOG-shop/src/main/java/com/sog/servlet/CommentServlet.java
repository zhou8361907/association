package com.sog.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sog.entity.Comment;
import com.sog.entity.Order;
import com.sog.service.CommentServiceI;
import com.sog.service.CommentServiceImpl;
import com.sog.service.OrderServiceI;
import com.sog.service.OrderServiceImpl;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/front/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_id=Integer.valueOf(request.getParameter("user_id"));
		int order_id=Integer.valueOf(request.getParameter("order_id"));
		String contents_goodsid_list=request.getParameter("content_goodsid_list");
		contents_goodsid_list=contents_goodsid_list.replace("[", "");
		contents_goodsid_list=contents_goodsid_list.replace("]", "");
		contents_goodsid_list=contents_goodsid_list.replace(" ", "");
		List<String> content_goodsid_list = java.util.Arrays.asList(contents_goodsid_list.split(","));
		for(int i=0;i<content_goodsid_list.size();i++) {
			int goods_id=Integer.valueOf(content_goodsid_list.get(i));
			String s1="pingjia"+goods_id;
			String s2="comment_content"+goods_id;
			String pingjia=request.getParameter(s1);
			String comment_content=request.getParameter(s2);
			Comment comment=new Comment();
			comment.setUserId(user_id);
			comment.setGoodsId(goods_id);
			comment.setCommentContent(comment_content);
			comment.setCommentStarNumber(Integer.valueOf(pingjia));
			//Timestamp转化为String: 
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//定义格式，不显示毫秒 
			Timestamp now = new Timestamp(System.currentTimeMillis());
			//获取系统当前时间 
			String str = df.format(now);         
			//String转化为Timestamp: 
			String time = df.format(new Date()); 
			Timestamp ts = Timestamp.valueOf(time); 
			comment.setCommentTime(ts);
			
			CommentServiceI csi=new CommentServiceImpl();
			try {
				csi.add(comment);
				OrderServiceI osi=new OrderServiceImpl();
				Order orders=new Order();
				orders=(Order)osi.getWhere(" and order_id="+order_id).get(0);
				orders.setOrderStage(6);
				osi.modify(orders);
				response.sendRedirect("/front/frontOrdersServlet?user_id="+user_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	}

}
