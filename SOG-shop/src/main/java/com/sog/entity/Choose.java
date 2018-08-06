package com.sog.entity;

import java.sql.Timestamp;
/**
 * 
 * @类名: Choose
 * @描述: 购物车和收藏表的实体 增加了 商品的属性
 * @作者：周帅
 * @日期：2018年7月3日下午1:42:08
 */
public class Choose {
	private int choose_id;
	private int user_id;
	private int goods_id;
	private Timestamp put_time;
	private int number;
	private Boolean type;
	private Goods good;
	public Choose() {}
	public Choose(int choose_id, int user_id, int goods_id, Timestamp put_time, int number, Boolean type) {
		super();
		this.choose_id = choose_id;
		this.user_id = user_id;
		this.goods_id = goods_id;
		this.put_time = put_time;
		this.number = number;
		this.type = type;
	}
	
	
	public Goods getGood() {
		return good;
	}
	public void setGood(Goods good) {
		this.good = good;
	}
	public int getChoose_id() {
		return choose_id;
	}
	public void setChoose_id(int choose_id) {
		this.choose_id = choose_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public Timestamp getPut_time() {
		return put_time;
	}
	public void setPut_time(Timestamp put_time) {
		this.put_time = put_time;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Boolean getType() {
		return type;
	}
	public void setType(Boolean type) {
		this.type = type;
	}
	
	
}
