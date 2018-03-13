package com.ceaft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="CAPACITACION")
public class Capacitacion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CAPACITACION")
	private long idCap;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Curso curso;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Alumno alumno;

	public long getIdCap() {
		return idCap;
	}

	public void setIdCap(long idCap) {
		this.idCap = idCap;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
}