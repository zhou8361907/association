package com.sog.service;

import java.util.List;
import java.util.Map;

import com.sog.dao.CommentDaoI;
import com.sog.dao.CommentDaoImpl;
import com.sog.entity.Comment;

public class CommentServiceImpl implements CommentServiceI<Comment> {

	CommentDaoI<Comment> cdi = new CommentDaoImpl();
	@Override
	public boolean add(Comment t) throws Exception {
		return cdi.insert(t);
	}

	@Override
	public boolean modify(Comment t) throws Exception {
		return cdi.update(t);
	}

	@Override
	public boolean remove(int id) throws Exception {
		return cdi.delete(id);
	}

	@Override
	public List<Comment> findByAll() throws Exception {
		return cdi.selectAll();
	}

	@Override
	public Map<String, Object> getPageAll(String wheresql, int currentPage, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> getWhere(String whereSql) throws Exception {
		return cdi.selectWhere(whereSql);
	}

	@Override
	public Map<String, Object> getFour(String whereSql, int currentPage, int pageSize) throws Exception {
		return cdi.findFour(whereSql, currentPage, pageSize);
	}

}
