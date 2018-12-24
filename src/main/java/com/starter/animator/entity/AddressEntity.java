package com.starter.animator.entity;

/**
 * Type for address information. It is used via composition only.
 * 
 * @author guptaank
 *
 */
public class AddressEntity {

	private String address1;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	private String phoneNo;
	private String mobileNo;

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "AddressBean [address1=" + address1 + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", zipcode=" + zipcode + ", phoneNo=" + phoneNo + ", mobileNo=" + mobileNo + "]";
	}

}
