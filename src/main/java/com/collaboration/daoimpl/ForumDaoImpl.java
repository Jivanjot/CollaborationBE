package com.collaboration.daoimpl;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaboration.dao.ForumDao;
import com.collaboration.domain.Forum;

@Transactional
@Repository("forumDao")
public class ForumDaoImpl implements ForumDao {

	@Autowired
	SessionFactory sessionFactory;
	Random rand=new Random();

	public boolean addForum(Forum forum) {
		try {
			forum.setForumId(rand.nextInt(50)+1);
			forum.setCreateDate(new java.util.Date());
			forum.setLikes(0);
		
			forum.setStatus("NA");
			sessionFactory.getCurrentSession().save(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Forum> listApprovedForums() {

		return sessionFactory.getCurrentSession().createQuery("from Forum where status='A'").list();

	}

	public List<Forum> listAllForums() {
		return sessionFactory.getCurrentSession().createQuery("from Forum").list();
	}

	public Forum getForum(int forumId) {

		return sessionFactory.getCurrentSession().get(Forum.class, forumId);

	}

	public boolean approveForum(int forumId) {
		try {
			Forum forum = getForum(forumId);
			forum.setStatus("A");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean rejectForum(int forumId) {
		try {
			Forum forum = getForum(forumId);
			forum.setStatus("NA");
			sessionFactory.getCurrentSession().update(forum);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public boolean incLikes(int forumId) {
		try {
			Forum forum = this.getForum(forumId);
			int likes = forum.getLikes();
			likes++;
			forum.setLikes(likes);
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}