package com.coding.cafe.service;

import com.coding.cafe.entity.User;

public interface UserService {

	public User addUser(User theUser);
	//check email is already present or not
	public boolean checkEmail(String email);
//	public boolean checkPassword(String password);
	//Validate user credentials
	public boolean validate(String email, String password);
//	public boolean validate(String email, int password);
	
		
}
