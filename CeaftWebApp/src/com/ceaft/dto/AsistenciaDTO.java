package com.ceaft.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Gary
 *
 */
public class AsistenciaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date horaLlegada;
	private String estado;
	
	/**
	 * 
	 */
	public AsistenciaDTO(){
		
	}

	public AsistenciaDTO(Date horaLlegada, String estado){
		this.horaLlegada = horaLlegada;
		this.estado = estado;
	}

	/**
	 * @return the horaLlegada
	 */
	public Date getHoraLlegada() {
		return horaLlegada;
	}

	/**
	 * @param horaLlegada the horaLlegada to set
	 */
	public void setHoraLlegada(Date horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
