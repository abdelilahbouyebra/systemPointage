package com.pointage.Entities;

// Generated 26 juil. 2015 16:55:18 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TbUserDept generated by hbm2java
 */
@Entity
@Table(name = "TB_USER_DEPT", catalog = "BioStar")
public class TbUserDept implements java.io.Serializable {

	private int ndepartmentIdn;
	private String sname;
	private String sdepartment;
	private short ndepth;
	private int nparentIdn;
	private Set<TbUser> tbUsers = new HashSet<TbUser>(0);

	public TbUserDept() {
	}

	public TbUserDept(int ndepartmentIdn, String sname, String sdepartment,
			short ndepth, int nparentIdn) {
		this.ndepartmentIdn = ndepartmentIdn;
		this.sname = sname;
		this.sdepartment = sdepartment;
		this.ndepth = ndepth;
		this.nparentIdn = nparentIdn;
	}

	public TbUserDept(int ndepartmentIdn, String sname, String sdepartment,
			short ndepth, int nparentIdn, Set<TbUser> tbUsers) {
		this.ndepartmentIdn = ndepartmentIdn;
		this.sname = sname;
		this.sdepartment = sdepartment;
		this.ndepth = ndepth;
		this.nparentIdn = nparentIdn;
		this.tbUsers = tbUsers;
	}

	@Id
	@Column(name = "nDepartmentIdn", unique = true, nullable = false)
	public int getNdepartmentIdn() {
		return this.ndepartmentIdn;
	}

	public void setNdepartmentIdn(int ndepartmentIdn) {
		this.ndepartmentIdn = ndepartmentIdn;
	}

	@Column(name = "sName", nullable = false, length = 64)
	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Column(name = "sDepartment", nullable = false)
	public String getSdepartment() {
		return this.sdepartment;
	}

	public void setSdepartment(String sdepartment) {
		this.sdepartment = sdepartment;
	}

	@Column(name = "nDepth", nullable = false)
	public short getNdepth() {
		return this.ndepth;
	}

	public void setNdepth(short ndepth) {
		this.ndepth = ndepth;
	}

	@Column(name = "nParentIdn", nullable = false)
	public int getNparentIdn() {
		return this.nparentIdn;
	}

	public void setNparentIdn(int nparentIdn) {
		this.nparentIdn = nparentIdn;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbUserDept")
	public Set<TbUser> getTbUsers() {
		return this.tbUsers;
	}

	public void setTbUsers(Set<TbUser> tbUsers) {
		this.tbUsers = tbUsers;
	}

}