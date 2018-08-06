package com.sog.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class Order {
	private Integer orderId;
	private Integer userId;
	private Integer transportId;
	private Integer orderStage;
	private BigDecimal sumMoney;
	private Timestamp beginTime;
	private Timestamp finishTime;
	private List<Content> ContentList;
	
	
	public List<Content> getContentList() {
		return ContentList;
	}
	public void setContentList(List<Content> contentList) {
		ContentList = contentList;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getTransportId() {
		return transportId;
	}
	public void setTransportId(Integer transportId) {
		this.transportId = transportId;
	}
	public Integer getOrderStage() {
		return orderStage;
	}
	public void setOrderStage(Integer orderStage) {
		this.orderStage = orderStage;
	}
	public BigDecimal getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(BigDecimal sumMoney) {
		this.sumMoney = sumMoney;
	}
	public Timestamp getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}
	public Timestamp getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}
}
