package com.starter.animator.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "page")
public class PageEntity {

	@Id
	private String id;
	private String pageId;
	private String bookId;
	private String pageNoInBook;
	private String imageUrl;
	private String contentType;
	private String contentUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getPageNoInBook() {
		return pageNoInBook;
	}

	public void setPageNoInBook(String pageNoInBook) {
		this.pageNoInBook = pageNoInBook;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentUrl() {
		return contentUrl;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	@Override
	public String toString() {
		return "PageBean [id=" + id + ", pageId=" + pageId + ", bookId=" + bookId + ", pageNoInBook=" + pageNoInBook
				+ ", imageUrl=" + imageUrl + ", contentType=" + contentType + ", contentUrl=" + contentUrl + "]";
	}

}
