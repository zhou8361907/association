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
import show.DB;
import as.event;
import as.appli;
import as.student;

public class attend_show extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public attend_show() {
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

		  List<student> list=new ArrayList<student>();

			response.setContentType("text/html");
			request.setCharacterEncoding("gb2312");
		   	response.setContentType("text/html;charset=gb2312");
			PrintWriter out=response.getWriter();
			
			String eid=request.getParameter("id");
			java.sql.Connection conn=null;
			
			  try{
				  DB db=new DB();
					conn=db.getconn();
		  		java.sql.Statement stmt =conn.createStatement();
		  		String attend_query="SELECT * FROM attend,student where attend.s_id=student.s_id and e_id="+eid;
		  		java.sql.ResultSet re= stmt.executeQuery(attend_query); 
		  	
		  		while(re.next()){
		  			student students=new student();
		  			students.setName(re.getString("s_name"));
					students.setId(re.getString("s_id"));
					students.setSex(re.getString("s_sex"));
					students.setAcademy(re.getString("s_academy"));
					students.setPhone(re.getString("s_phone"));
					students.setPassword(re.getString("s_password"));
		  			
		  			list.add(students);	
		  			}
		  		//获取申报活动的人员
		  		request.setAttribute("attend_show", list);
		  		request.getRequestDispatcher("/attendshow.jsp").forward(request, response); 
		  		
		  		
		  		
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

		this.doGet(request, response);
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
