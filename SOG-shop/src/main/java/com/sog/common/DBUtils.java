package com.sog.common;
/**
 * 
 * @类名 DBUtils
 * @描述   用于JDBC链接数据库
 * @作者   王帅
 * @日期 2018年6月22日 下午2:49:25
 *
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtils {
	private final static String driver = "com.mysql.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/sog-shop?useSSL=false&characterEncoding=UTF-8";
	private final static String user = "root";
	private final static String pwd = "123456";
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接对象
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(url,user,pwd);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 资源关闭
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void close(Connection conn,java.sql.PreparedStatement ps, ResultSet rs) {
		
			try {
				if(rs!=null) {
					rs.close();					
				}
				if(ps!=null) {
					ps.close();					
				}
				if(conn!=null) {
					conn.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
}
