package com.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaboration.dao.JobDao;
import com.collaboration.domain.Job;
@Transactional
@Repository(value="jobDao")
public class JobDaoImpl implements JobDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addJob(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(job);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean deleteJob(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(job);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean updateJob(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(job);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public List<Job> listAllJobs() 
	{
		
		return	sessionFactory.getCurrentSession().createQuery("from Job").list();
	
	}

	
	public Job getJob(int jobId) 
	{
		
		return sessionFactory.getCurrentSession().get(Job.class, jobId);
		 
	}
	
	
	
	
	

}
