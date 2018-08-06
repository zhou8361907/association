package com.sog.service;

import java.util.List;
import java.util.Map;

import org.junit.rules.DisableOnDebug;

import com.sog.dao.AdminDaoI;
import com.sog.dao.AdminDaoImpl;
import com.sog.entity.Admin;

public class AdminServiceImpl implements AdminServiceI<Admin> {
	private static AdminDaoI adi=new AdminDaoImpl();
	public boolean add(Admin t) throws Exception {
		List<Admin> list = adi.selectWhere(" and admin_account='"+ t.getAcount() + "'");
		if(list.size()>0) {
			return false;
		}
		return adi.insert(t);
	}

	public boolean modify(Admin t) throws Exception {
		
		return adi.update(t);
	}

	public boolean remove(int id) throws Exception {
		return adi.delete(id);
	}

	public List<Admin> findByAll() throws Exception {
		return adi.selectAll();

	}

	public boolean login(String adm, String password) throws Exception {
		String whereSql =" and admin_account='" + adm + "' and admin_password='" + password+"'"; 
		List<Admin> list = adi.selectWhere(whereSql);
		if(list.size()>0) {
			return true;
		}
		return false;
	}

	public boolean resetPWD(Admin adm) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public Map<String, Object> getAdminAndRolePageAll(int currentPage, int pageSize) throws Exception {
		return adi.findAdminAndRole("", currentPage, pageSize);
	}

	@Override
	public boolean getAdminExsit(String account) throws Exception {
		List<Admin> list=adi.selectWhere(" and admin_id='"+account+"'");
		if(list.size()>0) {
			return true;
		}
		return false;
	}

	@Override
	public Map<String, Object> getPageAll(String wheresql, int currentPage, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> getWhere(String whereSql) throws Exception {
		return adi.selectWhere(whereSql);
	}

}
