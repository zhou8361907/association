import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import show.DB;
import as.asso;
import as.event;
public class as_put extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public as_put() {
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

		response.setContentType("text/html");
		request.setCharacterEncoding("gb2312");
	   	response.setContentType("text/html;charset=gb2312");
		PrintWriter out=response.getWriter();
		
		String a_id=request.getParameter("id");
		java.sql.Connection conn=null;
		 try{
			 DB db=new DB();
				conn=db.getconn();
	  		java.sql.Statement stmt =conn.createStatement();
	  		String query="SELECT * FROM shetuan where a_id='"+a_id+"'";
	  		java.sql.ResultSet rs= stmt.executeQuery(query); 
	  		if(rs.next()){
	  			
	  			String id=rs.getString("a_id");
	  			String name=rs.getString("a_name");
	  			String charge=rs.getString("a_charge");
	  			String head=rs.getString("a_head");
	  			String time=rs.getString("a_time");
	  			String jian=rs.getString("a_jian");
	  			int follow=rs.getInt("a_follow");
	  			int news=rs.getInt("a_new");
	  			asso st=new asso(id,name,charge,head,time,jian,follow,news);
	  			
	  			request.setAttribute("st", st);
	  			
	  			request.getRequestDispatcher("/as.jsp").forward(request, response); 
	  				
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


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 this.doGet(request,response); 
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
