package com.sog.dao;

import java.util.List;
import com.sog.entity.Goods;

public interface BrandSeriesDaoI<T>  extends BaseDao<T>  {
//��ò��ظ��ĺ�����Ʒ��brand_id
	public List findBrandAndSeries( String whereSql) throws Exception;
//��ö�Ӧ��brand_id��goods
	public List<Goods> findgoodsByBrand( String whereSql) throws Exception;
	
}
