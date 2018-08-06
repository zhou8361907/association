package com.sog.dao;

import java.util.List;
import java.util.Map;

import com.sog.entity.Choose;
/**
 * 
 * @类名: ChooseDaoI
 * @描述: choose 的dao层接口
 * @作者：周帅
 * @日期：2018年7月3日下午1:43:13
 * @param <T>
 */
public interface ChooseDaoI<T> extends BaseDao<T> {
	
	//按用户名查找购物车内容
	public List<Choose> SelectByUser(int user_id) throws Exception;
	
	//通过choose_id,num来获取choose
	public Choose SelectBych_id(int choose_id,int num) throws Exception;
	
	//
}
