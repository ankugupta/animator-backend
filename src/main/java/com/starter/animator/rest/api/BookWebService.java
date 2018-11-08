package com.starter.animator.rest.api;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starter.animator.beans.BookBean;
import com.starter.animator.beans.BookRequestBean;
import com.starter.animator.beans.RestResponse;
import com.starter.animator.manager.BookManager;

@RestController
@RequestMapping(value="publisher/{publisherId}/books")
public class BookWebService {
	
	@Resource 
	private BookManager bookManager;

	@GetMapping
	public ResponseEntity<RestResponse<BookBean>> getAllBooks(@PathVariable String publisherId) {
		List<BookBean> books = this.bookManager.getBooks(publisherId);
		RestResponse<BookBean> response = new RestResponse<>(books, books.size());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<RestResponse<BookBean>> getBookById(@PathVariable("bookId") String bookId, @PathVariable String publisherId) {
		RestResponse<BookBean> response = new RestResponse<>(this.bookManager.getBookById(bookId, publisherId), 1);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<RestResponse<BookBean>> create(@RequestBody BookRequestBean book, @PathVariable String publisherId) {
		
		RestResponse<BookBean> response = new RestResponse<>(this.bookManager.create(book, publisherId), 1);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
