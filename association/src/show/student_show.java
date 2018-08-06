package show;
import java.sql.Connection;
import show.DB;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import as.choose;
import as.appli;
import as.event;
import as.student;
import as.asso;
public class student_show {
	
	//由学号得到对应的appli
	public List student_appli(String s_id)
	{
		
		List<appli> list =new ArrayList<appli>();
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
	          Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	             e.printStackTrace();
	         }


try { 
	DB db=new DB();
	con=db.getconn();
	String sql="select * from appli where s_id="+s_id;        
	psmt=con.prepareStatement(sql);
	rs=psmt.executeQuery();
	while(rs.next())
	{	
		String sid=rs.getString("s_id");
		String aid=rs.getString("a_id");
		String part=rs.getString("part");
		appli app=new appli(sid,aid,part);
		list.add(app);
	
	}
}
catch (SQLException e) {
	 e.printStackTrace();
}finally
{ 
	 try {
		 if(rs!=null)
			              {
			                  rs.close();
			                }
			               if(psmt!=null)
			               {
			                    psmt.close();
			                }
			              if(con!=null)
			                 {
			                      con.close();
			                  }
			              } catch (SQLException e) {
			                  e.printStackTrace();
			              }
			         }
		
		
		
		
		
		return list;
		
		
	}

	//由学号得到对应的choose
	
	public List student_choose(String s_id)
	{
		
		List<choose> list =new ArrayList<choose>();
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
	          Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	             e.printStackTrace();
	         }


try { 
	DB db=new DB();
	con=db.getconn();
	String sql="select * from choose where s_id="+s_id;        
	psmt=con.prepareStatement(sql);
	rs=psmt.executeQuery();
	while(rs.next())
	{	
		String sid=rs.getString("s_id");
		String aid=rs.getString("a_id");
		String job=rs.getString("job");
		String part=rs.getString("part");
		choose ch=new choose(sid,aid,job,part);
		list.add(ch);
	
	}
}
catch (SQLException e) {
	 e.printStackTrace();
}finally
{ 
	 try {
		 if(rs!=null)
			              {
			                  rs.close();
			                }
			               if(psmt!=null)
			               {
			                    psmt.close();
			                }
			              if(con!=null)
			                 {
			                      con.close();
			                  }
			              } catch (SQLException e) {
			                  e.printStackTrace();
			              }
			         }
		
		
		
		
		
		return list;
		
		
	}

	//由社团号得到对应的社团名
	
	public String shetuan_name(String a_id)
	{
		String a_name="";
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
	          Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	             e.printStackTrace();
	         }


try { 
	DB db=new DB();
	con=db.getconn();
	String sql="select * from shetuan where a_id="+a_id;        
	psmt=con.prepareStatement(sql);
	rs=psmt.executeQuery();
	if(rs.next())
	{	
	a_name=rs.getString("a_name");
	
	}
}
catch (SQLException e) {
	 e.printStackTrace();
}finally
{ 
	 try {
		 if(rs!=null)
			              {
			                  rs.close();
			                }
			               if(psmt!=null)
			               {
			                    psmt.close();
			                }
			              if(con!=null)
			                 {
			                      con.close();
			                  }
			              } catch (SQLException e) {
			                  e.printStackTrace();
			              }
			         }
		
		
		
		
		
		return a_name;
	}
	
	//通过社团号和学生号查找是否在社团中担任职务或申请加入社团
	public int attend_s(String s_id,String a_id)
	{
		int i=0;
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
	          Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	             e.printStackTrace();
	         }


try { 
	DB db=new DB();
	con=db.getconn();
	String sql="SELECT * FROM appli WHERE s_id='"+s_id+"' AND a_id='"+a_id+"' ";     
	psmt=con.prepareStatement(sql);
	rs=psmt.executeQuery();
	if(rs.next())
	{	
		i++;
		
	
	}
	sql="SELECT * FROM choose WHERE s_id='"+s_id+"' AND a_id='"+a_id+"' ";     
	psmt=con.prepareStatement(sql);
	rs=psmt.executeQuery();
	if(rs.next())
	{	
		i++;
		
	
	}
	
	
	
}
catch (SQLException e) {
	 e.printStackTrace();
}finally
{ 
	 try {
		 if(rs!=null)
			              {
			                  rs.close();
			                }
			               if(psmt!=null)
			               {
			                    psmt.close();
			                }
			              if(con!=null)
			                 {
			                      con.close();
			                  }
			              } catch (SQLException e) {
			                  e.printStackTrace();
			              }
			         }
		
		
		
		
		
		
		return i;
		
	}
	
	//由社团名得到对应的社团号
	
	public String shetuan_id(String a_name)
	{
		String a_id="";
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
	          Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	             e.printStackTrace();
	         }


