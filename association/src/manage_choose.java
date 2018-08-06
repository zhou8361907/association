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
public class manage_choose extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public manage_choose() {
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
		String job=request.getParameter("job");
		String types=request.getParameter("type");
		int type=Integer.parseInt(types);
		java.sql.Connection conn=null;
		try{
			DB db=new DB();
			conn=db.getconn();
			java.sql.Statement stmt =conn.createStatement();
			
			String choose_sql="SELECT * FROM choose WHERE s_id='"+s_id+"' AND a_id='"+a_id+"' ";
		
			java.sql.ResultSet rr=stmt.executeQuery(choose_sql);
			
			if(rr.next())
			{		String sql="";
				if(type==1){
				sql = "UPDATE choose SET job='"+job+"' WHERE s_id='"+s_id+"' AND a_id='"+a_id+"' ";}
				
				if(type==0)
				{
					sql="DELETE from choose WHERE s_id='"+s_id+"' AND a_id='"+a_id+"' ";
				}
				int j=stmt.executeUpdate(sql);
				
				request.getRequestDispatcher("/servlet/manage?id="+a_id).forward(request, response);
				
			}
			else
			{
				request.getRequestDispatcher("/defeat.jsp").forward(request, response); 
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
