package com.pointage.Utils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

public class Listen implements PhaseListener,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void afterPhase(PhaseEvent event) {
		  FacesContext facecontext=event.getFacesContext();
	        String currentPage=facecontext.getViewRoot().getViewId();
	        boolean  isLoginPage=(currentPage.lastIndexOf("login.xhtml")>-1) ? true:false;
	        HttpSession session=(HttpSession) facecontext.getExternalContext().getSession(true);
	        Object users=session.getAttribute("users");
	        if(!isLoginPage && users==null ){
	            NavigationHandler nh=facecontext.getApplication().getNavigationHandler();
	            nh.handleNavigation(facecontext, null, "/login.xhtml");
	        }
		
	}

	public void beforePhase(PhaseEvent e) {
		if (e.getPhaseId() == PhaseId.APPLY_REQUEST_VALUES) {
            ServletRequest request = (ServletRequest) e.getFacesContext().getExternalContext().getRequest();
            try {
                request.setCharacterEncoding("UTF-8");
            } catch (UnsupportedEncodingException uee) {
                System.out.println(uee);
            }
        }
		
	}

	public PhaseId getPhaseId() {
		 return PhaseId.RESTORE_VIEW;
	}

}
