package com.collaboration.dao;

import java.util.List;

import com.collaboration.domain.Blog;

public interface BlogDao {

	public boolean addBlog(Blog blog);
	public boolean deleteBlog(int blogId);
	public boolean updateBlog(Blog blog);
	
	public List<Blog> listApprovedBlogs();
	public boolean approveBlog(Blog blog);
	public boolean rejectBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> listAllBlogs();
	public boolean incrementLike(Blog blog);
	
}
