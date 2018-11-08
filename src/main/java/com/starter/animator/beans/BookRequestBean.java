package com.starter.animator.beans;

public class BookRequestBean {

	private String title;
	private String author;
	private String description;
	private String imageUrl;
	private String publisherId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}

	@Override
	public String toString() {
		return "BookRequestBean [title=" + title + ", author=" + author + ", description=" + description + ", imageUrl="
				+ imageUrl + ", publisherId=" + publisherId + "]";
	}

}
