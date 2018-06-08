package com.collaboration.dao;

import java.util.List;

import com.collaboration.domain.BlogComment;

public interface BlogCommentDao {
	
	public boolean addBlogComment(BlogCommentDao blogComment);
	public boolean deleteBlogComment(BlogCommentDao blogComment);
	public BlogComment getBlogComment(int commentId);
	public List<BlogComment> listBlogComments(int blogid);

}
