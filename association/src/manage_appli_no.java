import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import as.event;
import as.appli;
import show.DB;
public class manage_appli_no extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public manage_appli_no() {
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
		
		
		
		String aid=request.getParameter("aid");
		String sid=request.getParameter("sid");
		String part=request.getParameter("part");
		
	
		
				
			
				java.sql.Connection conn=null;
				
				  try{
					  DB db=new DB();
						conn=db.getconn();
			  		java.sql.Statement stmt =conn.createStatement();
			  		String query="select * from appli where a_id="+aid+" and s_id="+sid; 
			  		out.println(query);
			  		java.sql.ResultSet re= stmt.executeQuery(query); 
			  		if(re.next()){
			  			String delete_sql="delete from appli where a_id="+aid+" and s_id="+sid; 
			  			out.println(delete_sql);
			  		int j=stmt.executeUpdate(delete_sql);
			  			request.getRequestDispatcher("/servlet/manage?id="+aid).forward(request, response); 
			  				
			  			}
			  			else{
			  				request.getRequestDispatcher("/defeat.jsp").forward(request, response);  
			  			}
			  		}catch(Exception e){}
			  		finally{
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
