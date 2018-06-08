package com.collaboration;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaboration.dao.UserDao;
import com.collaboration.domain.User;


public class UserTestCase {

	@Autowired
	private static User user;
	@Autowired
	private static UserDao userDao;
	
	
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.collaboration");
		context.refresh();
		userDao=(UserDao)context.getBean("userDao");
		user=(User)context.getBean("user");
	}
	
	@Test
	public void saveUserTest()
	{
		user.setLoginName("jivcv zjan");
		user.setPassword("Avj SD");
		user.setEmail("singh.jv ivan0390");
		user.setName("Jivanjcv ot Singh");
		user.setAddress("Moga");
		user.setMobile("34543985645");
		user.setRole("User");
	boolean a=	userDao.registerUser(user);
		assertEquals(true,a);
		
	}

   
}

