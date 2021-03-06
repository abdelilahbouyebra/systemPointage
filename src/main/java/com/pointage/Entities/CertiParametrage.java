package com.pointage.Entities;

// Generated 26 juil. 2015 16:55:18 by Hibernate Tools 4.3.1

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * CertiParametrage generated by hbm2java
 */
@Entity
@Table(name = "CERTI_PARAMETRAGE", catalog = "BioStar")
public class CertiParametrage implements java.io.Serializable {

	private int idParametrage;
	private String identifiantSte;
	private String adresse;
	private String cnss;
	private String ifff;
	private String patente;
	private String numAssurance;
	private String steAssurance;
	private String nomDay3a;
	private String cnssEmp;
	private String tsa;
	@Lob
    private byte[] logo;

	public CertiParametrage() {
	}

	public CertiParametrage(int idParametrage) {
		this.idParametrage = idParametrage;
	}

	

	public CertiParametrage(int idParametrage, String identifiantSte,
			String adresse, String cnss, String ifff, String patente,
			String numAssurance, String steAssurance, String nomDay3a,
			String cnssEmp, String tsa, byte[] logo) {
		super();
		this.idParametrage = idParametrage;
		this.identifiantSte = identifiantSte;
		this.adresse = adresse;
		this.cnss = cnss;
		this.ifff = ifff;
		this.patente = patente;
		this.numAssurance = numAssurance;
		this.steAssurance = steAssurance;
		this.nomDay3a = nomDay3a;
		this.cnssEmp = cnssEmp;
		this.tsa = tsa;
		this.logo = logo;
	}

	@Id
	@Column(name = "id_parametrage", unique = true, nullable = false)
	public int getIdParametrage() {
		return this.idParametrage;
	}

	public void setIdParametrage(int idParametrage) {
		this.idParametrage = idParametrage;
	}

	@Column(name = "identifiant_ste", length = 100)
	public String getIdentifiantSte() {
		return this.identifiantSte;
	}

	public void setIdentifiantSte(String identifiantSte) {
		this.identifiantSte = identifiantSte;
	}

	@Column(name = "adresse", length = 150)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "cnss", length = 100)
	public String getCnss() {
		return this.cnss;
	}

	public void setCnss(String cnss) {
		this.cnss = cnss;
	}

	@Column(name = "ifff", length = 100)
	public String getIfff() {
		return this.ifff;
	}

	public void setIfff(String ifff) {
		this.ifff = ifff;
	}

	@Column(name = "patente", length = 100)
	public String getPatente() {
		return this.patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	@Column(name = "num_assurance", length = 100)
	public String getNumAssurance() {
		return this.numAssurance;
	}

	public void setNumAssurance(String numAssurance) {
		this.numAssurance = numAssurance;
	}

	@Column(name = "ste_assurance", length = 100)
	public String getSteAssurance() {
		return this.steAssurance;
	}

	public void setSteAssurance(String steAssurance) {
		this.steAssurance = steAssurance;
	}

	@Column(name = "nom_day3a", length = 100)
	public String getNomDay3a() {
		return this.nomDay3a;
	}

	public void setNomDay3a(String nomDay3a) {
		this.nomDay3a = nomDay3a;
	}

	@Column(name = "cnss_emp", length = 100)
	public String getCnssEmp() {
		return this.cnssEmp;
	}

	public void setCnssEmp(String cnssEmp) {
		this.cnssEmp = cnssEmp;
	}

	@Column(name = "tsa", length = 100)
	public String getTsa() {
		return this.tsa;
	}

	public void setTsa(String tsa) {
		this.tsa = tsa;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	
	

}
