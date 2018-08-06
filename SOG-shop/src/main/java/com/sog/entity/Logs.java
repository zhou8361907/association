package com.sog.entity;
import java.sql.Date;

public class Logs {
	private  Integer logs_id;
	private String operate_type;
	private String operate_content;
	private boolean if_success;
	
	
	public Integer getLogs_id() {
		return logs_id;
	}
	public void setLogs_id(Integer logs_id) {
		this.logs_id = logs_id;
	}
	
	
	public String getOperate_content() {
		return operate_content;
	}
	public void setOperate_content(String operate_content) {
		this.operate_content = operate_content;
	}
	private Date operate_time;
	public Date getOperate_time() {
		return operate_time;
	}
	public void setOperate_time(Date operate_time) {
		this.operate_time = operate_time;
	}
	private Integer security_class;
	public Integer getSecurity_class() {
		return security_class;
	}
	public void setSecurity_class(Integer security_class) {
		this.security_class = security_class;
	}
	public boolean isIf_success() {
		return if_success;
	}
	public void setIf_success(boolean if_success) {
		this.if_success = if_success;
	}
	public String getOperate_type() {
		return operate_type;
	}
	public void setOperate_type(String operate_type) {
		this.operate_type = operate_type;
	}






}
