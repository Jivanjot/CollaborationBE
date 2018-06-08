package com.collaboration.dao;

import com.collaboration.domain.User;

public interface UserDao {
	

	public boolean registerUser(User user);
	public boolean checkCredential(String loginName,String password);
	public User getUser(String loginName);


}
