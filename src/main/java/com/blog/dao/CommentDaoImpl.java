package com.blog.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blog.entity.Comment;
import com.blog.entity.Entry;

@Repository
@Transactional
public class CommentDaoImpl extends AbstractJpaDao<Comment, Long> implements CommentDao{
	
    @Autowired private EntityManager em;

    @Override
    public Entry findById(Long id){
        return em.find(Entry.class, id);
    }

    @Override
    public void add(Comment comment){
    	comment.setCreatedOn(new Date());
        em.merge(comment);
        return;
    }

}
