package show;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import as.event;
import show.DB;

/* 这个页面是用来查询活动，活动以点赞数为排列顺序排列，结果返回list表*/
public class event_show {

		public List eventshow()
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
				String sql="select * from event order by hope desc limit 0,3";        
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
		
	
		public List manage_eventshow()
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
				String sql="select * from event order by hope desc ";        
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
