package com.pointage.Dao;

import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pointage.Entities.TbEventLog;
import com.pointage.Entities.TbUser;

public class ResultatDaoImpl implements  ResultatDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<TbEventLog> AllResult() {
		Query query=em.createQuery("SELECT r FROM TbEventLog r");
		
		List<TbEventLog> listevents= query.setMaxResults(100).getResultList();
		for (TbEventLog tbEventLog : listevents) {
			Query query11=em.createQuery("SELECT u FROM TbUser u where u.suserId="+tbEventLog.getTbUser().getNuserIdn());
			tbEventLog.setTbUser((TbUser) query11.getSingleResult());
			Date date = new Date(tbEventLog.getId().getNdateTime()*1000);
			SimpleDateFormat format = new SimpleDateFormat("MM-dd-yy");
		    try {
				date=format.parse(format.format(date));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long times=new java.sql.Timestamp(date.getTime()).getTime();
		    Calendar c = Calendar.getInstance(); 
		    c.setTime(date); 
		    c.add(Calendar.DATE, 1);
		    Date date2 = c.getTime();
			SimpleDateFormat format3 = new SimpleDateFormat("MM-dd-yy");
		    try {
				date2=format3.parse(format3.format(date2));

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long times2=new java.sql.Timestamp(date2.getTime()).getTime();
			//////////////////////////////
			Query query1=em.createQuery("SELECT u FROM TbEventLog u where u.id.ndateTime<"+times2+" and u.id.ndateTime>="+times);
			//tbEventLog.setTbUser((TbUser) query1.getSingleResult());
			String hours="";
			@SuppressWarnings("unchecked")
			List<TbEventLog> listevents2=query1.getResultList();
			for (TbEventLog tbEventLog2 : listevents2) {
				Date date3 = new Date(tbEventLog2.getId().getNdateTime()*1000);
			    Format format2 = new SimpleDateFormat("HH:mm");
				hours=hours+" - "+format2.format(date3);
			}
			tbEventLog.setHours(hours);
			}

		return listevents;
	}

}
