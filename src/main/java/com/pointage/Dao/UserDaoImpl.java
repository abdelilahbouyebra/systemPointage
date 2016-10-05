package com.pointage.Dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pointage.Entities.Users;

public class UserDaoImpl implements UserDao,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Users> AllUsers() {
		Query query = em
				.createQuery("from Users");
		return  query.getResultList();
	}
	
	@Override
	public void SuppUser(Integer id) {
		
		Users user=em.find(Users.class, id);
        em.remove(user);
	}

	@Override
	public void AddUser(Users user) {
		// TODO Auto-generated method stub
		 em.persist(user);
	}

	@Override
	public void ModifierUser(Users user) {
		em.merge(user);
		
	}

}
