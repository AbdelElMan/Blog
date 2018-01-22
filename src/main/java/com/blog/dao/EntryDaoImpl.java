package com.blog.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blog.entity.Entry;

@Repository
@Transactional
public class EntryDaoImpl extends AbstractJpaDao<Entry, Long> implements EntryDao{
	
    @Autowired private EntityManager em;

    @Override
    public Entry findById(Long id){
        return em.find(Entry.class, id);
    }
    
    @Override
    public List<Entry> findAll(){
    	try{
			TypedQuery<Entry> q = em.createNamedQuery(Entry.FindAll,Entry.class);
			
			return q.getResultList();
			
		} catch (NoResultException nre) {		
			return null;
		}
    }
	
    @Override
    public void add(Entry entry){
    	entry.setCreatedOn(new Date());
        em.persist(entry);
        return;
    }

}
