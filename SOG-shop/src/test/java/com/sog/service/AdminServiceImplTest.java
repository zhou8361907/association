package com.sog.service;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sog.entity.Admin;

import junit.framework.Assert;

public class AdminServiceImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	AdminServiceI asi = new AdminServiceImpl();
	@Test
	public void testAdd() {
		Admin adm = new Admin();
		adm.setRole_id(3);
		adm.setAcount("456");
		adm.setName("admin2");
		adm.setPassword("123456");
		adm.setGender(0);
		boolean bool = false;
		try {
			bool = asi.add(adm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(bool);
	}

	@Test
	public void testModify() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testResetPWD() {
		fail("Not yet implemented");
	}

}
