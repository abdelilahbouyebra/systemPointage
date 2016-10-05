package com.pointage.Metier;

import java.util.List;

import com.pointage.Entities.CertiEmploye;
import com.pointage.Entities.TbUser;
import com.pointage.Entities.TbUserDept;

public interface EmployeMetier {
	public void AddEmploye(TbUser empl );
	public List<TbUser> AllEmployes();
	public boolean SuppEmploye(Integer idEmploye);
	public void ModifierEmploye(TbUser tbUser);
	public void ModifRegEmpl(CertiEmploye certiEmploye);

}
