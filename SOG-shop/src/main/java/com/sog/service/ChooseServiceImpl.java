package com.sog.service;

import java.util.List;
import java.util.Map;

import com.sog.dao.AdminDaoI;
import com.sog.dao.AdminDaoImpl;
import com.sog.dao.ChooseDaoI;
import com.sog.dao.ChooseDaoImpl;
import com.sog.entity.Admin;
import com.sog.entity.Choose;
/**
 * 
 * @类名: ChooseServiceImpl
 * @描述: choose的接口实现  利用 循环删除 实现clear  
 * @作者：周帅
 * @日期：2018年7月3日下午1:45:18
 */
public class ChooseServiceImpl implements ChooseServiceI<Choose> {
	private static ChooseDaoI cdi=new ChooseDaoImpl();
	@Override
	public boolean add(Choose t) throws Exception {
		List<Choose> list = cdi.selectWhere(" and user_id='"+ t.getUser_id() + "'"+" and goods_id='"+ t.getGoods_id() + "'"+" and type='"+ 0 + "'");
		if(list.size()>0) {
			Choose ch1=list.get(0);
			
			int num=ch1.getNumber()+t.getNumber();
			t.setChoose_id(ch1.getChoose_id());
			t.setNumber(num);
		
			return cdi.update(t);
		}else {
			return cdi.insert(t);
		}
		
	
	}

	@Override
	public boolean modify(Choose t) throws Exception {
		// TODO Auto-generated method stub
		return cdi.update(t);
	}

	@Override
	public boolean remove(int id) throws Exception {
		// TODO Auto-generated method stub
		return cdi.delete(id);
	}

	@Override
	public List<Choose> findByAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getPageAll(String wheresql, int currentPage, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Choose> getWhere(String whereSql) throws Exception {
		// TODO Auto-generated method stub
		return cdi.selectWhere(whereSql);
	}

	@Override
	public void clear(int user_id) throws Exception {
		List <Choose> list=cdi.SelectByUser(user_id);
		for(Choose choose :list) {
			cdi.delete(choose.getChoose_id());
		}
		
	
	}

	@Override
	public List<Choose> SelectByUser(int user_id) throws Exception {
		// TODO Auto-generated method stub
		return cdi.SelectByUser(user_id);
	}

	@Override
	public Choose SelectBych_id(int choose_id, int num) throws Exception {
		
		return cdi.SelectBych_id(choose_id, num);
	}

}
