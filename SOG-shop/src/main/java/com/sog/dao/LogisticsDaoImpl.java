package com.sog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sog.common.DBUtils;
import com.sog.entity.Logistics;

/**
 * @author 杨云凯
 *
 */
public class LogisticsDaoImpl implements LogisticsDaoI<Logistics> {

	public boolean update(Logistics L) throws Exception {
		
		Connection conn = DBUtils.getConnection();
		String sql = "update  logistics SET    order_id=?,company_name=?,transport_method=?,fee=?,send_time=?, send_address=?, receiver_address=?, receiver_phone=?,receiver_time=?,transport_number=?,receiver_name=?"+" where transport_id=?";
			
				
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, L.getOrder_id());
		ps.setString(2, L.getCompany_name());
		ps.setString(3, L.getTransport_method());
		ps.setBigDecimal(4, L.getFee());
		ps.setDate(5, L.getSend_time());
		ps.setString(6, L.getSend_address());
		ps.setString(7, L.getReceiver_address());
		ps.setString(8, L.getReceiver_phone());
		ps.setDate(9, L.getReceiver_time());
		ps.setString(10, L.getTransport_number());
		ps.setString(11, L.getReceiver_name());
		ps.setInt(12, L.getTransport_id());

		if (ps.executeUpdate() > 0) {
			
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	public boolean insert(Logistics L) throws SQLException {
		Connection conn = DBUtils.getConnection();
		String sql = "insert into  logistics  SET    order_id=?,company_name=?,transport_method=?,fee=?,send_time=?, send_address=?, receiver_address=?, receiver_phone=?,receiver_time=?,transport_number=?,receiver_name=?";
				
				
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, L.getOrder_id());
		ps.setString(2, L.getCompany_name());
		ps.setString(3, L.getTransport_method());
		ps.setBigDecimal(4, L.getFee());
		ps.setDate(5, L.getSend_time());
		ps.setString(6, L.getSend_address());
		ps.setString(7, L.getReceiver_address());
		ps.setString(8, L.getReceiver_phone());
		ps.setDate(9, L.getReceiver_time());
		ps.setString(10, L.getTransport_number());
		ps.setString(11, L.getReceiver_name());
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	public List<Logistics > selectAll() throws SQLException {
		Connection conn = DBUtils.getConnection();
		String sql = "SELECT * FROM logistics";
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		//将数据库中的记录转换为对象
		List<Logistics >  list=new ArrayList<Logistics >();
		//结果集
		
		
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Logistics   L=new Logistics ();
			L.setTransport_id(rs.getInt(1));
			L.setOrder_id(rs.getInt(2));
			L.setCompany_name(rs.getString(3));
			L.setTransport_method(rs.getString(4));
			L.setFee(rs.getBigDecimal(5));
			L.setSend_time(rs.getDate(6));
			L.setSend_address(rs.getString(7));
			L.setReceiver_address(rs.getString(8));
			L.setReceiver_name(rs.getString(9));
			L.setReceiver_phone(rs.getString(10));
			L.setReceiver_time(rs.getDate(11));
			L.setTransport_number(rs.getString(12));
			list.add(L);
		}
		DBUtils.close(conn, ps, rs);
		return list;
	}

	public List<Logistics > selectWhere(String whereSql) throws SQLException {
		Connection conn = DBUtils.getConnection();
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT * ");
		sb.append("FROM logistics ");
		sb.append(" WHERE 1=1 ");
		sb.append(whereSql);
		System.out.println(sb.toString());
		
		PreparedStatement ps = conn.prepareStatement(sb.toString());	
		List<Logistics>  list= new ArrayList<Logistics>();
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			
			Logistics L = new Logistics();
			L.setTransport_id(rs.getInt(1));
			L.setOrder_id(rs.getInt(2));
			L.setCompany_name(rs.getString(3));
			L.setTransport_method(rs.getString(4));
			L.setFee(rs.getBigDecimal(5));
			L.setSend_time(rs.getDate(6));
			L.setSend_address(rs.getString(7));
			L.setReceiver_address(rs.getString(8));
			L.setReceiver_name(rs.getString(9));
			L.setReceiver_phone(rs.getString(10));
			L.setReceiver_time(rs.getDate(11));
			L.setTransport_number(rs.getString(12));
	        list.add(L);
		
		}
		DBUtils.close(conn, ps, rs);
		return list;
	}

	public boolean delete(int id) throws SQLException {
		Connection conn = DBUtils.getConnection();
		String sql = "DELETE FROM logistics WHERE transport_id=?";
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	@Override
	public Map<String, Object> selectPage(String whereSql, int currentPage, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int insertre(Logistics L) throws SQLException{
		Connection conn = DBUtils.getConnection();
		String sql = "insert into  logistics  SET    order_id=?,company_name=?,transport_method=?,fee=?,send_time=?, send_address=?, receiver_address=?, receiver_phone=?,receiver_time=?,transport_number=?,receiver_name=?";
		ResultSet rs=null;
				
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, L.getOrder_id());
		ps.setString(2, L.getCompany_name());
		ps.setString(3, L.getTransport_method());
		ps.setBigDecimal(4, L.getFee());
		ps.setDate(5, L.getSend_time());
		ps.setString(6, L.getSend_address());
		ps.setString(7, L.getReceiver_address());
		ps.setString(8, L.getReceiver_phone());
		ps.setDate(9, L.getReceiver_time());
		ps.setString(10, L.getTransport_number());
		ps.setString(11, L.getReceiver_name());
		if (ps.executeUpdate() > 0) {

			rs = ps.getGeneratedKeys(); //获取结果
			rs.next();
			int ii=rs.getInt(1);
			return ii;
		}
		DBUtils.close(conn, ps, null);
		return -1;
	}
}
