package com.pointage.Metier;

import java.io.Serializable;



import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pointage.Dao.ReglageEmplDao;
import com.pointage.Entities.CertiEmploye;

@Transactional
public class ReglageEmplMetierImpl implements ReglageEmplMetier,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ReglageEmplDao DaoReg;
	
	public void setDaoReg(ReglageEmplDao daoReg) {
		DaoReg = daoReg;
	}
	
	@Override
	public CertiEmploye AddRegEmpl(CertiEmploye certiEmploye) {
		
		return DaoReg.AddRegEmpl(certiEmploye);
	}

	@Override
	public List<CertiEmploye> AllCerEmployes() {
		return DaoReg.AllCerEmployes();
	}

	@Override
	public void ModifRegEmpl(CertiEmploye certiEmploye) {
		DaoReg.ModifRegEmp(certiEmploye);
		
	}

	@Override
	public boolean SuppEmplAr(Integer idEmployer) {
		boolean m;
		try {
			DaoReg.SuppEmplAr(idEmployer);
			m=true;;
		} catch (Exception e) {
			m=false;
		}
		
		return m;
	}

	

	
	

}
