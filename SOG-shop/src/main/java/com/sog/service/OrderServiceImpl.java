package com.sog.service;

import java.util.List;
import java.util.Map;

import com.sog.dao.OrderDaoI;
import com.sog.dao.OrderDaoImpl;
import com.sog.entity.Brand;
import com.sog.entity.Order;

public class OrderServiceImpl implements OrderServiceI<Order> {

	OrderDaoI<Order> odi = new OrderDaoImpl();
	@Override
	public boolean add(Order t) throws Exception {
		return odi.insert(t);
	}

	@Override
	public boolean modify(Order t) throws Exception {
		return odi.update(t);
	}

	@Override
	public boolean remove(int id) throws Exception {
		return odi.delete(id);
	}

	@Override
	public List<Order> findByAll() throws Exception {
		return odi.selectAll();
	}

	@Override
	public Map<String, Object> getPageAll(String wheresql, int currentPage, int pageSize) throws Exception {
		
		return odi.selectPage(wheresql, currentPage, pageSize);
	}

	@Override
	public List<Order> getWhere(String whereSql) throws Exception {
		return odi.selectWhere(whereSql);
	}
	
	@Override
	public List<Order> getIdOrders(int id) throws Exception {
	
		 return odi.selectWhere(" and order_id="+id );
	}

	@Override
	public int insertre(Order t) throws Exception {
		
		return odi.insertre(t);
	}

}
