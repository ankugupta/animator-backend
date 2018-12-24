package com.starter.animator.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Type for publisher information.
 * 
 * @author guptaank
 *
 */
@Document(collection = "publisher")
public class PublisherEntity {

	@Id
	private String id;
	private String publisherId;
	private String publisherName;
	private AddressEntity contactAddress;

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

	public AddressEntity getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(AddressEntity contactAddress) {
		this.contactAddress = contactAddress;
	}

	@Override
	public String toString() {
		return "PublisherBean [id=" + id + ", publisherId=" + publisherId + ", publisherName=" + publisherName
				+ ", contactAddress=" + contactAddress + "]";
	}

}
