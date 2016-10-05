package com.pointage.Metier;

import java.util.List;

import com.pointage.Entities.TbUserDept;

public interface DepartementMetier {

	public void AddDept(TbUserDept dept);
	public boolean SuppDept(Integer idEmploye);
	public void ModifierDept(TbUserDept dept);
	public List<TbUserDept> AllDeparetement();
}
