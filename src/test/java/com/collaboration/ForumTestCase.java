package com.collaboration;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaboration.dao.ForumDao;
import com.collaboration.domain.Forum;

public class ForumTestCase {

	@Autowired
	private static ForumDao forumDao;
	@Autowired
	private static Forum forum;
	
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.collaboration");
		context.refresh();
		forumDao=(ForumDao)context.getBean("forumDao");
		forum=(Forum)context.getBean("forum");
	}
	
	@Test
	public void getAllForums()
	{
	List<Forum> forums=forumDao.listAllForums();
	 assertNotNull(forums);
	
	}
}
