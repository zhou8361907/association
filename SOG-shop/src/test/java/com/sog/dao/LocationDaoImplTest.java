package com.sog.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import com.sog.entity.Level_user;
import com.sog.entity.Location;

public class LocationDaoImplTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	LocationDaoI ldi = new LocationDaoImpl();
	@Test
	public void testInsert() {
		Location location=new Location();
		location.setLocationId(2);
		location.setUserId(2);
		location.setName("111");
		location.setPhone("123123");
		location.setLocation("12312");
		boolean bool;
		try {
			bool = ldi.insert(location);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Test
	public void testUpdate() {
		Location location=new Location();
		location.setLocationId(2);
		location.setUserId(2);
		location.setName("111");
		location.setPhone("666666");
		location.setLocation("12312");
		boolean bool;
		try {
			bool = ldi.update(location);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Test
	public void testDelete() {
		boolean bool;
		try {
			bool = ldi.delete(2);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectAll() {
		try {
			List<Location> list=ldi.selectAll();
			//
			for (Location location : list) {
				System.out.println(location.getLocationId());
				System.out.println(location.getLocation());
				
			}
			//Assert.assertEquals(list.size(), 3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectWhere() {
		String whereSql=" and location_id=2";
		try {
			List<Location> list=ldi.selectWhere(whereSql);
			for (Location location : list) {
				System.out.println(location.getLocationId());
				System.out.println(location.getLocation());				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectPage() {
		fail("Not yet implemented");
	}

}
