package com.sog.entity;
/**
 * 
 * @类名: Level_user
 * @描述: 会员等级表
 * @作者：周帅
 * @日期：2018年6月28日下午9:58:24
 */
public class Level_user {

	private int level_id;
	private String level_name;
	private int level_score;
	private int level_discount;
	
	public Level_user() {}
	public Level_user(int level_id, String level_name, int level_score, int level_discount) {
		super();
		this.level_id = level_id;
		this.level_name = level_name;
		this.level_score = level_score;
		this.level_discount = level_discount;
	}
	public int getLevel_id() {
		return level_id;
	}
	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}
	public String getLevel_name() {
		return level_name;
	}
	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}
	public int getLevel_score() {
		return level_score;
	}
	public void setLevel_score(int level_score) {
		this.level_score = level_score;
	}
	public int getLevel_discount() {
		return level_discount;
	}
	public void setLevel_discount(int level_discount) {
		this.level_discount = level_discount;
	}
	
	
	
}
