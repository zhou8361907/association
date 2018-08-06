package com.sog.dao;

import java.util.Map;

/**
 * 
 * @类名 AdminDaoI
 * @描述 TODO(一句话描述类的作用)
 * @作者 王帅
 * @日期 2018年6月26日 上午9:34:26
 *
 * @param <T>
 */
public interface AdminDaoI<T> extends BaseDao<T> {
	public Map<String,Object> findAdminAndRole(String whereSql, int currentPage, int pagenum) throws Exception;
}
