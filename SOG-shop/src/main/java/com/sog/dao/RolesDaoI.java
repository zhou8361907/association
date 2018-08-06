package com.sog.dao;

import java.sql.SQLException;
import java.util.List;

public interface RolesDaoI<Roles> extends BaseDao<Roles> {
	public boolean insert(Roles r) throws SQLException;
	public List<Roles> selectAll() throws SQLException;
	public List<Roles> selectWhere(String whereSql) throws SQLException;
	public boolean delete(int id) throws SQLException;
}
