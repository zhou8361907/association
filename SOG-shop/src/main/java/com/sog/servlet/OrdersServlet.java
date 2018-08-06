package com.sog.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sog.entity.Brand;
import com.sog.entity.Order;
import com.sog.service.AdminServiceI;
import com.sog.service.AdminServiceImpl;
import com.sog.service.BrandsServiceI;
import com.sog.service.BrandsServiceImpl;
import com.sog.service.OrderServiceI;
import com.sog.service.OrderServiceImpl;

/**
 * Servlet implementation class OrdersServlet
 */
@WebServlet("/admin/OrdersServlet")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		OrderServiceI<Order> osi = new OrderServiceImpl();

		String selectid=request.getParameter("selectid");
		System.out.println(selectid+"get");
		
		
			try {
				int curPage = 1;
				int pageSize = 3;
				if (null != request.getParameter("curPage")) {
					curPage = Integer.valueOf(request.getParameter("curPage"));
				}
				if (curPage <= 0) {
					curPage = 1;
				}
				Map<String,Object> OrderMap = null;
				
				if("0".equals(selectid))
				{ OrderMap = osi.getPageAll("and order_stage<4",curPage, pageSize);}
				else if("1".equals(selectid))
				{ OrderMap = osi.getPageAll("and order_stage=4",curPage, pageSize);}
				else if("2".equals(selectid))
				{OrderMap = osi.getPageAll("and order_stage=5",curPage, pageSize);}
				int pageNum=Integer.valueOf(OrderMap.get("pageNum").toString());
				
				// 通过 request 将获取到的数据传给页面
				request.setAttribute("map", OrderMap);
				if(curPage>=pageNum) {
					curPage=pageNum;
				}
				request.setAttribute("map", OrderMap);
				request.setAttribute("curPage", curPage);
				// 请求转发
				if("0".equals(selectid))
				{request.getRequestDispatcher("/admin/order-transport.jsp").forward(request, response);}
				else if("1".equals(selectid)) 
				{request.getRequestDispatcher("/admin/order-returned.jsp").forward(request, response);}
				else if("2".equals(selectid))
				{request.getRequestDispatcher("/admin/order-signed.jsp").forward(request, response);}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		OrderServiceI<Order> osi = new OrderServiceImpl();
		String flag = request.getParameter("flag");
		String selectid=request.getParameter("selectid");
		String Select=request.getParameter("change");
		System.out.println( Select+"hhhhhhhh");
		System.out.println( flag+"wwwwwww");
		System.out.println( selectid+"ttttttttt");
	   
		
		if("edit".equals(flag))
			{
		    	Integer id = Integer.valueOf(request.getParameter("id"));
				Integer cur = Integer.valueOf(request.getParameter("cur"));
				Integer stage= Integer.valueOf(Select);

				System.out.println("stage:---"+stage);
				try {
					List<Order> list=osi.getIdOrders(id);

					if (list.size() > 0) {
						Order o = list.get(0);
						
						o.setOrderStage(stage);

						
			
						try {
							if (osi.modify(o)) {
								System.out.println("更新"+stage+"成功");
								if("0".equals(selectid))
								{response.sendRedirect("/admin/OrdersServlet?selectid=0&curPage="+cur);
								System.out.println("传回发货界面");
								}
								else if("1".equals(selectid)) 
								{response.sendRedirect("/admin/OrdersServlet?selectid=1&curPage="+cur);
								System.out.println("传回退货界面");
								}
								else if("2".equals(selectid))
								{response.sendRedirect("/admin/OrdersServlet?selectid=2&curPage="+cur);
								System.out.println("传回签收界面");}
								
						      } else {
								response.getWriter().write("修改失败");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}

				} catch (Exception e) {
					System.out.println("王西风123");
					e.printStackTrace();
				}
				
				
				
				
				
			}
	}

}
