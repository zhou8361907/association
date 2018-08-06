package com.sog.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sog.entity.Admin;
import com.sog.entity.Logistics;
import com.sog.entity.User;


public class LogisticsDaoImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	LogisticsDaoI ldi = new LogisticsDaoImpl();
	@Test
	public void testUpdate() {
		Logistics logi=new Logistics();
		logi.setCompany_name("顺丰");
		logi.setFee(BigDecimal.valueOf(9.01));
		logi.setOrder_id(1);
		logi.setTransport_id(1);
		logi.setReceiver_name("周帅");
		boolean bool;
		try {
			bool = ldi.update(logi);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Test
	public void testInsert() {
		Logistics logi=new Logistics();
		logi.setOrder_id(1);
		logi.setCompany_name("顺丰");
		logi.setFee(BigDecimal.valueOf(10.01));
		logi.setOrder_id(2);
		
		int bool;
		try {
			bool = ldi.insertre(logi);
			System.out.println(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Test
	public void testSelectAll() {
		try {
			List<Logistics> list=ldi.selectAll();
			//
			for (Logistics logi : list) {
				System.out.println(logi.getCompany_name());
				System.out.println(logi.getReceiver_name());
			}
			//Assert.assertEquals(list.size(), 3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectWhere() {
		String whereSql=" and company_name='顺丰' and fee='10.01'";
		System.out.println("1111");
		try {
			System.out.println("1111");
			List<Logistics> list=ldi.selectWhere(whereSql);
			System.out.println("1111");
			Assert.assertTrue(list.size()>0);
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
	public void testSelectPage() {
		fail("Not yet implemented");
	}

}
