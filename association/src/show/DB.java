package show;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Locale; 
import java.util.ResourceBundle; 

public class DB {
	private   static String url;
	private   static String user;
	private   static String passwd;
	private static Connection conn;
	
	public static Connection getconn()
	{
		
		
		try{
			ResourceBundle resb = ResourceBundle.getBundle("config"); 
			url=resb.getString("db_url");
			user=resb.getString("db_user");
			passwd=resb.getString("db_pass");
			
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, passwd);
            return conn;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
		
	}
	
	
    

	
}
