package com.ceaft.dto;

import java.io.Serializable;

/**
 * 
 * @author Gary
 *
 */
public class HistoricoPieDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dia;
	private long valor;
	
	/**
	 * 
	 */
	public HistoricoPieDTO(){
		
	}
	
	/**
	 * 
	 * @param dia
	 * @param valor
	 */
	public HistoricoPieDTO(String dia, long valor){
		this.dia= dia;
		this.valor = valor;
	}

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
	public long getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(long valor) {
		this.valor = valor;
	}

}
