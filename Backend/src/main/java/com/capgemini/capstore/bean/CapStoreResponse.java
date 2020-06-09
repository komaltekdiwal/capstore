package com.capgemini.capstore.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;


public class CapStoreResponse {
	private int statusCode;
	private String message;
	private String description;
	private CouponBean couponBean;
	private List<CouponBean> couponList;
	private OrderDetailsBean orderDetails;
	
	public OrderDetailsBean getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetailsBean orderDetails) {
		this.orderDetails = orderDetails;
	}

	public CapStoreResponse() {
		
	}
	
	public CapStoreResponse(String message) {
		this.message = message;
	}

	
	//Generate getters and setters
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CouponBean getCouponBean() {
		return couponBean;
	}

	public void setCouponBean(CouponBean couponBean) {
		this.couponBean = couponBean;
	}

	public List<CouponBean> getCouponList() {
		return couponList;
	}

	public void setCouponList(List<CouponBean> couponList) {
		this.couponList = couponList;
	}
	
}//End of class
