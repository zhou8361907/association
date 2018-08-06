package com.sog.dao;
import java.sql.SQLException;
import java.util.List;
import com.sog.entity.Logs;

/**
 * 
 * @类名 LogsDaoI
 * @描述 TODO(一句话描述类的作用)
 * @作者 王帅
 * @日期 2018年6月26日 上午9:34:37
 *
 * @param <T>
 * @param <Logs>
 */
@SuppressWarnings("hiding")
public interface LogsDaoI<Logs> extends BaseDao<Logs> {
	public boolean insert(Logs logs) throws SQLException;
	public List<Logs> selectAll() throws SQLException;
	public List<Logs> selectWhere(String whereSql) throws SQLException;
	public boolean delete(int id) throws SQLException;
}
