package com.mum.discussionforum.dao;

import com.mum.discussionforum.domain.User;
import com.mum.discussionforum.domain.UserCredentials;

public interface UserDao {

	public void userSignUp(User user);
	public User userLogin(UserCredentials userCredential);
	public User getUser(int id);
}
