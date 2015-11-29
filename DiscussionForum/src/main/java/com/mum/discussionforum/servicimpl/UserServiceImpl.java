package com.mum.discussionforum.servicimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mum.discussionforum.dao.UserDao;
import com.mum.discussionforum.domain.User;
import com.mum.discussionforum.domain.UserCredentials;
import com.mum.discussionforum.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao UserDao;
	
	@Override
	
	public void userSignUp(User user) {
		UserDao.userSignUp(user);
	}

	

	@Override
	public User userLogin(UserCredentials userCredential) {
		return UserDao.userLogin(userCredential);
	}



	@Override
	public User getUser(int id) {
		return UserDao.getUser(id);
	}

}
