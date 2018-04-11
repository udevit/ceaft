package com.ceaft.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Alumno implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDALUMNO")
	private long idAlum;
	
	@Column(name="NOMBRE")
	private String nom;
	
	@Column(name="EDAD")
	private long edad;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "alumno", cascade = CascadeType.ALL)
	private Capacitacion capacitacion;
	
	@Column(name="MATRICULA")
	private String matric;

	public long getIdAlum() {
		return idAlum;
	}

	public void setIdAlum(long idAlum) {
		this.idAlum = idAlum;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public long getEdad() {
		return edad;
	}

	public void setEdad(long edad) {
		this.edad = edad;
	}

	public Capacitacion getCapacitacion() {
		return capacitacion;
	}

	public void setCapacitacion(Capacitacion capacitacion) {
		this.capacitacion = capacitacion;
	}

	public String getMatric() {
		return matric;
	}

	public void setMatric(String matric) {
		this.matric = matric;
	}
		
}
