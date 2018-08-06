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

import com.sog.common.DBUtils;
import com.sog.entity.Admin;
import com.sog.entity.User;
/**
 * 
 * @类名: UserDaoImpl
 * @描述: userDaoI的接口实现
 * @作者：周帅
 * @日期：2018年6月27日上午9:44:07
 */
public class UserDaoImpl implements UserDaoI<User> {

	public boolean insert(User t) throws Exception {
		Connection conn = DBUtils.getConnection();

		String sql = "INSERT INTO user(account,password,user_name,user_birthday,user_sex,user_money,user_score,user_phone,create_time,last_login_time,last_login_location,image_url,states)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, t.getAccount());
		ps.setString(2, t.getPassword());
		ps.setString(3, t.getUser_name());
		if(null!=t.getUser_birthday()) {
			ps.setDate(4, t.getUser_birthday());
		}else {
			ps.setDate(4, null);
		}
		ps.setInt(5, t.getUser_sex());
		ps.setBigDecimal(6, t.getUser_money());
		ps.setInt(7, t.getUser_score());
		ps.setString(8, t.getUser_phone());
		if(null != t.getCreate_time()) {
			
			ps.setTimestamp(9, new Timestamp(t.getCreate_time().getTime()));	
		}else {
			ps.setTimestamp(9,null);
		}

		if(null != t.getLast_login_time()) {
			
			ps.setTimestamp(10, new Timestamp(t.getLast_login_time().getTime()));	
		}else {
			ps.setTimestamp(10,null);
		}
			
		ps.setString(11, t.getLast_login_location());
		ps.setString(12,t.getImage_url());
		ps.setInt(13, t.getStates());
		//执行语句
		if(ps.executeUpdate()>0){
			
					return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	public boolean update(User t) throws Exception {
		Connection conn = DBUtils.getConnection();
		
		String sql="UPDATE user SET password=?,user_name=?,user_birthday=?,user_sex=?,user_money=?,user_score=?,user_phone=?,create_time=?,last_login_time=?,last_login_location=?,image_url=?,states=? WHERE user_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, t.getPassword());
		ps.setString(2, t.getUser_name());
		if(null!=t.getUser_birthday()) {
			ps.setDate(3, t.getUser_birthday());
		}else {
			ps.setDate(3, null);
		}
		ps.setInt(4, t.getUser_sex());
		ps.setBigDecimal(5, t.getUser_money());
		ps.setInt(6, t.getUser_score());
		ps.setString(7, t.getUser_phone());
		if(null != t.getCreate_time()) {
			
			ps.setTimestamp(8, new Timestamp(t.getCreate_time().getTime()));	
		}else {
			ps.setTimestamp(8,null);
		}

		if(null != t.getLast_login_time()) {
			
			ps.setTimestamp(9, new Timestamp(t.getLast_login_time().getTime()));	
		}else {
			ps.setTimestamp(9,null);
		}
			
		ps.setString(10, t.getLast_login_location());
		ps.setString(11,t.getImage_url());
		ps.setInt(12, t.getStates());
		ps.setInt(13, t.getUser_id());
		//执行语句
		System.out.println(t.getUser_id()+"--"+t.getAccount()+"--"+t.getPassword());
		if(ps.executeUpdate()>0){
			System.out.println(t.getUser_id()+"--"+t.getAccount()+"--"+t.getPassword());
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	public boolean delete(int id) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "DELETE from user WHERE user_id=?";
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

	public List<User> selectAll() throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql="SELECT user_id,account,password,user_name,user_birthday,user_sex,user_money,user_score,user_phone,create_time,last_login_time,last_login_location,image_url,states FROM user";
		//创建PreparedStatement
				PreparedStatement ps = conn.prepareStatement(sql);
				//将数据库中的记录转换为对象
				List<User> list = new ArrayList<User>();
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					User user = new User();
					user.setUser_id(rs.getInt(1));
					user.setAccount(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setUser_name(rs.getString(4));
					user.setUser_birthday(rs.getDate(5));
					user.setUser_sex(rs.getInt(6));
					user.setUser_money(rs.getBigDecimal(7));
					user.setUser_score(rs.getInt(8));
					user.setUser_phone(rs.getString(9));
					
					
					user.setCreate_time(rs.getTimestamp(10));
					user.setLast_login_time(rs.getTimestamp(11));
					user.setLast_login_location(rs.getString(12));
					user.setImage_url(rs.getString(13));
					user.setStates(rs.getInt(14));
					list.add(user);
				}
				DBUtils.close(conn, ps, rs);
				return list;
	}

	public List<User> selectWhere(String whereSql) throws Exception {
		Connection conn = DBUtils.getConnection();
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT user_id,account,password,user_name,user_birthday,user_sex,user_money,user_score,user_phone,create_time,last_login_time,last_login_location,image_url,states ");
		sb.append("FROM user ");
		sb.append(" WHERE 1=1 ");
		sb.append(whereSql);	
		PreparedStatement ps = conn.prepareStatement(sb.toString());
		//将数据库中的记录转换为对象
		List<User>  list=new ArrayList<User>();
		//结果集
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			
			User user = new User();
			user.setUser_id(rs.getInt(1));
			user.setAccount(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setUser_name(rs.getString(4));
			user.setUser_birthday(rs.getDate(5));
			user.setUser_sex(rs.getInt(6));
			user.setUser_money(rs.getBigDecimal(7));
			user.setUser_score(rs.getInt(8));
			user.setUser_phone(rs.getString(9));	
			user.setCreate_time(rs.getTimestamp(10));
			user.setLast_login_time(rs.getTimestamp(11));
			user.setLast_login_location(rs.getString(12));
			user.setImage_url(rs.getString(13));
			user.setStates(rs.getInt(14));
			list.add(user);
		
		}
		
		DBUtils.close(conn, ps, rs);
		return list;
	}

	@Override
	public Map<String, Object> selectPage(String whereSql, int currentPage, int pageSize) throws Exception {
		Connection conn = DBUtils.getConnection();
		int index = (currentPage - 1) * pageSize;
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT user_id,account,password,user_name,user_birthday,user_sex,user_money,user_score,user_phone,create_time,last_login_time,last_login_location,image_url,states FROM user WHERE 1=1 ");
		sb.append(whereSql);
		sb.append(" ORDER BY user_id desc ");
		sb.append( " LIMIT " + index + "," + pageSize);
//		String sql = "SELECT id,roleName,remark FROM role WHERE 1=1 " + whereSql + " LIMIT " + index + "," + pageSize;
		PreparedStatement ps0 = conn.prepareStatement(sb.toString());
		
		ResultSet rs0 = ps0.executeQuery();
		System.out.println(sb.toString());
		System.out.println(whereSql);
		
		List<User> list = new ArrayList<>();
	while(rs0.next()) {	
			User user = new User();
			user.setUser_id(rs0.getInt(1));
			user.setAccount(rs0.getString(2));
			user.setPassword(rs0.getString(3));
			user.setUser_name(rs0.getString(4));
			user.setUser_birthday(rs0.getDate(5));
			user.setUser_sex(rs0.getInt(6));
			user.setUser_money(rs0.getBigDecimal(7));
			user.setUser_score(rs0.getInt(8));
			user.setUser_phone(rs0.getString(9));	
			user.setCreate_time(rs0.getTimestamp(10));
			user.setLast_login_time(rs0.getTimestamp(11));
			user.setLast_login_location(rs0.getString(12));
			user.setImage_url(rs0.getString(13));
			user.setStates(rs0.getInt(14));
			list.add(user);
		
		}
		String sql = "SELECT count(*) FROM user  WHERE 1=1 " + whereSql;
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

	@Override
	public Map<String, Object> like_qurey(User t, int curPage, int pageSize) throws Exception {
		
		StringBuffer wheresql=new StringBuffer();
		wheresql.append("");
	
		if(t.getAccount()!=null&&!t.getAccount().equals("")) {
			wheresql.append(" and account like '%" + t.getAccount() + "%'");
		
		}
		if(t.getUser_name()!=null&&!t.getUser_name().equals("")) {
			wheresql.append(" and user_name like '%"+t.getUser_name()+"%'");
		
		}
		if(t.getStates()!=3) {
			if(t.getStates()==1) {
				wheresql.append(" and states =1");
			}
			if(t.getStates()==2){
				wheresql.append(" and states =0");			
			}
			
		}
		UserDaoI udi=new UserDaoImpl();
		Map<String, Object> map=udi.selectPage(wheresql.toString(),curPage, pageSize);
		
		return map;
	}

}
