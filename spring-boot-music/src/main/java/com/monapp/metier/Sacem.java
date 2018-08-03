package com.monapp.metier;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sacem")
public class Sacem {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String reference;
	@Column
	private Date date;
	
	@OneToOne()
	@JoinColumn(name="artiste_id")
	private Artiste artiste;
	
	public Sacem() {
	
	}
	
	
	
	public Sacem(String reference, Date date) {
		this.reference = reference;
		this.date = date;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "Sacem [id=" + id + ", reference=" + reference + ", date=" + date + ", artiste=" + artiste + "]";
	}

	
	
}
