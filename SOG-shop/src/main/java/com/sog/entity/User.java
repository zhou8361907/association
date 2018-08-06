package com.sog.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
/**
 * 
 * @类名: User
 * @描述: user实体类增加了 states
 * @作者：周帅
 * @日期：2018年6月28日下午2:11:02
 */
public class User {
	private int user_id;
	private String account;
	private String password;
	private String user_name;
	private Date user_birthday;
	private int user_sex;
	private BigDecimal user_money;
	private int user_score;
	private String user_phone;
	private Timestamp create_time;
	private Timestamp last_login_time;
	private String last_login_location;
	private String image_url;
	private int states;
	
	
	
	public User() {}
	
	
	public User(int user_id, String account, String password, String user_name, Date user_birthday, int user_sex,
			BigDecimal user_money, int user_score, String user_phone, Timestamp create_time, Timestamp last_login_time,
			String last_login_location, String image_url, int states) {
		super();
		this.user_id = user_id;
		this.account = account;
		this.password = password;
		this.user_name = user_name;
		this.user_birthday = user_birthday;
		this.user_sex = user_sex;
		this.user_money = user_money;
		this.user_score = user_score;
		this.user_phone = user_phone;
		this.create_time = create_time;
		this.last_login_time = last_login_time;
		this.last_login_location = last_login_location;
		this.image_url = image_url;
		this.states = states;
	}


	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Date getUser_birthday() {
		return user_birthday;
	}
	public void setUser_birthday(Date user_birthday) {
		this.user_birthday = user_birthday;
	}
	public int getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(int user_sex) {
		this.user_sex = user_sex;
	}
	public BigDecimal getUser_money() {
		return user_money;
	}
	public void setUser_money(BigDecimal user_money) {
		this.user_money = user_money;
	}
	public int getUser_score() {
		return user_score;
	}
	public void setUser_score(int intuser_score) {
		this.user_score = intuser_score;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public Timestamp getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(Timestamp last_login_time) {
		this.last_login_time = last_login_time;
	}

	public String getLast_login_location() {
		return last_login_location;
	}
	public void setLast_login_location(String last_login_location) {
		this.last_login_location = last_login_location;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}


	public int getStates() {
		return states;
	}


	public void setStates(int states) {
		this.states = states;
	}
	
	
	
}
