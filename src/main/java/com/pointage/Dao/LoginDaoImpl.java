package com.pointage.Dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pointage.Entities.Users;

public class LoginDaoImpl implements LoginDao,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;

	public Users FindUser(Users users) {
		Users model = null;
        
		try {
			Query   query = em.createQuery("SELECT u FROM Users u WHERE u.userName = :id and u.actived=1");
			query.setParameter("id", users.getUserName());
			model=(Users) query.getSingleResult();
			if(query.getResultList().size()<0){
			 model=null;
			}

		}  catch (NoResultException e) {
		    System.out.println("----------"+e);
		}
		return model;
	}

	public Users login(Users users) {
		Users model=this.FindUser(users);
	       if(model!=null ){
	           if(!users.getPassword().equals(model.getPassword())){
	               model=null;            
	           }  
	       }
	       return model;
	}

}
