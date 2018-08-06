package com.sog.service;



import java.util.List;
import java.util.Map;

import com.sog.entity.Admin;

/**
 * 
 * @类名 AdminServiceI
 * @描述 业务层管理接口
 * @作者 王帅
 * @日期 2018年6月24日 上午9:00:41
 *
 */

public interface AdminServiceI<T> extends BaseServiceI<T>{
	//登录
	public boolean login(String adm,String password) throws Exception ;
	//重置密码
	public boolean resetPWD(Admin adm) throws Exception ;
	//无条件，分页查询
	public Map<String,Object> getAdminAndRolePageAll(int currentPage, int pageSize) throws Exception;
	//查找账号是否存在
	public boolean getAdminExsit(String account) throws Exception;
	
}
