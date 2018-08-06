package com.sog.servlet;

import java.io.IOException;
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

import com.sog.entity.Choose;
import com.sog.entity.Goods;
import com.sog.entity.Location;
import com.sog.service.ChooseServiceI;
import com.sog.service.ChooseServiceImpl;
import com.sog.service.GoodsServiceI;
import com.sog.service.GoodsServiceImpl;
import com.sog.service.LocationServiceI;
import com.sog.service.LocationServiceImpl;

/**
 * Servlet implementation class ChooseServlet
 */
@WebServlet("/front/ChooseServlet")
public class ChooseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//获得对应用户购物车里的所有信息
		int user_id=Integer.valueOf(request.getParameter("user_id"));
		String flag = request.getParameter("flag");
	
		ChooseServiceI csi=new ChooseServiceImpl();
		LocationServiceI lsi=new LocationServiceImpl();
		if(null != request.getParameter("flag") && !request.getParameter("flag").equals("")) {
		
		
			if(flag.equals("balance")) {
				
				String money_all = request.getParameter("money_all");//获得选中商品的总价钱
				String check_list = request.getParameter("car_check_list");//获得选中choose_id的list
				String num_list = request.getParameter("car_num_list");//获得选中choose_id的num
				List<String> car_check_list = java.util.Arrays.asList(check_list.split(","));
				List<String> car_num_list = java.util.Arrays.asList(num_list.split(","));
				List<Choose> choose_list=new ArrayList<Choose>();
				List<Location> location_list=new ArrayList<Location>();
				try {
					location_list=lsi.getWhere(" and user_id="+user_id);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for( int i=0;i<car_check_list.size();i++) {
					
					Choose choose=new Choose();
					try {
						choose=csi.SelectBych_id(Integer.valueOf(car_check_list.get(i)), Integer.valueOf(car_num_list.get(i)));
						choose_list.add(choose);	
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				request.setAttribute("location_list", location_list);
				request.setAttribute("user_id", user_id);
				request.setAttribute("choose_list", choose_list);
				request.setAttribute("check_list", check_list);
				request.setAttribute("money_all", money_all);
				request.getRequestDispatcher("/front/address.jsp").forward(request, response);
				
			}else if(flag.equals("delete")) {
				int choose_id=Integer.valueOf(request.getParameter("choose_id"));
				System.out.println(choose_id+"到达了这里");
				try {
					csi.remove(choose_id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}else if(flag.equals("clear")) {
				try {
					csi.clear(user_id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else {
			
			List<Choose> list;
			try {
				list = csi.SelectByUser(user_id);
				System.out.println(list.size());
				request.setAttribute("list", list);
				request.setAttribute("user_id", user_id);
				
				request.getRequestDispatcher("/front/checkout.jsp").forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		}
		

	/**
	 * @param user_id 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag=request.getParameter("flag");

		ChooseServiceI csi=new ChooseServiceImpl();
		if(null != request.getParameter("flag") && !request.getParameter("flag").equals("")) {
		 if(flag.equals("delete")) {
			int choose_id=Integer.valueOf(request.getParameter("choose_id"));
			System.out.println(choose_id+"到达了这里");
			try {
				if(csi.remove(choose_id)) {
						
					response.getWriter().write("success");
					
						}
				else
				{
					
					response.getWriter().write("fail");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
		 }else if (flag.equals("buy")) {
			 int user_id=Integer.valueOf(request.getParameter("user_id"));
			 int goods_id=Integer.valueOf(request.getParameter("goods_id"));
			 int num=Integer.valueOf(request.getParameter("number"));
			 GoodsServiceI gsi=new GoodsServiceImpl();
			 Goods goods=new Goods();
			 List<Location> location_list=new ArrayList<Location>();
				LocationServiceI lsi=new LocationServiceImpl();
			 try {
				 location_list=lsi.getWhere(" and user_id="+user_id);
				goods=(Goods)gsi.getWhere(" and goods_id="+goods_id).get(0);
				request.setAttribute("goods", goods);
				request.setAttribute("user_id", user_id);
				request.setAttribute("num", num);
				request.setAttribute("location_list", location_list);
				request.getRequestDispatcher("/front/address_buy.jsp").forward(request, response);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		}else 
			{
				
				//获得user_id,goods_id,number设置put_time和type=0 存入choose表
				String user_id=request.getParameter("user_id");
				String goods_id=request.getParameter("goods_id");
				String number=request.getParameter("number");
				System.out.println(number);
				Choose choose=new Choose();
				choose.setGoods_id(Integer.valueOf(goods_id));
				choose.setUser_id(Integer.valueOf(user_id));
				choose.setNumber(Integer.valueOf(number));
				choose.setType(false);
				//Timestamp转化为String: 
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				//定义格式，不显示毫秒 
				Timestamp now = new Timestamp(System.currentTimeMillis());
				//获取系统当前时间 
				String str = df.format(now);         
				//String转化为Timestamp: 
				String time = df.format(new Date()); 
				Timestamp ts = Timestamp.valueOf(time); 
				choose.setPut_time(ts);
				try{
					if(csi.add(choose)) {
						response.sendRedirect("/front/frontGoodsServlet?goods_id="+goods_id);
					}else {
						response.getWriter().write("添加失败");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				
			}
		
		
		
		
		 }
		}
	


