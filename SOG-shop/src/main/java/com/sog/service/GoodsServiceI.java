package com.sog.service;

import java.util.List;
import java.util.Map;

import com.sog.dao.UserDaoI;
import com.sog.dao.UserDaoImpl;
import com.sog.entity.Goods;
import com.sog.entity.User;

public interface GoodsServiceI<Goods> extends BaseServiceI<Goods> {

	

	List<Goods> GetIdGoods(int id) throws Exception;
	
	public Map<String,Object> getFour(String whereSql, int currentPage, int pageSize) throws Exception;

	public Map<String, Object> like_qurey(String goods_name, String series_name, String brand_name, int currentPage, int pageSize) throws Exception;
}
