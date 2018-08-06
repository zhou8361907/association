/**
 * 
 */
package com.sog.service;

import java.util.List;
import java.util.Map;


import com.sog.dao.LogsDaoI;
import com.sog.dao.LogsDaoImpl;

import com.sog.entity.Logs;

/**
 * @param <T>
 * @ClassName LogsServiceImpl
 * @Description 
 * @Author 杨云凯
 * @Date 2018年6月30日 下午1:56:12
 */
public class LogsServiceImpl implements LogsServiceDaoI {

	private	static LogsDaoI<Logs> ldi=new LogsDaoImpl();
	public boolean add(Logs l) throws Exception {
		
		
		return ldi.insert(l);
	}

	
	@Override
	public boolean modify( Logs l) throws Exception {
		return ldi.update(l);
	}

	
	
	public boolean remove(int id) throws Exception {
		
		return ldi.delete(id);
	}

	
	@Override
	public List<Logs> findByAll() throws Exception {
		return ldi.selectAll();
	}

	
	public Map<String, Object> getPageAll(String wheresql, int currentPage, int pageSize) throws Exception {
	
		return ldi.selectPage(wheresql, currentPage, pageSize);
	}

	
	public List<Logs> getWhere(String whereSql) throws Exception {
		return null;
	
		
	}

	public List<Logs> GetIdLogs(int id) throws Exception {
		return ldi.selectWhere(" and logs_id="+id );
	}

	
}
