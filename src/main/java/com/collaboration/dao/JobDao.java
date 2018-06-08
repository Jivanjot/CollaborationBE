package com.collaboration.dao;

import java.util.List;

import com.collaboration.domain.Job;

public interface JobDao {
	
	public boolean addJob(Job job);
	public boolean deleteJob(Job job);
	public boolean updateJob(Job job);
	public List<Job> listAllJobs();
	public Job getJob(int jobId);

}
