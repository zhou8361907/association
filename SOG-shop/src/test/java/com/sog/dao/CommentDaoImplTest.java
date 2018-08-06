package com.sog.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import com.sog.entity.Comment;
import com.sog.entity.Goods;

public class CommentDaoImplTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	CommentDaoI cdi = new CommentDaoImpl();
	@Test
	public void testInsert() {
		Comment c=new Comment();
		c.setCommentId(2);
		c.setUserId(1);
		c.setGoodsId(1);
		c.setCommentTime(null);
		c.setCommentContent("12312312");
		c.setCommentStarNumber(5);
		try {

			Assert.assertTrue(cdi.insert(c));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		Comment c=new Comment();
		c.setCommentId(2);
		c.setUserId(1);
		c.setGoodsId(3);
		c.setCommentTime(null);
		c.setCommentContent("12312312");
		c.setCommentStarNumber(5);
		
		try {

			Assert.assertTrue(cdi.update(c));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			boolean bool=(cdi.delete(1));
		    Assert.assertTrue(bool);
		}
	    	catch (Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	}

	@Test
	public void testSelectAll() throws Exception {
		List<Comment> list=cdi.selectAll();
	    for(Comment c:list)
		{ 
		 System.out.println(c.getCommentId());
		 
        }
         Assert.assertEquals(list.size(),1);
		
	}

	@Test
	public void testSelectWhere() {
		String whereSql=" and comment_id=2";
		try {
			List <Comment> list=cdi.selectWhere(whereSql);
			for(Comment c:list)
			{ 
			 System.out.println(c.getCommentId());
			 
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

	@Test
	public void testFindFour() {
		Map<String,Object> map=new HashMap<>();
		try {
			map = cdi.findFour("", 1, 3);
			for (Object value : map.values()) {
				System.out.println(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
