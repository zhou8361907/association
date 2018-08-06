package com.sog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sog.common.DBUtils;
import com.sog.entity.Image_comment;
import com.sog.entity.Image_goods;

public class Image_commentDaoImpl implements Image_commentDaoI<Image_comment> {

	@Override
	public boolean insert(Image_comment t) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "INSERT INTO image_comment (comment_id,route,sort) VALUES(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, t.getComment_id());
		ps.setString(2, t.getRoute());
		ps.setInt(3, t.getSort());
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	@Override
	public boolean update(Image_comment t) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "UPDATE image_comment SET comment_id=?,route=?,sort=? WHERE image_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, t.getComment_id());
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
		String sql = "DELETE FROM image_comment WHERE image_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	@Override
	public List<Image_comment> selectAll() throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "SELECT * FROM image_comment";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Image_comment> list = new ArrayList<>();
		while (rs.next()) {
			Image_comment image = new Image_comment();
			image.setImage_id(rs.getInt(1));
			image.setComment_id(rs.getInt(2));
			image.setRoute(rs.getString(3));
			image.setSort(rs.getInt(4));
			list.add(image);
		}
		DBUtils.close(conn, ps, rs);
		return list;
	}

	@Override
	public List<Image_comment> selectWhere(String whereSql) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "SELECT image_id,comment_id,route,sort FROM image_comment WHERE 1=1 " + whereSql;
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Image_comment> list = new ArrayList<>();
		while (rs.next()) {
			Image_comment image = new Image_comment();
			image.setImage_id(rs.getInt(1));
			image.setComment_id(rs.getInt(2));
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
	public Map<String, Object> findImageAndComment(String whereSql, int currentPage, int pagenum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
