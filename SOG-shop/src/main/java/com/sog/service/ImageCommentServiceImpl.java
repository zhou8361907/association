package com.sog.service;

import java.util.List;
import java.util.Map;

import org.omg.PortableServer.IMPLICIT_ACTIVATION_POLICY_ID;

import com.sog.dao.Image_commentDaoI;
import com.sog.dao.Image_commentDaoImpl;
import com.sog.entity.Image_comment;

public class ImageCommentServiceImpl implements ImageCommentServiceI<Image_comment> {

	Image_commentDaoI<Image_comment> icdi = new Image_commentDaoImpl();
	@Override
	public boolean add(Image_comment t) throws Exception {
		return icdi.insert(t);
	}

	@Override
	public boolean modify(Image_comment t) throws Exception {
		return icdi.update(t);
	}

	@Override
	public boolean remove(int id) throws Exception {
		return icdi.delete(id);
	}

	@Override
	public List<Image_comment> findByAll() throws Exception {
		return icdi.selectAll();
	}

	@Override
	public Map<String, Object> getPageAll(String wheresql, int currentPage, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Image_comment> getWhere(String whereSql) throws Exception {
		return icdi.selectWhere(whereSql);
	}

}
