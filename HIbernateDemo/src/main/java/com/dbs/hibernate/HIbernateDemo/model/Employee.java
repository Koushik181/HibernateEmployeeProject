package com.dbs.hibernate.HIbernateDemo.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String ename;
	private String city;
	// collection is of type primitives or string
	
	@ElementCollection
	private Set<String> certificates;
	
	@ElementCollection
	@JoinTable(name="phonelist",
	joinColumns = @JoinColumn(referencedColumnName = "eid", name = "empid"))
	@Column(name="number")
	private List<String> phonenumbers;
	// unidirectional approach
	// the ownership
	@OneToMany(mappedBy = "employee")
	private List<Email> emailids;
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<String> getCertificates() {
		return certificates;
	}

	public void setCertificates(Set<String> certificates) {
		this.certificates = certificates;
	}

	public List<String> getPhonenumbers() {
		return phonenumbers;
	}

	public void setPhonenumbers(List<String> phonenumbers) {
		this.phonenumbers = phonenumbers;
	}

	public List<Email> getEmailids() {
		return emailids;
	}

	public void setEmailids(List<Email> emailids) {
		this.emailids = emailids;
	}
	
	

}
