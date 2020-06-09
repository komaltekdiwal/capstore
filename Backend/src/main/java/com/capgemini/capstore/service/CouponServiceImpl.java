package com.capgemini.capstore.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.bean.CouponBean;
import com.capgemini.capstore.bean.OrderDetailsBean;
import com.capgemini.capstore.dao.CouponDAO;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponDAO couponDAO;
	
	@Override
	public List<CouponBean> showAllCoupons() {
		couponDAO.deleteCoupon();
		return couponDAO.showAllCoupons();
	}

	@Override
	public boolean addCoupon(CouponBean couponBean) {
		return couponDAO.addCoupon(couponBean);
	}

	@Override
	public boolean updateCoupon(CouponBean couponBean) {
		return couponDAO.updateCoupon(couponBean);
	}

	@Override
	public boolean applyCoupon(int couponId, String email) {
		return couponDAO.applyCoupon(couponId, email);
	}

	@Override
	public OrderDetailsBean invoiceGenerator(String email) {
		return couponDAO.invoiceGenerator(email);
	}

	
}
