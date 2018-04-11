package com.ceaft.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Curso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDCURSO")
	private long id;
	
	@Column(name="DURACION")
	private long duracion;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="DIAS_DE_CLASE")
	private String diasClase;
	
	@Column(name="CLASES_X_SEMANA")
	private long clasesXSem;
	
	@Column(name="COSTO_QUINCENAL")
	private Double costoQuin;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "curso", cascade = CascadeType.ALL)
	private Capacitacion capacitacion;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Grupo grupo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDuracion() {
		return duracion;
	}

	public void setDuracion(long duracion) {
		this.duracion = duracion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDiasClase() {
		return diasClase;
	}

	public void setDiasClase(String diasClase) {
		this.diasClase = diasClase;
	}

	public long getClasesXSem() {
		return clasesXSem;
	}

	public void setClasesXSem(long clasesXSem) {
		this.clasesXSem = clasesXSem;
	}

	public Double getCostoQuin() {
		return costoQuin;
	}

	public void setCostoQuin(Double costoQuin) {
		this.costoQuin = costoQuin;
	}

	public Capacitacion getCapacitacion() {
		return capacitacion;
	}

	public void setCapacitacion(Capacitacion capacitacion) {
		this.capacitacion = capacitacion;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
}