package com.pointage.Dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pointage.Entities.TbUserDept;
import com.pointage.Entities.Users;

public class DepartementDaoImpl implements DepartementDao,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;

	@Override
	public void AddDept(TbUserDept dept) {
		em.persist(dept);	
		em.flush(); 
	}

	@Override
	public void SuppDept(Integer idEmploye) {
		TbUserDept dept=em.find(TbUserDept.class, idEmploye);
        em.remove(dept);
		
	}

	@Override
	public void ModifierDept(TbUserDept dept) {
		em.merge(dept);
		
	}

	@Override
	@SuppressWarnings({ "unchecked" }) 
	public List<TbUserDept> AllDeparetement() {
		Query query=em.createQuery("SELECT u FROM TbUserDept u ");
		
		return query.getResultList();
	}

}
