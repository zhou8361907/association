package com.sog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sog.common.DBUtils;
import com.sog.entity.Choose;
import com.sog.entity.Content;
import com.sog.entity.Order;

public class OrderDaoImpl implements OrderDaoI<Order> {

	@Override
	public boolean insert(Order t) throws Exception {
		Connection conn=DBUtils.getConnection();
		String sql = "INSERT INTO orders(user_id,transport_id,order_stage,sum_money,begin_time,finish_time)\r\n" + 
				"VALUES(?,?,?,?,?,?)";
		//创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, t.getUserId());
		ps.setInt(2, t.getTransportId());
		ps.setInt(3, t.getOrderStage());
		ps.setBigDecimal(4, t.getSumMoney());
		ps.setTimestamp(5, t.getBeginTime());
		ps.setTimestamp(6, t.getFinishTime());
		
		
		//执行语句
		if(ps.executeUpdate()>0){
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	@Override
	public boolean update(Order t) throws Exception {
		Connection conn=DBUtils.getConnection();
		String sql = "UPDATE orders SET user_id=?,transport_id=?,order_stage=?,sum_money=?,begin_time=?,finish_time=?\r\n" + 
				"WHERE order_id=?";
		//创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, t.getUserId());
		ps.setInt(2, t.getTransportId());
		ps.setInt(3, t.getOrderStage());
		ps.setBigDecimal(4, t.getSumMoney());
		ps.setTimestamp(5, t.getBeginTime());
		ps.setTimestamp(6, t.getFinishTime());
		ps.setInt(7, t.getOrderId());
		
		//执行语句
		if(ps.executeUpdate()>0){
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	@Override
	public boolean delete(int id) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "DELETE from orders WHERE order_id=?";
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

	@Override
	public List<Order> selectAll() throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "SELECT order_id,user_id,transport_id,order_stage,sum_money,begin_time,finish_time " + 
				"FROM orders";
		//创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		//将数据库中的记录转换为对象
		List<Order> list = new ArrayList<Order>();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Order order = new Order();
			order.setOrderId(rs.getInt(1));
			order.setUserId(rs.getInt(2));
			order.setTransportId(rs.getInt(3));
			order.setOrderStage(rs.getInt(4));
			order.setSumMoney(rs.getBigDecimal(5));
			order.setBeginTime(rs.getTimestamp(6));
			order.setFinishTime(rs.getTimestamp(7));
			list.add(order);
		}
		DBUtils.close(conn, ps, rs);
		return list;
	}

	@Override
	public List<Order> selectWhere(String whereSql) throws Exception {
		Connection conn = DBUtils.getConnection();
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT order_id,user_id,transport_id,order_stage,sum_money,begin_time,finish_time ");
		sb.append("FROM orders ");
		sb.append(" WHERE 1=1 ");
		sb.append(whereSql);
		sb.append(" ORDER BY order_id desc ");
		System.out.println(sb.toString());
		//String sql = "SELECT id,admin,password,adminName,gender,mobile,email,address,roleId,deptId,createDate,lastDate,remark FROM admin";
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sb.toString());
		//将数据库中的记录转换为对象
		List<Order> list = new ArrayList<Order>();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Order order = new Order();
			order.setOrderId(rs.getInt(1));
			order.setUserId(rs.getInt(2));
			order.setTransportId(rs.getInt(3));
			order.setOrderStage(rs.getInt(4));
			order.setSumMoney(rs.getBigDecimal(5));
			order.setBeginTime(rs.getTimestamp(6));
			order.setFinishTime(rs.getTimestamp(7));
			
			
			Content content=new Content();
			ContentDaoI cdi=new ContentDaoImpl();
			order.setContentList(cdi.selectWhere(" and order_id="+order.getOrderId()));
			
			list.add(order);
		}
		DBUtils.close(conn, ps, rs);
		return list;
	}

	@Override
	public Map<String, Object> selectPage(String whereSql, int currentPage, int pageSize) throws Exception {
		
		Connection conn = DBUtils.getConnection();
		int index = (currentPage - 1) * pageSize;
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT * FROM orders WHERE 1=1 ");
		sb.append(whereSql);
		sb.append(" ORDER BY order_id desc ");
		sb.append( " LIMIT " + index + "," + pageSize);

		PreparedStatement ps0 = conn.prepareStatement(sb.toString());
		ResultSet rs0 = ps0.executeQuery();
		List<Order> list = new ArrayList<>();
	while(rs0.next()) {
		Order o=new Order();
		o.setOrderId(rs0.getInt(1));
		o.setUserId(rs0.getInt(2));
		o.setTransportId(rs0.getInt(3));
		o.setOrderStage(rs0.getInt(4));
		o.setSumMoney(rs0.getBigDecimal(5));
		o.setBeginTime(rs0.getTimestamp(6));
		o.setFinishTime(rs0.getTimestamp(7));
		list.add(o);
		}
		String sql = "SELECT count(*) FROM orders  WHERE 1=1 " + whereSql;
		PreparedStatement ps1 = conn.prepareStatement(sql);
		ResultSet rs1 = ps1.executeQuery();
		int count = 0;
		int pageNum=0;
		if (rs1.next()) {
			count= rs1.getInt(1);
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
		return map;
	}

	@Override
	public int insertre(Order t) throws Exception {
		Connection conn=DBUtils.getConnection();
		String sql = "INSERT INTO orders(user_id,transport_id,order_stage,sum_money,begin_time,finish_time)\r\n" + 
				"VALUES(?,?,?,?,?,?)";
		
		ResultSet rs=null;
		//创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, t.getUserId());
		ps.setInt(2, t.getTransportId());
		ps.setInt(3, t.getOrderStage());
		ps.setBigDecimal(4, t.getSumMoney());
		ps.setTimestamp(5, t.getBeginTime());
		ps.setTimestamp(6, t.getFinishTime());
		
		
		//执行语句
		if(ps.executeUpdate()>0){

			rs = ps.getGeneratedKeys(); //获取结果
			rs.next();
			int ii=rs.getInt(1);
			return ii;
		}
		DBUtils.close(conn, ps, null);
		return -1;
	}

	@Override
	public List<Choose> SelectByUser(int user_id) throws Exception {
		Connection conn = DBUtils.getConnection();
		StringBuffer sb=new StringBuffer();
		
		
		
		return null;
	}
	}

