package com.blog.dao;
import com.blog.entity.User;

public interface UserDao extends IGenericDao<User, Long> {
	
	public User findById(Long id);
	public User findByUsername(String username);
	public void add(User usuario);

}
