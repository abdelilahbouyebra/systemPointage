package com.pointage.Metier;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pointage.Dao.DepartementDao;
import com.pointage.Entities.TbUserDept;

@Transactional
public class DepartementMetierImpl implements DepartementMetier,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private DepartementDao daoDept;
    private List<TbUserDept> selectItems;
	
	public void setDaoDept(DepartementDao daoDept) {
		this.daoDept = daoDept;
	}

	@Override
	public List<TbUserDept> AllDeparetement() {
		// TODO Auto-generated method stub
		return daoDept.AllDeparetement();
	}

	@Override
	public void AddDept(TbUserDept dept) {
		daoDept.AddDept(dept);
		
	}

	@Override
	public boolean SuppDept(Integer idEmploye) {
		boolean m;
		try {
			daoDept.SuppDept(idEmploye);;
			m=true;;
		} catch (Exception e) {
			m=false;
		}
		
		return m;
		
	}

	@Override
	public void ModifierDept(TbUserDept dept) {
		daoDept.ModifierDept(dept);
		
	}

	
	

}
