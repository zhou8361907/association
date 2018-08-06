package com.sog.service;

import java.awt.LinearGradientPaint;
import java.util.List;
import java.util.Map;

import com.sog.dao.Image_goodsDaoI;
import com.sog.dao.Image_goodsDaoImpl;
import com.sog.entity.Image_goods;

public class ImageGoodServiceImpl implements ImageGoodServiceI<Image_goods> {

	Image_goodsDaoI igdi = new Image_goodsDaoImpl();
	@Override
	public boolean add(Image_goods t) throws Exception {
		return igdi.insert(t);
	}

	@Override
	public boolean modify(Image_goods t) throws Exception {
		return igdi.update(t);
	}

	@Override
	public boolean remove(int id) throws Exception {
		return igdi.delete(id);
	}

	@Override
	public List<Image_goods> findByAll() throws Exception {
		return igdi.selectAll();
	}

	@Override
	public Map<String, Object> getPageAll(String wheresql, int currentPage, int pageSize) throws Exception {
		
		return null;
	}

	@Override
	public List<Image_goods> getWhere(String whereSql) throws Exception {
		return igdi.selectWhere(whereSql);
	}

	@Override
	public Map<String, Object> getImageAndGoodPageAll(int currentPage, int pageSize) throws Exception {
		return igdi.findImageAndGood("", currentPage, pageSize);
	}

}
