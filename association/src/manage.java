import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import as.event;
import as.appli;
import show.DB;
import as.choose;
public class manage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public manage() {
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
        List<appli> list=new ArrayList<appli>();
        List<event> event_list =new ArrayList<event>();
        List<choose> choose_list =new ArrayList<choose>();
		response.setContentType("text/html");
		request.setCharacterEncoding("gb2312");
	   	response.setContentType("text/html;charset=gb2312");
		PrintWriter out=response.getWriter();
		
		String aid=request.getParameter("id");
		java.sql.Connection conn=null;
		
		  try{
			  DB db=new DB();
				conn=db.getconn();
	  		java.sql.Statement stmt =conn.createStatement();
	  		String appli_query="SELECT * FROM appli where a_id="+aid;
	  		java.sql.ResultSet re= stmt.executeQuery(appli_query); 
	  	
	  		while(re.next()){
	  			
	  			String s_id=re.getString("s_id");
	  			String a_id=re.getString("a_id");
	  			String part=re.getString("part");
	  			
	  			appli app=new appli(s_id,a_id,part);
	  			
	  			list.add(app);	
	  			}
	  		//获取申报社团的人员
	  		request.setAttribute("manage_appli", list);
	  		
	  		
	  		
	  		
	  		
	  		
	  		String hold_query="SELECT * FROM event where e_state=1 and a_id=("+"select a_name from shetuan where a_id="+aid+")";
	  		
	  		java.sql.ResultSet rs= stmt.executeQuery(hold_query); 
	  		
	  		while(rs.next()){
	  			
	  			String id=rs.getString("e_id");
	  			String name=rs.getString("e_name");
	  			String time=rs.getString("e_hold_time");
	  			String place=rs.getString("e_hold_place");
	  			String jian=rs.getString("jian");
	  			int type=rs.getInt("type");
	  			int state=rs.getInt("e_state");
	  			int hope=rs.getInt("hope");
	  			String a_id=rs.getString("a_id");
	  			out.println(a_id);
	  			event events=new event(id,name,time,place,type,state,hope,jian,aid);
	  			event_list.add(events);
	  		}
	  		//获取该社团举办的活动
	  		request.setAttribute("event_hold", event_list);
	  		
	  		
	  		String choose_query="select * from choose where a_id="+aid;
	  		java.sql.ResultSet rc= stmt.executeQuery(choose_query); 
	  		while(rc.next()){
	  			
	  			String sid=rc.getString("s_id");
	  			String aaid=rc.getString("a_id");
	  			String job=rc.getString("job");
	  			String part=rc.getString("part");
	  			choose ch=new choose(sid,aaid,job,part);
	  			choose_list.add(ch);
	  			
	  		}
	  		//获取加入该社团的成员
	  		request.setAttribute("manage_choose", choose_list);
	  		
	  		
	  		
	  		
	  		request.getRequestDispatcher("/manage.jsp").forward(request, response); 
	  		
	  		
	  		
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
