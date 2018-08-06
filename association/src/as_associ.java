import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import as.asso;
import as.student;
import show.DB;

public class as_associ extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public as_associ() {
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
			String aname=request.getParameter("name");
			String aid=request.getParameter("id");
			String acharge=request.getParameter("charge");
			String ahead=request.getParameter("head");
			String atime=request.getParameter("time");
			String ajian=request.getParameter("jian");
			
			java.sql.Connection conn=null;
			
			try{
				
				DB db=new DB();
				conn=db.getconn();
				
				java.sql.Statement stmt =conn.createStatement();
				
				String zhu_sql="SELECT * FROM shetuan where a_id='"+aid+"'";
				
				java.sql.ResultSet rr=stmt.executeQuery(zhu_sql);
				if(rr.next())
				{
					request.getRequestDispatcher("/defeat.jsp").forward(request, response); 
					
				}
				else{
				String sql = "insert into shetuan values('"+aid+"','"+aname+"','"+acharge+"','"+ahead+"','"+atime+"','"+ajian+"','100','1')";
				int i = stmt.executeUpdate(sql);
				if(i>0) {
					System.out.println("≤Â»Î≥…π¶");
			
					
					 
					 request.getRequestDispatcher("/insert.jsp").forward(request, response); 
					 

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