try { 
	DB db=new DB();
	con=db.getconn();
	String sql="select * from shetuan where a_name="+a_name;        
	psmt=con.prepareStatement(sql);
	rs=psmt.executeQuery();
	if(rs.next())
	{	
	a_id=rs.getString("a_id");
	
	}
}
catch (SQLException e) {
	 e.printStackTrace();
}finally
{ 
	 try {
		 if(rs!=null)
			              {
			                  rs.close();
			                }
			               if(psmt!=null)
			               {
			                    psmt.close();
			                }
			              if(con!=null)
			                 {
			                      con.close();
			                  }
			              } catch (SQLException e) {
			                  e.printStackTrace();
			              }
			         }
		
		
		
		
		
		return a_id;
	}
	
	
	//由学号得到对应的对社团的点赞表
	public List as_follow(String s_id)
	{
		List<asso> list=new ArrayList<asso>();
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
	          Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	             e.printStackTrace();
	         }


try { 
	DB db=new DB();
	con=db.getconn();
	String sql="select * from shetuan,follow where shetuan.a_id=follow.a_id and s_id='"+s_id+"' order by follow_time desc limit 0,5";        
	psmt=con.prepareStatement(sql);
	rs=psmt.executeQuery();
	while(rs.next())
	{	
		String id=rs.getString("a_id");
		String name=rs.getString("a_name");
		String charge=rs.getString("a_charge");
		String head=rs.getString("a_head");
		String time=rs.getString("a_time");
		String jian=rs.getString("a_jian");
		int follow=rs.getInt("a_follow");
		int news=rs.getInt("a_new");
		asso st=new asso(id,name,charge,head,time,jian,follow,news);
		list.add(st);
	
	}
}
catch (SQLException e) {
	 e.printStackTrace();
}finally
{ 
	 try {
		 if(rs!=null)
			              {
			                  rs.close();
			                }
			               if(psmt!=null)
			               {
			                    psmt.close();
			                }
			              if(con!=null)
			                 {
			                      con.close();
			                  }
			              } catch (SQLException e) {
			                  e.printStackTrace();
			              }
			         }
		
		
		
		
		
		
		return list;
		
	}

	
	
	//由学号得到对应的点赞表
	
	public List event_zan(String s_id)
	{
		List<event> list =new ArrayList<event>();
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
	          Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	             e.printStackTrace();
	         }


try { 
	DB db=new DB();
	con=db.getconn();
	String sql="select * from zan,event where zan.e_id=event.e_id and s_id='"+s_id+"' and e_state=1 order by zan_time desc limit 0,5";        
	psmt=con.prepareStatement(sql);
	rs=psmt.executeQuery();
	while(rs.next())
	{	
		String id=rs.getString("e_id");
		String name=rs.getString("e_name");
		String time=rs.getString("e_hold_time");
		String place=rs.getString("e_hold_place");
		String jian=rs.getString("jian");
		int type=rs.getInt("type");
		int state=rs.getInt("e_state");
		int hope=rs.getInt("hope");
		String a_id=rs.getString("a_id");
		event ev=new event(id,name,time,place,type,state,hope,jian,a_id);
		list.add(ev);
	
	}
}
catch (SQLException e) {
	 e.printStackTrace();
}finally
{ 
	 try {
		 if(rs!=null)
			              {
			                  rs.close();
			                }
			               if(psmt!=null)
			               {
			                    psmt.close();
			                }
			              if(con!=null)
			                 {
			                      con.close();
			                  }
			              } catch (SQLException e) {
			                  e.printStackTrace();
			              }
			         }
		
		
		
		
		
		return list;
		
	}

	//判断是否是社团的负责人，若是返回社团号
	public String judge_charge(String s_id)
	{
		String a_id="";
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
	          Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	             e.printStackTrace();
	         }


