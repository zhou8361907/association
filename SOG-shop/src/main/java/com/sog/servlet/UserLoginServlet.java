package com.sog.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sog.entity.User;
import com.sog.service.UserServiceI;
import com.sog.service.UserServiceImpl;


@WebServlet("/front/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		 
		session.removeAttribute("user");

		response.sendRedirect("/front/index.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserServiceI<User> usi = new UserServiceImpl();
		System.out.println("aaa");
		String flag = request.getParameter("flag");
        System.out.println(flag);
		if ("login".equals(flag)) {
			HttpSession session = request.getSession();
			String account = request.getParameter("account");
			String password = request.getParameter("password");
            System.out.println(account+":"+password);
            String value1 = request.getParameter("codes");
			System.out.println("codes妈妈为"+value1);
			/* 获取图片的值 */
			System.out.println(value1 + "111");
		
			String value2 = (String) session.getAttribute("checkcode");
			System.out.println("codes爸爸为"+value2);
			/* 对比两个值（字母不区分大小写） */
			if(value2.equalsIgnoreCase(value1))	
			{
				try {
					if(usi.login(account, password)) {
	                    //获取会话，将户值放入会话中
						/* 获取输入的值 */
						List<User> ulist=usi.getWhere("and account='"+account + "'");
						User u=new User();
						u=ulist.get(0);
						Integer user_id=u.getUser_id();
						session.setAttribute("user", u);
						System.out.print("用户名aaaabbbbbb"+ user_id);
						
						response.getWriter().write("success");
					}else {					
						response.getWriter().write("fail1");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else
			{
				response.getWriter().write("fail2");
			}
		}
		else if("register".equals(flag))
		{
			String account = request.getParameter("account");
			String password=request.getParameter("password");
			String phonenumber=request.getParameter("phonenumber");
			String repassword=request.getParameter("repassword");
           try {
				
				if(usi.register(account)) {
			 User user=new User();
			 user.setUser_name(account);
			 user.setAccount(account);
			 user.setUser_phone(phonenumber);
			 user.setPassword(password);
			 usi.add(user);
			 		response.sendRedirect("/front/login.html");
				}else {					
					
					response.sendRedirect("/front/404.html");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
}