package com.starter.animator.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BookBean {

	private String id;
	private String bookId;
	private String title;
	private String author;
	private String description;
	private String imageUrl;
	private String publisherId;
	private String publisherName;
	private String schoolClass;
	private String subject;
	private String targetDATUrl;
	private String targetXMLUrl;
	private Integer noOfVideos;
	private Integer noOfActivities;
	private List<PageBean> pages;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

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

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(String schoolClass) {
		this.schoolClass = schoolClass;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTargetDATUrl() {
		return targetDATUrl;
	}

	public void setTargetDATUrl(String targetDATUrl) {
		this.targetDATUrl = targetDATUrl;
	}

	public String getTargetXMLUrl() {
		return targetXMLUrl;
	}

	public void setTargetXMLUrl(String targetXMLUrl) {
		this.targetXMLUrl = targetXMLUrl;
	}

	public Integer getNoOfVideos() {
		return noOfVideos;
	}

	public void setNoOfVideos(Integer noOfVideos) {
		this.noOfVideos = noOfVideos;
	}

	public Integer getNoOfActivities() {
		return noOfActivities;
	}

	public void setNoOfActivities(Integer noOfActivities) {
		this.noOfActivities = noOfActivities;
	}

	public List<PageBean> getPages() {
		return pages;
	}

	public void setPages(List<PageBean> pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "BookBean [id=" + id + ", bookId=" + bookId + ", title=" + title + ", author=" + author
				+ ", description=" + description + ", imageUrl=" + imageUrl + ", publisherId=" + publisherId
				+ ", publisherName=" + publisherName + ", schoolClass=" + schoolClass + ", subject=" + subject
				+ ", targetDATUrl=" + targetDATUrl + ", targetXMLUrl=" + targetXMLUrl + ", noOfVideos=" + noOfVideos
				+ ", noOfActivities=" + noOfActivities + ", pages=" + pages + "]";
	}

}
