package com.sog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sog.common.DBUtils;
import com.sog.entity.Brand;
import com.sog.entity.Level_user;
import com.sog.entity.User;


/**
 * 
 * @类名: Level_userDaoImpl
 * @描述: Level_user接口实现
 * @作者：周帅
 * @日期：2018年6月29日上午10:50:39
 */

public class Level_userDaoImpl implements Level_userDaoI<Level_user> {

	@Override
	public boolean insert(Level_user t) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "INSERT INTO level_user (level_name,level_socre,level_discount) VALUES(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, t.getLevel_name());
		ps.setInt(2,t.getLevel_score());
		ps.setInt(3, t.getLevel_discount());
		if (ps.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Level_user t) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql="UPDATE level_user SET level_name=?,level_socre=?,level_discount=? WHERE level_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, t.getLevel_name());
		ps.setInt(2, t.getLevel_score());
		ps.setInt(3, t.getLevel_discount());
		ps.setInt(4, t.getLevel_id());
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	@Override
	public boolean delete(int id) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql="DELETE FROM level_user WHERE level_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	@Override
	public List<Level_user> selectAll() throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql="SELECT level_id,level_name,level_socre,level_discount FROM level_user";
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		//将数据库中的记录转换为对象
		List<Level_user>  list=new ArrayList<>();
		//结果集
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Level_user level=new Level_user();
			level.setLevel_id(rs.getInt(1));
			level.setLevel_name(rs.getString(2));
			level.setLevel_score(rs.getInt(3));
			level.setLevel_discount(rs.getInt(4));
			list.add(level);
		}
		DBUtils.close(conn, ps, rs);
		return list;
	}

	@Override
	public List<Level_user> selectWhere(String whereSql) throws Exception {
		Connection conn = DBUtils.getConnection();
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT level_id,level_name,level_socre,level_discount ");
		sb.append("FROM level_user ");
		sb.append(" WHERE 1=1 ");
		sb.append(whereSql);
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sb.toString());
		//将数据库中的记录转换为对象
		List<Level_user>  list=new ArrayList<>();
		//结果集
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Level_user level=new Level_user();
			level.setLevel_id(rs.getInt(1));
			level.setLevel_name(rs.getString(2));
			level.setLevel_score(rs.getInt(3));
			level.setLevel_discount(rs.getInt(4));
			list.add(level);
		}
		DBUtils.close(conn, ps, rs);
		return list;
	}

	@Override
	public Map<String, Object> selectPage(String whereSql, int currentPage, int pageSize) throws Exception {
		Connection conn = DBUtils.getConnection();
		int index = (currentPage - 1) * pageSize;
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT level_id,level_name,level_socre,level_discount FROM level_user WHERE 1=1 ");
		sb.append(whereSql);
		sb.append(" ORDER BY level_id desc ");
		sb.append( " LIMIT " + index + "," + pageSize);
//		String sql = "SELECT id,roleName,remark FROM role WHERE 1=1 " + whereSql + " LIMIT " + index + "," + pageSize;
		PreparedStatement ps0 = conn.prepareStatement(sb.toString());
		ResultSet rs0 = ps0.executeQuery();
		List<Level_user>  list=new ArrayList<>();
		
		while (rs0.next()) {
			Level_user level=new Level_user();
			level.setLevel_id(rs0.getInt(1));
			level.setLevel_name(rs0.getString(2));
			level.setLevel_score(rs0.getInt(3));
			level.setLevel_discount(rs0.getInt(4));
			list.add(level);
		}
		

		String sql = "SELECT count(*) FROM level_user  WHERE 1=1 " + whereSql;
		PreparedStatement ps1 = conn.prepareStatement(sql);
		ResultSet rs1 = ps1.executeQuery();
		int count = 0;
		int pageNum=0;
		if (rs1.next()) {
			count = rs1.getInt(1);
		}
		Map<String,Object> map=new HashMap<>();
		
		if(count%pageSize==0) {
			pageNum=count/pageSize;
		}else {
			pageNum=count/pageSize+1;
		}
		
		map.put("list", list);
		map.put("count", count);
		map.put("pageNum", pageNum);
		//关闭连接
		DBUtils.close(conn, ps0, rs0);
		DBUtils.close(conn, ps1, rs1);
		return map;
	}

}
