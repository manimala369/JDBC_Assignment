package com.jdbccustomerapplication;

import java.util.Date;

public class Customer {

	private int id;
	private String name;
	private String phone;
	private String email;
	private Date dob;
	private String address;
	private double purchasecap;
	public Customer(int id, String name, String phone, String email, Date dob, String address,
			double purchasecap) {
	
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
		this.address = address;
		this.purchasecap= purchasecap;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getPurchasecap() {
		return purchasecap;
	}
	public void setPurchasecap(double purchasecap) {
		this.purchasecap = purchasecap;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", dob=" + dob
				+ ", address=" + address + ", purchasecap=" + purchasecap + "]";
	}	
}