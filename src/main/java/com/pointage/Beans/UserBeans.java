package com.pointage.Beans;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.pointage.Entities.Users;
import com.pointage.Metier.UserMetier;

@Named(value = "userBeans")
@RequestScoped
public class UserBeans implements Serializable {

	private static final long serialVersionUID = 1L;

	private Users usersSelected;
	private List<Users> list;

	@Autowired
	private UserMetier metier;
	
	
	public UserBeans() {
		 
	}

	@PostConstruct
	public void Init() {	
		this.list = new ArrayList<Users>();
		usersSelected=new Users();		
	}

	public void setMetier(UserMetier metier) {
		this.metier = metier;
	}

	public Users getUsersSelected() {
		return usersSelected;
	}

	public void setUsersSelected(Users usersSelected) {
		this.usersSelected = usersSelected;
	}

	public List<Users> getList() {
		return metier.AllUsers();
	}

	public void PDF(ActionEvent actionEvent) throws JRException, IOException{
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/report/listUser.jasper"));		
		byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRBeanCollectionDataSource(this.getList()));
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream outStream = response.getOutputStream();
		outStream.write(bytes, 0 , bytes.length);
		outStream.flush();
		outStream.close();
			
		FacesContext.getCurrentInstance().responseComplete();
	}
	public void SuppUser(ActionEvent actionEvent) {

		String msg1;
		if (metier.SuppUser(this.usersSelected.getUserId())) {
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

	public void AjouterUser(ActionEvent actionEvent) {
		String msg;
		String nom = usersSelected.getUserName();
		String password = usersSelected.getPassword();
		if (nom.equals("") || password.equals("")) {
			msg = "les champs vide sont oblégatoire??";
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_WARN, msg, null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		} else {

			try {
				metier.AddUser(this.usersSelected);
				this.Init();
				msg = "L'ajout avec succée";
				FacesMessage facesMessage = new FacesMessage(
						FacesMessage.SEVERITY_INFO, msg, null);
				FacesContext.getCurrentInstance()
						.addMessage(null, facesMessage);

			} catch (Exception e) {
				msg = "L'ajout echoé";
				FacesMessage facesMessage = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, msg, null);
				FacesContext.getCurrentInstance()
						.addMessage(null, facesMessage);
			}

		}

	}
	 public void ModifierUser(ActionEvent actionEvent) {
	        String msg2;
	        
	        try {
	        	metier.ModiefierUser(this.usersSelected);
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
