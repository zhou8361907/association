package com.sog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sog.common.DBUtils;
import com.sog.entity.Admin;
import com.sog.entity.Goods;
import com.sog.entity.Image_goods;
import com.sog.entity.Roles;

public class Image_goodsDaoImpl implements Image_goodsDaoI<Image_goods> {

	@Override
	public boolean insert(Image_goods t) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "INSERT INTO image_goods (goods_id,route,sort) VALUES(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, t.getGoods_id());
		ps.setString(2, t.getRoute());
		ps.setInt(3, t.getSort());
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	@Override
	public boolean update(Image_goods t) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "UPDATE image_goods SET goods_id=?,route=?,sort=? WHERE image_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, t.getGoods_id());
		ps.setString(2, t.getRoute());
		ps.setInt(3, t.getSort());
		ps.setInt(4, t.getImage_id());
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	@Override
	public boolean delete(int id) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "DELETE FROM image_goods WHERE image_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	@Override
	public List<Image_goods> selectAll() throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "SELECT * FROM image_goods";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Image_goods> list = new ArrayList<>();
		while (rs.next()) {
			Image_goods image = new Image_goods();
			image.setImage_id(rs.getInt(1));
			image.setGoods_id(rs.getInt(2));
			image.setRoute(rs.getString(3));
			image.setSort(rs.getInt(4));
			list.add(image);
		}
		DBUtils.close(conn, ps, rs);
		return list;
	}

	@Override
	public List<Image_goods> selectWhere(String whereSql) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "SELECT image_id,goods_id,route,sort FROM image_goods WHERE 1=1 " + whereSql;
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Image_goods> list = new ArrayList<>();
		while (rs.next()) {
			Image_goods image = new Image_goods();
			image.setImage_id(rs.getInt(1));
			image.setGoods_id(rs.getInt(2));
			image.setRoute(rs.getString(3));
			image.setSort(rs.getInt(4));
			list.add(image);
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
	public Map<String, Object> findImageAndGood(String whereSql, int currentPage, int pageSize) throws Exception {
		Connection conn = DBUtils.getConnection();
		int index = (currentPage - 1) * pageSize;
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT image_goods.image_id,image_goods.goods_id,route,sort,goods_name ");
		sb.append("FROM good,image_goods WHERE good.goods_id=image_goods.goods_id ");
		sb.append(whereSql);
		sb.append(" ORDER BY image_goods.image_id DESC ");
		sb.append(" LIMIT "+index+","+pageSize);
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sb.toString());
		//将数据库中的记录转换为对象
		List<Image_goods>  list=new ArrayList<>();
		//结果集
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Image_goods image_goods=new Image_goods();
			//添加角色
			image_goods.setImage_id(rs.getInt(1));
			image_goods.setGoods_id(rs.getInt(2));
			image_goods.setRoute(rs.getString(3));
			image_goods.setSort(rs.getInt(4));
			
			
			//创建角色对象
			Goods goods=new Goods();
			goods.setGoods_id(rs.getInt(2));
			goods.setGoods_name(rs.getString(5));
			image_goods.setGood(goods);
			list.add(image_goods);
			
		}
		
		String sql="SELECT count(*) FROM good,image_goods WHERE good.goods_id=image_goods.goods_id ";
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
