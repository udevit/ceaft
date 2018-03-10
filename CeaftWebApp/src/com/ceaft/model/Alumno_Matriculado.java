package com.ceaft.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Alumno_Matriculado implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@NotNull
	@Column(name="ID_ALUMNO")
	private long idAlum;
	
	@Column(name="MATRICULA")
	private String matric;
	
	@Column(name="GRUPO")
	private long grupo;

	public long getIdAlum() {
		return idAlum;
	}

	public void setIdAlum(long idAlum) {
		this.idAlum = idAlum;
	}

	public String getMatric() {
		return matric;
	}

	public void setMatric(String matric) {
		this.matric = matric;
	}

	public long getGrupo() {
		return grupo;
	}

	public void setGrupo(long grupo) {
		this.grupo = grupo;
	}
	
}
