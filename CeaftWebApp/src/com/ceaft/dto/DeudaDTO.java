package com.ceaft.dto;

import java.io.Serializable;

public class DeudaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double total;
	private double montoRecuperado;
	private double montoExtra;
	private double folio;
	
	/**
	 * 
	 */
	public DeudaDTO(){
		
	}
	
	/**
	 * 
	 * @param folio
	 * @param total
	 * @param montoRecuperado
	 * @param montoExtra
	 */
	public DeudaDTO(double folio, double total, double montoRecuperado, 
		double montoExtra){
		this.folio = folio;
		this.total = total;
		this.montoRecuperado = montoRecuperado;
		this.montoExtra = montoExtra;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}
	
	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}
	
	/**
	 * @return the montoRecuperado
	 */
	public double getMontoRecuperado() {
		return montoRecuperado;
	}
	
	/**
	 * @param montoRecuperado the montoRecuperado to set
	 */
	public void setMontoRecuperado(double montoRecuperado) {
		this.montoRecuperado = montoRecuperado;
	}
	
	/**
	 * @return the montoExtra
	 */
	public double getMontoExtra() {
		return montoExtra;
	}
	
	/**
	 * @param montoExtra the montoExtra to set
	 */
	public void setMontoExtra(double montoExtra) {
		this.montoExtra = montoExtra;
	}
	
	/**
	 * @return the folio
	 */
	public double getFolio() {
		return folio;
	}
	
	/**
	 * @param folio the folio to set
	 */
	public void setFolio(double folio) {
		this.folio = folio;
	}
	
}
