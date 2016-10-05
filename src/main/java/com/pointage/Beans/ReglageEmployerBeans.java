package com.pointage.Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;

import com.pointage.Entities.CertiEmploye;
import com.pointage.Entities.TbUser;
import com.pointage.Entities.TbUserDept;
import com.pointage.Metier.ReglageEmplMetier;

@ManagedBean(name="reglageEmployerBeans")
@SessionScoped
public class ReglageEmployerBeans implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ReglageEmplMetier metier4;
	private CertiEmploye regEmplSelected  ;
	private List<CertiEmploye> list;

	@PostConstruct
	public void Init() {	
		regEmplSelected=new CertiEmploye();
		this.list=new ArrayList<CertiEmploye>();			
	}

	public void setMetier4(ReglageEmplMetier metier4) {
		this.metier4 = metier4;
	}

	public CertiEmploye getRegEmplSelected() {
		return regEmplSelected;
	}

	public void setRegEmplSelected(CertiEmploye regEmplSelected) {
		this.regEmplSelected = regEmplSelected;
	}
	
	public List<CertiEmploye> getList() {
		return metier4.AllCerEmployes();
	}

	public void AjouterReglEmpl(ActionEvent actionEvent) {
		String msg;
		String nom=regEmplSelected.getNomAr();
		if (nom.equals("")) {
			msg = "le champ Nom est oblégatoire??";
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_WARN, msg, null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		} else {
			try {
				metier4.AddRegEmpl(regEmplSelected);
				msg = "L'ajout avec succée";
				FacesMessage facesMessage = new FacesMessage(
						FacesMessage.SEVERITY_INFO, msg, null);
				FacesContext.getCurrentInstance()
						.addMessage(null, facesMessage);

			} catch (Exception e) {
				msg =nom+" déja Ajouter";
				FacesMessage facesMessage = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, msg, null);
				FacesContext.getCurrentInstance()
						.addMessage(null, facesMessage);

			}

		}

	}
	public void ModifierReg(ActionEvent actionEvent) {
        String msg2;
        
        try {
        	metier4.ModifRegEmpl(regEmplSelected);
        	this.Init();
            msg2 = "Modification avec succée";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, msg2, null);
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			
		} catch (Exception e) {
			 msg2 = "Modification echoé";
	            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg2, null);
	            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
       
    }
	public void SuppEmplAr(ActionEvent actionEvent) {

		String msg1;
		if (metier4.SuppEmplAr(this.regEmplSelected.getIdEmploye())){
			msg1 = "La supprission avec succée";
			this.Init();
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_INFO, msg1, null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		} else {
			msg1 = "La supprission echoé";
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, msg1, null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}

	}

	
	
	

}
