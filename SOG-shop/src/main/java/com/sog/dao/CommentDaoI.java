package com.sog.dao;

import java.util.Map;

public interface CommentDaoI<T> extends BaseDao<T> {
	public Map<String,Object> findFour(String whereSql, int currentPage, int pagenum) throws Exception;
}
