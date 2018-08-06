package com.sog.entity;
//杨云凯  
public class Series {
	private Integer series_id;
	private Integer brand_id;
	private String series_name;
	private Integer sort_level;
	private Brand brand;
	
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Integer getSort_level() {
		return sort_level;
	}
	public void setSort_level(Integer sort_level) {
		this.sort_level = sort_level;
	}
	public Integer getSeries_id() {
		return series_id;
	}
	public void setSeries_id(Integer series_id) {
		this.series_id = series_id;
	}
	public Integer getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}
	public String getSeries_name() {
		return series_name;
	}
	public void setSeries_name(String series_name) {
		this.series_name = series_name;
	}

}
