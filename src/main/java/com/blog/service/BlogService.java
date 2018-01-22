package com.blog.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.dao.CommentDao;
import com.blog.dao.EntryDao;
import com.blog.dao.UserDao;
import com.blog.entity.Comment;
import com.blog.entity.Entry;
import com.blog.entity.User;
import com.blog.exception.BlogException;

@Service
@Transactional
public class BlogService {

	protected static Logger log = Logger.getLogger(BlogService.class);
	
    @Autowired private UserDao userDao;
    @Autowired private EntryDao entryDao;
    @Autowired private CommentDao commentDao;

	public void addUser(User user) throws BlogException {

		if(userDao.findByUsername(user.getUsername()) != null)
			throw new BlogException("El usuario ya existe");
		
		userDao.add(user);
	}

	public void addEntry(Entry entry, User user) throws BlogException {
		entry.setUser(user);
		entryDao.add(entry);
	}

	public Entry getEntry(Long id) throws BlogException {
		
		Entry entry = entryDao.findById(id);
		Hibernate.initialize(entry.getTags());
		Hibernate.initialize(entry.getComments());
		return entry;
	}

	public List<Entry> getAllEntries() {

		List<Entry> entries = entryDao.findAll();
		Hibernate.initialize(entries);
		for(Entry entry : entries) {
			Hibernate.initialize(entry.getTags());
		}
		return entries;
	}
	
	public void addComment(Comment comment, User user, Entry entry) throws BlogException {
		comment.setUser(user);
		comment.setEntry(entry);

		commentDao.add(comment);
	}

	
}