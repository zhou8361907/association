package com.sog.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sog.common.DBUtils;
import com.sog.entity.Brand;
import com.sog.entity.Comment;
import com.sog.entity.Goods;
import com.sog.entity.Image_comment;
import com.sog.entity.Image_goods;
import com.sog.entity.Series;
import com.sog.entity.User;

public class CommentDaoImpl implements CommentDaoI<Comment> {

	@Override
	public boolean insert(Comment t) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "INSERT INTO comments(user_id,goods_id,comment_time,comment_content,comment_star_number)\r\n" + 
				"VALUES(?,?,?,?,?)";
		//创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
							
		ps.setInt(1, t.getUserId());
		ps.setInt(2, t.getGoodsId());
		if(null != t.getCommentTime()) {
			ps.setTimestamp(3, new Timestamp(t.getCommentTime().getTime()));			
		}else {
			ps.setTimestamp(3, null);
		}
		ps.setString(4, t.getCommentContent());
		ps.setInt(5, t.getCommentStarNumber());
		
		
		//执行语句
		if(ps.executeUpdate()>0){
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	@Override
	public boolean update(Comment t) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "UPDATE comments SET user_id=?,goods_id=?,comment_time=?,comment_content=?,comment_star_number=?\r\n" + 
				"WHERE comment_id=?";
		//创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, t.getUserId());
		ps.setInt(2, t.getGoodsId());
		if(null != t.getCommentTime()) {
			ps.setTimestamp(3, new Timestamp(t.getCommentTime().getTime()));			
		}else {
			ps.setTimestamp(3, null);
		}
		ps.setString(4, t.getCommentContent());
		ps.setInt(5, t.getCommentStarNumber());
		ps.setInt(6, t.getCommentId());
		
		
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
		String sql = "DELETE from comments WHERE comment_id=?";
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
	public List<Comment> selectAll() throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "SELECT * FROM comments";
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		//将数据库中的记录转换为对象
		List<Comment>  list=new ArrayList<Comment>();
		//结果集
		ResultSet rs=ps.executeQuery();
    	System.out.println("1");
		while (rs.next()) {
	    	System.out.println("1");
			Comment c=new Comment();
			c.setCommentId(rs.getInt(1));
			c.setUserId(rs.getInt(2));
			c.setGoodsId(rs.getInt(3));
			if(null != rs.getTimestamp(4)) {
				c.setCommentTime(new Timestamp(rs.getTimestamp(4).getTime()));			
			}else {
				c.setCommentTime(null);
			}
			c.setCommentContent(rs.getString(5));
			c.setCommentStarNumber(rs.getInt(6));
			
			list.add(c);
		}
		DBUtils.close(conn, ps, null);
		return list;
	}

	@Override
	public List<Comment> selectWhere(String whereSql) throws Exception {
		Connection conn = DBUtils.getConnection();
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT * ");
		sb.append("FROM comments ");
		sb.append(" WHERE 1=1 ");
		sb.append(whereSql);
		System.out.println(sb.toString());
		
		PreparedStatement ps = conn.prepareStatement(sb.toString());	
		List<Comment>  list=new ArrayList<Comment>();
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Comment c=new Comment();
			c.setCommentId(rs.getInt(1));
			c.setUserId(rs.getInt(2));
			c.setGoodsId(rs.getInt(3));
			if(null != rs.getTimestamp(4)) {
				c.setCommentTime(new Timestamp(rs.getTimestamp(4).getTime()));			
			}else {
				c.setCommentTime(null);
			}
			c.setCommentContent(rs.getString(5));
			c.setCommentStarNumber(rs.getInt(6));
			
			list.add(c);
		
		
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
	public Map<String, Object> findFour(String whereSql, int currentPage, int pageSize) throws Exception {
		Connection conn = DBUtils.getConnection();
		int index = (currentPage - 1) * pageSize;
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT comment_id,comments.user_id,comments.goods_id,comment_time,comment_content,comment_star_number, ");
		sb.append(" goods_name,user_name,account ");
		sb.append(" FROM good,`user`,comments WHERE comments.goods_id=good.goods_id and `user`.user_id=comments.user_id ");
		sb.append(whereSql);
		sb.append(" ORDER BY comments.comment_id DESC ");
		sb.append(" LIMIT "+index+","+pageSize);
		
		PreparedStatement ps = conn.prepareStatement(sb.toString());
		//将数据库中的记录转换为对象
		List<Comment>  list=new ArrayList<>();
		//结果集
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			 Comment comment = new Comment();
			 comment.setCommentId(rs.getInt(1));
			 comment.setUserId(rs.getInt(2));
			 comment.setGoodsId(rs.getInt(3));
			 comment.setCommentTime(rs.getTimestamp(4));
			 comment.setCommentContent(rs.getString(5));
			 comment.setCommentStarNumber(rs.getInt(6));
			 
			 Goods good = new Goods();
			 good.setGoods_id(rs.getInt(3));
			 good.setGoods_name(rs.getString(7));
			 
			 User user = new User();
			 user.setUser_id(rs.getInt(2));
			 user.setUser_name(rs.getString(8));
			 user.setAccount(rs.getString(9));

			//创建图片对象
			Image_comment image = new Image_comment();
			String sql2 = "SELECT * FROM image_comment WHERE comment_id=" + rs.getInt(1);
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ResultSet rs2=ps2.executeQuery();
			if(rs2.next()) {
				image.setImage_id(rs2.getInt(1));
				image.setComment_id(rs2.getInt(2));
				image.setRoute(rs2.getString(3));
				image.setSort(rs2.getInt(4));
			}
			
			comment.setGood(good);
			comment.setUesr(user);
			comment.setImage(image);			
			
			list.add(comment);
			
		}
		
		String sql="SELECT count(*) From good,`user`,comments\r\n" + 
				"WHERE comments.goods_id=good.goods_id and `user`.user_id=comments.user_id " +whereSql;
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
