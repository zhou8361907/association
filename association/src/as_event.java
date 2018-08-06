import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import show.student_show;
import show.DB;
public class as_event extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public as_event() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("gb2312");
	   	response.setContentType("text/html;charset=gb2312");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String aid=request.getParameter("aid");
		String place=request.getParameter("place");
		String time=request.getParameter("time");
		String jian=request.getParameter("jian");
		String type=request.getParameter("type");
		String state="1";
		java.sql.Connection conn=null;
		
		try{
			DB db=new DB();
			conn=db.getconn();
			java.sql.Statement stmt =conn.createStatement();
			out.println("11");
			String zhu_sql="SELECT * FROM event where e_id='"+id+"'";
			out.println("112");
			java.sql.ResultSet rr=stmt.executeQuery(zhu_sql);
			if(rr.next())
			{
				request.getRequestDispatcher("/defeat.jsp").forward(request, response); 
				
			}
			else{
			student_show ss=new student_show();
			String a_id=ss.shetuan_name(aid);
				
				
			String sql = "insert into event values('"+id+"','"+name+"','"+time+"','"+place+"','"+type+"','"+state+"','100','"+jian+"','"+a_id+"')";
			out.println(sql);
			int i = stmt.executeUpdate(sql);
			out.println("114");
			if(i>0) {
				System.out.println("≤Â»Î≥…π¶");
		
				
				 
				 request.getRequestDispatcher("/hold.jsp?id="+aid).forward(request, response); 
				 

				
				}
			else{
				request.getRequestDispatcher("/defeat.jsp").forward(request, response); 
			}
			}
			stmt.close();
			conn.close();
			
			}catch(Exception e)
			{
				e.printStackTrace();
			}finally{
				if(conn!=null)
				{
					try{
						conn.close();
						
					}catch(SQLException e)
					{
						conn=null;
						e.printStackTrace();
					}
				}
			}
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		 this.doGet(request,response); 
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
