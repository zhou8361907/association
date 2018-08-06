package com.sog.entity;

public class Image_goods {
	private int image_id;
	private int goods_id;
	private String route;
	private int sort;
	
	private Goods good;
	
	public Goods getGood() {
		return good;
	}
	public void setGood(Goods good) {
		this.good = good;
	}
	public Image_goods() {}
	public Image_goods(int image_id, int goods_id, String route, int sort) {
		super();
		this.image_id = image_id;
		this.goods_id = goods_id;
		this.route = route;
		this.sort = sort;
	}
	public int getImage_id() {
		return image_id;
	}
	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	
	
}
