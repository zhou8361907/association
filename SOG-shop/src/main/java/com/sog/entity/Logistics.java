/**
 * 
 */
package com.sog.entity;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author 杨云凯
 *
 */
public class Logistics {
	private Integer transport_id;
	private Integer order_id;
	private String company_name ;
	private String transport_method;
	private BigDecimal fee;
	private Date send_time;
	private String send_address;
	private String receiver_address;
	private String receiver_phone;
	private String receiver_name;
	private Date receiver_time;
	private String transport_number;
	
	
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public Integer getTransport_id() {
		return transport_id;
	}
	public void setTransport_id(Integer transport_id) {
		this.transport_id = transport_id;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getTransport_method() {
		return transport_method;
	}
	public void setTransport_method(String transport_method) {
		this.transport_method = transport_method;
	}
	public BigDecimal getFee() {
		return fee;
	}
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
	public Date getSend_time() {
		return send_time;
	}
	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}
	public String getSend_address() {
		return send_address;
	}
	public void setSend_address(String send_address) {
		this.send_address = send_address;
	}
	public String getReceiver_address() {
		return receiver_address;
	}
	public void setReceiver_address(String receiver_address) {
		this.receiver_address = receiver_address;
	}
	public String getReceiver_phone() {
		return receiver_phone;
	}
	public void setReceiver_phone(String receiver_phone) {
		this.receiver_phone = receiver_phone;
	}
	public Date getReceiver_time() {
		return receiver_time;
	}
	public void setReceiver_time(Date receiver_time) {
		this.receiver_time = receiver_time;
	}
	public String getTransport_number() {
		return transport_number;
	}
	public void setTransport_number(String transport_number) {
		this.transport_number = transport_number;
	}


}
