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
import java.util.Date;

import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import show.DB;

public class event_zan extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public event_zan() {
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
		String e_id=request.getParameter("e_id");
		
	
	java.sql.Connection conn=null;
		
		try{
			DB db=new DB();
			conn=db.getconn();
			java.sql.Statement stmt =conn.createStatement();
			
			String join_sql="SELECT * FROM zan WHERE s_id='"+s_id+"' AND e_id='"+e_id+"' ";
		
			java.sql.ResultSet rr=stmt.executeQuery(join_sql);
			
			if(rr.next())
			{
				String zan_sql="delete from zan WHERE s_id='"+s_id+"' AND e_id='"+e_id+"' ";
				String sql = "update event set hope=hope-1 where e_id="+e_id;
				int j=stmt.executeUpdate(zan_sql);
				int i = stmt.executeUpdate(sql);
				request.getRequestDispatcher("/servlet/event_put?id="+e_id).forward(request, response);
				
			}
			else{
				String zan_sql="insert zan values('"+s_id+"','"+e_id+"',now())";
			String sql = "update event set hope=hope+1 where e_id="+e_id;
			int j=stmt.executeUpdate(zan_sql);
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				System.out.println("≤Â»Î≥…π¶");	
				request.getRequestDispatcher("/servlet/event_put?id="+e_id).forward(request, response); 
				}
			else
			{
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