try { 
	DB db=new DB();
	con=db.getconn();
	String sql="select * from shetuan where a_id="+s_id;        
	psmt=con.prepareStatement(sql);
	rs=psmt.executeQuery();
	if(rs.next())
	{	
	a_id=rs.getString("a_id");
	
	}
}
catch (SQLException e) {
	 e.printStackTrace();
}finally
{ 
	 try {
		 if(rs!=null)
			              {
			                  rs.close();
			                }
			               if(psmt!=null)
			               {
			                    psmt.close();
			                }
			              if(con!=null)
			                 {
			                      con.close();
			                  }
			              } catch (SQLException e) {
			                  e.printStackTrace();
			              }
			         }
		
		
		
		
		
		return a_id;
	}
	
	//由学号返回学生信息
	public student student_info(String s_id)

	{
		student students=new student();
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
	          Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	             e.printStackTrace();
	         }


try { 
	DB db=new DB();
	con=db.getconn();
	String sql="select * from student where s_id="+s_id;        
	psmt=con.prepareStatement(sql);
	rs=psmt.executeQuery();
	if(rs.next())
	{	
		
			students.setName(rs.getString("s_name"));
			students.setId(rs.getString("s_id"));
			students.setSex(rs.getString("s_sex"));
			students.setAcademy(rs.getString("s_academy"));
			students.setPhone(rs.getString("s_phone"));
			students.setPassword(rs.getString("s_password"));
		
	
	}
}
catch (SQLException e) {
	 e.printStackTrace();
}finally
{ 
	 try {
		 if(rs!=null)
			              {
			                  rs.close();
			                }
			               if(psmt!=null)
			               {
			                    psmt.close();
			                }
			              if(con!=null)
			                 {
			                      con.close();
			                  }
			              } catch (SQLException e) {
			                  e.printStackTrace();
			              }
			         }
		
		
		return students;
	}
	
	//由活动编号返回参加人数
	public int event_num(String e_id)
	{
		int i=0;
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
	          Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	             e.printStackTrace();
	         }


try { 
	DB db=new DB();
	con=db.getconn();
	String sql="select * from attend where e_id="+e_id;        
	psmt=con.prepareStatement(sql);
	rs=psmt.executeQuery();
	while(rs.next())
	{	
		i++;
		
	
	}
}
catch (SQLException e) {
	 e.printStackTrace();
}finally
{ 
	 try {
		 if(rs!=null)
			              {
			                  rs.close();
			                }
			               if(psmt!=null)
			               {
			                    psmt.close();
			                }
			              if(con!=null)
			                 {
			                      con.close();
			                  }
			              } catch (SQLException e) {
			                  e.printStackTrace();
			              }
			         }
		
		return i;
		
	}
	
	
	//由活动编号返回活动信息
	public event event_info(String e_id)
	{
		event ev=null;
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
	          Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	             e.printStackTrace();
	         }


try { 
	DB db=new DB();
	con=db.getconn();
	String sql="select * from event where e_id="+e_id;        
	psmt=con.prepareStatement(sql);
	rs=psmt.executeQuery();
	if(rs.next())
	{	
		String id=rs.getString("e_id");
			String name=rs.getString("e_name");
			String time=rs.getString("e_hold_time");
			String place=rs.getString("e_hold_place");
			String jian=rs.getString("jian");
			int type=rs.getInt("type");
			int state=rs.getInt("e_state");
			int hope=rs.getInt("hope");
			String a_id=rs.getString("a_id");
			ev=new event(id,name,time,place,type,state,hope,jian,a_id);
		
	
	}
}
catch (SQLException e) {
	 e.printStackTrace();
}finally
{ 
	 try {
		 if(rs!=null)
			              {
			                  rs.close();
			                }
			               if(psmt!=null)
			               {
			                    psmt.close();
			                }
			              if(con!=null)
			                 {
			                      con.close();
			                  }
			              } catch (SQLException e) {
			                  e.printStackTrace();
			              }
			         }
		
		
		
		return ev;
		
	}
}
