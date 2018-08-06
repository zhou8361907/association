package show;
import java.sql.*;
import show.DB;
public class event_join {
	
	//判断是否参加了这个活动 返回1表示参加，返回0 表示未参加
	public int pan_attend(String e_id,String s_id)
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
			String sql="select * from attend where s_id='"+s_id+"' and e_id='"+e_id+"'";     
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
