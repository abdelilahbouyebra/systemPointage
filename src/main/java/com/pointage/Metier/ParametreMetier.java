package com.pointage.Metier;

import java.util.List;

import com.pointage.Entities.CertiParametrage;

public interface ParametreMetier {
	public void ModifParam(CertiParametrage certiParametrage);
	public List<CertiParametrage> AllParametre();

}
