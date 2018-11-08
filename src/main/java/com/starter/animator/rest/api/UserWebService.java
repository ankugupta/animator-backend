package com.starter.animator.rest.api;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starter.animator.beans.RestResponse;
import com.starter.animator.beans.UserBean;
import com.starter.animator.manager.UserManager;

@RestController()
@RequestMapping("/user")
public class UserWebService {
	
	@Resource 
	private UserManager userManager;

	@GetMapping
	public ResponseEntity<RestResponse<UserBean>> getAllUsers() {
		List<UserBean> users = this.userManager.getUsers();
		RestResponse<UserBean> response = new RestResponse<>(users, users.size());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/userId")
	public ResponseEntity<RestResponse<UserBean>> getUserById(@PathVariable("userId") String userId) {
		RestResponse<UserBean> response = new RestResponse<>(this.userManager.getUserById(userId), 1);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<RestResponse<UserBean>> createUser(UserBean userBean){
		UserBean userCreated = this.userManager.createUser(userBean);
		RestResponse<UserBean> response = new RestResponse<>(userCreated, 1);
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<RestResponse<UserBean>> updateUser(UserBean userBean){
		this.userManager.updateUser(userBean);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/userId")
	public ResponseEntity<RestResponse<UserBean>> deleteUser(@PathVariable("userId") String userId) {
		this.userManager.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
