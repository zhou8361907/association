package com.sog.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sog.entity.Choose;
import com.sog.entity.Order;
import com.sog.service.OrderServiceI;
import com.sog.service.OrderServiceImpl;

/**
 * Servlet implementation class StatisticsServlet
 */
@WebServlet("/admin/StatisticsServlet")
public class StatisticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatisticsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderServiceI osi=new OrderServiceImpl();
		List<Order> order_list=new ArrayList<Order>();
		int order_number=0;
		BigDecimal order_money=new BigDecimal(0);
		int wait_pay=0;
		int wait_com=0;
		try {
			order_list=osi.findByAll();
			for( Order order : order_list) {
				BigDecimal b1=new BigDecimal(0);
				b1=order_money;
				order_number+=1;
				System.out.println("该订单的钱"+order.getSumMoney());
				order_money=b1.add(order.getSumMoney());
				System.out.println("总钱："+order_money);
				if( order.getOrderStage()==0) {
					wait_pay+=1;
				}
				if(order.getOrderStage()==1) {
					wait_com+=1;
				}
				
				
			}
			request.setAttribute("order_number", order_number);
			request.setAttribute("order_money", order_money);
			request.setAttribute("wait_pay", wait_pay);
			request.setAttribute("wait_com", wait_com);
			// 请求转发
			request.getRequestDispatcher("/admin/statistics.jsp").forward(request, response);
			
			
			
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
