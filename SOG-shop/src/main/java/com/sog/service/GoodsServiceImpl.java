package com.sog.service;

import java.util.List;
import java.util.Map;

import com.sog.dao.GoodsDaoI;
import com.sog.dao.GoodsDaoImpl;

import com.sog.entity.Goods;

public class GoodsServiceImpl implements GoodsServiceI<Goods> {
	private static GoodsDaoI<Goods> gdi = new GoodsDaoImpl();
	public boolean add(Goods g) throws Exception {
		return gdi.insert(g);
	}

	public boolean modify(Goods g) throws Exception {
		// TODO Auto-generated method stub
		return gdi.update(g);
	}

	public boolean remove(int id) throws Exception {
		return gdi.delete(id);
	}

	public List<Goods> findByAll() throws Exception {
		// TODO Auto-generated method stub
		return gdi.selectAll();
	}
	
	
	

	@Override
	public List<Goods> GetIdGoods(int id) throws Exception {
		
		return gdi.selectWhere(" and goods_id="+id );
	}

	@Override
	public Map<String, Object> getPageAll(String wheresql, int currentPage, int pageSize) throws Exception {
		return gdi.selectPage(wheresql, currentPage, pageSize);
	}

	@Override
	public List<Goods> getWhere(String whereSql) throws Exception {
		return gdi.selectWhere(whereSql);
	}

	@Override
	public Map<String, Object> getFour(String whereSql, int currentPage, int pageSize) throws Exception {
		return gdi.findFour(whereSql, currentPage, pageSize);
	}
	
	@Override
	public Map<String, Object> like_qurey(String goods_name, String series_name, String brand_name, int currentPage,
			int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return gdi.like_qurey(goods_name, series_name, brand_name, currentPage, pageSize);
	}

	
	


	
}