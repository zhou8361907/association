import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import show.DB;
import as.asso;
import as.event;
public class as_search extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public as_search() {
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

		List<asso> list =new ArrayList<asso>();
		response.setContentType("text/html");
		request.setCharacterEncoding("gb2312");
	   	response.setContentType("text/html;charset=gb2312");
		PrintWriter out=response.getWriter();
		String a_new=request.getParameter("a_new");
		
		int a_n=Integer.parseInt(a_new);
	
		
		java.sql.Connection conn=null;
		
		  try{
			  DB db=new DB();
				conn=db.getconn();
	  		java.sql.Statement stmt =conn.createStatement();
	  		String query="";
	  	
	  		if(a_n==-1)
	  		{
	  		query="select * from shetuan order by a_follow desc" ;
	  			
	  		}
	  		else
	  		{
	  			query="select * from shetuan where a_new="+a_n+" order by a_follow desc" ;
	  		}
	  		
	  	
	  		java.sql.ResultSet re= stmt.executeQuery(query); 
	  		while(re.next()){
	  			
	  			String id=re.getString("a_id");
	  			String name=re.getString("a_name");
	  			String charge=re.getString("a_charge");
	  			String head=re.getString("a_head");
	  			String time=re.getString("a_time");
	  			String jian=re.getString("a_jian");
	  			int follow=re.getInt("a_follow");
	  			int news=re.getInt("a_new");
	  			asso st=new asso(id,name,charge,head,time,jian,follow,news);
	  			
	  			list.add(st);
	  			
	  			
	  				
	  			}
	  		
	  		
	  			request.setAttribute("as_search", list);
	  			request.getRequestDispatcher("/assearch.jsp").forward(request, response); 
	  			
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
