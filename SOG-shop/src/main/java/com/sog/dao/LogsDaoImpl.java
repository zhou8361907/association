package com.sog.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sog.common.DBUtils;
import com.sog.entity.Goods;
import com.sog.entity.Logs;
public class LogsDaoImpl implements LogsDaoI<Logs> {

	
	public boolean insert(Logs t) throws SQLException {
		Connection conn = DBUtils.getConnection();
		String sql = "INSERT INTO logs (operate_content,operate_time,security_class,if_success,operate_type) VALUES(?,?,?,?,?)";
		// 创建PreparedStatement
		PreparedStatement ps= conn.prepareStatement(sql);
		
			ps = conn.prepareStatement(sql);
			ps.setString(1, t.getOperate_content());
			ps.setDate(2, new Date(new java.util.Date().getTime()));
			ps.setInt(3,t.getSecurity_class());
			ps.setBoolean(4, t.isIf_success());
			ps.setString(5,t.getOperate_type());
			if (ps.executeUpdate() > 0) {
				return true;
			}
			DBUtils.close(conn, ps, null);
		    return false;
	}

	public boolean update(Logs t) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "UPDATE logs SET operate_content=?,operate_time=?,security_class=?,if_success=?,operate_type=? where logs_id=?";
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, t.getOperate_content());
		ps.setDate(2, new Date(new java.util.Date().getTime()));
		ps.setInt(3,t.getSecurity_class());
		ps.setBoolean(4, t.isIf_success());
		ps.setString(5,t.getOperate_type());
		ps.setInt(6, t.getLogs_id());
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		
		return false;
	}

	public boolean delete(int id) throws SQLException {
		Connection conn = DBUtils.getConnection();
		String sql = "DELETE FROM logs WHERE logs_id=?";
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	
	}


	
	public List<Logs> selectWhere(String whereSql) throws SQLException {
		Connection conn = DBUtils.getConnection();
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT logs_id,operate_content,operate_time,security_class,if_success,operate_type ");
		sb.append("FROM logs ");
		sb.append(" WHERE 1=1 ");
		sb.append(whereSql);
		System.out.println(sb.toString());
		
		PreparedStatement ps = conn.prepareStatement(sb.toString());	
		List<Logs>  list= new ArrayList<Logs>();
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Logs  t=new Logs();
			t.setLogs_id(rs.getInt(1));
			t.setOperate_content(rs.getString(2));
			t.setOperate_time(rs.getDate(3));
			t.setSecurity_class(rs.getInt(4));
			t.setIf_success(rs.getBoolean(5));
			t.setOperate_type(rs.getString(6));
			list.add(t);
		}
		DBUtils.close(conn, ps, rs);
		return list;
		
	
	}

	public List<Logs> selectAll() throws SQLException {
		Connection conn = DBUtils.getConnection();
		String sql = "SELECT logs_id,operate_content,operate_time,security_class,if_success,operate_type FROM logs";
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		//将数据库中的记录转换为对象
		List<Logs>  list=new ArrayList<Logs>();
		//结果集
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Logs t=new Logs();
			t.setLogs_id(rs.getInt(1));
			t.setOperate_content(rs.getString(2));
			t.setOperate_time(rs.getDate(3));
			t.setSecurity_class(rs.getInt(4));
			t.setIf_success(rs.getBoolean(5));
			t.setOperate_type(rs.getString(6));
			list.add(t);
		}
		DBUtils.close(conn, ps, rs);
		return list;
	}

	
	public Map<String, Object> selectPage(String whereSql, int currentPage, int pageSize) throws Exception {
		Connection conn = DBUtils.getConnection();
		int index = (currentPage - 1) * pageSize;
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT * FROM logs WHERE 1=1 ");
		sb.append(whereSql);
		sb.append(" ORDER BY logs_id desc ");
		sb.append( " LIMIT " + index + "," + pageSize);

		PreparedStatement ps0 = conn.prepareStatement(sb.toString());
		ResultSet rs0 = ps0.executeQuery();
		List<Logs> list = new ArrayList<>();
	while(rs0.next()) {
		Logs l=new Logs();
		l.setLogs_id(rs0.getInt(1));
		l.setOperate_content(rs0.getString(2));
		l.setOperate_time(rs0.getDate(3));
		l.setSecurity_class(rs0.getInt(4));
		l.setIf_success(rs0.getBoolean(5));
		l.setOperate_type(rs0.getString(6));
		list.add(l);
		}
		String sql = "SELECT count(*) FROM logs  WHERE 1=1 " + whereSql;
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
		
		DBUtils.close(conn, ps0, rs0);
		DBUtils.close(conn, ps1, rs1);
		return map;
	}
	}

