package com.sog.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.sog.entity.Admin;
import com.sog.entity.User;

/**
 * 
 * @类名: UserDaoImplTest
 * @描述: userdaoImpl的测试类
 * @作者：周帅
 * @日期：2018年6月27日上午9:45:19
 */


public class UserDaoImplTest {
	UserDaoI udi=new UserDaoImpl();
	@Test
	public void test() {
		User user=new User();
		user.setAccount("周");
		user.setPassword("123");
		user.setStates(0);
		boolean bool;
		try {
			bool = udi.insert(user);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Test
	public void test_update() {
		User user=new User();
		
		user.setPassword("123");
		user.setUser_id(2);
		user.setStates(1);
		boolean bool;
		try {
			bool = udi.update(user);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	@Test
	public void test_delete() {
		boolean bool;
		try {
			bool = udi.delete(2);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		}
	
	@Test
	public void testSelectAll() {
		try {
			List<User> list=udi.selectAll();
			//
			for (User udm : list) {
				System.out.println(udm.getUser_id());
				System.out.println(udm.getStates());
				System.out.println(udm.getLast_login_time());
			}
			//Assert.assertEquals(list.size(), 3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSelectWhere() {
		String whereSql=" and account='1' and password='123'";
		System.out.println("1111");
		try {
			System.out.println("1111");
			List<Admin> list= udi.selectWhere(whereSql);
			System.out.println("1111");
			Assert.assertTrue(list.size()>0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testPage() {
		Map<String,Object> map;
		int pageNum=4;
		int pageCur=1;
		try {
			map=udi.selectPage("", pageCur, pageNum);
			int count=(int) map.get("count");
			List<User> list=(List<User>) map.get("list");
			if(count%pageNum==0) {
				System.out.println("总页数："+count/pageNum+"页");
			}else {
				System.out.println("总页数："+(count/pageNum+1)+"页");
			}
			for (User user : list) {
				System.out.println(user.getUser_id());}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
