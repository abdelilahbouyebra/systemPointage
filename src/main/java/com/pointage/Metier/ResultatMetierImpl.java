package com.pointage.Metier;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pointage.Dao.ResultatDao;
import com.pointage.Entities.TbEventLog;


@Transactional
public class ResultatMetierImpl implements ResultatMetier {
	
	private ResultatDao  daoResult;

	public void setDaoResult(ResultatDao daoResult) {
		this.daoResult = daoResult;
	}

	@Override
	public List<TbEventLog> AllResult() {
		// TODO Auto-generated method stub
		return daoResult.AllResult();
	}

}
