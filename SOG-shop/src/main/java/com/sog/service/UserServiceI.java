package com.sog.service;

import java.util.List;
import java.util.Map;

import com.sog.entity.User;

/**
 * 
 * @类名: UserServiceI
 * @描述: userServiceI的接口
 * @作者：周帅
 * @日期：2018年6月27日上午9:46:13
 * @param <T>
 */

public interface UserServiceI<T> extends BaseServiceI<T> {
	
	public Map<String, Object> like_qurey(User t, int currentPage, int pageSize) throws Exception;
	boolean login(String account, String password) throws Exception;
	
	boolean register(String account) throws Exception;
}
