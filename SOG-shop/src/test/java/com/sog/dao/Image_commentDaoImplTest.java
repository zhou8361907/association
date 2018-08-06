package com.sog.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import com.sog.entity.Image_comment;
import com.sog.entity.Image_goods;

public class Image_commentDaoImplTest {
	Image_commentDaoI icdi = new Image_commentDaoImpl();
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testInsert() {
		Image_comment image=new Image_comment();
		image.setComment_id(1);
		image.setRoute("file");
		image.setSort(1);
		boolean bool;
		try {
			bool = icdi.insert(image);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Test
	public void testUpdate() {
		Image_comment image=new Image_comment();
		image.setComment_id(2);
		image.setRoute("file3");
		image.setSort(3);
		image.setImage_id(3);
		boolean bool;
		try {
			bool = icdi.update(image);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Test
	public void testDelete() {
		boolean bool;
		try {
			bool = icdi.delete(2);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Test
	public void testSelectAll() {
		try {
			List<Image_comment> list=icdi.selectAll();
			//
			for (Image_comment image : list) {
				System.out.println(image.getImage_id());
				System.out.println(image.getComment_id());
			}
			//Assert.assertEquals(list.size(), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectWhere() {
		String whereSql=" and comment_id=1 and sort=1";
		try {
			List<Image_comment> list=icdi.selectWhere(whereSql);
			//
			for (Image_comment image : list) {
				System.out.println(image.getImage_id());
				System.out.println(image.getComment_id());
			}
			//Assert.assertEquals(list.size(), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindImageAndComment() {
		fail("Not yet implemented");
	}

}
