package com.sog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.relation.Role;

import com.sog.common.DBUtils;
import com.sog.entity.Admin;
import com.sog.entity.Brand;
import com.sog.entity.Goods;
import com.sog.entity.Roles;
import com.sog.entity.Series;

/**
 * @author 杨云凯
 *
 */
public class SeriesDaoImpl implements SeriesDaoI<Series> {

	public boolean update(Series s) throws Exception {
		
		Connection conn = DBUtils.getConnection();
		String sql = "update   series   SET  brand_id=?,series_name=?,sort_level=?"+" where series_id=?";;
				
				
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, s.getBrand_id());
		ps.setString(2, s.getSeries_name());
		ps.setInt(3, s.getSort_level());
		ps.setInt(4, s.getSeries_id());

		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	public boolean insert(Series s) throws SQLException {
		Connection conn = DBUtils.getConnection();
		String sql = "insert into  series  SET brand_id=?,series_name=?,sort_level=?";
				
				
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,s.getBrand_id());
		ps.setString(2, s.getSeries_name());
		ps.setInt(3, s.getSort_level());
	

		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	public List<Series> selectAll() throws SQLException {
		Connection conn = DBUtils.getConnection();
		String sql = "SELECT * FROM series";
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		//将数据库中的记录转换为对象
		List<Series>  list=new ArrayList<Series>();
		//结果集
		
		
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
		Series  s=new Series();
			s.setSeries_id(rs.getInt(1));
			s.setBrand_id(rs.getInt(2));
			s.setSeries_name(rs.getString(3));
			s.setSort_level(rs.getInt(4));
					
			list.add(s);
		}
		DBUtils.close(conn, ps, rs);
		return list;
	}

	public List<Series> selectWhere(String whereSql) throws SQLException {
		Connection conn = DBUtils.getConnection();
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT * ");
		sb.append("FROM series ");
		sb.append(" WHERE 1=1 ");
		sb.append(whereSql);
		System.out.println(sb.toString());
		
		PreparedStatement ps = conn.prepareStatement(sb.toString());	
		List<Series>  list= new ArrayList<Series>();
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			
			Series  s=new Series();
			s.setSeries_id(rs.getInt(1));
			s.setBrand_id(rs.getInt(2));
			s.setSeries_name(rs.getString(3));
			s.setSort_level(rs.getInt(4));
					
			list.add(s);
		
		
		}
		DBUtils.close(conn, ps, rs);
		return list;
	}

	public boolean delete(int id) throws SQLException {
		Connection conn = DBUtils.getConnection();
		String sql = "DELETE FROM series WHERE series_id=?";
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
		return null;
		
	}
	

	/* (non-Javadoc)
	 * @see com.sog.dao.SeriesDaoI#findSeriesAndBrand(java.lang.String, int, int)
	 */
	@Override
	public Map<String, Object> findSeriesAndBrand(String whereSql, int currentPage, int pagesize) throws Exception {
		Connection conn = DBUtils.getConnection();
		int index = (currentPage - 1) * pagesize;
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT series.series_id,series.brand_id,series_name,sort_level,brand_name,brand_country,brand_level ");
		sb.append("FROM series,brand WHERE series.brand_id=brand.brand_id ");
		sb.append(whereSql);
		sb.append(" ORDER BY series.series_id ASC ");
		sb.append(" LIMIT "+index+","+pagesize);
		
		PreparedStatement ps = conn.prepareStatement(sb.toString());
	
		List<Series>  list=new ArrayList<>();
		//结果集
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Series s=new Series();
			
			s.setSeries_id(rs.getInt(1));
			s.setBrand_id(rs.getInt(2));
			s.setSeries_name(rs.getString(3));
			s.setSort_level(rs.getInt(4));
			
			 Brand b=new Brand();//创建角色对象
			 b.setBrand_id(rs.getInt(2));
			 b.setBrand_name(rs.getString(5));
			 b.setBrand_country(rs.getString(6));
			 b.setBrand_level(rs.getInt(7));
			 s.setBrand(b);
		     list.add(s);
		}
		
		String sql="SELECT count(*) FROM series,brand WHERE series.brand_id=brand.brand_id  "+whereSql;
		PreparedStatement ps1 = conn.prepareStatement(sql);
		ResultSet rs1=ps1.executeQuery();
		rs1.next();
		Integer count=rs1.getInt(1);
		
		Map<String,Object> map=new HashMap<>();
		int pageNum=1;
		if(count%pagesize==0) {
			pageNum=count/pagesize;
		}else {
			pageNum=count/pagesize+1;
		}
		map.put("list", list);
		map.put("count", count);
		map.put("pageNum", pageNum);
		DBUtils.close(conn, ps, rs);
		return map;
	}

	}


