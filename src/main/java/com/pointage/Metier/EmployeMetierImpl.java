package com.pointage.Metier;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pointage.Dao.EmployeDao;
import com.pointage.Entities.CertiEmploye;
import com.pointage.Entities.TbUser;

@Transactional
public class EmployeMetierImpl implements EmployeMetier,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EmployeDao daoEmp;

	public void setDaoEmp(EmployeDao daoEmp) {
		this.daoEmp = daoEmp;
	}

	@Override
	public void AddEmploye(TbUser empl) {
		daoEmp.AddEmploye(empl);
	}

	@Override
	public boolean SuppEmploye(Integer idEmploye) {
		boolean m;
		try {
			daoEmp.SuppEmploye(idEmploye);
			m=true;;
		} catch (Exception e) {
			m=false;
		}
		
		return m;
		
	}

	@Override
	public void ModifierEmploye(TbUser tbUser) {
		daoEmp.ModifierEmploye(tbUser);
		
	}

	@Override
	public List<TbUser> AllEmployes() {
		return daoEmp.AllEmployes();
	}

	@Override
	public void ModifRegEmpl(CertiEmploye certiEmploye) {
		daoEmp.ModifRegEmp(certiEmploye);
		
	}

	
}
