package com.sog.entity;

import java.math.BigDecimal;

public class Goods {
private Integer goods_id;
private String goods_name;
private Integer store_number;
private BigDecimal good_buy_price;
private BigDecimal good_sell_price;
private BigDecimal good_sale_price;
private boolean if_onsale;
private Integer alert_num;
private String producing_area;
private String effect;
private String weight;
private String color;
private String describe;
private Integer series_id;

	private Image_goods image;
	private Series series;
	private Brand brand;
public Image_goods getImage() {
		return image;
	}
	public void setImage(Image_goods image) {
		this.image = image;
	}
	public Series getSeries() {
		return series;
	}
	public void setSeries(Series series) {
		this.series = series;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
public Integer getGoods_id() {
	return goods_id;
}
public void setGoods_id(Integer goods_id) {
	this.goods_id = goods_id;
}
public String getGoods_name() {
	return goods_name;
}
public void setGoods_name(String goods_name) {
	this.goods_name = goods_name;
}
public Integer getStore_number() {
	return store_number;
}
public void setStore_number(Integer store_number) {
	this.store_number = store_number;
}
public BigDecimal getGood_buy_price() {
	return good_buy_price;
}
public void setGood_buy_price(BigDecimal good_buy_price) {
	this.good_buy_price = good_buy_price;
}
public BigDecimal getGood_sell_price() {
	return good_sell_price;
}
public void setGood_sell_price(BigDecimal good_sell_price) {
	this.good_sell_price = good_sell_price;
}
public BigDecimal getGood_sale_price() {
	return good_sale_price;
}
public void setGood_sale_price(BigDecimal good_sale_price) {
	this.good_sale_price = good_sale_price;
}
public boolean isIf_onsale() {
	return if_onsale;
}
public void setIf_onsale(boolean if_onsale) {
	this.if_onsale = if_onsale;
}
public Integer getAlert_num() {
	return alert_num;
}
public void setAlert_num(Integer alert_num) {
	this.alert_num = alert_num;
}
public String getProducing_area() {
	return producing_area;
}
public void setProducing_area(String producing_area) {
	this.producing_area = producing_area;
}
public String getEffect() {
	return effect;
}
public void setEffect(String effect) {
	this.effect = effect;
}
public String getWeight() {
	return weight;
}
public void setWeight(String weight) {
	this.weight = weight;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getDescribe() {
	return describe;
}
public void setDescribe(String describe) {
	this.describe = describe;
}
public Integer getSeries_id() {
	return series_id;
}
public void setSeries_id(Integer series_id) {
	this.series_id = series_id;
}

}
