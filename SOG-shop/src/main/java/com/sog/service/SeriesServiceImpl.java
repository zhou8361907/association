
package com.sog.service;

import java.util.List;
import java.util.Map;

import com.sog.dao.SeriesDaoI;
import com.sog.dao.SeriesDaoImpl;
import com.sog.entity.Series;

/**
 * @ClassName SeriesServiceImpl
 * @Description 
 * @Author 杨云凯
 * @Date 2018年6月29日 下午10:23:43
 */
public class SeriesServiceImpl implements SeriesServiceI<Series>{

	
	private static SeriesDaoI<Series> sdi =new SeriesDaoImpl();

	public boolean add(Series s) throws Exception {
		
		List<Series> list = sdi.selectWhere(" and series_name='" + s.getSeries_name() + "'");
		if (list.size() > 0) {
			return false;	
		}
		return sdi.insert(s);
	}

	
	
	public boolean modify(Series s) throws Exception {
		return sdi.update(s);
	}

	
	
	public boolean remove(int id) throws Exception {
		return sdi.delete(id);
	}

	
	public List<Series> findByAll() throws Exception {
		return sdi.selectAll();
	}

	
	
	public Map<String, Object> getPageAll(String wheresql, int currentPage, int pageSize) throws Exception {
		
		return null;
	}

	
	@Override
	public List<Series> getWhere(String whereSql) throws Exception {
		return sdi.selectWhere(whereSql);
	}

	
	@Override
	public List<Series> GetIdSeries(int id) throws Exception {
		
		return sdi.selectWhere(" and brand_id="+id );
	}

	@Override
	public Map<String, Object> getSeriesAndBrand(int currentPage, int pageSize) throws Exception {
		return sdi.findSeriesAndBrand("", currentPage, pageSize);
	}

}
