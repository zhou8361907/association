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
import com.sog.entity.Goods;

public class BrandDaoImpl implements BrandDaoI<Brand> {

	@Override
	public boolean insert(Brand t) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql="INSERT INTO brand (brand_name,brand_country,brand_level) VALUES (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, t.getBrand_name());
		ps.setString(2, t.getBrand_country());
		ps.setInt(3, t.getBrand_level());
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	@Override
	public boolean update(Brand t) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql="UPDATE brand SET brand_name=?,brand_country=?,brand_level=? WHERE brand_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, t.getBrand_name());
		ps.setString(2, t.getBrand_country());
		ps.setInt(3, t.getBrand_level());
		ps.setInt(4, t.getBrand_id());
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	@Override
	public boolean delete(int id) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql="DELETE FROM brand WHERE brand_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	@Override
	public List<Brand> selectAll() throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql="SELECT brand_id,brand_name,brand_country,brand_level FROM brand";
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		//将数据库中的记录转换为对象
		List<Brand>  list=new ArrayList<>();
		//结果集
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Brand brand=new Brand();
			
			brand.setBrand_id(rs.getInt(1));
			brand.setBrand_name(rs.getString(2));
			brand.setBrand_country(rs.getString(3));
			brand.setBrand_level(rs.getInt(4));
		
			
			list.add(brand);
		}
		DBUtils.close(conn, ps, rs);
		return list;
	}

	@Override
	public List<Brand> selectWhere(String whereSql) throws Exception {
		Connection conn = DBUtils.getConnection();
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT brand_id,brand_name,brand_country,brand_level ");
		sb.append("FROM brand ");
		sb.append(" WHERE 1=1 ");
		sb.append(whereSql);
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sb.toString());
		//将数据库中的记录转换为对象
		List<Brand>  list=new ArrayList<>();
		//结果集
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Brand brand=new Brand();
			
			brand.setBrand_id(rs.getInt(1));
			brand.setBrand_name(rs.getString(2));
			brand.setBrand_country(rs.getString(3));
			brand.setBrand_level(rs.getInt(4));
		
			
			list.add(brand);
		}
		DBUtils.close(conn, ps, rs);
		return list;
		
	}

	@Override
	public Map<String, Object> selectPage(String whereSql, int currentPage, int pageSize) throws Exception {
		Connection conn = DBUtils.getConnection();
		int index = (currentPage - 1) * pageSize;
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT * FROM brand WHERE 1=1 ");
		sb.append(whereSql);
		sb.append(" ORDER BY brand_id desc ");
		sb.append( " LIMIT " + index + "," + pageSize);

		PreparedStatement ps0 = conn.prepareStatement(sb.toString());
		ResultSet rs0 = ps0.executeQuery();
		List<Brand> list = new ArrayList<>();
	while(rs0.next()) {
		Brand b=new Brand();
		b.setBrand_id(rs0.getInt(1));
		b.setBrand_name(rs0.getString(2));
		b.setBrand_country(rs0.getString(3));
		b.setBrand_level(rs0.getInt(4));
		list.add(b);
		}
		String sql = "SELECT count(*) FROM brand  WHERE 1=1 " + whereSql;
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
	}

