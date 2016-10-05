package com.pointage.Metier;

import java.util.List;

import com.pointage.Entities.CertiPtgregularise;

public interface RegulariseMetier  {
	public int AddRegu(CertiPtgregularise certiPtgregularise );
	public List<CertiPtgregularise> AllReg();
	public void SuppReg(Integer idPtgregularise);
	public void ModifierReg(CertiPtgregularise certiPtgregularise);

}
