import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.DriverManager;
import java.sql.SQLException;
import show.DB;
import as.student;
public class as_login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public as_login() {
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
			
			 String sname=request.getParameter("username");
		      String spas=request.getParameter("password");
		      request.setAttribute("accout", sname);
		      request.setAttribute("password", spas);
		 
		      java.sql.Connection conn=null;
		      //获得来源网址登录成功后返回原地址
		      String fromURL = request.getHeader("Referer");
		     out.println(fromURL);
		     out.println(fromURL.substring(42));
		     out.println(fromURL.substring(40));
		      try{
		    	  DB db=new DB();
					conn=db.getconn();
		  		java.sql.Statement stmt =conn.createStatement();
		  		String query="SELECT * FROM student where s_id='"+sname+"' and s_password='"+spas+"'";
		  		java.sql.ResultSet re= stmt.executeQuery(query); 
		  		HttpSession hs=request.getSession(true);
		  		if(re.next()){

		  			student students=new student();
		  			students.setName(re.getString("s_name"));
		  			students.setId(re.getString("s_id"));
		  			students.setSex(re.getString("s_sex"));
		  			students.setAcademy(re.getString("s_academy"));
		  			students.setPhone(re.getString("s_phone"));
		  			
		  			hs.setAttribute("user", students);
		  			if(fromURL.length()>44)
		  				{ request.getRequestDispatcher(fromURL.substring(42)).forward(request, response); }
		  			else
		  			{
		  				request.getRequestDispatcher("/index.jsp").forward(request, response); 
		  			}
		  			}
		  			else{
		  				
		  				request.getRequestDispatcher("/index.jsp").forward(request, response); 
		  			}
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
