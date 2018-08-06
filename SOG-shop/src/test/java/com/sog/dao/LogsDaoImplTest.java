package com.sog.dao;
import java.sql.SQLException;   
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


import com.sog.entity.Logs;

public class LogsDaoImplTest {
	LogsDaoI<Logs> ldi=new LogsDaoImpl();
	@Test
	public void testInsert() {
		Logs t=new Logs();
		
		t.setOperate_content("login content insert");
		t.setSecurity_class(1);
		t.setIf_success(false);
		t.setOperate_type("login insert");
		
		try {

			Assert.assertTrue(ldi.insert(t));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdate() throws Exception  {
		Logs t=new Logs();
		t.setOperate_content("Login update test");
		t.setSecurity_class(18);
		t.setIf_success(false);
		t.setOperate_type("buy update test");
		t.setLogs_id(27);
		boolean bool=((LogsDaoImpl) ldi).update(t);
	    Assert.assertTrue(bool);
	}	
	@Test
    public void testDelete() throws SQLException {
    	try {
		boolean bool=((LogsDaoImpl) ldi).delete(25);
	    Assert.assertTrue(bool);
	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
	};
	@Test
	public void testSelect() throws SQLException
{   
		List<Logs> list=(List<Logs>) ((LogsDaoImpl) ldi).selectAll();
	    for(Logs t:list)
		{ 
		 System.out.println(t.getOperate_content()+t.getSecurity_class());
		 
        }
         Assert.assertEquals(list.size(),2);
		
		
	}	

	@Test
	public void testSelectWhere() {
		String whereSql=" and logs_id='27' and security_class=18 ";
		try {
			List<Logs> list=((LogsDaoImpl) ldi).selectWhere(whereSql);
			 for(Logs t:list)
				{ 
				 System.out.println( t.getSecurity_class());
	
		        }
			Assert.assertTrue(list.size()>0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
