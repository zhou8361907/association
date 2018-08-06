package com.sog.service;

import java.util.List;
import java.util.Map;

import com.sog.dao.LocationDaoI;
import com.sog.dao.LocationDaoImpl;
import com.sog.entity.Location;

public class LocationServiceImpl implements LocationServiceI<Location> {

	LocationDaoI ldi = new LocationDaoImpl();
	@Override
	public boolean add(Location t) throws Exception {
		return ldi.insert(t);
	}

	@Override
	public boolean modify(Location t) throws Exception {
		return ldi.update(t);
	}

	@Override
	public boolean remove(int id) throws Exception {
		return ldi.delete(id);
	}

	@Override
	public List<Location> findByAll() throws Exception {
		return ldi.selectAll();
	}

	@Override
	public Map<String, Object> getPageAll(String wheresql, int currentPage, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> getWhere(String whereSql) throws Exception {
		return ldi.selectWhere(whereSql);
	}

}
