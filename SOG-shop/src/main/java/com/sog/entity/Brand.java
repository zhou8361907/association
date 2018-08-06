package com.sog.entity;
/**
 * 
 * @类名: Brand 品牌类
 * @描述: 品牌表的实体
 * @作者：周帅
 * @日期：2018年6月28日上午8:18:29
 */
public class Brand {
	private int brand_id;
	private String brand_name;
	private String brand_country;
	private Integer brand_level;
	public Integer getBrand_level() {
		return brand_level;
	}
	public void setBrand_level(Integer brand_level) {
		this.brand_level = brand_level;
	}
	public Brand() {}
	public Brand(int brand_id, String brand_name, String brand_country) {
		super();
		this.brand_id = brand_id;
		this.brand_name = brand_name;
		this.brand_country = brand_country;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getBrand_country() {
		return brand_country;
	}
	public void setBrand_country(String brand_country) {
		this.brand_country = brand_country;
	}
	
}
