package com.sog.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sog.entity.Level_user;
import com.sog.entity.User;
import com.sog.service.Level_userServiceI;
import com.sog.service.Level_userServiceImpl;
import com.sog.service.UserServiceI;
import com.sog.service.UserServiceImpl;
/**
 * 
 * @类名: LevelServlet
 * @描述: 实现level表的增删改查,今天实现了删除后返回原页面，全部删除后的页面异常，修改后返回原页面
 * @作者：周帅
 * @日期：2018年6月29日下午10:36:55
 */
@WebServlet("/admin/LevelServlet")
public class LevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if(null!=request.getParameter("flag")){
			
			
			if("del".equals(request.getParameter("flag"))) {
				Level_userServiceI lsi=new Level_userServiceImpl();
				int id=Integer.valueOf(request.getParameter("id"));
				int curPage=Integer.valueOf(request.getParameter("cur"));
				int pageSize=3;
				try {
					if(lsi.remove(id)) {
						Map<String, Object> map = lsi.getPageAll("",curPage, pageSize);
						int pageNum=Integer.valueOf(map.get("pageNum").toString());
						
						if(curPage>=pageNum) {
							curPage=pageNum;
						}
						//当记录全部删除时，pageNUm=0,导致curPage=0,分页查询的函数第二个参数不允许curPage=0，所以检测当curPage=0，令为1；
						if(curPage<=0) {
							curPage=1;
						}
						//这里对map和page再次赋值，是当前页面的记录全部删除后，需要重新获取map,否则就会显示没有记录的那一页
						map = lsi.getPageAll("",curPage, pageSize);
						pageNum=Integer.valueOf(map.get("pageNum").toString());
						request.setAttribute("map", map);
						request.setAttribute("curPage", curPage);
						//System.out.print(userlist.size());
						request.getRequestDispatcher("/admin/level_user.jsp").forward(request, response);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if("edit".equals(request.getParameter("flag"))) {
				Level_userServiceI lsi=new Level_userServiceImpl();
				Integer id = Integer.valueOf(request.getParameter("id"));
				Integer cur = Integer.valueOf(request.getParameter("cur"));
				try {
					List<Level_user> list = lsi.getWhere(" and level_id="+id );
					if (list.size() > 0) {
						Level_user level=list.get(0);
						
						request.setAttribute("level", level);
						request.setAttribute("cur", cur);
						//
						request.getRequestDispatcher("/admin/addlevel.jsp").forward(request, response);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}	
		}
		else {
			//读取用户
			Level_userServiceI lsi=new Level_userServiceImpl();
			List<Level_user> levellist;
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

				Map<String, Object> map = lsi.getPageAll("",curPage, pageSize);
				int pageNum=Integer.valueOf(map.get("pageNum").toString());
				
				if(curPage>=pageNum) {
					curPage=pageNum;
				}
				request.setAttribute("map", map);
				request.setAttribute("curPage", curPage);
				//System.out.print(userlist.size());
				request.getRequestDispatcher("/admin/level_user.jsp").forward(request, response);
				
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
		Level_userServiceI lsi=new Level_userServiceImpl();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String scores=request.getParameter("score");
		String discounts=request.getParameter("discount");
		
		int score,discount;
		if(scores.equals(""))
		{
			score=0;
		}else {
			score=Integer.valueOf(scores);;
		}
		
		if(discounts.equals(""))
		{
			discount=0;
		}else {
			discount=Integer.valueOf(discounts);;
		}
		System.out.println("333");
		if(null!=id && !id.equals(""))
		{
		
			
			Level_user level=new Level_user();
			level.setLevel_discount(discount);
			level.setLevel_name(name);
			level.setLevel_score(score);
			level.setLevel_id(Integer.valueOf(id));
			Integer cur = Integer.valueOf(request.getParameter("cur"));
			try {
				if (lsi.modify(level)) {
					response.sendRedirect("/admin/LevelServlet?curPage="+cur);
				} else {
					response.getWriter().write("修改失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			Level_user level=new Level_user();
			level.setLevel_discount(discount);
			level.setLevel_name(name);
			level.setLevel_score(score);
			System.out.println(name);
			System.out.println(discount);
			System.out.println(score);
			try{
				if(lsi.add(level)) {
					response.sendRedirect("/admin/LevelServlet");
				}else {
					response.getWriter().write("添加失败");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}

}
