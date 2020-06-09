package com.capgemini.capstore.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="return_product")
public class ReturnProductBean {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int returnId;
	
	
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private int productId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getReturnId() {
		return returnId;
	}

	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}


}
