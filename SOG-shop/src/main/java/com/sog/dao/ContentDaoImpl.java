package com.sog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sog.common.DBUtils;
import com.sog.entity.Content;
import com.sog.entity.Goods;

public class ContentDaoImpl implements ContentDaoI<Content> {

	@Override
	public boolean insert(Content t) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "INSERT INTO content (order_id,goods_id,order_number,note) VALUES(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, t.getOrder_id());
		ps.setInt(2, t.getGoods_id());
		ps.setInt(3, t.getOrder_number());
		ps.setString(4, t.getNote());
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	@Override
	public boolean update(Content t) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "UPDATE content SET order_id=?,goods_id=?,order_number=?,note=? WHERE order_content_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		
		ps.setInt(1, t.getOrder_id());
		ps.setInt(2, t.getGoods_id());
		ps.setInt(3, t.getOrder_number());
		ps.setString(4, t.getNote());
		ps.setInt(5, t.getOrder_content_id() );
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	@Override
	public boolean delete(int id) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "DELETE FROM content WHERE order_content_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	@Override
	public List<Content> selectAll() throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "SELECT * FROM content";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Content> list = new ArrayList<>();
		while (rs.next()) {
			Content content = new Content();
			content.setOrder_content_id(rs.getInt(1));
			content.setOrder_id(rs.getInt(2));
			content.setGoods_id(rs.getInt(3));
			content.setOrder_number(rs.getInt(4));
			content.setNote(rs.getString(5));
			list.add(content);
		}
		DBUtils.close(conn, ps, rs);
		return list;
	}

	@Override
	public List<Content> selectWhere(String whereSql) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "SELECT order_content_id,order_id,goods_id,order_number,note FROM content WHERE 1=1 " + whereSql;
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Content> list = new ArrayList<>();
		while (rs.next()) {
			Content content = new Content();
			content.setOrder_content_id(rs.getInt(1));
			content.setOrder_id(rs.getInt(2));
			content.setGoods_id(rs.getInt(3));
			content.setOrder_number(rs.getInt(4));
			content.setNote(rs.getString(5));
			
			Goods goods=new Goods();
			GoodsDaoI gdi=new GoodsDaoImpl();
			goods=(Goods)gdi.selectWhere(" and goods_id="+content.getGoods_id()).get(0);
			content.setGoods(goods);
			list.add(content);
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
