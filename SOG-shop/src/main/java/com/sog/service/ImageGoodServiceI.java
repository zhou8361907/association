package com.sog.service;

import java.util.Map;

public interface ImageGoodServiceI<T> extends BaseServiceI<T> {
	public Map<String,Object> getImageAndGoodPageAll(int currentPage, int pageSize) throws Exception;
	
}
