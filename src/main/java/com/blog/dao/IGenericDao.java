package com.blog.dao;

import java.io.Serializable;

public interface IGenericDao<T, PK extends Serializable>{
	 
   public void persist(final T entity);
   public T merge(final T entity);
   public void remove(final T entity);
	   
}