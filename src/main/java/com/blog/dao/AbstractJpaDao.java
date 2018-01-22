package com.blog.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AbstractJpaDao<T, PK extends Serializable> implements IGenericDao<T, PK>{
   
   @Autowired private EntityManager em;

	@Override
	public void persist(T entity) {
		em.persist(entity);
		em.flush();
	}
	
	@Override
	public T merge(T entity) {
		return em.merge(entity);
	}
	
	@Override
	public void remove(T entity) {
		em.remove(entity);
	}

}