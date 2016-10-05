package com.pointage.Beans;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;

import org.springframework.beans.factory.annotation.Autowired;

import com.pointage.Entities.TbUserDept;
import com.pointage.Metier.DepartementMetier;


@ManagedBean(name="deptBeans")
@RequestScoped
public class DeptBeans  {
	
	@Autowired
	private DepartementMetier metier3;
	private List<SelectItem> selectItemOnItemsDep;
	private TbUserDept dept=new TbUserDept();
	private List<TbUserDept> listDept;
	private TbUserDept deptSelected;

	
	@PostConstruct
	public void Init() {
		this.dept=new TbUserDept();
	 this.listDept=new ArrayList<TbUserDept>();
	 this.deptSelected=new TbUserDept();

	}
	public void setMetier3(DepartementMetier metier3) {
		this.metier3 = metier3;
	}

	public List<SelectItem> getSelectItemOnItemsDep() {
		this.selectItemOnItemsDep=new ArrayList<SelectItem>();
		List<TbUserDept> lisDepts= metier3.AllDeparetement();
		for (TbUserDept tbUserDept : lisDepts) {
			SelectItem selectItem=new SelectItem(tbUserDept.getNdepartmentIdn(),tbUserDept.getSname());
			this.selectItemOnItemsDep.add(selectItem);
			
		}
		return selectItemOnItemsDep;
	}
	public List<TbUserDept> getListDept() {
		listDept=metier3.AllDeparetement();
		return listDept; 
	}
	public TbUserDept getDeptSelected() {
		return deptSelected;
	}
	public void setDeptSelected(TbUserDept deptSelected) {
		this.deptSelected = deptSelected;
	}
	public void PDF(ActionEvent actionEvent) throws JRException, IOException{
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/report/listDept.jasper"));		
		byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRBeanCollectionDataSource(this.getListDept()));
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream outStream = response.getOutputStream();
		outStream.write(bytes, 0 , bytes.length);
		outStream.flush();
		outStream.close();
			
		FacesContext.getCurrentInstance().responseComplete();
	}
	public void AjouterDept(ActionEvent actionEvent) {
		String msg;
		String nom =deptSelected.getSname();
		if (nom.equals("")) {
			msg = "les champs vide sont oblégatoire??";
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_WARN, msg, null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		} else {

			this.deptSelected.setSname(this.deptSelected.getSname());
			this.deptSelected.setSdepartment(this.deptSelected.getSname());
			try {
				metier3.AddDept(this.deptSelected);
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
	 public void ModifierDept(ActionEvent actionEvent) {
	        String msg2;
	        
	        try {
	        	metier3.ModifierDept(this.deptSelected);;
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
	 
	
	public void SuppDept(ActionEvent actionEvent) {

		String msg1;
		if (metier3.SuppDept(this.deptSelected.getNdepartmentIdn())) {
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
	
	
	public void XLSX(ActionEvent actionEvent) throws JRException, IOException{
		Map<String,Object> parametros= new HashMap<String,Object>();
		parametros.put("txtUsuario", "MitoCode");
		
		File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/report/listDept.jasper"));
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(),parametros, new JRBeanCollectionDataSource(this.listDept));
		
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-disposition","attachment; filename=jsfReporte.xls");
		ServletOutputStream stream = response.getOutputStream();
		
		JRXlsExporter exporter = new JRXlsExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
		exporter.exportReport();
		
		stream.flush();
		stream.close();
		FacesContext.getCurrentInstance().responseComplete();
	}
	
	public void PPT(ActionEvent actionEvent) throws JRException, IOException{
		Map<String,Object> parametros= new HashMap<String,Object>();
		parametros.put("txtUsuario", "MitoCode");
		
		File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/report/listDept.jasper"));
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(),parametros, new JRBeanCollectionDataSource(this.listDept));
		
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-disposition","attachment; filename=jsfReporte.ppt");
		ServletOutputStream stream = response.getOutputStream();
		
		JRPptxExporter exporter = new JRPptxExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
		exporter.exportReport();
		
		stream.flush();
		stream.close();
		FacesContext.getCurrentInstance().responseComplete();
	}
	
	public void DOC(ActionEvent actionEvent) throws JRException, IOException{
		Map<String,Object> parametros= new HashMap<String,Object>();
		parametros.put("txtUsuario", "MitoCode");
		
		File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/report/listDept.jasper"));
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(),parametros, new JRBeanCollectionDataSource(this.getListDept()));
		
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-disposition","attachment; filename=jsfReporte.doc");
		ServletOutputStream stream = response.getOutputStream();
		
		JRDocxExporter exporter = new JRDocxExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
		exporter.exportReport();
		
		stream.flush();
		stream.close();
		FacesContext.getCurrentInstance().responseComplete();
	}
	

}
