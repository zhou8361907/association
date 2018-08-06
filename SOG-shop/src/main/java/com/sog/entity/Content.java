package com.sog.entity;

public class Content {
	private int order_content_id;
	private int order_id;
	private int goods_id;
	private int order_number;
	private String note;
	private Goods goods;
	
	
	public Content() {}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getOrder_content_id() {
		return order_content_id;
	}
	public void setOrder_content_id(int order_content_id) {
		this.order_content_id = order_content_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getOrder_number() {
		return order_number;
	}
	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
