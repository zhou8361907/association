package com.sog.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sog.entity.Roles;
import com.sog.service.RolesServiceImpl;
import com.sog.service.RolesServicel;


/**
 * 
 * @类名 RolesServlet
 * @描述 TODO(一句话描述类的作用)
 * @作者 王帅
 * @日期 2018年6月29日 上午10:00:05
 *
 */

@WebServlet("/admin/RolesServlet")
public class RolesServlet extends HttpServlet {
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RolesServicel<Roles> rsi = new RolesServiceImpl();
		String flag = request.getParameter("flag");
		if ("edit".equals(flag)) {
			// 进记录修改
			Integer id = Integer.valueOf(request.getParameter("id"));
			Integer cur = Integer.valueOf(request.getParameter("cur"));
			try {
				List<Roles> list = rsi.getWhere(" and role_id= "+id);
				if (list.size() > 0) {
					Roles role = list.get(0);
					request.setAttribute("role", role);
					request.setAttribute("cur", cur);
					//
					request.getRequestDispatcher("/admin/addRole.jsp").forward(request, response);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("del".equals(flag)) {
			// 删除操作
			try {
				
				
				if (rsi.remove(Integer.valueOf(request.getParameter("id")))) {
					int pageSize=3;
					int curPage=Integer.valueOf(request.getParameter("cur"));
					Map<String, Object> map = rsi.getPageAll("",curPage, pageSize);
					int pageNum=Integer.valueOf(map.get("pageNum").toString());
					
					if(curPage>=pageNum) {
						curPage=pageNum;
					}
					//当记录全部删除时，pageNUm=0,导致curPage=0,分页查询的函数第二个参数不允许curPage=0，所以检测当curPage=0，令为1；
					if(curPage<=0) {
						curPage=1;
					}
					//这里对map和page再次赋值，是当前页面的记录全部删除后，需要重新获取map,否则就会显示没有记录的那一页
					map = rsi.getPageAll("",curPage, pageSize);
					pageNum=Integer.valueOf(map.get("pageNum").toString());					
					
					request.setAttribute("map", map);
					request.setAttribute("curPage", curPage);
					//System.out.print(userlist.size());
					request.getRequestDispatcher("/admin/role.jsp").forward(request, response);
					
				} else {
					response.getWriter().write("修改失败");
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				int curPage = 1;
				int pageSize = 3;
				if (null != request.getParameter("curPage")) {
					curPage = Integer.valueOf(request.getParameter("curPage"));
				}
				if (curPage <= 0) {
					curPage = 1;
				}
				
				Map<String, Object> map = rsi.getPageAll("", curPage, pageSize);
				int pageNum=Integer.valueOf(map.get("pageNum").toString());
				
				if(curPage>=pageNum) {
					curPage=pageNum;
				}
				request.setAttribute("map", map);
				request.setAttribute("curPage", curPage);
				request.getRequestDispatcher("/admin/role.jsp").forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role_position = request.getParameter("role_position");
		String role_privilege = request.getParameter("role_privilege");

		RolesServicel<Roles> rsi = new RolesServiceImpl();
		String id = request.getParameter("id");
		
		if (null != id && !id.equals("")) {
			Roles role = new Roles();
			role.setRole_id(Integer.valueOf(id));
			role.setRole_position(role_position);
			role.setRole_privilege(Integer.valueOf(role_privilege));
			Integer cur = Integer.valueOf(request.getParameter("cur"));
			System.out.print(cur);
			try {
				if (rsi.modify(role)) {
					response.sendRedirect("/admin/RolesServlet?curPage="+cur);
				} else {
					response.getWriter().write("修改失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			Roles role = new Roles();
			role.setRole_position(role_position);
			role.setRole_privilege(Integer.valueOf(role_privilege));
			try {
				if (rsi.add(role)) {
					response.sendRedirect("/admin/RolesServlet");
				} else {
					response.getWriter().write("添加失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
