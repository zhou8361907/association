package com.sog.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sog.dao.ContentDaoI;
import com.sog.dao.ContentDaoImpl;
import com.sog.dao.LogisticsDaoI;
import com.sog.dao.LogisticsDaoImpl;
import com.sog.entity.Choose;
import com.sog.entity.Content;
import com.sog.entity.Goods;
import com.sog.entity.Location;
import com.sog.entity.Logistics;
import com.sog.entity.Order;
import com.sog.service.ChooseServiceI;
import com.sog.service.ChooseServiceImpl;
import com.sog.service.GoodsServiceI;
import com.sog.service.GoodsServiceImpl;
import com.sog.service.LocationServiceI;
import com.sog.service.LocationServiceImpl;
import com.sog.service.OrderServiceI;
import com.sog.service.OrderServiceImpl;

/**
 * Servlet implementation class frontOrdersServlet
 */
@WebServlet("/front/frontOrdersServlet")
public class frontOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_id=Integer.valueOf(request.getParameter("user_id"));
		OrderServiceI osi=new OrderServiceImpl();
		Order orders=new Order();
		if(null!=request.getParameter("flag")){
	
			int order_id=Integer.valueOf(request.getParameter("order_id"));
			if("pay".equals(request.getParameter("flag"))) {
				//付款
				try {
					orders=(Order)osi.getWhere(" and order_id="+order_id).get(0);
					orders.setOrderStage(1);
					osi.modify(orders);
					response.sendRedirect("/front/frontOrdersServlet?user_id="+user_id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if("take".equals(request.getParameter("flag"))) {
				//收货
				try {
				
					orders=(Order)osi.getWhere(" and order_id="+order_id).get(0);
				
					orders.setOrderStage(5);
					osi.modify(orders);
				
				//	request.getRequestDispatcher("/front/frontOrdersServlet?user_id="+user_id).forward(request, response);
					response.sendRedirect("/front/frontOrdersServlet?user_id="+user_id);
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if("returs".equals(request.getParameter("flag"))) {
				//退货
				try {
					orders=(Order)osi.getWhere(" and order_id="+order_id).get(0);
					orders.setOrderStage(4);
					osi.modify(orders);
					response.sendRedirect("/front/frontOrdersServlet?user_id="+user_id);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}else if("comments".equals(request.getParameter("flag"))) {
				//评价
				Goods good=new Goods();
				GoodsServiceI gsi=new GoodsServiceImpl();
				List<Content> content_list=new ArrayList();
				List content_goodsid_list=new ArrayList();
				try {
					orders=(Order)osi.getWhere(" and order_id="+order_id).get(0);
					content_list=orders.getContentList();
					for(int i=0;i<content_list.size();i++) {
						content_goodsid_list.add(content_list.get(i).getGoods_id());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
			
				
				request.setAttribute("content_goodsid_list", content_goodsid_list);
				request.setAttribute("content_list", content_list);
				request.setAttribute("order_id", order_id);
				request.getRequestDispatcher("/front/evaluate.jsp").forward(request, response);
			}else if("sign".equals(request.getParameter("flag"))) {
				//签收
				try {
					orders=(Order)osi.getWhere(" and order_id="+order_id).get(0);
					orders.setOrderStage(5);
					osi.modify(orders);
					
					//获得对应订单id的物流表
					LogisticsDaoI logdi=new LogisticsDaoImpl();
					Logistics logistics=new Logistics();
					logistics=(Logistics)logdi.selectWhere(" and transport_id="+orders.getTransportId()).get(0);
					java.util.Date udate;
					udate = new java.util.Date();//获取系统时间
					java.sql.Date sdate = new java.sql.Date(udate.getTime());//类型转换
					//logistics.setSend_time(sdate);
					logistics.setReceiver_time(sdate);
					
					logdi.update(logistics);
					response.sendRedirect("/front/frontOrdersServlet?user_id="+user_id);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}else {
		
	
		List<Order> order_list= new ArrayList<Order>();
		try {
		
			order_list=osi.getWhere(" and user_id="+user_id);
			
			request.setAttribute("order_list", order_list);
			request.getRequestDispatcher("/front/My_Order.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag=request.getParameter("flag");
		int user_id=Integer.valueOf(request.getParameter("user_id"));
		if(null != request.getParameter("flag") && !request.getParameter("flag").equals("")) {
			if("buy".equals(request.getParameter("flag"))) {
				String goods_id = request.getParameter("goods_id");
				String locations_id=request.getParameter("loc");//获得传入地址的location_id
				String num = request.getParameter("num");
				String money_all = request.getParameter("money_all");//获得选中商品的总价钱
				//获取当前选中的地址
				LocationServiceI lsi=new LocationServiceImpl();
				Location location=new Location();
				//生成对应地址的物流表,并获得刚刚插入的
				LogisticsDaoI logdi=new LogisticsDaoImpl();
				Logistics logistics=new Logistics();
				int logistics_id=0;
				int order_id=0;
				//生成订单
				OrderServiceI osi=new OrderServiceImpl();
				Order orders=new Order();
				//生成订单明细；
				
				Content content=new Content();
				ContentDaoI condi=new ContentDaoImpl();
				try {
					//获得收货地址
					location=(Location)lsi.getWhere(" and location_id="+locations_id).get(0);
					//生成物流记录
					logistics.setCompany_name("申通");
					logistics.setTransport_method("空运");
					logistics.setFee(BigDecimal.valueOf(0));
					logistics.setSend_address("秦皇岛");
					java.util.Date udate;
					//udate = new java.util.Date();//获取系统时间
					//java.sql.Date sdate = new java.sql.Date(udate.getTime());//类型转换
					//logistics.setSend_time(sdate);
					logistics.setReceiver_address(location.getLocation());
					logistics.setReceiver_phone(location.getPhone());
					logistics.setReceiver_name(location.getName());
					logistics.setOrder_id(0);
					logistics_id=logdi.insertre(logistics);
					System.out.println("收货地址为"+logistics.getReceiver_address());
					//生成订单
					orders.setUserId(user_id);
					orders.setTransportId(logistics_id);
					orders.setOrderStage(0);
					orders.setSumMoney(new BigDecimal(money_all));
					//Timestamp转化为String: 
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					//定义格式，不显示毫秒 
					Timestamp now = new Timestamp(System.currentTimeMillis());
					//获取系统当前时间 
					String str = df.format(now);         
					//String转化为Timestamp: 
					String time = df.format(new Date()); 
					Timestamp ts = Timestamp.valueOf(time); 
					orders.setBeginTime(ts);
					order_id=osi.insertre(orders);
					System.out.println("生成的order"+order_id);
					//生成订单明细
					
						content.setGoods_id(Integer.valueOf(goods_id));
						content.setOrder_id(order_id);
						content.setOrder_number(Integer.valueOf(num));
						condi.insert(content);
						
						
					
					
					response.sendRedirect("/front/frontOrdersServlet?user_id="+user_id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
			
			
		}else {
			String money_all = request.getParameter("money_all");//获得选中商品的总价钱
			String check_lists = request.getParameter("choose_list");//获得选中choose_id的list
			String locations_id=request.getParameter("loc");//获得传入地址的location_id
			List<String> check_list = java.util.Arrays.asList(check_lists.split(","));//获得选中choose_id的list
			
//			
//			for(int i=0;i<check_list.size();i++) {
//				System.out.println(check_list.get(i));
//			}
			
			//获取当前选中的地址
			LocationServiceI lsi=new LocationServiceImpl();
			Location location=new Location();
			//生成对应地址的物流表,并获得刚刚插入的
			LogisticsDaoI logdi=new LogisticsDaoImpl();
			Logistics logistics=new Logistics();
			int logistics_id=0;
			int order_id=0;
			//生成订单
			OrderServiceI osi=new OrderServiceImpl();
			Order orders=new Order();
			//生成订单明细；
			ChooseServiceI csi=new ChooseServiceImpl();
			Choose choose=new Choose();
			Content content=new Content();
			ContentDaoI condi=new ContentDaoImpl();
			try {
				//获得收货地址
				location=(Location)lsi.getWhere(" and location_id="+locations_id).get(0);
				//生成物流记录
				logistics.setCompany_name("申通");
				logistics.setTransport_method("空运");
				logistics.setFee(BigDecimal.valueOf(0));
				logistics.setSend_address("秦皇岛");
				java.util.Date udate;
				//udate = new java.util.Date();//获取系统时间
				//java.sql.Date sdate = new java.sql.Date(udate.getTime());//类型转换
				//logistics.setSend_time(sdate);
				logistics.setReceiver_address(location.getLocation());
				logistics.setReceiver_phone(location.getPhone());
				logistics.setReceiver_name(location.getName());
				logistics.setOrder_id(0);
				logistics_id=logdi.insertre(logistics);
				System.out.println("收货地址为"+logistics.getReceiver_address());
				//生成订单
				orders.setUserId(user_id);
				orders.setTransportId(logistics_id);
				orders.setOrderStage(0);
				orders.setSumMoney(new BigDecimal(money_all));
				//Timestamp转化为String: 
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				//定义格式，不显示毫秒 
				Timestamp now = new Timestamp(System.currentTimeMillis());
				//获取系统当前时间 
				String str = df.format(now);         
				//String转化为Timestamp: 
				String time = df.format(new Date()); 
				Timestamp ts = Timestamp.valueOf(time); 
				orders.setBeginTime(ts);
				order_id=osi.insertre(orders);
				System.out.println("生成的order"+order_id);
				//生成订单明细
				System.out.println("checl_list的大小"+check_list.size());
				for(int i=0;i<check_list.size();i++) {
					int j=Integer.valueOf(check_list.get(i));
					System.out.println("购物车的编号"+j);
					choose=(Choose)csi.getWhere(" and choose_id="+j).get(0);
					
					content.setGoods_id(choose.getGoods_id());
					content.setOrder_id(order_id);
					content.setOrder_number(choose.getNumber());
					condi.insert(content);
					csi.remove(j);
					
				}
				
				response.sendRedirect("/front/frontOrdersServlet?user_id="+user_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
	
		
		
		
	}

}
