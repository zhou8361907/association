package com.sog.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sog.entity.Brand;

public class BrandDaoImplTest {
	BrandDaoI bdi=new BrandDaoImpl();
	@Test
	public void test_insert() {
		Brand brand=new Brand();
		brand.setBrand_name("lv");
		brand.setBrand_country("美国");
		brand.setBrand_level(3);
		
		boolean bool;
		try {
			bool = bdi.insert(brand);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	@Test
	public void test() {
		
	}
	
	@Test
	public void test_update() {
		Brand brand=new Brand();
		brand.setBrand_name("six");
		brand.setBrand_country("中国");
		brand.setBrand_id(1);
		brand.setBrand_level(4);
		boolean bool;
		try {
			bool = bdi.update(brand);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Test
	public void test_delete() {
		boolean bool;
		try {
			bool = bdi.delete(3);
			Assert.assertTrue(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_selectAll() {
		try {
			List<Brand> list=bdi.selectAll();
			//
			for (Brand brand : list) {
				System.out.println(brand.getBrand_id());
				System.out.println(brand.getBrand_name());
			}
			//Assert.assertEquals(list.size(), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test_selectwhere() {
		String whereSql=" and brand_name ='lv' and brand_country='美国'";
		try {
			List<Brand> list=bdi.selectWhere(whereSql);
			for (Brand brand : list) {
				System.out.println(brand.getBrand_id());
				System.out.println(brand.getBrand_name());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
