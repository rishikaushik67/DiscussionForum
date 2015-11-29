package com.mum.discussionforum.service;

import com.mum.discussionforum.domain.User;
import com.mum.discussionforum.domain.UserCredentials;

public interface UserService {
	
	public void userSignUp(User user);

	public User userLogin(UserCredentials userCredential);
	
	public User getUser(int id);
}
