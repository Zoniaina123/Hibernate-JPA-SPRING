package com.formation.tutorial.hibernate.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY")
public class Company {
	private int companyId;
	private String companyName;
	private List<Employee> employee;

	@Id
	//@GeneratedValue
	@Column(name = "COMPANY_ID")
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Column(name = "COMPANY_NAME")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
	

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", employee=" + employee + "]";
	}
	
	
}
