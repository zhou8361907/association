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
import as.event;
public class event_search extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public event_search() {
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
		List<event> list =new ArrayList<event>();
		response.setContentType("text/html");
		request.setCharacterEncoding("gb2312");
	   	response.setContentType("text/html;charset=gb2312");
		PrintWriter out=response.getWriter();
		String e_type=request.getParameter("type");
		String e_state=request.getParameter("state");
		int types=Integer.parseInt(e_type);
		int states=Integer.parseInt(e_state);
		
		java.sql.Connection conn=null;
		
		  try{
			  DB db=new DB();
				conn=db.getconn();
	  		java.sql.Statement stmt =conn.createStatement();
	  		String query="";
	  	
	  		if(types==-1&&states==-1)
	  		{
	  		query="select * from event order by hope desc" ;
	  			
	  		}
	  		else if( types==-1&&states!=-1)
	  		{
	  			query="select * from event where e_state="+states+" order by hope desc" ;
	  		}
	  		else if(types!=-1&&states==-1 )
	  		{
	  			query="select * from event where type="+types+" order by hope desc" ;
	  		}
	  		else if(types!=-1&&states!=-1)
	  		{
	  			query="select * from event where type="+types+" and e_state="+states+" order by hope desc" ;
	  		}
	  	
	  		java.sql.ResultSet re= stmt.executeQuery(query); 
	  		while(re.next()){
	  			
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
	  			list.add(events);
	  			
	  			//request.setAttribute("event_search", events);
	  			//request.getRequestDispatcher("/eventsearch.jsp").forward(request, response); 
	  			
	  				
	  			}
	  		
	  		
	  			request.setAttribute("event_search", list);
	  			request.getRequestDispatcher("/eventsearch.jsp").forward(request, response); 
	  			
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
