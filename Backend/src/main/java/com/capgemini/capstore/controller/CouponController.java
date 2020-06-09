package com.capgemini.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.bean.CapStoreResponse;
import com.capgemini.capstore.bean.CouponBean;
import com.capgemini.capstore.bean.OrderDetailsBean;
import com.capgemini.capstore.exception.CapstoreException;
import com.capgemini.capstore.service.CouponService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class CouponController {

	@Autowired
	CouponService couponService;
	
	@GetMapping(path = "/showAllCoupons" )
	public CapStoreResponse showAllCoupons() {
		List<CouponBean> couponList = couponService.showAllCoupons();
		CapStoreResponse capStoreResponse = new CapStoreResponse();
		if(couponList !=null && !couponList.isEmpty()) {
			capStoreResponse.setStatusCode(201);
			capStoreResponse.setMessage("Success");
			capStoreResponse.setDescription("Coupon records found...");
			capStoreResponse.setCouponList(couponList);
		}else {
			throw new CapstoreException("coupons can't be fetched");
		}
	return capStoreResponse;
	}

	@PostMapping("/addCoupon")
	public CapStoreResponse addCoupon(@RequestBody CouponBean couponBean) {
		CapStoreResponse capStoreResponse = new CapStoreResponse();
		boolean isProductAdded = couponService.addCoupon(couponBean);
		if (isProductAdded) {
			capStoreResponse.setStatusCode(201);
			capStoreResponse.setMessage("Success");
			capStoreResponse.setDescription("Coupon added successfully");
		}
		return capStoreResponse;
	}// End of addProduct()
	
	
	/*@DeleteMapping(path = "/deleteCoupon")
	public CapStoreResponse deleteCoupon(int couponId)	{
		boolean isDeleted = couponService.deleteCoupon(currentDate);
		
		CapStoreResponse capStoreResponse = new CapStoreResponse();
		if(isDeleted) {
			capStoreResponse.setStatusCode(201);
			capStoreResponse.setMessage("Success");
			capStoreResponse.setDescription("Coupon Deleted successfully...");
		}else {
			capStoreResponse.setStatusCode(401);
			capStoreResponse.setMessage("Failed");
			capStoreResponse.setDescription("Unable to deleted coupon...");
		}
		return capStoreResponse;
	}*/
	
	
	@PostMapping(path = "/applyCoupon")
	public CapStoreResponse applyCoupon(int couponId,String email) {
		boolean isApplied = couponService.applyCoupon(couponId,email);
		
		CapStoreResponse capStoreResponse = new CapStoreResponse();
		if(isApplied) {
			capStoreResponse.setStatusCode(201);
			capStoreResponse.setMessage("Success");
			capStoreResponse.setDescription("Coupon applied successfully");
		}else {
			capStoreResponse.setStatusCode(401);
			capStoreResponse.setMessage("Failed");
			capStoreResponse.setDescription("Coupon not applied");
		}
		return capStoreResponse;
	}
	
	
	@PostMapping(path = "/updateCoupon")
	public CapStoreResponse updateCoupon(@RequestBody CouponBean couponBean) {
		boolean couponUpdated = couponService.updateCoupon(couponBean);
		CapStoreResponse capStoreResponse = new CapStoreResponse();
		if (couponUpdated) {
			capStoreResponse.setStatusCode(201);
			capStoreResponse.setMessage("Success");
			capStoreResponse.setDescription("Product updated successfully");
		}
		return capStoreResponse;
	}// End of updateProduct()
	
	@GetMapping(path = "/invoiceGenerated" )
	public CapStoreResponse invoiceGenerator(@RequestParam String email) {
		OrderDetailsBean orderDetailsBean = couponService.invoiceGenerator(email);
		CapStoreResponse capStoreResponse = new CapStoreResponse();
		if(orderDetailsBean !=null) {
			capStoreResponse.setStatusCode(201);
			capStoreResponse.setMessage("Success");
			capStoreResponse.setDescription("Coupon records found...");
			capStoreResponse.setOrderDetails(orderDetailsBean);
		}else {
			throw new CapstoreException("coupons can't be fetched");
		}
	return capStoreResponse;
	}
	
}
