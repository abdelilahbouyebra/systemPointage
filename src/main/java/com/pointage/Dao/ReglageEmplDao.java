package com.pointage.Dao;

import java.util.List;

import com.pointage.Entities.CertiEmploye;
import com.pointage.Entities.TbUser;

public interface ReglageEmplDao {
	public CertiEmploye AddRegEmpl(CertiEmploye certiEmploye);
	public List<CertiEmploye> AllCerEmployes();
	public void ModifRegEmp(CertiEmploye certiEmploye);
	public void SuppEmplAr(Integer idEmployer);
	

}
