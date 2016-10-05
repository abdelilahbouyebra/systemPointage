package com.pointage.Dao;

import java.util.List;

import com.pointage.Entities.CertiPtgregularise;

public interface RegulariseDao {
	public int AddRegu(CertiPtgregularise certiPtgregularise );
	public List<CertiPtgregularise> AllReg();
	public void SuppReg(Integer idPtgregularise);
	public void ModifierReg(CertiPtgregularise certiPtgregularise);

}
