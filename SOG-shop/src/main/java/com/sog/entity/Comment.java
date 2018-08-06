package com.sog.entity;

import java.sql.Timestamp;

public class Comment {
	private Goods good;
	private User uesr;
	private Image_comment image;	
	
	public Goods getGood() {
		return good;
	}
	public void setGood(Goods good) {
		this.good = good;
	}
	public User getUesr() {
		return uesr;
	}
	public void setUesr(User uesr) {
		this.uesr = uesr;
	}
	public Image_comment getImage() {
		return image;
	}
	public void setImage(Image_comment image) {
		this.image = image;
	}
	private Integer commentId;
	@Override
	public String toString() {
		return "comment [commentId=" + commentId + ", userId=" + userId + ", goodsId=" + goodsId + ", commentTime="
				+ commentTime + ", commentContent=" + commentContent + ", commentStarNumber=" + commentStarNumber + "]";
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Timestamp getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Integer getCommentStarNumber() {
		return commentStarNumber;
	}
	public void setCommentStarNumber(Integer commentStarNumber) {
		this.commentStarNumber = commentStarNumber;
	}
	private Integer userId;
	private Integer goodsId;
	private Timestamp commentTime;
	private String commentContent;
	private Integer commentStarNumber;
}
