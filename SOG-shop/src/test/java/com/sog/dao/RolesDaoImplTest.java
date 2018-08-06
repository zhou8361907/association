/**
 * 
 */
package com.sog.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.sog.entity.Roles;


/**
 * @author 杨云凯
 *
 */
public class RolesDaoImplTest {

RolesDaoI<Roles> rdi=new RolesDaoImpl();
	@Test
	public void testInsert() {
			Roles r=new Roles();
			r.setRole_position("shichang总监");	
			r.setRole_privilege(4);
			
			try {

				Assert.assertTrue(rdi.insert(r));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	
	
	@Test
	public void testDelete() throws SQLException {
		try {
		
	    Assert.assertTrue(rdi.delete(2));
	}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	};

	@Test
	public void testSelect() throws SQLException
	{   
			List<Roles> list= rdi.selectAll();
		    for(Roles r:list)
			{ 
			 System.out.println(r.getRole_position());
			 
	        }
	         Assert.assertEquals(list.size(),4);
			
			
		}	


	@Test
	public void testSelectWhere() {
		String whereSql=" and role_privilege='1'  ";
		try {
			List<Roles> list=((RolesDaoImpl) rdi).selectWhere(whereSql);
			 for(Roles r:list)
				{ 
				 System.out.println(r.getRole_position());

		        }
			Assert.assertTrue(list.size()>0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testUpdate() throws Exception  {
		Roles r=new Roles();
		
	r.setRole_position("营销经理");
		r.setRole_privilege(1);
		r.setRole_id(1);
		boolean bool=((RolesDaoImpl) rdi).update(r);
	    Assert.assertTrue(bool);
	}	
	
	@Test
	public void testSelectPage() {
		int pageNum=3;
		int pageCur=4;
		Map<String,Object> map;
		try {
			map = rdi.selectPage("", pageCur, pageNum);
			int count=(int) map.get("count");
			List<Roles> list=(List<Roles>) map.get("list");
			if(count%pageNum==0) {
				System.out.println("总页数："+count/pageNum+"页");
			}else {
				System.out.println("总页数："+(count/pageNum+1)+"页");
			}
			for (Roles role : list) {
				System.out.println(role.getRole_id());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
