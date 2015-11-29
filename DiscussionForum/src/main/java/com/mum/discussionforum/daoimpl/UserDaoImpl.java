package com.mum.discussionforum.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mum.discussionforum.dao.UserDao;
import com.mum.discussionforum.domain.User;
import com.mum.discussionforum.domain.UserCredentials;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public void userSignUp(User user) {
		System.out.println("DAO"+user.getFirstName());
		sessionFactory.getCurrentSession().persist(user);
	}

	@Override
	public User userLogin(UserCredentials userCredential) {
		// TODO Auto-generated method stub
		User user= (User) sessionFactory.getCurrentSession().createQuery("from User u where u.userCredentials.userName='"+userCredential.getUserName()+"'"
				+ " and u.userCredentials.password='"+userCredential.getPassword()+"'").uniqueResult();
		return user;
	}

	@Override
	public User getUser(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class,id);
	}

}
