package com.pointage.Dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.FinderException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pointage.Entities.CertiPtgregularise;

public class RegulariseDaoImpl implements RegulariseDao,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;


	@Override
	public List<CertiPtgregularise> AllReg() {
		Query query=em.createQuery("SELECT p FROM CertiPtgregularise p ");
		return query.getResultList();
	}

	@Override
	public void SuppReg(Integer idPtgregularise) {
		CertiPtgregularise certiPtgregularise=em.find(CertiPtgregularise.class, idPtgregularise);
		em.remove(certiPtgregularise);
		
		
	}

	@Override
	public void ModifierReg(CertiPtgregularise certiPtgregularise) {
		em.merge(certiPtgregularise);
		
	}

	@Override
	public int AddRegu(CertiPtgregularise certiPtgregularise) {
       em.persist(certiPtgregularise);
       em.flush();
       return certiPtgregularise.getIdPtgregularise();
	}

	
}
