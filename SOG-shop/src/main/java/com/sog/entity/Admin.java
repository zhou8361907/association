package com.sog.entity;

import java.sql.Timestamp;

public class Admin {
	private Integer id;
	private String account;
	private String password;
	private String name;
	
	private Roles role;
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", account=" + account + ", password=" + password + ", name=" + name + ", create_time="
				+ create_time + ", last_login_time=" + last_login_time + ", last_location=" + last_location
				+ ", role_id=" + role_id + ", phone=" + phone + ", gender=" + gender + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAcount() {
		return account;
	}
	public void setAcount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getLast_location() {
		return last_location;
	}
	public void setLast_location(String last_location) {
		this.last_location = last_location;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	private Timestamp create_time;
	private Timestamp last_login_time;
	private String last_location;
	private Integer role_id;
	private String phone;
	private Integer gender;
	private Integer states;
	public Integer getStates() {
		return states;
	}
	public void setStates(Integer states) {
		this.states = states;
	}
}
