package com.sog.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sog.entity.Location;
import com.sog.service.LocationServiceI;
import com.sog.service.LocationServiceImpl;

/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/front/AddressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if(null != request.getParameter("flag") && !request.getParameter("flag").equals("")) {
			if(flag.equals("delete")) {
				int user_id=Integer.valueOf(request.getParameter("user_id"));
				int location_id=Integer.valueOf(request.getParameter("location_id"));
				LocationServiceI lsi=new LocationServiceImpl();
				try {
					lsi.remove(location_id);
					response.sendRedirect("/front/AddressServlet?user_id="+user_id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
		}else {
			int user_id=Integer.valueOf(request.getParameter("user_id"));
			LocationServiceI lsi=new LocationServiceImpl();
			List<Location> location_list=new ArrayList<Location>();
			try {
				location_list=lsi.getWhere(" and user_id="+user_id);
				
				request.setAttribute("location_list", location_list);
				request.getRequestDispatcher("/front/refer.jsp").forward(request, response);
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
		String flag = request.getParameter("flag");
		LocationServiceI lsi=new LocationServiceImpl();
		if(null != request.getParameter("flag") && !request.getParameter("flag").equals("")) {
			
			if(flag.equals("add")) {
				String location = request.getParameter("location");
				int user_id=Integer.valueOf(request.getParameter("user_id"));
				String name = request.getParameter("name");
				String phone = request.getParameter("phone");
				Location locations=new Location();
				locations.setUserId(user_id);
				locations.setLocation(location);
				locations.setName(name);
				locations.setPhone(phone);
				
				try {
					lsi.add(locations);
					response.sendRedirect("/front/AddressServlet?user_id="+user_id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}else if(flag.equals("update")) {
				int user_id=Integer.valueOf(request.getParameter("user_id"));
				int location_id=Integer.valueOf(request.getParameter("location_id"));
				String name = request.getParameter("name");
				String phone = request.getParameter("phone");
				String location = request.getParameter("location");
				
				System.out.println(name);
				System.out.println(phone);
				System.out.println(location);
				System.out.println("要查询的地址第"+location_id);
				Location locations=new Location();
				try {
					locations=(Location)lsi.getWhere(" and location_id="+location_id).get(0);
					locations.setUserId(user_id);
					locations.setLocation(location);
					locations.setName(name);
					locations.setPhone(phone);
					locations.setLocationId(location_id);
					System.out.println("要"+locations.getLocationId());
					lsi.modify(locations);
					response.sendRedirect("/front/AddressServlet?user_id="+user_id);
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
			
			
		}
	}

}
