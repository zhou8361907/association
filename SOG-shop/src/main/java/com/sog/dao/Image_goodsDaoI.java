package com.sog.dao;

import java.util.Map;

public interface Image_goodsDaoI<T> extends BaseDao<T> {
	public Map<String,Object> findImageAndGood(String whereSql, int currentPage, int pagenum) throws Exception;
}
