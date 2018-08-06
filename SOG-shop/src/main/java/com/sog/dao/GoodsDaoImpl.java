package com.sog.dao;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sog.common.DBUtils;
import com.sog.entity.Admin;
import com.sog.entity.Brand;
import com.sog.entity.Goods;
import com.sog.entity.Image_goods;
import com.sog.entity.Roles;
import com.sog.entity.Series;
import com.sog.entity.User;


public class GoodsDaoImpl implements GoodsDaoI<Goods> {

	public boolean update(Goods g) throws Exception {
		Connection conn = DBUtils.getConnection();
		String sql = "UPDATE good  SET goods_name=?,store_number=?,good_buy_price=?,good_sell_price=?,good_sale_price=?,if_onsale=?, alert_num=?,producing_area=?,effect=?,weight=?,color=?,describes=?,series_id=?"
				
				+ " where goods_id=?";
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1,g.getGoods_name() );
	ps.setInt(2,g.getStore_number() );
	ps.setBigDecimal(3, g.getGood_buy_price());
	ps.setBigDecimal(4, g.getGood_sell_price());
	ps.setBigDecimal(5, g.getGood_sale_price());
	ps.setBoolean(6, g.isIf_onsale());
	ps.setInt(7, g.getAlert_num());
	ps.setString(8, g.getProducing_area());
	ps.setString(9, g.getEffect());
	ps.setString(10, g.getWeight());
	ps.setString(11, g.getColor());
	ps.setString(12, g.getDescribe());
	ps.setInt(13, g.getSeries_id());
	ps.setInt(14, g.getGoods_id());
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		
		return false;
		
	}

	public boolean insert(Goods g) throws SQLException {
		Connection conn = DBUtils.getConnection();
		String sql = "insert into  good  (goods_name,store_number,good_buy_price,good_sell_price,good_sale_price,if_onsale, alert_num,producing_area,effect,weight,color,describes,series_id)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,g.getGoods_name() );
		ps.setInt(2,g.getStore_number() );
		ps.setBigDecimal(3, g.getGood_buy_price());
		ps.setBigDecimal(4, g.getGood_sell_price());
		ps.setBigDecimal(5, g.getGood_sale_price());
		ps.setBoolean(6, g.isIf_onsale());
		ps.setInt(7, g.getAlert_num());
		ps.setString(8, g.getProducing_area());
		ps.setString(9, g.getEffect());
		ps.setString(10, g.getWeight());
		ps.setString(11, g.getColor());
		ps.setString(12, g.getDescribe());
		ps.setInt(13, g.getSeries_id());
	
		if (ps.executeUpdate() > 0) {
			return true;
		}
		DBUtils.close(conn, ps, null);
		
		return false;
		
	}

	public List<Goods> selectAll() throws SQLException {
		Connection conn = DBUtils.getConnection();
		String sql = "SELECT * FROM good";
		// 创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		//将数据库中的记录转换为对象
		List<Goods>  list=new ArrayList<Goods>();
		//结果集
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Goods g=new Goods();
			g.setGoods_id(rs.getInt(1));
			g.setGoods_name(rs.getString(2));
			g.setStore_number(rs.getInt(3));
			g.setGood_buy_price(rs.getBigDecimal(4));
			g.setGood_sell_price(rs.getBigDecimal(5));
			g.setGood_sale_price(rs.getBigDecimal(6));
			g.setIf_onsale(rs.getBoolean(7));
			g.setAlert_num(rs.getInt(8));
			g.setProducing_area(rs.getString(9));
			g.setEffect(rs.getString(10));
			g.setWeight(rs.getString(11));
			g.setColor(rs.getString(12));
			g.setDescribe(rs.getString(13));
			g.setSeries_id(rs.getInt(14));
			list.add(g);
		}
		DBUtils.close(conn, ps, null);
		return list;
	}

	public List<Goods> selectWhere(String whereSql) throws SQLException {
		
		Connection conn = DBUtils.getConnection();
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT * ");
		sb.append("FROM good ");
		sb.append(" WHERE 1=1 ");
		sb.append(whereSql);
		System.out.println(sb.toString());
		
		PreparedStatement ps = conn.prepareStatement(sb.toString());	
		List<Goods>  list= new ArrayList<Goods>();
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Goods g=new Goods();
			g.setGoods_id(rs.getInt(1));
			g.setGoods_name(rs.getString(2));
			g.setStore_number(rs.getInt(3));
			g.setGood_buy_price(rs.getBigDecimal(4));
			g.setGood_sell_price(rs.getBigDecimal(5));
			g.setGood_sale_price(rs.getBigDecimal(6));
			g.setIf_onsale(rs.getBoolean(7));
			g.setAlert_num(rs.getInt(8));
			g.setProducing_area(rs.getString(9));
			g.setEffect(rs.getString(10));
			g.setWeight(rs.getString(11));
			g.setColor(rs.getString(12));
			g.setDescribe(rs.getString(13));
			g.setSeries_id(rs.getInt(14));
			list.add(g);
		
		
		}
		DBUtils.close(conn, ps, rs);
		return list;
		
	
	}

	public boolean delete(int id) throws SQLException {
		Connection conn = DBUtils.getConnection();
		String sql = "DELETE FROM good WHERE goods_id=?";
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
		Connection conn = DBUtils.getConnection();
		int index = (currentPage - 1) * pageSize;
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT * FROM good WHERE 1=1 ");
		sb.append(whereSql);
		sb.append(" ORDER BY goods_id desc ");
		sb.append( " LIMIT " + index + "," + pageSize);

		PreparedStatement ps0 = conn.prepareStatement(sb.toString());
		ResultSet rs0 = ps0.executeQuery();
		List<Goods> list = new ArrayList<>();
	while(rs0.next()) {
		Goods g=new Goods();
		g.setGoods_id(rs0.getInt(1));
		g.setGoods_name(rs0.getString(2));
		g.setStore_number(rs0.getInt(3));
		g.setGood_buy_price(rs0.getBigDecimal(4));
		g.setGood_sell_price(rs0.getBigDecimal(5));
		g.setGood_sale_price(rs0.getBigDecimal(6));
		g.setIf_onsale(rs0.getBoolean(7));
		g.setAlert_num(rs0.getInt(8));
		g.setProducing_area(rs0.getString(9));
		g.setEffect(rs0.getString(10));
		g.setWeight(rs0.getString(11));
		g.setColor(rs0.getString(12));
		g.setDescribe(rs0.getString(13));
		g.setSeries_id(rs0.getInt(14));
		list.add(g);
		}
		String sql = "SELECT count(*) FROM good  WHERE 1=1 " + whereSql;
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
	public Map<String, Object> findFour(String whereSql, int currentPage, int pageSize) throws Exception {
		Connection conn = DBUtils.getConnection();
		int index = (currentPage - 1) * pageSize;
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT good.goods_id,goods_name,store_number,good_buy_price,good_sell_price,good_sale_price,if_onsale,alert_num,producing_area,effect,weight, ");
		sb.append(" color,describes,good.series_id,series.brand_id,series_name,series.sort_level, ");
		sb.append(" brand_name,brand_country,brand_level ");
		sb.append(" FROM good,series,brand WHERE series.brand_id=brand.brand_id and good.series_id=series.series_id ");
		sb.append(whereSql);
		sb.append(" ORDER BY good.goods_id DESC ");
		sb.append(" LIMIT "+index+","+pageSize);
		
		PreparedStatement ps = conn.prepareStatement(sb.toString());
		//将数据库中的记录转换为对象
		List<Goods>  list=new ArrayList<>();
		//结果集
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Goods good=new Goods();
			//添加角色			
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
			
			//创建系列对象
			Series series = new Series();
			series.setSeries_id(rs.getInt(14));
			series.setBrand_id(rs.getInt(15));
			series.setSeries_name(rs.getString(16));
			series.setSort_level(rs.getInt(17));
			//创建品牌对象
			Brand brand = new Brand();
			brand.setBrand_id(rs.getInt(15));
			brand.setBrand_name(rs.getString(18));
			brand.setBrand_country(rs.getString(19));
			brand.setBrand_level(rs.getInt(20));

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
			
			
			good.setSeries(series);
			good.setBrand(brand);
			good.setImage(image_goods);
			
			
			list.add(good);
			
		}
		
		String sql="SELECT count(*) From good,series,brand\r\n" + 
				"WHERE series.brand_id=brand.brand_id and good.series_id=series.series_id " +whereSql;
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
	@Override
	public Map<String, Object> like_qurey(String goods_name, String series_name, String brand_name, int currentPage, int pageSize) throws Exception {
		StringBuffer wheresql=new StringBuffer();
		wheresql.append("");
		if(goods_name!=null&&!goods_name.equals("")) {
			wheresql.append(" and goods_name like '%"+goods_name + "%'");
		
		}
		if(series_name!=null&&!series_name.equals("")) {
			wheresql.append("and series_name like '%"+series_name + "%'");
			
		}
		if(brand_name!=null&&!brand_name.equals("")) {
			wheresql.append(" and brand_name like '%"+brand_name + "%'");
			
		}
		
		GoodsDaoI gdi=new GoodsDaoImpl();
		Map<String, Object> map=gdi.findFour(wheresql.toString(),currentPage, pageSize);
		
		return map;
	}

}
