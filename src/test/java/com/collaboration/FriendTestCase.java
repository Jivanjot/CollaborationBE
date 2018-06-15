package com.collaboration;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.Table;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaboration.dao.FriendDao;
import com.collaboration.dao.UserDao;
import com.collaboration.domain.Friend;
import com.collaboration.domain.User;

public class FriendTestCase {

	
private static AnnotationConfigApplicationContext context;
@Autowired
private static FriendDao friendDao;
@Autowired
private static Friend friend;

	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.collaboration");
		context.refresh();
		friendDao=(FriendDao)context.getBean("friendDao");
		friend=(Friend)context.getBean("friend");
	}
	
	@Test
	public void showFriendList() {
		List<Friend> friends=friendDao.showFriendList("jivan");
		assertNotNull(friends);
		
	}
	
}
