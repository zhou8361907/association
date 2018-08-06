package com.sog.dao;



import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.sog.entity.Goods;


public class GoodsDaoImplTest {

	GoodsDaoI<Goods> gdi=new GoodsDaoImpl();
	@Test
	public void testInsert() {
		Goods g=new Goods();
		g.setGoods_name("lankou");
		g.setStore_number(200);
		g.setGood_buy_price(BigDecimal.valueOf(205.18));
		g.setGood_sell_price(BigDecimal.valueOf(500.10));
		g.setGood_sale_price(BigDecimal.valueOf(400.10));
		g.setIf_onsale(false);
		g.setAlert_num(105);
		g.setProducing_area("Manchester");
		g.setEffect("youqise");
		g.setWeight("250mg");
		g.setColor("hongse ");
		g.setDescribe("hen ");
		g.setSeries_id(5);
		try {

			Assert.assertTrue(gdi.insert(g));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
@Test
	public void testUpdate() {
		Goods g=new Goods();
		g.setGoods_name("lankou update 2" );
		g.setStore_number(200);
		g.setGood_buy_price(BigDecimal.valueOf(205.18));
		g.setGood_sell_price(BigDecimal.valueOf(500.10));
		g.setGood_sale_price(BigDecimal.valueOf(400.10));
		g.setIf_onsale(false);
		g.setAlert_num(105);
		g.setProducing_area("manchesite update  2");
		g.setEffect("youqise update");
		g.setWeight("250mg");
		g.setColor("update");
		g.setDescribe("update");
		g.setSeries_id(05);
		g.setGoods_id(2);
		try {

			Assert.assertTrue(gdi.update(g));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			boolean bool=((GoodsDaoImpl) gdi).delete(21);
		    Assert.assertTrue(bool);
		}
	    	catch (Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	}

	@Test
	public void testSelect() throws SQLException
	{   
			List<Goods> list=(List<Goods>) ((GoodsDaoImpl) gdi).selectAll();
		    for(Goods g:list)
			{ 
			 System.out.println(g.getGoods_id());
			 
	        }
	         Assert.assertEquals(list.size(),3);
			
			
		}	

	
	@Test
	public void testSelectWhere() {
		String whereSql=" and goods_id='4'";
		try {
			List <Goods> list=((GoodsDaoImpl) gdi).selectWhere(whereSql);
			 for(Goods g:list)
				{ 
				 System.out.println( g.getGoods_id());
	
		        }
			Assert.assertTrue(list.size()>0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testfindFour() {
		Map<String,Object> map=new HashMap<>();
		try {
			map = gdi.findFour("", 1, 3);
			for (Object value : map.values()) {
				System.out.println(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
