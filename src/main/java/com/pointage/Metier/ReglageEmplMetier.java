package com.pointage.Metier;

import java.util.List;

import com.pointage.Entities.CertiEmploye;

public interface ReglageEmplMetier {
	
	public CertiEmploye AddRegEmpl(CertiEmploye certiEmploye);
	public List<CertiEmploye> AllCerEmployes();
	public void ModifRegEmpl(CertiEmploye certiEmploye);
	public boolean SuppEmplAr(Integer idEmployer);

}
