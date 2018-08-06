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
import com.sog.entity.Brand;
import com.sog.entity.Goods;
import com.sog.entity.Image_goods;
import com.sog.entity.Series;

public class BrandSeriesDaoImpl implements BrandSeriesDaoI<Series> {

	@Override
	public boolean insert(Series t) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Series t) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Series> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Series> selectWhere(String whereSql) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> selectPage(String whereSql, int currentPage, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
//获得不重复的含有商品的brand_id
	@Override
	public List findBrandAndSeries(String whereSql) throws Exception {
		
		Connection conn = DBUtils.getConnection();
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT series.brand_id FROM good,series,brand WHERE good.series_id=series.series_id and series.brand_id=brand.brand_id and good.goods_name!='' GROUP BY brand.brand_id");
		PreparedStatement ps = conn.prepareStatement(sb.toString());
		List list=new ArrayList<>();
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			//System.out.println(rs.getInt(1));
			list.add(rs.getInt(1));
		}

           return list;
	}

@Override
public List<Goods> findgoodsByBrand(String whereSql) throws Exception {
	Connection conn = DBUtils.getConnection();
	StringBuffer sb=new StringBuffer();
	sb.append("SELECT good.*,series.series_name,brand.brand_name,image_id,route,sort  FROM good,series,brand,image_goods WHERE good.series_id=series.series_id and series.brand_id=brand.brand_id and good.goods_id=image_goods.goods_id and good.goods_name!=''");
	sb.append(whereSql);
	PreparedStatement ps = conn.prepareStatement(sb.toString());
	List<Goods> list=new ArrayList<>();
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
		Goods good=new Goods();
		good.setGoods_id(rs.getInt(1));
		good.setGoods_name(rs.getString(2));
		good.setGood_sale_price(rs.getBigDecimal(6));
		good.setGood_sell_price(rs.getBigDecimal(5));
		Series series=new Series();
		//System.out.println(good.getGoods_id());
		series.setSeries_name(rs.getString(15));
		Image_goods image=new Image_goods(); 
        image.setImage_id(rs.getInt(17));
        image.setRoute(rs.getString(18));
		Brand brand=new Brand();
		brand.setBrand_name(rs.getString(16));
		good.setBrand(brand);
		good.setSeries(series);
		good.setImage(image);
		list.add(good);
	}
	return list;
}


}
