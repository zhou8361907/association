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
public class manage_as extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public manage_as() {
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
		
		String aid=request.getParameter("id");
		String types=request.getParameter("type");
		int type=Integer.parseInt(types);
		
		java.sql.Connection conn=null;
		
		try{
			DB db=new DB();
			conn=db.getconn();
			java.sql.Statement stmt =conn.createStatement();
			
			
			
		
				String sql="";
				
				if(type==0){
					sql="delete from shetuan where a_id="+aid;
					
				}else
				{
					sql="update shetuan set a_new=0 where a_id="+aid;
				}
				

			int i = stmt.executeUpdate(sql);
			if(i>0) {
				
				 request.getRequestDispatcher("/insert.jsp").forward(request, response); 
				 

				}
			else{
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
