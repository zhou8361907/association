package com.sog.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 杨云凯
 *
 */
public interface LogisticsDaoI <Logistics> extends BaseDao<Logistics> {
	public boolean insert(Logistics L) throws SQLException;
	public List<Logistics> selectAll() throws SQLException;
	public List<Logistics> selectWhere(String whereSql) throws SQLException;
	public boolean delete(int id) throws SQLException;
	
	//插入并返回id
	public int insertre(Logistics L) throws SQLException;
}
