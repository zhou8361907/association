package show;
import java.sql.*;
import show.DB;
public class judge {

	//判断是否对这个活动点赞
	public int pan_zan(String s_id,String e_id)
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
			String sql="select * from zan where s_id='"+s_id+"' and e_id='"+e_id+"'";     
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			if(rs.next())
			{	
			i=1;
			}
			else
			{
				i=0;
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
		if(i==1)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}

	
	
	public int pan_follow(String s_id,String a_id)
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
			String sql="select * from follow where s_id='"+s_id+"' and a_id='"+a_id+"'";     
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			if(rs.next())
			{	
			i=1;
			}
			else
			{
				i=0;
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
		if(i==1)
		{
			return 1;
		}
		else
		{
			return 0;
		}
		
		
	}



}
