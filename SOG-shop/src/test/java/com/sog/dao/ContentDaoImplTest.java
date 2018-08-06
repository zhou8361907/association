package com.sog.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sog.entity.Content;

public class ContentDaoImplTest {
	ContentDaoI cdi=new ContentDaoImpl();
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void test_insert() {
		Content content=new Content();
		content.setOrder_id(1);
		content.setGoods_id(1);
		content.setOrder_number(4);
		content.setNote("速发");
		boolean bool;
		try {
			bool = cdi.insert(content);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void test_update() {
		Content content=new Content();
		content.setOrder_id(2);
		content.setGoods_id(2);
		content.setOrder_number(6);
		content.setNote("申通");
		content.setOrder_content_id(2);
		boolean bool;
		try {
			bool = cdi.update(content);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void test_delete() {
		boolean bool;
		try {
			bool = cdi.delete(4);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void test_seleteAll() {
		try {
			List<Content> list=cdi.selectAll();
			//
			for (Content content : list) {
				System.out.println(content.getOrder_content_id());
				System.out.println(content.getGoods_id());
			}
			//Assert.assertEquals(list.size(), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test_seletewhere() {
		String whereSql=" and order_id=13";
		try {
			List<Content> list=cdi.selectWhere(whereSql);
			//
			for (Content content : list) {
				System.out.println(content.getOrder_content_id());
				System.out.println(content.getGoods().getGoods_name());
			}
			//Assert.assertEquals(list.size(), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
