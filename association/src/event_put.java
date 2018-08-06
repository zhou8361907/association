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
import as.event;
import as.student;
public class event_put extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public event_put() {
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
		
		String e_id=request.getParameter("id");
		java.sql.Connection conn=null;
		
		  try{
			  DB db=new DB();
				conn=db.getconn();
	  		java.sql.Statement stmt =conn.createStatement();
	  		String query="SELECT * FROM event where e_id='"+e_id+"'";
	  		java.sql.ResultSet re= stmt.executeQuery(query); 
	  		if(re.next()){
	  			
	  			String id=re.getString("e_id");
	  			String name=re.getString("e_name");
	  			String time=re.getString("e_hold_time");
	  			String place=re.getString("e_hold_place");
	  			String jian=re.getString("jian");
	  			int type=re.getInt("type");
	  			int state=re.getInt("e_state");
	  			int hope=re.getInt("hope");
	  			String a_id=re.getString("a_id");
	  			event events=new event(id,name,time,place,type,state,hope,jian,a_id);
	  			
	  			request.setAttribute("events", events);
	  			
	  			request.getRequestDispatcher("/eventshow.jsp").forward(request, response); 
	  				
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
