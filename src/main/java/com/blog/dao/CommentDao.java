package com.blog.dao;

import com.blog.entity.Comment;
import com.blog.entity.Entry;

public interface CommentDao extends IGenericDao<Comment, Long> {
	
	public Entry findById(Long id);
	public void add(Comment comment);

}
