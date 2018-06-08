package com.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaboration.dao.BlogCommentDao;
import com.collaboration.domain.BlogComment;
@Transactional
@Repository(value="blogCommentDao")
public class BlogCommentDaoImpl implements BlogCommentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public BlogComment getBlogComment(int commentId) 
	{
		try
		{
			
			return	sessionFactory.getCurrentSession().get(BlogComment.class,commentId);
			 
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public List<BlogComment> listBlogComments(int blogid) 
	{
	
return	sessionFactory.getCurrentSession().createQuery("from BlogComment where blogId='"+blogid+"'").list();
		
		
	}

	public boolean addBlogComment(BlogCommentDao blogComment) {
		try
		{
			sessionFactory.getCurrentSession().save(blogComment);
			return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

	public boolean deleteBlogComment(BlogCommentDao blogComment) {
		try
		{
			sessionFactory.getCurrentSession().delete(blogComment);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	
	
	
}
