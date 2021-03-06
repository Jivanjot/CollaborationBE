package com.collaboration.daoimpl;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaboration.dao.BlogDao;
import com.collaboration.domain.Blog;
@Transactional
@Repository("blogDao")
public class BlogDaoImpl implements BlogDao {
	@Autowired
	SessionFactory sessionFactory;

	Random rand=new Random();
	public boolean addBlog(Blog blog) {
		try {
			blog.setBlogId(rand.nextInt(100)+1);
			blog.setCreateDate(new java.util.Date());
			blog.setLikes(0);
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteBlog(int blogId) {
		try {
			Blog blog = (Blog) sessionFactory.getCurrentSession().get(Blog.class, blogId);
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	public List<Blog> listApprovedBlogs() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Blog where status='A'").list();

		} catch (Exception e) {
			return null;
		}
	}

	public boolean approveBlog(int blogId) {
		try {
			Blog blog=this.getBlog(blogId);
			blog.setStatus("A"); // Specifying the status of the Blog as A which means Approved
			sessionFactory.getCurrentSession().update(blog); // updating the blog
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean rejectBlog(int blogId) {
		try {
			Blog blog=this.getBlog(blogId);
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog); // updating blog
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Blog getBlog(int blogId) {
		try {

			return sessionFactory.getCurrentSession().get(Blog.class, blogId);

		} catch (Exception e) {
			return null;
		}
	}

	public List<Blog> listAllBlogs() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Blog").list();

		} catch (Exception e) {
			return null;
		}
	}

	public boolean incrementLike(int blogId) {
		try {
      Blog      blog=  this.getBlog(blogId);
		int likes=blog.getLikes();	
          likes++;
			blog.setLikes(likes);
			sessionFactory.getCurrentSession().update(blog); // updating the blog
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}