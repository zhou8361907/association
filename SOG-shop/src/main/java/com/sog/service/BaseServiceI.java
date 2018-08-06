package com.sog.service;

import java.util.List;
import java.util.Map;

import com.sog.entity.Admin;


/**
 * 
 * @类名: BaseServiceI
 * @描述: 增加分页方法
 * @作者：周帅
 * @日期：2018年6月27日上午10:53:26
 * @param <T>
 */
public interface BaseServiceI<T> {
	//
	public boolean add(T t) throws Exception;
	//
	public boolean modify(T t) throws Exception;
	
	public boolean remove(int id) throws Exception;
	//获取记录的方法
	public List<T> findByAll() throws Exception;
	
	//
	public Map<String,Object> getPageAll(String wheresql, int currentPage,int pageSize)  throws Exception;
	//
	public List<T> getWhere(String whereSql) throws Exception;
}
