package com.pointage.Beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.pointage.Entities.Users;
import com.pointage.Metier.LoginMetier;
import com.pointage.Metier.LoginMetierImpl;
import com.pointage.Utils.MyUtil;


@ManagedBean(name="loginBeans")
@SessionScoped
public class LoginBeans implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Users users;
	@Autowired
	private  LoginMetier metierLogin;
	
	@PostConstruct
	public void Init() {
	 this.users= new Users();

	}
	
	public void setMetierLogin(LoginMetier metierLogin) {
		this.metierLogin = metierLogin;
	}
    
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	public void login(ActionEvent actionEvent) {  
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean loggedIn;
        this.users=this.metierLogin.login(this.users);
        String redire="";
        if (this.users!=null) {
            loggedIn = true;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("users", this.users.getUserName());
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenu", this.users.getUserName());
            redire=MyUtil.UrlPat()+"views/templateClient.xhtml";
        } else {
            loggedIn = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Login ou le mot de passe est incorrect");
             this.Init();
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
        context.addCallbackParam("redire", redire); 
    }  
	
	 public String LogOut(ActionEvent actionEvent){
	        String redire=MyUtil.UrlPat()+"login.xhtml";
	        RequestContext Context= RequestContext.getCurrentInstance();
	        FacesContext facesContext=FacesContext.getCurrentInstance();
	        HttpSession session=(HttpSession) facesContext.getExternalContext().getSession(false);
	        session.invalidate();
	        Context.addCallbackParam("LoggeOut", true);
	        Context.addCallbackParam("redire", redire);
	        return redire;
	        
	        
	    }
	 
	
	

}
