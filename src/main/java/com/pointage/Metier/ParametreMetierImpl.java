package com.pointage.Metier;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pointage.Dao.ParametreDao;
import com.pointage.Entities.CertiParametrage;

@Transactional
public class ParametreMetierImpl implements ParametreMetier{
	
	@Autowired
	private ParametreDao daoParam;
	

	public void setDaoParam(ParametreDao daoParam) {
		this.daoParam = daoParam;
	}

	@Override
	public void ModifParam(CertiParametrage certiParametrage) {
		daoParam.ModifParam(certiParametrage);
		
	}

	@Override
	public List<CertiParametrage> AllParametre() {
		// TODO Auto-generated method stub
		return daoParam.AllParametre();
	}

}
