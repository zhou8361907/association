package com.sog.dao;

import java.util.Map;

public interface Image_commentDaoI<T> extends BaseDao<T> {
	public Map<String,Object> findImageAndComment(String whereSql, int currentPage, int pagenum) throws Exception;
}
