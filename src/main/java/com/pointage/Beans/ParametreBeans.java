package com.pointage.Beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.Part;

import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;

import com.pointage.Entities.CertiParametrage;
import com.pointage.Metier.ParametreMetier;

@ManagedBean(name="parametreBeans")
@ViewScoped
public class ParametreBeans implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CertiParametrage parametrageSelected;
	@Autowired
	private ParametreMetier metier6;
	private List<CertiParametrage> list;
	private UploadedFile uploadedFile;
	
	@PostConstruct
	public void Init() {	
		this.list = new ArrayList<CertiParametrage>();
		parametrageSelected=new CertiParametrage();	
	}
	
	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public CertiParametrage getParametrageSelected() {
		return parametrageSelected;
	}
	public void setParametrageSelected(CertiParametrage parametrageSelected) {
		this.parametrageSelected = parametrageSelected;
	}
	public void setMetier6(ParametreMetier metier6) {
		this.metier6 = metier6;
	}
	public List<CertiParametrage> getList() {
		return metier6.AllParametre();
	}
	
	
	public void ModifierParam(ActionEvent actionEvent) throws IOException{
        String msg2;
        
        try {
        	metier6.ModifParam(this.parametrageSelected);;
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

}
