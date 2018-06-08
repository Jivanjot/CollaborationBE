package com.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaboration.dao.ForumDao;
import com.collaboration.domain.Forum;

@Transactional 
@Repository("forumDao")
public class ForumDaoImpl implements ForumDao {

@Autowired
SessionFactory sessionFactory;

public boolean addForum(Forum forum) 
{
	try
	{
	sessionFactory.getCurrentSession().save(forum);
	return true;
	}
	catch(Exception e)
	{
	return false;	
	}
}

public boolean deleteForum(Forum forum) {
	try
	{
	sessionFactory.getCurrentSession().delete(forum);
	return true;
	}
	catch(Exception e)
	{
	return false;	
	}
}

public List<Forum> listApprovedForums() 
{
	
	return sessionFactory.getCurrentSession().createQuery("from Forum where status='A'").list();
	
	
}

public List<Forum> listAllForums() 
{
	return sessionFactory.getCurrentSession().createQuery("from Forum ").list();
}

public Forum getForum(int forumId) 
{
	
	return sessionFactory.getCurrentSession().get(Forum.class,forumId);
	
}

public boolean approveForum(int forumId) 
{
    try
    {
	Forum forum= getForum(forumId);
	  forum.setStatus("A");
     sessionFactory.getCurrentSession().update(forum);
     return true;
    }
    catch(Exception e)
    {
    	return false;
    }
}

    public boolean rejectForum(int forumId) {
		try {
			Forum forum= getForum(forumId);
			  forum.setStatus("NA");
		     sessionFactory.getCurrentSession().update(forum);
		     return true;
			
		}
		catch(Exception e)
		{
			return false;
		}

}

}