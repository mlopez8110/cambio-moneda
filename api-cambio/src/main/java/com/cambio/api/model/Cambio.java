package com.cambio.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cambio")

public class Cambio {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String monedaorigen;
	private String monedafinal;
	private double tipocambio;
	
	public Cambio(){}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMonedaorigen() {
		return monedaorigen;
	}
	public void setMonedaorigen(String monedaorigen) {
		this.monedaorigen = monedaorigen;
	}
	public String getMonedafinal() {
		return monedafinal;
	}
	public void setMonedafinal(String monedafinal) {
		this.monedafinal = monedafinal;
	}
	public double getTipocambio() {
		return tipocambio;
	}
	public void setTipocambio(double tipocambio) {
		this.tipocambio = tipocambio;
	}
	

	


	
}
