package com.collaboration.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaboration.dao.UserDao;
import com.collaboration.domain.User;

@Transactional
@Repository(value = "userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private User user;
	public boolean registerUser(User user) {
		
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			return false;
		}
		
	}
	public boolean checkCredential(String loginName,String password) {
		try {
			
			sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("loginName",loginName)).add(Restrictions.eq("password", password)).uniqueResult();
		    return true;
		} catch (HibernateException e) {
			return false;
		}
		
	}
	public User getUser(String loginName) {
	return	sessionFactory.getCurrentSession().get(User.class,loginName);
		
		
	}
	
	
	

}
