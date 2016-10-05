package com.pointage.Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;

import com.pointage.Entities.CertiEmploye;
import com.pointage.Entities.CertiPtgregularise;
import com.pointage.Entities.TbUser;
import com.pointage.Metier.RegulariseMetier;

@ManagedBean(name="regulariseBeans")
@SessionScoped
public class RegulariseBeans implements Serializable {

	private static final long serialVersionUID = 1L;

	private RegulariseMetier metier7;
	private CertiPtgregularise certiPtgregulariseSelected;
	private List<CertiPtgregularise> list;
	
	@PostConstruct
	public void Init() {	
        certiPtgregulariseSelected=new CertiPtgregularise();
		this.list=new ArrayList<CertiPtgregularise>();
			
	}
	
	public void setMetier7(RegulariseMetier metier7) {
		this.metier7 = metier7;
	}


	public CertiPtgregularise getCertiPtgregulariseSelected() {
		return certiPtgregulariseSelected;
	}


	public void setCertiPtgregulariseSelected(
			CertiPtgregularise certiPtgregulariseSelected) {
		this.certiPtgregulariseSelected = certiPtgregulariseSelected;
	}


	public List<CertiPtgregularise> getList() {
		return metier7.AllReg();
	}
	
	public void AjouterReglEmpl(ActionEvent actionEvent) {
		String msg;
			try {
				metier7.AddRegu(this.certiPtgregulariseSelected);
				msg = "L'ajout avec succée";
				FacesMessage facesMessage = new FacesMessage(
						FacesMessage.SEVERITY_INFO, msg, null);
				FacesContext.getCurrentInstance()
						.addMessage(null, facesMessage);

			} catch (Exception e) {
				msg =" déja Ajouter";
				FacesMessage facesMessage = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, msg, null);
				FacesContext.getCurrentInstance()
						.addMessage(null, facesMessage);

			}

	}
	

}
