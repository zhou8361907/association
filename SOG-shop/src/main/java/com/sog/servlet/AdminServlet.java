package com.sog.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.xmlrpc.base.Data;
import com.sog.entity.Admin;
import com.sog.entity.Logs;
import com.sog.entity.Roles;
import com.sog.service.AdminServiceI;
import com.sog.service.AdminServiceImpl;
import com.sog.service.LogsServiceDaoI;
import com.sog.service.LogsServiceImpl;
import com.sog.service.RolesServiceImpl;
import com.sog.service.RolesServicel;

/**
 * 
 * @类名 AdminServlet
 * @描述 TODO(一句话描述类的作用)
 * @作者 王帅
 * @日期 2018年6月26日 下午2:56:44
 *
 */
@WebServlet("/admin/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//管理员
		AdminServiceI asi = new AdminServiceImpl();
		//角色
		RolesServicel rsi = new RolesServiceImpl();
		
		String flag=request.getParameter("flag");
		if("out".equals(flag)){
			//销毁session
			HttpSession session = request.getSession();
			/*********添加登录日志***************/
			LogsServiceDaoI lsi = new LogsServiceImpl();
			Logs logs = new Logs();
			logs.setOperate_type("0");
			logs.setOperate_content(session.getAttribute("username")+"退出成功.");
			logs.setOperate_time(new java.sql.Date(new java.util.Date().getTime()));
			logs.setIf_success(true);
			logs.setSecurity_class(1);
			try {
				lsi.add(logs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.invalidate();
			response.sendRedirect("/admin/login.html");
			
		}else if("del".equals(flag)){
			// 删除操作
			try {
				System.out.print("4444");
				if (asi.remove(Integer.valueOf(request.getParameter("id")))) {
					int pageSize=3;
					int curPage=Integer.valueOf(request.getParameter("cur"));
					System.out.print("111");
					Map<String,Object> adminMap = asi.getAdminAndRolePageAll(curPage, pageSize);
					int pageNum=Integer.valueOf(adminMap.get("pageNum").toString());
					System.out.print("3332");
					if(curPage>=pageNum) {
						curPage=pageNum;
					}
					//当记录全部删除时，pageNUm=0,导致curPage=0,分页查询的函数第二个参数不允许curPage=0，所以检测当curPage=0，令为1；
					if(curPage<=0) {
						curPage=1;
					}
					System.out.print("222");
					//这里对map和page再次赋值，是当前页面的记录全部删除后，需要重新获取map,否则就会显示没有记录的那一页
					adminMap = asi.getAdminAndRolePageAll(curPage, pageSize);
					pageNum=Integer.valueOf(adminMap.get("pageNum").toString());
					
					System.out.print("7777");
					request.setAttribute("map", adminMap);
					request.setAttribute("curPage", curPage);
					//System.out.print(userlist.size());
					System.out.print("111");
					request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
					
					
				
				} else {
					response.getWriter().write("删除失败");
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("edit".equals(flag)) {
			// 进记录修改
			Integer id = Integer.valueOf(request.getParameter("id"));
			Integer cur = Integer.valueOf(request.getParameter("cur"));
			System.out.println("aaaaa");
			try {
				List<Admin> list = asi.getWhere(" and admin_id= "+id);
				List<Roles> roleList;
				System.out.println(list.size());
				System.out.println("aaaaa");
				if (list.size() > 0) {
					Admin admin = list.get(0);
					request.setAttribute("admin", admin);
					// 读取角色
					roleList = rsi.findByAll();
					request.setAttribute("roleList", roleList);
					request.setAttribute("cur", cur);
					//
					request.getRequestDispatcher("/admin/addAdmin.jsp").forward(request, response);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if ("add".equals(flag)) {
			List<Roles> roleList;
			try {
				// 读取角色
				roleList = rsi.findByAll();
				request.setAttribute("roleList", roleList);
				// 请求转发
				request.getRequestDispatcher("/admin/addAdmin.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			try {
				int curPage = 1;
				int pageSize = 3;
				if (null != request.getParameter("curPage")) {
					curPage = Integer.valueOf(request.getParameter("curPage"));
				}
				if (curPage <= 0) {
					curPage = 1;
				}
				
				Map<String,Object> adminMap = asi.getAdminAndRolePageAll(curPage, pageSize);
				int pageNum=Integer.valueOf(adminMap.get("pageNum").toString());
				
				// 通过 request 将获取到的数据传给页面
				request.setAttribute("map", adminMap);
				if(curPage>=pageNum) {
					curPage=pageNum;
				}
				request.setAttribute("map", adminMap);
				request.setAttribute("curPage", curPage);
				// 请求转发
				request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * view界面跳转到该方法
	 * 该方法会调用 业务层方法进行用户密码认证
	 * */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//创建 业务层对象
		AdminServiceI asi = new AdminServiceImpl();
		System.out.println("aaa");
		String flag = request.getParameter("flag");

		String id = request.getParameter("id");
		
		if("login".equals(flag)){
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			System.out.println(username+":"+password);
			try {
				//判断用户名密码是否正确
				if(asi.login(username, password)) {
					//获取会话，将用户值放入会话中
					HttpSession session=request.getSession();
					session.setAttribute("username", username);
					/*********添加登录日志***************/
					LogsServiceDaoI lsi = new LogsServiceImpl();
					Logs logs = new Logs();
					logs.setOperate_type("0");
					logs.setOperate_content(username+"登陆成功.");
					logs.setOperate_time(new java.sql.Date(new java.util.Date().getTime()));
					logs.setIf_success(true);
					logs.setSecurity_class(1);
					lsi.add(logs);
					List<Admin> list = asi.getWhere("and  admin_account='" + username + "'");
					Integer roleId = 0;
					System.out.println(username+":"+roleId);
					if(list.size()>0) {
						roleId = list.get(0).getRole_id();
					}
					System.out.println(username+":"+roleId);
					//response.sendRedirect("/admin/index.jsp?roleId=" + roleId.toString());
					System.out.println(username+":"+roleId);
					response.getWriter().write("success" + roleId);
				}else {
					//response.sendRedirect("/admin/error.jsp");
					response.getWriter().write("fail");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(null != id && !id.equals("")) {
			System.out.println(id);
			String txtAccount= request.getParameter("txtAccount");
			String adminName= request.getParameter("txtUserName");
			String gender=request.getParameter("txtGender");
			String mobile = request.getParameter("txtMobile");
			String password = request.getParameter("txtPassword");
			String roleId = request.getParameter("roleType");
			Admin admin = new Admin();
			admin.setId(Integer.valueOf(id));
			admin.setAcount(txtAccount);
			admin.setName(adminName);
			admin.setGender(Integer.valueOf(gender));
			admin.setPhone(mobile);
			admin.setPassword(password);
			admin.setRole_id(Integer.valueOf(roleId));
			admin.setStates(1);
			Integer cur = Integer.valueOf(request.getParameter("cur"));
			try {
				if (asi.modify(admin)) {
					response.sendRedirect("/admin/AdminServlet?curPage="+cur);
				} else {
					response.getWriter().write("修改失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("add".equals(flag)) {
			String txtAccount= request.getParameter("txtAccount");
			String adminName= request.getParameter("txtUserName");
			String gender=request.getParameter("txtGender");
			String mobile = request.getParameter("txtMobile");
			String password = request.getParameter("txtPassword");
			String roleId = request.getParameter("roleType");
			
			
			//创建Admin对象
			Admin admin=new Admin();
			admin.setAcount(txtAccount);
			admin.setName(adminName);
			admin.setGender(Integer.valueOf(gender));
			admin.setPhone(mobile);
			admin.setPassword(password);
			admin.setRole_id(Integer.valueOf(roleId));
			admin.setStates(1);
			try {
				if(asi.add(admin)) {
					response.sendRedirect("/admin/AdminServlet");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if("exist".equals(flag)) {
			String account= request.getParameter("txtAccount");
			//查找账号
			try {
				if(asi.getAdminExsit(account)) {
					response.getWriter().write("1");
				}else {
					response.getWriter().write("0");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
