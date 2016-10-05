package com.pointage.Dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.pointage.Entities.CertiEmploye;

public class ReglageEmplDaoImpl implements ReglageEmplDao,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;

	@Override
	public CertiEmploye AddRegEmpl(CertiEmploye certiEmploye) {
		em.persist(certiEmploye);
		em.flush();
		em.close(); 
		System.out.println("같같같같같같같같같같같같같같같"+certiEmploye.getIdEmploye());
		return certiEmploye;
	}

	@Override
	public List<CertiEmploye> AllCerEmployes() {
		Query query=em.createQuery("SELECT e FROM CertiEmploye e ");
		return query.getResultList();
	}

	@Override
	public void ModifRegEmp(CertiEmploye certiEmploye) {
		em.merge(certiEmploye);
		
	}

	@Override
	public void SuppEmplAr(Integer idEmployer) {
		CertiEmploye  certiEmploye=em.find(CertiEmploye.class, idEmployer);
		em.remove(certiEmploye);	
	}

}
