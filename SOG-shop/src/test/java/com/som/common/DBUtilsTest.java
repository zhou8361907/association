package com.som.common;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sog.common.DBUtils;

public class DBUtilsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetConnection() {
		Connection conn = DBUtils.getConnection();
		//断言
		Assert.assertNotNull(conn);
	}

	@Test
	public void testClose() {
		fail("Not yet implemented");
	}

}
