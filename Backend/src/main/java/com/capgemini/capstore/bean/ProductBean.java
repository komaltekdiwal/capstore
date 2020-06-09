package com.capgemini.capstore.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductBean {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	@Column
	private String productName;
	@Column
	private String productPrice;
	@Column
	private String ProductQuantity;
	@Column
	private String productCategory;
	@Column
	private String productImage;
	@Column
	private double productDiscount;
	@Column
	private Date productDiscountExpireDate;
	@Column
	private String brandName;
	@Column
	private String email;

	// Getters and Setters
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductQuantity() {
		return ProductQuantity;
	}

	public void setProductQuantity(String productQuantity) {
		ProductQuantity = productQuantity;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public double getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(double productDiscount) {
		this.productDiscount = productDiscount;
	}

	public Date getProductDiscountExpireDate() {
		return productDiscountExpireDate;
	}

	public void setProductDiscountExpireDate(Date productDiscountExpireDate) {
		this.productDiscountExpireDate = productDiscountExpireDate;
	}

	public String getProductBrandName() {
		return brandName;
	}

	public void setbrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
