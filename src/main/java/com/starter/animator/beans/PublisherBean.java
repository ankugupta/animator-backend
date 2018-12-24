package com.starter.animator.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PublisherBean {

	private String id;
	private String publisherId;
	private String publisherName;
	private AddressBean contactAddress;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public AddressBean getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(AddressBean contactAddress) {
		this.contactAddress = contactAddress;
	}

	@Override
	public String toString() {
		return "PublisherBean [id=" + id + ", publisherId=" + publisherId + ", publisherName=" + publisherName
				+ ", contactAddress=" + contactAddress + "]";
	}

}
