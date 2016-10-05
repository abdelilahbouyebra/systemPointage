package com.pointage.Dao;

import java.util.List;

import com.pointage.Entities.TbUserDept;

public interface DepartementDao {
	public void AddDept(TbUserDept dept);
	public void SuppDept(Integer idEmploye);
	public void ModifierDept(TbUserDept dept);
	public List<TbUserDept> AllDeparetement();

}
