import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.io.PrintWriter;
import show.DB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class as_follow extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public as_follow() {
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
		String s_id=request.getParameter("s_id");
		String a_id=request.getParameter("a_id");
		
	
	java.sql.Connection conn=null;
		
		try{
			DB db=new DB();
			conn=db.getconn();
			java.sql.Statement stmt =conn.createStatement();
			
			String join_sql="SELECT * FROM follow WHERE s_id='"+s_id+"' AND a_id='"+a_id+"' ";
		
			java.sql.ResultSet rr=stmt.executeQuery(join_sql);
		
			if(rr.next())
			{
				String follow_sql="delete from follow WHERE s_id='"+s_id+"' AND a_id='"+a_id+"' ";
				String sql = "update shetuan set a_follow=a_follow-1 where a_id="+a_id;
				int j=stmt.executeUpdate(follow_sql);
				int i = stmt.executeUpdate(sql);
				request.getRequestDispatcher("/servlet/as_put?id="+a_id).forward(request, response);
				
			}
			else{
				String follow_sql="insert follow values('"+s_id+"','"+a_id+"',now())";
			String sql = "update shetuan set a_follow=a_follow+1";
			int j=stmt.executeUpdate(follow_sql);
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				System.out.println("≤Â»Î≥…π¶");	
				request.getRequestDispatcher("/servlet/as_put?id="+a_id).forward(request, response); 
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
