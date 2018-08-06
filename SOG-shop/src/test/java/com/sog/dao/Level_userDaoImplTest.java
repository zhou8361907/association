package com.sog.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sog.entity.Brand;
import com.sog.entity.Level_user;
import com.sog.entity.User;

public class Level_userDaoImplTest {
	Level_userDaoI ldi=new Level_userDaoImpl();
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	
	@Test
	public void test_insert() {
		Level_user level=new Level_user();
		level.setLevel_name("vip4");
		level.setLevel_score(1000);
		level.setLevel_discount(2);
		boolean bool;
		try {
			bool = ldi.insert(level);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void test_update() {
		Level_user level=new Level_user();
		level.setLevel_name("vip2");
		level.setLevel_score(1000);
		level.setLevel_discount(9);
		level.setLevel_id(1);
		boolean bool;
		try {
			bool = ldi.update(level);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void test_delete() {
		boolean bool;
		try {
			bool = ldi.delete(3);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test_seleteAll() {
		try {
			List<Level_user> list=ldi.selectAll();
			//
			for (Level_user level : list) {
				System.out.println(level.getLevel_id());
				System.out.println(level.getLevel_name());
				
			}
			//Assert.assertEquals(list.size(), 3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_selectwhere() {
		String whereSql=" and level_name ='vip2' and level_id=1";
		try {
			List<Level_user> list=ldi.selectWhere(whereSql);
			for (Level_user level : list) {
				System.out.println(level.getLevel_id());
				System.out.println(level.getLevel_name());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
