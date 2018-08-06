package com.sog.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface GoodsDaoI<Goods> extends BaseDao<Goods> {
	public boolean insert(Goods goods) throws SQLException;
	public List<Goods> selectAll() throws SQLException;
	public  List<Goods> selectWhere(String whereSql) throws SQLException;
	public boolean delete(int id) throws SQLException;
	
	//商品查询 2018.6.30
	public Map<String,Object> findFour(String whereSql, int currentPage, int pagenum) throws Exception;
	//模糊查询
		public Map<String, Object> like_qurey(String goods_name, String series_name, String brand_name, int currentPage, int pageSize) throws Exception;
}
