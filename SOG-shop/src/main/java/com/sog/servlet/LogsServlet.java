package com.sog.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sog.entity.Goods;
import com.sog.entity.Logs;
import com.sog.service.GoodsServiceI;
import com.sog.service.GoodsServiceImpl;
import com.sog.service.LogsServiceDaoI;
import com.sog.service.LogsServiceImpl;

/**
 * Servlet implementation class LogsServlet
 */
@WebServlet("/admin/LogsServlet")
public class LogsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (null != request.getParameter("flag")) {
			System.out.println("1111111");
			if ("del".equals(request.getParameter("flag"))) {
				LogsServiceDaoI lsi = new LogsServiceImpl();
			    Integer logs_id = Integer.valueOf(request.getParameter("logs_id"));
				System.out.println(logs_id);
				int curPage = Integer.valueOf(request.getParameter("cur"));
				int pageSize = 3;
				try {
					if (lsi.remove(logs_id)) {
						Map<String, Object> map = lsi.getPageAll("", curPage, pageSize);
						int pageNum = Integer.valueOf(map.get("pageNum").toString());

						if (curPage >= pageNum) {
							curPage = pageNum;
						}
						request.setAttribute("map", map);
						request.setAttribute("curPage", curPage);

						request.getRequestDispatcher("/admin/logs.jsp").forward(request, response);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if ("edit".equals(request.getParameter("flag"))) {
				System.out.println("2222222");
				LogsServiceDaoI lsi = new LogsServiceImpl();
				Integer logs_id = Integer.valueOf(request.getParameter("logs_id"));
				try {
					List<Logs> list = lsi.GetIdLogs(logs_id);
					if (list.size() > 0) {
						Logs l = list.get(0);
						request.setAttribute("logs", l);
						request.getRequestDispatcher("/admin/addlogs.jsp").forward(request, response);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}


		else {

			LogsServiceDaoI lsi = new LogsServiceImpl();

			try {
				int curPage = 1;
				int pageSize = 15;
				if (null != request.getParameter("curPage")) {
					curPage = Integer.valueOf(request.getParameter("curPage"));
				}
				if (curPage <= 0) {
					curPage = 1;
				}
				// 实现前翻页和后翻页 通过jap传递参数act(动作，前翻后翻） cur(当前页面）num(总页数）
				if (null != request.getParameter("act")) {
					int act = Integer.valueOf(request.getParameter("act"));
					int cur = Integer.valueOf(request.getParameter("cur"));
					int num = Integer.valueOf(request.getParameter("num"));
					if (act == 111) {
						if (cur <= 1) {
							curPage = 1;
						} else {
							curPage = cur - 1;
						}
					} else {

						if (cur >= num) {
							curPage = num;
						} else {
							curPage = cur + 1;
						}
					}

				}
				Map<String, Object> map = lsi.getPageAll("", curPage, pageSize);
				int pageNum = Integer.valueOf(map.get("pageNum").toString());
				if (curPage >= pageNum) {
					curPage = pageNum;
				}
				request.setAttribute("map", map);
				request.setAttribute("curPage", curPage);
				// System.out.print(userlist.size());
				request.getRequestDispatcher("/admin/logs.jsp").forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		LogsServiceDaoI lsi = new LogsServiceImpl();
		String logs_id = request.getParameter("logsId");
		String OperateContent = request.getParameter("OperateContent");
		String OperateTime = request.getParameter("OperateTime");

		String Security = request.getParameter("Security");

		String IfSuccess = request.getParameter("IfSuccess");
		String OperateType = request.getParameter("OperateType");
		if (null != logs_id && !logs_id.equals("")) {
			Logs l = new Logs();
			l.setLogs_id(Integer.valueOf(logs_id).intValue());

			l.setOperate_content(OperateContent);
			// l.setOperateDate(new java.util.Date().getTime());
			l.setSecurity_class(Integer.valueOf(Security).intValue());
			l.setIf_success(false);
			l.setOperate_type(OperateType);
			try {
				if (lsi.modify(l)) {
					response.sendRedirect("/admin/LogsServlet");
				} else {
					response.getWriter().write("修改失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Logs l = new Logs();

			l.setOperate_content(OperateContent);
			l.setSecurity_class(Integer.valueOf(Security).intValue());
			// l.setOperateDate(new java.util.Date().getTime());
			l.setIf_success(false);
			l.setOperate_type(OperateType);
			try {
				if (lsi.add(l)) {
					response.sendRedirect("/admin/LogsServlet");
				} else {
					response.getWriter().write("添加失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
