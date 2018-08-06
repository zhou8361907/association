package com.sog.service;

import java.util.List;

import com.sog.entity.Order;

public interface OrderServiceI<T> extends BaseServiceI<T>{ 

	public 	List<Order> getIdOrders(int id) throws Exception;
	//插入后返回order_id
	public int insertre(Order t) throws Exception;
}
