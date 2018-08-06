package com.sog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sog.common.DBUtils;
import com.sog.entity.Roles;


/**
 * @author 杨云凯
 *
 */
public class RolesDaoImpl implements RolesDaoI<Roles> {

	public boolean update(Roles r) throws Exception {
		
		Connection conn = DBUtils.getConnection();
		String sql = "update   role   SET role_position=?,role_privilege=?"+" where role_id=?";;
				
				
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);

	
	ps.setString(1,r.getRole_position() );
	ps.setInt(2, r.getRole_privilege());
	ps.setInt(3, r.getRole_id());
	

		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	public boolean insert (Roles r) throws SQLException {
		Connection conn = DBUtils.getConnection();
		String sql = "insert into  role  SET role_position=?,role_privilege=?";
				
				
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1,r.getRole_position());
	ps.setInt(2, r.getRole_privilege());
	
	

		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	public List<Roles> selectAll() throws SQLException {
		Connection conn = DBUtils.getConnection();
		String sql = "SELECT * FROM role";
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		//将数据库中的记录转换为对象
		List<Roles>  list=new ArrayList<Roles>();
		//结果集
		
		
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
		Roles r=new Roles();
			r.setRole_id(rs.getInt(1));
			r.setRole_position(rs.getString(2));
		r.setRole_privilege(rs.getInt(3));
					
			list.add(r);
		}
		DBUtils.close(conn, ps, rs);
		return list;
	}

	public List<Roles> selectWhere(String whereSql) throws SQLException {
		Connection conn = DBUtils.getConnection();
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT * ");
		sb.append("FROM role ");
		sb.append(" WHERE 1=1 ");
		sb.append(whereSql);
		System.out.println(sb.toString());
		
		PreparedStatement ps = conn.prepareStatement(sb.toString());	
		List<Roles>  list= new ArrayList<Roles>();
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Roles  r=new Roles();
			r.setRole_id(rs.getInt(1));
			r.setRole_position(rs.getString(2));
		r.setRole_privilege(rs.getInt(3));
			list.add(r);
		
		
		}
		DBUtils.close(conn, ps, rs);
		return list;
	}

	public boolean delete(int id) throws SQLException {
		Connection conn = DBUtils.getConnection();
		String sql = "DELETE FROM role WHERE role_id=?";
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
		Connection conn = DBUtils.getConnection();
		int index = (currentPage - 1) * pageSize;
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT role_id,role_position,role_privilege FROM role WHERE 1=1 ");
		sb.append(whereSql);
		sb.append(" ORDER BY role_id desc ");
		sb.append( " LIMIT " + index + "," + pageSize);
//		String sql = "SELECT id,roleName,remark FROM role WHERE 1=1 " + whereSql + " LIMIT " + index + "," + pageSize;
		PreparedStatement ps0 = conn.prepareStatement(sb.toString());
		ResultSet rs0 = ps0.executeQuery();
		List<Roles> list = new ArrayList<>();
		while (rs0.next()) {
			Roles role = new Roles();
			role.setRole_id(rs0.getInt(1));
			role.setRole_position(rs0.getString(2));
			role.setRole_privilege(rs0.getInt(3));
			list.add(role);
		}

		String sql = "SELECT count(*) FROM role  WHERE 1=1 " + whereSql;
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
