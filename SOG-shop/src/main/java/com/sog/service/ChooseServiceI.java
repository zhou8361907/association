package com.sog.service;

import java.util.List;
import java.util.Map;

import com.sog.entity.Choose;
import com.sog.entity.User;
/**
 * 
 * @类名: ChooseServiceI
 * @描述: chooseService 的接口
 * @作者：周帅
 * @日期：2018年7月3日下午1:44:55
 * @param <T>
 */
public interface ChooseServiceI<T> extends BaseServiceI<T> {
	public void clear(int user_id) throws Exception ;
	
	
	//按用户名查找购物车内容
		public List<Choose> SelectByUser(int user_id) throws Exception;
	
		
	//通过choose_id,num来获取choose
		public Choose SelectBych_id(int choose_id,int num) throws Exception;
		
}
