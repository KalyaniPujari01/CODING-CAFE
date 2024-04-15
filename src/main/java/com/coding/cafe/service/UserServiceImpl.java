package com.coding.cafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.cafe.entity.User;
import com.coding.cafe.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userrep;
	
	public UserServiceImpl(UserRepository userrep) {
		this.userrep=userrep;
	}



	@Override
	public User addUser(User theUser) {
		return userrep.save(theUser);
	}
	
	
	@Override
	public boolean checkEmail(String email) {
		return userrep.existsByEmail(email);
	}

//	@Override
//	public boolean checkPassword(String password) {
//		return userrep.existsPassword(password);
//	}
	
	
	
	@Override
	public boolean validate(String email, String password) {
         if(userrep.existsByEmail(email)) {
         	User u= userrep.getByEmail(email);
         	String dbPassword =u.getPassword();
        	System.out.println(email);
        	System.out.println(password);
         	System.out.println(u);
         	System.out.println(dbPassword);

         	if(password.equals(dbPassword) )
        	{
        		return true;
         		
        	}
         	else
         	{
         		return false;
         	}
        	
          }
         else
         {
        	 return false;
         }
	}











}
