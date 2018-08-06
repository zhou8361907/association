package com.sog.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sog.entity.Choose;

public class ChooseDaoImplTest {
	ChooseDaoI cdi=new ChooseDaoImpl();
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void test_insert() {
		Choose choose = new Choose();
		choose.setUser_id(1);
		choose.setGoods_id(1);
		choose.setType(false);
		choose.setNumber(30);
		boolean bool;
		try {
			bool = cdi.insert(choose);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void test_update() {
		Choose choose = new Choose();
		choose.setUser_id(2);
		choose.setGoods_id(2);
		choose.setType(false);
		choose.setNumber(50);
		choose.setChoose_id(2);
		boolean bool;
		try {
			bool = cdi.update(choose);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_delete() {
		boolean bool;
		try {
			bool = cdi.delete(3);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	@Test
	public void test_selectAll() {
		try {
			List<Choose> list=cdi.selectAll();
			//
			for (Choose choose : list) {
				System.out.println(choose.getChoose_id());
				System.out.println(choose.getNumber());
			}
			//Assert.assertEquals(list.size(), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test_selectwhere() {
		String whereSql=" and user_id=1 and goods_id=1";
		try {
			List<Choose> list=cdi.SelectByUser(1);
			//
			for (Choose choose : list) {
				System.out.println(choose.getChoose_id());
				System.out.println(choose.getNumber());
			}
			//Assert.assertEquals(list.size(), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
