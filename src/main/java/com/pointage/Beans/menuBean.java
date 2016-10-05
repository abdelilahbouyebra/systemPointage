package com.pointage.Beans;


import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.pointage.Utils.MyUtil;

@Named(value ="menuBean")
@RequestScoped
public class menuBean implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 6135680651283511593L;

public void lougout() {  
        MyUtil.Urlbase();
    }  
      
    public void update() {  
        addMessage("Data updated");  
    }  
      
    public void delete() {  
        addMessage("Data deleted");  
    }  
      
    public void addMessage(String summary) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
}
