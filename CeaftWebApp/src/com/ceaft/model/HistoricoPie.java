package com.ceaft.model;

import java.io.Serializable;

/**
 * 
 * @author Gary
 *
 */
public class HistoricoPie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String dia;
	private double valor;
	
	/**
	 * @return the dia
	 */
	public String getDia() {
		return dia;
	}
	
	/**
	 * @param dia the dia to set
	 */
	public void setDia(String dia) {
		this.dia = dia;
	}
	
	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}
	
	/**
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
