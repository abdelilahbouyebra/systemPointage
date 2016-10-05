package com.pointage.Metier;

import java.io.Serializable;
import java.util.List;





import org.springframework.transaction.annotation.Transactional;

import com.pointage.Dao.RegulariseDao;
import com.pointage.Entities.CertiPtgregularise;

@Transactional
public class RegulariseMetierImpl implements RegulariseMetier,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RegulariseDao daoRegu;

	public void setDaoRegu(RegulariseDao daoRegu) {
		this.daoRegu = daoRegu;
	}

	@Override
	public int AddRegu(CertiPtgregularise certiPtgregularise) {
		return daoRegu.AddRegu(certiPtgregularise);
		
	}

	@Override
	public List<CertiPtgregularise> AllReg() {
		// TODO Auto-generated method stub
		return daoRegu.AllReg();
	}

	@Override
	public void SuppReg(Integer idPtgregularise) {
		daoRegu.SuppReg(idPtgregularise);
		
	}

	@Override
	public void ModifierReg(CertiPtgregularise certiPtgregularise) {
		daoRegu.ModifierReg(certiPtgregularise);
		
	}

}
