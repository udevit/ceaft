package com.ceaft.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CURSO")
public class Curso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_CURSO")
	private long id;
	
	@Column(name="DURACION")
	private long duracion;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "curso", cascade = CascadeType.ALL)
	private Capacitacion capacitacion;
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the duracion
	 */
	public long getDuracion() {
		return duracion;
	}
	
	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(long duracion) {
		this.duracion = duracion;
	}
	
	/**
	 * @return the capacitacion
	 */
	public Capacitacion getCapacitacion() {
		return capacitacion;
	}
	
	/**
	 * @param capacitacion the capacitacion to set
	 */
	public void setCapacitacion(Capacitacion capacitacion) {
		this.capacitacion = capacitacion;
	}

}
