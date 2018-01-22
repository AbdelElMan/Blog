package com.blog.dao;

import java.util.List;

import com.blog.entity.Entry;

public interface EntryDao extends IGenericDao<Entry, Long> {
	
	public Entry findById(Long id);
	public List<Entry> findAll();
	public void add(Entry entry);

}
