package com.pointage.Dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pointage.Entities.CertiEmploye;
import com.pointage.Entities.TbUser;
import com.pointage.Entities.TbUserDept;

public class EmployeDaoImpl implements EmployeDao,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	@Override
	public void AddEmploye(TbUser empl) {
		em.persist(empl);
		
	}
	@Override
	public List<TbUser> AllEmployes() {
		Query query=em.createQuery("FROM TbUser u");//FROM TbUser u"+" LEFT JOIN FETCH u.CertiEmploye
		return query.getResultList();
	}
	@Override
	public void SuppEmploye(Integer idEmploye) {
		TbUser tbUser=em.find(TbUser.class, idEmploye);
		em.remove(tbUser);
		
	}
	@Override
	public void ModifierEmploye(TbUser tbUser) {
		em.merge(tbUser);
		
	}

	@Override
	public void ModifRegEmp(CertiEmploye certiEmploye) {
		em.merge(certiEmploye);
		
	}

}
