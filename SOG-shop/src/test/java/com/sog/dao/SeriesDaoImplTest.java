/**
 * @author 杨云凯
 
 */
package com.sog.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;


import com.sog.entity.Series;


public class SeriesDaoImplTest{
SeriesDaoI<Series> sdi=new SeriesDaoImpl();
	@Test
	public void testInsert() {
			Series s=new Series();
			s.setBrand_id(20);
			s.setSeries_name("兰蔻精华2");
			s.setSort_level(1);
			try {

				Assert.assertTrue(sdi.insert(s));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	
	
	@Test
	public void testDelete() throws SQLException {
		try {
		
	    Assert.assertTrue(sdi.delete(2));
	}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	};

	@Test
	public void testSelect() throws Exception
	{   
			List<Series> list= sdi.selectAll();
		    for(Series s:list)
			{ 
			 System.out.println(s.getSeries_name());
			 
	        }
	         Assert.assertEquals(list.size(),4);
			
			
		}	


	@Test
	public void testSelectWhere() {
		String whereSql=" and series_id='3'  ";
		try {
			List<Series> list=((SeriesDaoImpl) sdi).selectWhere(whereSql);
			 for(Series s:list)
				{ 
				 System.out.println(s.getSeries_id());

		        }
			Assert.assertTrue(list.size()>0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testUpdate() throws Exception  {
		Series s=new Series();
		s.setSeries_id(4);
		s.setBrand_id(15);
		s.setSeries_name("巴黎欧莱雅");
		s.setSort_level(2);
		boolean bool=((SeriesDaoImpl) sdi).update(s);
	    Assert.assertTrue(bool);
	}	
	
	@Test
	public void testfindAdminAndRole() {
		Map<String,Object> map=new HashMap<>();
		try {
			map = sdi.findSeriesAndBrand("", 1, 3);
			for (Object value : map.values()) {
				System.out.println(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
