package com.sog.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sog.dao.UserDaoI;
import com.sog.dao.UserDaoImpl;
import com.sog.entity.User;
import com.sog.service.UserServiceI;
import com.sog.service.UserServiceImpl;

/**
 * 
 * @类名: UserServlet
 * @描述: 实现了分页以及删除后返回原页面，修改后返回原页面，全部删除后的页面异常
 * @作者：周帅
 * @日期：2018年6月29日下午10:39:56
 */
@WebServlet("/admin/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//设置响应编码
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		User user_query=new User();
		
		if(null!=request.getParameter("flag")){
			
			
			if("del".equals(request.getParameter("flag"))) {
				UserServiceI usi=new UserServiceImpl();
				int user_id=Integer.valueOf(request.getParameter("user_id"));
				int curPage=Integer.valueOf(request.getParameter("cur"));
				int pageSize=3;
				try {
					if(usi.remove(user_id)) {
						response.sendRedirect("/admin/UserServlet?curPage="+curPage);
					
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}else if("edit".equals(request.getParameter("flag"))) {
				UserServiceI usi=new UserServiceImpl();
				Integer user_id = Integer.valueOf(request.getParameter("user_id"));
				Integer curPage = Integer.valueOf(request.getParameter("cur"));
				try {
					List<User> list = usi.getWhere(" and user_id="+user_id);
					if (list.size() > 0) {
						User user = list.get(0);
						request.setAttribute("user", user);
						//获得修改的 curPage
						request.setAttribute("curs", curPage);
						//
						request.getRequestDispatcher("/admin/adduser.jsp").forward(request, response);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}	
		}
		else {
			//读取用户
			HttpSession session = request.getSession(); 
			if(null!=request.getParameter("wheresql"))
			{
				session.removeAttribute("user_query_session");
			}
			User user_session=new User();
			UserDaoI udi=new UserDaoImpl();
			UserServiceI usi=new UserServiceImpl();
			List<User> userlist;
			try {
				int curPage=1;
				int pageSize=3;
				if (null != request.getParameter("curPage")) {
					curPage = Integer.valueOf(request.getParameter("curPage"));
				}
				if (curPage <= 0) {
					curPage = 1;
				}
				//实现前翻页和后翻页  通过jap传递参数act(动作，前翻后翻） cur(当前页面）num(总页数）
				if(null!=request.getParameter("act")) {
					int act=Integer.valueOf(request.getParameter("act"));
					int cur=Integer.valueOf(request.getParameter("cur"));
					int num=Integer.valueOf(request.getParameter("num"));
					if(act==111)
					{
						if(cur<=1)
						{
							curPage=1;
						}
						else {
							curPage=cur-1;
						}
					}else {
						
						if(cur>=num)
						{
							curPage=num;
						}
						else
						{
							curPage=cur+1;
						}
					}
					
				}
		        
				//对session判空 进行赋值。
				if(session.getAttribute("user_query_session")!=null) {
					user_query=(User) request.getSession().getAttribute("user_query_session");
					System.out.println(user_query.getAccount());
					System.out.println(user_query.getUser_name());
				}
				
				
				
				Map<String, Object> map; 
				System.out.println(request.getParameter("query_account"));
				System.out.println(request.getParameter("query_name"));
				System.out.println(request.getParameter("query_states"));
			//判断如果form表单提交时的input 不为空的时候 对user_query进行赋值并存入session，当input都为空的时候移除session
			//	if(null!=request.getParameter("query")) {
				if(null!=request.getParameter("query_account")||null!=request.getParameter("query_name")||null!=request.getParameter("query_states")) {
				
					String query_account=request.getParameter("query_account");
					String query_name=request.getParameter("query_name");
					StringBuffer wheresql=new StringBuffer();
					
					//System.out.println(query_name);
					
					if(!query_account.equals("")) {
						byte source [] = query_account.getBytes("iso8859-1");//得到客户机提交的原始数据
						query_account = new String (query_account.getBytes("iso8859-1"),"UTF-8");//解决乱码
						user_query.setAccount(query_account);
					}else
					{
						user_query.setAccount("");
					}
					if(!query_name.equals("")) {
					byte source [] = query_name.getBytes("iso8859-1");//得到客户机提交的原始数据
					query_name = new String (query_name.getBytes("iso8859-1"),"UTF-8");//解决乱码
					user_query.setUser_name(query_name);
					}else {
						user_query.setUser_name(query_name);
					}
					session.setAttribute("user_query_session", user_query); 
				}
				map=usi.like_qurey(user_query, curPage, pageSize);
					
//				}else {
//					//如果没有模糊搜索条件就直接调用getPageAll
//					map= usi.getPageAll("",curPage, pageSize);
//				}
					
					
					
				int pageNum=Integer.valueOf(map.get("pageNum").toString());
				
				if(curPage>=pageNum) {
					curPage=pageNum;
				}
				request.setAttribute("map", map);
				request.setAttribute("curPage", curPage);
				request.setAttribute("user_query", user_query);
				request.getRequestDispatcher("/admin/user.jsp").forward(request, response);
				
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String act=request.getParameter("act");
//		
//		if("query".equals(act)) {
//			String query_left=request.getParameter("query_left");
//			String query_right=request.getParameter("query_right");
//			String query_account=request.getParameter("query_account");
//			String query_name=request.getParameter("query_name");
//			String query_states=request.getParameter("query_states");
//			StringBuffer wheresql=new StringBuffer();
//		
//			if(!query_left.equals("")) {
//				wheresql.append(" and user_id>="+Integer.valueOf(query_left));
//			}
//			if(!query_right.equals("")) {
//				wheresql.append(" and user_id<="+Integer.valueOf(query_right));
//			}
//		
//			
//			if(!query_account.equals("")) {
//				wheresql.append(" and account like LIKE \'%" + query_account + "%\'");
//			}
//			
//		
//			
//		if(!query_name.equals("")) {
//				wheresql.append( " and user_name like ").append(" '").append("%"+query_name+"%"+"'");
//			}
//			if(!query_states.equals("")) {
//				wheresql.append(" and states="+Integer.valueOf(query_states));
//			}
//			
//			String wheresqls=wheresql.toString();
//			String url="/admin/UserServlet?wheresql="+wheresqls;
//		//	wheresqls= java.net.URLDecoder.decode(wheresqls,"UTF-8"); 
//			response.sendRedirect(url);
//			System.out.println("44444");
//			System.out.println(url);
//			
//			
//			
//			
//			
//			
//			
//		}else {
			UserServiceI usi=new UserServiceImpl();
			String account=request.getParameter("account");
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			String phone=request.getParameter("phone");
			BigDecimal money=BigDecimal.valueOf(0);
			int score=0;
			if(request.getParameter("money").equals(""))
			{
				money=new BigDecimal("0");
			}else {
				money=new BigDecimal(request.getParameter("money"));
			}
			System.out.print(money);
			if(request.getParameter("score").equals(""))
			{
				score=0;
			}else {
				score=Integer.valueOf(request.getParameter("score"));
			
			}	
			System.out.print(score);
			String user_id=request.getParameter("user_id");
			int states;
			if(request.getParameter("states").equals(""))
			{
				states=0;
			}else {
				states=Integer.valueOf(request.getParameter("states"));;
			}
			if(null!=user_id && !user_id.equals(""))
			{
				User user=new User();
				user.setUser_id(Integer.valueOf(user_id));
				user.setAccount(account);
				user.setUser_name(name);
				user.setPassword(password);
				user.setUser_phone(phone);
				user.setUser_money(money);
				user.setUser_score(score);
				user.setStates(states);
				int curPage=Integer.valueOf(request.getParameter("cur"));
				try {
					if (usi.modify(user)) {
						//返回到修改的页面
						response.sendRedirect("/admin/UserServlet?curPage="+curPage);
					} else {
						response.getWriter().write("修改失败");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}else {
				int sta;
				if(request.getParameter("states").equals(""))
				{
					sta=0;
				}else {
					sta=1;
				}
				
				User user=new User();
				user.setAccount(account);
				user.setUser_name(name);
				user.setPassword(password);
				user.setUser_phone(phone);
				user.setUser_money(money);
				user.setUser_score(score);
				user.setStates(sta);
				//Timestamp转化为String: 
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				//定义格式，不显示毫秒 
				Timestamp now = new Timestamp(System.currentTimeMillis());
				//获取系统当前时间 
				String str = df.format(now);         
				//String转化为Timestamp: 
				String time = df.format(new Date()); 
				Timestamp ts = Timestamp.valueOf(time); 
				user.setCreate_time(ts);
				try{
					if(usi.add(user)) {
						response.sendRedirect("/admin/UserServlet");
					}else {
						response.getWriter().write("添加失败");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		//}
		
		
		
		
	
		
		
		
		
	}

}
