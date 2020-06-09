package com.capgemini.capstore.dao;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.capstore.bean.CouponBean;
import com.capgemini.capstore.bean.OrderDetailsBean;

public interface CouponDAO {

	public List<CouponBean> showAllCoupons();
	public boolean addCoupon(CouponBean couponBean);
	public void deleteCoupon();
	public boolean updateCoupon(CouponBean couponBean);
	public boolean applyCoupon(int couponId, String email);
	public OrderDetailsBean invoiceGenerator(String email);
}
