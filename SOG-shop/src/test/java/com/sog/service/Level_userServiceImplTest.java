package com.sog.service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.sog.entity.Level_user;

public class Level_userServiceImplTest {
	Level_userServiceI lsi=new Level_userServiceImpl();
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void test_add() {
		Level_user level=new Level_user();
		level.setLevel_name("vip3");
		level.setLevel_score(100);
		level.setLevel_discount(9);
		boolean bool;
		try {
			bool = lsi.add(level);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
