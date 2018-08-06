package com.sog.service;




import java.util.List;
import java.util.Map;

import com.sog.dao.Level_userDaoI;
import com.sog.dao.Level_userDaoImpl;
import com.sog.dao.UserDaoI;
import com.sog.dao.UserDaoImpl;
import com.sog.entity.Level_user;
import com.sog.entity.User;

/**
 * 
 * @类名: Level_userServiceImpl
 * @描述: level_userService接口实现
 * @作者：周帅
 * @日期：2018年6月29日上午10:49:10
 */

public class Level_userServiceImpl implements Level_userServiceI<Level_user> {
	private static Level_userDaoI ldi = new Level_userDaoImpl();
	@Override
	public boolean add(Level_user t) throws Exception {
		List<Level_user> list = ldi.selectWhere(" and level_name='" + t.getLevel_name() + "'");
		if (list.size() > 0) {
			return false;	
		}
		return ldi.insert(t);
	}

	@Override
	public boolean modify(Level_user t) throws Exception {
		// TODO Auto-generated method stub
		return ldi.update(t);
	}

	@Override
	public boolean remove(int id) throws Exception {
		// TODO Auto-generated method stub
		return ldi.delete(id);
	}

	@Override
	public List<Level_user> findByAll() throws Exception {
		// TODO Auto-generated method stub
		return ldi.selectAll();
	}

	@Override
	public Map<String, Object> getPageAll(String wheresql, int currentPage, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return ldi.selectPage(wheresql, currentPage, pageSize);
	}

	@Override
	public List<Level_user> getWhere(String whereSql) throws Exception {
		// TODO Auto-generated method stub
		return ldi.selectWhere(whereSql);
	}

}
