package com.sog.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sog.common.DBUtils;
import com.sog.entity.Choose;
import com.sog.entity.Goods;
import com.sog.entity.Image_goods;
/**
 * 
 * @类名: ChooseDaoImpl
 * @描述: choose的dao层实现 增加了 全部删除和按user_id选择购物车内容
 * @作者：周帅
 * @日期：2018年7月3日下午1:43:36
 */
public class ChooseDaoImpl implements ChooseDaoI<Choose> {

	@Override
	public boolean insert(Choose t) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql="INSERT INTO choose (user_id,goods_id,put_time,number,type) VALUES(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, t.getUser_id());
		ps.setInt(2, t.getGoods_id());
		if(null != t.getPut_time()) {
			
			ps.setTimestamp(3, new Timestamp(t.getPut_time().getTime()));	
		}else {
			ps.setTimestamp(3,null);
		}
		ps.setInt(4, t.getNumber());
		ps.setBoolean(5, t.getType());
		
		if (ps.executeUpdate() > 0) {
			return true;
		}
		return false;
		
	}

	@Override
	public boolean update(Choose t) throws Exception {
		Connection conn = DBUtils.getConnection();
		
		String sql = "UPDATE choose SET user_id=?,goods_id=?,put_time=?,number=?,type=? WHERE choose_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, t.getUser_id());
		ps.setInt(2, t.getGoods_id());
		
		if(null != t.getPut_time()) {
			
			ps.setTimestamp(3, new Timestamp(t.getPut_time().getTime()));	
		}else {
			ps.setTimestamp(3,null);
		}
		
		//System.out.println();
		System.out.println(t.getNumber());
		ps.setInt(4, t.getNumber());
		System.out.println(t.getNumber());
		ps.setBoolean(5, t.getType());
		ps.setInt(6, t.getChoose_id());
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		return false;
	}

	@Override
	public boolean delete(int id) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "DELETE FROM choose WHERE choose_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		if (ps.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Choose> selectAll() throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "SELECT * FROM choose WHERE type = 0";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Choose> list = new ArrayList<>();
		while (rs.next()) {
			Choose choose = new Choose();
			choose.setChoose_id(rs.getInt(1));
			choose.setUser_id(rs.getInt(2));
			choose.setGoods_id(rs.getInt(3));
			choose.setPut_time(rs.getTimestamp(4));
			choose.setNumber(rs.getInt(5));
			choose.setType(rs.getBoolean(6));
			list.add(choose);
		}
		DBUtils.close(conn, ps, rs);
		return list;
	}

	@Override
	public List<Choose> selectWhere(String whereSql) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "SELECT choose_id,user_id,goods_id,put_time,number,type FROM choose WHERE type = 0 "+whereSql;
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Choose> list = new ArrayList<>();
		while (rs.next()) {
			Choose choose = new Choose();
			choose.setChoose_id(rs.getInt(1));
			choose.setUser_id(rs.getInt(2));
			choose.setGoods_id(rs.getInt(3));
			choose.setPut_time(rs.getTimestamp(4));
			choose.setNumber(rs.getInt(5));
			choose.setType(rs.getBoolean(6));
			list.add(choose);
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
	public List<Choose> SelectByUser(int user_id) throws Exception {
		Connection conn = DBUtils.getConnection();
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT good.goods_id,goods_name,store_number,good_buy_price,good_sell_price,good_sale_price,if_onsale,alert_num,producing_area,effect,weight,color,describes,series_id, ");
		sb.append(" choose_id,user_id,put_time,number,type ");
		sb.append(" FROM good,choose WHERE good.goods_id=choose.goods_id ");
		sb.append(" AND type = 0 AND choose.user_id="+user_id);
		sb.append(" ORDER BY choose.choose_id DESC ");
		PreparedStatement ps = conn.prepareStatement(sb.toString());
		//将数据库中的记录转换为对象
		List<Choose>  list=new ArrayList<>();
		//结果集
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			
			//创建图片对象
			Image_goods image_goods = new Image_goods();
			String sql2 = "SELECT * FROM image_goods WHERE image_goods.goods_id=" + rs.getInt(1);
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ResultSet rs2=ps2.executeQuery();
			if(rs2.next()) {
				image_goods.setImage_id(rs2.getInt(1));
				image_goods.setGoods_id(rs2.getInt(2));
				image_goods.setRoute(rs2.getString(3));
				image_goods.setSort(rs2.getInt(4));
			}
			
			
			
			//添加商品具体信息
			Goods good=new Goods();
			good.setGoods_id(rs.getInt(1));
			good.setGoods_name(rs.getString(2));
			good.setStore_number(rs.getInt(3));
			good.setGood_buy_price(BigDecimal.valueOf(rs.getInt(4)));
			good.setGood_sell_price(BigDecimal.valueOf(rs.getInt(5)));
			good.setGood_sale_price(BigDecimal.valueOf(rs.getInt(6)));
			good.setIf_onsale(rs.getBoolean(7));
			good.setAlert_num(Integer.valueOf(rs.getInt(8)));
			good.setProducing_area(rs.getString(9));
			good.setEffect(rs.getString(10));
			good.setWeight(rs.getString(11));
			good.setColor(rs.getString(12));
			good.setDescribe(rs.getString(13));
			good.setSeries_id(Integer.valueOf(rs.getInt(14)));
			good.setImage(image_goods);
			//创建购物车信息
			Choose choose=new Choose();
			choose.setChoose_id(rs.getInt(15));
			choose.setGoods_id(rs.getInt(1));
			choose.setUser_id(rs.getInt(16));
			choose.setPut_time(rs.getTimestamp(17));
			choose.setNumber(rs.getInt(18));
			choose.setType(rs.getBoolean(19));
			choose.setGood(good);
			
			
		
			
			
			list.add(choose);
		}
		return list;
	}

	@Override
	public Choose SelectBych_id(int choose_id, int num) throws Exception {
		ChooseDaoI cdi=new ChooseDaoImpl();
		GoodsDaoI gdi=new GoodsDaoImpl();
		Choose ch1=(Choose)cdi.selectWhere(" and choose_id="+choose_id).get(0);;
		ch1.setChoose_id(choose_id);
		ch1.setNumber(num);
		
		update(ch1);
		Choose ch=new Choose();
		ch=(Choose)cdi.selectWhere(" and choose_id="+choose_id).get(0);
		Goods good=(Goods)gdi.selectWhere(" and goods_id="+ch.getGoods_id()).get(0);
		ch.setGood(good);
		return ch;
	}
	
	

}
