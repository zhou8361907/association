import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import show.DB;
import as.student;


public class as_register extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public as_register() {
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
		String sacademy=request.getParameter("academy");
		String sname=request.getParameter("name");
		String sre=request.getParameter("re_password");
		String ssex=request.getParameter("sex");
		String sid=request.getParameter("id");
		String spassword=request.getParameter("password");
		String sphone=request.getParameter("phone");
		
		java.sql.Connection conn=null;
		
		try{
			DB db=new DB();
			conn=db.getconn();
			java.sql.Statement stmt =conn.createStatement();
			
			String zhu_sql="SELECT * FROM student where s_id='"+sid+"'";
			
			java.sql.ResultSet rr=stmt.executeQuery(zhu_sql);
			if(rr.next())
			{
				request.getRequestDispatcher("/defeat.jsp").forward(request, response); 
				
			}
			else{
			String sql = "insert into student values('"+sid+"','"+sname+"','"+ssex+"','"+sacademy+"','"+sphone+"','"+spassword+"')";
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				System.out.println("≤Â»Î≥…π¶");
				student stu=new student();
				stu.setName(sname);
				stu.setId(sid);
				stu.setPassword(spassword);
				stu.setAcademy(sacademy);
				stu.setSex(ssex);
				stu.setPhone(sphone);
				request.setAttribute("student", stu);
				
				 
				 request.getRequestDispatcher("/zhuce.jsp").forward(request, response); 	
				}
			else{
				request.getRequestDispatcher("/defeat.jsp").forward(request, response); 
			}
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
