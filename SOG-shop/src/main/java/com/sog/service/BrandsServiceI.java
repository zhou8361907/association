package com.sog.service;

import java.util.List;


public interface BrandsServiceI<Brand> extends BaseServiceI<Brand> {

	

	List<Brand> GetIdBrands(int id) throws Exception;

	
}
