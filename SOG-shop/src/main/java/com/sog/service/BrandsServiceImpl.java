/**
 * 
 */
package com.sog.service;

import java.util.List;
import java.util.Map;

import com.sog.dao.BrandDaoI;
import com.sog.dao.BrandDaoImpl;

import com.sog.entity.Brand;


/**
 * @ClassName BrandsServiceImpl
 * @Description 
 * @Author 杨云凯
 * @Date 2018年6月29日 下午4:11:14
 */
public class BrandsServiceImpl implements BrandsServiceI<Brand> {

	private static BrandDaoI<Brand> bdi = new BrandDaoImpl() ;
	
	public boolean add(Brand b) throws Exception {
		List<Brand> list = bdi.selectWhere(" and brand_id='" + b.getBrand_id()+ "'");
		if (list.size() > 0) {
			return false;	
		}
		return bdi.insert(b);
		
	}


	public boolean modify(Brand b) throws Exception {
		return bdi.update(b);
	}

	
	public boolean remove(int id) throws Exception {
		return bdi.delete(id);
	}

	
	public List<Brand> findByAll() throws Exception {
		
		return bdi.selectAll();
	}

	public Map<String, Object> getPageAll(String wheresql, int currentPage, int pageSize) throws Exception {
		return bdi.selectPage(wheresql, currentPage, pageSize);
	}

	
	public List<Brand> getWhere(String whereSql) throws Exception {
	
		return bdi.selectWhere(whereSql);
	}

	
	public List<Brand> GetIdBrands(int id) throws Exception {
		return bdi.selectWhere(" and brand_id="+id );
	}

}
