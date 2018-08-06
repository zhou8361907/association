package com.sog.dao;

import java.util.List;
import com.sog.entity.Goods;

public interface BrandSeriesDaoI<T>  extends BaseDao<T>  {
//获得不重复的含有商品的brand_id
	public List findBrandAndSeries( String whereSql) throws Exception;
//获得对应的brand_id的goods
	public List<Goods> findgoodsByBrand( String whereSql) throws Exception;
	
}
