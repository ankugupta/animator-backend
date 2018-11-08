package com.starter.animator.manager;

import java.util.List;

import com.starter.animator.beans.UserBean;

public interface UserManager {

	List<UserBean> getUsers();
	
	UserBean getUserById(String userId);
	
	UserBean createUser(UserBean userRequest);
	
	void updateUser(UserBean userRequest);
	
	void deleteUser(String userId);
}
