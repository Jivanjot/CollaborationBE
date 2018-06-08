package com.collaboration.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaboration.dao.ProfilePictureDao;
import com.collaboration.domain.ProfilePicture;
@Transactional
@Repository(value="profilePictureDao")
public class ProfilePictureDaoImpl implements ProfilePictureDao{

	@Autowired
	SessionFactory sessionFactory;

	public void save(ProfilePicture profilePicture) {
		sessionFactory.getCurrentSession().saveOrUpdate(profilePicture);
	
		
	}

	public ProfilePicture getProfilePicture(String loginName) {
		
	return sessionFactory.getCurrentSession().get(ProfilePicture.class,loginName);
		
	}
	
	
	
}
