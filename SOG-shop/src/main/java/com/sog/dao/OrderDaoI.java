package com.sog.dao;

import java.util.List;
import java.util.Map;

import com.sog.entity.Choose;
import com.sog.entity.Order;

public interface OrderDaoI<T> extends BaseDao<T> {
	public int insertre(Order t) throws Exception;
	
	//关于通过user_id获得订单所有内容。
	public List<Choose> SelectByUser(int user_id) throws Exception;
}
