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
import show.DB;
public class event_finish extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public event_finish() {
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
		
		
		
		String eid=request.getParameter("eid");
		String aid=request.getParameter("aid");
		out.println(eid);
		
		java.sql.Connection conn=null;
		
		  try{
			  DB db=new DB();
				conn=db.getconn();
	  		java.sql.Statement stmt =conn.createStatement();
	  		String query="select * from event where e_id="+eid; 
	  		out.println(query);
	  		java.sql.ResultSet re= stmt.executeQuery(query); 
	  		if(re.next()){
	  			String update_sql="update event set e_state=0 where e_id="+eid; 
	  			
	  		int j=stmt.executeUpdate(update_sql);
//	  		String name_sql="select * from shetuan where a_name="+aname;
//	  		re=stmt.executeQuery(name_sql);
//	  		if(re.next())
//	  		{
//	  			aid=re.getString("a_id");
//	  		}
	  		
	  		out.println(aid);
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
