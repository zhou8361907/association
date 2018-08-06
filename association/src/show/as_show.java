package show;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import as.asso;
import as.event;
import show.DB;

public class as_show {

	public List asshow()
	{
		List<asso> list =new ArrayList<asso>();
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		


try { 
	 DB db=new DB();
		con=db.getconn();
	String sql="select * from shetuan where a_new=0 order by a_follow desc limit 0,5";        
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
	
	
	
	
	public List manage_asshow()
	{
		List<asso> list =new ArrayList<asso>();
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
	


try { 
	 DB db=new DB();
		con=db.getconn();
	String sql="select * from shetuan order by a_follow desc";        
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
	
	
	
	public List asshow_new()
	{
		List<asso> list =new ArrayList<asso>();
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
	String sql="select * from shetuan where a_new=1 order by a_follow desc limit 0,5";        
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
	
	
	public List asshow_hold_now(String a_name)

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
	String sql="select * from event where a_id='"+a_name+"' and e_state=1  limit 0,5";        
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
	
	
	
	public List asshow_hold_done(String a_name)

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
	String sql="select * from event where a_id='"+a_name+"' and e_state=0  limit 0,5";        
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
	
}
