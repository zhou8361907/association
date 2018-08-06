package com.sog.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jcp.xml.dsig.internal.dom.ApacheOctetStreamData;

import com.sog.common.DBUtils;
import com.sog.entity.Admin;
import com.sog.entity.Roles;

public class AdminDaoImpl implements AdminDaoI<Admin> {

	public boolean insert(Admin t) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "INSERT INTO Admin(role_id,admin_password,admin_account,admin_name,create_time,last_login_time,last_location,phone,gender,states)\r\n" + 
				"VALUES(?,?,?,?,?,?,?,?,?,?)";
		//创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, t.getRole_id());					
		ps.setString(2, t.getPassword());
		ps.setString(3, t.getAcount());
		ps.setString(4, t.getName());
		if(null != t.getCreate_time()) {
			ps.setTimestamp(5, new Timestamp(t.getCreate_time().getTime()));			
		}else {
			ps.setTimestamp(5, null);
		}
		if(null != t.getLast_login_time()) {
			ps.setTimestamp(6, new Timestamp(t.getLast_login_time().getTime()));			
		}else {
			ps.setTimestamp(6, null);
		}
		ps.setString(7, t.getLast_location());
		ps.setString(8, t.getPhone());
		ps.setInt(9, t.getGender());
		ps.setInt(10, t.getStates());
		
		
		//执行语句
		if(ps.executeUpdate()>0){
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	public boolean update(Admin t) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "UPDATE Admin SET role_id=?,admin_password=?,admin_account=?,admin_name=?,create_time=?,last_login_time=?,last_location=?,phone=?,gender=?,states=?\r\n" + 
				"WHERE admin_id=?";
		//创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, t.getRole_id());
		ps.setString(2, t.getPassword());
		ps.setString(3, t.getAcount());
		ps.setString(4, t.getName());
		if(null != t.getCreate_time()) {
			ps.setTimestamp(5, new Timestamp(t.getCreate_time().getTime()));			
		}else {
			ps.setTimestamp(5, null);
		}
		if(null != t.getLast_login_time()) {
			ps.setTimestamp(6, new Timestamp(t.getLast_login_time().getTime()));			
		}else {
			ps.setTimestamp(6, null);
		}
		ps.setString(7, t.getLast_location());
		ps.setString(8, t.getPhone());
		ps.setInt(9, t.getGender());
		ps.setInt(10, t.getStates());
		
		ps.setInt(11, t.getId());
		//执行语句
		if(ps.executeUpdate()>0){
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	public boolean delete(int id) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "DELETE from Admin WHERE admin_id=?";
		//创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		//执行语句
		if(ps.executeUpdate()>0){
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	public List<Admin> selectAll() throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "SELECT admin_id,role_id,admin_password,admin_account,admin_name,create_time,last_login_time,last_location,phone,gender,states\r\n" + 
				"FROM admin";
		//创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		//将数据库中的记录转换为对象
		List<Admin> list = new ArrayList<Admin>();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Admin adm = new Admin();
			adm.setId(rs.getInt(1));
			adm.setRole_id(rs.getInt(2));
			adm.setPassword(rs.getString(3));
			adm.setAcount(rs.getString(4));
			adm.setName(rs.getString(5));
			adm.setCreate_time(rs.getTimestamp(6));
			adm.setLast_login_time(rs.getTimestamp(7));
			adm.setLast_location(rs.getString(8));
			adm.setPhone(rs.getString(9));
			adm.setGender(rs.getInt(10));
			adm.setStates(rs.getInt(11));
			list.add(adm);
		}
		DBUtils.close(conn, ps, rs);
		return list;
	}

	public List<Admin> selectWhere(String whereSql) throws Exception {
		Connection conn = DBUtils.getConnection();
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT admin_id,role_id,admin_password,admin_account,admin_name,create_time,last_login_time,last_location,phone,gender,states ");
		sb.append("FROM Admin ");
		sb.append(" WHERE 1=1 ");
		sb.append(whereSql);
		System.out.println(sb.toString());
		//String sql = "SELECT id,admin,password,adminName,gender,mobile,email,address,roleId,deptId,createDate,lastDate,remark FROM admin";
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sb.toString());
		//将数据库中的记录转换为对象
		List<Admin>  list=new ArrayList<Admin>();
		//结果集
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Admin adm=new Admin();
			adm.setId(rs.getInt(1));
			adm.setRole_id(rs.getInt(2));
			adm.setPassword(rs.getString(3));
			adm.setAcount(rs.getString(4));
			adm.setName(rs.getString(5));
			adm.setCreate_time(rs.getTimestamp(6));
			adm.setLast_login_time(rs.getTimestamp(7));
			adm.setLast_location(rs.getString(8));
			adm.setPhone(rs.getString(9));
			adm.setGender(rs.getInt(10));
			adm.setStates(rs.getInt(11));
			
			
			list.add(adm);
		}
		DBUtils.close(conn, ps, rs);
		return list;
	}

	@Override
	public Map<String, Object> selectPage(String whereSql, int currentPage, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> findAdminAndRole(String whereSql, int currentPage, int pageSize) throws Exception {
		Connection conn = DBUtils.getConnection();
		int index = (currentPage - 1) * pageSize;
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT admin.admin_id,admin.role_id,admin_password,admin_account,admin_name,create_time,last_login_time,last_location,phone,gender,states,role_position,role_privilege ");
		sb.append("FROM admin,role WHERE admin.role_id=role.role_id ");
		sb.append(whereSql);
		sb.append(" ORDER BY admin.admin_id DESC ");
		sb.append(" LIMIT "+index+","+pageSize);
		//String sql = "SELECT id,admin,password,adminName,gender,mobile,email,address,roleId,deptId,createDate,lastDate,remark FROM admin";
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sb.toString());
		//将数据库中的记录转换为对象
		List<Admin>  list=new ArrayList<>();
		//结果集
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Admin admin=new Admin();
			//添加角色
			admin.setId(rs.getInt(1));
			admin.setRole_id(rs.getInt(2));
			admin.setPassword(rs.getString(3));
			admin.setAcount(rs.getString(4));
			admin.setName(rs.getString(5));
			admin.setCreate_time(rs.getTimestamp(6));
			admin.setLast_login_time(rs.getTimestamp(7));
			admin.setLast_location(rs.getString(8));
			admin.setPhone(rs.getString(9));
			admin.setGender(rs.getInt(10));
			admin.setStates(rs.getInt(11));
			
			
			//创建角色对象
			Roles role=new Roles();
			role.setRole_id(rs.getInt(2));
			role.setRole_position(rs.getString(12));
			role.setRole_privilege(rs.getInt(13));
			admin.setRole(role);
			list.add(admin);
			
		}
		
		String sql="SELECT count(*) FROM admin,role WHERE admin.role_id=role.role_id ";
		PreparedStatement ps1 = conn.prepareStatement(sql);
		ResultSet rs1=ps1.executeQuery();
		rs1.next();
		Integer count=rs1.getInt(1);
		
		Map<String,Object> map=new HashMap<>();
		int pageNum=1;
		if(count%pageSize==0) {
			pageNum=count/pageSize;
		}else {
			pageNum=count/pageSize+1;
		}
		map.put("list", list);
		map.put("count", count);
		map.put("pageNum", pageNum);
		DBUtils.close(conn, ps, rs);
		return map;
	}

	
}
