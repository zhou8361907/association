package com.sog.service;
import java.util.List;
import java.util.Map;

import com.sog.dao.UserDaoI;
import com.sog.dao.UserDaoImpl;
import com.sog.entity.User;


/**
 * 
 * @类名: UserServiceImpl
 * @描述: UserServiceI的接口实现
 * @作者：周帅
 * @日期：2018年6月27日上午9:46:47
 */
public class UserServiceImpl implements UserServiceI<User> {
	private static UserDaoI udi = new UserDaoImpl();
	public boolean add(User t) throws Exception {
		List<User> list = udi.selectWhere(" and account='" + t.getAccount() + "'");
		if (list.size() > 0) {
			return false;	
		}
		return udi.insert(t);
	}

	public boolean modify(User t) throws Exception {
		// TODO Auto-generated method stub
		return udi.update(t);
	}

	public boolean remove(int id) throws Exception {
		// TODO Auto-generated method stub
		return udi.delete(id);
	}

	public List<User> findByAll() throws Exception {
		// TODO Auto-generated method stub
		return udi.selectAll();
	}
	
	
	

	@Override
	public Map<String, Object> getPageAll(String wheresql, int currentPage, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return udi.selectPage(wheresql, currentPage, pageSize);
	}

	@Override
	public List<User> getWhere(String whereSql) throws Exception {
		// TODO Auto-generated method stub
		return udi.selectWhere(whereSql);
	}

	@Override
	public Map<String, Object> like_qurey(User t, int currentPage, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return udi.like_qurey(t, currentPage, pageSize);
	}
	
	@Override
	public boolean login(String account, String password) throws Exception {
		String whereSql =" and account='" + account+ "' and password='" + password+"'"; 
		List<User> list = udi.selectWhere(whereSql);
		if(list.size()>0) {
			return true;
		}
		return false;
		
	}

	
	@Override
	public boolean register(String account) throws Exception {
		String  whereSql =" and account='" + account+"'";
		List<User> list = udi.selectWhere(whereSql);
		if(list.size()>0) {
			return false;
		}
		return true;
			
	}

}
