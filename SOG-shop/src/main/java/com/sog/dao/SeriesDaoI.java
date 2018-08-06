package com.sog.dao;


import java.util.Map;

public interface SeriesDaoI<Series> extends BaseDao<Series> {
	public Map<String,Object> findSeriesAndBrand(String whereSql, int currentPage, int pagenum) throws Exception;
	
}
