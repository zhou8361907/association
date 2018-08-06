/**
 * 
 */
package com.sog.service;

import java.util.List;
import java.util.Map;

/**
 * @param <T>
 * @ClassName SeriesServiceI
 * @Description 
 * @Author 杨云凯
 * @Date 2018年6月29日 下午10:19:03
 */
public interface SeriesServiceI<Series>  extends BaseServiceI<Series>{

	List<Series> GetIdSeries(int id) throws Exception;
	public Map<String,Object> getSeriesAndBrand(int currentPage, int pageSize) throws Exception;
}
