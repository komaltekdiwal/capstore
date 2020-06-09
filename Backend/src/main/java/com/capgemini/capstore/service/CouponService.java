package com.capgemini.capstore.service;

import java.util.List;

import com.capgemini.capstore.bean.CouponBean;
import com.capgemini.capstore.bean.OrderDetailsBean;

public interface CouponService {
	public List<CouponBean> showAllCoupons();
	public boolean addCoupon(CouponBean couponBean);
	public boolean updateCoupon(CouponBean couponBean);
	public boolean applyCoupon(int couponId,String email);
	public OrderDetailsBean invoiceGenerator(String email);
}
