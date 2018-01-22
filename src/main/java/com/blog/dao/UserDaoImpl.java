package com.blog.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.blog.entity.User;
import com.blog.enums.Roles;

@Repository
@Transactional
public class UserDaoImpl extends AbstractJpaDao<User, Long> implements UserDao{
	
    @Autowired private EntityManager em;
    @Autowired private BCryptPasswordEncoder encoder;

    @Override
    public User findById(Long id){
        return em.find(User.class, id);
    }

    @Override
    public void add(User user){
		user.setRol(Roles.ROLE_USER.getValue());
    	user.setPassword(encoder.encode(user.getPassword()));
    	user.setCreatedOn(new Date());
    	em.persist(user);
        return;
    }

	@Override
	public User findByUsername(String username){
		try{
			TypedQuery<User> q = em.createNamedQuery(User.FindByUsername,User.class)
									.setParameter("username", username);
			return q.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

}
