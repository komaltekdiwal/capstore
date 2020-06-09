package com.capgemini.capstore.bean;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coupon")
public class CouponBean {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int couponId;
	@Column
	private String couponCode;
	@Column
	private String couponInformation;
	@Column
	private LocalDate couponExpireDate;
	@Column
	private double discount;
	@Column
	private int count;
	@Column
	private double originalBill;
	
	
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public String getCouponInformation() {
		return couponInformation;
	}
	public void setCouponInformation(String couponInformation) {
		this.couponInformation = couponInformation;
	}
	public LocalDate getCouponExpireDate() {
		return couponExpireDate;
	}
	public void setCouponExpireDate(LocalDate couponExpireDate) {
		this.couponExpireDate = couponExpireDate;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getOriginalBill() {
		return originalBill;
	}
	public void setOriginalBill(double originalBill) {
		this.originalBill = originalBill;
	}
	
	
}
