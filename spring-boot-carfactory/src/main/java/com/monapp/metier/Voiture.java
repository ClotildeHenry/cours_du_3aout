package com.monapp.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="car")
public class Voiture {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="model")
	private String model;
	@Column(name="noserie")
	private String noSerie;
	@Column(name="puissance")
	private int puissance;
	
	@ManyToOne
	@JoinColumn(name="voiture_id")
	private Factory factory;
	

	public Voiture() {
		super();
	}
	public Voiture(int id, String model, String noSerie, int puissance) {
		super();
		this.id = id;
		this.model = model;
		this.noSerie = noSerie;
		this.puissance = puissance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getNoSerie() {
		return noSerie;
	}
	public void setNoSerie(String noSerie) {
		this.noSerie = noSerie;
	}
	public int getPuissance() {
		return puissance;
	}
	public void setPuissance(int puissance) {
		this.puissance = puissance;
		
		
	}
	
	
	public Factory getFactory() {
		return factory;
	}
	public void setFactory(Factory factory) {
		this.factory = factory;
	}
	@Override
	public String toString() {
		return "Voiture [id=" + id + ", model=" + model + ", noSerie=" + noSerie + ", puissance=" + puissance + "]";
	}
	
	
	
	
	

}
