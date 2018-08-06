package com.sog.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import com.sog.entity.Order;
import com.sog.entity.Roles;

public class OrderDaoImplTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	OrderDaoI odi = new OrderDaoImpl();
	@Test
	public void testInsert() {
		Order order = new Order();
		order.setOrderId(2);
		order.setOrderStage(1);
		order.setBeginTime(null);
		order.setFinishTime(null);
		order.setSumMoney(BigDecimal.valueOf(1));
		order.setTransportId(1);
		order.setUserId(2);
		try {

			Assert.assertTrue(odi.insert(order));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		Order order = new Order();
		order.setOrderId(1);
		order.setOrderStage(222);
		order.setBeginTime(null);
		order.setFinishTime(null);
		order.setSumMoney(BigDecimal.valueOf(1));
		order.setTransportId(1);
		order.setUserId(2);
		try {

			Assert.assertTrue(odi.update(order));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			
		    Assert.assertTrue(odi.delete(3));
		}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	

	@Test
	public void testSelectAll() throws Exception {
		List<Order> list= odi.selectAll();
	    for(Order r:list)
		{ 
		 System.out.println(r.getOrderId());
		 
        }
         Assert.assertEquals(list.size(),2);
	}

	@Test
	public void testSelectWhere() {
		String whereSql=" and order_id=13  ";
		try {
			List<Order> list=odi.selectWhere(whereSql);
			 for(Order r:list)
				{ 
				 System.out.println(r.getContentList().size());

		        }
			Assert.assertTrue(list.size()>0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectPage() {
		fail("Not yet implemented");
	}

}
