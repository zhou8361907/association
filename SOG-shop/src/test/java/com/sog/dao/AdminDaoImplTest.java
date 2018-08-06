package com.sog.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sog.entity.Admin;
import com.sun.prism.shader.AlphaOne_LinearGradient_AlphaTest_Loader;

public class AdminDaoImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	AdminDaoI adi =new AdminDaoImpl();
	@Test
	public void testInsert() {
		Admin adm=new Admin();
		adm.setName("adasn");
		adm.setPassword("12asdfads3456");
		adm.setGender(1);
		adm.setRole_id(3);
		adm.setStates(1);
		boolean bool;
		try {
			bool = adi.insert(adm);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Test
	public void testUpdate() {
		Admin adm=new Admin();
		adm.setName("admn");
		adm.setPassword("123412412");
		adm.setGender(0);
		adm.setRole_id(0);
		adm.setStates(1);
		//id
		adm.setId(1);
		boolean bool;
		try {
			bool = adi.update(adm);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Test
	public void testDelete() {
		boolean bool;
		try {
			bool = adi.delete(16);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Test
	public void testSelectAll() {
		try {
			List<Admin> list=adi.selectAll();
			//
			for (Admin adm : list) {
				System.out.println(adm.getName());
			}
			Assert.assertEquals(list.size(), 3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectWhere() {
		try {
			List<Admin> list=adi.selectAll();
			//
			for (Admin adm : list) {
				System.out.println(adm.getName());
			}
			Assert.assertEquals(list.size(), 3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testfindAdminAndRole() {
		Map<String,Object> map=new HashMap<>();
		try {
			map = adi.findAdminAndRole("", 1, 3);
			for (Object value : map.values()) {
				System.out.println(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
