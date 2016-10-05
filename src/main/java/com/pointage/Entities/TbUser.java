package com.pointage.Entities;

// Generated 26 juil. 2015 16:55:18 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TbUser generated by hbm2java
 */
@Entity
@Table(name = "TB_USER", catalog = "BioStar")
public class TbUser implements java.io.Serializable {

	private int nuserIdn; 
	private CertiEmploye certiEmploye;
	private CertiPtgregularise certiPtgregularise;
	private TbUserDept tbUserDept;
	private String suserName;
	private String stelNumber;
	private String semail;
	private String suserId;
	private int nstartDate;
	private int nendDate;
	private int nadminLevel;
	private int nauthMode;
	private int nauthLimitCount;
	private int ntimedApb;
	private int nencryption;
	private Set<TbTaResult> tbTaResults = new HashSet<TbTaResult>(0);
	private Set<TbEventLog> tbEventLogs = new HashSet<TbEventLog>(0);

	public TbUser() {
	}

	public TbUser(int nuserIdn, TbUserDept tbUserDept, String suserName,
			String stelNumber, String semail, String suserId, int nstartDate, int nendDate, int nadminLevel,
			int nauthMode, int nauthLimitCount, int ntimedApb, int nencryption) {
		this.nuserIdn = nuserIdn;
		this.tbUserDept = tbUserDept;
		this.suserName = suserName;
		this.stelNumber = stelNumber;
		this.semail = semail;
		this.suserId = suserId;
		this.nstartDate = nstartDate;
		this.nendDate = nendDate;
		this.nadminLevel = nadminLevel;
		this.nauthMode = nauthMode;
		this.nauthLimitCount = nauthLimitCount;
		this.ntimedApb = ntimedApb;
		this.nencryption = nencryption;
	}

	public TbUser(int nuserIdn, CertiEmploye certiEmploye,
			CertiPtgregularise certiPtgregularise, TbUserDept tbUserDept,
			String suserName, String stelNumber, String semail, String suserId, int nstartDate, int nendDate,
			int nadminLevel, int nauthMode, int nauthLimitCount, int ntimedApb,
			int nencryption, Set<TbTaResult> tbTaResults,
			Set<TbEventLog> tbEventLogs) {
		this.nuserIdn = nuserIdn;
		this.certiEmploye = certiEmploye;
		this.certiPtgregularise = certiPtgregularise;
		this.tbUserDept = tbUserDept;
		this.suserName = suserName;
		this.stelNumber = stelNumber;
		this.semail = semail;
		this.suserId = suserId;
		this.nstartDate = nstartDate;
		this.nendDate = nendDate;
		this.nadminLevel = nadminLevel;
		this.nauthMode = nauthMode;
		this.nauthLimitCount = nauthLimitCount;
		this.ntimedApb = ntimedApb;
		this.nencryption = nencryption;
		this.tbTaResults = tbTaResults;
		this.tbEventLogs = tbEventLogs;
	}

	@Id
	@Column(name = "nUserIdn", unique = true, nullable = false)
	public int getNuserIdn() {
		return this.nuserIdn;
	}

	public void setNuserIdn(int nuserIdn) {
		this.nuserIdn = nuserIdn;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idEmploye")
	public CertiEmploye getCertiEmploye() {
		return this.certiEmploye;
	}

	public void setCertiEmploye(CertiEmploye certiEmploye) {
		this.certiEmploye = certiEmploye;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ptgregularise")
	public CertiPtgregularise getCertiPtgregularise() {
		return this.certiPtgregularise;
	}

	public void setCertiPtgregularise(CertiPtgregularise certiPtgregularise) {
		this.certiPtgregularise = certiPtgregularise;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nDepartmentIdn", nullable = false)
	public TbUserDept getTbUserDept() {
		return this.tbUserDept;
	}

	public void setTbUserDept(TbUserDept tbUserDept) {
		this.tbUserDept = tbUserDept;
	}

	@Column(name = "sUserName", nullable = false, length = 96)
	public String getSuserName() {
		return this.suserName;
	}

	public void setSuserName(String suserName) {
		this.suserName = suserName;
	}

	@Column(name = "sTelNumber", nullable = false, length = 64)
	public String getStelNumber() {
		return this.stelNumber;
	}

	public void setStelNumber(String stelNumber) {
		this.stelNumber = stelNumber;
	}

	@Column(name = "sEmail", nullable = false, length = 100)
	public String getSemail() {
		return this.semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	@Column(name = "sUserID", nullable = false, length = 64)
	public String getSuserId() {
		return this.suserId;
	}

	public void setSuserId(String suserId) {
		this.suserId = suserId;
	}


	@Column(name = "nStartDate", nullable = false)
	public int getNstartDate() {
		return this.nstartDate;
	}

	public void setNstartDate(int nstartDate) {
		this.nstartDate = nstartDate;
	}

	@Column(name = "nEndDate", nullable = false)
	public int getNendDate() {
		return this.nendDate;
	}

	public void setNendDate(int nendDate) {
		this.nendDate = nendDate;
	}

	@Column(name = "nAdminLevel", nullable = false)
	public int getNadminLevel() {
		return this.nadminLevel;
	}

	public void setNadminLevel(int nadminLevel) {
		this.nadminLevel = nadminLevel;
	}

	@Column(name = "nAuthMode", nullable = false)
	public int getNauthMode() {
		return this.nauthMode;
	}

	public void setNauthMode(int nauthMode) {
		this.nauthMode = nauthMode;
	}

	@Column(name = "nAuthLimitCount", nullable = false)
	public int getNauthLimitCount() {
		return this.nauthLimitCount;
	}

	public void setNauthLimitCount(int nauthLimitCount) {
		this.nauthLimitCount = nauthLimitCount;
	}

	@Column(name = "nTimedAPB", nullable = false)
	public int getNtimedApb() {
		return this.ntimedApb;
	}

	public void setNtimedApb(int ntimedApb) {
		this.ntimedApb = ntimedApb;
	}

	@Column(name = "nEncryption", nullable = false)
	public int getNencryption() {
		return this.nencryption;
	}

	public void setNencryption(int nencryption) {
		this.nencryption = nencryption;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbUser")
	public Set<TbTaResult> getTbTaResults() {
		return this.tbTaResults;
	}

	public void setTbTaResults(Set<TbTaResult> tbTaResults) {
		this.tbTaResults = tbTaResults;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbUser")
	public Set<TbEventLog> getTbEventLogs() {
		return this.tbEventLogs;
	}

	public void setTbEventLogs(Set<TbEventLog> tbEventLogs) {
		this.tbEventLogs = tbEventLogs;
	}

}