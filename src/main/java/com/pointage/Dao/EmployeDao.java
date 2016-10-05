package com.pointage.Dao;

import java.util.List;

import com.pointage.Entities.CertiEmploye;
import com.pointage.Entities.TbUser;
import com.pointage.Entities.TbUserDept;

public interface EmployeDao {
	public void AddEmploye(TbUser empl );
	public List<TbUser> AllEmployes();
	public void SuppEmploye(Integer idEmploye);
	public void ModifierEmploye(TbUser tbUser);
	public void ModifRegEmp(CertiEmploye certiEmploye) ;

}
