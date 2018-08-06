package com.sog.service;

import java.util.Map;

public interface CommentServiceI<T> extends BaseServiceI<T> {
	public Map<String,Object> getFour(String whereSql, int currentPage, int pageSize) throws Exception;
}
