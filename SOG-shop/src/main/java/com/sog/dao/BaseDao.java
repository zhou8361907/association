package com.sog.dao;

import java.util.List;
/**
 * 
 * @类名 BaseDao
 * @描述 Dao层基类 设置CRUD
 * @作者 王帅
 * @日期 2018年6月26日 上午9:26:08
 *
 * @param <T>
 */
import java.util.Map;


/**
 * 
 * @类名: BaseDao
 * @描述: 增加分页
 * @作者：周帅
 * @日期：2018年6月27日上午10:07:34
 * @param <T>
 */
public interface BaseDao<T> {
	//向某个表中增加内容
	public boolean insert(T t) throws Exception;
	//向某个表中更新内容
	public boolean update(T t) throws Exception;
	//向某个表中删除内容
	public boolean delete(int id) throws Exception;
	//向某个表中查询内容
	public List<T> selectAll() throws Exception;
	
	//条件查询内容
	public List<T> selectWhere(String whereSql)throws Exception;
	
	
	//分页方法
	public Map<String, Object> selectPage(String whereSql,int currentPage,int pageSize) throws Exception;
}
