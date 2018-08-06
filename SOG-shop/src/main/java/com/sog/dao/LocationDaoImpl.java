package com.sog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sog.common.DBUtils;
import com.sog.entity.Level_user;
import com.sog.entity.Location;

public class LocationDaoImpl implements LocationDaoI<Location> {

	@Override
	public boolean insert(Location t) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "INSERT INTO location (user_id,name,phone,location) VALUES(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, t.getUserId());
		ps.setString(2,t.getName());
		ps.setString(3, t.getPhone());
		ps.setString(4, t.getLocation());
		if (ps.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Location t) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql="UPDATE location SET user_id=?,name=?,phone=?,location=? WHERE location_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, t.getUserId());
		ps.setString(2,t.getName());
		ps.setString(3, t.getPhone());
		ps.setString(4, t.getLocation());
		ps.setInt(5, t.getLocationId());
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	@Override
	public boolean delete(int id) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql="DELETE FROM location WHERE location_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	@Override
	public List<Location> selectAll() throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql="SELECT location_id,user_id,name,phone,location FROM location";
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		//将数据库中的记录转换为对象
		List<Location>  list=new ArrayList<>();
		//结果集
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Location location=new Location(); 
			location.setLocationId(rs.getInt(1));
			location.setUserId(rs.getInt(2));
			location.setName(rs.getString(3));
			location.setPhone(rs.getString(4));
			location.setLocation(rs.getString(5));
			list.add(location);
		}
		DBUtils.close(conn, ps, rs);
		return list;
	}

	@Override
	public List<Location> selectWhere(String whereSql) throws Exception {
		Connection conn = DBUtils.getConnection();
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT location_id,user_id,name,phone,location ");
		sb.append("FROM location ");
		sb.append(" WHERE 1=1 ");
		sb.append(whereSql);
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sb.toString());
		//将数据库中的记录转换为对象
		List<Location>  list=new ArrayList<>();
		//结果集
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Location location=new Location(); 
			location.setLocationId(rs.getInt(1));
			location.setUserId(rs.getInt(2));
			location.setName(rs.getString(3));
			location.setPhone(rs.getString(4));
			location.setLocation(rs.getString(5));
			list.add(location);
		}
		DBUtils.close(conn, ps, rs);
		return list;
	}

	@Override
	public Map<String, Object> selectPage(String whereSql, int currentPage, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
