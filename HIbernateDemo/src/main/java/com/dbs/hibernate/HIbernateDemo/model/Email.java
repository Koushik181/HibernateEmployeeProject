package com.dbs.hibernate.HIbernateDemo.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String emailid;
	
	// bidirectional association
	@ManyToOne
	@JoinColumn(name="empid")
	private Employee employee;
	
	public Email() {
		// TODO Auto-generated constructor stub
	}

	public Email(int id, String emailid) {
		super();
		this.id = id;
		this.emailid = emailid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Override
	public String toString() {
		return "Email [id=" + id + ", emailid=" + emailid + "]";
	}
	
	
}
