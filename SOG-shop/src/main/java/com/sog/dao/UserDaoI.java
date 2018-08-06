package com.sog.dao;

import java.util.Map;

import com.sog.entity.User;

/**
 * 
 * @类名: UserDaoI
 * @描述: User表的接口类
 * @作者：周帅
 * @日期：2018年6月26日下午1:45:01
 */
public interface UserDaoI<T> extends BaseDao<T> {
	public Map<String, Object> like_qurey(User t, int currentPage, int pageSize) throws Exception;
}
