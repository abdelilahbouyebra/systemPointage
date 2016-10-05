package com.pointage.Beans;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.beans.factory.annotation.Autowired;

import com.pointage.Entities.CertiEmploye;
import com.pointage.Entities.TbEventLog;
import com.pointage.Entities.TbTaResult;
import com.pointage.Metier.ResultatMetier;
import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;

@ManagedBean(name="resultBeans")
public class ResultBeans {
	
	@Autowired
	private ResultatMetier metier5;
	private List<TbEventLog> list;
	private TbEventLog resSelected;
	private java.util.Date ndateTime;
	@PostConstruct
	public void Init() {	
		resSelected=new TbEventLog();
		this.list=new ArrayList<TbEventLog>();			
	}
	public java.util.Date getNdateTime() {
		return ndateTime;
	}


	public void setNdateTime(java.util.Date ndateTime) {
		this.ndateTime = ndateTime;
	}


	public List<TbEventLog> getList() {
		return metier5.AllResult();
	}
	public void setMetier5(ResultatMetier metier5) {
		this.metier5 = metier5;
	}
	public TbEventLog getResSelected() {
		return resSelected;
	}
	public void setResSelected(TbEventLog resSelected) {
		resSelected = resSelected;
	}

	
	public String convertTime(long time){
	    Date date = new Date(time*1000);
	    Format format = new SimpleDateFormat("EEEE MM-yyyy");
	    return format.format(date);
	}
	public String convertTimeH(long time){
	    Date date = new Date(time*1000);
	    Format format = new SimpleDateFormat("EEEE - MM/yyyy - HH:mm");
	    return format.format(date);
	}
	
	
	
	
	

}
