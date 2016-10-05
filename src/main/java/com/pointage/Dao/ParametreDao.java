package com.pointage.Dao;

import java.util.List;

import com.pointage.Entities.CertiParametrage;

public interface ParametreDao {
	
	public void ModifParam(CertiParametrage certiParametrage);
	public List<CertiParametrage> AllParametre();

}
