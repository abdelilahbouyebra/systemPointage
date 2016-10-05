package com.pointage.Dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pointage.Entities.CertiParametrage;

public class ParametreDaoImpl implements ParametreDao,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;

	@Override
	public void ModifParam(CertiParametrage certiParametrage) {
		em.merge(certiParametrage);
		
	}

	@Override
	public List<CertiParametrage> AllParametre() {
		// TODO Auto-generated method stub
      Query query=em.createQuery("FROM CertiParametrage");
		
		return query.getResultList();
	}

	public byte[] loadImage(int id){
	        return em.find(CertiParametrage.class, id).getLogo();
	    }
}
