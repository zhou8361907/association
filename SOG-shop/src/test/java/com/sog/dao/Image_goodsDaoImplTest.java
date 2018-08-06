package com.sog.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.sog.entity.Image_goods;

public class Image_goodsDaoImplTest {
	Image_goodsDaoI idi=new Image_goodsDaoImpl();
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	
	@Test
	public void test_insert() {
		Image_goods image=new Image_goods();
		image.setGoods_id(1);
		image.setRoute("file");
		image.setSort(1);
		boolean bool;
		try {
			bool = idi.insert(image);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void test_update() {
		Image_goods image=new Image_goods();
		image.setGoods_id(3);
		image.setRoute("file3");
		image.setSort(3);
		image.setImage_id(3);
		boolean bool;
		try {
			bool = idi.update(image);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	@Test
	public void test_delete() {
		boolean bool;
		try {
			bool = idi.delete(5);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	@Test
	public void test_selectAll() {
		try {
			List<Image_goods> list=idi.selectAll();
			//
			for (Image_goods image : list) {
				System.out.println(image.getImage_id());
				System.out.println(image.getGoods_id());
			}
			//Assert.assertEquals(list.size(), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_selectwhere() {
		String whereSql=" and goods_id=1 and sort=1";
		try {
			List<Image_goods> list=idi.selectWhere(whereSql);
			//
			for (Image_goods image : list) {
				System.out.println(image.getImage_id());
				System.out.println(image.getGoods_id());
			}
			//Assert.assertEquals(list.size(), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_findImageAndGood() {
		Map<String,Object> map=new HashMap<>();
		try {
			map = idi.findImageAndGood("", 1, 3);
			for (Object value : map.values()) {
				System.out.println(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
