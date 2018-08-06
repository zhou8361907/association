package com.sog.service;

import java.util.List;
import java.util.Map;

import com.sog.dao.RolesDaoI;
import com.sog.dao.RolesDaoImpl;
import com.sog.entity.Roles;

public class RolesServiceImpl implements RolesServicel<Roles> {
	RolesDaoI rdi = new RolesDaoImpl();
	@Override
	public boolean add(Roles t) throws Exception {
		return rdi.insert(t);
	}

	@Override
	public boolean modify(Roles t) throws Exception {
		return rdi.update(t);
	}

	@Override
	public boolean remove(int id) throws Exception {
		return rdi.delete(id);
	}

	@Override
	public List<Roles> findByAll() throws Exception {
		return rdi.selectAll();
	}

	

	@Override
	public Map<String, Object> getPageAll(String wheresql, int currentPage, int pageSize) throws Exception {
		return rdi.selectPage("", currentPage, pageSize);
		
	}

	@Override
	public List<Roles> getWhere(String whereSql) throws Exception {

		return rdi.selectWhere(whereSql);
	}

}
