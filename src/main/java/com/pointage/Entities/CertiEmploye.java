package com.pointage.Entities;

// Generated 26 juil. 2015 16:55:18 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CertiEmploye generated by hbm2java
 */
@Entity
@Table(name = "CERTI_EMPLOYE", catalog = "BioStar")
public class CertiEmploye implements java.io.Serializable {

	private int idEmploye;
	private String nomAr;
	private String typeEmployeAr;
	private String professionAr;
	private String professionMinehaAr;
	private String salaireJrneeAr;
	private String bourseAncienteAe;
	private String bourseAutresAe;
	private String salaireBaseNet;
	@Override
	public String toString() {
		return "CertiEmploye [idEmploye=" + idEmploye + "]";
	}

	private String cin;
	private String cnns;
	private String dnaissance;
	private String dateDebutTravail;
	private String tauxAnciente;
	private Set<TbUser> tbUsers = new HashSet<TbUser>(0);

	public CertiEmploye() {
	}

	public CertiEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}

	public CertiEmploye(int idEmploye, String nomAr, String typeEmployeAr,
			String professionAr, String professionMinehaAr,
			String salaireJrneeAr, String bourseAncienteAe,
			String bourseAutresAe, String salaireBaseNet,
			String cin, String cnns, String dnaissance,
			String dateDebutTravail, String tauxAnciente, Set<TbUser> tbUsers) {
		this.idEmploye = idEmploye;
		this.nomAr = nomAr;
		this.typeEmployeAr = typeEmployeAr;
		this.professionAr = professionAr;
		this.professionMinehaAr = professionMinehaAr;
		this.salaireJrneeAr = salaireJrneeAr;
		this.bourseAncienteAe = bourseAncienteAe;
		this.bourseAutresAe = bourseAutresAe;
		this.salaireBaseNet = salaireBaseNet;
		this.cin = cin;
		this.cnns = cnns;
		this.dnaissance = dnaissance;
		this.dateDebutTravail = dateDebutTravail;
		this.tauxAnciente = tauxAnciente;
		this.tbUsers = tbUsers;
	}

	@Id
	@Column(name = "id_employe", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdEmploye() {
		return this.idEmploye;
	}

	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}

	@Column(name = "nom_ar", length = 50)
	public String getNomAr() {
		return this.nomAr;
	}

	public void setNomAr(String nomAr) {
		this.nomAr = nomAr;
	}

	@Column(name = "type_employe_ar", length = 50)
	public String getTypeEmployeAr() {
		return this.typeEmployeAr;
	}

	public void setTypeEmployeAr(String typeEmployeAr) {
		this.typeEmployeAr = typeEmployeAr;
	}

	@Column(name = "profession_ar", length = 50)
	public String getProfessionAr() {
		return this.professionAr;
	}

	public void setProfessionAr(String professionAr) {
		this.professionAr = professionAr;
	}

	@Column(name = "profession_mineha_ar", length = 50)
	public String getProfessionMinehaAr() {
		return this.professionMinehaAr;
	}

	public void setProfessionMinehaAr(String professionMinehaAr) {
		this.professionMinehaAr = professionMinehaAr;
	}

	@Column(name = "salaire_jrnee_ar", length = 50)
	public String getSalaireJrneeAr() {
		return this.salaireJrneeAr;
	}

	public void setSalaireJrneeAr(String salaireJrneeAr) {
		this.salaireJrneeAr = salaireJrneeAr;
	}

	@Column(name = "bourse_anciente_ae", length = 50)
	public String getBourseAncienteAe() {
		return this.bourseAncienteAe;
	}

	public void setBourseAncienteAe(String bourseAncienteAe) {
		this.bourseAncienteAe = bourseAncienteAe;
	}

	@Column(name = "bourse_autres_ae", length = 50)
	public String getBourseAutresAe() {
		return this.bourseAutresAe;
	}

	public void setBourseAutresAe(String bourseAutresAe) {
		this.bourseAutresAe = bourseAutresAe;
	}

	@Column(name = "salaire_base_net", length = 50)
	public String getSalaireBaseNet() {
		return this.salaireBaseNet;
	}

	public void setSalaireBaseNet(String salaireBaseNet) {
		this.salaireBaseNet = salaireBaseNet;
	}

	@Column(name = "cin", length = 50)
	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	@Column(name = "cnns", length = 50)
	public String getCnns() {
		return this.cnns;
	}

	public void setCnns(String cnns) {
		this.cnns = cnns;
	}

	@Column(name = "dnaissance", length = 50)
	public String getDnaissance() {
		return this.dnaissance;
	}

	public void setDnaissance(String dnaissance) {
		this.dnaissance = dnaissance;
	}

	@Column(name = "date_debut_travail", length = 10)
	public String getDateDebutTravail() {
		return this.dateDebutTravail;
	}

	public void setDateDebutTravail(String dateDebutTravail) {
		this.dateDebutTravail = dateDebutTravail;
	}

	@Column(name = "taux_anciente", length = 10)
	public String getTauxAnciente() {
		return this.tauxAnciente;
	}

	public void setTauxAnciente(String tauxAnciente) {
		this.tauxAnciente = tauxAnciente;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "certiEmploye")
	public Set<TbUser> getTbUsers() {
		return this.tbUsers;
	}

	public void setTbUsers(Set<TbUser> tbUsers) {
		this.tbUsers = tbUsers;
	}

}
