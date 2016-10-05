package com.pointage.Beans;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.pointage.Entities.CertiEmploye;
import com.pointage.Entities.TbUser;
import com.pointage.Entities.TbUserDept;
import com.pointage.Entities.Users;
import com.pointage.Metier.EmployeMetier;
import com.pointage.Metier.ReglageEmplMetier;

@ManagedBean(name="emplBeans")
@RequestScoped
public class EmplBeans implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<TbUser> list;
	private TbUser emplSelected;
	private List<SelectItem> selectItemOnItemsUser;
	@Autowired
	private EmployeMetier metier2;
	
	@Autowired
	private ReglageEmplMetier metier4;
	private CertiEmploye regEmplSelected  ;
	private CertiEmploye certiEmploye1;
	
	private Boolean disabled = true;
	private java.util.Date nstartDate;
	private java.util.Date nendDate;
	
	@PostConstruct
	public void Init() {	
		this.list = new ArrayList<TbUser>();
		emplSelected=new TbUser();	

		emplSelected.setTbUserDept(new TbUserDept());
		this.certiEmploye1=new CertiEmploye();
		emplSelected.setCertiEmploye(new CertiEmploye());
	}
	public Date intToDate(int dat){
        Date date = new Date(dat);
        return date;
	}

	public java.util.Date getNstartDate() {
		return nstartDate;
	}

	public void setNstartDate(java.util.Date nstartDate) {
		this.nstartDate = nstartDate;
	}

	public java.util.Date getNendDate() {
		return nendDate;
	}

	public void setNendDate(java.util.Date nendDate) {
		this.nendDate = nendDate;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	public void onRowSelect(SelectEvent event) {
	    disabled = false;
	}

	public CertiEmploye getCertiEmploye1() {
		return certiEmploye1;
	}

	public void setCertiEmploye1(CertiEmploye certiEmploye1) {
		this.certiEmploye1 = certiEmploye1;
	}
	private List<CertiEmploye> listRg;


	public void  IntToDate(int number) throws ParseException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date date = df.parse(String.valueOf(number));

		System.out.println("======================================"+date);
	}
	
	
	public void hand(){
		   emplSelected=new TbUser(); // Type of element of list
		   certiEmploye1=new CertiEmploye();
		}

	public List<SelectItem> getSelectItemOnItemsUser() {
		this.selectItemOnItemsUser=new ArrayList<SelectItem>();
		List<TbUser> lisUsers= metier2.AllEmployes();
		for (TbUser tbUser : lisUsers) {
			SelectItem selectItem=new SelectItem(tbUser.getNuserIdn(),tbUser.getSuserName());
			this.selectItemOnItemsUser.add(selectItem);
		}
		
		return selectItemOnItemsUser;
	}

	public void setMetier2(EmployeMetier metier2) {
		this.metier2 = metier2;
	}

	public List<TbUser> getList() {
		return metier2.AllEmployes();
	}

	public void setList(List<TbUser> list) {
		this.list = list;
	}

	public CertiEmploye getRegEmplSelected() {
		return regEmplSelected;
	}

	public void setRegEmplSelected(CertiEmploye regEmplSelected) {
		this.regEmplSelected = regEmplSelected;
	}

	public TbUser getEmplSelected() {
		return emplSelected;
	}

	public void setEmplSelected(TbUser emplSelected) {
		this.emplSelected = emplSelected;
	}
	
	public void AjouterEmpl(ActionEvent actionEvent) {
		String msg;
		String sid =emplSelected.getSuserId();
		int dep =emplSelected.getTbUserDept().getNdepartmentIdn();
		if (sid.equals("") || dep==0) {
			msg = "les champs SID et Departement sont oblégatoire??";
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_WARN, msg, null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		} else {
			this.emplSelected.setSemail(emplSelected.getSemail());
			this.emplSelected.setStelNumber(emplSelected.getStelNumber());
			this.emplSelected.setSuserId(emplSelected.getSuserId());
			this.emplSelected.setSuserName(emplSelected.getSuserName());
 
			 int i1 = (int) (nstartDate.getTime()/1000);
			this.emplSelected.setNstartDate(i1);	
			 int i2 = (int) (nendDate.getTime()/1000);
			this.emplSelected.setNendDate(i2);
			
			this.emplSelected.setTbUserDept(emplSelected.getTbUserDept());
			this.emplSelected.setNadminLevel(241);
			this.emplSelected.setNauthMode(1024);
			this.emplSelected.setNauthLimitCount(0);
			this.emplSelected.setNtimedApb(0);
			this.emplSelected.setCertiEmploye(null);
			try {
				metier2.AddEmploye(this.emplSelected);
				this.Init();
				msg = "L'ajout avec succée";
				FacesMessage facesMessage = new FacesMessage(
						FacesMessage.SEVERITY_INFO, msg, null);
				FacesContext.getCurrentInstance()
						.addMessage(null, facesMessage);
				this.setNendDate(null);
				this.setNstartDate(null);

			} catch (Exception e) {
				this.Init();
			
			}

		}

	}
	public void SuppEmpl(ActionEvent actionEvent) {

		String msg1;
		if(this.emplSelected.getSuserId()==null){
			msg1 = "SVP selectionner un emplyer";
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, msg1, null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			
		}else{
		if (metier2.SuppEmploye(this.emplSelected.getNuserIdn())) {
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
		}}

	}
	public void ModifierEmpl(ActionEvent actionEvent) {
        String msg2;
        
        try {
        	 int i1 = (int) (nstartDate.getTime()/1000);
 			this.emplSelected.setNstartDate(i1);	
 			 int i2 = (int) (nendDate.getTime()/1000);
 			 this.emplSelected.setNendDate(i2);
        	metier2.ModifierEmploye(this.emplSelected);
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

	public void ModifReg(ActionEvent actionEvent) {
        String msg2;
        
        try {
        	metier4.ModifRegEmpl(emplSelected.getCertiEmploye());
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
	public void AjoutReg(ActionEvent actionEvent) {
        String msg2;
        
        try {
        	
        	metier4.AddRegEmpl(this.certiEmploye1);
        	this.emplSelected.setCertiEmploye(certiEmploye1);
            this.metier2.ModifierEmploye(emplSelected);;
        	this.Init();
            msg2 = "L'ajout avec succée";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, msg2, null);
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			
		} catch (Exception e) {
			e.getStackTrace();
		}

	}
	
	public void reglage(ActionEvent actionEvent){
		//if(emplSelected.getCertiEmploye()==null){
			///AjoutReg(actionEvent);
		//}else{
		//	ModifReg(actionEvent);
		//}

          
	}
	public void PDF(ActionEvent actionEvent) throws JRException, IOException{
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/report/listeEmpl.jasper"));		
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
	public String convertTime(long time){
	    Date date = new Date(time*1000);
	    Format format = new SimpleDateFormat("MM-dd-yy");
	    return format.format(date);
	}
	
}
